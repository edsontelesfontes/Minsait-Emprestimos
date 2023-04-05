package com.minsait.emprestimos.model;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_loan_contract")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientCpf;

    private BigDecimal amount;
    private BigDecimal totalAmount;

    @Enumerated(EnumType.ORDINAL)
    private EnumClientType clientType;
}
