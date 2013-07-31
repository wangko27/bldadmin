package com.cnarj.ttxs.pojo.learn;

import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ReadSrc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ReadSrc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private String readsrcid;// 博览群书ID
	private ReadSrcType readSrcType;// 类别
	private SubjectCode subjectCode;// 科目
	private GradeCode gradeCode;// 年级
	private Member member;// 来源
	private String readsrctile;// 标题
	private Long collectionnum;// 收藏次数
	private Long downloadnum;// 下载次数
	private String contentintro;// 内容简介
	private Long sharenum;// 分享次数
	private String photopath;// 图片地址（封面）
	private String readsrcformat;// 格式
	private Long readsrcsize;// 大小
	private Long ratingnum;// 评分人数
	private Long generalscore;// 综合分
	private String srckeywords;// 资源关键字
	private Long readsrcsales;// 销量
	private Date createdate;// 创建日期
	private Date modifydate;// 修改日期
	private String isrecommend; // 是否推荐书籍
	private String ishot;// 是否热销 1是 0否
	private String isenable;// 是否启用 1启用 0不启用
	private String srcpath;// 资源路径
	private String username;// 来源人姓名
	private Long downpoint;// 下载所需积分
	private Long readnum;// 阅读次数
	private Set readSrcDownRecs = new HashSet(0);
	private Set readSrcHandleRecs = new HashSet(0);
	private Set readSrcCommenteds = new HashSet(0);

	// Constructors

	public ReadSrc(String readsrcid, ReadSrcType readSrcType,
			SubjectCode subjectCode, GradeCode gradeCode, Member member,
			String readsrctile, Long collectionnum, Long downloadnum,
			String contentintro, Long sharenum, String photopath,
			String readsrcformat, Long readsrcsize, Long ratingnum,
			Long generalscore, String srckeywords, Long readsrcsales,
			Date createdate, Date modifydate, String isrecommend, String ishot,
			String isenable, String srcpath, String username, Long downpoint,
			Long readnum, Set readSrcDownRecs, Set readSrcHandleRecs,
			Set readSrcCommenteds) {
		super();
		this.readsrcid = readsrcid;
		this.readSrcType = readSrcType;
		this.subjectCode = subjectCode;
		this.gradeCode = gradeCode;
		this.member = member;
		this.readsrctile = readsrctile;
		this.collectionnum = collectionnum;
		this.downloadnum = downloadnum;
		this.contentintro = contentintro;
		this.sharenum = sharenum;
		this.photopath = photopath;
		this.readsrcformat = readsrcformat;
		this.readsrcsize = readsrcsize;
		this.ratingnum = ratingnum;
		this.generalscore = generalscore;
		this.srckeywords = srckeywords;
		this.readsrcsales = readsrcsales;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.isrecommend = isrecommend;
		this.ishot = ishot;
		this.isenable = isenable;
		this.srcpath = srcpath;
		this.username = username;
		this.downpoint = downpoint;
		this.readnum = readnum;
		this.readSrcDownRecs = readSrcDownRecs;
		this.readSrcHandleRecs = readSrcHandleRecs;
		this.readSrcCommenteds = readSrcCommenteds;
	}

	/** default constructor */
	public ReadSrc() {
	}

	// Property accessors

	public String getReadsrcid() {
		return this.readsrcid;
	}

	public void setReadsrcid(String readsrcid) {
		this.readsrcid = readsrcid;
	}

	public ReadSrcType getReadSrcType() {
		return this.readSrcType;
	}

	public void setReadSrcType(ReadSrcType readSrcType) {
		this.readSrcType = readSrcType;
	}

	public SubjectCode getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(SubjectCode subjectCode) {
		this.subjectCode = subjectCode;
	}

	public GradeCode getGradeCode() {
		return this.gradeCode;
	}

	public void setGradeCode(GradeCode gradeCode) {
		this.gradeCode = gradeCode;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getReadsrctile() {
		return this.readsrctile;
	}

	public void setReadsrctile(String readsrctile) {
		this.readsrctile = readsrctile;
	}

	public Long getCollectionnum() {
		return this.collectionnum;
	}

	public void setCollectionnum(Long collectionnum) {
		this.collectionnum = collectionnum;
	}

	public Long getDownloadnum() {
		return this.downloadnum;
	}

	public void setDownloadnum(Long downloadnum) {
		this.downloadnum = downloadnum;
	}

	public String getContentintro() {
		return this.contentintro;
	}

	public void setContentintro(String contentintro) {
		this.contentintro = contentintro;
	}

	public Long getSharenum() {
		return this.sharenum;
	}

	public void setSharenum(Long sharenum) {
		this.sharenum = sharenum;
	}

	public String getPhotopath() {
		return this.photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public String getReadsrcformat() {
		return this.readsrcformat;
	}

	public void setReadsrcformat(String readsrcformat) {
		this.readsrcformat = readsrcformat;
	}

	public Long getReadsrcsize() {
		return this.readsrcsize;
	}

	public void setReadsrcsize(Long readsrcsize) {
		this.readsrcsize = readsrcsize;
	}

	public Long getRatingnum() {
		return this.ratingnum;
	}

	public void setRatingnum(Long ratingnum) {
		this.ratingnum = ratingnum;
	}

	public Long getGeneralscore() {
		return this.generalscore;
	}

	public void setGeneralscore(Long generalscore) {
		this.generalscore = generalscore;
	}

	public String getSrckeywords() {
		return this.srckeywords;
	}

	public void setSrckeywords(String srckeywords) {
		this.srckeywords = srckeywords;
	}

	public Long getReadsrcsales() {
		return this.readsrcsales;
	}

	public void setReadsrcsales(Long readsrcsales) {
		this.readsrcsales = readsrcsales;
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

	public String getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getIshot() {
		return this.ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getIsenable() {
		return this.isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}

	public Set getReadSrcDownRecs() {
		return this.readSrcDownRecs;
	}

	public void setReadSrcDownRecs(Set readSrcDownRecs) {
		this.readSrcDownRecs = readSrcDownRecs;
	}

	public Set getReadSrcHandleRecs() {
		return this.readSrcHandleRecs;
	}

	public void setReadSrcHandleRecs(Set readSrcHandleRecs) {
		this.readSrcHandleRecs = readSrcHandleRecs;
	}

	public Set getReadSrcCommenteds() {
		return this.readSrcCommenteds;
	}

	public void setReadSrcCommenteds(Set readSrcCommenteds) {
		this.readSrcCommenteds = readSrcCommenteds;
	}

	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDownpoint() {
		return downpoint;
	}

	public void setDownpoint(Long downpoint) {
		this.downpoint = downpoint;
	}

	public Long getReadnum() {
		return readnum;
	}

	public void setReadnum(Long readnum) {
		this.readnum = readnum;
	}

}