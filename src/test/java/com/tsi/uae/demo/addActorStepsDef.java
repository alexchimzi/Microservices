package com.tsi.uae.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class addActorStepsDef {
    Actor actor;
    String first_name;
    String last_name;

    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        // Write code here that turns the phrase above into concrete actions
        first_name = "Testing";
        last_name = "Test";
    }
    MicroserviceApplication pa;
    ActorRepository actorRepository;
    CountryRepository countryRepository;
    CityRepository cityRepository;
    ArgumentCaptor<Actor> argumentCaptor;
    String actualFirstName;
    String actualLastName;
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        // Write code here that turns the phrase above into concrete actions
        argumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepository = mock(ActorRepository.class);
        pa = new MicroserviceApplication(actorRepository,cityRepository,countryRepository);
        pa.addActor(first_name,last_name);
        verify(actorRepository).save(argumentCaptor.capture());
        actualFirstName = argumentCaptor.getValue().getFirst_name();
        actualLastName = argumentCaptor.getValue().getLast_name();



    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(first_name,actualFirstName);
        Assertions.assertEquals(last_name,actualLastName);

    }
}
