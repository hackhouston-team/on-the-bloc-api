package com.bloc.ontheblocapi.services;

import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(final String id) throws DocumentNotFoundException {
        final Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> new DocumentNotFoundException(id, User.class));
        return user.get();
    }

    public User createNewUser(final String id) {
        final User newUser = new User(id);
        return userRepository.save(newUser);
    }
}
