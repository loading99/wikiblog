package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.*;
import com.jiawa.wiki.mapper.ContentMapper;

import com.jiawa.wiki.mapper.VisitsMapper;
import com.jiawa.wiki.req.VisitReq;
import com.jiawa.wiki.utils.CopyUtil;
import com.jiawa.wiki.utils.RedisTokenValidate;
import com.jiawa.wiki.utils.RequestContext;
import com.jiawa.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Service
public class VisitService {

    private final static Logger LOG = LoggerFactory.getLogger(VisitService.class);

    @Resource
    private VisitsMapper visitmapper;

    @Resource
    private SnowFlake snowflake;

    @Resource
    private RedisTokenValidate redisTokenValidator;

    /**
     *
     */
    public Long searchTotal(){
        return visitmapper.countByExample(null);
    }


    /**
     * Insert visits record
     * @param req
     * If the same ip visit the same page for several times in one hour, then do not insert.
     */
    public void insertVisit(VisitReq req){
        String ip= RequestContext.getRemoteAddr();
        if(redisTokenValidator.validate("Visit"+"_"+ip+req.getWeb(),3600)){
            Visits copy = CopyUtil.copy(req,Visits.class);
            long id = snowflake.nextId();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LOG.info("----Current time {}------",date);
            copy.setDate(date);
            copy.setId(id);
            copy.setIp(ip);
            visitmapper.insert(copy);
        }
    }
}

