package com.codingdojo.burgertracker1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.burgertracker1.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
// find All 
List<Burger> findAll();

}
