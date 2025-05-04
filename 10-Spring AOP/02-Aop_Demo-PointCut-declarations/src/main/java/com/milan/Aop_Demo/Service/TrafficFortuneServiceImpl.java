package com.milan.Aop_Demo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {

        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return a fortune
        return "Traffic will be less this morning";
    }

    @Override
    public String getFortune(boolean trip) {

        if(trip) {
            throw new RuntimeException("Highway is closed for 3 days");
        }

        return getFortune();
    }
}
