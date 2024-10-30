package com.dss.springcoredemo.common.impl;

import com.dss.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
