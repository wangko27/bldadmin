package com.cnarj.ttxs.pojo.interest;

import java.util.Date;

/**
 * 首页活动作品展示
 * 
 * @author 唐其
 * 
 */
public class ActivityWorksShow implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String showId;// ID,主键
	private String showTitle;// 显示标题
	private String showUrl;// 链接地址
	private Long showSort;// 排序
	private String showImgpath;// 显示图片路径
	private Date showCreatedate;// 创建时间
	private Date showModifydate;// 修改时间
	private String showEnabled;// 是否可用，有效性 1有效 0无效

	public ActivityWorksShow() {
		super();
	}

	public ActivityWorksShow(String showId, String showTitle, String showUrl,
			Long showSort, String showImgpath, Date showCreatedate,
			Date showModifydate, String showEnabled) {
		super();
		this.showId = showId;
		this.showTitle = showTitle;
		this.showUrl = showUrl;
		this.showSort = showSort;
		this.showImgpath = showImgpath;
		this.showCreatedate = showCreatedate;
		this.showModifydate = showModifydate;
		this.showEnabled = showEnabled;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

	public Long getShowSort() {
		return showSort;
	}

	public void setShowSort(Long showSort) {
		this.showSort = showSort;
	}

	public String getShowImgpath() {
		return showImgpath;
	}

	public void setShowImgpath(String showImgpath) {
		this.showImgpath = showImgpath;
	}

	public Date getShowCreatedate() {
		return showCreatedate;
	}

	public void setShowCreatedate(Date showCreatedate) {
		this.showCreatedate = showCreatedate;
	}

	public Date getShowModifydate() {
		return showModifydate;
	}

	public void setShowModifydate(Date showModifydate) {
		this.showModifydate = showModifydate;
	}

	public String getShowEnabled() {
		return showEnabled;
	}

	public void setShowEnabled(String showEnabled) {
		this.showEnabled = showEnabled;
	}

}
