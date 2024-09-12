package com.dss.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	// private String[] coursePrefixes;
	
	

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}



	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		if (theCode != null) {
			return theCode.startsWith(coursePrefix);
		}
		
		return true;
	}
	
	/*
		@Override
	    public boolean isValid(String theCode, 
	                        ConstraintValidatorContext theConstraintValidatorContext) {
	        boolean result = false;
	        
	        if (theCode != null) {
	            
	            //
	            // loop thru course prefixes
	            //
	            // check to see if code matches any of the course prefixes
	            //
	            for (String tempPrefix : coursePrefixes) {
	                result = theCode.startsWith(tempPrefix);
	                
	                // if we found a match then break out of the loop
	                if (result) {
	                    break;
	                }
	            }
	        }
	        else {
	            result = true;
	        }
	        
	        return result;
	  	}
	*/
	
}
