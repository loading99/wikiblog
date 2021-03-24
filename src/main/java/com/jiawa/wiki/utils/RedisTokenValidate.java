package com.jiawa.wiki.utils;

import com.jiawa.wiki.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTokenValidate {
    @Resource
    private RedisTemplate redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RedisTokenValidate.class);

    public boolean validate(String key,long second){
        if(redisTemplate.hasKey(key)){
            logger.warn("key Already exists:{}",key);
            return false;
        }else{
            logger.info("key is valid, place in Redis {}",key);
            redisTemplate.opsForValue().set(key,key,second, TimeUnit.SECONDS);
            return true;
        }
    }
}
