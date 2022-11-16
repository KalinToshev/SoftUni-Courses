package com.softuni.lab_springdataautomappingobjects.services;

import com.softuni.lab_springdataautomappingobjects.entities.Employee;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();

}
