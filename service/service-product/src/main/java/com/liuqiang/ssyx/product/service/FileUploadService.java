package com.liuqiang.ssyx.product.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: oss文件上传与下载服务类
 * @date 2023/9/6 17:46
 */
public interface FileUploadService {
    //文件上传
    String fileUpload(MultipartFile file);

    //文件下载
    Object fileDownload(MultipartFile file);
}
