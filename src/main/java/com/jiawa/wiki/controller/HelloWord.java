package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.TestAcc;
import com.jiawa.wiki.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HelloWord {

    @Resource
    private TestService testService;


    @RequestMapping(value = "/Hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/test")
    public List<TestAcc> getAccList(){
        return testService.list();
    }
}
