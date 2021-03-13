package com.jiawa.wiki.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


public class PageReq {

    @NotNull(message="Page cannot be null")
    private int page;

    @NotNull(message="Size cannot be null")
    @Max(value=100,message = "Request exceeds limit!")
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
