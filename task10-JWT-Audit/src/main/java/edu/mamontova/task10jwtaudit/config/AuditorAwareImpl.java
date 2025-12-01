package edu.mamontova.task10jwtaudit.config;/*
  @author tanus
  @project task10-JWT-Audit
  @class AuditorAwareImpl
  @version 1.0.0
  @since 28.11.2025 - 21.55
*/


import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return Optional.of("system_or_anonymous");
        }

        return Optional.of(authentication.getName());
    }
}