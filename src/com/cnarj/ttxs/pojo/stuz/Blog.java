package com.cnarj.ttxs.pojo.stuz;

import java.util.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.user.Member;


/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog  implements java.io.Serializable {

	//操作上一篇下一篇
	 private Boolean blogpre = true;
	 private Boolean blognext = true;

    // Fields    

     private String blogid;
     private String blogtitle;
     private String blogcontent;
     private Long viewperm;
     private String viewpwd;
     private String blacklist;
     private String useridlist;
     private String usernamelist;
     private String usertype;
     private Timestamp createdate;
     private Date modifydate;
     
     private Long readnum;
     private Long commentnum;
     private Member member;


     private Set blogcomments = new HashSet(0);

    // Constructors



	/** default constructor */
    public Blog() {
    }

    
    /** full constructor */

    public Blog(String blogid, String blogtitle, String blogcontent,
    		Long viewperm, String viewpwd, String blacklist,
			String useridlist, String usernamelist, String usertype,
			Timestamp createdate, Date modifydate, Long readnum, Long commentnum,Member member,
			Set blogcomments) {
		
		this.blogid = blogid;
		this.blogtitle = blogtitle;
		this.blogcontent = blogcontent;
		this.viewperm = viewperm;
		this.viewpwd = viewpwd;
		this.blacklist = blacklist;
		this.useridlist = useridlist;
		this.usernamelist = usernamelist;
		this.usertype = usertype;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.readnum = readnum;
		this.commentnum = commentnum;
		this.member = member;
		this.blogcomments = blogcomments;
	}

   
    // Property accessors

    public String getBlogid() {
        return this.blogid;
    }
    
    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getBlogtitle() {
        return this.blogtitle;
    }
    
    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getBlogcontent() {
        return this.blogcontent;
    }
    
    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent;
    }

    public Long getViewperm() {
        return this.viewperm;
    }
    
    public void setViewperm(Long viewperm) {
        this.viewperm = viewperm;
    }

    public String getViewpwd() {
        return this.viewpwd;
    }
    
    public void setViewpwd(String viewpwd) {
        this.viewpwd = viewpwd;
    }

    public String getBlacklist() {
        return this.blacklist;
    }
    
    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist;
    }

    public String getUseridlist() {
        return this.useridlist;
    }
    
    public void setUseridlist(String useridlist) {
        this.useridlist = useridlist;
    }

    public String getUsernamelist() {
        return this.usernamelist;
    }
    
    public void setUsernamelist(String usernamelist) {
        this.usernamelist = usernamelist;
    }

    public String getUsertype() {
        return this.usertype;
    }
    
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return this.modifydate;
    }
    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
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


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Set getBlogcomments() {
		return blogcomments;
	}


	public void setBlogcomments(Set blogcomments) {
		this.blogcomments = blogcomments;
	}


	public Boolean getBlogpre() {		return blogpre;	}
	public void setBlogpre(Boolean blogpre) {		this.blogpre = blogpre;	}
	public Boolean getBlognext() {		return blognext;	}
	public void setBlognext(Boolean blognext) {		this.blognext = blognext;	}

	









}