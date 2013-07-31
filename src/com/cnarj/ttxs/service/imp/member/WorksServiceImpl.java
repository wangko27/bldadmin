package com.cnarj.ttxs.service.imp.member;


import java.sql.Date;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.interest.IActivityDao;
import com.cnarj.ttxs.dao.member.IWorkPhotosDao;
import com.cnarj.ttxs.dao.member.IWorksDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityWorkPhotos;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IWorksService;
import com.cnarj.ttxs.util.FileOperate;


/**
 * 空间service接口实现类 - 作品管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月6日
 */
public class WorksServiceImpl extends BaseServiceImpl<ActivityWorks,String> implements IWorksService {

	private IWorksDao worksDao;
	private IActivityDao activityDao;
	private IWorkPhotosDao workPhotosDao;
	
	
	
	public IWorkPhotosDao getWorkPhotosDao() {
		return workPhotosDao;
	}

	public void setWorkPhotosDao(IWorkPhotosDao workPhotosDao) {
		this.workPhotosDao = workPhotosDao;
	}

	public IWorksDao getWorksDao() {
		return worksDao;
	}

	public IActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public void setWorksDao(IWorksDao worksDao) {
		this.worksDao = worksDao;
	}

	public void setBaseDao(IWorksDao worksDao) {
		super.setBaseDao(worksDao);
	}

	public Result getWorksList(Page page, String memberid) {
		
		return worksDao.getWorksList(page, memberid);
	}
	
	public List<Activity> getActivityList(){
		String hql = " from Activity as model " +
				" where sysdate > model.begindate " +
				" and sysdate < model.enddate";
		return activityDao.getList(hql);
	}

	public void addWork(ActivityWorks work,List<ActivityWorkPhotos> list) {
		Assert.notNull(work, "作品对象不能为空");
		Assert.notNull(list, "作品图片不能为空");
		
		Activity acti = activityDao.get(work.getActivity().getActivityid());
		Assert.notNull(acti, "活动不能为空");

		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//1 获取作品编号
		String num = acti.getActivitycode()+String.valueOf(acti.getActivitySeq()+1);
		
		//2 修改活动中作品的计数序列
		acti.setActivitySeq(acti.getActivitySeq()+1);
		activityDao.update(acti);
		
		//3 保存作品
		work.setWorksnumber(num);
		work.setVotes(Long.valueOf("0"));
		
		worksDao.save(work);
		
		for(int i = 0;i < list.size();i++){
			list.get(i).setCreatedate(now);
			list.get(i).setWork(work);
			workPhotosDao.save(list.get(i));
		}
	}

	public void cancel(ActivityWorks work,List<ActivityWorkPhotos> list) {
		Assert.notNull(work, "作品对象不能为空");
		Assert.hasText(work.getFacepath(),"作品缩略图路径为空!");
		
		//1 删除缩略图
		FileOperate.deleteFile(work.getFacepath());
		
		//2 删除作品
		for(int i = 0;i < list.size();i++){
			FileOperate.deleteFile(list.get(i).getPhotopath());
		}
		
	}
	
}
