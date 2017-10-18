package com.sinsuren.user.management.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by surender.s on 18/10/17.
 */

@Slf4j
public class UnprocessableEntityException extends ClientException {
    private static final long serialVersionUID = 2405997615249959954L;

    public UnprocessableEntityException(String msg, ResponseEntity response) {
        super(msg, response);
    }

    public UnprocessableEntityException(String msg, Exception e) {
        super(msg, e);
    }

    public UnprocessableEntityException(String msg) {
        super(msg);
    }

    public UnprocessableEntityException(Exception exception) {
        super(exception);
    }


    @Override
    protected HttpStatus getStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
