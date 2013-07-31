package com.cnarj.ttxs.web.actions.member;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IWorksService;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

import com.cnarj.ttxs.util.LogUtil;

/**
 * 用户Action类 - 作品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class WorksAction extends PageAction {

	private IWorksService worksService;

	private String memberid;
	private List<ActivityWorks> worksList;
	private List<Activity> activityList;
	private ActivityWorks work;
	private File snfile;
	private String snfileContentType;
	private String snfileFileName;
	private File workfile;
	private String workfileContentType;
	private String workfileFileName;
	private String divshow;
	private String activityid;
	

	private File filedata;
	private String Filename;
	private List<ActivityWorkPhotos> photoList;
	private String delworkup;
	
	public String getDelworkup() {
		return delworkup;
	}
	public void setDelworkup(String delworkup) {
		this.delworkup = delworkup;
	}
	public File getFiledata() {
		return filedata;
	}
	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}
	public List<ActivityWorkPhotos> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<ActivityWorkPhotos> photoList) {
		this.photoList = photoList;
	}
	public String getActivityid() {		return activityid;	}
	public void setActivityid(String activityid) {		this.activityid = activityid;	}
	public String getDivshow() {		return divshow;	}
	public void setDivshow(String divshow) {		this.divshow = divshow;	}
	public File getSnfile() {		return snfile;	}
	public void setSnfile(File snfile) {		this.snfile = snfile;	}
	public String getSnfileContentType() {		return snfileContentType;	}
	public void setSnfileContentType(String snfileContentType) {		this.snfileContentType = snfileContentType;	}
	public String getSnfileFileName() {		return snfileFileName;	}
	public void setSnfileFileName(String snfileFileName) {		this.snfileFileName = snfileFileName;	}
	public File getWorkfile() {		return workfile;	}
	public void setWorkfile(File workfile) {		this.workfile = workfile;	}
	public String getWorkfileContentType() {		return workfileContentType;	}
	public void setWorkfileContentType(String workfileContentType) {		this.workfileContentType = workfileContentType;	}
	public String getWorkfileFileName() {		return workfileFileName;	}
	public void setWorkfileFileName(String workfileFileName) {		this.workfileFileName = workfileFileName;	}
	public ActivityWorks getWork() {		return work;	}
	public void setWork(ActivityWorks work) {		this.work = work;	}
	public List<Activity> getActivityList() {		return activityList;	}
	public void setActivityList(List<Activity> activityList) {		this.activityList = activityList;	}
	public IWorksService getWorksService() {		return worksService;	}
	public void setWorksService(IWorksService worksService) {		this.worksService = worksService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public List<ActivityWorks> getWorksList() {		return worksList;	}
	public void setWorksList(List<ActivityWorks> worksList) {		this.worksList = worksList;	}
	

	/**
	 * 查询我的作品
	 * @return
	 */
	public String list(){
		try{
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_WORKS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = worksService.getWorksList(page, memberid);
			this.worksList = result.getContent();
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	/**
	 * 跳转到添加我的作品
	 * @return
	 */
	public String addGo(){
		try{
			//查询当前的活动
			this.activityList = worksService.getActivityList();
			
			//清空将要上传的作品图片session
			super.setSession("photoList", null);
			this.photoList = null;
			work = null;
			
			//清空temp目录
			FileOperate.deleteDirectoryAndFile(new File(HttpUtil.getRealPath()+"userspacefile/"+this.memberid+"/works/content/temp"));
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败!");
			return ERROR;
		}
	}
	
	/**
	 * 上传作品图片
	 * @return
	 */
	public String uploadwork(){
		try{
			//记录上传的图片的名称
			ActivityWorkPhotos pho = new ActivityWorkPhotos();
			pho.setPhotoname(this.Filename);
			
			
			//上传图片
			StringBuffer spath = new StringBuffer();
			String tempworkpath = spath.append("userspacefile/")
									.append(this.memberid)
									.append("/works/content/temp/").toString();
			//上传图片名称
			String tempname = FileOperate.generateFileName(this.Filename);
			//上传资源封面图片,返回封面名称
			String tempRealPath = FileOperate.fileUpload(this.filedata,null, null, tempworkpath, tempname);
			pho.setPhotopath(tempRealPath);//此时存入的为temp目录

			//记录图片信息
			this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
			if(null == this.photoList){
				this.photoList = new ArrayList<ActivityWorkPhotos>();
			}
			photoList.add(pho);
			super.setSession("photoList", photoList);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 关闭上传作品
	 * @return
	 */
	public String closeupload(){
		try{
			//查询当前的活动
			this.activityList = worksService.getActivityList();
			//记录图片信息
			this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**]
	 * 删除已上传的作品
	 * @return
	 */
	public String deleteWorkUpload(){
		try{
			//查询当前的活动
			this.activityList = worksService.getActivityList();
			
			//图片信息
			this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
			for(int i = 0;i < photoList.size();i++){
				if(photoList.get(i).getPhotopath().equals(this.delworkup)){
					photoList.remove(i);
					break;
				}
			}
			super.setSession("photoList", photoList);
			
			//删除指定的文件
			FileOperate.deleteFile(this.delworkup);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败");
			return ERROR;
		}
	}

	/**
	 * 预添加
	 * @return
	 */
	public String addAdvance(){
		try{
			//上传缩略图片
			//图片地址
			StringBuffer snsrcpath = new StringBuffer();
			String snrealpath = snsrcpath.append("userspacefile/")
				.append(memberid)//用户
				.append("/works/face/")//作品缩略图
				.toString();
			//保存封面名称
			String snname = FileOperate.generateFileName(this.snfileFileName);
			//上传资源封面图片,返回封面名称
			String snRealPath = FileOperate.fileUpload(this.snfile,null, null, snrealpath, snname);
//		
//			//上传作品图片
//			//图片地址
//			StringBuffer worksrcpath = new StringBuffer();
//			String workrealpath = worksrcpath.append("userspacefile/")
//				.append(memberid)//用户
//				.append("/works/content/")//作品内容
//				.toString();
//			//保存封面名称
//			String workname = FileOperate.generateFileName(this.workfileFileName);
//			//上传资源封面图片,返回封面名称
//			String workRealPath = FileOperate.fileUpload(this.workfile,	null, null, workrealpath, workname);
//		
			
			Member m = new Member();
			m.setMemberid(memberid);
			m.setNikename(Member.LOGIN_MEMBER_NIKENAME);

			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			
			//设置预作品的图片参数
			work.setFacepath(snRealPath);
			work.setMember(m);
			work.setCreatedate(now);
			
		


			this.divshow = "1";			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败!");
			return ERROR;
		}
	}
	/**
	 * addAdvance方法的验证方法
	 * @throws UnsupportedEncodingException 
	 */
	public void validateAddAdvance() throws UnsupportedEncodingException{
		byte[] b;
		if(null ==  work.getWorkstitle() || work.getWorkstitle().length() == 0){
			this.addActionError("作品标题不能为空");
		} 
		else{
			b = work.getWorkstitle().getBytes("GBK");
			if(b.length > 256){
				this.addActionError("输入的作品标题过大");
			}
		}
		
		if(null == work.getActivity().getActivityid() || work.getActivity().getActivityid().length() == 0){
			this.addActionError("作品所在的活动不能为空");
		}
		if(null == this.snfileFileName || this.snfileFileName.length() == 0){
			this.addActionError("缩略图不能为空");
		}
		//图片信息
		this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
		if(null == this.photoList || this.photoList.size() == 0){
			this.addActionError("作品不能为空");
		}
		if(null == work.getWorksintro() || work.getWorksintro().length() == 0){
			this.addActionError("作品简介不能为空");
		}
		if(null == work.getWorkscontent() || work.getWorkscontent().length() == 0){
			this.addActionError("作品介绍不能为空");
		}
		
	}

	/**
	 * 取消添加
	 * @return
	 */
	public String addCancel(){
		try{
			if(null == work.getFacepath() || work.getFacepath().length() == 0){
				LogUtil.logger.error(this.getClass().getName()+":addCancel:"+"缩略图为空!");
				return ERROR;
			}
			//记录图片信息
			this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
			
			this.worksService.cancel(work,photoList);
			work.setFacepath(null);
			work.setShowsrc(null);
			super.setSession("photoList", null);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("取消失败!");
			return ERROR;
		}
	}
	
	/**
	 * 添加我的作品
	 * @return
	 */
	public String add(){
		try{
			//作品的用户信息
			Member m = new Member();
			m.setMemberid(memberid);
			m.setNikename(Member.LOGIN_MEMBER_NIKENAME);
			Activity activity = new Activity();
			activity.setActivityid(activityid);
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			
			
			
			work.setMember(m);
			work.setActivity(activity);
			work.setCreatedate(now);
			work.setApprostatu("0");
			//记录图片信息
			this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
			this.worksService.addWork(work,this.photoList);
			
			this.addActionMessage("添加成功");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败!");
			return ERROR;
		}
	}	
	/**
	 * add方法的验证方法
	 * @throws UnsupportedEncodingException 
	 */
	public void validateAdd() throws UnsupportedEncodingException{
		byte[] b;
		if(null ==  work.getWorkstitle() || work.getWorkstitle().length() == 0){
			this.addActionError("作品标题不能为空");
		} 
		else{
			b = work.getWorkstitle().getBytes("GBK");
			if(b.length > 256){
				this.addActionError("输入的作品标题过大");
			}
		}
		
		if(null == this.activityid || activityid.length() == 0){
			this.addActionError("作品所在的活动不能为空");
		}
		if(null == work.getFacepath() || work.getFacepath().length() == 0){
			this.addActionError("缩略图不能为空");
		}
		//图片信息
		this.photoList = (List<ActivityWorkPhotos>) super.getSession("photoList");
		if(null == this.photoList || this.photoList.size() == 0){
			this.addActionError("作品不能为空");
		}
		if(null == work.getWorksintro() || work.getWorksintro().length() == 0){
			this.addActionError("作品简介不能为空");
		}
		else{
			b = work.getWorksintro().getBytes("GBK");
			if(b.length > 256){
				this.addActionError("输入的作品标题过大");
			}
		}
		if(null == work.getWorkscontent() || work.getWorkscontent().length() == 0){
			this.addActionError("作品介绍不能为空");
		}
	}
	
	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		this.divshow = "0";	
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
	
}
