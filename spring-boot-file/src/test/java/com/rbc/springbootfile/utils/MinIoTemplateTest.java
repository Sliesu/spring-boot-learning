package com.rbc.springbootfile.utils;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MinIoTemplateTest {

    @Resource
    private MinIoTemplate minIoTemplate;

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.bucketName}")
    private String bucketName;
    /**
     * 判断 bucket 是否存在
     */
    @Test
    void bucketExists() throws Exception {
        boolean flag = minIoTemplate.bucketExists("dyh");
        System.out.println(flag);
    }

    /**
     * 创建 bucket
     */
    @Test
    void makeBucket() throws Exception {
        //Amazon S3 对桶名称有一些限制，例如只能包含小写字母、数字、连字符和点号，并且必须以字母或数字开头，长度在 3 到 63 个字符之间
        minIoTemplate.makeBucket("dyh");
    }

    /**
     * 放入文件
     */
    @Test
    void putObject() throws Exception {
        File file = new File("../doc/img/rbc-logo-round.png");

        // 对上传的文件重命名
        String oldFileName = file.getName();
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index);
        String newFileName = UUID.randomUUID() + suffixName;

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String today = df.format(new Date());

        ObjectWriteResponse owr = minIoTemplate.putObject("dyh", "/"+today+"/"+newFileName, new FileInputStream(file));
        System.out.println(endPoint + "/"+bucketName + owr.object());
    }

    @Test
    void removeObject() throws Exception {
        // 文件存在
        minIoTemplate.removeObject("mqxu", "img/test.jpg");
    }
}