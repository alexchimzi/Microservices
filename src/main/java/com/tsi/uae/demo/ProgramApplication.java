package com.tsi.uae.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class ProgramApplication {
	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}

	public ProgramApplication( ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}
	@GetMapping("/Get_All")
	public @ResponseBody Iterable<Actor>getAllActors(){
		//System.out.println(actorRepository.toString());
		return actorRepository.findAll();
	}
	@GetMapping("/Get_Id")
	public @ResponseBody Optional<Actor> getActorId(@RequestParam int Id){
		return actorRepository.findById(Id);
	}
	@PostMapping("/Add")
	public Boolean addActor(@RequestParam String first_name, @RequestParam String last_name){

		Actor a = new Actor(first_name,last_name);

		actorRepository.save(a);

		return true;

	}
	@DeleteMapping("/Delete")
	public Boolean removeActorById(@RequestParam int Id){
		if(actorRepository.existsById(Id)){
			actorRepository.deleteById(Id);
			return true;
		}else {
			System.out.println("Id "+Id +" doesnt exist");
			return false;
		}
		//return true;
	}
	@PutMapping("/Update")
	public String updateActorById(@RequestParam Integer id, String first_name, String last_name){

		Actor a = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Cannot find  Id"+ id));
		a.setFirst_name(first_name);
		a.setLast_name(last_name);
		actorRepository.save(a);
		return "Updated";


	}


}
