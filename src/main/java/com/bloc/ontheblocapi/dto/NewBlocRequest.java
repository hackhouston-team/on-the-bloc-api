package com.bloc.ontheblocapi.dto;

import com.bloc.ontheblocapi.validation.UserIdExists;

import java.util.List;

public class NewBlocRequest {
    @UserIdExists
    private String creatorId;
    private String name;
    private List<NewMessageRequest> message;

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

    public List<NewMessageRequest> getMessage() {
        return message;
    }

    public void setMessage(List<NewMessageRequest> message) {
        this.message = message;
    }
}
