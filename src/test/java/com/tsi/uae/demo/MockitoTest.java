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

    @Mock
    private AddressRepository addressRepository;


    @BeforeEach
    void setup(){
        microserviceApplication = new MicroserviceApplication(actorRepository,cityRepository,
                countryRepository,addressRepository);
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

        Actor actor = new Actor(1,"TEST", "TESTING");
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
        Actor actor = new Actor();
        actor.setActor_id(1);
        actor.setFirst_name("TESTING");
        actor.setLast_name("TEST");
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

        City city = new City();
        city.setCity("TESTING");
        city.setCity_id(1);
        city.setCountry_id(1);

        Mockito.when(microserviceApplication.getCityId(1)).thenReturn(Optional.of(city));
        Optional<City> c = microserviceApplication.getCityId(1);

        Assertions.assertEquals("TESTING",c.get().getCity());
        Assertions.assertEquals(1,c.get().getCity_id());
        Assertions.assertEquals(1,c.get().getCountry_id());
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
        City city = new City(1,"TEST",1);
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

        Country country = new Country();
        country.setCountry("TESTING");
        country.setCountry_id(1);
        Mockito.when(microserviceApplication.getCountryById(1)).thenReturn(Optional.of(country));
        Optional<Country> c = microserviceApplication.getCountryById(1);

        Assertions.assertEquals("TESTING",c.get().getCountry());
        Assertions.assertEquals(1,c.get().getCountry_id());
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
        Country country = new Country(1,"TEST");
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

    //Address Tests
    @Test
    public void canGetAllAddress()
    {
        microserviceApplication.getAllAddress();
        verify(addressRepository).findAll();
    }
    @Test
    public void canGetAddressById()
    {

        Address address = new Address();
        address.setAddress("TESTING");
        address.setAddress2("TESTING 2");
        address.setPhone(123456789);
        address.setPostal_code(12345);
        address.setCity_id(123);
        address.setLocation(null);
        address.setDistrict("TESTING 3");

        address.setAddress_id(1);
        Mockito.when(microserviceApplication.getAddressById(1)).thenReturn(Optional.of(address));
        Optional<Address> a = microserviceApplication.getAddressById(1);

        Assertions.assertEquals("TESTING",a.get().getAddress());
        Assertions.assertEquals(1,a.get().getAddress_id());
        Assertions.assertEquals("TESTING 2",a.get().getAddress2());
        Assertions.assertEquals(123456789,a.get().getPhone());
        Assertions.assertEquals(12345,a.get().getPostal_code());
        Assertions.assertEquals(123,a.get().getCity_id());
        Assertions.assertEquals(null,a.get().getLocation());
        Assertions.assertEquals("TESTING 3",a.get().getDistrict());

    }
    @Test
    public void canAddAddress()
    {
        microserviceApplication.addAddress(1,"TESTING");
        ArgumentCaptor<Address> addressArgumentCaptor
                = ArgumentCaptor.forClass(Address.class);

        verify(addressRepository).save(addressArgumentCaptor.capture());
        Address a = addressArgumentCaptor.getValue();
        Assertions.assertEquals(a.getAddress(),"TESTING","Incorrect Name");
    }
    @Test
    public void canUpdateAddress()
    {
        Address address = new Address(1,"TEST",890,67890);
        Mockito.when(microserviceApplication.getAddressById(1)).thenReturn(Optional.of(address));
        microserviceApplication.updateAddressById(1,"TESTING","TESTING 2","TESTING 3",
                123,12345,123456789,null);
        Address a = microserviceApplication.getAddressById(1).orElseThrow();

        Assertions.assertEquals("TESTING",a.getAddress());
        Assertions.assertEquals(1,a.getAddress_id());
        Assertions.assertEquals("TESTING 2",a.getAddress2());
        Assertions.assertEquals(123456789,a.getPhone());
        Assertions.assertEquals(12345,a.getPostal_code());
        Assertions.assertEquals(123,a.getCity_id());
        Assertions.assertEquals(null,a.getLocation());
        Assertions.assertEquals("TESTING 3",a.getDistrict());


    }

    @Test
    public void canDeleteAddress()
    {
        Address a = new Address(1,"TEST");

        Optional<Address> optionalAddress = Optional.of(a);
        Mockito.when(addressRepository.findById(1)).thenReturn(optionalAddress);
        addressRepository.deleteById(1);
        verify(addressRepository).deleteById(1);
        Assertions.assertTrue(microserviceApplication.removeAddressById(1));

    }
}
