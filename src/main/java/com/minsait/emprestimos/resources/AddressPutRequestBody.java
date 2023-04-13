package com.minsait.emprestimos.resources;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPutRequestBody {
    private String rua;
    private Integer numero;

    private String cep;

}
