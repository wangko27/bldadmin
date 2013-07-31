package com.cnarj.ttxs.web.actions.member;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.learn.ILiveEncyclopediaService;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.service.member.IMoodsService;
import com.cnarj.ttxs.service.member.IVisitService;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 我的空间首页
 * @author hedan
 *
 */
public class MyZoneIndexAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2600641924144068903L;

	private IMoodsService moodsService;
	
	private IActionRecService actionRecService;
	
	private IVisitService visitService;
	
	private IOneDayOneTextService onetextService;
	
	private IReadbookService readbookService;
	
	private ILiveEncyclopediaService liveService;
	
	private String memberid;
	
	private moods mood;
	
	private String moodtext;//心情内容
	
	private List<ActionRec> listActionRecords;//班级动态
	
	private List<ZoneVisits> visitList;  //最近来访

	private List<ReadSrc> onetextList;
	
	private List<ReadSrc> readBookList;
	
	private List<ArticleSrc> liveList;
	
	public IMoodsService getMoodsService() {		return moodsService;	}
	public void setMoodsService(IMoodsService moodsService) {		this.moodsService = moodsService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public moods getMood() {		return mood;	}
	public void setMood(moods mood) {		this.mood = mood;	}
	public List<ActionRec> getListActionRecords() {	return listActionRecords; }
	public void setListActionRecords(List<ActionRec> listActionRecords) {	this.listActionRecords = listActionRecords; }
	public IActionRecService getActionRecService() {	return actionRecService; }
	public void setActionRecService(IActionRecService actionRecService) {	this.actionRecService = actionRecService;	}
	public IVisitService getVisitService() {	return visitService;	}
	public void setVisitService(IVisitService visitService) {	this.visitService = visitService;	}
	public IOneDayOneTextService getOnetextService() {		return onetextService;	}
	public void setOnetextService(IOneDayOneTextService onetextService) {		this.onetextService = onetextService;	}
	public IReadbookService getReadbookService() {		return readbookService;	}
	public void setReadbookService(IReadbookService readbookService) {		this.readbookService = readbookService;	}
	public ILiveEncyclopediaService getLiveService() {		return liveService;	}
	public void setLiveService(ILiveEncyclopediaService liveService) {		this.liveService = liveService;	}
	public List<ZoneVisits> getVisitList() {		return visitList;	}
	public void setVisitList(List<ZoneVisits> visitList) {		this.visitList = visitList;	}
	public List<ReadSrc> getOnetextList() {		return onetextList;	}
	public void setOnetextList(List<ReadSrc> onetextList) {		this.onetextList = onetextList;	}
	public List<ReadSrc> getReadBookList() {		return readBookList;	}
	public void setReadBookList(List<ReadSrc> readBookList) {		this.readBookList = readBookList;	}
	public List<ArticleSrc> getLiveList() {		return liveList;	}
	public void setLiveList(List<ArticleSrc> liveList) {		this.liveList = liveList;	}
	public String getMoodtext() {		return moodtext;	}
	public void setMoodtext(String moodtext) {		this.moodtext = moodtext;	}
	/**
	 * 发表心情
	 * @return
	 */
	public String ajaxAddMoods(){
		PrintWriter out = null;
		try{
			out = getResponse().getWriter();
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			
			Member m = new Member();
			m.setMemberid(memberid);
			m.setNikename(nikename);
			mood = new moods();
			mood.setMoodtext(moodtext);
			mood.setCreatedate(now);
			mood.setMember(m);
			
			Common common = moodsService.saveMood(mood, m);//保存心情
			StringBuffer  sb = null;
			if(common.getStr1() != null && !"".equals(common.getStr1())){
				sb = new StringBuffer("");
				mood = moodsService.get(common.getStr1());//查询最新添加的心情
				if(mood != null){
					sb.append("<p>"+mood.getMoodtext()+"</p>");
					if(mood.getCreatedate() != null){
						sb.append("<span>"+DateUtil.setDateFormat(mood.getCreatedate(), "yyyy-MM-dd HH:mm")+"</span>");
					}else{
						sb.append("<span>&nbsp;</span>");
					}
				}
			}else{
				sb = new StringBuffer("<p>&nbsp;</p><span>&nbsp;</span>");
			}
			out.print(sb);
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
			out.print("exception");
		}
		out.close();
		return null;
	}
	
	/**
	 * 用户中心首页初始化--好友动态
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String userCenterIndex(){
		try{
			String gradecode = "8a8081a131bd7ec20131bd1234560001";//年级id
			listActionRecords = actionRecService.getListByFriend(memberid, 20);//查询好友动态
			List<moods> listMoods = moodsService.getListByMaxResults(memberid,1);//取最新一条心情
			if(listMoods != null && listMoods.size() > 0){
				mood = listMoods.get(0);//取最新一条心情
			}else{
				mood = null;
			}
			//4.最新6条来访
			visitList = this.visitService.getvisit(CommStaticNum.PAGENUM_VISITLIST, memberid);
			
			//5.查询今日课题 3
			onetextList = onetextService.listReadOnedayByNew(gradecode, 3);
			
			//6.博览群书 5
			readBookList = readbookService.get5ReadSrc(5);
			
			//7.生活百科 5
			liveList = liveService.getLiveEncyclopedia(5);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
	}
	
	/**
	 * 我的动态
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String myself()throws Exception{
		try {
			listActionRecords = actionRecService.getListByMyself(memberid, 20);//查询我的动态
			List<moods> listMoods = moodsService.getListByMaxResults(memberid,1);//取最新一条心情
			if(listMoods != null && listMoods.size() > 0){
				mood = listMoods.get(0);//取最新一条心情
			}else{
				mood = null;
			}
			//4.最新6条来访
			visitList = this.visitService.getvisit(CommStaticNum.PAGENUM_VISITLIST, memberid);
			
			//5.查询今日课题 3
			String gradecode = "8a8081a131bd7ec20131bd1234560001";//年级id
			onetextList = onetextService.listReadOnedayByNew(gradecode, 3);
			
			//6.博览群书 5
			readBookList = readbookService.get5ReadSrc(5);
			
			//7.生活百科 5
			liveList = liveService.getLiveEncyclopedia(5);
			
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return "myself";
	}
	
	
	/**
	 * 所有的方法都要判断用户信息
	 */
	@Override
	public void validate() {
		try {
			//取当前用户ID
			this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionError("请登录!!");
				sendRedirect("/login/login.jsp");
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
		}
		
	}
}
