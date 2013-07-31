package com.cnarj.ttxs.web.actions.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.dsis.TStudent;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.ZoneVisits;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.StudentService;
import com.cnarj.ttxs.service.learn.ILiveEncyclopediaService;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.service.member.IMoodsService;
import com.cnarj.ttxs.service.member.IVisitService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.BaseAction;

/**
 * 用户中心 -- 班级动态
 * @author hedan
 *
 */
public class ClassDynamicAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6522668384718486626L;

	private IActionRecService actionRecService;

	private MemberService memberService;
	
	private StudentService studentService;
	
	private IMoodsService moodsService;
	
	private IVisitService visitService;
	
	private IOneDayOneTextService onetextService;
	
	private IReadbookService readbookService;
	
	private ILiveEncyclopediaService liveService;
	
	private Long classId;
	
	private List<TStudent> listStudents;
	
	private List<ActionRec> listActionRecords;//班级动态
	
	private moods mood;
	
	private List<ZoneVisits> visitList;  //最近来访

	private List<ReadSrc> onetextList;
	
	private List<ReadSrc> readBookList;
	
	private List<ArticleSrc> liveList;
	
	/**
	 * 班级动态
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String dynamic()throws Exception{
		try {
			Long stuId = getDsisUserid();
			TStudent student = studentService.get(stuId);
			if(student != null){
				classId = student.getTClasses().getBjId();//得到该会员登录的班级id
			}
			if(classId != null){
				listStudents = studentService.getStudentListByClassId(getXxid(), classId);
			}
			listActionRecords = new ArrayList<ActionRec>();
			if(listStudents != null && listStudents.size() > 0 ){
				int size = listStudents.size();
				Member l_member = null;
				String l_memberId = null;
				List<ActionRec> l_listActionRecords = null; 
				List<Member> l_listMember = new ArrayList<Member>();
				for(int i=0; i < size ; i++){
					stuId = listStudents.get(i).getXsId();
					l_member = memberService.getMember(stuId, getSessionMemberType());//根据会员类型和dsisUserId获得会员实体对象
					if(l_member != null){
						l_listMember.add(l_member);
					}
				}
				
				if(l_listMember != null && l_listMember.size() > 0){
					int size1 = l_listMember.size();
					Random radom = new Random();
					int radomInt;
					int size2;
					ActionRec actionRecord = null;
					int l_len = size1 ;
					for(int i = 0; i < size1; i++){
						radomInt = radom.nextInt(l_len);
						l_member = l_listMember.get(radomInt);
						if(l_member != null){
							l_memberId = l_member.getMemberid();
						}
						if(l_memberId != null && !"".equals(l_memberId)){
							l_listActionRecords = actionRecService.getList("member.memberid", l_memberId, "actiondate", "desc");//根据会员id获得会员动态
						}
						if(l_listActionRecords != null && l_listActionRecords.size() > 0){
							size2 = l_listActionRecords.size();
							if(size2 > 3){//如果大于3则取前三条
								size2 = 3;
							}
							for(int j = 0; j < size2 ; j++){
								actionRecord = l_listActionRecords.get(j);
								if(actionRecord.getActiontype() == 2){
									actionRecord.getBlog().setBlogcontent(HtmlUtil.splitAndFilterString(actionRecord.getBlog().getBlogcontent(), 80));
								}
								listActionRecords.add(actionRecord);
							}
						}
						if(listActionRecords.size() == 20){
							break;
						}
						l_listMember.remove(radomInt);//移除已取过的对象
						l_len--;
					}
				}
				
			}
			List<moods> listMoods = moodsService.getListByMaxResults(getSessionMemberId(),1);//取最新一条心情
			if(listMoods != null && listMoods.size() > 0){
				mood = listMoods.get(0);//取最新一条心情
			}else{
				mood = null;
			}
			
			//4.最新6条来访
			visitList = this.visitService.getvisit(CommStaticNum.PAGENUM_VISITLIST, getSessionMemberId());
			
			//5.查询今日课题 3
			String gradecode = "8a8081a131bd7ec20131bd1234560001";//年级id  **********变量 根据该会员得到其所在年级
			onetextList = onetextService.listReadOnedayByNew(gradecode, 3);
			
			//6.博览群书 5
			readBookList = readbookService.get5ReadSrc(5);
			
			//7.生活百科 5
			liveList = liveService.getLiveEncyclopedia(5);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return LIST;
	}

	public IActionRecService getActionRecService() {
		return actionRecService;
	}

	public void setActionRecService(IActionRecService actionRecService) {
		this.actionRecService = actionRecService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	public List<ActionRec> getListActionRecords() {
		return listActionRecords;
	}

	public void setListActionRecords(List<ActionRec> listActionRecords) {
		this.listActionRecords = listActionRecords;
	}

	public IMoodsService getMoodsService() {
		return moodsService;
	}

	public void setMoodsService(IMoodsService moodsService) {
		this.moodsService = moodsService;
	}

	public moods getMood() {
		return mood;
	}

	public void setMood(moods mood) {
		this.mood = mood;
	}

	public IVisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(IVisitService visitService) {
		this.visitService = visitService;
	}

	public IOneDayOneTextService getOnetextService() {
		return onetextService;
	}

	public void setOnetextService(IOneDayOneTextService onetextService) {
		this.onetextService = onetextService;
	}

	public IReadbookService getReadbookService() {
		return readbookService;
	}

	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}

	public ILiveEncyclopediaService getLiveService() {
		return liveService;
	}

	public void setLiveService(ILiveEncyclopediaService liveService) {
		this.liveService = liveService;
	}

	public List<ZoneVisits> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<ZoneVisits> visitList) {
		this.visitList = visitList;
	}

	public List<ReadSrc> getOnetextList() {
		return onetextList;
	}

	public void setOnetextList(List<ReadSrc> onetextList) {
		this.onetextList = onetextList;
	}

	public List<ReadSrc> getReadBookList() {
		return readBookList;
	}

	public void setReadBookList(List<ReadSrc> readBookList) {
		this.readBookList = readBookList;
	}

	public List<ArticleSrc> getLiveList() {
		return liveList;
	}

	public void setLiveList(List<ArticleSrc> liveList) {
		this.liveList = liveList;
	}
	
	
	
}
