package com.test.java.exception;

public class NoAccessException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "Cannot access %s with name=%s";

    public NoAccessException(Class<?> entityClass, Object name) {
        super(String.format(MESSAGE_TEMPLATE, entityClass.getSimpleName(), name));
    }
}
