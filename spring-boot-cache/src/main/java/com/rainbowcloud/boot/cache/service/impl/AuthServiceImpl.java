package com.rainbowcloud.boot.cache.service.impl;

import com.rainbowcloud.boot.cache.Keys.RedisKeys;
import com.rainbowcloud.boot.cache.config.RedisCache;
import com.rainbowcloud.boot.cache.exception.ErrorCode;
import com.rainbowcloud.boot.cache.exception.ServerException;
import com.rainbowcloud.boot.cache.service.AuthService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;


@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Resource
    private RedisCache redisCache;

    @Override
    public String loginByPhone(String phone, String code) {
        // 获取验证码的 key
        String smsCacheKey = RedisKeys.getSmsKey(phone);

        // 从 Redis 中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);

        if (ObjectUtils.isEmpty(redisCode)) {
            // 验证码已失效
            throw new ServerException(ErrorCode.SMS_CODE_EXPIRE);
        } else if (!redisCode.toString().equals(code)) {
            // 验证码错误
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }

        // 删除用过的验证码
        redisCache.delete(smsCacheKey);

        // 返回 token，这里用 UUID 模拟，实际上是要根据用户 id，构造一个 JWT Token
        String token = UUID.randomUUID().toString();
        logger.info("User with phone {} logged in successfully.", phone);
        return token;
    }
}
