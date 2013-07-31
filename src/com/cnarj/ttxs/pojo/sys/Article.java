package com.cnarj.ttxs.pojo.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-6
 * Time: 上午10:55
 */

public class Article implements Serializable {

    public String id ;
    public String title;
    public String text;
    public Integer type;
    public Date createTime;
    public Date lastModifyTime;
    public Integer orderList;


    public Article() {
    }

    public Article(String id, String title, String text, Integer type, Date createTime, Date lastModifyTime, Integer orderList) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.type = type;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.orderList = orderList;
    }

    public Article(String id, String title, String text, Integer type, Date createTime) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.type = type;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getOrderList() {
        return orderList;
    }

    public void setOrderList(Integer orderList) {
        this.orderList = orderList;
    }

}
