package com.cnarj.ttxs.pojo.stuz;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * UserAddr entity. @author MyEclipse Persistence Tools
 */

public class UserAddr  implements java.io.Serializable {


    // Fields    

     private String useraddrid;
     private Member member;
     private String addr;
     private String zipcode;
     private String addrmobile;
     private String addrphone;
     private Date createdate;
     private Date modifydate;


    // Constructors

    /** default constructor */
    public UserAddr() {
    }

    
    /** full constructor */
    public UserAddr(Member member, String addr, String zipcode, String addrmobile, String addrphone, Date createdate, Date modifydate) {
        this.member = member;
        this.addr = addr;
        this.zipcode = zipcode;
        this.addrmobile = addrmobile;
        this.addrphone = addrphone;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getUseraddrid() {
        return this.useraddrid;
    }
    
    public void setUseraddrid(String useraddrid) {
        this.useraddrid = useraddrid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public String getAddr() {
        return this.addr;
    }
    
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddrmobile() {
        return this.addrmobile;
    }
    
    public void setAddrmobile(String addrmobile) {
        this.addrmobile = addrmobile;
    }

    public String getAddrphone() {
        return this.addrphone;
    }
    
    public void setAddrphone(String addrphone) {
        this.addrphone = addrphone;
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
   








}