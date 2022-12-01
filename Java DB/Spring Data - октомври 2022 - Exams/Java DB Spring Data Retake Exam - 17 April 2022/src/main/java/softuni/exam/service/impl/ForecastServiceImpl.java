package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastWrapperDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;

    private final CityRepository cityRepository;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CityRepository cityRepository) {
        this.forecastRepository = forecastRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(FORECAST_FILE_PATH, ForecastWrapperDTO.class)
                .getForecasts().stream()
                .filter(forecastImportDTO -> {
                    boolean isValid = validationUtil.isValid(forecastImportDTO);

                    Optional<City> city = cityRepository.findById(forecastImportDTO.getCity());

                    if (city.isEmpty()) isValid = false;

                    City originalCity = city.get();

                    Forecast forecast = forecastRepository.findAllByCityAndDayOfWeek(originalCity, forecastImportDTO.getDayOfWeek()).orElse(null);

                    if (forecast != null) {
                        isValid = false;
                    }

                    stringBuilder.append(isValid ? String.format("Successfully import forecast %s - %.2f", forecastImportDTO.getDayOfWeek().toString(), forecastImportDTO.getMaxTemperature()) : "Invalid forecast").append(System.lineSeparator());

                    return isValid;
                })
                .map(forecastImportDTO -> {
                    Forecast forecast = modelMapper.map(forecastImportDTO, Forecast.class);
                    City city = cityRepository.findById(forecastImportDTO.getCity()).get();
                    forecast.setCity(city);
                    forecast.setSunrise(LocalTime.parse(forecastImportDTO.getSunrise(), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    forecast.setSunset(LocalTime.parse(forecastImportDTO.getSunset(), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    return forecast;
                })
                .forEach(forecastRepository::saveAndFlush);

        return stringBuilder.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder stringBuilder = new StringBuilder();

        Set<Forecast> forecastSet = forecastRepository.findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        forecastSet.forEach(forecast -> {
            stringBuilder.append(String.format("City: %s%n" +
                    "-min temperature: %.2f%n" +
                    "--max temperature: %.2f%n" +
                    "---sunrise: %s%n" +
                    "-----sunset: %s",
                    forecast.getCity().getCityName(),
                    forecast.getMinTemperature(),
                    forecast.getMaxTemperature(),
                    forecast.getSunrise(),
                    forecast.getSunset()))
                    .append(System.lineSeparator());
        });

        return stringBuilder.toString();
    }
}
