package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.domain.DocExample;
import com.jiawa.wiki.mapper.DocMapper;
import com.jiawa.wiki.req.DocReq;
import com.jiawa.wiki.response.DocResp;
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
public class DocService {

    private final static Logger LOG = LoggerFactory.getLogger(DocService.class);

    @Resource
    private DocMapper docmapper;

    @Resource
    private SnowFlake snowflake;

    public List<DocResp> list(){
        DocExample docExample=new DocExample();
        docExample.setOrderByClause("sort asc");
        List<Doc> docList=docmapper.selectByExample(docExample);
        List<DocResp> list=CopyUtil.copyList(docList,DocResp.class);
        return list;
    }

    public PageResp<Doc> searchbyname(DocReq req){

        DocExample docExample = new DocExample();
        docExample.setOrderByClause("sort asc");
        DocExample.Criteria criteria = docExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Doc> docs = docmapper.selectByExample(docExample);
        PageInfo<Doc> pageInfo=new PageInfo<>(docs);
        PageResp<Doc> response=new PageResp<>();
        response.setList(docs);
        response.setTotal(pageInfo.getTotal());
        return response;
    }
    public void update(DocReq req){

        Doc copy = CopyUtil.copy(req,Doc.class);
        //check if the id in the database

        if (ObjectUtils.isEmpty(req.getId())){
            //if ID doesn't exist
            copy.setId(snowflake.nextId());
            docmapper.insert(copy);
        }else{
            docmapper.updateByPrimaryKey(copy);
        }
    }
    public void delete(Long id){
        docmapper.deleteByPrimaryKey(id);
    }
    public void delete(List<Long> IDlist){
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria=docExample.createCriteria();
        criteria.andIdIn(IDlist);
        docmapper.deleteByExample(docExample);
    }
}
