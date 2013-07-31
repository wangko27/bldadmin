package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.sys.Admin;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User:liz
 * Date: 13-7-22
 * Time: A.M.9:51
 * 购物车运费模板
 */
public class FeeTemplate {
    private String id;
    private String templateName;        //模板名称
    private String province;            //省份

    private Double firstPrice;          //首价格
    private Double continuePrice;       //续价格

    private Double firstWeight;          //首重量
    private Double continueWeight;      //续重量

    private String firstWeightUnit;      //首重单位
    private String continueWeightUnit;  //续重单位

    private Double price;  //邮费优惠需满足的价格

    private Admin admin;
    private Admin lastModifyAdmin;
    private Date createTime;


    public FeeTemplate() {
    }

    public FeeTemplate(String id, String templateName, String province, Double firstPrice, Double continuePrice,
                       Double firstWeight, Double continueWeight, String firstWeightUnit, String continueWeightUnit,
                       Double price, Admin admin, Admin lastModifyAdmin, Date createTime) {
        this.id = id;
        this.templateName = templateName;
        this.province = province;
        this.firstPrice = firstPrice;
        this.continuePrice = continuePrice;
        this.firstWeight = firstWeight;
        this.continueWeight = continueWeight;
        this.firstWeightUnit = firstWeightUnit;
        this.continueWeightUnit = continueWeightUnit;
        this.price = price;
        this.admin = admin;
        this.lastModifyAdmin = lastModifyAdmin;
        this.createTime = createTime;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(Double firstPrice) {
        this.firstPrice = firstPrice;
    }

    public Double getContinuePrice() {
        return continuePrice;
    }

    public void setContinuePrice(Double continuePrice) {
        this.continuePrice = continuePrice;
    }

    public Double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Double getContinueWeight() {
        return continueWeight;
    }

    public void setContinueWeight(Double continueWeight) {
        this.continueWeight = continueWeight;
    }

    public String getFirstWeightUnit() {
        return firstWeightUnit;
    }

    public void setFirstWeightUnit(String firstWeightUnit) {
        this.firstWeightUnit = firstWeightUnit;
    }

    public String getContinueWeightUnit() {
        return continueWeightUnit;
    }

    public void setContinueWeightUnit(String continueWeightUnit) {
        this.continueWeightUnit = continueWeightUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getLastModifyAdmin() {
        return lastModifyAdmin;
    }

    public void setLastModifyAdmin(Admin lastModifyAdmin) {
        this.lastModifyAdmin = lastModifyAdmin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
