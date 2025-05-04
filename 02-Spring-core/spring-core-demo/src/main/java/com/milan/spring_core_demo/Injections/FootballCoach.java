package com.milan.spring_core_demo.Injections;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component // defaultName will be : footballCoach
@Lazy
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("Inside FootballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice dribbling for 30 minutes";
    }
}