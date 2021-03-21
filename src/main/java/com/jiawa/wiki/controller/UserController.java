package com.jiawa.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiawa.wiki.domain.User;
import com.jiawa.wiki.req.LoginReq;
import com.jiawa.wiki.req.ResetPasswordReq;
import com.jiawa.wiki.req.UserReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.LoginResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.UserService;
import com.jiawa.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private RedisTemplate redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/list")
    public CommonResp getUserList(){
        CommonResp<PageResp<User>> resp = new CommonResp<>();
        PageResp<User> list = userService.list();
        resp.setContent(list);
        return resp;

    }

    @GetMapping("/search")
    public CommonResp searchUserbyName(UserReq req){
        CommonResp<PageResp<User>> resp = new CommonResp<>();
        PageResp<User> list = userService.searchbyname(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveUser(@Valid @RequestBody UserReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        userService.update(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }
    @PostMapping("/reset-password")
    public CommonResp resetPass(@Valid @RequestBody ResetPasswordReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        userService.resetpassword(req);
        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp deleteUser(@PathVariable Long id){
        userService.delete(id);
        CommonResp resp = new CommonResp<>();
        return resp;
    }
    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody LoginReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<LoginResp> resp = new CommonResp<>();
        LoginResp loginResp = userService.login(req);
        //如果成功会set success为 true
        //否则会被异常处理拦截
        Long token=snowFlake.nextId();
        logger.info("-------Generate Token and save in Redis-------");
        loginResp.setToken(token.toString());
        redisTemplate.opsForValue().set(token, JSONObject.toJSONString(loginResp),3600, TimeUnit.SECONDS);
        resp.setContent(loginResp);
        return resp;
    }
}
