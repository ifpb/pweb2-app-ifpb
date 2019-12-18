package br.com.ifpb.appifpb.alunoms.config.security;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("securityProperties")
@ConfigurationProperties(prefix="security")
@ToString
@Data
public class SecurityConfig {
    private String tokenType;
    private String secret;
    private String issuer;
    private String audience;
    private Long expiration;
}
