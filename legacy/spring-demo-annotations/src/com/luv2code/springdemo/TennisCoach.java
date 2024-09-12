package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
// @Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("crazyFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("inside TennisCoach()");
	}
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice in the brick dust field";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setFortuneService(FortuneService fortuneService)");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("inside doSomeCrazyStuff(FortuneService fortuneService)");
		this.fortuneService = fortuneService;
	}
	*/

	@PostConstruct
	public void doPostConstructor() {
		System.out.println("TennisCoach -> doPostConstructor...");
	}
	
	@PreDestroy
	public void doPreDestroy() {
		System.out.println("TennisCoach -> doBeforeDestroy...");
	}
}
