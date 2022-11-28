package bg.softuni.hiberspring.service.impl;

import bg.softuni.hiberspring.domain.dtos.TownImportDTO;
import bg.softuni.hiberspring.domain.entities.Town;
import bg.softuni.hiberspring.repository.TownRepository;
import bg.softuni.hiberspring.service.TownService;
import bg.softuni.hiberspring.util.FileUtil;
import bg.softuni.hiberspring.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;
import static bg.softuni.hiberspring.common.Constants.SUCCESSFUL_IMPORT_MESSAGE;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileUtil.readFile("towns.json");
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<TownImportDTO> towns = Arrays.stream(gson.fromJson(readTownsJsonFile(), TownImportDTO[].class)).toList();

        for (TownImportDTO town : towns) {
            boolean isValid = validationUtil.isValid(town);

            if (isValid) {
                Town townToSave = this.modelMapper.map(town, Town.class);

                this.townRepository.saveAndFlush(townToSave);

                stringBuilder.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Town", town.getName())).append(System.lineSeparator());
            } else stringBuilder.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
