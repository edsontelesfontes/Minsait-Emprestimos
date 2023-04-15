package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.validation.constraints.ZipCode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPutRequestBody {
    private String rua;
    private Integer numero;

    @ZipCode
    private String cep;

}
