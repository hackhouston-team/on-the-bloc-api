package com.bloc.ontheblocapi.dto;

public class NewBlocRequest {
    private String creatorId;
    private String name;

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
