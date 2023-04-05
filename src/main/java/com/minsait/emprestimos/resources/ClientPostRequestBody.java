package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Address;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientPostRequestBody {
    @NotEmpty(message = "Name can't be empty or null")
    private String name;

    @CPF(message = "CPF can't be empty or null")
    //@NotEmpty(message = "CPF can't be empty or null")
    private String cpf;
    private String phoneNumber;
    @Valid
    @NotNull(message = "Address can't be null")
    private Address address;
    @NotNull(message = "Salary can't be null")
    @Positive
    private BigDecimal salary;

    @NotNull(message = "Client type can't be null")
    private EnumClientType clientType;
}
