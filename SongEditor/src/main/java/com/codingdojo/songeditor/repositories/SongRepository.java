package com.codingdojo.songeditor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.songeditor.models.Song;
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
}
