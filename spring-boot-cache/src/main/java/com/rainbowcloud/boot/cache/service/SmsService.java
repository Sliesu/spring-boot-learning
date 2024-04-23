package com.rainbowcloud.boot.cache.service;

public interface SmsService {
    /**
     * 发短信
     * @param phoneNumber 手机号
     */
    void sendSms(String phoneNumber);

}
