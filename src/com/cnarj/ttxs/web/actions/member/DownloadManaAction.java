package com.cnarj.ttxs.web.actions.member;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrcCommented;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.ISrcManaService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import java.util.Hashtable;
import java.util.List;

/**
 * 用户Action类 - 下载管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
@Validation
public class DownloadManaAction extends PageAction {

	private ISrcManaService srcManaService;
	
	private List<ReadSrcDownRec> downlist;
	private ReadSrc readSrc;
	private ReadSrcDownRec readSrcDownRec;
	private ReadSrcCommented readSrcComm;
	
	private String srcid;//资源ID
	private String downrecid;//资源下载记录id
	private String readsrcid;//返回博览群书的ID
	
	private String memberid;
	
	
	public String getReadsrcid() {		return readsrcid;	}
	public void setReadsrcid(String readsrcid) {		this.readsrcid = readsrcid;	}
	public String getDownrecid() {		return downrecid;	}
	public void setDownrecid(String downrecid) {		this.downrecid = downrecid;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public String getSrcid() {		return srcid;	}
	public void setSrcid(String srcid) {		this.srcid = srcid;	}
	public List<ReadSrcDownRec> getDownlist() {		return downlist;	}
	public void setDownlist(List<ReadSrcDownRec> downlist) {		this.downlist = downlist;	}
	public ISrcManaService getSrcManaService() {		return srcManaService;	}
	public void setSrcManaService(ISrcManaService srcManaService) {		this.srcManaService = srcManaService;	}
	public ReadSrc getReadSrc() {		return readSrc;	}
	public void setReadSrc(ReadSrc readSrc) {		this.readSrc = readSrc;	}
	public ReadSrcDownRec getReadSrcDownRec() {		return readSrcDownRec;	}
	public void setReadSrcDownRec(ReadSrcDownRec readSrcDownRec) {		this.readSrcDownRec = readSrcDownRec;	}
	public ReadSrcCommented getReadSrcComm() {		return readSrcComm;	}
	public void setReadSrcComm(ReadSrcCommented readSrcComm) {		this.readSrcComm = readSrcComm;	}	
	
	/**
	 * 获取下载信息列表
	 * @return
	 */
	public String getDownloadList(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_DOWNMANM);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = srcManaService.getDownList(page,memberid);
			this.downlist = result.getContent();
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	/**
	 * 根据ID查询资源信息
	 * @return
	 */
	public String toRating(){
		try{
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			//如果既未传入资源ID又未传入资源下载ID
			if((null == this.readsrcid || this.readsrcid.length() == 0)&&(null == this.downrecid || this.downrecid.length() == 0)){
				this.addActionMessage("错误!!");
				return ERROR;
			}
			else{
				//如果传入了下载ID
				if(!(null == this.downrecid || this.downrecid.length() == 0)){
					Hashtable table = new Hashtable();
					table.put("member.memberid", memberid);
					table.put("downrecid", this.downrecid);
					this.readSrcDownRec = srcManaService.getDownRec(table);
					
					return SUCCESS;
				}
				
				//如果传入了资源ID
				if(!(null == this.readsrcid || this.readsrcid.length() == 0)){
					Hashtable table = new Hashtable();
					table.put("member.memberid", memberid);
					table.put("readSrc.readsrcid", this.readsrcid);
					this.readSrcDownRec = srcManaService.getDownRec(table);
					
					if(null == readSrcDownRec){
						this.addActionMessage("您未下载过该资源，不能进行评论!");
						return "readbookerror";
					}
					else if(readSrcDownRec.getIsrating().equals("1")){

						this.addActionMessage("您已评过分，不能重复!");
						return "readbookerror";
					}
					else if(readSrcDownRec.getReadSrc().getIsenable().equals("0")){

						this.addActionMessage("该资源已关闭，无法进行评论!");
						return "readbookerror";
					}
					
					return SUCCESS;
				}
			}
			
			
			this.addActionMessage("错误!!");
			return ERROR;
			
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获取信息失败!");
			return ERROR;
		}
	}
	
	/**
	 * 发布下载资源的评分及评论
	 * @return
	 */
	@Validations( 
		requiredStrings={ 
				@RequiredStringValidator(fieldName="readSrc.readsrcid",message="资源ID丢失!",trim = true),
				@RequiredStringValidator(fieldName="readSrcComm.commentedcontent",message="请评论!",trim = true)
				},
		stringLengthFields = {
			@StringLengthFieldValidator(fieldName="readSrcComm.commentedcontent",
					message = "评论信息过长",
					shortCircuit = true,
					trim = true, 
					minLength = "1", 
					maxLength = "512")
		}
	) 
	public String addDownComm(){
		try{
			//取会员信息
			Member m = new Member();
			//取当前用户ID
			String memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
			Long memberType = (Long)super.getSession(Member.LOGIN_MEMBER_TYPE);
			String headpath = (String)super.getSession(Member.LOGIN_MEMBER_HEADPATH);
			
			if(null == memberid || memberid.length() == 0){
				this.addActionMessage("请登录!!");
				return ERROR;
			}
			m.setMemberid(memberid);
			m.setNikename(nikename);
			m.setMemberType(memberType);
			m.setHeadpath(headpath);
			
			readSrcComm.setIp(super.getRequest().getRemoteAddr());//IP
			readSrcComm.setMember(m);
			readSrcComm.setReadSrc(readSrc);
			readSrcComm.setUsername(nikename);
			
			srcManaService.saveComment(this.readSrcComm,readSrcDownRec.getDownrecid());
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获取信息失败!");
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
