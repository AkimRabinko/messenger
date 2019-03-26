package com.example.messenger.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select USERNAME, ROLE from EMPLOYEE where USERNAME=?")
                .usersByUsernameQuery("select USERNAME, PASSWORD, 1 as enabled  from EMPLOYEE where USERNAME=?");
    }
}
