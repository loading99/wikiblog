package com.jiawa.wiki;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.service.EbookService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@SpringBootTest
class WikiApplicationTests {
    @Resource
    private EbookMapper ebookmapper;

    private final static Logger LOG = LoggerFactory.getLogger(EbookService.class);
    @Test
    void contextLoads() {
        Ebook ebook = ebookmapper.selectByPrimaryKey(Long.valueOf(10));
        LOG.info("value is ", ebook);
    }

}
