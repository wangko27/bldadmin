package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;

import com.cnarj.ttxs.pojo.user.Member;

/**
 * albums entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class albums implements java.io.Serializable {

	// Fields

	private String albumid;
	private Member member;
	private String albumname;
	private String albumpath;
	private String albumcoverpath;
	/**
	 * 1 所有人
	   2 所有好友
	   3 仅主人
	 */
	private Long viewperm;
	private String albumpwd;
	private Long readnum;
	private Long commentnum;
	private String blacklist;
	private String useridlist;
	private String usernamelist;
	private String usertypelist;
	private Date createdate;
	private Date modifydate;
	
	private Long photonum;
	private String albumnotes;
	private Long orderList;
	private String isdefault;
	
	
	public albums() {
		
	}
	
	
	
	public albums(Member member, String albumname, String albumpath,
			String albumcoverpath, Long viewperm, String albumpwd,
			Long readnum, Long commentnum, String blacklist, String useridlist,
			String usernamelist, String usertypelist, Date createdate,
			Date modifydate,Long photonum,String albumnotes,Long orderList,String isdefault) {
	
		this.member = member;
		this.albumname = albumname;
		this.albumpath = albumpath;
		this.albumcoverpath = albumcoverpath;
		this.viewperm = viewperm;
		this.albumpwd = albumpwd;
		this.readnum = readnum;
		this.commentnum = commentnum;
		this.blacklist = blacklist;
		this.useridlist = useridlist;
		this.usernamelist = usernamelist;
		this.usertypelist = usertypelist;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.photonum = photonum;
		this.albumnotes = albumnotes;
		this.orderList = orderList;
		this.isdefault = isdefault;
	}


	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public Long getPhotonum() {
		return photonum;
	}
	public void setPhotonum(Long photonum) {
		this.photonum = photonum;
	}
	public String getAlbumnotes() {
		return albumnotes;
	}
	public void setAlbumnotes(String albumnotes) {
		this.albumnotes = albumnotes;
	}
	public Long getOrderList() {
		return orderList;
	}
	public void setOrderList(Long orderList) {
		this.orderList = orderList;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public String getAlbumpath() {
		return albumpath;
	}
	public void setAlbumpath(String albumpath) {
		this.albumpath = albumpath;
	}
	public String getAlbumcoverpath() {
		return albumcoverpath;
	}
	public void setAlbumcoverpath(String albumcoverpath) {
		this.albumcoverpath = albumcoverpath;
	}
	public Long getViewperm() {
		return viewperm;
	}
	public void setViewperm(Long viewperm) {
		this.viewperm = viewperm;
	}
	public String getAlbumpwd() {
		return albumpwd;
	}
	public void setAlbumpwd(String albumpwd) {
		this.albumpwd = albumpwd;
	}
	public Long getReadnum() {
		return readnum;
	}
	public void setReadnum(Long readnum) {
		this.readnum = readnum;
	}
	public Long getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(Long commentnum) {
		this.commentnum = commentnum;
	}
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	public String getUseridlist() {
		return useridlist;
	}
	public void setUseridlist(String useridlist) {
		this.useridlist = useridlist;
	}
	public String getUsernamelist() {
		return usernamelist;
	}
	public void setUsernamelist(String usernamelist) {
		this.usernamelist = usernamelist;
	}
	public String getUsertypelist() {
		return usertypelist;
	}
	public void setUsertypelist(String usertypelist) {
		this.usertypelist = usertypelist;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	
}