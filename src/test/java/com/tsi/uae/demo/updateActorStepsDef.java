package com.tsi.uae.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public class updateActorStepsDef {
    int actor_Id;
    String first_name = "TEST";
    String last_name = "TESTING";
    MicroserviceApplication pa;
    ActorRepository actorRepository;
    CountryRepository countryRepository;
    CityRepository cityRepository;
    AddressRepository addressRepository;
    CustomerRepository customerRepository;

    String actualFirstName;
    String actualLastName;

    @Given("I have the actors ID and Update")
    public void i_have_the_actors_id_and_update() {
    actor_Id = 1;
    actualFirstName = "TESTING";
    actualLastName = "TEST";
    }
    @When("I update actor information on table")
    public void i_update_actor_information_on_table() {
        actorRepository = mock(ActorRepository.class);
        pa = new MicroserviceApplication(actorRepository,cityRepository,
                countryRepository,
                addressRepository,
                customerRepository);

        Actor c = new Actor(first_name,last_name);
        Optional<Actor> optionalActor = Optional.of(c);
        Mockito.when(actorRepository.findById(1)).thenReturn(optionalActor);
        pa.addActor(1,optionalActor.get().getFirst_name(),
                optionalActor.get().getLast_name());

        pa.updateActorById(1,actualFirstName,actualLastName);

    }
    @Then("I get the success Message")
    public void i_get_the_success_message() {

        Assertions.assertEquals(actualFirstName,pa.getActorId(1).get().getFirst_name(),"First name did not update "+actualFirstName);
        Assertions.assertEquals(actualLastName,pa.getActorId(1).get().getLast_name(),"Last name did not update "+actualLastName);

    }
}
