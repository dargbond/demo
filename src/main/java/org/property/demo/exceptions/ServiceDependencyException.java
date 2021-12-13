package org.property.demo.exceptions;

public class ServiceDependencyException extends Exception {
    public ServiceDependencyException(final String msg) {
        super(msg);
    }

    public ServiceDependencyException(final String msg, final Throwable e) {
        super(msg, e);
    }
}
