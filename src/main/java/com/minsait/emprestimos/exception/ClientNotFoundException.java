package com.minsait.emprestimos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message) {
        super(String.format(message));
    }
    public ClientNotFoundException(String message, String cpf) {
        super(String.format(message, cpf));
    }
}
