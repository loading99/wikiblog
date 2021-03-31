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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp getCategoryList(){
        CommonResp<List<CategoryResp>> resp = new CommonResp<>();
        List<CategoryResp> list = categoryService.list();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public CommonResp searchCategorybyName(@Valid CategoryReq req){
        CommonResp<PageResp<Category>> resp = new CommonResp<>();
        PageResp<Category> list = categoryService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveCategory(@Valid @RequestBody CategoryReq req){
        categoryService.update(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }


    @DeleteMapping("/delete/{str}")
    public CommonResp deleteCategory(@PathVariable String str){
        final List<String> ids = Arrays.asList(str.split(","));
        List<Long> IDlist=new ArrayList<>();
        for (String id : ids) {
            IDlist.add(Long.parseLong(id));
        }
        categoryService.delete(IDlist);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

}
