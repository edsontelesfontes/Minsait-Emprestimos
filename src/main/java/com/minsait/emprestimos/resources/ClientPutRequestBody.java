package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.validation.constraints.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientPutRequestBody {

    private String nome;

    @Phone
    private String telefone;

    @Valid
    private AddressPutRequestBody endereco;
    @Min(value = 1319, message = "Please insert a amount superior a minimum wage")
    private BigDecimal rendimentoMensal;

    private EnumClientType relacionamento;
}
