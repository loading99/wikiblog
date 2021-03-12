package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.response.commonResp;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping("/save")
    public commonResp saveEbook(@RequestBody UpdateReq req){
        ebookService.update(req);
        commonResp resp = new commonResp<>();
        return resp;
    }
}
