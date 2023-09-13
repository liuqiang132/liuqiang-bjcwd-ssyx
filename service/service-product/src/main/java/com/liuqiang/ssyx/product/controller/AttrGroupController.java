package com.liuqiang.ssyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.product.AttrGroup;
import com.liuqiang.ssyx.product.service.AttrGroupService;
import com.liuqiang.ssyx.vo.product.AttrGroupQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/admin/product/attrGroup")
@Api(tags = "分组管理商品")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @ApiOperation(value = "分页查询平台商品分组")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, AttrGroupQueryVo attrGroupQueryVo) {
        Page<AttrGroup> attrGroupPage = new Page<>(page, limit);
        IPage<AttrGroup> pageResult = attrGroupService.getPageAttrGroup(attrGroupPage, attrGroupQueryVo);
        return Result.success(pageResult);
    }


    @ApiOperation(value = "根据id查询平台商品属性")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        AttrGroup attrGroup = attrGroupService.getById(id);
        if (attrGroup!=null){
            return Result.success(attrGroup);
        }else {
            return Result.success(attrGroup);
        }

    }

    @ApiOperation(value = "保存平台属性分组")
    @PostMapping("/save")
    public Result save(@RequestBody AttrGroup attrGroup) {
        boolean save = attrGroupService.save(attrGroup);
        if (save){
            return Result.success(null );
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "根据id更新平台商品分组")
    @PutMapping("/update")
    public Result updateById(@RequestBody AttrGroup attrGroup) {
        boolean update = attrGroupService.updateById(attrGroup);
        if (update){
            return Result.success(null );
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "根据id删除平台属性分组")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        boolean removeById = attrGroupService.removeById(id);
        if (removeById){
            return Result.success(null );
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "批量删除平台属性分组")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        boolean removeByIds = attrGroupService.removeByIds(idList);
        if (removeByIds){
            return Result.success(null );
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "查询所有平台属性分组")
    @GetMapping("/findAllList")
    public Result getPageList() {
        List<AttrGroup> list = attrGroupService.list();
        return Result.success(list);
    }

}

