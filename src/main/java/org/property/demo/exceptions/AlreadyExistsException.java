package org.property.demo.exceptions;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(final String msg) {
        super(msg);
    }

    public AlreadyExistsException(final String msg, final Throwable e) {
        super(msg, e);
    }
}
