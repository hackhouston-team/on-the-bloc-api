package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    private final BlocService blocService;
    private final ConversionService conversionService;

    @Autowired
    public ConverterConfig(@Lazy final BlocService blocService,
                           @Lazy final ConversionService conversionService) {
        this.blocService = blocService;
        this.conversionService = conversionService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new NewUserRequestToUserConverter(blocService));
        registry.addConverter(new NewMessageRequestToMessageConverter());
        registry.addConverter(new DocumentNotFoundExceptionToDocumentNotFoundResponseConverter());
        registry.addConverter(new BlocToBlocSummaryConverter());
        registry.addConverter(new NewBlockRequestToBlocConverter(conversionService));
    }
}
