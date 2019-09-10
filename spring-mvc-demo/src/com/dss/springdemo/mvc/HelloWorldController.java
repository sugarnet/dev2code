package com.dss.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String letShoutDudeVersion3(@RequestParam("studentName") String theName, Model model) {
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hello! from the version 3 my friend " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}

}
