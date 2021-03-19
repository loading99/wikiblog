package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.User;
import com.jiawa.wiki.req.UserReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

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

    @DeleteMapping("/delete/{id}")
    public CommonResp deleteUser(@PathVariable Long id){
        userService.delete(id);
        CommonResp resp = new CommonResp<>();
        return resp;
    }
}
