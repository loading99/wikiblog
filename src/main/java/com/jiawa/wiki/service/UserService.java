package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.User;
import com.jiawa.wiki.domain.UserExample;
import com.jiawa.wiki.exception.BusinessException;
import com.jiawa.wiki.exception.BusinessExceptionCode;
import com.jiawa.wiki.mapper.UserMapper;
import com.jiawa.wiki.req.LoginReq;
import com.jiawa.wiki.req.ResetPasswordReq;
import com.jiawa.wiki.req.UserReq;
import com.jiawa.wiki.req.UpdateReq;
import com.jiawa.wiki.response.LoginResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.utils.CopyUtil;
import com.jiawa.wiki.utils.SnowFlake;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private final static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper usermapper;

    @Resource
    private SnowFlake snowflake;

    public PageResp<User> list(){
        PageHelper.startPage(1,10);//Only Effective to the first query
        PageInfo<User> pageInfo=new PageInfo<>();
        List<User> users = usermapper.selectByExample(null);
        PageResp<User> response=new PageResp<>();
        response.setList(users);
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    public PageResp<User> searchbyname(UserReq req){

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getAccount())) {
            criteria.andNameLike("%"+req.getAccount()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<User> users = usermapper.selectByExample(userExample);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        PageResp<User> response=new PageResp<>();
        response.setList(users);
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    public void update(UserReq req){

        User copy = CopyUtil.copy(req,User.class);
        //check if the id in the database
        if (ObjectUtils.isEmpty(req.getId())){
            //if ID doesn't exist
            User user = selectbyAcc(req.getAccount());
            if(ObjectUtils.isEmpty(user)){
                copy.setId(snowflake.nextId());
                usermapper.insert(copy);
            }else{
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        }else{
            copy.setAccount(null);
            copy.setPassword(null);
            usermapper.updateByPrimaryKeySelective(copy);
        }
    }

    public void resetpassword(ResetPasswordReq req){
        User copy = CopyUtil.copy(req,User.class);
        usermapper.updateByPrimaryKeySelective(copy);
    }
    public void delete(Long id){
        usermapper.deleteByPrimaryKey(id);
    }

    public User selectbyAcc(String acc){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(acc);
        List<User> users = usermapper.selectByExample(userExample);
        if(CollectionUtils.isEmpty(users)){
            return null;
        }else {
            return users.get(0);
        }
    }

    public LoginResp login(LoginReq req) {
        User userDB = selectbyAcc(req.getAccount());
        if (ObjectUtils.isEmpty(userDB)) {
            LOG.info("用户名不存在，{}", req.getAccount());
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        } else {
            if (userDB.getPassword().equals(req.getPassword())) {
                LoginResp loginResp = CopyUtil.copy(userDB, LoginResp.class);
                return loginResp;
            } else {
                LOG.info("密码不正确，{}", req.getPassword());
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }
}
