package com.codingdojo.beltexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexam.models.Course;
import com.codingdojo.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);

	List<User> findAll();

	User findByIdIs(Long id);

	// OneToMany
	List<User> findAllByInstructedCourses(Course course);
	List<User> findByInstructedCoursesNotContains(Course course);

	// ManyToMany
	List<User> findAllByEnrolledCourses(Course course);
	List<User> findByEnrolledCoursesNotContains(Course course);
}
