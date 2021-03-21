package com.jiawa.wiki.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class LoginReq{

    @NotEmpty(message = "Account  cannot be empty!")
    private String account;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}