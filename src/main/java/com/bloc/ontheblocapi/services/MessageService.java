package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final BlocService blocService;

    @Autowired
    public MessageService(final BlocService blocService) {
        this.blocService = blocService;
    }

    public List<Message> getUserMessagesByBlock(final String userId, final String blocId) throws DocumentNotFoundException {
        return blocService.getBlocById(blocId).getMessages().stream()
                .filter(message -> message.getCreatorId().equals(userId))
                .collect(Collectors.toList());
    }
}
