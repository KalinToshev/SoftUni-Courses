package com.softuni.lab_springdataautomappingobjects.services;

import com.softuni.lab_springdataautomappingobjects.entities.Address;
import com.softuni.lab_springdataautomappingobjects.entities.Employee;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import com.softuni.lab_springdataautomappingobjects.repositories.AddressRepository;
import com.softuni.lab_springdataautomappingobjects.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, ModelMapper modelMapper) {

        this.employeeRepository = employeeRepository;

        this.addressRepository = addressRepository;

        this.modelMapper = modelMapper;

    }

    @Override
    public Employee create(CreateEmployeeDTO employeeDTO) {

        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(employeeDTO.getAddress().getCountry(), employeeDTO.getAddress().getCity());

        address.ifPresent(employee::setAddress);

        return this.employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDTO> findAll() {

        return this.employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());

    }

}
