package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentsWrapperDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final TownRepository townRepository;

    private final ValidationUtil validationUtil;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ModelMapper modelMapper, TownRepository townRepository, ValidationUtil validationUtil) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(APARTMENTS_FILE_PATH, ApartmentsWrapperDTO.class)
                .getApartments()
                .stream()
                .filter(apartmentImportDTO -> {
                    boolean isValid = validationUtil.isValid(apartmentImportDTO);

                    boolean doesntExist = apartmentRepository.findApartmentByTownAndArea(townRepository.findByTownName(apartmentImportDTO.getTown()).get(), apartmentImportDTO.getArea()).isEmpty();

                    if (!doesntExist) {
                        isValid = false;
                    }

                    stringBuilder.append(isValid ? String.format("Successfully imported apartment %s - %.2f", apartmentImportDTO.getApartmentType(),apartmentImportDTO.getArea()) : "Invalid apartment").append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentImportDTO -> {
                    Apartment apartment = modelMapper.map(apartmentImportDTO, Apartment.class);
                    apartment.setTown(townRepository.findByTownName(apartmentImportDTO.getTown()).get());
                    return apartment;
                })
                .forEach(apartmentRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
