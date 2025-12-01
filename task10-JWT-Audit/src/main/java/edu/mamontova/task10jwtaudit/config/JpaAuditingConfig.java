package edu.mamontova.task10jwtaudit.config;/*
  @author tanus
  @project task10-JWT-Audit
  @class JpaAuditingConfig
  @version 1.0.0
  @since 28.11.2025 - 21.55
*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}