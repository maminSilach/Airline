package com.example.bookingofairtickets.Config;

import com.example.bookingofairtickets.Service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceImpl userDetailsService;
    private final CustomSuccessHandler successHandler;
    public WebSecurityConfig(UserDetailServiceImpl userDetailsService, CustomSuccessHandler customSuccessHandler){
        this.userDetailsService = userDetailsService;
        this.successHandler = customSuccessHandler;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/airline/", "/airline/registration", "/airline/login")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/airline/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/airline/login").successHandler(successHandler).and().
                logout().logoutUrl("/airline/logout").
                permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
