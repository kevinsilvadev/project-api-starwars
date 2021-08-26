package com.kevin.apistarwars.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kevin.apistarwars.model.Caracteristicas;
import com.kevin.apistarwars.services.CaracteristicaService;

@RestController
@RequestMapping(value = "/caracteristicas")
public class CaracteristicaResource {

	@Autowired
	private CaracteristicaService service;

	@GetMapping
	public ResponseEntity<List<Caracteristicas>> findAll() {
		List<Caracteristicas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Caracteristicas> findById(@PathVariable Long id){
		Caracteristicas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity <Caracteristicas> insert( @RequestBody Caracteristicas obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Caracteristicas> update(@PathVariable Long id, @RequestBody Caracteristicas obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
