package com.dss.springcoredemo.common.impl;

import com.dss.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
