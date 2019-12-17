package br.com.ifpb.appifpb.alunoms.config.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="security")
@Data
public class SecurityConfig {
    private String tokenType;
    private String secret;
    private String issuer;
    private String audience;
    private Long expiration;
}
