package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.beltexam.models.Course;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	// Create
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	// Read
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	// Update
	public Course updateCourse(Course course) {
		if (courseRepository.existsById(course.getId())) {
			return courseRepository.save(course);
		} else {
			return null;
		}
	}

	// Delete
	public void deleteCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);

		if (optionalCourse.isPresent()) {
			Course course = optionalCourse.get();

			// Remove relationships before deletion
			course.getStudents().clear();
			course.getInstructor().getInstructedCourses().remove(course);

			courseRepository.delete(course);
		}
	}

	// Custom queries
	public List<Course> getCourseByInstructor(User instructor) {
		return courseRepository.findAllByInstructor(instructor);
	}

	public List<Course> getCourseNotInstructorBy(User instructor) {
		return courseRepository.findByInstructorNot(instructor);
	}

	public List<Course> getCoursesEnrolledByStudent(User student) {
		return courseRepository.findAllByStudents(student);
	}

	public List<Course> getCoursesNotEnrolledByStudent(User student) {
		return courseRepository.findByStudentsNotContains(student);
	}

	public void addStudent(Course course, User student, BindingResult result) {
		List<User> students = course.getStudents();
		if (!students.contains(student)) {
			students.add(student);
			course.setStudents(students);
			courseRepository.save(course);
		} else {
			result.rejectValue("course", "existingStudent", "Student have already enrolled this course!");
		}
	}
}