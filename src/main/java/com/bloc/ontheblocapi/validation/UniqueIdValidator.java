package com.bloc.ontheblocapi.validation;

import com.bloc.ontheblocapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueIdValidator implements ConstraintValidator<UniqueId, String> {
    private final UserRepository userRepository;

    @Autowired
    public UniqueIdValidator(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(final String id, final ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.findById(id).isPresent();
    }
}
