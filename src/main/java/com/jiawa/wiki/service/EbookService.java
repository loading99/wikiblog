package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private final static Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookmapper;

    public PageResp<Ebook> list(){
        PageHelper.startPage(1,10);//Only Effective to the first query
        PageInfo<Ebook> pageInfo=new PageInfo<>();
        List<Ebook> ebooks = ebookmapper.selectByExample(null);
        PageResp<Ebook> response=new PageResp<>();
        response.setList(ebooks);
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    public PageResp<Ebook> searchbyname(EbookReq req){

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebooks = ebookmapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo=new PageInfo<>(ebooks);
        PageResp<Ebook> response=new PageResp<>();
        response.setList(ebooks);
        response.setTotal(pageInfo.getTotal());
        return response;
    }
}
