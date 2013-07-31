package com.cnarj.ttxs.web.actions.zone;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.stuz.blogcomment;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.service.member.IBlogCommentService;
import com.cnarj.ttxs.service.member.IBlogService;
import com.cnarj.ttxs.service.member.IFriendsInfoService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 他人空间博文
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月16日14:28:01
 */
@SuppressWarnings("serial")
public class BlogAction extends PageAction {

	private IBlogService blogService;
	private IBlogCommentService blogCommentService;
	private MemberService memberService;
	private IFriendsInfoService friendService;
	
	private String TTid;//所访问的用户Id 
	private Member TTUser;//所访问的用户对象
	
	private Blog blog;
	private String oper;
	
	private List<Blog> bloglist;
	private List<blogcomment> comlist;
	
	private String comcontent;
	private String blogid;
	private String comid;
	private String pwd;
	
	private boolean friendsign = false;//是否已是好友标志
	
	
	//getter and setter

	

	public boolean isFriendsign() {		return friendsign;	}
	public void setFriendsign(boolean friendsign) {		this.friendsign = friendsign;	}
	public IFriendsInfoService getFriendService() {		return friendService;	}
	public void setFriendService(IFriendsInfoService friendService) {		this.friendService = friendService;	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Member getTTUser() {
		return TTUser;
	}
	public void setTTUser(Member user) {
		TTUser = user;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getComcontent() {
		return comcontent;
	}
	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}
	
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public IBlogService getBlogService() {
		return blogService;
	}
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public List<Blog> getBloglist() {
		return bloglist;
	}
	public void setBloglist(List<Blog> bloglist) {
		this.bloglist = bloglist;
	}
	public IBlogCommentService getBlogCommentService() {
		return blogCommentService;
	}
	public void setBlogCommentService(IBlogCommentService blogCommentService) {
		this.blogCommentService = blogCommentService;
	}
	public List<blogcomment> getComlist() {
		return comlist;
	}
	public void setComlist(List<blogcomment> comlist) {
		this.comlist = comlist;
	}
	public String getTTid() {
		return TTid;
	}
	public void setTTid(String tid) {
		TTid = tid;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
	/**
	 * 查询博文列表 分页
	 * @return
	 */
	public String list(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);

			
			//设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ZONEBLOG);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = this.blogService.openGetBlogList(page, memberid, TTid);
			
			this.bloglist = result.getContent();
			String filstr = "";
			for(Blog bl : bloglist){
				filstr = HtmlUtil.splitAndFilterString(bl.getBlogcontent(),120);
				bl.setBlogcontent(filstr);
			}

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("拉取数据失败,请稍后重试!");
			return ERROR;
		}
	}
	
	/**
	 * 查询Blog详情
	 * @return
	 */
	public String getBlogDetail(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);

			this.blog = blogService.opengetBlog(blogid, TTid, memberid, pwd);
			if(null == blog){
				this.addActionMessage("缺少权限！");
				return ERROR;
			}
			//查询留言信息
			comlist = blogCommentService.getListByDate(blog.getBlogid());
			//修改阅读数
			blogService.updateReadNum(blog);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("加载数据失败,请稍后重试!");
			return ERROR;
		}
	}
	
	/**
	 * 查询上一篇
	 */
	public String getPre(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			

			this.blog = blogService.opengetPre(blog, TTid, pwd, memberid);
			if(null == blog){
				this.addActionMessage("缺少权限！");
				return ERROR;
			}
			
			//查询留言信息
			comlist = blogCommentService.getListByDate(blog.getBlogid());
			
			//修改阅读数
			blogService.updateReadNum(blog);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获取上一篇失败!请稍后重试!");
			return ERROR;
		}
	}
	
	/**
	 * 查询下一篇
	 * @return
	 */
	public String getNext(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			
			this.blog = blogService.opengerNext(blog, TTid, pwd, memberid);
			if(null == blog){
				this.addActionMessage("缺少权限！");
				return ERROR;
			}
			
			//查询留言信息
			comlist = blogCommentService.getListByDate(blog.getBlogid());
			
			//修改阅读数
			blogService.updateReadNum(blog);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获取下一篇失败,请稍后重试!");
			return ERROR;
		}
	}

	@Override
	/**
	 * 所有的方法都要判断他人用户信息
	 */
	public void validate() {
		if(this.TTid == null || this.TTid.length() == 0){
			this.addActionError("错误！需指定他人ID");
		}
		else{
			if(null == TTUser){
				TTUser = memberService.get(this.TTid);
				
				String mid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
				if(null != mid && mid.length() > 0){

					//判断是否是好友
					Hashtable table = new Hashtable();
					table.put("memberByUserid.memberid", mid);
					table.put("memberByFrienduserid.memberid", TTid);
					
					this.friendsign = this.friendService.isExist(table);
				}
				
			}
		}
	}
}
