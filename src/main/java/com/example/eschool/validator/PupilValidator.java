package com.example.eschool.validator;

import com.example.eschool.model.Pupil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PupilValidator implements Validator {
	
	private Pattern pattern;  
	private Matcher matcher; 

	// Any UTF8 letter
	String STRING_PATTERN = "\\p{L}+"; 
	
    @Override
    public boolean supports(Class<?> aClass) {
        return Pupil.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pupil pupil = (Pupil) o;

        // First name and last name - at least 2, at most 32.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (pupil.getFirstName().length() < 2 || pupil.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.pupilForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (pupil.getLastName().length() < 2 || pupil.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.pupilForm.name");
        }

        // First name and last name - text only.
        if (!(pupil.getFirstName() != null && pupil.getFirstName().isEmpty())) {  
        	pattern = Pattern.compile(STRING_PATTERN);  
        	matcher = pattern.matcher(pupil.getFirstName());  
        	if (!matcher.matches()) {  
        		errors.rejectValue("firstName", "Text.pupilForm.firstName");  
        	}  
        }  

        if (!(pupil.getLastName() != null && pupil.getLastName().isEmpty())) {  
        	pattern = Pattern.compile(STRING_PATTERN);  
        	matcher = pattern.matcher(pupil.getLastName());  
        	if (!matcher.matches()) {  
        		errors.rejectValue("lastName", "Text.pupilForm.lastName");  
        	}  
        }  
        
    }
}
