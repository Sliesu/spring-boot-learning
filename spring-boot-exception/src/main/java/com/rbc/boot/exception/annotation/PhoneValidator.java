package com.rbc.boot.exception.annotation;


import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author DingYihang
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    // 手机号正则表达式
    private static final String REGEX_PHONE = "^1[3456789]\\d{9}$";

    @Override
    public void initialize(Phone phone) {
        // 可以在这里执行一些初始化操作，但在这个示例中我们不需要做任何事情
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            // 忽略空值，由@NotBlank注解校验
            return true;
        } else {
            // 使用正则表达式校验手机号格式
            return Pattern.matches(REGEX_PHONE, value);
        }
    }
}
