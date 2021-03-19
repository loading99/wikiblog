package com.jiawa.wiki.exception;


public enum BusinessExceptionCode {

    USER_LOGIN_NAME_EXIST("Account Name already exists"),
    LOGIN_USER_ERROR("Account name doesn't exist or password mismatches"),
    VOTE_REPEAT("You already like the item"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
