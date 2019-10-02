package com.dss.springdemo.mvc;

import java.util.Arrays;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	// private LinkedHashMap<String, String> countries;
	private String favoriteLanguage;
	private String operatingSystems[];
	
	public Student() {
	
		/*
		this.countries = new LinkedHashMap<String, String>();
		this.countries.put("ARG", "Argentina");
		this.countries.put("BRA", "Brazil");
		this.countries.put("CHI", "Chile");
		this.countries.put("PAR", "Paraguay");
		*/
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	/*public LinkedHashMap<String, String> getCountries() {
		return countries;
	}*/

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", favoriteLanguage=" + favoriteLanguage + ", operatingSystems=" + Arrays.toString(operatingSystems)
				+ "]";
	}

	
}
