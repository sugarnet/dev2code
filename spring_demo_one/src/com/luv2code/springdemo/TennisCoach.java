package com.luv2code.springdemo;

public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practica el saque por veinte minutos!!!";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
