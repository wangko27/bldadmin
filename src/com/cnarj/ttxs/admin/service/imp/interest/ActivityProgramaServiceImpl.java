package com.cnarj.ttxs.admin.service.imp.interest;

import java.util.Date;

import com.cnarj.ttxs.admin.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.dao.Article.ISysArticleTypeDao;
import com.cnarj.ttxs.dao.interest.IActivityProgramaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 兴趣频道后台Service实现类 - 活动栏目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityProgramaServiceImpl extends
		BaseServiceImpl<ActivityPrograma, String> implements
		IActivityProgramaService {

	IActivityProgramaDao activityProgramaDao;

	ISysArticleTypeDao sysArticleTypeDao;

	public IActivityProgramaDao getActivityProgramaDao() {
		return activityProgramaDao;
	}

	public void setActivityProgramaDao(IActivityProgramaDao activityProgramaDao) {
		this.activityProgramaDao = activityProgramaDao;
	}

	public ISysArticleTypeDao getSysArticleTypeDao() {
		return sysArticleTypeDao;
	}

	public void setSysArticleTypeDao(ISysArticleTypeDao sysArticleTypeDao) {
		this.sysArticleTypeDao = sysArticleTypeDao;
	}

	public void setBaseDao(IActivityProgramaDao activityProgramaDao) {
		super.setBaseDao(activityProgramaDao);
	}

	public void savePrograma(ActivityPrograma programa) throws Exception {

		// 创建系统文章类别（在兴趣类别下添加该栏目类别）
		SysArticleType articleType_xq = sysArticleTypeDao
				.get("8a80818c31b6a6270131b6a835780013");
		SysArticleType sysArticleType = new SysArticleType();
		sysArticleType.setCreatedate(new Date());
		sysArticleType.setModifydate(new Date());
		sysArticleType.setArticletypename(programa.getProName());
		sysArticleType.setArticleType(articleType_xq);
		sysArticleType.setArticlesort(new Long(2));
		String articletypeid = sysArticleTypeDao.save(sysArticleType);

		// 保存栏目信息
		programa.setProCreatedate(new Date());
		programa.setProUpdatedate(new Date());
		programa.setProProgramatypeid(articletypeid);
		activityProgramaDao.save(programa);
	}

	public void updatePrograma(ActivityPrograma programa) throws Exception {
		ActivityPrograma programaNew = activityProgramaDao.get(programa
				.getProID());
		programaNew.setProUpdatedate(new Date());
		programaNew.setProName(programa.getProName());
		programaNew.setProIsenable(programa.getProIsenable());
		programaNew.setProSort(programa.getProSort());
		programaNew.setProUrl(programa.getProUrl());
		activityProgramaDao.update(programaNew);
	}

	public Result findProgramaByPager(Page pager, String proName,
			Long proIsenable) throws Exception {
		return activityProgramaDao.findProgramaByPager(pager, proName,
				proIsenable);
	}

	public void deletePrograma(String proID) throws Exception {

		// 查询栏目信息
		ActivityPrograma programa = activityProgramaDao.get(proID);

		if (null != programa.getProProgramatypeid()) {
			// 删除系统文章分类 栏目分类
			sysArticleTypeDao.delete(programa.getProProgramatypeid());
		}

		// 删除栏目
		activityProgramaDao.delete(programa);
	}

}
