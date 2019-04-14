package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.dto.NewBlocRequest;
import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.Message;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class NewBlockRequestToBlocConverter implements Converter<NewBlocRequest, Bloc> {
    private final ConversionService conversionService;

    public NewBlockRequestToBlocConverter(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Bloc convert(final NewBlocRequest newBlocRequest) {
        final Bloc bloc = new Bloc(newBlocRequest.getName());

        if (newBlocRequest.getMessages() != null && newBlocRequest.getMessages().size() > 0) {
            final List<Message> messages = newBlocRequest.getMessages().stream()
                    .map(message -> conversionService.convert(message, Message.class))
                    .collect(Collectors.toList());
            bloc.setMessages(messages);
        }

        return bloc;
    }
}
