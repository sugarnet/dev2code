package com.dss.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	
	// read the configuration file
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	// get the bean
	Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
	
	// use the bean
	System.out.println(theC);
	
	// close the context

}
