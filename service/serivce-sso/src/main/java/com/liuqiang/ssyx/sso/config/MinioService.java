package com.liuqiang.ssyx.sso.config;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: minio业务类
 * @date 2023/9/6 14:39
 */
@Component
public class MinioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinioService.class);

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties properties;
    /** 根据File类进行上传 */
    public boolean upload(File file) {
        String filename = file.getName();
        try {
            minioClient.uploadObject(UploadObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(filename)
                    .filename(file.getAbsolutePath())
                    .build());
            return true;
        } catch (Exception e) {
            LOGGER.error("file upload minio exception, file name: {}", filename, e);
            return false;
        }
    }
    /** 前端上传 */
    public boolean upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(filename)
                    .stream(inputStream, inputStream.available(), -1)
                    .contentType(file.getContentType())
                    .build());
            return true;
        } catch (Exception e) {
            LOGGER.error("file upload minio exception, file name: {}", filename, e);
            return false;
        }
    }
    /** 上传到Minio指定路径 */
    public boolean upload(String path, MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            filename = path + filename;
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(filename)
                    .stream(inputStream, inputStream.available(), -1)
                    .contentType(file.getContentType())
                    .build());
            return true;
        } catch (Exception e) {
            LOGGER.error("file upload minio exception, file name: {}", filename, e);
            return false;
        }
    }
    /** 上传到Minio指定目录，可选择自定义随机文件名 */
    public boolean upload(String path, MultipartFile file, Boolean isRandom) {
        String filename = file.getOriginalFilename();
        if (Boolean.TRUE.equals(isRandom)) {
            long millis = System.currentTimeMillis();
            String extension = FilenameUtils.getExtension(filename);
            filename = millis + "." + extension;
        }
        try {
            filename = path + filename;
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(filename)
                    .stream(inputStream, inputStream.available(), -1)
                    .contentType(file.getContentType())
                    .build());
            return true;
        } catch (Exception e) {
            LOGGER.error("file upload minio exception, file name: {}, source file name: {}", filename, file.getOriginalFilename(), e);
            return false;
        }
    }

    /** response下载 */
    public void download(String filename, HttpServletResponse response) {
        response.reset();
        try(InputStream inputStream = minioClient.getObject(GetObjectArgs.builder()
                .bucket(properties.getBucket())
                .object(filename)
                .build())) {
            filename = filename.substring(filename.lastIndexOf("/") + 1);
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
        } catch (Exception e) {
            LOGGER.error("file download from minio exception, file name: {}", filename,  e);
        }
    }




}
