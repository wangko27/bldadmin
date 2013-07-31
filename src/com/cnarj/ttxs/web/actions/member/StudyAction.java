package com.cnarj.ttxs.web.actions.member;

import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IStudyService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户Action类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class StudyAction extends PageAction {

	private IStudyService studyService;
	
	private String memberid;
	
	private List<ArticleSrc> studyList;
	private ArticleSrc studysrc;
	private String studyid;
	
	public IStudyService getStudyService() {		return studyService;	}
	public void setStudyService(IStudyService studyService) {		this.studyService = studyService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public List<ArticleSrc> getStudyList() {		return studyList;	}
	public void setStudyList(List<ArticleSrc> studyList) {		this.studyList = studyList;	}
	public ArticleSrc getStudysrc() {		return studysrc;	}
	public void setStudysrc(ArticleSrc studysrc) {		this.studysrc = studysrc;	}
	public String getStudyid() {		return studyid;	}
	public void setStudyid(String studyid) {		this.studyid = studyid;	}
	

	/**
	 * 查询
	 * @return
	 */
	public String list(){
		try{
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_STUDY);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = studyService.getStudyListByM(page, memberid);//page分页信息
			this.studyList = result.getContent();
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 增加
	 * @return
	 */
	public String add(){
		try{
			Long membertype = (Long)super.getSession(Member.LOGIN_MEMBER_TYPE);
			String studyid = studyService.saveStudy(this.studysrc.getArticletitle(), this.studysrc.getArticlesrccontent(), memberid,membertype,this.studysrc);
			
			if(null != studyid && studyid.length() > 0){
				this.addActionMessage("添加成功！");
				return SUCCESS;
			}
			else{
				this.addActionMessage("添加失败！");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败！");
			return ERROR;
		}
	}

	/**
	 * 删除
	 * @return
	 */
	public String del(){
		try{
			Hashtable table = new Hashtable();
			table.put("member.memberid", memberid);
			table.put("articlesrcid",this.studyid);
			
			int r = studyService.delete(table);
			if(r > 0){
				this.addActionMessage("删除成功！");
				return SUCCESS;
			}
			else{
				this.addActionMessage("添加失败！");
				return ERROR;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败！");
			return ERROR;
		}
	}

	/**
	 * 修改
	 * @return
	 */
	public String upd(){
		try{
			
			studyService.updateStudy(this.studysrc);
			this.addActionMessage("修改成功！");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("修改失败！");
			return ERROR;
		}
	}

	public String updGo(){
		try{
			
			this.studysrc = studyService.get(this.studyid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
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
