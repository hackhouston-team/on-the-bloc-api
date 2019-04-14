package com.bloc.ontheblocapi.models;

import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private String creatorId;
    private String content;

    public Message(final String creatorId, final String content) {
        this.creatorId = creatorId;
        this.content = content;
    }

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
