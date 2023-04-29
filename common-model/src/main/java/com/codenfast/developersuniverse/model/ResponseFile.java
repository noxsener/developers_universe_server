package com.codenfast.developersuniverse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {
    private String fileName;
    private String mimeType;

    public ResponseFile(File file) throws IOException {
        this.fileName = file.getName();
        this.mimeType = new Tika().detect(file);
    }
}
