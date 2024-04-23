package com.rainbowcloud.boot.cache.service;

/**
 * @author DingYihang
 */
public interface AuthService{

    /**
     * 通过手机登录
     * @param phone 手机号
     * @param code 验证码
     * @return
     */
    public String loginByPhone(String phone, String code);

}
