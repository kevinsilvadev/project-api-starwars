package com.kevin.apistarwars.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kevin.apistarwars.exception.ResourceNotFoundException;
import com.kevin.apistarwars.model.Personagem;
import com.kevin.apistarwars.repository.PersongemRepository;

@Service
public class PersonagemService {

	@Autowired
	private PersongemRepository repository;

	public List<Personagem> findAll() {
		return repository.findAll();
	}

	public Personagem findById(Long id) {
		Optional<Personagem> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}


	public void delete(Long id) {
		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}

	}

	public Personagem update(Long id, Personagem obj) {

		try {

			Personagem entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Personagem entity, Personagem obj) {
		entity.setFoto(obj.getFoto());
		entity.setNome(obj.getNome());
		entity.setNome(obj.getHistoria());

	}
	
	public Personagem insert(Personagem obj) {
		return repository.save(obj);
	}

}
