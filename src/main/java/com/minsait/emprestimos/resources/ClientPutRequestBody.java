package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Address;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientPutRequestBody {

    private String name;

    private String cpf;

    private String phoneNumber;


    private Address address;

    private BigDecimal salary;

    private EnumClientType clientType;
}
