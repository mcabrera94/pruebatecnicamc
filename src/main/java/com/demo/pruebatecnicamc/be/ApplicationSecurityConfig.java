package com.demo.pruebatecnicamc.be;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String name;

    @Value("${spring.security.user.password}")
    private String password;

    @Value("${spring.security.user.roles}")
    private String roles;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/user/createuser").hasRole(roles)
            .antMatchers("/user/deleteUserByEmail").hasRole(roles)
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
         authentication.inMemoryAuthentication()
                .withUser(name)
                .password(passwordEncoder().encode(password))
                .roles(roles);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
    "/user/getUserByEmail",
                "/user/getusers",
                "/search/getParam");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
