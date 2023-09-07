package com.liuqiang.ssyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.product.service.CategoryService;
import com.liuqiang.ssyx.vo.product.CategoryQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Api(tags = "商品三级分类接口")
@RestController
@RequestMapping("/admin/product/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "分页查询商品分类列表")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, CategoryQueryVo categoryQueryVo) {
        Page<Category> objectPage = new Page<>(page, limit);
        IPage<Category> result = categoryService.getPageList(objectPage, categoryQueryVo);

        return Result.success(result);
    }

    @ApiOperation(value = "查询所有商品分类列表")
    @GetMapping("/findAllList")
    public Result findAllList() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    @ApiOperation(value = "根据id查询商品列表")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    @ApiOperation(value = "保存商品")
    @PostMapping("/save")
    public Result save(@RequestBody Category category) {
        boolean save = categoryService.save(category);
        if (save){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "根据id更新商品列表")
    @PutMapping("/update")
    public Result updateById(@RequestBody Category category) {
        boolean update = categoryService.updateById(category);
        if (update){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "根据id删除商品列表")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        boolean removeById = categoryService.removeById(id);
        if (removeById){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "查询所有商品分类列表")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        boolean removeByIds = categoryService.removeByIds(idList);
        if (removeByIds){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }
}

