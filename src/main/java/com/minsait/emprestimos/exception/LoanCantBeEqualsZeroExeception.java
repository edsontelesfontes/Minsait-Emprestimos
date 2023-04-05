package com.minsait.emprestimos.exception;

public class LoanCantBeEqualsZeroExeception extends RuntimeException{
    public LoanCantBeEqualsZeroExeception(String message) {
        super(message);
    }
}
