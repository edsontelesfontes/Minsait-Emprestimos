package com.minsait.emprestimos.exception;

public class ClientAlreadyExitsException extends RuntimeException{
    public ClientAlreadyExitsException(String message, String cpf) {
        super(message + cpf);
    }
}
