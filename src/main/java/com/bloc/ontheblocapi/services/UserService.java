package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.dto.NewUserRequest;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Autowired
    public UserService(final UserRepository userRepository,
                       final ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    public User getUserById(final String id) throws DocumentNotFoundException {
        final Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> new DocumentNotFoundException(id, User.class));
        return user.get();
    }

    public User createNewUser(final NewUserRequest newUserRequest) {
        final User newUser = conversionService.convert(newUserRequest, User.class);
        return userRepository.save(newUser);
    }
}
