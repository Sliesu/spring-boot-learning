package com.rbc.boot.exception.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IDCardValidator implements ConstraintValidator<IDCard, String> {

    @Override
    public void initialize(IDCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(String idCardNumber, ConstraintValidatorContext context) {
        // 这里是验证逻辑

        // 验证身份证号码的长度是否为18位
        return idCardNumber != null && idCardNumber.length() == 18;
    }
}