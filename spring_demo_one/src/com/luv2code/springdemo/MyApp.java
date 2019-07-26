package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {

		//creamos el objeto
		Coach theCoach = new TrackCoach();
		
		//usamos el objeto
		System.out.println(theCoach.getDailyWorkout());
	}

}
