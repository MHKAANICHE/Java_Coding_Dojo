package com.codingdojo.songeditor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.songeditor.models.Song;
import com.codingdojo.songeditor.models.SongContribution;
import com.codingdojo.songeditor.repositories.SongContributionRepository;

@Service
public class SongContributionService {
	@Autowired
	private SongContributionRepository songContributionRepo;
	
	// C R U D
		public List<SongContribution> getAll() {
			return songContributionRepo.findAll();
		}

		// get by id
		public SongContribution getById(Long id) {
			Optional<SongContribution> optional = songContributionRepo.findById(id);
			if (optional.isPresent()) {
				return optional.get();
			} else {
				return null;
			}
		}

		// save
		public SongContribution create(SongContribution contrib) {
			return songContributionRepo.save(contrib);
		}

		// update
		public SongContribution update(SongContribution contrib) {
			return songContributionRepo.save(contrib);
		}

		// delete
		public void deleteById(Long id) {
			Optional<SongContribution> optional = songContributionRepo.findById(id);
			if (optional.isPresent()) {
				songContributionRepo.deleteById(id);
			}
		}
	
	 
}
