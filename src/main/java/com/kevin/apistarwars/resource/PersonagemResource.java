package com.kevin.apistarwars.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.apistarwars.model.Personagem;
import com.kevin.apistarwars.repository.PersongemRepository;

@RestController
@RequestMapping
public class PersonagemResource {

	@Autowired
	private PersongemRepository repo;

	@GetMapping(value = "/personagens")
	public ResponseEntity<List<Personagem>> findAll() {
		List<Personagem> list = repo.findAll();
		return ResponseEntity.ok().body(list);
	}

}
