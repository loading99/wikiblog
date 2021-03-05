package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.TestAcc;
import com.jiawa.wiki.mapper.Testmapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private Testmapper testmapper;

    public List<TestAcc> list(){
        return testmapper.list();
    }
}
