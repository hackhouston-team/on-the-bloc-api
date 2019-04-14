package com.bloc.ontheblocapi.controllers;

import com.bloc.ontheblocapi.dto.NewBlocRequest;
import com.bloc.ontheblocapi.dto.NewMessageRequest;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.Message;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.services.BlocService;
import com.bloc.ontheblocapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/blocs")
public class BlocController {
    private final BlocService blocService;
    private final UserService userService;

    @Autowired
    public BlocController(final BlocService blocService,
                          final UserService userService) {
        this.blocService = blocService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(final @PathVariable String id) throws DocumentNotFoundException {
        final Bloc bloc = blocService.getBlocById(id);
        return new ResponseEntity<>(bloc, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bloc> createNewBlock(final @RequestBody @Valid NewBlocRequest newBlockRequest) throws DocumentNotFoundException {
        final Bloc newBloc = blocService.createNewBloc(newBlockRequest);
        final User user = userService.addBlocById(newBloc.getCreatorId(), newBloc);
        return new ResponseEntity<>(newBloc, HttpStatus.OK);
    }

    @PostMapping("/{id}/message")
    public ResponseEntity<Message> createNewMessage(final @PathVariable String id,
                                                    final @RequestBody @Valid NewMessageRequest message) throws DocumentNotFoundException {
        final Message newMessage = blocService.createNewMessage(id, message);
        return new ResponseEntity<>(newMessage, HttpStatus.OK);
    }
}
