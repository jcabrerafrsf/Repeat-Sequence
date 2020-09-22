package com.possumus.repeatsequence.util;

/**
 * Class for managing the Business Exception.
 * @author jcabrera
 */
public class BusinessException extends Exception {
    public BusinessException(String mensaje) {
        super(mensaje);
    }
}
