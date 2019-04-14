package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.BlocSummary;
import org.springframework.core.convert.converter.Converter;

public class BlocToBlocSummaryConverter implements Converter<Bloc, BlocSummary> {
    @Override
    public BlocSummary convert(final Bloc bloc) {
        final BlocSummary blocSummary = new BlocSummary();
        blocSummary.setId(bloc.getId());
        blocSummary.setCreator(bloc.getCreatorId());
        blocSummary.setName(bloc.getName());
        blocSummary.setMessageCount(bloc.getMessageCount());
        return blocSummary;
    }
}
