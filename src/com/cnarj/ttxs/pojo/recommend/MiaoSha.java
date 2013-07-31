package com.cnarj.ttxs.pojo.recommend;

import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Admin;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: A.M.9:44
 * 商品秒杀实体类
 */
public class MiaoSha implements Serializable {
    private  String miaoShaId;//秒杀id
    private Goods goods;//商品信息
    private Date beginDate;//秒杀开始日期
    private Date endDate;//秒杀结束日期
    private String state;//秒杀状态；0表示未秒杀 1表示正在秒杀中 2表示已秒杀过 , 3表示即将开始
    private Integer num ;//商品被秒杀次数
    private Admin admin; //秒杀商品推荐人
    private Date createDate;
    private String beginWeekday;//秒杀开始日期是星期几
    private String endWeekday;//秒杀结束日期是星期几
    private Long time;//商品秒杀时长
    private Double miaoPrice;
    private Date lastModifyTime;

    public MiaoSha() {
    }

    public MiaoSha(String miaoShaId, Goods goods, Date beginDate, Date endDate, String state, Integer num, Admin admin,
                   Date createDate, String beginWeekday, String endWeekday, Long time, Double miaoPrice, Date lastModifyTime) {
        this.miaoShaId = miaoShaId;
        this.goods = goods;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.state = state;
        this.num = num;
        this.admin = admin;
        this.createDate = createDate;
        this.beginWeekday = beginWeekday;
        this.endWeekday = endWeekday;
        this.time = time;
        this.miaoPrice = miaoPrice;
        this.lastModifyTime = lastModifyTime;
    }

    public String getMiaoShaId() {

        return miaoShaId;
    }

    public void setMiaoShaId(String miaoShaId) {
        this.miaoShaId = miaoShaId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBeginWeekday() {
        return beginWeekday;
    }

    public void setBeginWeekday(String beginWeekday) {
        this.beginWeekday = beginWeekday;
    }

    public String getEndWeekday() {
        return endWeekday;
    }

    public void setEndWeekday(String endWeekday) {
        this.endWeekday = endWeekday;
    }

    public Double getMiaoPrice() {
        return miaoPrice;
    }

    public void setMiaoPrice(Double miaoPrice) {
        this.miaoPrice = miaoPrice;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
