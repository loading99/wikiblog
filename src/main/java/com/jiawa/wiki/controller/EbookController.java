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
import org.springframework.transaction.annotation.Transactional;
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

    @Value("${image.baseURL}")
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
    @Transactional
    public CommonResp upload(@RequestParam("file") MultipartFile cover,
                             @RequestParam("id") Long id) throws IOException {
        LOG.info("上传文件开始：{}", cover);
        LOG.info("文件名：{}", cover.getOriginalFilename());
        LOG.info("文件大小：{}", cover.getSize());
        // Save to local
        LOG.info(baseURL);
        String fileName = cover.getOriginalFilename();
        String fullPath = baseURL + fileName;
        File dest = new File(fullPath);
        cover.transferTo(dest);
        LOG.info(dest.getAbsolutePath());
        // Save to database
        ebookService.UploadCover(dest.getAbsolutePath(), id);
        return new CommonResp();
    }
}
