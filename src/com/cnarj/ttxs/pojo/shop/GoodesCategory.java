package com.cnarj.ttxs.pojo.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * GoodesCategory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GoodesCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private String categoryid;// 商品分类ID
	private GoodesCategory goodesCategory;// 上级分类
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	private String categoryname;// 分类名称
	private String metakeywords;// 页面关键词
	private String metadescription;// 页面描述
	private Long orderlist;// 排序
	private String categorypath;// 树路径
	private Set goodses = new HashSet(0);
	private List<GoodesCategory> goodesCategories = new ArrayList<GoodesCategory>(0);
	private Long goodsnum;// 商品数量
	private String ishot;// 是否热销类别

	// Constructors

	/** default constructor */
	public GoodesCategory() {
	}

	/** full constructor */
	public GoodesCategory(GoodesCategory goodesCategory, Date createdate,
			Date modifydate, String categoryname, String metakeywords,
			String metadescription, Long orderlist, String categorypath,
			Set goodses, Set goodesCategoriesm, Long goodsnum, String ishot) {
		this.goodesCategory = goodesCategory;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.categoryname = categoryname;
		this.metakeywords = metakeywords;
		this.metadescription = metadescription;
		this.orderlist = orderlist;
		this.categorypath = categorypath;
		this.goodses = goodses;
		
	}

	// Property accessors

	public String getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public GoodesCategory getGoodesCategory() {
		return this.goodesCategory;
	}

	public void setGoodesCategory(GoodesCategory goodesCategory) {
		this.goodesCategory = goodesCategory;
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

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getMetakeywords() {
		return this.metakeywords;
	}

	public void setMetakeywords(String metakeywords) {
		this.metakeywords = metakeywords;
	}

	public String getMetadescription() {
		return this.metadescription;
	}

	public void setMetadescription(String metadescription) {
		this.metadescription = metadescription;
	}

	public Long getOrderlist() {
		return this.orderlist;
	}

	public void setOrderlist(Long orderlist) {
		this.orderlist = orderlist;
	}

	public String getCategorypath() {
		return this.categorypath;
	}

	public void setCategorypath(String categorypath) {
		this.categorypath = categorypath;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Long getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(Long goodsnum) {
		this.goodsnum = goodsnum;
	}

	public String getIshot() {
		return ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public List<GoodesCategory> getGoodesCategories() {
		return goodesCategories;
	}

	public void setGoodesCategories(List<GoodesCategory> goodesCategories) {
		this.goodesCategories = goodesCategories;
	}

}