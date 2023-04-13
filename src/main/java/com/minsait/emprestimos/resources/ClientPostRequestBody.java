package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.validation.constraints.Phone;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientPostRequestBody {
    @NotBlank(message = "Name can't be empty or null")
    private String nome;

    @CPF(message = "CPF can't be empty or null")
    //@NotEmpty(message = "CPF can't be empty or null")
    private String cpf;

    @NotBlank(message = "Client phone can't be null or empty")
    @Phone(message = "celular informado inválido")
    @Size(min = 8, max = 15, message = "celular precisa ter entre 8 e 15 caracteres")
    private String telefone;
    @NotNull(message = "Client Address can't be null")
    private AddressPostRequestBody endereco;
    @NotNull(message = "Client salary can't be null")
    @DecimalMin(value = "1319.0", inclusive = false)
    private BigDecimal rendimentoMensal;

    @NotNull(message = "Client type can't be null")
    private EnumClientType relacionamento;
}