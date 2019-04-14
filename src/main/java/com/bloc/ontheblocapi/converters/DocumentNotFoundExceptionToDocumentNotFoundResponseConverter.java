package com.bloc.ontheblocapi.converters;

import com.bloc.ontheblocapi.dto.DocumentNotFoundResponse;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import org.springframework.core.convert.converter.Converter;

public class DocumentNotFoundExceptionToDocumentNotFoundResponseConverter implements Converter<DocumentNotFoundException, DocumentNotFoundResponse> {
    @Override
    public DocumentNotFoundResponse convert(final DocumentNotFoundException exception) {
        final DocumentNotFoundResponse response = new DocumentNotFoundResponse();
        response.setId(exception.getId());
        response.setType(exception.getType());
        response.setMessage(exception.getMessage());
        return response;
    }
}
