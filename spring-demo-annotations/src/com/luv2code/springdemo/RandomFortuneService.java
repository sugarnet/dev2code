package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String [] fortunes = {
			"text 1",
			"text 2",
			"text 3"
	};

	@Override
	public String getFortune() {
		Random random = new Random();
		return this.fortunes[random.nextInt(this.fortunes.length)];
	}

}
