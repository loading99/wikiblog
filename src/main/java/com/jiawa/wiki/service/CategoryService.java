package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Category;
import com.jiawa.wiki.domain.CategoryExample;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.mapper.CategoryMapper;
import com.jiawa.wiki.req.CategoryReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.CategoryResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.utils.CopyUtil;
import com.jiawa.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private CategoryMapper categorymapper;

    @Resource
    private SnowFlake snowflake;

    public List<CategoryResp> list(){
        CategoryExample categoryExample=new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categoryList=categorymapper.selectByExample(categoryExample);
        List<CategoryResp> list=CopyUtil.copyList(categoryList,CategoryResp.class);
        return list;
    }

    public PageResp<Category> searchbyname(CategoryReq req){

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Category> categorys = categorymapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo=new PageInfo<>(categorys);
        PageResp<Category> response=new PageResp<>();
        response.setList(categorys);
        response.setTotal(pageInfo.getTotal());
        return response;
    }
    public void update(CategoryReq req){

        Category copy = CopyUtil.copy(req,Category.class);
        //check if the id in the database

        if (ObjectUtils.isEmpty(req.getId())){
            //if ID doesn't exist
            copy.setId(snowflake.nextId());
            categorymapper.insert(copy);
        }else{
            categorymapper.updateByPrimaryKey(copy);
        }
    }
    public void delete(Long id){
        categorymapper.deleteByPrimaryKey(id);
    }
}
