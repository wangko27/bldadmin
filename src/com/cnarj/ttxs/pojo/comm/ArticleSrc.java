package com.cnarj.ttxs.pojo.comm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * ArticleSrc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ArticleSrc implements java.io.Serializable {

	// Fields

	private String articlesrcid;
	private ArticleType articleType;
	private SubjectCode subjectcode;
	private GradeCode gradecode;
	private Member member;
	private String articletitle;
	private String articleintro;
	private Long pagecount;
	private String articlesrccontent;
	private Long publishertype;
	private Long collectionnum;
	private Long sharenum;
	private Long userpushnum;// 用户推荐数
	private String metakeywords;
	private String schoolname;
	private String albumspath;
	private String ispublication;
	private String istop;
	private String isrecommend;
	private String htmlfilepath;
	private Date createdate;
	private Date modifydate;
	private Set Articlehandlerecs = new HashSet(0);
	private Set Articlecommentinfos = new HashSet(0);
	
	//2011年9月26日11:35:13 update by sly
	private String artfrom;//文章来源
	private String coverpath;//封面路径

	// Constructors

	/** default constructor */
	public ArticleSrc() {
	}

	/** full constructor */
	public ArticleSrc(ArticleType articleType, SubjectCode ttxsSysSubjectcode,
			GradeCode ttxsSysGradecode, Member ttxsUserMember,
			String articletitle, String articleintro, Long pagecount,
			String articlesrccontent, Long publishertype, Long collectionnum,
			Long sharenum, String metakeywords, String schoolname,
			String albumspath, String ispublication, String istop,
			String isrecommend, String htmlfilepath, Date createdate,
			Date modifydate, Set Articlehandlerecs, Set Articlecommentinfos,
			Long userpushnum, String artfrom,String coverpath) {
		this.articleType = articleType;
		this.subjectcode = ttxsSysSubjectcode;
		this.gradecode = ttxsSysGradecode;
		this.member = ttxsUserMember;
		this.articletitle = articletitle;
		this.articleintro = articleintro;
		this.pagecount = pagecount;
		this.articlesrccontent = articlesrccontent;
		this.publishertype = publishertype;
		this.collectionnum = collectionnum;
		this.sharenum = sharenum;
		this.metakeywords = metakeywords;
		this.schoolname = schoolname;
		this.albumspath = albumspath;
		this.ispublication = ispublication;
		this.istop = istop;
		this.isrecommend = isrecommend;
		this.htmlfilepath = htmlfilepath;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.Articlehandlerecs = Articlehandlerecs;
		this.Articlecommentinfos = Articlecommentinfos;
		this.userpushnum = userpushnum;
		this.artfrom = artfrom;
		this.coverpath = coverpath;
	}

	// Property accessors

	public String getArticlesrcid() {
		return this.articlesrcid;
	}

	public void setArticlesrcid(String articlesrcid) {
		this.articlesrcid = articlesrcid;
	}

	public ArticleType getArticleType() {
		return this.articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public SubjectCode getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(SubjectCode subjectcode) {
		this.subjectcode = subjectcode;
	}

	public GradeCode getGradecode() {
		return gradecode;
	}

	public void setGradecode(GradeCode gradecode) {
		this.gradecode = gradecode;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getArticletitle() {
		return this.articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public String getArticleintro() {
		return this.articleintro;
	}

	public void setArticleintro(String articleintro) {
		this.articleintro = articleintro;
	}

	public Long getPagecount() {
		return this.pagecount;
	}

	public void setPagecount(Long pagecount) {
		this.pagecount = pagecount;
	}

	public String getArticlesrccontent() {
		return this.articlesrccontent;
	}

	public void setArticlesrccontent(String articlesrccontent) {
		this.articlesrccontent = articlesrccontent;
	}

	public Long getPublishertype() {
		return this.publishertype;
	}

	public void setPublishertype(Long publishertype) {
		this.publishertype = publishertype;
	}

	public Long getCollectionnum() {
		return this.collectionnum;
	}

	public void setCollectionnum(Long collectionnum) {
		this.collectionnum = collectionnum;
	}

	public Long getSharenum() {
		return this.sharenum;
	}

	public void setSharenum(Long sharenum) {
		this.sharenum = sharenum;
	}

	public String getMetakeywords() {
		return this.metakeywords;
	}

	public void setMetakeywords(String metakeywords) {
		this.metakeywords = metakeywords;
	}

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getAlbumspath() {
		return this.albumspath;
	}

	public void setAlbumspath(String albumspath) {
		this.albumspath = albumspath;
	}

	public String getIspublication() {
		return this.ispublication;
	}

	public void setIspublication(String ispublication) {
		this.ispublication = ispublication;
	}

	public String getIstop() {
		return this.istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getHtmlfilepath() {
		return this.htmlfilepath;
	}

	public void setHtmlfilepath(String htmlfilepath) {
		this.htmlfilepath = htmlfilepath;
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

	public Set getArticlehandlerecs() {
		return Articlehandlerecs;
	}

	public void setArticlehandlerecs(Set articlehandlerecs) {
		Articlehandlerecs = articlehandlerecs;
	}

	public Set getArticlecommentinfos() {
		return Articlecommentinfos;
	}

	public void setArticlecommentinfos(Set articlecommentinfos) {
		Articlecommentinfos = articlecommentinfos;
	}

	public Long getUserpushnum() {
		return userpushnum;
	}

	public void setUserpushnum(Long userpushnum) {
		this.userpushnum = userpushnum;
	}

	public String getArtfrom() {
		return artfrom;
	}

	public void setArtfrom(String artfrom) {
		this.artfrom = artfrom;
	}

	public String getCoverpath() {
		return coverpath;
	}

	public void setCoverpath(String coverpath) {
		this.coverpath = coverpath;
	}
	
}