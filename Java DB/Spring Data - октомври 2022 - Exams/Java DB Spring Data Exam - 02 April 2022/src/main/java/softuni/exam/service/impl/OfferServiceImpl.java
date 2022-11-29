package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OffersWrapperDTO;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;

    private final XmlParser xmlParser;

    private final ValidationUtil validationUtil;

    private final AgentRepository agentRepository;

    private final ModelMapper modelMapper;

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationUtil validationUtil, AgentRepository agentRepository, ModelMapper modelMapper, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(OFFERS_FILE_PATH, OffersWrapperDTO.class)
                .getOffers()
                .stream()
                .filter(offerImportDTO -> {
                    boolean isValid = validationUtil.isValid(offerImportDTO);

                    if(agentRepository.findByFirstName(offerImportDTO.getName().getName()).isEmpty()) {
                        isValid = false;
                    }

                    stringBuilder.append(isValid
                                    ? String.format("Successfully import offer %.2f", offerImportDTO.getPrice())
                                    : "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(offerImportDTO -> {
                    Offer offer = modelMapper.map(offerImportDTO, Offer.class);
                    offer.setAgent(agentRepository.findByFirstName(offerImportDTO.getName().getName()).get());
                    offer.setApartment(apartmentRepository.findById(offerImportDTO.getApartment().getId()).get());
                    offer.setPublishedOn(LocalDate.parse(offerImportDTO.getPublishedOn(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                    return offer;
                })
                .forEach(offerRepository::saveAndFlush);

        return stringBuilder.toString();
    }

    @Override
    public String exportOffers() throws JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<Offer> offers  = offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms);

        offers.forEach(offer -> {
            stringBuilder.append(String.format("Agent %s %s with offer №%d:%n" +
                    "   -Apartment area: %.2f%n" +
                    "   --Town: %s%n" +
                    "   ---Price: %.2f$",
                    offer.getAgent().getFirstName(),
                    offer.getAgent().getLastName(),
                    offer.getId(),
                    offer.getApartment().getArea(),
                    offer.getApartment().getTown().getTownName(),
                    offer.getPrice()))
                    .append(System.lineSeparator());
        });

        return stringBuilder.toString();
    }
}
