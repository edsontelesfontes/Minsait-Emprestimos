package com.minsait.emprestimos.validation;

import com.minsait.emprestimos.validation.constraints.ZipCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidation implements ConstraintValidator<ZipCode,String> {
@Override
public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
        return false;
        }

        String expression = "^([0-9]{5})-?([0-9]{3})$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
        }
}
