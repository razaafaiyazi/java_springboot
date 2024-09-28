package com.bloggingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //enabling only Basic authentication
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((authorize)->{
                    /*COMMENTED BELOW CODES TO ENABLE METHOD LEVEL AUTHORIZATION*/
                    //role based authorization
         //           authorize.requestMatchers(HttpMethod.POST,"/api/posts/**").hasAnyRole("ADMIN","USER");
         //           authorize.requestMatchers(HttpMethod.PUT,"/api/posts/**").hasRole("ADMIN");
         //           authorize.requestMatchers(HttpMethod.DELETE,"/api/posts/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET,"/api/posts/**").permitAll();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }
    // In-memory authentication
    @Bean
    UserDetailsService userDetailsService(){
        UserDetails razaa = User.builder()
                .username("razaa")
                .password(this.passwordEncoder().encode("razaa"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(this.passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(razaa,admin);
    }
}
