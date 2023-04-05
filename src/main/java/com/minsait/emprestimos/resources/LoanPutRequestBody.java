package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class LoanPutRequestBody {
    @NotNull(message = "Id can't be null")
    private Long id;
    @CPF
    private String cpf;
    @NotBlank(message = "Loan can't be null ou blank")
    private BigDecimal loanAmount;
    @NotNull(message = "Client type can't be null")
    private EnumClientType enumClientType;
}
