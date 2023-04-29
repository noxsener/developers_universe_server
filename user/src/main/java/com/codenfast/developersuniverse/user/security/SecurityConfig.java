package com.codenfast.developersuniverse.user.security;

import com.codenfast.developersuniverse.user.service.UserService;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableMethodSecurity

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final UserService userService;
    private final byte[] scrt2 = "1b5ce5df".getBytes();
    private final byte[] scrt4 = "10bb".getBytes();
    private final byte[] scrt5 = "4043".getBytes();
    private final byte[] scrt1 = "a8e0".getBytes();
    private final byte[] scrt3 = "d4a693bff56a".getBytes();

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.cors().and()
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.TRACE).denyAll()
                        .requestMatchers("/api/user/login").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(userService)
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        SecretKey key = new SecretKeySpec(ByteBuffer
                .allocate(scrt1.length + scrt2.length + scrt3.length + scrt4.length + scrt5.length)
                .put(scrt2).put(scrt4).put(scrt5).put(scrt1).put(scrt3)
                .array(), "HmacSHA256");
        return new NimbusJwtEncoder(new ImmutableSecret<>(key));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey originalKey = new SecretKeySpec(ByteBuffer
                .allocate(scrt1.length + scrt2.length + scrt3.length + scrt4.length + scrt5.length)
                .put(scrt2).put(scrt4).put(scrt5).put(scrt1).put(scrt3)
                .array(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(originalKey).build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*", "https://*.*.*", "http://*.*.*", "*.*", "http://localhost:*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("Content-type");
        allowedHeaders.add("x-auth-token");
        allowedHeaders.add("x-xsrf-token");
        allowedHeaders.add("Content-Disposition");
        allowedHeaders.add("Origin");
        allowedHeaders.add("Access-Control-Request-Method");
        allowedHeaders.add("Access-Control-Request-Headers");
        allowedHeaders.add("X-PINGOTHER");
        allowedHeaders.add("Cache-Control");
        allowedHeaders.add("Pragma");
        allowedHeaders.add("Expires");
        configuration.setAllowedHeaders(allowedHeaders);
        configuration.setExposedHeaders(Arrays.asList("x-auth-token", "x-xsrf-token", "xsrf-token", "Origin"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
