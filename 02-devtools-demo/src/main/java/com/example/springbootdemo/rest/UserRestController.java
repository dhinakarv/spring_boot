package com.example.springbootdemo.rest;

import com.example.springbootdemo.config.AppConfigReader;
import com.example.springbootdemo.service.Coach;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@EnableConfigurationProperties
@PropertySource(value ="classpath:application.properties")
public class UserRestController {


    @Autowired
    private AppConfigReader appConfigReader;

    private Coach coach;

    private Coach anotherCoach;
    @Autowired
    UserRestController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Constructor******************:"+theCoach.getClass().getSimpleName());
        coach = theCoach;
    }

    @Autowired
    public void setCoach(@Qualifier("swimCoach") Coach theCoach, @Qualifier("swimCoach") Coach theAnotherCoach
                    ){
        System.out.println("In Setter********************:"+theCoach.getClass().getSimpleName());
        coach =  theCoach;
        anotherCoach = theAnotherCoach;
    }
    @GetMapping("/logins")
    public ResponseEntity login(){
        System.out.println("Welcome:"+appConfigReader.getNationality());
        return new ResponseEntity("Welcome to Login Page.."+appConfigReader.getNationality() , HttpStatus.OK);
    }

    @GetMapping("/welcome")
    public ResponseEntity welcome(){
        String user = appConfigReader.getNationality();
        return new ResponseEntity("Welcome to the Home Page: "+user, HttpStatus.OK);
    }

    //expose endpoint for workout
    @GetMapping("/daily")
    public String getDailyWorkout(){
        return coach.dailyWorkOut();
    }

    @GetMapping("/weekly")
    public String getWeeklyWorkout(){
        return "Run 25k Miles";
    }

    @Value("${team.name}")
    private String teamName;
    @GetMapping("/testProperties")
    public String getTeamAndCoachName(){
        return "Team Name:"+teamName;
    }

    @GetMapping("/check")
    public String checkBeanScope(){
        return "Swim Coach are same?;"+(anotherCoach==coach);
    }
}
