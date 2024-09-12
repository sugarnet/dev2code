package com.luv2code.springdemo;

public class TennisCoach implements Coach {
	
	private String emailAddress;
	private String team;
	
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public void hacerAlInicio() {
		System.out.println("Desde hacerAlInicio()");
	}
	
	public void hacerAlFinal() {
		System.out.println("Desde hacerAlFinal()");
	}
	
}
