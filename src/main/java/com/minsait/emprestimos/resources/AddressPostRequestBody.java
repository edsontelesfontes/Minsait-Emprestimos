package com.minsait.emprestimos.resources;

import com.minsait.emprestimos.validation.constraints.Phone;
import com.minsait.emprestimos.validation.constraints.ZipCode;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPostRequestBody {
    @NotBlank(message = "Street cant be null or empty")
    private String rua;
    @Min(value = 1)
    private Integer numero;
    @NotBlank(message = "Cep cant be null or empty")
    @ZipCode
    private String cep;

}
