package com.softuni.lab_springdataautomappingobjects.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    public Address() {

    }

    public Address(String city, String country) {

        this.city = city;

        this.country = country;

    }

    public long getId() {

        return id;

    }

    public void setId(long id) {

        this.id = id;

    }

    public String getCity() {

        return city;

    }

    public void setCity(String city) {

        this.city = city;

    }

    public String getCountry() {

        return country;

    }

    public void setCountry(String country) {

        this.country = country;

    }

    @Override
    public String toString() {

        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';

    }

}
