package com.codingdojo.teammanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.teammanager.models.Player;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findAll();
}
