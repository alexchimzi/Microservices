package com.tsi.uae.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class removeActorStepDef {
    int actor_Id;
    String first_name = "TEST";
    String last_name= "TESTING";
    MicroserviceApplication pa;
    ActorRepository actorRepository;
    CountryRepository countryRepository;
    CityRepository cityRepository;
    AddressRepository addressRepository;
    CustomerRepository customerRepository;

    @Given("I have the actors ID")
    public void i_have_the_actors_id() {
    actor_Id = 1;
    }
    @When("I remove user from the database")
    public void i_remove_user_from_the_database() {
        //argumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepository = mock(ActorRepository.class);
        pa = new MicroserviceApplication(actorRepository,cityRepository,
                countryRepository,
                addressRepository,
                customerRepository);
        Actor c = new Actor(first_name,last_name);
        Optional<Actor> optionalActor = Optional.of(c);
        Mockito.when(actorRepository.findById(1)).thenReturn(optionalActor);

    }
    @Then("I get the success return Boolean")
    public void i_get_the_success_return_boolean() {
        Assertions.assertTrue(pa.removeActorById(actor_Id));

    }
}
