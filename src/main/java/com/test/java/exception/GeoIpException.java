package com.test.java.exception;

public class GeoIpException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "Cannot get up %s with name=%s";

    public GeoIpException(Class<?> entityClass, Object name) {
        super(String.format(MESSAGE_TEMPLATE, entityClass.getSimpleName(), name));
    }
}
