package com.rbc.springbootfile.utils;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.io.InputStream;


/**
 * @author DingYihang
 */
@Component
@Configuration
public class MinIoTemplate {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;


    private MinioClient client;

    /**
     * 初始化方法
     * Initialization method
     */
    @PostConstruct
    public void init() {
        client = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 判断 bucket 是否存在
     * Check if bucket exists
     *
     * @param bucketName 桶名称
     * @return 是否存在
     * @throws Exception 异常
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return client.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(bucketName)
                        .build()
        );
    }

    /**
     * 创建 bucket
     * Create bucket
     *
     * @param bucketName 桶名称
     * @throws Exception 异常
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if (!flag) {
            client.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
        }
    }

    /**
     * 上传文件
     * Upload file
     *
     * @param bucketName  桶名称
     * @param objectName  对象名称
     * @param inputStream 输入流
     * @return ObjectWriteResponse
     * @throws Exception 异常
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return client.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream, -1, 1048576000)
                        .build()
        );
    }

    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param objectName 对象名称
     */
    public void removeObject(String bucketName, String objectName) throws Exception {
        client.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
}

