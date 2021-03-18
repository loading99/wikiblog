package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Content;
import com.jiawa.wiki.domain.ContentExample;
import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.domain.DocExample;
import com.jiawa.wiki.mapper.ContentMapper;
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
import org.yaml.snakeyaml.events.Event;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocService {

    private final static Logger LOG = LoggerFactory.getLogger(DocService.class);

    @Resource
    private DocMapper docmapper;

    @Resource
    private ContentMapper contentmapper;

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
        Content content=CopyUtil.copy(req,Content.class);

        if (ObjectUtils.isEmpty(req.getId())){
            //if ID doesn't exist
            final long ID = snowflake.nextId();
            copy.setId(ID);
            docmapper.insert(copy);
            content.setId(ID);
            contentmapper.insert(content);
        }else{
            docmapper.updateByPrimaryKey(copy);

            int count = contentmapper.updateByPrimaryKeyWithBLOBs(content);
            //防止在创建文档分类时并没有创建content，导致插入失败
            if(count==0){
                contentmapper.insert(content);
            }
        }
    }
    public String findContent(Long id){

        Content content = contentmapper.selectByPrimaryKey(id);
        return content.getContent();
    }

    public void delete(Long id){
        docmapper.deleteByPrimaryKey(id);

        //Delete content as well
        contentmapper.deleteByPrimaryKey(id);
    }

    public void delete(List<Long> IDlist){
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria=docExample.createCriteria();
        criteria.andIdIn(IDlist);
        docmapper.deleteByExample(docExample);

        //delete content as well
        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria contentcriteria = contentExample.createCriteria();
        contentcriteria.andIdIn(IDlist);
        contentmapper.deleteByExample(contentExample);
    }
}
