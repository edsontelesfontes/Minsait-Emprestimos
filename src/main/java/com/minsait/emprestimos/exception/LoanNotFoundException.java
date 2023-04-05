package com.minsait.emprestimos.exception;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String message, String cpf) {
        super(String.format(message, cpf));
    }
    public LoanNotFoundException(String message) {
        super(String.format(message));
    }
}
