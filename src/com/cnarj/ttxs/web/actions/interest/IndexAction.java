package com.cnarj.ttxs.web.actions.interest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TSchoolinfo;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.SchoolinfoService;
import com.cnarj.ttxs.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 兴趣Action类 - 首页
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月22日
 */
@SuppressWarnings("serial")
public class IndexAction extends PageAction {

	private IActivityWorksService worksService;
	private IActivityService activityService;
	private IActivityProgramaService programaService;
	private String activityProid;//上面的id
	private String activityColseId;//关闭的id
	private String proh;//该栏目下的行业知识
	private SchoolinfoService schoolinfoService;//学校的id
	
	
	public SchoolinfoService getSchoolinfoService() {
		return schoolinfoService;
	}

	public void setSchoolinfoService(SchoolinfoService schoolinfoService) {
		this.schoolinfoService = schoolinfoService;
	}

	public String getActivityColseId() {
		return activityColseId;
	}

	public String getProh() {
		return proh;
	}

	public void setProh(String proh) {
		this.proh = proh;
	}

	public void setActivityColseId(String activityColseId) {
		this.activityColseId = activityColseId;
	}

	public String getActivityProid() {
		return activityProid;
	}

	public void setActivityProid(String activityProid) {
		this.activityProid = activityProid;
	}

	public IActivityProgramaService getProgramaService() {
		return programaService;
	}

	public void setProgramaService(IActivityProgramaService programaService) {
		this.programaService = programaService;
	}

	public IActivityWorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(IActivityWorksService worksService) {
		this.worksService = worksService;
	}

	public IActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

	public String showIndexPage(){
		if(activityProid==null||activityProid.trim().equals("")){
			List<ActivityPrograma> prolist=programaService.getTopPrograma(true, 1, true);
			if(prolist.size()!=0){
				activityProid=prolist.get(0).getProID();
			}
		}
		if(activityColseId==null){
			List<ActivityPrograma> prolist=programaService.getTopPrograma(true, 1, true);
			if(prolist.size()!=0){
				activityColseId=prolist.get(0).getProID();
			}
		}
		if(activityProid!=null){
			//按导航栏id查找排行版信息(那一个栏目下的排行榜)
			List<ActivityWorks> works=worksService.getByFareActivityWorks(10, true, activityProid);
			//设置学校
			for(ActivityWorks work:works){
				Member member=work.getMember();
				if(member.getXxid()!=null&&!member.getXxid().trim().equals("")){
					TSchoolinfo school = schoolinfoService.get("xxid",member.getXxid());
					work.setSchoolName(school.getSchName());
				}
			}
			this.setAttribute("indexWorks", works);
			
			//显示该栏目下最新的活动(包括最新的照片);
			Activity activi=activityService.getByProIdAndCreateTime(activityProid);
			
			String[] pics=null;
			if(activi!=null){
				ActivityPrograma pro=activi.getPrograma();
				String picPath=activi.getUnlinepath();
				if(picPath!=null){
					File file=new File(this.getRealPath()+picPath);
					pics=file.list();//得到picpath目录中的文件名称
				}
				//显示行业知识(最新)(行业知识的id(拍拍乐))
				List<Article> articles=worksService.getByIndustryidArticles(pro.getProProgramatypeid(), 8,true);
				
				this.setAttribute("indexArt",articles);
				this.setAttribute("indexpic", pics);
				this.setAttribute("indexact", activi);
				//设置内容
				if(activi!=null&&activi.getActivityintro()!=null&&!activi.getActivityintro().equals("")){
					this.setAttribute("indexContext", HtmlUtil.splitAndFilterString(activi.getActivityintro(), 100));
				}
				this.setAttribute("indexPro", pro);
			}
			//System.out.println(activi.getActivityid());
			//获得展示的图片
			List<ActivityWorksShow> activPic=programaService.getShowPics();
			this.setAttribute("activPic", activPic);
			
			//显示前三个月和后一个月的活动的类别
			List<Activity> list=activityService.getActicityType();
			this.setAttribute("indexType", list);
			this.setAttribute("typelength", list.size());
			//按栏目显示 以关闭了的活动
			List<Activity> acts=activityService.getCloseActivity(activityColseId);
			this.setAttribute("indexActs", acts);
			//显示两位导航老师
			List<String> bls=new ArrayList<String>();
			List<ActivityTeacher> teachers=activityService.getTwoTeacher();
			for(ActivityTeacher teacher:teachers){
				Blog blog=worksService.getByTeacherIdBlog(teacher.getId());
				if(blog!=null&&blog.getBlogcontent()!=null&&!blog.getBlogcontent().equals("")){
					bls.add(HtmlUtil.splitAndFilterString(blog.getBlogcontent(), 30));
				}
			}
			this.setAttribute("blogs", bls);
			this.setAttribute("indexTea", teachers);
		}
		return "showIndex";
	}
	//得到所有已经结束了的活动
	public  String getAllColseAct(){
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(45);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result=activityService.getcAllCloseAct(page);
		setAttribute("actList", result.getContent());
		setAttribute("actLength",result.getContent().size() );
		return "closeAct";
	}
}
