package com.bloc.ontheblocapi.exceptions;

public class DocumentNotFoundException extends Exception {
    private String id;
    private Class type;
    private String message;

    public DocumentNotFoundException(final String id, final Class type) {
        this(id, type, String.format("%s document with id: %s could not be found", type, id));
    }

    public DocumentNotFoundException(final String id, final Class type, final String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
