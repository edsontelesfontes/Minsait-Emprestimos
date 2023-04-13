package com.minsait.emprestimos.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.emprestimos.enumeration.EnumClientType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanGetRequestBody {

    private Long id;
    private String cpfCliente;
    private BigDecimal valorFinal;
    private BigDecimal valorInicial;

    private EnumClientType relacionamento;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicial;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFinal;
}
