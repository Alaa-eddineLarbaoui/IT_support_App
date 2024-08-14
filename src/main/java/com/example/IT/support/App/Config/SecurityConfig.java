package com.example.IT.support.App.Config;

import com.example.IT.support.App.Enum.Erole;
import com.example.IT.support.App.Repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private PersoneRepository personeRepository;


    @Bean
    UserDetailsService userDetailsService() {
        return personeRepository::findByUsername;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filtercjain///////////");

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
//                                .requestMatchers("/api/auth/signup").hasRole(String.valueOf(Erole.ADMIN))
//                                .requestMatchers("/api/auth/login").permitAll()
//                                .requestMatchers("/api/user/**").hasRole(String.valueOf(Erole.ADMIN))
//                                .requestMatchers("/api/equipement/**").hasRole(String.valueOf(Erole.ADMIN))
//                                .requestMatchers("/api/panne/**").hasRole(String.valueOf(Erole.ADMIN))
//                                .requestMatchers(POST,"/tech/**").hasRole(String.valueOf(Erole.TECHNICIEN))
//                                .requestMatchers("/swagger-ui/**").permitAll()
//                                .requestMatchers("v3/api-docs/**").permitAll()


//                                .anyRequest().authenticated()
                               .anyRequest().permitAll()


                );

        http.cors(Customizer.withDefaults());
        http.addFilterBefore(new JwtAuthorizationFilter(userDetailsService()), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        System.out.println("///////////athhmanager");
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}