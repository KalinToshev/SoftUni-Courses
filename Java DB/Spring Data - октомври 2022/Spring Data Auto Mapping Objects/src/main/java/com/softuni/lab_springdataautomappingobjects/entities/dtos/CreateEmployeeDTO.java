package com.softuni.lab_springdataautomappingobjects.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateEmployeeDTO {
    private final String firstName;

    private final String lastName;

    private final BigDecimal salary;

    private final LocalDate birthday;

    private AddressDTO address;

    public CreateEmployeeDTO(String firstName, String lastName, BigDecimal salary, LocalDate birthday, AddressDTO address) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.salary = salary;

        this.birthday = birthday;

        this.address = address;

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public BigDecimal getSalary() {

        return salary;

    }

    public LocalDate getBirthday() {

        return birthday;

    }

    public AddressDTO getAddress() {

        return address;

    }

}
