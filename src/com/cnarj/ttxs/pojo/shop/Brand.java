package com.cnarj.ttxs.pojo.shop;

import java.util.HashSet;
import java.util.Set;


/**
 * Brand entity. @author MyEclipse Persistence Tools
 */

public class Brand  implements java.io.Serializable {


    // Fields    

     private String brandid;
     private String brandname;
     private String logo;
     private String website;
     private String introduction;
     private Long orderlist;
     private Set goodses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Brand() {
    }

    
    /** full constructor */
    public Brand(String brandname, String logo, String website, String introduction, Long orderlist, Set goodses) {
        this.brandname = brandname;
        this.logo = logo;
        this.website = website;
        this.introduction = introduction;
        this.orderlist = orderlist;
        this.goodses = goodses;
    }

   
    // Property accessors

    public String getBrandid() {
        return this.brandid;
    }
    
    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return this.brandname;
    }
    
    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }

    public Set getGoodses() {
        return this.goodses;
    }
    
    public void setGoodses(Set goodses) {
        this.goodses = goodses;
    }
   








}