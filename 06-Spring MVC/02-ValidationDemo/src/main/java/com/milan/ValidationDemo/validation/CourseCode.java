package com.milan.ValidationDemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    public String value() default "LUV";

    //define default error message
    public String message() default "Invalid Course Code, Must start with LUV";

    //define default groups
    public Class<?>[] groups() default {};

    //defile default payloads
    public Class<? extends Payload>[] payload() default {};
}
