package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {
    private static final String PART_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartRepository partRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partRepository = partRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PART_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readPartsFileContent(), PartImportDTO[].class))
                .filter(partImportDTO -> {
                    boolean isValid = validationUtil.isValid(partImportDTO);

                    Optional<Part> byPartName = partRepository.findByPartName(partImportDTO.getPartName());

                    if (byPartName.isPresent()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported part %s - %.2f", partImportDTO.getPartName(), partImportDTO.getPrice()) : "Invalid part").append(System.lineSeparator());

                    return isValid;
                })
                .map(partImportDTO -> modelMapper.map(partImportDTO, Part.class))
                .forEach(partRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
