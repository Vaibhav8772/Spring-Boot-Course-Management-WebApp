package com.chatnlt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chatnlt.entities.Course;
import com.chatnlt.entities.User;
import com.chatnlt.helper.Message;
import com.chatnlt.repository.UserRepository;
import com.chatnlt.service.CourseService;
import com.chatnlt.service.TestimonialService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private CourseService courseService;

    @Autowired
    private TestimonialService testimonialService;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("testimonials", testimonialService.getAllTestimonials());
        return "home";
    }

    @GetMapping("/course/{id}")
    public String courseDetails(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourse(id));
        return "course-detail";
    }
	
    
    @GetMapping("/about")
    public String aboutus() {
        return "about";
    }
    
	
	
    @RequestMapping(path="/signup")
	public String signUpPage(Model model) {
		
		
		model.addAttribute("user",new User());
		return "sign-up";
		}
	
	
	
	 @RequestMapping(value = "/do_register", method = RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user,
	                               BindingResult result,
	                               @RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement,
	                               Model model,
	                               HttpSession session) {
	        try {
	            if (!aggrement) {
	                session.setAttribute("message", new Message("Please accept terms and conditions", "alert-danger"));
	                model.addAttribute("user", user);
	                return "sign-up";
	            }

	            if (result.hasErrors()) {
	                model.addAttribute("user", user);
	                return "sign-up";
	            }

	            // Save user
	            user.setRole("USER");
	            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	            userRepository.save(user);
	            session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
	            model.addAttribute("user", new User());
	            return "sign-up";
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.setAttribute("message", new Message("Something went wrong Please All Fields Are Required " , "alert-danger"));
	            model.addAttribute("user", user);
	            return "sign-up";
	        }
	    }
	 
	 
	 
	 
	 
	 @RequestMapping("/signin")
	 public String customLogin(Model model) {
		 
		 model.addAttribute("title","Login Page");
		 return "login";
	 }
	 
	 
	 @GetMapping("/courses")
	    public String showCourseForm(Model model) {
	        model.addAttribute("courseEnquiry", new Course());

	        // Add dropdown values
	        List<String> courseOptions = Arrays.asList("Crash Course", "Full Year Course", "Weekend Batch", "Online Batch");
	        model.addAttribute("courseOptions", courseOptions);

	        return "courses";
	    }

	    @PostMapping("/submit-course")
	    public String submitCourseForm(@Valid @ModelAttribute("courseEnquiry") Course course,
	                                   BindingResult result,
	                                   RedirectAttributes redirectAttributes,
	                                   Model model) {
	        if (result.hasErrors()) {
	            // In case of error, re-add the course options for dropdown
	            model.addAttribute("courseOptions", Arrays.asList("Crash Course", "Full Year Course", "Weekend Batch", "Online Batch"));
	            return "courses";
	        }

	        courseService.addCourse(course);
	        redirectAttributes.addFlashAttribute("message", "Enquiry submitted successfully!");
	        return "redirect:/courses";
	    }
	 
	 
	 
	 
	 
	 
	}
	
	
	

