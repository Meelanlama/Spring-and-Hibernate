package com.milan.ValidationDemo.model;

import com.milan.ValidationDemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "Must be greater than or Equal to 0")
    @Max(value = 10, message = "Must be less than or Equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^$|^[a-zA-Z0-9]{5}$", message = "Must be exactly 5 characters/digits or empty")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
