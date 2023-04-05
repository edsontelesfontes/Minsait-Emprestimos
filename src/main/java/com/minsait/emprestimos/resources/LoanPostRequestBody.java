package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanPostRequestBody {

    @CPF
    private String cpf;
    @NotBlank(message = "Loan can't be null ou blank")
    private BigDecimal loanAmount;
    @NotNull(message = "Client type can't be null")
    private EnumClientType enumClientType;
}
