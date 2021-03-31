package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.req.VisitReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.VisitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 记录访问，统计访问
 *
 */
@RestController
@RequestMapping("/stats")
public class StatsController {
    @Resource
    private VisitService visitService;


    @PostMapping("/add")
    public CommonResp addVisit(@Valid @RequestBody VisitReq req){
        visitService.insertVisit(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @GetMapping("/list")
    public CommonResp list(VisitReq req){
        CommonResp<Long> resp = new CommonResp<>();
        Long count = visitService.searchTotal();
        resp.setContent(count);
        return resp;
    }
}
