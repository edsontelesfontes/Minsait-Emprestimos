package com.minsait.emprestimos.exception;

public class ClientWithoutLimit extends RuntimeException{
    public ClientWithoutLimit(String message) {
        super(message);
    }
}
