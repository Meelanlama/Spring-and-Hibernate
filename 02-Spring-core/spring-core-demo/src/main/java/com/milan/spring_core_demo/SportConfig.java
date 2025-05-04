package com.milan.spring_core_demo;

import com.milan.spring_core_demo.Injections.Coach;
import com.milan.spring_core_demo.Injections.GymCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach myGymCoach() {
        return new GymCoach();
    }
}
