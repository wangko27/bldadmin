package com.cnarj.ttxs.admin.actions.shopping;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.Article.IAnswerService;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.IQuestionTypeService;
import com.cnarj.ttxs.service.shopping.IZealAnswerService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
/**
 * 商城频道后台action类 -热心答疑
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 刘其
 * @version 1.0
 * @since 2011年9月2日
 */
@SuppressWarnings("serial")
public class ShoppingQuestionAction extends PageAction {
	private IZealAnswerService zealAnswerService;
	private MemberService memberService;
	private ZealAnswer zealAnswer;
	private String id;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public IZealAnswerService getZealAnswerService() {
		return zealAnswerService;
	}
	public void setZealAnswerService(IZealAnswerService zealAnswerService) {
		this.zealAnswerService = zealAnswerService;
	}
	public ZealAnswer getZealAnswer() {
		return zealAnswer;
	}
	public void setZealAnswer(ZealAnswer zealAnswer) {
		this.zealAnswer = zealAnswer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	/*
	 * 查询未回答的热心解答问题
	 * 
	 */
	public String list(){
		try {
			String questionTypeid=getParameter("questionTypeid");
			if(null==questionTypeid||"".equals(questionTypeid)){
				questionTypeid=this.type;
			}
			LogUtil.logger.info("记录日志信息!");
			// 设置每页查询的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("modifydate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			if(questionTypeid.equals("1")){
				Long totalRecords = zealAnswerService.getTotalCount("is not null");
				//创建页面
				page = PageUtil.createPage(page, totalRecords.intValue()); 
				result=zealAnswerService.getQuestionBystaues(page, "is not null");
				//总数目
				if(result.getContent()==null){
					setAttribute("result",null);
				}else{
					setAttribute("result",result);
				}
				return "list";
			}
			else{
				Long totalRecords = zealAnswerService.getTotalCount("is null");
				//创建页面
				page = PageUtil.createPage(page, totalRecords.intValue()); 
				result=zealAnswerService.getQuestionBystaues(page, "is null");
				//总数目
				if(result.getContent()==null){
					setAttribute("result",null);
				}else{
					setAttribute("result",result);
				}
				return "list";
			}
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("result",null);
			return "list";
		}
	}
	/*
	 * 查询未回答的热心解答问题
	 * 
	 */
	public String search(){
		try {
			String questiontitle=getParameter("questiontitle");
			if(questiontitle==null){
				setAttribute("result",null);
				return "list";
			}
			else{
				LogUtil.logger.info("记录日志信息!");
				// 设置每页查询的条数
				page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
				//设置排序的字段
				page.setOrderBy("modifydate");
				//设置排序方法
				page.setOrderType(OrderType.desc);
				// 根据statePage进行Page对象设置，并查询
				if (gotoPage == null || gotoPage.length() == 0) {
					gotoPage = "1";
				}
				page.setCurrentPage(Integer.parseInt(gotoPage));
				Long totalRecords = zealAnswerService.getTotalCountBysartch(questiontitle.trim());
				//创建页面
				page = PageUtil.createPage(page, totalRecords.intValue()); 
				result=zealAnswerService.getQuestionRI(page, questiontitle.trim());
				if(result==null){
					setAttribute("result",null);
				}else{
					setAttribute("result",result);
				}
				return "list";
			} 
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("result",null);
			return "list";
		}
	}
	/*
	 * 回答页面展示
	 * 
	 */
	public String answerpage(){
		try {
			ZealAnswer zealAnswer =	zealAnswerService.get(this.id);
			if(zealAnswer==null){
				setAttribute("zealAnswer", null);
			}else{
				setAttribute("zealAnswer", zealAnswer);
			}
			return "view";
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("zealAnswer", null);
			return "view";
		}
	}
	/*
	 * 回答页面
	 * 
	 */
	public String answer(){
			try {
				if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
					// 未登录跳到登录页面
					this.clearMessages();
					this.addActionMessage("未登录!");
					return  answerpage();
				}else {
					if(zealAnswer.getAnswer().equals("")||zealAnswer.getAnswer()==null){
					 this.addActionMessage("回答不能为空");	
					 return  answerpage();
					}
					String memberid = HttpUtil.getSession(
							Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
					//获得用户信息
					Member member =memberService.get(memberid);
					//获得原数据
					ZealAnswer answer=new ZealAnswer();
					answer=zealAnswerService.get(zealAnswer.getZealanswerid());
					answer.setModifydate(new Date());
					answer.setAnswer(zealAnswer.getAnswer());
					//添加问题创建时间
					zealAnswerService.update(answer);
					this.addActionMessage("问题回答成功!");
					return  answerpage();
				}
			} catch (Exception e) {
				// TODO: handle exception
				this.addActionMessage("问题添加失败!");
				return  answerpage();
			}	
	}
	/*
	 * 删除问题
	 * 
	 */
	public String delete(){
		try{
			zealAnswerService.delete(this.id);
			return list();
		}catch (Exception e) {
			// TODO: handle exception
			return list();
		}
	}
}