package com.cnarj.ttxs.web.actions.Article;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.IAnswerService;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.IQuestionTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.QuestionSaveDate;
import com.cnarj.ttxs.comm.QuestionStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.info.QuestionType;
import com.cnarj.ttxs.pojo.user.*;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class QuestionAction extends PageAction {
	private IQuestionService questionService;
	private IAnswerService answerServive;
	private IQuestionTypeService questionTypeService;
	private Answer as;
	private  Member member;
	private Question qt;
	private MemberService memberService;
	private QuestionType questionType;
	private List<Question> questionList;
	private List<QuestionType> questionTypeList;
	private List<Answer> answerlist;
	private List<Answer> bestanswer;
	private String showtypenum; 
	
	
	private String questiontypeid;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestiontypeid() {
		return questiontypeid;
	}
	public void setQuestiontypeid(String questiontypeid) {
		this.questiontypeid = questiontypeid;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public IAnswerService getAnswerServive() {
		return answerServive;
	}
	public void setAnswerServive(IAnswerService answerServive) {
		this.answerServive = answerServive;
	}
	
	public List<Answer> getAnswerlist() {
		return answerlist;
	}
	public void setAnswerlist(List<Answer> answerlist) {
		this.answerlist = answerlist;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public IQuestionTypeService getQuestionTypeService() {
		return questionTypeService;
	}
	public void setQuestionTypeService(IQuestionTypeService questionTypeService) {
		this.questionTypeService = questionTypeService;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public List<QuestionType> getQuestionTypeList() {
		return questionTypeList;
	}
	public void setQuestionTypeList(List<QuestionType> questionTypeList) {
		this.questionTypeList = questionTypeList;
	}

	public List<Answer> getBestanswer() {
		return bestanswer;
	}
	public void setBestanswer(List<Answer> bestanswer) {
		this.bestanswer = bestanswer;
	}
	public String getShowtypenum() {
		return showtypenum;
	}
	public void setShowtypenum(String showtypenum) {
		this.showtypenum = showtypenum;
	}
	public Question getQt() {
		return qt;
	}
	public void setQt(Question qt) {
		this.qt = qt;
	}
	public Answer getAs() {
		return as;
	}
	public void setAs(Answer as) {
		this.as = as;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 根据问题类别分页查找 - 内容
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */
	public String list(){
		questionTypeList=questionTypeService.getAll();
		String questionTypeid=getParameter("questiontypeid");
		String questionStatus=getParameter("questionstatus");
		if(questionTypeid==null||"".equals(questionTypeid.trim())){
			questionTypeid=this.id;
		}
		LogUtil.logger.info("记录日志信息!");
		// 设置每页查询的条数
		page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
		//设置排序的字段
		page.setOrderBy("begindate");
		//设置排序方法
		page.setOrderType(OrderType.desc);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		//总数目
		Long totalRecords = questionService.getTotalCount(questionStatus,questionTypeid);
		page = PageUtil.createPage(page, totalRecords.intValue()); 
		result = questionService.getQuestionBystaues(page, questionStatus, questionTypeid);
		setAttribute("result", result);
		setAttribute("page", result.getPage());
		return "list";
	}
	
	/**
	 * 我来回答- 内容
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	public String AnswerQuestion(){
		try {
			if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
				this.clearMessages();
				this.addActionMessage("未登录!");
				return "login";// 未登录
			}else {
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				Question question=new Question();
				question=questionService.get(this.id);
				boolean b=answerServive.isExist("member.memberid", member.getMemberid(),question.getQuestionid());
				if(b==true){
					this.clearMessages();
					this.addActionMessage("你已经回答过该问题了!");
					return "input";
				}
				member.setMemberpoint((member.getMemberpoint()==null?0:member.getMemberpoint())+new Long(1));
				question.setAnswernum(question.getAnswernum()+new Long(1));
				question.setModifydate(new Date());
				questionService.update(question);
				as.setMember(member);
				as.setQuestion(question);
				as.setAnswerdate(new Date());
				as.setIsbest("0");
				as.setAnswerusername(member.getNikename());
				answerServive.save(as);
				this.clearMessages();
				this.addActionMessage("问题回答成功!");	
				return "input";
			}
		} catch (Exception e) {
			// TODO: handle exception
			this.clearMessages();
			this.addActionMessage("问题回答失败!");
			return "input";
		}
	}
	/**
	 * 问题回答页面- 内容
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	public String Show_QuestionAdd(){
		Date date=DateUtil.getCurrentDate().getTime();
		try {
			int d = DateUtil.getDay(date.toString(), "");
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		questionTypeList=questionTypeService.getAll();
		return "success";
	}
	/**
	 * 用户问题添加-------------优化完成
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	public String QuestionAdd(){
		try {
				if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
					getResponse().getWriter().print(-1);// 未登录
					return "login";//跳到登录页面
				}else {
					String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
					//获得用户信息
					Member member =memberService.get(memberid);
					member.setMemberpoint((member.getMemberpoint()==null?0:member.getMemberpoint())+new Long(1));
					member.setModifydate(new Date());
					memberService.update(member);
					//取得当前时间
					qt.setMember(member);
					qt.setAsker(member.getNikename());
					//添加问题创建时间
					qt.setCreatedate(new Date());
					qt.setBegindate(new Date());
					qt.setQuestionstatus("0");
					qt.setVisittime(new Long(0));
					qt.setAnswernum(new Long(0));
					//计算问题结束时间为10分钟 	QuestionSaveDate.QUESTIONSAVEDATE*24*60*60*1000;
					Long l=qt.getBegindate().getTime()+QuestionSaveDate.QUESTIONSAVEDATE*24*60*60*1000;
					qt.setEnddate(new Date(l));
					questionService.save(qt);
					QuestionType questionType=questionTypeService.get(qt.getQuestionType().getQuestiontypeid());
					questionType.setQuestiontypeid(qt.getQuestionType().getQuestiontypeid());
					questionType.setModifydate(new Date());
					questionType.setDatanum(questionType.getDatanum()+ new Long(1));
					questionTypeService.update(questionType);
					this.addActionMessage("问题添加成功!");
					return Show_QuestionAdd();
				}
		} catch (Exception e) {
			// TODO: handle exception
			this.clearMessages();
			this.addActionMessage("问题添加失败!");
			return Show_QuestionAdd();
		}	
	}

	/**
	 * 根据id查询问题和问题的答案- 内容
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	
	public String getQuestionById(){
		try {
			//q取得问题详细信息
			Question question=new Question();
			question=questionService.get(this.id);
			System.out.println("Id :"+id);
			if(question==null){
				setAttribute("isnull", "yes");
				setAttribute("noRI", "yes");
				return "view";
			}
			if(question.getVisittime()==null){
				question.setVisittime(new Long(1));
			}
			else{			
				question.setVisittime(question.getVisittime()+(new Long(1)));
			}
			Long l=question.getBegindate().getTime()+QuestionSaveDate.QUESTIONSAVEDATE*24*60*60*1000;
			Long m=new Date().getTime();
			//修改问题状态
			if(m>l){
				question.setQuestionstatus("1");
			}
			question.setAsker(question.getAsker());
			question.setQuestionpoint(question.getQuestionpoint());
			question.setAnswernum(question.getAnswernum());
			question.setModifydate(new Date());
			question.setQuestionType(question.getQuestionType());
			question.setExplanation(question.getExplanation());
			question.setExplanation(HtmlUtil.splitAndFilterString(question.getExplanation(), question.getExplanation().length()));
			bestanswer=answerServive.getbestanswer("1", question.getQuestionid());		
			//获得问题回答详情
			answerlist=answerServive.getbestanswer("0", question.getQuestionid());
			//获得关联问题
			questionList=questionService.getQuestionRI("questionType.questiontypeid", question.getQuestionType().getQuestiontypeid());
			setAttribute("questionList", questionList);
			questionService.update(question);
			setAttribute("qt", question);
			return "view";
		} catch (Exception e) {
			// TODO: handle exception
			return "view";
			
		}
		
	}	
//	/**
//	 * 清空问题表 和 答案表
//	 * 
//	 * @copyright 湖南爱瑞杰科技发展股份有限公司
//	 * @author sly
//	 * @version 1.0
//	 * @since 2011年7月6日11:26:36
//	 */
	public String clearTable(){
		//查找未结束的问题
		List<Question> questionList=questionService.getAll();
		System.out.println(questionList.size());
		Iterator<Question> it=questionList.iterator();
		if(questionList.size()>0){			 
			List<Question> list=new ArrayList<Question>();
			while(it.hasNext()){
				Question question=(Question)it.next();	
				Answer answer=new Answer();
				answer.setQuestion(question);
				List<Answer> answerlist=answerServive.getList("question", answer.getQuestion());
				Iterator<Answer> it2=answerlist.iterator();
				while(it2.hasNext()){
					Answer answer2=(Answer)it2.next(); 
				answerServive.delete(answer2);
				}
				questionService.delete(question.getQuestionid());
			}
		}
	return "success"; 	
	}
	/**
	 * 修改问题状态问最佳答案
	 * 
	 * @return
	 */
	
	public String updateAnswer(){
		try {
			setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME,
			"00000000000000000000000000000001");
			if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
				// 未登录
			}else {
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				Question question=questionService.get(this.id);			
				Answer answer=new Answer();
				answer=answerServive.get(as.getAnswerid());
				answer.setMember(member);
				answer.setQuestion(question);
				answer.setIsbest("1");
				answerServive.update(answer);
				question.setQuestionstatus("1");
				question.setModifydate(new Date());
				questionService.update(question);
				this.addActionMessage("设置成功!");
			}
			return "input";
			
		} catch (Exception e) {
			// TODO: handle exception
			this.addActionMessage("设置失败!");
			return "input";
		}
	}
}
	