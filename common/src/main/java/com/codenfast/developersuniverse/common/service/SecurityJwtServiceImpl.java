package com.codenfast.developersuniverse.common.service;

import com.codenfast.developersuniverse.common.entity.user.User;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@Data
@RequiredArgsConstructor
public class SecurityJwtServiceImpl implements SecurityJwtService {
    private static final char[] someInfo = {'d', '8', '5', 'f', 'b', 'd', '9', 'c', 'f', 'f', 'c', '1'};
    private final ObjectMapper objectMapper;

    private String doHMACSHA256(String part1AndPart2, String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secretKey.getBytes(), "HS256"));
        byte[] hashBytes = mac.doFinal(part1AndPart2.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    @Override
    public boolean validateJwt(String jwt) {
        try {
            if (StringUtils.isBlank(jwt)) {
                return Boolean.FALSE;
            }
            String[] parts = jwt.split("\\.");


            String part3 = parts[2];
            String part1Part2 = parts[0] + "." + parts[1];
            String jwtSignature = Base64.getEncoder().encodeToString(
                    (doHMACSHA256(part1Part2, new String(someInfo))).getBytes(StandardCharsets.UTF_8));
            return jwtSignature.equals(part3);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean validateJwtUser(String jwt) {
        try {
            if (StringUtils.isBlank(jwt)) {
                return Boolean.FALSE;
            }
            String[] parts = jwt.split("\\.");

            String part2 = new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                    StandardCharsets.UTF_8);
            User user = new ObjectMapper().readValue(part2, User.class);
            if (user.getLastTokenTime().isBefore(LocalDateTime.now())) {
                return Boolean.FALSE;
            }
            String part3 = parts[2];
            String part1Part2 = parts[0] + "." + parts[1];
            String jwtSignature = Base64.getEncoder().encodeToString(
                    (doHMACSHA256(part1Part2, new String(someInfo))).getBytes(StandardCharsets.UTF_8));
            return jwtSignature.equals(part3);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public String generateJwt(String payload) throws CodenfastException {
        try {
            String header = "{\"alg\": \"HS256\", \"typ\": \"JWT\"}";
            String part1 = Base64.getEncoder().encodeToString(header.getBytes(StandardCharsets.UTF_8));
            String part2 = Base64.getEncoder().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
            String part1Part2 = part1 + "." + part2;
            String part3 = Base64.getEncoder().encodeToString(
                    (doHMACSHA256(part1Part2, new String(someInfo))).getBytes(StandardCharsets.UTF_8));
            return part1Part2 + "." + part3;
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new CodenfastException(e);
        }
    }

    @Override
    public String getValueFromJWT(String jwt) {
        String[] parts = jwt.split("\\.");
        return new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                StandardCharsets.UTF_8);
    }

    public User getUserFromJWT(String token) throws CodenfastException {
        if (token == null) {
            return null;
        }
        String[] parts = token.split("\\.");
        String part2 = new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                StandardCharsets.UTF_8);
        try {
            return objectMapper.readValue(part2, User.class);
        } catch (JsonProcessingException e) {
            throw new CodenfastException(e);
        }
    }
}
