package com.example.springdatawthboot.entity.userInfo;

import jakarta.persistence.*;



@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String zipCode;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String city;


    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String number) {
        this.zipCode = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


