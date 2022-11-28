package bg.softuni.hiberspring.service.impl;

import bg.softuni.hiberspring.domain.dtos.EmployeeImportDTO;
import bg.softuni.hiberspring.domain.dtos.EmployeesWrapperDTO;
import bg.softuni.hiberspring.domain.entities.Branch;
import bg.softuni.hiberspring.domain.entities.Employee;
import bg.softuni.hiberspring.domain.entities.EmployeeCard;
import bg.softuni.hiberspring.repository.BranchRepository;
import bg.softuni.hiberspring.repository.EmployeeCardRepository;
import bg.softuni.hiberspring.repository.EmployeeRepository;
import bg.softuni.hiberspring.service.EmployeeService;
import bg.softuni.hiberspring.util.FileUtil;
import bg.softuni.hiberspring.util.ValidationUtil;
import bg.softuni.hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static bg.softuni.hiberspring.common.Constants.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final EmployeeCardRepository employeeCardRepository;

    private final BranchRepository branchRepository;

    private final ValidationUtil validationUtil;

    private final FileUtil fileUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, XmlParser xmlParser, ModelMapper modelMapper, EmployeeCardRepository employeeCardRepository, BranchRepository branchRepository, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return fileUtil.readFile("employees.xml");
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        EmployeesWrapperDTO employeesWrapperDTO = xmlParser.parseXml(EmployeesWrapperDTO.class, "src/main/resources/files/employees.xml");

        List<EmployeeImportDTO> employees = employeesWrapperDTO.getEmployees();

        for (EmployeeImportDTO employee : employees) {
            boolean isValid = validationUtil.isValid(employee);

            if (isValid) {
                Optional<EmployeeCard> byNumber = employeeCardRepository.findByNumber(employee.getCard());

                if (byNumber.isEmpty()) continue;

                Optional<Employee> employeeByCard = employeeRepository.findEmployeeByCard(byNumber.get().getNumber());

                if (employeeByCard.isPresent()) continue;

                Optional<Branch> byName = branchRepository.findByName(employee.getBranch());

                if (byName.isEmpty()) continue;

                Employee employeeToSave = modelMapper.map(employee, Employee.class);

                employeeToSave.setBranch(byName.get());

                employeeToSave.setCard(byNumber.get());

                stringBuilder.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Employee", employee.getFirstName() + " " + employee.getLastName())).append(System.lineSeparator());

                employeeRepository.saveAndFlush(employeeToSave);

            } else stringBuilder.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Employee> employees = employeeRepository.employees();

        for (Employee employee : employees) {
            stringBuilder.append(String.format(PRODUCTIVE_EMPLOYEE_OUTPUR_FORMAT, employee.getFirstName() + " " + employee.getLastName(), employee.getPosition(), employee.getCard().getNumber())).append(System.lineSeparator());
        }

        String testext = stringBuilder.toString();

        System.out.println();

        return null;
    }
}
