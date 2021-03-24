package com.jiawa.wiki.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;


public class RequestContext implements Serializable {

    private static ThreadLocal<String> remoteAddr=new ThreadLocal<>();

    public static String getRemoteAddr(){
        return remoteAddr.get();
    }

    public static void setRemoteAddr(String remoteAddr){
        RequestContext.remoteAddr.set(remoteAddr);
    }
}
