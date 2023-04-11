package com.minsait.emprestimos.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanGetRequestBody {

    private Long id;
    private String cpf;
    private BigDecimal totalAmount;
    private BigDecimal loanAmount;

    private EnumClientType enumClientType;

    private LocalDate startDate;
    private LocalDate endDate;
}
