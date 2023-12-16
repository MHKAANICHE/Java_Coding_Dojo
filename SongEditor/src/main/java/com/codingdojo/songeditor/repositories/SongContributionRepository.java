package com.codingdojo.songeditor.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.songeditor.models.SongContribution;
@Repository
public interface SongContributionRepository extends CrudRepository<SongContribution, Long> {
	List<SongContribution> findAll();
}
