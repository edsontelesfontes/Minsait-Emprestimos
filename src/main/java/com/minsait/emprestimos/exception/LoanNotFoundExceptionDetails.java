package com.minsait.emprestimos.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LoanNotFoundExceptionDetails extends RuntimeException{
    private String title;
    private Integer status;
    private String Details;
    private String sistemMessage;
    private LocalDateTime timestamp;
}
