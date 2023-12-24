package com.codingdojo.beltexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
//		if (loggedInUser == null) {
//			session.invalidate();
//			return "redirect:/logout"; // Redirect to your login page
//		}
		model.addAttribute("userName", loggedInUser.getUserName());
		model.addAttribute("userId", loggedInUser.getId());
		model.addAttribute("courses", courseServ.getAllCourse());

		return "dash.jsp";
	}

	@GetMapping("/classes/new")
	public String newCourse(@ModelAttribute("newCourse") Course newCourse, HttpSession session) {
		return "new.jsp";
	}

	@PostMapping("/saveNewCourse")
	public String saveNewCourse(@Valid @ModelAttribute("newCourse") Course newCourse, BindingResult result,
			HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
//				if (loggedInUser == null) {
//					session.invalidate();
//					return "redirect:/logout"; // Redirect to your login page
//				}
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
//		if (loggedInUser == null) {
//			session.invalidate();
//			return "redirect:/logout"; // Redirect to your login page
//		}

		model.addAttribute("editCourse", courseServ.getCourseById(id));
		return "edit.jsp";
	}

	@PostMapping("/saveEditCourse")
	public String saveEditCourse(@Valid @ModelAttribute("editCourse") Course editCourse, BindingResult result,
			HttpSession session, Model model) {
		// Check session
		User loggedInUser = (User) session.getAttribute("user_session");
//				if (loggedInUser == null) {
//					session.invalidate();
//					return "redirect:/logout"; // Redirect to your login page
//				}

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
		courseServ.deleteCourse(id);
		return "redirect:/classes";
	}

	@GetMapping("/classes/{id}")
	public String showCourse(@PathVariable("id") Long id, 
			HttpSession session, Model model) {
		model.addAttribute("course", courseServ.getCourseById(id));
		// Initialise Student obj
		User newStudent = new User();
		newStudent.setPassword("student");
		newStudent.setConfirmPW("student");
		model.addAttribute("newStudent", newStudent);
		return "show.jsp";
	}

	
	@PostMapping("/saveNewStudent/{course_id}")
	public String createNewStudent(@PathVariable("course_id") Long course_id,
			@Valid @ModelAttribute("newStudent") User newStudent, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("course", courseServ.getCourseById(course_id));
			model.addAttribute("newStudent", newStudent);
			return "show.jsp";
		} else {
			// save student
//			newStudent.setPassword("student");
//			newStudent.setConfirmPW("student");
			User student = userServ.createUser(newStudent);
			Course course = courseServ.getCourseById(course_id);
			courseServ.addStudent(course, student, result);
			return "redirect:/classes/" + course_id;
		}
	}

	@PostMapping("/enrollStudent")
	public String enrollStudentToCourse() {
		return "redirect:/show";
	}

//	@GetMapping("/new")
//	public String newCelebrity(@ModelAttribute("newCelebrity") Course newCelebrity, BindingResult result,
//			HttpSession session) {
//		// Check session else logout
//		User loggedInUser = (User) session.getAttribute("user_session");
//		if (loggedInUser == null) {
//			session.invalidate();
//			return "redirect:/logout"; // Redirect to your login page
//		}
//		return "new.jsp";
//	}
//
//	@PostMapping("/saveNawCelebrity")
//	public String saveNewCelebrity(
//	@ModelAttribute("newCelebrity") Course newCelebrity, 
//	BindingResult result,HttpSession session) {
//		// Check session else logout
//		User loggedInUser = (User) session.getAttribute("user_session");
//		if (loggedInUser == null) {
//			session.invalidate();
//			return "redirect:/logout"; // Redirect to your login page
//		}
//		// User is logged in, proceed with saving the new celebrity
//		newCelebrity.setOwner(loggedInUser);
//		clbServ.createCelebrity(newCelebrity);
//		return "redirect:/dash";
//	}
//
//	@GetMapping("/show")
//	public String show() {
//	return"show.jsp";
//	}
////	@GetMapping("/show/{id}")
//	public String showCelebrity(@PathVariable("id")Long id, 
//	HttpSession session, Model model) {
//		// Check session else logout
//				User loggedInUser = (User) session.getAttribute("user_session");
//				if (loggedInUser == null) {
//					session.invalidate();
//					return "redirect:/logout"; // Redirect to your login page
//				}
//		// show celebrity
//			model.addAttribute("celebrity", clbServ.getCelebrityById(id));			
//		return "show.jsp";
//	}
//	
//	@PostMapping("/follow/celbrities/{clb_id}")
//	public String addFollower(
//			@PathVariable("clb_id")Long clb_id,  
//			HttpSession session) {
//		// Check session else logout
//		User loggedInUser = (User) session.getAttribute("user_session");
//		if (loggedInUser == null) {
//			session.invalidate();
//			return "redirect:/logout"; // Redirect to your login page
//		}
//		Course celebrity = clbServ.getCelebrityById(clb_id);
//	    clbServ.addFollower(celebrity,loggedInUser );
//	return "redirect:/dash";
//	}
//
//	@GetMapping("/edit")
//	public String editCelebrity() {
//		return "edit.jsp";
//	}

}
