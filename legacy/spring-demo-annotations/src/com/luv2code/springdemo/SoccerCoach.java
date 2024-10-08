package com.luv2code.springdemo;

public class SoccerCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice shut!";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
