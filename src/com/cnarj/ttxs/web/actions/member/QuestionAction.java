package com.cnarj.ttxs.web.actions.member;

import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IQuestionService;

import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户Action类 - 问题管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class QuestionAction extends PageAction {

	private IQuestionService questionService;
	
	private List<Question> questionList;
	private String memberid;
	private String answerid, questionid;
	private String id;

	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public String getAnswerid() {		return answerid;	}
	public void setAnswerid(String answerid) {		this.answerid = answerid;	}
	public String getQuestionid() {		return questionid;	}
	public void setQuestionid(String questionid) {		this.questionid = questionid;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public IQuestionService getQuestionService() {		return questionService;	}
	public void setQuestionService(IQuestionService questionService) {		this.questionService = questionService;	}
	public List<Question> getQuestionList() {		return questionList;	}
	public void setQuestionList(List<Question> questionList) {		this.questionList = questionList;	}
	
	/**
	 * 查询用户的问题列表
	 * @return
	 */
	public String listQuestion(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_QUESTION);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = questionService.getQuestionList(page, memberid);
			this.questionList = result.getContent();
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	public String bestAnswer(){
		try{
			
			int re = questionService.saveBeseAnswer(memberid, answerid, questionid);
			if(re == 1){
				this.addActionMessage("操作成功");
				this.id = this.questionid;
			}
			else{
				this.addActionMessage("操作失败!");
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("操作失败!");
			return ERROR;
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
