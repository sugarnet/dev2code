package com.luv2code.springdemo;

public class PatoCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public PatoCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Monta el animal por media hora";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
