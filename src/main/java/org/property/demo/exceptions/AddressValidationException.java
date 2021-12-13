package org.property.demo.exceptions;

public class AddressValidationException extends Exception {
    public AddressValidationException(final String msg) {
        super(msg);
    }

    public AddressValidationException(final String msg, final Throwable e) {
        super(msg, e);
    }
}
