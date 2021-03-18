package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Content;
import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.req.DocReq;
import com.jiawa.wiki.response.ContentResp;
import com.jiawa.wiki.response.DocResp;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.DocService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
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
    @GetMapping("/content/{id}")
    public CommonResp getContent(@PathVariable Long id){
        CommonResp<String> resp = new CommonResp<>();
        if (ObjectUtils.isEmpty(id)) {
            resp.setSuccess(false);
            resp.setMessage("The Content id cannot be empty!");
        } else {
            String content = docService.findContent(id);
            resp.setContent(content);
        }
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

    @DeleteMapping("/delete/{str}")
    public CommonResp deleteDoc(@PathVariable String str){
        final List<String> ids = Arrays.asList(str.split(","));
        List<Long> IDlist=new ArrayList<>();
        for (String id : ids) {
            IDlist.add(Long.parseLong(id));
        }
        docService.delete(IDlist);
        CommonResp resp = new CommonResp<>();
        return resp;
    }
}
