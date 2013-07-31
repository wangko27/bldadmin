package com.cnarj.ttxs.web.actions.interest;

import java.util.List;

import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorkCommented;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.interest.IActivityVotesService;
import com.cnarj.ttxs.service.interest.IActivityWorkCommentedService;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.ReadCharacterInfo;
import com.cnarj.ttxs.web.actions.base.PageAction;
/**
 * 该action主要是用作评论的显示
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ActivityWorkCommentedAction extends PageAction {

	private String workId;//作品id
	private String valiedateCode;//验证码
	private String comContent;//评论的内容
	private String hangye;//行业知识
	private IActivityWorkCommentedService commentedService;
	private IActivityWorksService worksService;//跟新投票次数
	private IActivityVotesService votesService;//插入投票记录
	private String proID;//栏目id
	
	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getHangye() {
		return hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	public IActivityWorksService getWorksService() {
		return worksService;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public void setWorksService(IActivityWorksService worksService) {
		this.worksService = worksService;
	}

	public IActivityVotesService getVotesService() {
		return votesService;
	}

	public void setVotesService(IActivityVotesService votesService) {
		this.votesService = votesService;
	}

	public IActivityWorkCommentedService getCommentedService() {
		return commentedService;
	}

	public void setCommentedService(IActivityWorkCommentedService commentedService) {
		this.commentedService = commentedService;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	/**
	 * 作品的详细页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showActivityWorkComm(){
		
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(8);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		ActivityWorks works=commentedService.getByActivityIdActivityWork(workId);
		result=commentedService.getByWorkIdActivityWorkCommenteds(workId,page);
		List<ActivityWorkCommented> list=result.getContent();
		int total=result.getPage().getTotalCount();
		//System.out.println(works.getActivity().getIndustryid());
		this.setAttribute("hangye", works.getActivity().getIndustryid());//行业知识
		//System.out.println(works.getActivity().getActivityid());
		this.setAttribute("activitId", works.getActivity().getActivityid());//活动的id
		showLeft(works.getActivity().getActivityid());
		//System.out.println(works.getActivity().getPrograma().getProID());
		this.setAttribute("activitPro", works.getActivity().getPrograma().getProID());//活动栏目的id
		proID=works.getActivity().getPrograma().getProID();
		//System.out.println(works.getActivity().getActivityfeaphotopath());
		this.setAttribute("activityfeaphotopath", works.getActivity().getActivityfeaphotopath());//// 活动专题图片
		
		List<ActivityWorkPhotos> photos=commentedService.getActivityPhotosbyWorkId(workId);//得到该作品的参赛内容(图片)
		
		this.setAttribute("photos", photos);
		this.setAttribute("works", works);
		this.setAttribute("total", total);
		this.setAttribute("comms", list);
		return "comm";
	}
	
	public String showLeft(String activitId){
		//得到票数最多的10条信息(排行版)
		List<ActivityWorks> fareList=worksService.getByFareActivityWorks(10,false,activitId);
		setAttribute("fareList", fareList);
		//得到(推荐的)活动老师
		List<ActivityTeacher> teachers=worksService.getByActIdActivityTeacher(activitId);
		if(teachers.size()!=0){
			//得到老师的最新博文信息
			Blog blog=worksService.getByTeacherIdBlog(teachers.get(0).getId());
			setAttribute("teachers", teachers);
			if(blog!=null&&blog.getBlogcontent()!=null&&blog.getBlogcontent().trim().equals("")){
				setAttribute("blogcontent", HtmlUtil.splitAndFilterString(blog.getBlogcontent(), 30));
			}
		}
		//得到活动的详细信息
		Activity activity=worksService.getByIdActivity(activitId);
		//System.out.println(activity.getActivityid());
		if(activity!=null&&activity.getActivityintro()!=null&&!activity.getActivityintro().trim().equals("")){
			//System.out.println(HtmlUtil.splitAndFilterString(activity.getActivityintro(), 75));
			setAttribute("activityInfo", HtmlUtil.splitAndFilterString(activity.getActivityintro(), 75));
		}
		setAttribute("hangye", activity.getIndustryid());//该活动的行业知识
		if(activity!=null&&activity.getIndustryid()!=null&&!activity.getIndustryid().trim().equals("")){
			//行业知识
			List<Article> harticles=worksService.getByIndustryidArticles(activity.getIndustryid(), 13,false);
			setAttribute("harticles", harticles);
		}
		if(activity!=null&&activity.getSysnotesid()!=null&&!activity.getSysnotesid().trim().equals("")){
			//活动公告
			List<Article> darticles=worksService.getBySysnotesidArticles(activity.getSysnotesid(),3);
			this.setAttribute("darticles", darticles);
		}
		return "left";
	}

	/**
	 * 用户投票
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String worksFare(){
		//判断用户有没有登录
		try {
			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
			"2                               ");
			String memberid = HttpUtil.getSession(
					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			if (null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)) {
				getResponse().getWriter().print(0);// 未登录
			} else {
				//判断是否有该用户的投票记录 没有就创建
				boolean isEx=votesService.findActivityVtes(workId, memberid);
				if(isEx){
					getResponse().getWriter().print(2);// 未登录
					return null;
				}
				//用户不能对同一中作品投票多次
				votesService.addActivityVote(workId, memberid, this.getRequest().getRemoteAddr());//添加投票记录
				ActivityWorks work= worksService.updateActivityWorksFare(workId);//更改票数记录
				getResponse().getWriter().print(work.getVotes().intValue());
				}
			getResponse().getWriter().close();
		} catch (Exception e) {
			System.out.println("投票失败!");
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户评论
	 * @return
	 */
	public String showCommInfo(){
		//判断用户有没有登录
		try {
			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
			"2                               ");
			String memberid = HttpUtil.getSession(
					Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			if (null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)) {
				getResponse().getWriter().print(0);// 未登录
			} else {
				//判断是否有该用户的投票记录 没有就创建
				boolean isEx=commentedService.isActivityWorkCommentedService(memberid, workId);
				//验证码
				String yanCode=(String) this.getSession("authcode");
				if(!valiedateCode.trim().equalsIgnoreCase(yanCode)){
					getResponse().getWriter().print(1);// 验证码错误
					getResponse().getWriter().close();
					return null;
				}
				if(isEx){
					getResponse().getWriter().print(2);// 以评论
					getResponse().getWriter().close();
					return null;
				}
				//System.out.println(comContent);
				//非法字符集
				ReadCharacterInfo rec=new ReadCharacterInfo();
				List<String> charaList=rec.getCharaList();
				//判断是否含有非法字符
				for(String str:charaList){
					if(comContent.indexOf(str)>-1){
						getResponse().getWriter().print(3);// 含非法字符
						getResponse().getWriter().close();
						return null;
					}
				}
				String comUserName=commentedService.getByUserIdMember(memberid).getUsername();
				commentedService.saveActivityWorkCommentedService(workId, memberid, comContent, comUserName, this.getRequest().getRemoteAddr());
				getResponse().getWriter().print(4);// 评论成功
			}
			getResponse().getWriter().close();
		} catch (Exception e) {
			System.out.println("评论失败失败!");
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
		}
		return null;
	}
	public String getValiedateCode() {
		return valiedateCode;
	}

	public void setValiedateCode(String valiedateCode) {
		this.valiedateCode = valiedateCode;
	}
}
