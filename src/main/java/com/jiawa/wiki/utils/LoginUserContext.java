package com.jiawa.wiki.utils;


import com.jiawa.wiki.response.LoginResp;

import java.io.Serializable;

public class LoginUserContext implements Serializable {

    private static ThreadLocal<LoginResp> user = new ThreadLocal<>();

    public static LoginResp getUser() {
        return user.get();
    }

    public static void setUser(LoginResp user) {
        LoginUserContext.user.set(user);
    }

}
