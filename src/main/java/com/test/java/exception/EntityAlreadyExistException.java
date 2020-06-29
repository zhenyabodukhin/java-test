package com.test.java.exception;

public class EntityAlreadyExistException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "%s with name=%s already exist";

    public EntityAlreadyExistException(Class<?> entityClass, Object id) {
        super(String.format(MESSAGE_TEMPLATE, entityClass.getSimpleName(), id));
    }
}
