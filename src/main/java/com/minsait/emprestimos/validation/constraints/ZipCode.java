package com.minsait.emprestimos.validation.constraints;

import com.minsait.emprestimos.validation.PhoneValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
    String message() default "Digit a valid zip code with br pattern";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
