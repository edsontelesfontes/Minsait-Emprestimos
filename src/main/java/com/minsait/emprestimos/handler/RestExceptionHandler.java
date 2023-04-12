package com.minsait.emprestimos.handler;

import com.minsait.emprestimos.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ClientAlreadyExitsException.class)
    public ResponseEntity<ClientAlreadyExitsExceptionDetails>  handlerHlientAlreadyExists(ClientAlreadyExitsException clientAlreadyExitsException){
        return new ResponseEntity<>(
                ClientAlreadyExitsExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(clientAlreadyExitsException.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientCantBeNullException.class)
    public ResponseEntity<ClientCantBeNullExceptionDetails>  handlerClientCantBeNull(ClientCantBeNullException clientCantBeNullException){
        return new ResponseEntity<>(
                ClientCantBeNullExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(clientCantBeNullException.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ClientNotFoundExceptionDetails>  handlerClientNotFound(ClientNotFoundException clientNotFoundException){
        return new ResponseEntity<>(
                ClientNotFoundExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(clientNotFoundException.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientWithoutLimit.class)
    public ResponseEntity<ClientWithoutLimitDetails>  handlerClientWithoutLimit(ClientWithoutLimit clientWithoutLimit){
        return new ResponseEntity<>(
                ClientWithoutLimitDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(clientWithoutLimit.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanCantBeEqualsZeroExeception.class)
    public ResponseEntity<LoanCantBeEqualsZeroExeceptionDetails>  handlerLoanCantBeZero(LoanCantBeEqualsZeroExeception loanCantBeEqualsZeroExeception){
        return new ResponseEntity<>(
                LoanCantBeEqualsZeroExeceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(loanCantBeEqualsZeroExeception.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<LoanNotFoundExceptionDetails>  handlerLoanNotFound(LoanNotFoundException LoanNotFoundException){
        return new ResponseEntity<>(
                LoanNotFoundExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Client already exists")
                        .Details(LoanNotFoundException.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }
}
