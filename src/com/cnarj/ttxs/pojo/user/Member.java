package com.cnarj.ttxs.pojo.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Member entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Member  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 360250773084531676L;
	
	public static final String LOGIN_MEMBER_ID_SESSION_NAME = "loginMemberId";// 保存登录会员ID的Session名称
	public static final String LOGIN_MEMBER_USERNAME_COOKIE_NAME = "loginMemberUsername";// 保存登录会员用户名的Cookie名称
	public static final String LOGIN_MEMBER_TYPE = "loginMemberType";//会员登录类型
	public static final String LOGIN_REDIRECTION_URL_SESSION_NAME = "redirectionUrl";// 保存登录来源URL的Session名称
	public static final String LOGIN_MEMBER_SESSION_XXID = "loginMemberXxid";//保存登录会员所属学校id名称
	public static final String LOGIN_MEMBER_SESSION_DSISUSERID = "dsisUserid";
	
	//update by sly 20110819
	public static final String LOGIN_MEMBER_HEADPATH = "loginMemberHeadpath";//会员头像路径
	public static final String LOGIN_MEMBER_NIKENAME = "loginMemberNikename";//会员昵称
	public static final String LOGIN_MEMBER_POINT = "loginMemberPoint";//会员积分
	public static final String LOGIN_MEMBER_EMAIL ="loginMemberEmail";//会员邮箱
    // Fields    

     private String memberid;
     private Long memberType; // 1. 学生, 2. 家长,  3. 教师,  4. 其他注册用户
     private MemberRank memberRank;
     private Date createdate;
     private Date modifydate;
     private String username;
     private String memberpassword;
     private String email;
     private String safequestion;
     private String safeanswer;
     private Long memberpoint;
     private Long deposit;
     private String isaccountenabled;
     private String isaccountlocked;//账号是否启用 1启用 0禁用
     private Long loginfailurecount;//账号是否锁定 1未锁定 0锁定
     private Date lockeddate;
     private String registip;
     private String loginip;
     private Date logindate;
     private String passwordrecoverkey;
     private String headpath;
     private Long dsisuserid;
     private String nikename;//昵称
     private String xxid;//所属学校id
     private String mobilephone;//手机号码 用来找回密码
     private MemberAddInfo memberAddInfo;//会员扩展表
     
     private Date keycreatedate; //密码找回Key的设置时间
     
	 private Set srcRatDetails = new HashSet(0);
     private Set friendsInfosForFrienduserid = new HashSet(0);
     private Set memberPoints = new HashSet(0);
     private Set friendsInfosForUserid = new HashSet(0);
     private Set zealAnswers = new HashSet(0);
     private Set answers = new HashSet(0);
     private Set msgInfosForRecuserid = new HashSet(0);
     private Set zoneVisitsesForIntervieweesuserid = new HashSet(0);
     private Set articleSrcs = new HashSet(0);
     private Set msgInfosForSenduserid = new HashSet(0);
     private Set actionRecs = new HashSet(0);
     private Set carItems = new HashSet(0);
     private Set readSrcDownRecs = new HashSet(0);
     private Set readSrcs = new HashSet(0);
     private Set articleCommentInfos = new HashSet(0);
     private Set srcs = new HashSet(0);
     private Set readSrcCommenteds = new HashSet(0);
     private Set articleHandleRecs = new HashSet(0);
     private Set zoneVisitsesForVisitorsuserid = new HashSet(0);
     private Set deposits = new HashSet(0);
     private Set orderses = new HashSet(0);
     private Set userAddrs = new HashSet(0);
     private Set srcHandleRecs = new HashSet(0);
     private Set receivers = new HashSet(0);
     private Set readSrcHandleRecs = new HashSet(0);
     
     private Set activityTeacher = new HashSet(0);
     private Set activityWorks = new HashSet(0);
     private Set question = new HashSet(0);
     
     private Set blogs = new HashSet(0);
     private Set blogcomments = new HashSet(0);



	/** default constructor */
    public Member() {
    }

    
    /** full constructor */
	public Member(String memberid, Long memberType, MemberRank memberRank,
			Date createdate, Date modifydate, String username,
			String memberpassword, String email, String safequestion,
			String safeanswer, Long memberpoint, Long deposit,
			String isaccountenabled, String isaccountlocked,
			Long loginfailurecount, Date lockeddate, String registip,
			String loginip, Date logindate, String passwordrecoverkey,
			String headpath, Long dsisuserid, String nikename, String xxid,
			String mobilephone, MemberAddInfo memberAddInfo, Set srcRatDetails,
			Set friendsInfosForFrienduserid, Set memberPoints,
			Set friendsInfosForUserid, Set zealAnswers, Set answers,
			Set msgInfosForRecuserid, Set zoneVisitsesForIntervieweesuserid,
			Set articleSrcs, Set msgInfosForSenduserid, Set actionRecs,
			Set carItems, Set readSrcDownRecs, Set readSrcs,
			Set articleCommentInfos, Set srcs, Set readSrcCommenteds,
			Set articleHandleRecs, Set zoneVisitsesForVisitorsuserid,
			Set deposits, Set orderses, Set userAddrs, Set srcHandleRecs,
			Set receivers, Set readSrcHandleRecs, Set activityTeacher,
			Set activityWorks, Set question, Set blogs, Set blogcomments,Date keycreatedate) {
		super();
		this.memberid = memberid;
		this.memberType = memberType;
		this.memberRank = memberRank;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.username = username;
		this.memberpassword = memberpassword;
		this.email = email;
		this.safequestion = safequestion;
		this.safeanswer = safeanswer;
		this.memberpoint = memberpoint;
		this.deposit = deposit;
		this.isaccountenabled = isaccountenabled;
		this.isaccountlocked = isaccountlocked;
		this.loginfailurecount = loginfailurecount;
		this.lockeddate = lockeddate;
		this.registip = registip;
		this.loginip = loginip;
		this.logindate = logindate;
		this.passwordrecoverkey = passwordrecoverkey;
		this.headpath = headpath;
		this.dsisuserid = dsisuserid;
		this.nikename = nikename;
		this.xxid = xxid;
		this.mobilephone = mobilephone;
		this.memberAddInfo = memberAddInfo;
		this.srcRatDetails = srcRatDetails;
		this.friendsInfosForFrienduserid = friendsInfosForFrienduserid;
		this.memberPoints = memberPoints;
		this.friendsInfosForUserid = friendsInfosForUserid;
		this.zealAnswers = zealAnswers;
		this.answers = answers;
		this.msgInfosForRecuserid = msgInfosForRecuserid;
		this.zoneVisitsesForIntervieweesuserid = zoneVisitsesForIntervieweesuserid;
		this.articleSrcs = articleSrcs;
		this.msgInfosForSenduserid = msgInfosForSenduserid;
		this.actionRecs = actionRecs;
		this.carItems = carItems;
		this.readSrcDownRecs = readSrcDownRecs;
		this.readSrcs = readSrcs;
		this.articleCommentInfos = articleCommentInfos;
		this.srcs = srcs;
		this.readSrcCommenteds = readSrcCommenteds;
		this.articleHandleRecs = articleHandleRecs;
		this.zoneVisitsesForVisitorsuserid = zoneVisitsesForVisitorsuserid;
		this.deposits = deposits;
		this.orderses = orderses;
		this.userAddrs = userAddrs;
		this.srcHandleRecs = srcHandleRecs;
		this.receivers = receivers;
		this.readSrcHandleRecs = readSrcHandleRecs;
		this.activityTeacher = activityTeacher;
		this.activityWorks = activityWorks;
		this.question = question;
		this.blogs = blogs;
		this.blogcomments = blogcomments;
		this.keycreatedate = keycreatedate;
	}

	
   
    // Property accessors

    public String getMemberid() {
        return this.memberid;
    }
    
    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }


    public Long getMemberType() {
		return memberType;
	}


	public void setMemberType(Long memberType) {
		this.memberType = memberType;
	}


	public MemberRank getMemberRank() {
        return this.memberRank;
    }
    
    public void setMemberRank(MemberRank memberRank) {
        this.memberRank = memberRank;
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

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMemberpassword() {
        return this.memberpassword;
    }
    
    public void setMemberpassword(String memberpassword) {
        this.memberpassword = memberpassword;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSafequestion() {
        return this.safequestion;
    }
    
    public void setSafequestion(String safequestion) {
        this.safequestion = safequestion;
    }

    public String getSafeanswer() {
        return this.safeanswer;
    }
    
    public void setSafeanswer(String safeanswer) {
        this.safeanswer = safeanswer;
    }

    public Long getMemberpoint() {
        return this.memberpoint;
    }
    
    public void setMemberpoint(Long memberpoint) {
        this.memberpoint = memberpoint;
    }

    public Long getDeposit() {
        return this.deposit;
    }
    
    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public String getIsaccountenabled() {
        return this.isaccountenabled;
    }
    
    public void setIsaccountenabled(String isaccountenabled) {
        this.isaccountenabled = isaccountenabled;
    }

    public String getIsaccountlocked() {
        return this.isaccountlocked;
    }
    
    public void setIsaccountlocked(String isaccountlocked) {
        this.isaccountlocked = isaccountlocked;
    }

    public Long getLoginfailurecount() {
        return this.loginfailurecount;
    }
    
    public void setLoginfailurecount(Long loginfailurecount) {
        this.loginfailurecount = loginfailurecount;
    }

    public Date getLockeddate() {
        return this.lockeddate;
    }
    
    public void setLockeddate(Date lockeddate) {
        this.lockeddate = lockeddate;
    }

    public String getRegistip() {
        return this.registip;
    }
    
    public void setRegistip(String registip) {
        this.registip = registip;
    }

    public String getLoginip() {
        return this.loginip;
    }
    
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Date getLogindate() {
        return this.logindate;
    }
    
    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getPasswordrecoverkey() {
        return this.passwordrecoverkey;
    }
    
    public void setPasswordrecoverkey(String passwordrecoverkey) {
        this.passwordrecoverkey = passwordrecoverkey;
    }
    

    public Long getDsisuserid() {
		return dsisuserid;
	}

	public void setDsisuserid(Long dsisuserid) {
		this.dsisuserid = dsisuserid;
	}


	public Set getSrcRatDetails() {
        return this.srcRatDetails;
    }
    
    public void setSrcRatDetails(Set srcRatDetails) {
        this.srcRatDetails = srcRatDetails;
    }

    public Set getFriendsInfosForFrienduserid() {
        return this.friendsInfosForFrienduserid;
    }
    
    public void setFriendsInfosForFrienduserid(Set friendsInfosForFrienduserid) {
        this.friendsInfosForFrienduserid = friendsInfosForFrienduserid;
    }

    public Set getMemberPoints() {
        return this.memberPoints;
    }
    
    public void setMemberPoints(Set memberPoints) {
        this.memberPoints = memberPoints;
    }

    public Set getFriendsInfosForUserid() {
        return this.friendsInfosForUserid;
    }
    
    public void setFriendsInfosForUserid(Set friendsInfosForUserid) {
        this.friendsInfosForUserid = friendsInfosForUserid;
    }

    public Set getZealAnswers() {
        return this.zealAnswers;
    }
    
    public void setZealAnswers(Set zealAnswers) {
        this.zealAnswers = zealAnswers;
    }

    public Set getAnswers() {
        return this.answers;
    }
    
    public void setAnswers(Set answers) {
        this.answers = answers;
    }

    public Set getMsgInfosForRecuserid() {
        return this.msgInfosForRecuserid;
    }
    
    public void setMsgInfosForRecuserid(Set msgInfosForRecuserid) {
        this.msgInfosForRecuserid = msgInfosForRecuserid;
    }

    public Set getZoneVisitsesForIntervieweesuserid() {
        return this.zoneVisitsesForIntervieweesuserid;
    }
    
    public void setZoneVisitsesForIntervieweesuserid(Set zoneVisitsesForIntervieweesuserid) {
        this.zoneVisitsesForIntervieweesuserid = zoneVisitsesForIntervieweesuserid;
    }

    public Set getArticleSrcs() {
        return this.articleSrcs;
    }
    
    public void setArticleSrcs(Set articleSrcs) {
        this.articleSrcs = articleSrcs;
    }

    public Set getMsgInfosForSenduserid() {
        return this.msgInfosForSenduserid;
    }
    
    public void setMsgInfosForSenduserid(Set msgInfosForSenduserid) {
        this.msgInfosForSenduserid = msgInfosForSenduserid;
    }

    public Set getActionRecs() {
        return this.actionRecs;
    }
    
    public void setActionRecs(Set actionRecs) {
        this.actionRecs = actionRecs;
    }

    public Set getCarItems() {
        return this.carItems;
    }
    
    public void setCarItems(Set carItems) {
        this.carItems = carItems;
    }

    public Set getReadSrcDownRecs() {
        return this.readSrcDownRecs;
    }
    
    public void setReadSrcDownRecs(Set readSrcDownRecs) {
        this.readSrcDownRecs = readSrcDownRecs;
    }

    public Set getReadSrcs() {
        return this.readSrcs;
    }
    
    public void setReadSrcs(Set readSrcs) {
        this.readSrcs = readSrcs;
    }

    public Set getArticleCommentInfos() {
        return this.articleCommentInfos;
    }
    
    public void setArticleCommentInfos(Set articleCommentInfos) {
        this.articleCommentInfos = articleCommentInfos;
    }

    public Set getSrcs() {
        return this.srcs;
    }
    
    public void setSrcs(Set srcs) {
        this.srcs = srcs;
    }

    public Set getReadSrcCommenteds() {
        return this.readSrcCommenteds;
    }
    
    public void setReadSrcCommenteds(Set readSrcCommenteds) {
        this.readSrcCommenteds = readSrcCommenteds;
    }

    public Set getArticleHandleRecs() {
        return this.articleHandleRecs;
    }
    
    public void setArticleHandleRecs(Set articleHandleRecs) {
        this.articleHandleRecs = articleHandleRecs;
    }

    public Set getZoneVisitsesForVisitorsuserid() {
        return this.zoneVisitsesForVisitorsuserid;
    }
    
    public void setZoneVisitsesForVisitorsuserid(Set zoneVisitsesForVisitorsuserid) {
        this.zoneVisitsesForVisitorsuserid = zoneVisitsesForVisitorsuserid;
    }

    public Set getDeposits() {
        return this.deposits;
    }
    
    public void setDeposits(Set deposits) {
        this.deposits = deposits;
    }

    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }

    public Set getUserAddrs() {
        return this.userAddrs;
    }
    
    public void setUserAddrs(Set userAddrs) {
        this.userAddrs = userAddrs;
    }

    public Set getSrcHandleRecs() {
        return this.srcHandleRecs;
    }
    
    public void setSrcHandleRecs(Set srcHandleRecs) {
        this.srcHandleRecs = srcHandleRecs;
    }

    public Set getReceivers() {
        return this.receivers;
    }
    
    public void setReceivers(Set receivers) {
        this.receivers = receivers;
    }

    public Set getReadSrcHandleRecs() {
        return this.readSrcHandleRecs;
    }
    
    public void setReadSrcHandleRecs(Set readSrcHandleRecs) {
        this.readSrcHandleRecs = readSrcHandleRecs;
    }

	public Set getActivityTeacher() {
		return activityTeacher;
	}

	public void setActivityTeacher(Set activityTeacher) {
		this.activityTeacher = activityTeacher;
	}

	public Set getActivityWorks() {
		return activityWorks;
	}

	public void setActivityWorks(Set activityWorks) {
		this.activityWorks = activityWorks;
	}

	public Set getQuestion() {
		return question;
	}

	public void setQuestion(Set question) {
		this.question = question;
	}

	public Set getBlogs() {
		return blogs;
	}

	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

	public String getHeadpath() {
		return headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public Set getBlogcomments() {
		return blogcomments;
	}

	public void setBlogcomments(Set blogcomments) {
		this.blogcomments = blogcomments;
	}


	public String getNikename() {
		return nikename;
	}


	public void setNikename(String nikename) {
		this.nikename = nikename;
	}


	public String getXxid() {
		return xxid;
	}

	public void setXxid(String xxid) {
		this.xxid = xxid;
	}


	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public MemberAddInfo getMemberAddInfo() {
		return memberAddInfo;
	}

	public void setMemberAddInfo(MemberAddInfo memberAddInfo) {
		this.memberAddInfo = memberAddInfo;
	}


	public Date getKeycreatedate() {
		return keycreatedate;
	}


	public void setKeycreatedate(Date keycreatedate) {
		this.keycreatedate = keycreatedate;
	}

	
   
}