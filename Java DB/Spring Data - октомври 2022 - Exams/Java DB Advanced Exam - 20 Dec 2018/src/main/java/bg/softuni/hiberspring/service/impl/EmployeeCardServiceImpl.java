package bg.softuni.hiberspring.service.impl;

import bg.softuni.hiberspring.domain.dtos.EmployeeCardImportDTO;
import bg.softuni.hiberspring.domain.entities.EmployeeCard;
import bg.softuni.hiberspring.repository.EmployeeCardRepository;
import bg.softuni.hiberspring.service.EmployeeCardService;
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
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return fileUtil.readFile("employee-cards.json");
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<EmployeeCardImportDTO> employeeCardImportDTOS = Arrays.stream(gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardImportDTO[].class)).toList();

        for (EmployeeCardImportDTO employeeCard : employeeCardImportDTOS) {
                Optional<EmployeeCard> byNumber = employeeCardRepository.findByNumber(employeeCard.getNumber());

                if (byNumber.isPresent()) {
                    stringBuilder.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    continue;
                }

                EmployeeCard employeeCardToSave = modelMapper.map(employeeCard, EmployeeCard.class);

                stringBuilder.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Employee Card", employeeCard.getNumber())).append(System.lineSeparator());

                this.employeeCardRepository.saveAndFlush(employeeCardToSave);
        }

        return stringBuilder.toString();
    }
}
