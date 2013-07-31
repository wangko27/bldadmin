package com.cnarj.ttxs.pojo.recommend;

import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.sys.LocationInfo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-24
 * Time: 下午4:24
 * 商品推荐
 */
public class GoodsRecommend implements java.io.Serializable {
    private String recommendId;//推荐id
    private Goods goods;//商品id
    private String recommendType;//推荐类型  1表示商品推荐
    private Date createDate;//创建日期
    private Date lastModifyDate;//最后修改日期
    private String recommendState;//推荐状态: 1 表示推荐（默认） 0表示不推荐
    private Admin admin;//后台用户
    private Admin lastModifyUser;//最后修改者
    private LocationInfo locationInfo ;//推荐位置信息
    private String miaoSha;//是否推荐为秒杀商品 0表示不推荐为秒杀商品，1表示推荐为秒杀为商品
    private MiaoSha miao;//秒杀信息
    public GoodsRecommend() {
    }

    public GoodsRecommend(String recommendId, Goods goods, String recommendType, Date createDate,
                          Date lastModifyDate, String recommendState, Admin admin,Admin lastModifyUser,
                          LocationInfo locationInfo,String miaoSha,MiaoSha miao) {
        this.recommendId = recommendId;
        this.goods = goods;
        this.recommendType = recommendType;
        this.createDate = createDate;
        this.lastModifyDate = lastModifyDate;
        this.recommendState = recommendState;
        this.admin = admin;
        this.lastModifyUser = lastModifyUser;
        this.locationInfo = locationInfo;
        this.miaoSha = miaoSha;
        this.miao = miao;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }


    public String getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(String recommendType) {
        this.recommendType = recommendType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getRecommendState() {
        return recommendState;
    }

    public void setRecommendState(String recommendState) {
        this.recommendState = recommendState;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(Admin lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getMiaoSha() {
        return miaoSha;
    }

    public void setMiaoSha(String miaoSha) {
        this.miaoSha = miaoSha;
    }

    public MiaoSha getMiao() {
        return miao;
    }

    public void setMiao(MiaoSha miao) {
        this.miao = miao;
    }
}
