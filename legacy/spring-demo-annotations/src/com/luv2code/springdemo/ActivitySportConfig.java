package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitySportConfig {
	
	@Bean
	public FortuneService fortuneService() {
		return new LionFortuneService();
	}
	
	@Bean
	public Coach soccerCoach() {
		return new SoccerCoach(this.fortuneService());
	}

}
