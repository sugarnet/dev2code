package com.dss.springcoredemo.rest;

import com.dss.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;
    private final Coach myAnotherCoach;

    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach myAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.myAnotherCoach = myAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: " + (myCoach == myAnotherCoach);
    }
}
