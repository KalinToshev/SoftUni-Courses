package com.softuni.lab_springdataautomappingobjects.services;

import com.softuni.lab_springdataautomappingobjects.entities.Address;
import com.softuni.lab_springdataautomappingobjects.entities.dtos.AddressDTO;

public interface AddressService {

    Address create(AddressDTO data);

}
