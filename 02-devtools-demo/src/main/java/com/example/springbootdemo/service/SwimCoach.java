package com.example.springbootdemo.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        public class SwimCoach implements Coach{
    @Override
    public String dailyWorkOut() {
        return "Swim Practice: Swim should be for 50 mins";
    }
}
