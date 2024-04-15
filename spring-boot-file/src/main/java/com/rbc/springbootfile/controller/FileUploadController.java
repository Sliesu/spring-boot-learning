package com.rbc.springbootfile.controller;


import com.rbc.springbootfile.utils.MinIoTemplate;
import com.rbc.springbootfile.utils.OssTemplate;
import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author DingYihang
 */
@Component
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Value("${file.upload-path}")
    private String uploadPath;

    @Resource
    private MinIoTemplate minIoTemplate;

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Resource
    private OssTemplate ossTemplate;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @PostMapping("/native")
    public String nativeUpload(MultipartFile file, HttpServletRequest request) {
        if(file == null){
            throw new RuntimeException("文件不能为空");
        }
        String today = df.format(new Date());

        // 创建上传的子目录
        File folder = new File(uploadPath + "/" + today);
        if (!folder.exists()) {
            boolean flag = folder.mkdirs();
            System.out.println(flag);
        }

        // 对上传的文件重命名
        String oldFileName = file.getOriginalFilename();
        assert oldFileName != null;
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() + suffixName;
        System.out.println(newFileName);

        // 文件上传
        try {
            file.transferTo(new File(folder, newFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 拼接访问地址
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + today + "/" + newFileName;
    }

    @PostMapping("/minio")
    public String minioUpload(MultipartFile file, HttpServletRequest request) {
        ObjectWriteResponse owr;
        try {
            // 对上传的文件重命名
            String oldFileName = file.getOriginalFilename();
            assert oldFileName != null;
            int index = oldFileName.lastIndexOf(".");
            String suffixName = oldFileName.substring(index);
            String newFileName = UUID.randomUUID() + suffixName;

            // 获取当天日期作为目录
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            String today = df.format(new Date());

            // 上传文件到MinIO对象存储服务
            owr = minIoTemplate.putObject("dyh", "/" + today + "/" + newFileName, file.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return endPoint + "/"+bucketName + owr.object();
    }

    /**
     * oss 文件上传
     * @param file 文件对象
     * @return 文件上传后的地址
     */
    @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }
}