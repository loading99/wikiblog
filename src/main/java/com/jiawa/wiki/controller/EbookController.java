package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.response.commonResp;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public commonResp getEbookList(){
        commonResp<PageResp<Ebook>> resp = new commonResp<>();
        PageResp<Ebook> list = ebookService.list();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public commonResp searchEbookbyName(EbookReq req){
        commonResp<PageResp<Ebook>> resp = new commonResp<>();
        PageResp<Ebook> list = ebookService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }
}
