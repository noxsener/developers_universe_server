package com.codenfast.developersuniverse.model;

import com.codenfast.developersuniverse.utils.StringConstant;

public class CodenfastException extends Exception {
    public CodenfastException() {
    }

    public CodenfastException(String message) {
        super(message);
    }

    public CodenfastException(String message, Throwable cause) {
        super(message, cause);
        cause.printStackTrace();
    }

    public CodenfastException(Throwable cause) {
        super(cause);
        cause.printStackTrace();
    }

    public static CodenfastException entityNotFound(Class<?> clazz, String id) {
       return new CodenfastException(String.format(StringConstant.DATA_NOT_FOUND, clazz.getName(), id));
    }
}
