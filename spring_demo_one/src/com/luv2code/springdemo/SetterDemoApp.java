package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	
	public static void main(String args[]) {
		
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
		
		// use the methods
		System.out.println(cricketCoach.getDailyWorkout());
		
		System.out.println(cricketCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
