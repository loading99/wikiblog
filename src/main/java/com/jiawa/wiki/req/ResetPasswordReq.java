package com.jiawa.wiki.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ResetPasswordReq extends PageReq {
    private Long id;


    @NotNull(message = "Password cannot be empty")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$",
            message = "Password should be between 6,32 and contain characters and numbers")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}