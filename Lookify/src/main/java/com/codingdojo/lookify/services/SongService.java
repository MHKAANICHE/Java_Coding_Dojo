package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepo;

// C R U D
	public List<Song> getAll() {
		return songRepo.findAll();
	}

	public List<Song> getAllByArtist(String artist) {
		return songRepo.findByArtistContaining(artist);
	}
	
	public List<Song> getAllSortedByRating() {
		return songRepo.findByOrderByRatingDesc();
	}

	public Song getOneById(Long id) {
		Optional<Song> optional = songRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Song create(Song song) {
		return songRepo.save(song);
	}

	public Song update(Song song) {
		return songRepo.save(song);
	}

	public void deleteById(Long id) {
		Optional<Song> optional = songRepo.findById(id);
		if (optional.isPresent()) {
			songRepo.deleteById(id);
		}
	}

}
