package com.rbc.boot.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author DingYihang
 */
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
public @interface Gender {
    String message() default "性别格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
