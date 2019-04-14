package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.dto.NewBlocRequest;
import com.bloc.ontheblocapi.dto.NewMessageRequest;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.BlocSummary;
import com.bloc.ontheblocapi.models.Message;
import com.bloc.ontheblocapi.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Bloc createNewBloc(final NewBlocRequest newBlocRequest) {
        final Bloc bloc = conversionService.convert(newBlocRequest, Bloc.class);
        return blocRepository.save(bloc);
    }

    public List<BlocSummary> getBlocSummaries(final List<String> ids) {
        if (ids == null || ids.size() == 0) {
            return null;
        }

        final List<Bloc> blocs = (List<Bloc>) blocRepository.findAllById(ids);
        return blocs.stream()
                .map(bloc -> conversionService.convert(bloc, BlocSummary.class))
                .collect(Collectors.toList());
    }

    public Message createNewMessage(final String blocId, final NewMessageRequest newMessageRequest) throws DocumentNotFoundException {
        final Message message = conversionService.convert(newMessageRequest, Message.class);
        final Bloc bloc = getBlocById(blocId);
        final List<Message> messages = bloc.getMessages() != null ? bloc.getMessages() : new ArrayList<>();
        messages.add(message);
        bloc.setMessages(messages);
        blocRepository.save(bloc);
        return message;
    }
}
