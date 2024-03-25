package com.rainbowcloud.boot.controller;

import com.rainbowcloud.boot.entity.User;
import com.rainbowcloud.boot.response.AjaxResponse;
import com.rainbowcloud.boot.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

/**
 * User Controller.
 * @author DingYihang
 */
@Tag(name = "用户接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 使用GET方法,查询所有用户: GET /api/user/all
     *
     * @return AjaxResponse 所有用户信息JSON
     */
    @Operation(summary = "查询所有用户")
    @GetMapping("/all")
    public AjaxResponse selectAll() {
        try {
            List<User> users = userService.selectAll();
            return AjaxResponse.success(users);
        } catch (Exception e) {

            return AjaxResponse.error(e.getMessage());
        }
    }
}