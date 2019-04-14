package com.bloc.ontheblocapi.controllers;

import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(final @PathVariable String id) throws DocumentNotFoundException {
        final User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> createNewUser(final @PathVariable String id) {
        final User user = userService.createNewUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
