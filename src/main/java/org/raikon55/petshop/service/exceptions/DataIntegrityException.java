package org.raikon55.petshop.service.exceptions;

public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 8542992883578746817L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
