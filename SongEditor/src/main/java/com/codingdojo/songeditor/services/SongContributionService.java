package com.codingdojo.songeditor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.songeditor.models.SongContribution;
import com.codingdojo.songeditor.repositories.SongContributionRepository;

@Service
public class SongContributionService {
	@Autowired
	private SongContributionRepository songContributionRepo;
	
	// C R U D
	public List<SongContribution> getAll(){
		return songContributionRepo.findAll();
	}
	
	// save
	
	 
}
