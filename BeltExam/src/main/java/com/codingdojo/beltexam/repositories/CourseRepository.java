package com.codingdojo.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexam.models.Course;
import com.codingdojo.beltexam.models.User;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findAll();

	Course findByIdIs(Long id);

	// ManyToOne
	List<Course> findByInstructor(User instructor);
	List<Course> findAllByInstructor(User instructor);
	List<Course> findByInstructorNot(User instructor);

	// ManyToMany
	List<Course> findAllByStudents(User student);
	List<Course> findByStudentsNotContains(User student);
}
