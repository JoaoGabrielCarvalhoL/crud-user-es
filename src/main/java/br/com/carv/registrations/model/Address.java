package br.com.carv.registrations.model;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false, length = 10)
    private String cep;

    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;

    public Address() {

    }

    public Address(Long addressId, String street, String district, String houseNumber, String cep, City city) {
        this.addressId = addressId;
        this.street = street;
        this.district = district;
        this.houseNumber = houseNumber;
        this.cep = cep;
        this.city = city;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
