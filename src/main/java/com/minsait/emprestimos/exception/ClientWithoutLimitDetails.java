package com.minsait.emprestimos.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClientWithoutLimitDetails extends RuntimeException{
    private String title;
    private Integer status;
    private String details;
    private String message;
    private LocalDateTime timestamp;
}
