package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    private final CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder stringBuilder =  new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDTO[].class))
                .filter(cityImportDTO -> {
                    boolean isValid = validationUtil.isValid(cityImportDTO);

                    Optional<City> byCityName = cityRepository.findByCityName(cityImportDTO.getCityName());

                    if (byCityName.isPresent()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported city %s - %d", cityImportDTO.getCityName(), cityImportDTO.getPopulation()) : "Invalid city").append(System.lineSeparator());

                    return isValid;
                })
                .map(cityImportDTO -> {
                    City city = modelMapper.map(cityImportDTO, City.class);
                    Country country = countryRepository.findById(cityImportDTO.getCountry()).get();
                    city.setCountry(country);
                    return city;
                })
                .forEach(cityRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
