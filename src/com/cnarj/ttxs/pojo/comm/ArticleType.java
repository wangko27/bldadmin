package com.cnarj.ttxs.pojo.comm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ArticleType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ArticleType implements java.io.Serializable {

	// Fields

	private String articletypeid;
	private ArticleType articleType;
	private String articletypename;
	private Long articlesort;
	private Date createdate;
	private Date modifydate;
	private Set articleTypes = new HashSet(0);
	private Set articleSrcs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ArticleType() {
	}

	/** full constructor */
	public ArticleType(ArticleType articleType, String articletypename,
			Long articlesort, Date createdate, Date modifydate,
			Set articleTypes, Set articleSrcs) {
		this.articleType = articleType;
		this.articletypename = articletypename;
		this.articlesort = articlesort;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.articleTypes = articleTypes;
		this.articleSrcs = articleSrcs;
	}

	// Property accessors

	public String getArticletypeid() {
		return this.articletypeid;
	}

	public void setArticletypeid(String articletypeid) {
		this.articletypeid = articletypeid;
	}

	public ArticleType getArticleType() {
		return this.articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public String getArticletypename() {
		return this.articletypename;
	}

	public void setArticletypename(String articletypename) {
		this.articletypename = articletypename;
	}

	public Long getArticlesort() {
		return this.articlesort;
	}

	public void setArticlesort(Long articlesort) {
		this.articlesort = articlesort;
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

	public Set getArticleTypes() {
		return this.articleTypes;
	}

	public void setArticleTypes(Set articleTypes) {
		this.articleTypes = articleTypes;
	}

	public Set getArticleSrcs() {
		return this.articleSrcs;
	}

	public void setArticleSrcs(Set articleSrcs) {
		this.articleSrcs = articleSrcs;
	}

}