package com.possumus.repeatsequence.util;

/**
 * Class for managing the Errors parser.
 * @author jcabrera
 */
public class ExcepcionParser {
    public static Throwable getRootException(Throwable exception) {
        Throwable rootException = exception;
        while (rootException.getCause() != null) {
            rootException = rootException.getCause();
        }
        return rootException;
    }
}
