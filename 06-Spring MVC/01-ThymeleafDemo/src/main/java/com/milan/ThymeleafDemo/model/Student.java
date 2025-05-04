package com.milan.ThymeleafDemo.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favProgrammingLanguage;
    private List<String> favOS;

    public Student(){}

    public List<String> getFavOS() {
        return favOS;
    }

    public void setFavOS(List<String> favOS) {
        this.favOS = favOS;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavProgrammingLanguage() {
        return favProgrammingLanguage;
    }

    public void setFavProgrammingLanguage(String favProgrammingLanguage) {
        this.favProgrammingLanguage = favProgrammingLanguage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favProgrammingLanguage='" + favProgrammingLanguage + '\'' +
                ", favOS=" + favOS +
                '}';
    }
}
