package com.cnarj.ttxs.pojo.sys;

import java.util.Date;


/**
 * Footer entity. @author MyEclipse Persistence Tools
 */

public class Footer  implements java.io.Serializable {


    // Fields    

     private String footerid;
     private Date createdate;
     private Date modifydate;
     private String footercontent;


    // Constructors

    /** default constructor */
    public Footer() {
    }

    
    /** full constructor */
    public Footer(Date createdate, Date modifydate, String footercontent) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.footercontent = footercontent;
    }

   
    // Property accessors

    public String getFooterid() {
        return this.footerid;
    }
    
    public void setFooterid(String footerid) {
        this.footerid = footerid;
    }

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return this.modifydate;
    }
    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getFootercontent() {
        return this.footercontent;
    }
    
    public void setFootercontent(String footercontent) {
        this.footercontent = footercontent;
    }
   








}