package com.minsait.emprestimos.model;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Column(nullable = false)
    private String nome;
    @Id
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Endereco endereco;
    private BigDecimal rendimentoMensal;

    private EnumClientType relacionamento;

    @OneToMany(mappedBy = "cpfCliente")
    private List<Emprestimo> emprestimo;

}
