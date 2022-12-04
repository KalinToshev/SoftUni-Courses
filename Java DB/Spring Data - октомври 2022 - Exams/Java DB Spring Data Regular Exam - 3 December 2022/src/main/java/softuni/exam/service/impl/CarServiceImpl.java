package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarWrapperDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private static final String CAR_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarRepository carRepository;

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CAR_FILE_PATH));
    }

    @Override
    public String importCars() throws JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(CAR_FILE_PATH, CarWrapperDTO.class)
                .getCars()
                .stream()
                .filter(carImportDTO -> {
                    boolean isValid = validationUtil.isValid(carImportDTO);

                    Optional<Car> byPlateNumber = carRepository.findByPlateNumber(carImportDTO.getPlateNumber());

                    if (byPlateNumber.isPresent()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported car %s - %s", carImportDTO.getCarMake(), carImportDTO.getCarModel()) : "Invalid car").append(System.lineSeparator());

                    return isValid;
                })
                .map(carImportDTO -> modelMapper.map(carImportDTO, Car.class))
                .forEach(carRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
