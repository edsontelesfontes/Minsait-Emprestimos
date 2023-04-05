package com.minsait.emprestimos.exception;

public class ClientCantBeNullException extends RuntimeException{
    public ClientCantBeNullException(String message) {
        super(message);
    }
}
