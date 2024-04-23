package com.rainbowcloud.boot.cache.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author DingYihang
 */
@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "rbc.sms.ccp")
public class CloopenConfig {
    /**
     * CCP服务器地址
     */
    private String serveIP;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;

//    serveIP: app.cloopen.com
//    port: 8883
//    accountSId: b84ebec7313344378e8e3f02e7bd6616
//    accountToken: aa100f56bd2537c0addcd2c4afa683c3
//    AppID: 2c94811c8cd4da0a018f047873166abc
}
