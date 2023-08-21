package com.liuqiang.ssyx.login.controller;

import com.liuqiang.ssyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 登录接口
 * @date 2023/8/21 19:06
 */
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin("*") //后期微服务中使用服务网关进行统一处理
@Api(tags = "登录接口")
public class IndexController {

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(){
        Map<String,String> map = new HashMap<>();
        map.put("token","token-admin");
        return Result.success(map);

    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Result getInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("name","liuqiang132");
        map.put("avatar","https://p9.itc.cn/q_70/images03/20200828/7084f6e0076140f0bf3439af89f58ed5.gif");
        return Result.success(map);
    }

    @ApiOperation(value = "退出")
    @PostMapping("/logout")
    public Result logout(){
        return Result.success(null);

    }

}
