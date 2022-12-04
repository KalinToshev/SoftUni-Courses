package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicImportDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class MechanicServiceImpl implements MechanicService {
    private static final String MECHANIC_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicRepository mechanicRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.mechanicRepository = mechanicRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANIC_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicImportDTO[].class))
                .filter(mechanicImportDTO -> {
                    boolean isValid = validationUtil.isValid(mechanicImportDTO);

                    Optional<Mechanic> byFirstName = mechanicRepository.findByFirstName(mechanicImportDTO.getFirstName());
                    Optional<Mechanic> byEmail = mechanicRepository.findByEmail(mechanicImportDTO.getEmail());
                    Optional<Mechanic> byPhone = mechanicRepository.findByPhone(mechanicImportDTO.getPhone());

                    if (byFirstName.isPresent() || byEmail.isPresent() || byPhone.isPresent()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported mechanic %s %s", mechanicImportDTO.getFirstName(), mechanicImportDTO.getLastName()) : "Invalid mechanic").append(System.lineSeparator());

                    return isValid;
                })
                .map(mechanicImportDTO -> modelMapper.map(mechanicImportDTO, Mechanic.class))
                .forEach(mechanicRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
