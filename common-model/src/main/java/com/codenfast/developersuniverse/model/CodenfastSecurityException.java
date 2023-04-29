package com.codenfast.developersuniverse.model;

import com.codenfast.developersuniverse.utils.StringConstant;

public class CodenfastSecurityException extends Exception {

    public CodenfastSecurityException() {
        super(StringConstant.SECURITY_EXCEPTION);
    }
}
