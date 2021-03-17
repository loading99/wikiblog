package com.jiawa.wiki.req;

public class EbookReq extends PageReq{
    private long id;
    private String name;
    private long categoryId2;

    public long getId() {
        return id;
    }

    public long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
