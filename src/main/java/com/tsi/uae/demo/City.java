package com.tsi.uae.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Repository
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int city_id;

    private String city;
    @ManyToOne
    @JoinColumn(name="country_id")
    Country country;

    public City(int city_id, String city, Country country) {
        this.city_id = city_id;
        this.city = city;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", country_id=" + country.getCountry_id() +
                '}';
    }
}
