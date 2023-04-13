package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Emprestimo;
import com.minsait.emprestimos.model.Endereco;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientGetRequestBody {
    private String nome;
    private String cpf;
    private String telefone;
    private AddressGetRequestBody endereco;
    private BigDecimal rendimentoMensal;

    private EnumClientType relacionamento;

    private List<Emprestimo> emprestimo;
}
