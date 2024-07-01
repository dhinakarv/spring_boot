package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class SpringbootdemoApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringbootdemoApplication.class, args);
        System.out.println("Spring boot started");
    }

}
