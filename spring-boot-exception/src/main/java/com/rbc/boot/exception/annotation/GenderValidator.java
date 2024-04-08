package com.rbc.boot.exception.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {

    @Override
    public void initialize(Gender gender) {

    }

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {
        return gender != null && (gender.equals("男") || gender.equals("女"));
    }
}