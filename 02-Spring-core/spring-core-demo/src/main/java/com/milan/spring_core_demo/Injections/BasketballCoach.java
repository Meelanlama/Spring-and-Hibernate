package com.milan.spring_core_demo.Injections;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BasketballCoach implements Coach {

    public BasketballCoach() {
        System.out.println("Inside BasketballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice 3 pointers for 15 minutes";
    }
}
