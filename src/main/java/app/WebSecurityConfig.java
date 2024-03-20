package app;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import app.exception.CustomAccessDeniedHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import java.util.Collections;
import org.springframework.beans.factory.annotation.*;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig{
  
  
  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/","/home").permitAll()
                .requestMatchers("/","access-denied").permitAll()
                .requestMatchers("/","/book_register/***").hasRole("ADMIN")
                .requestMatchers("/","/deleteBook/***").hasRole("ADMIN")
                .requestMatchers("/","/editBook/***").hasRole("ADMIN")
               // .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .requestMatchers("/h2-console/**").permitAll() 
                .anyRequest().authenticated()
            )
             .exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()))
          // http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
             .logout((logout) -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/") 
                .permitAll()
            );
            
            //.logout((logout) -> logout.permitAll());

        return http.build();
    } 


@Bean
public AccessDeniedHandler accessDeniedHandler() {
   return new CustomAccessDeniedHandler();
}
}

