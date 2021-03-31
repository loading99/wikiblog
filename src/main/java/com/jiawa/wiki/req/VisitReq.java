package com.jiawa.wiki.req;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class VisitReq {
    private Long id;

    private String ip;

    @NotNull(message = "visited webpage cannot be null!")
    private String web;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ip=").append(ip);
        sb.append(", web=").append(web);
        sb.append(", date=").append(date);
        sb.append("]");
        return sb.toString();
    }
}