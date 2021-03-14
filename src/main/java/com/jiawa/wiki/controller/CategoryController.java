package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Category;
import com.jiawa.wiki.req.CategoryReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.CategoryResp;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp getCategoryList(){
        CommonResp<PageResp<Category>> resp = new CommonResp<>();
        PageResp<Category> list = categoryService.list();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public CommonResp searchCategorybyName(@Valid CategoryReq req){
        CommonResp<CategoryResp<Category>> resp = new CommonResp<>();
        CategoryResp<Category> list = categoryService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveCategory(@Valid @RequestBody CategoryReq req){
        categoryService.update(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

}
