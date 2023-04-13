package com.minsait.emprestimos.resources;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Data
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressGetRequestBody {


    private String rua;
    private Integer numero;
    private String cep;

}
