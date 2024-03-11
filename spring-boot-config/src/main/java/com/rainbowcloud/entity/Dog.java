package com.rainbowcloud.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    @Value("${person.dog.name}")
    private String name;
    @Value("${person.dog.age}")
    private Integer age;
}