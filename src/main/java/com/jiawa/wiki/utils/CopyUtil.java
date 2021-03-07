package com.jiawa.wiki.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyUtil {

    //Class<T> target 代表一个类
    public static <T> T copy(Object src, Class<T> target){
        if(src==null){ return null;}

        T obj =null;
        try {
            obj=target.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(src,obj);
        return obj;
    }

    public static <T> List<T> copyList(List src, Class<T> clazz){
        List<T> target=new ArrayList<>();
        if (!CollectionUtils.isEmpty(src))
        for (Object o : src) {
            T obj=copy(o,clazz);
            target.add(obj);
        }
        return target;
    }



}
