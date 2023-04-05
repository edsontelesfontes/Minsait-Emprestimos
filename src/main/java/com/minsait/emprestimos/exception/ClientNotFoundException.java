package com.minsait.emprestimos.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message, String cpf) {
        super(String.format(message, cpf));
    }
}
