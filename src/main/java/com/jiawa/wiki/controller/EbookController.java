package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.service.EbookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;

    @Value("{image.baseURL}")
    String baseURL;

    private static final Logger LOG = LoggerFactory.getLogger(EbookController.class);

    @GetMapping("/list")
    public CommonResp getEbookList(){
        CommonResp<PageResp<Ebook>> resp = new CommonResp<>();
        PageResp<Ebook> list = ebookService.list();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public CommonResp searchEbookbyName(@Valid EbookReq req){
        CommonResp<PageResp<Ebook>> resp = new CommonResp<>();
        PageResp<Ebook> list = ebookService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveEbook(@Valid @RequestBody UpdateReq req){
        ebookService.update(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp deleteEbook(@PathVariable Long id){
        ebookService.delete(id);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @RequestMapping("/upload/cover")
    public CommonResp upload(@RequestParam MultipartFile cover) throws IOException {
        LOG.info("上传文件开始：{}", cover);
        LOG.info("文件名：{}", cover.getOriginalFilename());
        LOG.info("文件大小：{}", cover.getSize());

        // 保存文件到本地
        String fileName = cover.getOriginalFilename();
        String fullPath = baseURL + fileName;
        File dest = new File(fullPath);
        cover.transferTo(dest);
        LOG.info(dest.getAbsolutePath());

        return new CommonResp();
    }
}
