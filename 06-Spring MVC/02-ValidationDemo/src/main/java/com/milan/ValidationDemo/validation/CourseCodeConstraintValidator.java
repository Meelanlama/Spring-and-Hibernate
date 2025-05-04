package com.milan.ValidationDemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCodePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        courseCodePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        //This checks if theCode starts with the prefix stored in the courseCodePrefix variable.
        // If it does, result will be set to true; otherwise, it will be set to false.
        //If theCode is null, it sets result = true, implying that a null value is considered valid, and the validation passes.

        // If theCode is null or an empty string, consider it valid.
        if (theCode == null || theCode.isEmpty()) {
            result = true;
        } else {
            // Check if theCode starts with the courseCodePrefix
            result = theCode.startsWith(courseCodePrefix);
        }

        return result;
    }
}
