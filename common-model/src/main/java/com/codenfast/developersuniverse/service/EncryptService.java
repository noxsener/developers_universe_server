package com.codenfast.developersuniverse.service;

import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface EncryptService {
    <T> T readValue(String data, String content, Class<T> valueType) throws JsonProcessingException, CodenfastSecurityException;
    String writeValue(String data, Object content) throws JsonProcessingException, CodenfastSecurityException;
}
