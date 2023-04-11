package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Address;
import jakarta.validation.constraints.Min;
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


    //private Address address;
    private AddressPutRequestBody addressPutRequestBody;
    @Min(value = 1320, message = "Please insert a amount superior a minimum wage")
    private BigDecimal salary;

    private EnumClientType clientType;
}
