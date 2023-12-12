package com.codingdojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;

// CRUD 
// Find All
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}

// Find By Id
	public Ninja getById(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}

// Create
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

// Update 
	public Ninja update(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

// delete
	public void delete(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			ninjaRepo.deleteById(id);
		}
	}
}
