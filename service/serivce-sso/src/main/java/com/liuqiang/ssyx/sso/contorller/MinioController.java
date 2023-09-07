package com.liuqiang.ssyx.sso.contorller;

import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.common.result.ResultCodeEnum;
import com.liuqiang.ssyx.sso.config.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: minio分布式对象存储接口
 * @date 2023/9/6 14:11
 */
@Api(tags = "minio分布式对象存储接口")
@RestController
@RequestMapping("/admin/product/minio")
@CrossOrigin("*")
public class MinioController {

    @Autowired
    private MinioService minioService;
    /**
     * 上传文件
     */
    @PostMapping("/upLoadFile")
    @ApiOperation(value = "上传文件")
    public Result upLoadFile(@RequestBody MultipartFile multipartFile) {
        boolean upload = minioService.upload(multipartFile);
        if (upload){
            return Result.success(ResultCodeEnum.FILE_UPLOAD_SUCCESS);
        }else {
            return Result.fail(ResultCodeEnum.FILE_UPLOAD_FAIL);
        }

    }

    /**
     * 下载文件
     */
    @ApiOperation(value = "下载文件")
    @PostMapping("/downloadFile")
    public Result downloadFile(@RequestBody MultipartFile multipartFile, HttpServletResponse response) {
        //获取文件的名称
        String fileName = multipartFile.getName();
        minioService.download(fileName,response);

        return Result.success(ResultCodeEnum.FILE_UPLOAD_SUCCESS);
    }

}
