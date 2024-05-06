package com.rbc.boot.task.job;


import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.zxing.qrcode.encoder.QRCode;
import com.rbc.boot.task.service.MailService;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 定时任务类，演示使用Spring的@Scheduled注解来执行定时任务。
 */
@Component
@Slf4j
public class ScheduledJobs {

    @Resource
    private MailService mailService;

//    /**
//     * 演示固定延迟任务。
//     * 每次任务执行结束后，延迟3秒后再次执行。
//     */
//    @Scheduled(fixedDelay = 3000)
//    public void fixedDelayJob() {
//        log.info("fixedDelayJob start: {}", new Date());
//        log.info("fixedDelayJob end: {}", new Date());
//    }
//
//    /**
//     * 演示固定速率任务。
//     * 每次任务开始后，间隔3秒执行一次。
//     */
//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() {
//        log.info("fixedRateJob start: {}", new Date());
//        log.info("fixedRateJob end: {}", new Date());
//    }



//    /**
//     * 每年的5月6日16:05执行一次。
//     */
//    @Scheduled(cron = "0 5 16 6 5 ?")
//    public void cronJob() {
//        log.info("祝你生日快乐: {}", new Date());
//    }

//    /**
//     * 每5秒生成当前时间的二维码
//     */
//    @Scheduled(cron = "0/20 * * * * ?")
//    public void qrCodeCronJob() {
//        // 格式化当前系统时间
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dataTime = formatter.format(new Date());
//
//        UUID uuid = UUID.randomUUID();
//        // 生成指定url对应的二维码到文件，宽和高都是300像素
//        QrCodeUtil.generate(dataTime, 300, 300, FileUtil.file("C:/Users/DingYihang/Desktop/QrCode/QrCode"+uuid+".jpg"));
//        log.info("新二维码已生成");
//    }

    /**
     * 每年的5月6日16:55执行一次发送邮件
     */
    @Scheduled(cron = "0 55 16 6 5 ?")
    public void happyCronJob() throws MessagingException {
        mailService.sendHtmlMail();
        log.info("邮件发送成功");
    }
}


