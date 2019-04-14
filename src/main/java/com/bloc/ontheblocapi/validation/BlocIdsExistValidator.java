package com.bloc.ontheblocapi.validation;

import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class BlocIdsExistValidator implements ConstraintValidator<BlocIdsExist, List<String>> {
    private final BlocRepository blocRepository;

    @Autowired
    public BlocIdsExistValidator(final BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public boolean isValid(final List<String> ids, final ConstraintValidatorContext constraintValidatorContext) {
        // If not ids were given or empty the field is valid
        if (ids == null || ids.size() == 0) {
            return true;
        }

        // TODO: Should determine which ids are not valid and update constraintValidatorContext for better error messages.
        final List<Bloc> blocs = (List<Bloc>) blocRepository.findAllById(ids);
        return blocs.size() == ids.size();
    }
}
