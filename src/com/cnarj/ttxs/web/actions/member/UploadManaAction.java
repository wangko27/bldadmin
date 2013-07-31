package com.cnarj.ttxs.web.actions.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IUpSrcService;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 空间Action类 - 上传的资源管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class UploadManaAction extends PageAction {

	private IUpSrcService upsrcService;
	private IGradeCodeService gradecodeService;
	private ISubjectCodeService subjectService;
	private IReadbookTypeService readsrctypeService;
	
	private ReadSrc readsrc;
	private String srcid;
	private List<ReadSrc> readsrcList;
	private String memberid;
	private List<GradeCode> gradeList;
	private List<SubjectCode> subjectList;
	private List<ReadSrcType> srctypeList;
	
	//封面
	private File photofile;
	private String photofileContentType;
	private String photofileFileName;
	
	//资源
	private File souce;
	private String souceContentType;
	private String souceFileName;
	
	public File getSouce() {		return souce;	}
	public void setSouce(File souce) {		this.souce = souce;	}
	public String getSouceContentType() {		return souceContentType;	}
	public void setSouceContentType(String souceContentType) {		this.souceContentType = souceContentType;	}
	public String getSouceFileName() {		return souceFileName;	}
	public void setSouceFileName(String souceFileName) {		this.souceFileName = souceFileName;	}
	public File getPhotofile() {		return photofile;	}
	public void setPhotofile(File photofile) {		this.photofile = photofile;	}
	public String getPhotofileContentType() {		return photofileContentType;	}
	public void setPhotofileContentType(String photofileContentType) {		this.photofileContentType = photofileContentType;	}
	public String getPhotofileFileName() {		return photofileFileName;	}
	public void setPhotofileFileName(String photofileFileName) {		this.photofileFileName = photofileFileName;	}
	public IReadbookTypeService getReadsrctypeService() {		return readsrctypeService;	}
	public void setReadsrctypeService(IReadbookTypeService readsrctypeService) {		this.readsrctypeService = readsrctypeService;	}
	public List<ReadSrcType> getSrctypeList() {		return srctypeList;	}
	public void setSrctypeList(List<ReadSrcType> srctypeList) {		this.srctypeList = srctypeList;	}
	public ISubjectCodeService getSubjectService() {		return subjectService;	}
	public void setSubjectService(ISubjectCodeService subjectService) {		this.subjectService = subjectService;	}
	public List<GradeCode> getGradeList() {		return gradeList;	}
	public void setGradeList(List<GradeCode> gradeList) {		this.gradeList = gradeList;	}
	public List<SubjectCode> getSubjectList() {		return subjectList;	}
	public void setSubjectList(List<SubjectCode> subjectList) {		this.subjectList = subjectList;	}
	public IGradeCodeService getGradecodeService() {		return gradecodeService;	}
	public void setGradecodeService(IGradeCodeService gradecodeService) {		this.gradecodeService = gradecodeService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public String getSrcid() {		return srcid;	}
	public void setSrcid(String srcid) {		this.srcid = srcid;	}
	public List<ReadSrc> getReadsrcList() {		return readsrcList;	}
	public void setReadsrcList(List<ReadSrc> readsrcList) {		this.readsrcList = readsrcList;	}
	public IUpSrcService getUpsrcService() {		return upsrcService;	}
	public void setUpsrcService(IUpSrcService upsrcService) {		this.upsrcService = upsrcService;	}
	public ReadSrc getReadsrc() {		return readsrc;	}
	public void setReadsrc(ReadSrc readsrc) {		this.readsrc = readsrc;	}
	
	/**
	 * 获取用户上传的资源列表
	 * @return
	 */
	public String listUpSrc(){

		try{				
			
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ALBUM);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = this.upsrcService.getUpList(page, memberid);
			this.readsrcList = result.getContent();
			
			//查询数据
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("获得数据失败,请稍后重试...");
			return ERROR;
		}
	}
	
	/**
	 * 用户关闭已上传资源
	 * @return
	 */
	public String closeSrc(){

		try{				
			upsrcService.updCloseSrc(srcid);

			this.addActionMessage("操作成功!");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("操作失败!");
			return ERROR;
		}
	}
	public void validateCloseSrc(){
		
		if(null == this.srcid || srcid.length() == 0){
			this.addActionError("资源ID不能为空!!");
		}
	}
	
	/**
	 * 上传资源
	 * @return
	 */
	public String addSrc(){

		try{				
			String nikename = (String)super.getSession(Member.LOGIN_MEMBER_NIKENAME);
//			this.upsrcService.addSrc(memberid, nikename, readsrc, this.photofileFileName,
//					this.photofile, this.souceFileName, this.souce);
			
			this.addActionMessage("操作成功!");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("操作失败!");
			return ERROR;
		}
	}
	public void validateAddSrc() throws UnsupportedEncodingException{
		byte[] b;
		if(null == readsrc.getReadsrctile() || readsrc.getReadsrctile().length() == 0){
			this.addActionError("资源标题不能为空");
		}
		else {
			 b = readsrc.getReadsrctile().getBytes("GBK");
			if(b.length > 128){
				this.addActionError("输入的资源标题过大");
			}
		}
		
		if(null == readsrc.getGradeCode() || null == readsrc.getGradeCode().getGradecode() 
				|| readsrc.getGradeCode().getGradecode().length() == 0){
			this.addActionError("资源年级不能为空");
		}
		if(null == readsrc.getSubjectCode() || null == readsrc.getSubjectCode().getSubjectcode() 
				|| readsrc.getSubjectCode().getSubjectcode().length() == 0){
			this.addActionError("资源科目不能为空");
		}
		if(null == readsrc.getReadSrcType() || null == readsrc.getReadSrcType().getSrctypeid() 
				|| readsrc.getReadSrcType().getSrctypeid().length() == 0){
			this.addActionError("资源类型不能为空");
		}
		if(null != readsrc.getSrckeywords()){
			b = readsrc.getSrckeywords().getBytes("GBK");
			if(b.length > 128){
				this.addActionError("输入的关键字过大");
			}
		}
		if(null == readsrc.getContentintro() || readsrc.getContentintro().length() == 0){
			this.addActionError("资源简介不能为空");
		}
		else{
			b = readsrc.getContentintro().getBytes();
			if(b.length > 1024){
				this.addActionError("输入的简介过长");
			}
		}
		
		//验证资源封面和资源的类型及大小
		//资源DOC、TXT、XLS、PDF、CHM(最大1M)，JPG、GIF、PNG、BMP(最大2M)，RAR、ZIP、RM、RMVB、FLV(最大10M)
		//封面JPG、GIF、PNG、BMP(最大1M)
		
		
		if(null != photofile){
			// 获得文件后缀名
			String extensionphoto = photofileFileName.substring(photofileFileName
					.lastIndexOf(".") + 1);
			extensionphoto = extensionphoto.toUpperCase();
			if(!"JPG".equals(extensionphoto) && !"GIF".equals(extensionphoto) && !"PNG".equals(extensionphoto) && !"BMP".equals(extensionphoto)){
				this.addActionError("封面只能上传JPG、GIF、PNG、BMP(最大1M)等格式！");
			}
			if((photofile.length() / 1024) / 1024 > 1){
				this.addActionError("封面最大只能上传1M!");
			}
		}
		
		if (null != souce) {
			// 获得文件后缀名
			String extensionsouce = souceFileName.substring(souceFileName
					.lastIndexOf(".") + 1);
			extensionsouce = extensionsouce.toUpperCase();
			
			if ("RAR".equals(extensionsouce) || "ZIP".equals(extensionsouce)
					 || "RM".equals(extensionsouce) || "RMVB".equals(extensionsouce) || "FLV".equals(extensionsouce)) {
				if (((souce.length() / 1024) / 1024) > 10) {
					this.addActionError("资源"+extensionsouce+"格式最大只能上传10M!");
				}
			}
			if ("DOC".equals(extensionsouce) || "TXT".equals(extensionsouce) ||
					"XLS".equals(extensionsouce) || "PDF".equals(extensionsouce) || 
					 "CHM".equals(extensionsouce)) {
				if (((extensionsouce.length() / 1024) / 1024) > 1) {
					this.addActionError("资源"+extensionsouce+"格式最大只能上传1M!");
				}
			}
			if ("JPG".equals(extensionsouce) || "GIF".equals(extensionsouce)
					|| "PNG".equals(extensionsouce) || "BMP".equals(extensionsouce)) {
				if (((extensionsouce.length() / 1024) / 1024) > 2) {
					this.addActionError("资源"+extensionsouce+"格式最大只能上传2M!");
				}
			}
			
			else{

				this.addActionError("资源格式不正确!");
			}
		}
		
		if(null != this.getActionErrors()){
			toAddSrc();
		}
	}
	
	/**
	 * 跳转到上传资源
	 * @return
	 */
	public String toAddSrc(){
		try{		
//		    1)查询年级
			this.gradeList = gradecodeService.getAll();
//		    2)查询科目
			this.subjectList = this.subjectService.getAll();
//		    3)查询资源类别 博览群书下的类别 8a8081a131bbac4d0131bbac8f5a0001
			this.srctypeList = readsrctypeService.getList("readSrcType.srctypeid", "8a8081a131bbac4d0131bbac8f5a0001");
			
			return SUCCESS;
		}catch(Exception e){
			getRequest().setAttribute("exception", e.toString());
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