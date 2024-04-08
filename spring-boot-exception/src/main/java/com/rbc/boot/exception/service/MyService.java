package com.rbc.boot.exception.service;

import com.rbc.boot.exception.enums.ErrorCode;
import com.rbc.boot.exception.exception.ServerException;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Service
    public class ExceptionService {
        /**
         * 模拟未登录异常
         */
        public void unAuthorizedError() {
            throw new ServerException("没有登录");
        }

        /**
         *模拟系统异常
         */
        public void systemError() {
            throw new ServerException("系统异常");
        }

    }
}
