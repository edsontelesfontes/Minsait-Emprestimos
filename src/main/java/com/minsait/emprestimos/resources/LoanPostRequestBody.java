package com.minsait.emprestimos.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanPostRequestBody {

    @CPF
    private String cpf;
    @DecimalMin(value = "1.0", inclusive = false)

    private BigDecimal loanAmount;
    private EnumClientType enumClientType;

    @NotNull(message = "End date can't be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Future
    private LocalDate endDate;
}
