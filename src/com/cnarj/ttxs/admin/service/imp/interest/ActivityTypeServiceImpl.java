package com.cnarj.ttxs.admin.service.imp.interest;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.admin.service.interest.IActivityTypeService;
import com.cnarj.ttxs.dao.interest.IActivityTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 兴趣频道后台Service实现类 - 活动作品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public class ActivityTypeServiceImpl extends
		BaseServiceImpl<ActivityType, String> implements IActivityTypeService {

	IActivityTypeDao activityTypeDao;

	public IActivityTypeDao getActivityTypeDao() {
		return activityTypeDao;
	}

	public void setActivityTypeDao(IActivityTypeDao activityTypeDao) {
		this.activityTypeDao = activityTypeDao;
	}

	public void setBaseDao(IActivityTypeDao activityTypeDao) {
		super.setBaseDao(activityTypeDao);
	}

	public Result findActivityTypeByPager(Page pager, String typeName,
			String proID) throws Exception {
		return activityTypeDao.findActivityTypeByPager(pager, typeName, proID);
	}

	public void saveActivityType(ActivityType activityType) throws Exception {
		activityType.setTypeCreatedate(new Date());
		activityType.setTypeUpdatedate(new Date());
		activityTypeDao.save(activityType);
	}

	public void updateActivityType(ActivityType activityType) throws Exception {
		ActivityType activityTypeNew = activityTypeDao.get(activityType
				.getTypeId());
		activityTypeNew.setTypeUpdatedate(new Date());
		activityTypeNew.setTypeName(activityType.getTypeName());
		activityTypeNew.setPrograma(activityType.getPrograma());
		activityTypeDao.update(activityTypeNew);
	}

	public String getActivityTypeByOption(String proID) throws Exception {
		List<ActivityType> list_activityType = activityTypeDao
				.listActivityTypeByPrograma(proID);
		StringBuffer sbOption = new StringBuffer();
		String selectTypeId = HttpUtil.getParameter("selectTypeId");
		for (ActivityType activityType : list_activityType) {
			sbOption.append("<option value=\"");
			sbOption.append(activityType.getTypeId());
			sbOption.append("\" ");
			if (null != selectTypeId
					&& activityType.getTypeId().equals(selectTypeId)) {
				sbOption.append(" selected");
			}
			sbOption.append(">");
			sbOption.append(activityType.getTypeName());
			sbOption.append("</option>");
		}
		return sbOption.toString();
	}
}
