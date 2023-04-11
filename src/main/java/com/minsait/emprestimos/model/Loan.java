package com.minsait.emprestimos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tb_loans")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "cpf_client")
    private String cpf;
    private BigDecimal totalAmount;
    private BigDecimal loanAmount;
    //
    private EnumClientType enumClientType;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate = LocalDate.now();
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

}
