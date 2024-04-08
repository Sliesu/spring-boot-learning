package com.rbc.boot.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DingYihang
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IDCardValidator.class)
public @interface IDCard {
    String message() default "身份证号格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}