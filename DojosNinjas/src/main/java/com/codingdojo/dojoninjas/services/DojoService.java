package com.codingdojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
// C R U D

// find all
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}

// find by id
	public Dojo getById(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

// create
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

// update
	public Dojo update(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

// delete
	public void delete(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			dojoRepo.deleteById(id);
		}
	}
}
