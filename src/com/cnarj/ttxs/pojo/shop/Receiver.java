package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;

/**
 * Receiver entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Receiver implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String receiverid;// 收货地址ID
	private Member member;// 收货人
	private String recusername;// 收货人姓名
	private String areapath;// 收货地区路径
	private String receiveraddress;// 地址
	private String receiverphone;// 电话
	private String receivermobile;// 手机
	private String zipcode;// 邮编
	private String isdefault;// 是否默认 1是 0否
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期

	// Constructors

	/** default constructor */
	public Receiver() {
	}

	/** full constructor */
	public Receiver(Member member, String recusername, String areapath,
			String receiveraddress, String receiverphone,
			String receivermobile, String zipcode, String isdefault,
			Date createdate, Date modifydate) {
		this.member = member;
		this.recusername = recusername;
		this.areapath = areapath;
		this.receiveraddress = receiveraddress;
		this.receiverphone = receiverphone;
		this.receivermobile = receivermobile;
		this.zipcode = zipcode;
		this.isdefault = isdefault;
		this.createdate = createdate;
		this.modifydate = modifydate;
	}

	// Property accessors

	public String getReceiverid() {
		return this.receiverid;
	}

	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getRecusername() {
		return this.recusername;
	}

	public void setRecusername(String recusername) {
		this.recusername = recusername;
	}

	public String getAreapath() {
		return this.areapath;
	}

	public void setAreapath(String areapath) {
		this.areapath = areapath;
	}

	public String getReceiveraddress() {
		return this.receiveraddress;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public String getReceiverphone() {
		return this.receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public String getReceivermobile() {
		return this.receivermobile;
	}

	public void setReceivermobile(String receivermobile) {
		this.receivermobile = receivermobile;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
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