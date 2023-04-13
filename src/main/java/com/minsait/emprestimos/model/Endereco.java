package com.minsait.emprestimos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private String cep;

}
