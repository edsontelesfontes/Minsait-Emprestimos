package com.minsait.emprestimos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_loans")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "cpf_client")
    private String cpfCliente;
    private BigDecimal valorFinal;
    private BigDecimal valorInicial;
    //
    private EnumClientType Relacionamento;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicial = LocalDate.now();
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFinal;

}
