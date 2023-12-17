package com.codingdojo.savetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravel.models.Item;
import com.codingdojo.savetravel.repositories.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepo;

// CRUD
// get all
	public List<Item> getAll() {
		return itemRepo.findAll();
	}

// get by Id
	public Item getById(Long id) {
		Optional<Item> optionalItem = itemRepo.findById(id);
		if (optionalItem.isEmpty()) {
			return null;
		}
		return optionalItem.get();
	}

// crate
	public Item create(Item item) {
		return itemRepo.save(item);
	}

// update
	public Item update(Item item) {
		return itemRepo.save(item);
	}

// Delete
	public void delete(Long id) {
		Optional<Item> optionalItem = itemRepo.findById(id);
		if (optionalItem.isPresent()) {
			itemRepo.deleteById(id);
		}
	}
}
