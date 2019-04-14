package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.dto.NewMessageRequest;
import com.bloc.ontheblocapi.models.Message;
import org.springframework.core.convert.converter.Converter;

public class NewMessageRequestToMessageConverter implements Converter<NewMessageRequest, Message> {
    @Override
    public Message convert(NewMessageRequest newMessageRequest) {
        final Message message = new Message();
        message.setCreatorId(newMessageRequest.getCreatorId());
        message.setContent(newMessageRequest.getContent());
        return message;
    }
}
