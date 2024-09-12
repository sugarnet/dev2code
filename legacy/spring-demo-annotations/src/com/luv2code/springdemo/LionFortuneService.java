package com.luv2code.springdemo;

public class LionFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You are a Lion!!!";
	}

}
