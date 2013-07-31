package com.cnarj.ttxs.web.actions.member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.stuz.blogcomment;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.service.member.IBlogCommentService;
import com.cnarj.ttxs.service.member.IBlogService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.util.Pubfun;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 空间博文控制类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月16日9:54:49
 */
@Validation
@SuppressWarnings("serial")
public class BlogAction extends PageAction {

	private IBlogService blogService;
	private IBlogCommentService blogCommentService;
	private IActionRecService actionRecService; 
	
	private Blog blog;
	private String oper;
	
	private List<Blog> bloglist;
	private List<blogcomment> comlist;
	
	private String comcontent;
	private String blogid;
	private String comid;
	
	private int blogtype;//查询时使用 1 查自己 2 查好友 3 查全部（同班同学） 


	private String memberid;
	//getter and setter


	
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}

	public int getBlogtype() {
		return blogtype;
	}
	public void setBlogtype(int blogtype) {
		this.blogtype = blogtype;
	}
	public IActionRecService getActionRecService() {
		return actionRecService;
	}
	public void setActionRecService(IActionRecService actionRecService) {
		this.actionRecService = actionRecService;
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
	
	//methods	
	@Validations( 
	requiredStrings={ 
			@RequiredStringValidator(fieldName="blog.blogtitle",message="博文标题不能为空!",trim = true),
			@RequiredStringValidator(fieldName="blog.blogcontent",message="博文内容不能为空!",trim = true)
			},
	stringLengthFields = {
			@StringLengthFieldValidator(fieldName="blog.blogtitle",
					message = "博文标题长度必须在 ${minLength}-${maxLength}之间",
					shortCircuit = true,
					trim = true, 
					minLength = "1", 
					maxLength = "256")
			}
		) 
	public String add(){
		
		try{
			//判断数据
			if(blog.getViewperm() == 4 && blog.getViewpwd().length() == 0){
				this.addActionMessage("请输入加密密码!");
				return ERROR;
			}
			
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			Timestamp nowtime = new Timestamp(now.getTime());
			
			blog.setCreatedate(nowtime);
			
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}

			Member me = new Member();
			me.setMemberid(memberid);
			me.setNikename(nikename);
			
			blog.setMember(me);
			blog.setReadnum(Long.parseLong("0"));
			blog.setCommentnum(Long.parseLong("0"));
			blog.setBlogcontent(Pubfun.contentHandle(blog.getBlogcontent()));
			
			blogService.save(blog);
			
			blog.setBlogpre(blogService.isHasPre(blog.getCreatedate(), blog.getMember().getMemberid(),1));
			blog.setBlognext(false);

			//记录动态
			ActionRec actionrec = new ActionRec();
			actionrec.setActiondate(now);
			actionrec.setActionpath1("myspace/comm/blogDetail.action?blog.blogid="+blog.getBlogid());
			actionrec.setActiontitle("发表了博文：");
			actionrec.setActiontype(new Long(2));
			actionrec.setBlog(blog);
			actionrec.setMember(me);
			actionrec.setUsername(me.getNikename());
			actionrec.setOtheractionpath1("Zone/blogDetail.action?blogid="+blog.getBlogid()+"&TTid="+memberid);
			
			actionRecService.save(actionrec);
			
			this.blogtype = 1;
			
			return getBlogDetail();
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("发表博文失败!");
			return ERROR;
		}
		
	}
	
	@Validations( 
			requiredStrings={ 
					@RequiredStringValidator(fieldName="blog.blogtitle",message="博文标题不能为空!",trim = true),
					@RequiredStringValidator(fieldName="blog.blogcontent",message="博文内容不能为空!",trim = true)
					},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="blog.blogtitle",
							message = "博文标题长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256")
					}
				) 
	public String edit(){
		try{
			//判断数据
			if(blog.getViewperm() == 4 && blog.getViewpwd().length() == 0){
				this.addActionMessage("请输入加密密码!");
				return ERROR;
			}
			blog.setBlogcontent(Pubfun.contentHandle(blog.getBlogcontent()));
			blogService.updateBlog(blog);
			this.blogtype = 1;
			
			//此处计算是否有上一页下一页
//			blog.setBlogpre(blogService.isHasPre(blog.getCreatedate(), blog.getMember().getMemberid(),1));
//			blog.setBlognext(false);
			this.addActionMessage("修改成功");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("修改博文失败!");
			return ERROR;
		}
		
	}
	
	/**
	 * 修改之前,查询数据
	 * @return
	 */
	public String upEdit(){
		try{
			this.blog = blogService.load(blog.getBlogid());
			this.oper = "edit";

			blog.setBlogcontent(Pubfun.contentHandleUpdate(blog.getBlogcontent()));

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("加载数据失败,请稍后重试!");
			return ERROR;
		}
	}
	
	/**
	 * 查询Blog详情
	 * @return
	 */
	public String getBlogDetail(){
		try{
			this.blog = blogService.get(blog.getBlogid());
//			System.out.println(this.blogtype);
			//判断是否有上一页下一页
			blog.setBlogpre(blogService.isHasPre(blog.getCreatedate(), this.memberid,this.blogtype));
			blog.setBlognext(blogService.isHasNext(blog.getCreatedate(),this.memberid,this.blogtype));
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
	
	public String del(){
		try{
			
			blogService.delBlog(this.blog.getBlogid(), memberid);
			blogtype = 1;
			this.addActionMessage("博文删除成功!");
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除博文失败,请稍后重试!");
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
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}

			Member me = new Member();
			me.setMemberid(memberid);
			
			blog.setMember(me);
			
			this.blog = blogService.getPre(blog,this.blogtype,this.memberid);
			
			if(null == blog){
				this.addActionMessage("获取上一篇失败!");
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
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}
			System.out.println(memberid);

			Member me = new Member();
			me.setMemberid(memberid);
			
			blog.setMember(me);
			
			this.blog = blogService.getNext(blog,this.blogtype,this.memberid);
			
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
	
	/**
	 * 查询我的博文列表 分页
	 * @return
	 */
	public String list(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				return ERROR;
			}

			//设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ZONEBLOG);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			if(blogtype == 1){
				//查自己的博文
				result = this.blogService.getmyblog(page,memberid);
			}
			else if(blogtype == 2){
				//查好友的博文
				result = this.blogService.getfriendblog(page, memberid);
				
			}
			else if(blogtype == 3){
				//查所有博文
				result = this.blogService.getallblog(page);
			}
			else{
				this.addActionMessage("错误！");
				return ERROR;
			}
			
			if(null != result){
				this.bloglist = result.getContent();
				String filstr = "";
				for(Blog bl : bloglist){
					filstr = HtmlUtil.splitAndFilterString(bl.getBlogcontent(),120);
					bl.setBlogcontent(filstr);
				}
			}

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("拉取数据失败,请稍后重试!");
			return ERROR;
		}
	}

	
	/**
	 * 添加留言
	 * @return
	 */
	public void addComment(){
		try{
			//取会员信息
			Member m = new Member();
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("用户信息不正确!!");
				super.ajaxHtml("exception");
				return;
			}
			m.setMemberid(memberid);
			m.setNikename(nikename);
			
			
			String html = blogCommentService.saveCommentHtml(this.blogid, m,super.getRequest().getRemoteAddr(),this.comcontent,this.comid);
			
			//增加一个留言量
			blogService.updateCommentNum(this.blogid);
			
			super.ajaxHtml(html);
		}catch(Exception e){
			e.printStackTrace();
			super.ajaxHtml("exception");
		}
	}
	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
}
