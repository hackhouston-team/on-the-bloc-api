package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.dto.NewMessageRequest;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.Message;
import com.bloc.ontheblocapi.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlocService {
    private final BlocRepository blocRepository;
    private final ConversionService conversionService;

    @Autowired
    public BlocService(final BlocRepository blocRepository,
                       final ConversionService conversionService) {
        this.blocRepository = blocRepository;
        this.conversionService = conversionService;
    }

    public Bloc getBlocById(final String id) throws DocumentNotFoundException {
        final Optional<Bloc> bloc = blocRepository.findById(id);
        bloc.orElseThrow(() -> new DocumentNotFoundException(id, Bloc.class));
        return bloc.get();
    }

    public Bloc createNewBloc(final String name) {
        final Bloc bloc = new Bloc(name);
        return blocRepository.save(bloc);
    }

    public Message createNewMessage(final String blocId, final NewMessageRequest newMessageRequest) throws DocumentNotFoundException {
        final Message message = conversionService.convert(newMessageRequest, Message.class);
        final Bloc bloc = getBlocById(blocId);
        bloc.getMessages().add(message);
        blocRepository.save(bloc);
        return message;
    }
}
