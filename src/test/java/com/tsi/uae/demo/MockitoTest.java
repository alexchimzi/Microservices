package com.tsi.uae.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MicroserviceApplication microserviceApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private CityRepository cityRepository;


    @BeforeEach
    void setup(){
        microserviceApplication = new MicroserviceApplication(actorRepository,cityRepository,countryRepository);
    }

    @Test
    public void canGetAllActors()
    {
        microserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test
    public void canGetActorsById()
    {

        Actor actor = new Actor("TEST", "TESTING");
        Mockito.when(microserviceApplication.getActorId(1)).thenReturn(Optional.of(actor));
        Optional<Actor> a = microserviceApplication.getActorId(1);

        Assertions.assertEquals("TEST",a.get().getFirst_name());
        Assertions.assertEquals("TESTING",a.get().getLast_name());
    }
    @Test
    public void canAddActor()
    {
        microserviceApplication.addActor("alex","ben");
        ArgumentCaptor<Actor> actorArgumentCaptor
                 = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor a = actorArgumentCaptor.getValue();
        Assertions.assertEquals(a.getFirst_name(),"alex","Incorrect First Name");
        Assertions.assertEquals(a.getLast_name(),"ben","Incorrect Last Name");
    }
    @Test
    public void canUpdateActor()
    {
        Actor actor = new Actor("TEST", "TESTING");
        Mockito.when(microserviceApplication.getActorId(1)).thenReturn(Optional.of(actor));
        microserviceApplication.updateActorById(1,"TESTING","TEST");
        Actor a = microserviceApplication.getActorId(1).orElseThrow();

        Assertions.assertEquals(a.getFirst_name(),"TESTING","Incorrect First Name");
        Assertions.assertEquals(a.getLast_name(),"TEST","Incorrect Last Name");

    }

    @Test
    public void canDeleteActor()
    {
        Actor actor = new Actor("TEST", "TESTING");

        Optional<Actor> optionalActor = Optional.of(actor);
        Mockito.when(actorRepository.findById(1)).thenReturn(optionalActor);
        actorRepository.deleteById(1);
        verify(actorRepository).deleteById(1);
        Assertions.assertTrue(microserviceApplication.removeActorById(1));

    }

    // City Tests
    @Test
    public void canGetAllCity()
    {
        microserviceApplication.getAllCity();
        verify(cityRepository).findAll();
    }
    @Test
    public void canGetCityById()
    {

        City city = new City("TESTING");
        Mockito.when(microserviceApplication.getCityId(1)).thenReturn(Optional.of(city));
        Optional<City> c = microserviceApplication.getCityId(1);

        Assertions.assertEquals("TESTING",c.get().getCity());
    }
    @Test
    public void canAddCity()
    {
        microserviceApplication.addCity("TEST");
        ArgumentCaptor<City> cityArgumentCaptor
                = ArgumentCaptor.forClass(City.class);

        verify(cityRepository).save(cityArgumentCaptor.capture());
        City c = cityArgumentCaptor.getValue();
        Assertions.assertEquals(c.getCity(),"TEST","Incorrect Name");
    }
    @Test
    public void canUpdateCity()
    {
        City city = new City("TEST");
        Mockito.when(microserviceApplication.getCityId(1)).thenReturn(Optional.of(city));
        microserviceApplication.updateCityById(1,"TESTING");
        City c = microserviceApplication.getCityId(1).orElseThrow();

        Assertions.assertEquals(c.getCity(),"TESTING","Incorrect Name");

    }

    @Test
    public void canDeleteCity()
    {
        City c = new City("TEST");

        Optional<City> optionalCity = Optional.of(c);
        Mockito.when(cityRepository.findById(1)).thenReturn(optionalCity);
        cityRepository.deleteById(1);
        verify(cityRepository).deleteById(1);
        Assertions.assertTrue(microserviceApplication.removeCityById(1));

    }

    // Country Tests
    @Test
    public void canGetAllCountry()
    {
        microserviceApplication.getAllCountry();
        verify(countryRepository).findAll();
    }
    @Test
    public void canGetCountryById()
    {

        Country country = new Country("TESTING");
        Mockito.when(microserviceApplication.getCountryById(1)).thenReturn(Optional.of(country));
        Optional<Country> c = microserviceApplication.getCountryById(1);

        Assertions.assertEquals("TESTING",c.get().getCountry());
    }
    @Test
    public void canAddCountry()
    {
        microserviceApplication.addCountry("TEST");
        ArgumentCaptor<Country> countryArgumentCaptor
                = ArgumentCaptor.forClass(Country.class);

        verify(countryRepository).save(countryArgumentCaptor.capture());
        Country c = countryArgumentCaptor.getValue();
        Assertions.assertEquals(c.getCountry(),"TEST","Incorrect Name");
    }
    @Test
    public void canUpdateCountry()
    {
        Country country = new Country("TEST");
        Mockito.when(microserviceApplication.getCountryById(1)).thenReturn(Optional.of(country));
        microserviceApplication.updateCountryById(1,"TESTING");
        Country c = microserviceApplication.getCountryById(1).orElseThrow();

        Assertions.assertEquals(c.getCountry(),"TESTING","Incorrect Name");

    }

    @Test
    public void canDeleteCountry()
    {
        Country c = new Country("TEST");

        Optional<Country> optionalCountry = Optional.of(c);
        Mockito.when(countryRepository.findById(1)).thenReturn(optionalCountry);
        countryRepository.deleteById(1);
        verify(countryRepository).deleteById(1);
        Assertions.assertTrue(microserviceApplication.removeCountryById(1));

    }
}
