package com.dss.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWork() {
		return "Practice in the brick dust field";
	}

}
