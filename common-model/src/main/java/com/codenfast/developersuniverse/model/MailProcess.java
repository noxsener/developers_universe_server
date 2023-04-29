package com.codenfast.developersuniverse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailProcess {
    /*Mail Session Properties*/
    private String username;
    private char[] password;
    private boolean isTLSEnabled;
    private String smtpHost;
    private int smtpPort;
    private String trustCertificate;

    /*Mail Info*/
    private List<String> toList;
    private List<String> ccList;
    private List<String> bccList;
    private String subject;
    private String htmlContent;
    private List<FileByte> attachments;
}
