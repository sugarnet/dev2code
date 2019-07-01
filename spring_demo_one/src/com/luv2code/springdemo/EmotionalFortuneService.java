package com.luv2code.springdemo;

public class EmotionalFortuneService implements FortuneService {

	private String emotions[];
	
	public EmotionalFortuneService() {
		this.emotions = new String[]{
				"I love this sport",
				"I need to play now",
				"Wow, is it very emotional!"
		};
	}
	
	@Override
	public String getFortune() {
		return this.emotions[getRandom()];
	}
	
	private int getRandom() {
		int leftLimit = 0;
	    int rightLimit = this.emotions.length-1;
	    
	    return (leftLimit + (int) (Math.random() * (rightLimit - leftLimit)));
	}

}
