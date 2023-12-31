package com.codingdojo.beltexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.beltexam.models.Course;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.CourseService;
import com.codingdojo.beltexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private UserService userServ;

	@Autowired
	private CourseService courseServ;

	@GetMapping("/classes")
	public String home(HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}
		model.addAttribute("userName", loggedInUser.getUserName());
		model.addAttribute("userId", loggedInUser.getId());
		model.addAttribute("courses", courseServ.getAllCourse());

		return "dash.jsp";
	}

	@GetMapping("/classes/new")
	public String newCourse(@ModelAttribute("newCourse") Course newCourse, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}
		return "new.jsp";
	}

	@PostMapping("/saveNewCourse")
	public String saveNewCourse(@Valid @ModelAttribute("newCourse") Course newCourse, BindingResult result,
			HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}
		if (result.hasErrors()) {
			model.addAttribute("newCourse", newCourse);
			return "new.jsp";
		} else {
			newCourse.setInstructor(loggedInUser);
			courseServ.createCourse(newCourse);
			return "redirect:/classes";
		}
	}

	@GetMapping("/classes/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, @ModelAttribute("editCourse") Course editCourse,
			HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}

		model.addAttribute("editCourse", courseServ.getCourseById(id));
		return "edit.jsp";
	}

	@PostMapping("/saveEditCourse")
	public String saveEditCourse(@Valid @ModelAttribute("editCourse") Course editCourse, BindingResult result,
			HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}

		if (result.hasErrors()) {
			model.addAttribute("editCourse", editCourse);
			return "edit.jsp";
		} else {
			editCourse.setInstructor(loggedInUser);
			courseServ.updateCourse(editCourse);
			return "redirect:/classes";
		}
	}

	@GetMapping("/classes/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long id, HttpSession session) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}
		courseServ.deleteCourse(id);
		return "redirect:/classes";
	}

	@GetMapping("/classes/{id}")
	public String showCourse(@PathVariable("id") Long id, HttpSession session, Model model) {

		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}

		Course myCourse = courseServ.getCourseById(id);
		model.addAttribute("course", courseServ.getCourseById(id));
		model.addAttribute("notEnrolledStudents", userServ.getStudentNotEnrolledCourse(myCourse));
		// Initialise Student obj
		User newStudent = new User();
		newStudent.setPassword("student");
		newStudent.setConfirmPW("student");
		model.addAttribute("newStudent", newStudent);

		return "show.jsp";
	}

	@PostMapping("/saveNewStudent/{course_id}")
	public String createNewStudent(@PathVariable("course_id") Long course_id,
			@Valid @ModelAttribute("newStudent") User newStudent, BindingResult result, HttpSession session,
			Model model) {

		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}

		if (result.hasErrors()) {
			model.addAttribute("course", courseServ.getCourseById(course_id));
			model.addAttribute("newStudent", newStudent);
			return "show.jsp";
		} else {
			// save student
			User student = userServ.createUser(newStudent);
			Course course = courseServ.getCourseById(course_id);
			courseServ.addStudent(course, student);
			return "redirect:/classes/" + course_id;
		}
	}

	@PostMapping("/enrollStudent/{course_id}")
	public String enrollStudentToCourse(@PathVariable("course_id") Long course_id,
			@RequestParam("student_id") Long student_id, HttpSession session) {

		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
		if (loggedInUser == null) {
			session.invalidate();
			return "redirect:/logout"; // Redirect to your login page
		}

		User student = userServ.getUserById(student_id);
		Course course = courseServ.getCourseById(course_id);
		courseServ.addStudent(course, student);
		return "redirect:/classes/" + course_id;
	}

}
