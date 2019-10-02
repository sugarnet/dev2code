package com.dss.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// lecura desde archivo de propiedades
    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student student = new Student();
		
		// add student obtject to the model
		theModel.addAttribute("student", student);
		
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processFomr(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("The student: " + theStudent);
		
		return "student-confirmation";
	}
	
}
