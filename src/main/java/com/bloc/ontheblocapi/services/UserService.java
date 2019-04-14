package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.dto.NewUserRequest;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.BlocSummary;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public User addBlocById(final String id, final Bloc bloc) throws DocumentNotFoundException {
        final User user = getUserById(id);
        final BlocSummary blocSummary = conversionService.convert(bloc, BlocSummary.class);
        final List<BlocSummary> blocSummaries = user.getBlocSummaries() != null ? user.getBlocSummaries() : new ArrayList<>();
        blocSummaries.add(blocSummary);
        user.setBlocSummaries(blocSummaries);
        userRepository.save(user);
        return user;
    }
}
