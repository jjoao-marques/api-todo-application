package com.marques.projecttodo.services.exceptions;

public class InvalidDate extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidDate (String msg) {
        super(msg);
    }
}
