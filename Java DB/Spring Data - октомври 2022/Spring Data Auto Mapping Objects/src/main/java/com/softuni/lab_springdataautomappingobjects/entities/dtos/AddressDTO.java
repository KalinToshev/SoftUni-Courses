package com.softuni.lab_springdataautomappingobjects.entities.dtos;

public class AddressDTO {

    private final String country;

    private final String city;

    public AddressDTO(String country, String city) {

        this.country = country;

        this.city = city;

    }

    public String getCountry() {

        return country;

    }

    public String getCity() {

        return city;

    }

}
