package com.barberia.citaShow.config;

import com.barberia.citaShow.services.LoginImpl;
import com.barberia.citaShow.util.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig   {

    private  JwtFilter jwtFilter;
    @Autowired
    public  SecurityConfig (JwtFilter jwtFilter){
        this.jwtFilter = jwtFilter;
    }
    @Autowired
    private LoginImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       /* http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/**").permitAll(). anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();*/
       http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessiones->sessiones.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                . authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/auth/**").permitAll()
                       .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)      ;
        return http.build();
    }

    //@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws  Exception{
        return  configuration.getAuthenticationManager();
    }





}
