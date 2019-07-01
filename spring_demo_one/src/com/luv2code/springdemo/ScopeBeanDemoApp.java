package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeBeanDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", TennisCoach.class);
		
		Coach otherCoach = context.getBean("myCoach", TennisCoach.class);
		
		boolean result = (theCoach == otherCoach);
		
		System.out.println("Are the same reference? " + result);
		
		System.out.println("\ntheCoach: " + theCoach);
		System.out.println("otherCoach: " + otherCoach);
		
		context.close();
	}

}
