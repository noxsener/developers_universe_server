package com.codenfast.developersuniverse.user.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {

    private final JwtEncoder encoder;

    public String generateToken(HttpServletRequest httpServletRequest,  Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();
        String issuer = StringUtils.isNotBlank(httpServletRequest.getHeader("Referer")) ?
                httpServletRequest.getHeader("Referer")
                : httpServletRequest.getHeader("Host");
        JwtClaimsSet.Builder builder = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope);

        if (StringUtils.isNotBlank(issuer) && !issuer.matches(".*((127\\.0\\.0\\.1)|(192\\.168\\.)|(localhost)).*")) {
            builder.issuer(issuer);
        }

        JwtClaimsSet jwtClaimsSet = builder.build();
        return this.encoder.encode(JwtEncoderParameters.from(jwsHeader,jwtClaimsSet)).getTokenValue();
    }

}
