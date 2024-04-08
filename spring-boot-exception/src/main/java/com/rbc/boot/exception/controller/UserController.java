package com.rbc.boot.exception.controller;


import com.rbc.boot.exception.entity.User;
import com.rbc.boot.exception.result.Result;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author DingYihang
 */
@RestController
public class UserController {
    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        // 校验未通过
        if(bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}