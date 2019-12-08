package com.maxmayev.compservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web
        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
        .configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    @Bean
    public PasswordEncoder encoder(){
        return new StandardPasswordEncoder("maxmayev");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/order*","/delete*").hasRole("ADMIN").antMatchers("/","/**").access("permitAll")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/order",true)
        .and().logout().logoutSuccessUrl("/");
    }
}