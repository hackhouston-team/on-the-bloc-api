package com.bloc.ontheblocapi.dto;

public class NewUserRequest {
    private String id;

    public NewUserRequest(final String id) {
        this.id = id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
