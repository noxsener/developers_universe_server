package com.codenfast.developersuniverse.service;

import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
@RequiredArgsConstructor
public class EncryptServiceImpl implements EncryptService {

    private final ObjectMapper objectMapper;

    private static final byte[] KEY = "4bc2059c4cf54aca96e4413a93a0fdsq".getBytes(StandardCharsets.UTF_8);
    private static final SecretKeySpec SECRET = new SecretKeySpec(KEY, "AES");
    private static final String ALGORITHM = "AES/CTR/PKCS7Padding";

    @SuppressWarnings("java:S3329") // Already random iv
    private String encrypt(String data, String inputValue) throws CodenfastSecurityException {
        if (StringUtils.isBlank(data) && StringUtils.isBlank(inputValue)) {
            throw new CodenfastSecurityException();
        }
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
            byte[] iv = (data + '0' + data.substring(data.length() - 2)).getBytes(StandardCharsets.UTF_8);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET, ivSpec);
            byte[] plaintext = inputValue.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = cipher.doFinal(plaintext);
            return Base64.getEncoder().encodeToString(ciphertext);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Encrypt data is corrupted: {}", e.getMessage(), e);
        } catch (IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException | InvalidAlgorithmParameterException e) {
            log.error("Cryption isn't valid: {}", e.getMessage(), e);
        }
        throw new CodenfastSecurityException();
    }

    private String decrypt(String data, String inputValue) throws CodenfastSecurityException {
        if (StringUtils.isBlank(data) && StringUtils.isBlank(inputValue)) {
            throw new CodenfastSecurityException();
        }
        try {
            byte[] dataInBytes = Base64.getDecoder().decode(inputValue);
            Cipher cipher = Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());
            byte[] iv = (data + '0' + data.substring(data.length() - 2)).getBytes(StandardCharsets.UTF_8);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, SECRET, ivSpec);
            byte[] decryptedBytes = cipher.doFinal(dataInBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Encrypt data is corrupted: {}", e.getMessage(), e);
        } catch (IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException | InvalidAlgorithmParameterException e) {
            log.error("Cryption isn't valid: {}", e.getMessage(), e);
        }
        throw new CodenfastSecurityException();
    }

    public <T> T readValue(String data, String content, Class<T> valueType) throws JsonProcessingException, CodenfastSecurityException {
        return objectMapper.readValue(decrypt(data, content), valueType);
    }

    public String writeValue(String data, Object content) throws JsonProcessingException, CodenfastSecurityException {
        return encrypt(data, objectMapper.writeValueAsString(content));
    }
}
