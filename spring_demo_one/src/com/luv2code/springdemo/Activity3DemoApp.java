package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Activity3DemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("activity3-applicationContext.xml");
		
		Coach c1 = context.getBean("myCoach", Coach.class);
		
		Coach c2 = context.getBean("myCoach", Coach.class);
		
		System.out.println("Son iguales? => " + (c1 == c2));
		
		System.out.println("c1: " + c1 );
		System.out.println("c2: " + c2 );
		
		System.out.println(c1.getDailyWorkout());
		System.out.println(c1.getDailyFortune());
		
		
		context.close();
	}

}
