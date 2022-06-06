package com.tsi.uae.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Optional;

@Entity
@Qualifier
@Table(name = "actor")
@Repository
public class Actor implements ActorRepository {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int actor_id;


    //Attributes
    private String first_name;
    private String last_name;

    //@ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    //@JasonIgnore
    //private Set<Film> film = new HashSet<>();


    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public Actor(){

    }


    @Override
    public <S extends Actor> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Actor> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Actor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Actor> findAll() {
        return null;
    }

    @Override
    public Iterable<Actor> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Actor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Actor> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
