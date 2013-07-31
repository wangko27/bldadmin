package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Navigation entity. @author MyEclipse Persistence Tools
 */

public class Navigation  implements java.io.Serializable {


    // Fields    // 导航位置:顶部、中间、底部
	public enum Position {
		top, middle, bottom
	}

     private String navigationid;
     private Navigation navigation;
     private Date createdate;
     private Date modifydate;
     private String navigationname;
     private Long navigationposition;
     private String navigationurl;
     private String isvisible;
     private String isblanktarget;
     private Long orderlist;
     private Set navigations = new HashSet(0);


    // Constructors

    /** default constructor */
    public Navigation() {
    }

    
    /** full constructor */
    public Navigation(Navigation navigation, Date createdate, Date modifydate, String navigationname, Long navigationposition, String navigationurl, String isvisible, String isblanktarget, Long orderlist, Set navigations) {
        this.navigation = navigation;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.navigationname = navigationname;
        this.navigationposition = navigationposition;
        this.navigationurl = navigationurl;
        this.isvisible = isvisible;
        this.isblanktarget = isblanktarget;
        this.orderlist = orderlist;
        this.navigations = navigations;
    }

   
    // Property accessors

    public String getNavigationid() {
        return this.navigationid;
    }
    
    public void setNavigationid(String navigationid) {
        this.navigationid = navigationid;
    }

    public Navigation getNavigation() {
        return this.navigation;
    }
    
    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
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

    public String getNavigationname() {
        return this.navigationname;
    }
    
    public void setNavigationname(String navigationname) {
        this.navigationname = navigationname;
    }

    public Long getNavigationposition() {
        return this.navigationposition;
    }
    
    public void setNavigationposition(Long navigationposition) {
        this.navigationposition = navigationposition;
    }

    public String getNavigationurl() {
        return this.navigationurl;
    }
    
    public void setNavigationurl(String navigationurl) {
        this.navigationurl = navigationurl;
    }

    public String getIsvisible() {
        return this.isvisible;
    }
    
    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible;
    }

    public String getIsblanktarget() {
        return this.isblanktarget;
    }
    
    public void setIsblanktarget(String isblanktarget) {
        this.isblanktarget = isblanktarget;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }

    public Set getNavigations() {
        return this.navigations;
    }
    
    public void setNavigations(Set navigations) {
        this.navigations = navigations;
    }
   








}