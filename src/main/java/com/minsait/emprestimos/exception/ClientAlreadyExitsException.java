package com.minsait.emprestimos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientAlreadyExitsException extends RuntimeException{
    public ClientAlreadyExitsException(String message, String cpf) {
        super(message + cpf);
    }
}
