package com.codenfast.developersuniverse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ElectronicArchiveLoginModel {

    private static final String TYPE_FTP = "ftp";
    private static final String TYPE_GOOGLE_DRIVE = "google-drive";
    private static final String TYPE_ONE_DRIVE = "one-drive";

    private String type;

    private String username;
    private String password;
    private String url;
    private Integer port;
}
