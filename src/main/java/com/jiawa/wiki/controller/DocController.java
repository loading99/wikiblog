package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.req.DocReq;
import com.jiawa.wiki.response.DocResp;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {
    @Resource
    private DocService docService;

    @GetMapping("/list")
    public CommonResp getDocList(){
        CommonResp<List<DocResp>> resp = new CommonResp<>();
        List<DocResp> list = docService.list();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public CommonResp searchDocbyName(@Valid DocReq req){
        CommonResp<PageResp<Doc>> resp = new CommonResp<>();
        PageResp<Doc> list = docService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveDoc(@Valid @RequestBody DocReq req){
        docService.update(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp deleteDoc(@PathVariable Long id){
        docService.delete(id);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

}
