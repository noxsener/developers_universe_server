package com.codenfast.developersuniverse.common.service;

import com.codenfast.developersuniverse.common.entity.user.User;
import com.codenfast.developersuniverse.model.CodenfastException;
import org.springframework.stereotype.Service;

@Service
public interface SecurityJwtService {
    boolean validateJwt(String token);

    boolean validateJwtUser(String token);

    String generateJwt(String payload) throws CodenfastException;

    String getValueFromJWT(String token);

    User getUserFromJWT(String token) throws CodenfastException;
}
