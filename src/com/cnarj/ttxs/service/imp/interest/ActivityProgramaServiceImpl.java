package com.cnarj.ttxs.service.imp.interest;

import java.util.List;

import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.dao.interest.IActivityProgramaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityProgramaService;
/**
 * 兴趣频道Service实现类 - 活动栏目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityProgramaServiceImpl extends BaseServiceImpl<ActivityPrograma, String> implements
		IActivityProgramaService {
	
	public void setBaseDao(IActivityProgramaDao activityProgramaDao) {
		super.setBaseDao(activityProgramaDao);
	}
	private IActivityProgramaDao activityProgramaDao;

	public IActivityProgramaDao getActivityProgramaDao() {
		return activityProgramaDao;
	}

	public void setActivityProgramaDao(IActivityProgramaDao activityProgramaDao) {
		this.activityProgramaDao = activityProgramaDao;
	}

	/**
	 * 排行版内的栏目推荐时间一次排序
	 * 得到导航栏目的
	 * @param isNumber 是否启用限行
	 * @param isSelect  是否启用条件查询
	 * @param number  限行条数
	 * @return 得到结果
	 */
	public List<ActivityPrograma> getTopPrograma(boolean isNumber, int number,boolean isSelect) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityPrograma a where 1=1");
		if(isNumber&&isSelect){//按启用 和 限行
			if(number<=0){
				number=1;
			}
			hql.append(" and a.proIsenable=1 order by a.proSort");
			return activityProgramaDao.getActivityProgramas(isNumber, hql.toString(), number);
		}
		if(!isNumber&&isSelect){//按启用 和不限行查询
			hql.append(" and a.proIsenable=1 order by a.proSort");
			return activityProgramaDao.getActivityProgramas(isNumber, hql.toString(), number);
		}
		if(isNumber&&!isSelect){//按 不启用  和限行查询
			hql.append(" order by a.proSort");
			return activityProgramaDao.getActivityProgramas(isNumber, hql.toString(), number);
		}
		if(!isNumber&&!isSelect){//什么都不按
			return activityProgramaDao.getActivityProgramas(isNumber, hql.toString(), number);
		}
		return null;
	}
	/**
	 * 得到展示图片
	 * @return
	 */
	public List<ActivityWorksShow> getShowPics() {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityWorksShow s where s.showEnabled='1' order by s.showSort");
		
		return activityProgramaDao.getShowPics(hql.toString());
	}
/**
 * 得到所有的排行榜信息
 */
	public Result getShowAllFera(String actId,Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityWorks w where w.activity.activityid='").append(actId).append("' order by w.votes desc");
		return activityProgramaDao.getAllFera(hql.toString(),page);
	}
}
