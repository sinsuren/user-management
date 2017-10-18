package com.sinsuren.user.management.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;

/**
 * Created by surender.s on 18/10/17.
 */
@Slf4j
public abstract class ClientException extends RuntimeException {
    private static final long serialVersionUID = 2405997615249959954L;

    @Getter
    private ResponseEntity response;


    public ClientException(String msg, ResponseEntity response) {
        super(msg);
        this.response = response;
        log.error(msg);
    }

    public ClientException(String msg, Exception e) {
        super(format("%s %s", msg, e.getMessage()));
        String errorDescription = msg + e.getLocalizedMessage();
        this.response = ResponseEntity
                .status(getStatus())
                .body(msg);
        log.error(msg, e);
    }

    public ClientException(String msg) {
        super(msg);
        this.response = ResponseEntity.status(getStatus()).body(msg);
        log.error(msg);
    }

    public ClientException(Exception exception) {
        super(exception);
        this.response = ResponseEntity.status(getStatus()).body(exception.getMessage());
        log.error(exception.getMessage());
    }

    protected abstract HttpStatus getStatus();
}

