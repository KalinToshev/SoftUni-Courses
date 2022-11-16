package com.softuni.lab_springdataautomappingobjects;

import com.softuni.lab_springdataautomappingobjects.entities.Address;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.AddressDTO;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.softuni.lab_springdataautomappingobjects.services.AddressService;
import com.softuni.lab_springdataautomappingobjects.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    private final Scanner scanner;

    @Autowired
    public AppMain(AddressService addressService, EmployeeService employeeService, Scanner scanner) {

        this.addressService = addressService;

        this.employeeService = employeeService;

        this.scanner = scanner;
        
    }

    @Override
    public void run(String... args) throws Exception {

//        createAddress(scanner);

//        createEmployee(scanner);

        printAllEmployees();

    }

    private void printAllEmployees() {

        this.employeeService.findAll()
                .forEach(System.out::println);

    }

    private void createEmployee() {

        String firstName = scanner.nextLine();

        BigDecimal salary = new BigDecimal(scanner.nextLine());

        LocalDate birthday = LocalDate.parse(scanner.nextLine());

//        long addressId = Long.parseLong(scanner.nextLine());

        String country = scanner.nextLine();

        String city = scanner.nextLine();

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        this.employeeService.create(employeeDTO);

    }

    private void createAddress() {

        String country = scanner.nextLine();

        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);

        Address address = addressService.create(data);

        System.out.println(address);

    }

}
