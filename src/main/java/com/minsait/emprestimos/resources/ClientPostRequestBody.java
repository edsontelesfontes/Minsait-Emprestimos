package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Address;
import com.minsait.emprestimos.validation.constraints.Phone;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
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
    private String name;

    @CPF(message = "CPF can't be empty or null")
    //@NotEmpty(message = "CPF can't be empty or null")
    private String cpf;

    @NotBlank(message = "Client phone can't be null or empty")
    @Phone(message = "celular informado inválido")
    @Size(min = 8, max = 15, message = "celular precisa ter entre 8 e 15 caracteres")
    private String phoneNumber;
    @NotNull(message = "Client Address can't be null")
    private AddressPostRequestBody address;
    @NotNull(message = "Client salary can't be null")
    @DecimalMin(value = "1319.0", inclusive = false)
    private BigDecimal salary;

    @NotNull(message = "Client type can't be null")
    private EnumClientType clientType;
}