package com.rbc.boot.exception.handler;

import com.rbc.boot.exception.enums.ErrorCode;
import com.rbc.boot.exception.exception.ServerException;
import com.rbc.boot.exception.result.Result;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author DingYihang
 *
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {
    /**
     * 处理自定义异常
     *
     * @param exception 异常
     * @return Result<String>
     */
    @ExceptionHandler(ServerException.class)
    public Result<String> handleException(ServerException exception) {
        return Result.error(exception.getCode(), exception.getMsg());

    }

    /**
     * 数据校验异常
     *
     * @param exception 异常
     * @return Result<String>
     */
    @ExceptionHandler(BindException.class)
    public Result<String> bindException(BindException exception) {
        FieldError fieldError = exception.getFieldError();
        assert fieldError != null;
        return Result.error(fieldError.getDefaultMessage());
    }

    /**
     * 其他异常情况
     *
     * @param ex 异常
     * @return Result<String>
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

