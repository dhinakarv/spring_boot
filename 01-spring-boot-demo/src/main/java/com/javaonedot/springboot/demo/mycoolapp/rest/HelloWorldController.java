package com.javaonedot.springboot.demo.mycoolapp.rest;

import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    @GetMapping("/")
    public String sayHello(){
        return "Hi User, Welcome to my Cool App:"+coachName+":"+teamName;
    }
}
