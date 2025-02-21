package com.example.demo.Infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private Filtro filtro;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .csrf().disable()  // Desabilita CSRF para APIs stateless
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Sem sessões no lado do servidor
            .and()
            .authorizeHttpRequests()  // Substitui authorizeRequests() por authorizeHttpRequests()
            .requestMatchers("/aut").permitAll()  // Endpoints permitidos sem autenticação
            .anyRequest().authenticated() 
            .and()
            .addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class) // Todos os outros endpoints requerem autenticação
            
            .build();
}

    
    

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }
    
}