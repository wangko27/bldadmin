package com.cnarj.ttxs.web.actions.shopping;

import java.util.Date;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.shopping.IZealAnswerService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

@SuppressWarnings("serial")
public class ShoppingQuestionAction extends PageAction {
	private IZealAnswerService zealAnswerService;
	private MemberService memberService;
	private Member member;
	
	private String t;
	private ZealAnswer zealAnswer;
	private String id;
	
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public IZealAnswerService getZealAnswerService() {
		return zealAnswerService;
	}
	public void setZealAnswerService(IZealAnswerService zealAnswerService) {
		this.zealAnswerService = zealAnswerService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 热心解答问题列表
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */
	public String list(){
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("result",null);
			return "list";
		}
	}
	public String add(){
		try {
			if(null==getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
				this.clearMessages();
				// 未登录跳到登录页面
				this.addActionMessage("未登录!");
				return  list();
			}else {
				String memberid = HttpUtil.getSession(
						Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
				//获得用户信息
				Member member =memberService.get(memberid);
				boolean b= zealAnswerService.isExist("questiontitle", zealAnswer.getQuestiontitle());
				if(b==true){
					this.addActionMessage("问题已存在!");
					return  list();
				}
				zealAnswer.setMember(member);
				zealAnswer.getQuestiontitle();
				zealAnswer.setAskerusername(member.getUsername());
				zealAnswer.setQuestiondate(new Date());
				zealAnswer.setCreatedate(new Date());
				zealAnswer.setAnswer(null);
				//添加问题创建时间
				zealAnswerService.save(zealAnswer);
				this.clearMessages();
				this.addActionMessage("问题添加成功!");
				return  list();
			}
		} catch (Exception e) {
			// TODO: handle exception
			this.addActionMessage("问题添加失败!");
			return  list();
		}	
	}
	public String getQuestionById(){
		try {
			ZealAnswer zealAnswer=zealAnswerService.get(this.id);
			this.setAttribute("zealAnswer", zealAnswer);
			this.setAttribute("show", "1");
			return list();
		} catch (Exception e) {
			// TODO: handle exception
			this.setAttribute("zealAnswer", null);
			return list();
		}
	}
	public ZealAnswer getZealAnswer() {
		return zealAnswer;
	}
	public void setZealAnswer(ZealAnswer zealAnswer) {
		this.zealAnswer = zealAnswer;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
	