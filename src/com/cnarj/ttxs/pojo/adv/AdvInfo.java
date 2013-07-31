package com.cnarj.ttxs.pojo.adv;

import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.List;


/**
 * AdvInfo entity. @author MyEclipse Persistence Tools
 */

public class AdvInfo  implements java.io.Serializable {


    // Fields    
	
	
//	public enum ADVTYPE {
//		top, middle, bottom
//	}
     private String advinfoid;//广告的id
     private Admin admin;//管理员
     private LocationInfo locationInfo;//广告位置
     private Long advtype;//广告类型    1代表图片
     private String hyperlink;//链接
     private String photoid;//图片的名称
     private Long showtype;//表现方式   1代表图片
     private Date showbegindate;//使用时间
     private Date showenddate;//结束时间
     private String advstat;//是否展示 1表示展示  0表示不展示
     private String upusername;//用户名称
     private String upuserip;//广告的上传地址
     private Date createdate;//创建日期
     private Date modifydate;//修改日期

     private String advtitle;//广告标题

    // Constructors

    /** default constructor */
    public AdvInfo() {
    }

	/** minimal constructor */
    public AdvInfo(Admin admin, LocationInfo locationInfo, String advtitle,Long advtype, String hyperlink, String photoid, Long showtype, Date showbegindate, String advstat) {
        this.admin = admin;
        this.locationInfo = locationInfo;
        this.advtype = advtype;
        this.hyperlink = hyperlink;
        this.photoid = photoid;
        this.showtype = showtype;
        this.showbegindate = showbegindate;
        this.advstat = advstat;
        this.advtitle = advtitle;
    }
    
    /** full constructor */
    public AdvInfo(Admin admin, LocationInfo locationInfo, Long advtype, String hyperlink, String photoid, Long showtype, Date showbegindate, Date showenddate, String advstat, String upusername, String upuserip, Date createdate, Date modifydate) {
        this.admin = admin;
        this.locationInfo = locationInfo;
        this.advtype = advtype;
        this.hyperlink = hyperlink;
        this.photoid = photoid;
        this.showtype = showtype;
        this.showbegindate = showbegindate;
        this.showenddate = showenddate;
        this.advstat = advstat;
        this.upusername = upusername;
        this.upuserip = upuserip;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.advtitle = advtitle;
    }

    public static List<String> getImagePaths(String photoid){
        try{
            return new Gson().fromJson(photoid,new TypeToken<List<String>>(){}.getType());
        }catch (Exception e){
            return null;
        }
    }

   
    // Property accessors

    public String getAdvinfoid() {
        return this.advinfoid;
    }
    
    public void setAdvinfoid(String advinfoid) {
        this.advinfoid = advinfoid;
    }

    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LocationInfo getLocationInfo() {
        return this.locationInfo;
    }
    
    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public Long getAdvtype() {
        return this.advtype;
    }
    
    public void setAdvtype(Long advtype) {
        this.advtype = advtype;
    }

    public String getHyperlink() {
        return this.hyperlink;
    }
    
    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getPhotoid() {
        return this.photoid;
    }
    
    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public Long getShowtype() {
        return this.showtype;
    }
    
    public void setShowtype(Long showtype) {
        this.showtype = showtype;
    }

    public Date getShowbegindate() {
        return this.showbegindate;
    }
    
    public void setShowbegindate(Date showbegindate) {
        this.showbegindate = showbegindate;
    }

    public Date getShowenddate() {
        return this.showenddate;
    }
    
    public void setShowenddate(Date showenddate) {
        this.showenddate = showenddate;
    }

    public String getAdvstat() {
        return this.advstat;
    }
    
    public void setAdvstat(String advstat) {
        this.advstat = advstat;
    }

    public String getUpusername() {
        return this.upusername;
    }
    
    public void setUpusername(String upusername) {
        this.upusername = upusername;
    }

    public String getUpuserip() {
        return this.upuserip;
    }
    
    public void setUpuserip(String upuserip) {
        this.upuserip = upuserip;
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

	public String getAdvtitle() {
		return advtitle;
	}

	public void setAdvtitle(String advtitle) {
		this.advtitle = advtitle;
	}
   








}