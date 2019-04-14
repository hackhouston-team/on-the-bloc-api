package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.BlocIdentifiers;
import org.springframework.core.convert.converter.Converter;

public class BlocToBlocIdentifiersConverter implements Converter<Bloc, BlocIdentifiers> {
    @Override
    public BlocIdentifiers convert(final Bloc bloc) {
        final BlocIdentifiers blocIdentifiers = new BlocIdentifiers();
        blocIdentifiers.setId(bloc.getId());
        blocIdentifiers.setName(bloc.getName());
        return blocIdentifiers;
    }
}
