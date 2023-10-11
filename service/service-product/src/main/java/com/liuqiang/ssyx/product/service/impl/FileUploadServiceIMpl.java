package com.liuqiang.ssyx.product.service.impl;

import com.aliyun.oss.OSSClient;
import com.liuqiang.ssyx.product.config.OssProperties;
import com.liuqiang.ssyx.product.service.FileUploadService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: oss文件上传与下载服务类
 * @date 2023/9/6 17:46
 */
@Service
public class FileUploadServiceIMpl implements FileUploadService {


    //oss属性类
    @Autowired
    private OssProperties ossProperties;

    @Autowired
    private OSSClient ossClient;


    //文件上传
    @Override
    public String fileUpload(MultipartFile file) {
        try {
            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            //生成随机唯一值，使用uuid，添加到文件名称里面
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid+fileName;
            //按照当前日期，创建文件夹，上传到创建文件夹里面
            //  2021/02/02/01.jpg
            String timeUrl = new DateTime().toString("yyyy/MM/dd");
            fileName = timeUrl+"/"+fileName;
            //调用方法实现上传
            ossClient.putObject(ossProperties.getBucketName(), fileName, inputStream);
            //上传之后文件路径
            // https://ssyx-atguigu.oss-cn-beijing.aliyuncs.com/01.jpg
            String url = "https://"+ossProperties.getBucketName()+"."+ossProperties.getEndpoint()+"/"+fileName;
            //返回
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    //文件下载
    @Override
    public Object fileDownload(MultipartFile file) {
        return null;
    }
}
