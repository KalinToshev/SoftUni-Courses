package com.softuni.lab_springdataautomappingobjects.services;

import com.softuni.lab_springdataautomappingobjects.entities.Address;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.AddressDTO;
import com.softuni.lab_springdataautomappingobjects.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {

        this.addressRepository = addressRepository;

        this.modelMapper = modelMapper;

    }

    @Override
    public Address create(AddressDTO data) {

        Address address = modelMapper.map(data, Address.class);

        return this.addressRepository.save(address);

    }

}
