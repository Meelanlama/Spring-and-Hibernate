package com.milan.spring_core_demo.Injections;

public class GymCoach implements Coach {

    public GymCoach() {
        System.out.println("Inside GymCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Do 3 sets of chest workout 5 reps and weights";
    }
}
