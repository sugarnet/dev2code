package com.luv2code.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoy es tu d�a de suerte!!!";
	}

}
