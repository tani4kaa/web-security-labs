package edu.mamontova.task10jwtaudit.security;/*
  @author tanus
  @project task10-JWT-Audit
  @class SecurityConfig
  @version 1.0.0
  @since 28.11.2025 - 21.56
*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Встановлюємо фіктивну аутентифікацію для тестування AuditorAwareImpl
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                "Professor_Gprohorov_audit_user", // Це ім'я буде в createdBy / lastModifiedBy
                null,
                null
        );
        SecurityContextHolder.getContext().setAuthentication(token);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll() // Дозволяємо всі запити
                );

        return http.build();
    }
}