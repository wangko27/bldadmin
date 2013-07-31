package com.cnarj.ttxs.pojo.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * ArticleType entity. @author MyEclipse Persistence Tools
 */

public class SysArticleType  implements java.io.Serializable {


    // Fields    

     private String articletypeid;
     private SysArticleType articleType;
     private String articletypename;
     private Long articlesort;
     private String articletypepath;
     private Date createdate;
     private Date modifydate;
     private Set articleTypes = new HashSet(0);
     private Set articles = new HashSet(0);


    // Constructors

    /** default constructor */
    public SysArticleType() {
    }

    
    /** full constructor */
    public SysArticleType(SysArticleType articleType, String articletypename, Long articlesort, String articletypepath, Date createdate, Date modifydate, Set articleTypes, Set articles) {
        this.articleType = articleType;
        this.articletypename = articletypename;
        this.articlesort = articlesort;
        this.articletypepath = articletypepath;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.articleTypes = articleTypes;
        this.articles = articles;
    }

   
    // Property accessors

    public String getArticletypeid() {
        return this.articletypeid;
    }
    
    public void setArticletypeid(String articletypeid) {
        this.articletypeid = articletypeid;
    }

    public SysArticleType getArticleType() {
        return this.articleType;
    }
    
    public void setArticleType(SysArticleType articleType) {
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

    public String getArticletypepath() {
        return this.articletypepath;
    }
    
    public void setArticletypepath(String articletypepath) {
        this.articletypepath = articletypepath;
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

    public Set getArticles() {
        return this.articles;
    }
    
    public void setArticles(Set articles) {
        this.articles = articles;
    }
   








}