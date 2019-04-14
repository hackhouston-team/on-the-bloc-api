package com.bloc.ontheblocapi.dto;

import com.bloc.ontheblocapi.validation.UserIdExists;

public class NewMessageRequest {
    @UserIdExists
    private String creatorId;
    private String content;

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}