package com.codingdojo.songeditor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.songeditor.models.Song;
import com.codingdojo.songeditor.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepo;

	// C R U D
	public List<Song> getAll() {
		return songRepo.findAll();
	}

	// get by id
	public Song getById(Long id) {
		Optional<Song> optional = songRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// save
	public Song create(Song song) {
		return songRepo.save(song);
	}

	// update
	public Song update(Song song) {
		return songRepo.save(song);
	}

	// delete
	public void deleteById(Long id) {
		Optional<Song> optional = songRepo.findById(id);
		if (optional.isPresent()) {
			// set all contribution to null 
			
			songRepo.deleteById(id);
		}
	}

}
