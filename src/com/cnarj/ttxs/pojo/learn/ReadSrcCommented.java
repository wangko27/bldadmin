package com.cnarj.ttxs.pojo.learn;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * ReadSrcCommented entity. @author MyEclipse Persistence Tools
 */

public class ReadSrcCommented  implements java.io.Serializable {


    // Fields    

     private String commentedid; // 主键
     private Member member; // 评论会员ID
     private ReadSrc readSrc; //被评论书籍ID
     private String commentedcontent; //评论内容
     private String username; //评论用户姓名
     private String ip; //评论IP
     private Date commenteddate; //评论时间
     private String delflag; //删除标志  0正常 1删除
     
     private Long scoring; //所评分数


    // Constructors

    /** default constructor */
    public ReadSrcCommented() {
    }

    
    /** full constructor */
    public ReadSrcCommented(Member member, ReadSrc readSrc, String commentedcontent, String username, String ip, Date commenteddate, String delflag,Long scoring) {
        this.member = member;
        this.readSrc = readSrc;
        this.commentedcontent = commentedcontent;
        this.username = username;
        this.ip = ip;
        this.commenteddate = commenteddate;
        this.delflag = delflag;
        this.scoring = scoring;
    }

   
    // Property accessors

    public String getCommentedid() {
        return this.commentedid;
    }
    
    public void setCommentedid(String commentedid) {
        this.commentedid = commentedid;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public ReadSrc getReadSrc() {
        return this.readSrc;
    }
    
    public void setReadSrc(ReadSrc readSrc) {
        this.readSrc = readSrc;
    }

    public String getCommentedcontent() {
        return this.commentedcontent;
    }
    
    public void setCommentedcontent(String commentedcontent) {
        this.commentedcontent = commentedcontent;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCommenteddate() {
        return this.commenteddate;
    }
    
    public void setCommenteddate(Date commenteddate) {
        this.commenteddate = commenteddate;
    }

    public String getDelflag() {
        return this.delflag;
    }
    
    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }


	public Long getScoring() {
		return scoring;
	}


	public void setScoring(Long scoring) {
		this.scoring = scoring;
	}
   








}