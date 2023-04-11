package com.minsait.emprestimos.model;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Column(nullable = false)
    private String name;
    @Id
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    private BigDecimal salary;

    private EnumClientType clientType;

    @OneToMany(mappedBy = "cpf")
    private List<Loan> loan;

}
