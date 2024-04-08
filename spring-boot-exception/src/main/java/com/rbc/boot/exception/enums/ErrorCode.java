package com.rbc.boot.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author DingYihang
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description 异常类型枚举
 **/
@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED(401, "登录失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试");

    private final int code;
    private final String msg;
}