package com.tsi.uae.demo;

import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Embedded;
//import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "actor")
@Repository
public class Actor {


    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int actor_id;




    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    //Attributes
    private String first_name;
    private String last_name;



    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;

    }
    public Actor(int Id, String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
        this.actor_id = Id;

    }


    public Actor(){

    }




    @Override
    public String toString() {
        return "Actor{" +
                "actor_id=" + actor_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
