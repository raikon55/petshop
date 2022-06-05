package org.raikon55.petshop.service.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 8542992883578746817L;

    public ObjetoNaoEncontradoException(String msg) {
        super(msg);
    }

    public ObjetoNaoEncontradoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
