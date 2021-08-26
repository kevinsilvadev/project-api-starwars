package com.kevin.apistarwars.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kevin.apistarwars.exception.ResourceNotFoundException;
import com.kevin.apistarwars.model.Caracteristicas;
import com.kevin.apistarwars.repository.CaracteristicaRepository;

@Service
public class CaracteristicaService {

	@Autowired
	private CaracteristicaRepository repository;

	public List<Caracteristicas> findAll() {
		return repository.findAll();
	}

	public Caracteristicas findById(Long id) {
		Optional<Caracteristicas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Caracteristicas insert(Caracteristicas obj) {
		return repository.save(obj);
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

	public Caracteristicas update(Long id, Caracteristicas obj) {

		try {

			Caracteristicas entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Caracteristicas entity, Caracteristicas obj) {
		entity.setAltura(obj.getAltura());
		entity.setCabelo(obj.getCabelo());
		entity.setMorte(obj.getMorte());
		entity.setNascimento(obj.getNascimento());
		entity.setOlhos(obj.getOlhos());

	}

}
