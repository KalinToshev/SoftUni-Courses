package bg.softuni.hiberspring.service.impl;

import bg.softuni.hiberspring.domain.dtos.BranchImportDTO;
import bg.softuni.hiberspring.domain.entities.Branch;
import bg.softuni.hiberspring.domain.entities.Town;
import bg.softuni.hiberspring.repository.BranchRepository;
import bg.softuni.hiberspring.repository.TownRepository;
import bg.softuni.hiberspring.service.BranchService;
import bg.softuni.hiberspring.util.FileUtil;
import bg.softuni.hiberspring.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static bg.softuni.hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;
import static bg.softuni.hiberspring.common.Constants.SUCCESSFUL_IMPORT_MESSAGE;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final TownRepository townRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownRepository townRepository) {
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return fileUtil.readFile("branches.json");
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<BranchImportDTO> branches = Arrays.stream(gson.fromJson(readBranchesJsonFile(), BranchImportDTO[].class)).toList();

        for (BranchImportDTO branch : branches) {
            boolean isValid = validationUtil.isValid(branch);

            if (isValid) {
                Branch branchToSave = modelMapper.map(branch, Branch.class);

                Optional<Town> townByName = townRepository.findTownByName(branch.getTown());

                if (townByName.isEmpty()) {
                    continue;
                } else branchToSave.setTown(townByName.get());

                stringBuilder.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Branch", branch.getName())).append(System.lineSeparator());

                this.branchRepository.saveAndFlush(branchToSave);
            } else stringBuilder.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
