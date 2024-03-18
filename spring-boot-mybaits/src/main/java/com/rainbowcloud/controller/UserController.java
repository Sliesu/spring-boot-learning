package com.rainbowcloud.controller;

import com.rainbowcloud.entity.User;
import com.rainbowcloud.response.AjaxResponse;
import com.rainbowcloud.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Using GET method to fetch all users: GET /user/all
     * @return AjaxResponse containing the list of users and response status
     */
    @Operation(summary = "Fetch all users")
    @GetMapping("/all")
    public AjaxResponse selectAll() {
        try {
            List<User> users = userService.selectAll();
            return AjaxResponse.success(users);
        } catch (Exception e) {
            // Assuming AjaxResponse has a method to handle errors
            return AjaxResponse.error(e.getMessage());
        }
    }
}