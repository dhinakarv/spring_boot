package com.spring.cruddemo.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.beans.BeanProperty;

@Configuration
public class DemoSecurityConfiguration {

    //Add support to jdbc based credentials
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "magic-api/resources").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "magic-api/resources/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.PUT, "magic-api/resources/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "magic-api/resources").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "magic-api/resources/**").hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults());

        //Disable CSRF - its not requred for stateless calls: PUT, POST, DELETE, GET.Cross-site request forgery (CSRF) is a web security vulnerability
        // that allows an attacker to trick a user into performing actions they don't intend to do. CSRF attacks happen when an attacker's website,
        // blog, email, or other web application
        // causes a user's browser to perform an unwanted action on a trusted site where the user is already authenticated.
        http.csrf(csrf-> csrf.disable());
        return http.build();
    }
    //Hardcoded credentials
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails dhina = (User.builder().
                username("dhina").password("{noop}dhina")
                .roles("ADMIN").build());

        UserDetails gayu = (User.builder().
                username("gayu").password("{noop}gayu")
                .roles("MANAGER").build());

        UserDetails dhiya = (User.builder().
                username("dhiya").password("{noop}dhiya")
                .roles("EMPLOYEE").build());
        return new InMemoryUserDetailsManager(dhina,gayu,dhiya);
    }*/
}
