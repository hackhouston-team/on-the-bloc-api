package com.bloc.ontheblocapi.controllers;

import com.bloc.ontheblocapi.dto.DocumentNotFoundResponse;
import com.bloc.ontheblocapi.exceptions.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private final ConversionService conversionService;

    @Autowired
    public ExceptionHandlerControllerAdvice(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<DocumentNotFoundResponse> handleDocumentNotFoundException(final DocumentNotFoundException exception) {
        final DocumentNotFoundResponse response = conversionService.convert(exception, DocumentNotFoundResponse.class);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
