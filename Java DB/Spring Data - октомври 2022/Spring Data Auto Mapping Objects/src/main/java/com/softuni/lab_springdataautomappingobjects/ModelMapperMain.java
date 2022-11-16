package com.softuni.lab_springdataautomappingobjects;

import com.softuni.lab_springdataautomappingobjects.entities.Address;
import com.softuni.lab_springdataautomappingobjects.entities.Employee;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//@Component
public class ModelMapperMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Address address =  new Address("Sofia", "Bulgaria");

        Employee employee = new Employee("Kalin", BigDecimal.TEN, address);

        ModelMapper modelMapper = new ModelMapper();

//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//
//            @Override
//            protected void configure() {
//
//                map().setCity(source.getAddress().getCity());
//
//            }
//
//        };
//
//        modelMapper.addMappings(propertyMap);

//        modelMapper.validate();

        TypeMap<Employee, EmployeeDTO> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeDTO.class);

        typeMap.addMappings(mapping -> mapping.map(
                source -> source.getAddress().getCity(),
                EmployeeDTO::setAddressCity)
        );

//        typeMap.validate();

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO.toString());

    }

}
