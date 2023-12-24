package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.beltexam.models.Course;
import com.codingdojo.beltexam.models.LoginUser;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.repositories.CourseRepository;
import com.codingdojo.beltexam.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CourseRepository courseRepo;

	// Registration : create new user
	// validation : email does not exist in DB 
	// validation : ConfirmPW match Password 
	public User userRegistration(User user, BindingResult result) {
        validateUniqueEmail(user.getEmail(), result);
        validatePasswordConfirmation(user.getPassword(), user.getConfirmPW(), result);
        if (result.hasErrors()) {
            return null;
        }
        hashAndSavePassword(user);
        return userRepo.save(user);
    }
	
	// Login : find user by email
	// Validation : email do exist in DB
	// Validation : Check Password
	 public User userLogin(LoginUser user, BindingResult result) {
		    Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
		    if (!optionalUser.isPresent()) {
		        result.rejectValue("email", "emailNotExists", "This email does not exist.");
		    } else {
		        User existingUser = optionalUser.get();
		        if (!BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
		            result.rejectValue("password", "invalidPassword", "Invalid password.");
		        }
		    }
		    return result.hasErrors() ? null : optionalUser.orElse(null);
		}
    
	private void validateUniqueEmail(String email, BindingResult result) {
	    if (email != null) {
	        userRepo.findByEmail(email).ifPresent(existingUser ->
	                result.rejectValue("email", "emailExists", "This email already exists."));
	    }
	}

    private void validatePasswordConfirmation(String password, String confirmPW, BindingResult result) {
        if (!password.equals(confirmPW)) {
            result.rejectValue("confirmPW", "passwordMismatch", "Confirmation & Password should match.");
        }
    }

    private void hashAndSavePassword(User user) {
        String hashPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPW);
    }
	
// C R U D 
	
	 // Create
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Read
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // Update
    public User updateUser(User user) {
        // Check if the user with the given ID exists before updating (this doesn't concern updating user password)
        if (userRepo.existsById(user.getId())) {
            return userRepo.save(user);
        } else {         
            return null;
        }
    }

 	// Delete
    public void deleteUser(Long id) {
    	   Optional<User> optionalUser = userRepo.findById(id);

    	    if (optionalUser.isPresent()) {
    	        User user = optionalUser.get();

    	        // Remove relationships before deletion
    	        user.getInstructedCourses().clear();
    	        user.getEnrolledCourses().forEach(course -> course.getStudents().remove(user));

    	        // Delete the user
    	        userRepo.deleteById(id);
        }
    }

    // Other custom queries
    // OneToMany
    public List<User> getUsersByCourseOwner(Course course) {
        return userRepo.findAllByInstructedCourses(course);
    }
    public List<User> getUsersNotHavingCourseOwnsership(Course course) {
        return userRepo.findByInstructedCoursesNotContains(course);
    }
	//ManyToMany
    public List<User> getStudentNotEnrolledCourse(Course course) {
        return userRepo.findByEnrolledCoursesNotContains(course);
    }

    public List<User> getUsersFollowingCelebrity(Course course) {
        return userRepo.findAllByEnrolledCourses(course);
    }
    
    // delete association between follower and the celebrity
    //@Transactional, ensuring that the entire method's logic is executed within a single transaction.
    @Transactional
    public void deleteStudent(User student, Course course) {
        List<Course> enrolledCourses = student.getEnrolledCourses();
        List<User> students = course.getStudents();

        if (enrolledCourses != null && students != null) {
        	enrolledCourses.remove(course);
        	students.remove(student);
		
			student.setEnrolledCourses(enrolledCourses);
            userRepo.save(student);
            
            course.setStudents(students);
            courseRepo.save(course);
        }
    }
 		

}
