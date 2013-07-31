package com.cnarj.ttxs.web.actions.zone;

import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.learn.ILiveEncyclopediaService;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.service.member.IFriendsInfoService;
import com.cnarj.ttxs.service.member.IMoodsService;
import com.cnarj.ttxs.service.member.IPhotosService;
import com.cnarj.ttxs.service.member.IVisitService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

public class IndexAction extends PageAction {
	
	private IMoodsService moodService;
	private IPhotosService photosService;
	private MemberService memberService;
	private IActionRecService actionRecService; 
	private IOneDayOneTextService onetextService;
	private ILiveEncyclopediaService liveService;
	private IReadbookService readbookService;
	private IFriendsInfoService friendService;
	private IVisitService visitService;
	
	private String TTid;//所访问的用户Id 
	private Member TTUser;//所访问的用户对象
	private String memberid;
	private boolean friendsign = false;//是否已是好友标志
	private Long dsisid;//传入二期用户ID
	
	private moods mood;
	private List<Photos> photoList;
	private List<ActionRec> actionRecList;
	private List<ReadSrc> onetextList;
	private List<ArticleSrc> liveList;
	private List<ReadSrc> readBookList;
	private List<ZoneVisits> visitList;

	public List<ZoneVisits> getVisitList() {		return visitList;	}
	public void setVisitList(List<ZoneVisits> visitList) {		this.visitList = visitList;	}
	public IVisitService getVisitService() {		return visitService;	}
	public void setVisitService(IVisitService visitService) {		this.visitService = visitService;	}
	public boolean isFriendsign() {		return friendsign;	}
	public void setFriendsign(boolean friendsign) {		this.friendsign = friendsign;	}
	public IReadbookService getReadbookService() {		return readbookService;	}
	public void setReadbookService(IReadbookService readbookService) {		this.readbookService = readbookService;	}
	public IFriendsInfoService getFriendService() {		return friendService;	}
	public void setFriendService(IFriendsInfoService friendService) {		this.friendService = friendService;	}
	public List<ArticleSrc> getLiveList() {		return liveList;	}
	public void setLiveList(List<ArticleSrc> liveList) {		this.liveList = liveList;	}
	public List<ReadSrc> getReadBookList() {		return readBookList;	}
	public void setReadBookList(List<ReadSrc> readBookList) {		this.readBookList = readBookList;	}
	public ILiveEncyclopediaService getLiveService() {		return liveService;	}
	public void setLiveService(ILiveEncyclopediaService liveService) {		this.liveService = liveService;	}
	public List<ReadSrc> getOnetextList() {		return onetextList;	}
	public void setOnetextList(List<ReadSrc> onetextList) {		this.onetextList = onetextList;	}
	public IOneDayOneTextService getOnetextService() {		return onetextService;	}
	public void setOnetextService(IOneDayOneTextService onetextService) {		this.onetextService = onetextService;	}
	public IPhotosService getPhotosService() {		return photosService;	}
	public void setPhotosService(IPhotosService photosService) {		this.photosService = photosService;	}
	public MemberService getMemberService() {		return memberService;	}
	public void setMemberService(MemberService memberService) {		this.memberService = memberService;	}
	public IActionRecService getActionRecService() {		return actionRecService;	}
	public void setActionRecService(IActionRecService actionRecService) {		this.actionRecService = actionRecService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public moods getMood() {		return mood;	}
	public void setMood(moods mood) {		this.mood = mood;	}
	public List<Photos> getPhotoList() {		return photoList;	}
	public void setPhotoList(List<Photos> photoList) {		this.photoList = photoList;	}
	public List<ActionRec> getActionRecList() {		return actionRecList;	}
	public void setActionRecList(List<ActionRec> actionRecList) {		this.actionRecList = actionRecList;	}
	public String getTTid() {		return TTid;	}
	public void setTTid(String tid) {		TTid = tid;	}
	public Member getTTUser() {		return TTUser;	}
	public void setTTUser(Member user) {		TTUser = user;	}
	public IMoodsService getMoodService() {		return moodService;	}
	public void setMoodService(IMoodsService moodService) {		this.moodService = moodService;	}
	public Long getDsisid() {		return dsisid;	}
	public void setDsisid(Long dsisid) {		this.dsisid = dsisid;	}
	
	/**
	 * 首页
	 * @return
	 */
	public String index(){
		try{	
			String filstr = "";
			String gradecode = "8a8081a131bd7ec20131bd1234560001";
			
			
			//1.查询他的心情，最新一条
			mood = moodService.getMood(TTid);
			
			//2.查询最新上传的照片 5个
			photoList = photosService.opengetNewPhotos(memberid, TTid);
			
			//3.查询他的动态 20条
			actionRecList = actionRecService.openActionList(TTid);
			for(int i = 0;i < actionRecList.size();i++){
				if(actionRecList.get(i).getBlog() != null){
					filstr = HtmlUtil.splitAndFilterString(actionRecList.get(i).getBlog().getBlogcontent(),120);
					actionRecList.get(i).getBlog().setBlogcontent(filstr);
				}
			}
			
			//4.最新6条来访
			visitList = this.visitService.getvisit(CommStaticNum.PAGENUM_VISITLIST, TTid);
			
			//5.查询今日课题 3
			onetextList = onetextService.listReadOnedayByNew(gradecode, 3);
			
			//6.博览群书 5
			readBookList = readbookService.get5ReadSrc(5);
			
			//7.生活百科 5
			liveList = liveService.getLiveEncyclopedia(5);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获得数据失败,请稍后重试...");
			return ERROR;
		}
	}
	
	/**
	 * 跳转到他的资料
	 * @return
	 */
	public String userinfo(){
		return SUCCESS;
	}
	
	
	@Override
	/**
	 * 所有的方法都要判断他人用户信息
	 */
	public void validate() {

		if(null != this.dsisid){
			Member TT = this.memberService.getMember(this.dsisid, new Long("1"));
			
			if(null == TT){
				this.addActionError("错误！");
			}
			else{
				this.TTid = TT.getMemberid();
				this.TTUser = TT;
			}
		}
		if(this.TTid == null || this.TTid.length() == 0){
			this.addActionError("错误！需指定他人ID");
		}
		else{
			this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == TTUser){
				TTUser = memberService.get(this.TTid);
				
				String mid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
				if(null != mid && mid.length() > 0){

					//判断是否是好友
					Hashtable table = new Hashtable();
					table.put("memberByUserid.memberid", mid);
					table.put("memberByFrienduserid.memberid", TTid);
					
					this.friendsign = this.friendService.isExist(table);
					
					//如果为自己，不能添加好友
					if(this.memberid.equals(TTid)){
						this.friendsign = true;
					}
				}
				
			}
			memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		}
		
	}
}
