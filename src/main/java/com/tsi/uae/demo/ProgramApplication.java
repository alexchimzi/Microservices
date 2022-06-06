package com.tsi.uae.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class ProgramApplication {
	@Autowired
	private @Qualifier("actor") ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}

	public ProgramApplication(@Qualifier("actor") ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}
	@GetMapping("/Get_Actors")
	public @ResponseBody Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}
	//@PostMapping("/Add_New_Actor")
	//public @ResponseBody Iterable<Actor>post_(){}


}
