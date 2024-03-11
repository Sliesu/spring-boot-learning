package com.rainbowcloud.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource(value = {"classpath:employee.properties"})
public class Employee {

    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstEmployeeName;

    @Value("#{{'key1:1,key2:2,key3:3'.split(',').collectEntries{it.split(':')[0], it.split(':')[1].toInteger()}}")
    private Map<String, Integer> employeeAges;

    @Value("#{systemProperties[ 'java.home' ]}")
    private String javaHome;


}