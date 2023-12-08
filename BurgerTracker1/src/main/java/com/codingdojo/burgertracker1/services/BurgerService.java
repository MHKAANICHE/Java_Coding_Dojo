package com.codingdojo.burgertracker1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgertracker1.models.Burger;
import com.codingdojo.burgertracker1.repositories.BurgerRepository;

@Service
public class BurgerService {
// dependecy Injection 
	private final BurgerRepository burgerRepo;

	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepo = burgerRepository;
	}

// C R U D
	public Burger create(Burger burger) {
		return burgerRepo.save(burger);
	}

	public Burger findById(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if (optionalBurger.isEmpty()) {
			return null;
		} else {
			return optionalBurger.get();
		}
	}

	public Burger update(Burger burger) {
		return burgerRepo.save(burger);
	}

	public void destroy(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if (!optionalBurger.isEmpty()) {
			burgerRepo.deleteById(id);
		}
	}

	public List<Burger> findAll() {
		return burgerRepo.findAll();
	}
}
