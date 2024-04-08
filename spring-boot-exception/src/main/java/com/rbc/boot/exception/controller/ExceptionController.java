package com.rbc.boot.exception.controller;

import com.rbc.boot.exception.service.MyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DingYihang
 */
@RestController
public class ExceptionController {
    @Resource
    private MyService.ExceptionService exceptionService;

    @GetMapping("/articles/{id}")
    public void getArticle(@PathVariable("id") Integer id) {
        if (id == 1) {
            exceptionService.unAuthorizedError();
        } else {
            exceptionService.systemError();
        }
    }
}