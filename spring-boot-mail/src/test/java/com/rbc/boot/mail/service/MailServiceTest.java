package com.rbc.boot.mail.service;

import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail( "1391767025@qq.com",  "测试普通文本邮件", "这是一封测试普通文本邮件");
    }

    @Test
    void sendHtmlMail() throws MessagingException {
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
                        color: #007bff;
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
                <h2>这是一封HTML邮件</h2>
                <p>亲爱的用户：</p>
                <p>以下是一封测试HTML邮件：</p>
                <p>发送信息：</p>
                <p>姓名：CrispShark</p>
                <p>邮箱：yihang_0913@qq.com</p>
            </body>
        </html>""";
        mailService.sendHtmlMail("1391767025@qq.com", "这是一封HTML邮件", content);
    }

    @Test
    void sendAttachmentMail() throws MessagingException {
        String to = "1391767025@qq.com";
        String subject = "这是一封HTML邮件";
        String content = "这是一个带附件的邮件";
        String filePath = "E:\\WorkSpace\\SpringBootProjects\\spring-boot-learning\\doc\\img\\jianshu-page.png";

        mailService.sendAttachmentsMail(to, subject, content, filePath);
    }


}
