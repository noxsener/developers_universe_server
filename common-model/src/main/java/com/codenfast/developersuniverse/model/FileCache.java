package com.codenfast.developersuniverse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileCache {
    private byte[] fileByte;
    private Map<String, List<String>> headers = new HashMap<>();

}
