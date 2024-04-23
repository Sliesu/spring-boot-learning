package com.rainbowcloud.boot.cache.Keys;

public class RedisKeys {
    public static String getSmsKey(String phone) {
        return "sms:captcha" + phone;
    }
}
