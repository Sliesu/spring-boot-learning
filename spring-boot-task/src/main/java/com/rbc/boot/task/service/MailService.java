package com.rbc.boot.task.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 邮件服务类，用于发送简单邮件
 * @author DingYihang
 */

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 构造函数
     *
     * @param javaMailSender JavaMailSender 实例
     */
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送简单邮件
     *
     * @param to      收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

    /**
     * 发送 HTML 富文本邮件
     *
     * @param to      接收邮件的邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws MessagingException 消息异常
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        // 设置为 HTML 富文本
        mimeMessageHelper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

    public  void sendHtmlMail() throws MessagingException {
        String content = """
        <html>
            <head>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f2f2f2;
                        padding: 20px;
                    }
                    h2 {
                        color: red;
                    }
                    p {
                        font-size: 16px;
                    }
                    ul {
                        list-style-type: circle;
                    }
                    li {
                        margin-bottom: 5px;
                    }
                </style>
            </head>
            <body>
                <h2>生日祝福邮件</h2>
                <p>亲爱的用户：</p>
                <p>祝你生日快乐!</p>
                <p>返送信息：</p>
                <p>祝福人姓名：CrispShark</p>
                <p>祝福发送邮箱：yihang_0913@qq.com</p>
            </body>
        </html>""";
        String to = "1391767025@qq.com";
        String subject = "生日祝福邮件";
        String filePath = "C:\\Users\\DingYihang\\Desktop\\QrCode\\OIP.jpg";
        sendAttachmentsMail(to, subject, content, filePath);
    }

    /**
     * 发送带附件的邮件
     * @param to      接收邮件的邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filePath 附件路径
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
        mimeMessageHelper.addAttachment(fileName, file);

        javaMailSender.send(mimeMessage);
    }

}