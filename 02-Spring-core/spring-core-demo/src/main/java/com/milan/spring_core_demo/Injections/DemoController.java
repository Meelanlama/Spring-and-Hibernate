package com.milan.spring_core_demo.Injections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach myCoach2;

//    @Autowired
//    public DemoController(@Qualifier("myCricketCoach") Coach theCoach,@Qualifier("myCricketCoach") Coach theCoach2) {
//        this.myCoach = theCoach;
//        this.myCoach2 = theCoach2;
//    }

    @Autowired
    @Qualifier("myGymCoach")
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    //to check if prototype bean is same
    @GetMapping("/check")
    public String check() {
        return "Comparing prototype Beans if they are same : " + (myCoach == myCoach2);
    }
}
