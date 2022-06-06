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
	private @Qualifier("actors") ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}

	public ProgramApplication(@Qualifier("actors") ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewUser (@RequestParam String first_name,@RequestParam String last_name){
		Actor a = new Actor();

		actorRepository.save(a);
		return "";
	}
}
