package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.VisitReq;
import com.jiawa.wiki.response.CommonResp;
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
    public CommonResp saveDoc(@Valid @RequestBody VisitReq req){
        visitService.insertVisit(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }
}
