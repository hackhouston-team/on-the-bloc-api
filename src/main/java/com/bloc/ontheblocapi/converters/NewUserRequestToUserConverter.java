package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.dto.NewUserRequest;
import com.bloc.ontheblocapi.models.BlocIdentifiers;
import com.bloc.ontheblocapi.models.User;
import com.bloc.ontheblocapi.services.BlocService;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class NewUserRequestToUserConverter implements Converter<NewUserRequest, User> {
    private BlocService blocService;

    public NewUserRequestToUserConverter(final BlocService blocService) {
        this.blocService = blocService;
    }

    @Override
    public User convert(final NewUserRequest newUserRequest) {
        final User user = new User(newUserRequest.getId());
        final List<BlocIdentifiers> blocIdentifiers = blocService.getBlocIdentifiers(newUserRequest.getBlocIds());
        user.setBlocIdentifiers(blocIdentifiers);
        return user;
    }
}
