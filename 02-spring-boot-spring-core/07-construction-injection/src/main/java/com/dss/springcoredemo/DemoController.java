package com.dss.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach cricketCoach;

    @Autowired // we use @Autowired on the constructor when we have more constructors. In this case is optional.
    public DemoController(Coach cricketCoach) {
        this.cricketCoach = cricketCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }
}
