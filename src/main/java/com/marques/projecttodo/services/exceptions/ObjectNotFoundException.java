package com.marques.projecttodo.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 1l;

    public ObjectNotFoundException (String msg) {
        super(msg);
    }
}
