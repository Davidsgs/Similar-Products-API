package com.similar.product.config;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FeignException.NotFound.class)
    public void handleException(FeignException.NotFound ex) {
        log.error(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {
        log.error(ex.getMessage());
    }

}