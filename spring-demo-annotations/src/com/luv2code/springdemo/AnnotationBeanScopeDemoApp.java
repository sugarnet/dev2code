package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean areTheSame = ( theCoach == alphaCoach );
		
		System.out.println("Are the same? -> " + areTheSame);
		
		System.out.println("Reference theCoach: " + theCoach);
		
		System.out.println("Reference alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
