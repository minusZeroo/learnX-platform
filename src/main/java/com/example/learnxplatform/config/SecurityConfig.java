package com.example.learnxplatform.config;

import com.example.learnxplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService; // Autowire the UserService

    // Configure authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    // Configure HTTP security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF protection
                .authorizeRequests()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/users/login").permitAll()// Allow registration without authentication
                .antMatchers("/api/tutor-availabilities/**").permitAll()
                .antMatchers("/api/tutorial-requests/**").permitAll()
                .antMatchers("/api/tutorial-bookings/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // Enable HTTP Basic Authentication
    }

    // Configure password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Expose AuthenticationManager bean
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
