package com.rainbowcloud.boot.cache.controller;

import com.alibaba.fastjson2.JSONObject;
import com.rainbowcloud.boot.cache.result.Result;
import com.rainbowcloud.boot.cache.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sms")
public class SmsController {

    @Resource
    private SmsService service;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", phone);
        service.sendSms(phone);
        return Result.ok();
    }
}
