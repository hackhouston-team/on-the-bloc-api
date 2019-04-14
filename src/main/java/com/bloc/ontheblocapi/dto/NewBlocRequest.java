package com.bloc.ontheblocapi.dto;

import com.bloc.ontheblocapi.validation.UserIdExists;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class NewBlocRequest {
    @UserIdExists
    private String creatorId;

    @NotBlank
    private String name;

    private List<NewMessageRequest> messages;

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

    public List<NewMessageRequest> getMessages() {
        return messages;
    }

    public void setMessages(List<NewMessageRequest> messages) {
        this.messages = messages;
    }
}
