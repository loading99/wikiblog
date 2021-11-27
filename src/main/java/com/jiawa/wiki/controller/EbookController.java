package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.service.EbookService;
import com.jiawa.wiki.utils.SnowFlake;
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

    @Resource
    SnowFlake snowflake;

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

    @PostMapping("/upload/cover")
    @Transactional
    public CommonResp upload(@RequestParam("file") MultipartFile cover,
                             @RequestParam("id") Long id) throws IOException {
        LOG.info("Start to Upload file：{}", cover);
        LOG.info("FileName：{}", cover.getOriginalFilename());
        LOG.info("Size：{}", cover.getSize());
        // Save to local
        //Ensure the uniqueness of image name
        String fileName = snowflake.nextId() + cover.getOriginalFilename() ;
        String fullPath = baseURL + fileName;
        File dest = new File(fullPath);
        cover.transferTo(dest);
        LOG.info("Successfully save file to local!");
        // Save to database
        ebookService.UploadCover("/cover/" + fileName, id);
        return new CommonResp<>();
    }
}
