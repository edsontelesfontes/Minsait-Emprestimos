package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.model.Address;
import com.minsait.emprestimos.model.Loan;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientGetRequestBody {
    private String name;
    private String cpf;
    private String phoneNumber;
    private AddressGetRequestBody address;
    private BigDecimal salary;
    private EnumClientType clientType;

    private List<Loan> loan;
}
