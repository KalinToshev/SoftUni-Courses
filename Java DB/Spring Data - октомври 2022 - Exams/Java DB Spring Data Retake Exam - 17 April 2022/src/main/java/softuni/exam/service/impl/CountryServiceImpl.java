package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), CountryImportDTO[].class))
                .filter(countryImportDTO -> {
                    boolean isValid = validationUtil.isValid(countryImportDTO);

                    Optional<Country> byCountryName = countryRepository.findByCountryName(countryImportDTO.getCountryName());

                    if (byCountryName.isPresent()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported country %s - %s", countryImportDTO.getCountryName(), countryImportDTO.getCurrency()) : "Invalid country").append(System.lineSeparator());

                    return isValid;
                })
                .map(countryImportDTO -> modelMapper.map(countryImportDTO, Country.class))
                .forEach(countryRepository::saveAndFlush);


        return stringBuilder.toString();
    }
}
