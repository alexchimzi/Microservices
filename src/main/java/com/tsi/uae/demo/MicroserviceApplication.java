package com.tsi.uae.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class MicroserviceApplication {
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	public MicroserviceApplication(ActorRepository actorRepository,CityRepository cityRepository,CountryRepository countryRepository){

		this.actorRepository = actorRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
	}
	@GetMapping("/Get_All_Actors")
	public @ResponseBody Iterable<Actor>getAllActors(){
		//System.out.println(actorRepository.toString());
		return actorRepository.findAll();
	}
	@GetMapping("/Get_Actor_By_Id")
	public @ResponseBody Optional<Actor> getActorId(@RequestParam int Id){
		return actorRepository.findById(Id);
	}
	@PostMapping("/Add_Actor")
	public Boolean addActor(@RequestParam String first_name,  String last_name){

		Actor a = new Actor(first_name,last_name);

		actorRepository.save(a);

		return true;

	}


	@DeleteMapping("/Delete_Actor")
	public Boolean removeActorById(@RequestParam int Id){
		Actor a = actorRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Actor not found for this ID :: " + Id));
		actorRepository.delete(a);
		return true;
	}
	@PutMapping("/Update_Actor")
	public String updateActorById(@RequestParam Integer id, String first_name, String last_name){

		Actor a = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Cannot find  Id"+ id));
		a.setFirst_name(first_name);
		a.setLast_name(last_name);
		actorRepository.save(a);
		return "Updated";


	}
	//City
	@GetMapping("/Get_All_City")
	public @ResponseBody Iterable<City>getAllCity(){
		//System.out.println(actorRepository.toString());
		return cityRepository.findAll();
	}
	@GetMapping("/Get_City_By_Id")
	public @ResponseBody Optional<City> getCityId(@RequestParam int Id){

		return cityRepository.findById(Id);
	}
	@PostMapping("/Add_City")
	public Boolean addCity(@RequestParam String cityName){

		City c = new City(cityName);

		cityRepository.save(c);

		return true;

	}
	@DeleteMapping("/Delete_City")
	public Boolean removeCityById(@RequestParam int Id){
		City c = cityRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Actor not found for this ID :: " + Id));
		cityRepository.delete(c);
		return true;
	}
	@PutMapping("/Update_City")
	public Boolean updateCityById(@RequestParam Integer id, String cityName){

		City c = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Cannot find  Id"+ id));
		c.setCity(cityName);
		cityRepository.save(c);
		return true;
	}
	// Country
	@GetMapping("/Get_All_Country")
	public @ResponseBody Iterable<Country>getAllCountry(){
		//System.out.println(actorRepository.toString());
		return countryRepository.findAll();
	}
	@GetMapping("/Get_Country_By_Id")
	public @ResponseBody Optional<Country> getCountryById(@RequestParam int Id){

		return countryRepository.findById(Id);
	}
	@PostMapping("/Add_Country")
	public Boolean addCountry(@RequestParam String countryName){

		Country c = new Country(countryName);

		countryRepository.save(c);

		return true;

	}
	@DeleteMapping("/Delete_Country")
	public Boolean removeCountryById(@RequestParam int Id){
		Country c = countryRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Actor not found for this ID :: " + Id));
		countryRepository.delete(c);
		return true;
	}
	@PutMapping("/Update_Country")
	public Boolean updateCountryById(@RequestParam Integer id, String countryName){

		Country c = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Cannot find  Id"+ id));
		c.setCountry(countryName);
		countryRepository.save(c);
		return true;
	}
}
