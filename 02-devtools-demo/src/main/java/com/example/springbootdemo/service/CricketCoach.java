package com.example.springbootdemo.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach{
    @Override
    public String dailyWorkOut(){
        return "Cricket Practice: Bowling for 50 mins";
    }
}
