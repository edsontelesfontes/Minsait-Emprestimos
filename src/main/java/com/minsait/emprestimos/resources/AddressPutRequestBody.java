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
    private String street;
    private Integer number;

    private String zipCode;

}
