package com.tsi.uae.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "address")
@Repository
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int address_id;

    private String address;
    @Nullable
    private String address2;

    private  String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private int postal_code;
    @Nullable
    private int phone;
    @Nullable
    private Blob location;

    public Address() {
    }

    public Address(int address_id, String address, City city, int postal_code) {
        this.address_id = address_id;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
    }

    public Address(int address_id, String address) {
        this.address_id = address_id;
        this.address = address;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Nullable
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(@Nullable String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Nullable
    public Blob getLocation() {
        return location;
    }

    public void setLocation(@Nullable Blob location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", city_id=" + city.getCity() +
                ", postal_code=" + postal_code +
                ", phone=" + phone +
                ", location=" + location +
                '}';
    }
}
