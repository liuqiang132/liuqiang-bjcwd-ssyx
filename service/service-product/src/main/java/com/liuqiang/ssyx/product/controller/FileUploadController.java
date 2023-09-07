package com.liuqiang.ssyx.product.controller;

import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.product.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: oss文件上传与下载接口
 * @date 2023/9/6 17:44
 */
@Api(tags = "oss文件上传与下载接口")
@RestController
@RequestMapping("/admin/product")
@CrossOrigin("*")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    @ApiOperation(value = "文件上传")
    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file){
        String fileUrl = fileUploadService.fileUpload(file);
        return Result.success(fileUrl);
    }
    @ApiOperation(value = "文件下载")
    @PostMapping("/fileDownload")
    public Result fileDownload(MultipartFile file){
        return Result.success(fileUploadService.fileDownload(file));
    }


}
