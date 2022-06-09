package com.tsi.uae.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "city")
@Repository
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int city_id;

    private String city;

    private int country_id;

    public City(int city_id, String city, int country_id) {
        this.city_id = city_id;
        this.city = city;
        this.country_id = country_id;
    }
    public City(String city) {

        this.city = city;

    }
    public City(){

    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
