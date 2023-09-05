package com.liuqiang.ssyx.product.controller;


import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.product.Attr;
import com.liuqiang.ssyx.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Api(tags = "平台属性列表接口")
@RestController
@RequestMapping("/admin/product/attr")
@CrossOrigin("*")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @ApiOperation(value = "根据平台属性分组id查询平台属性列表")
    @GetMapping("/{groupId}")
    public Result getList(@PathVariable("groupId") Long groupId) {
       List<Attr> attrList = attrService.getListAttrGroup(groupId);
        return Result.success(attrList);
    }

    @ApiOperation(value = "根据id查询平台属性列表")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        Attr attr = attrService.getById(id);
        if (attr!=null){
            return Result.success(attr);
        }
        return Result.fail(null);
    }

    @ApiOperation(value = "保存平台属性")
    @PostMapping("/save")
    public Result save(@RequestBody Attr attr) {
        boolean save = attrService.save(attr);
        if (save){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "更新平台属性列表")
    @PutMapping("/update")
    public Result updateById(@RequestBody Attr attr) {
        boolean updateById = attrService.updateById(attr);
        if (updateById){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }


    @ApiOperation(value = "根据id删除平台属性")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        boolean removeById = attrService.removeById(id);
        if (removeById){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "批量删除平台删除列表")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        boolean removeByIds = attrService.removeByIds(idList);
        if (removeByIds){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }

}

