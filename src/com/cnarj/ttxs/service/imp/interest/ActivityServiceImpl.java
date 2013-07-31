package com.cnarj.ttxs.service.imp.interest;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Engineering;

import com.cnarj.ttxs.dao.interest.IActivityDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityTeacher;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.util.DateUtil;
import com.jhlabs.image.BentleyFilter;

/**
 * 兴趣频道service实现类 -  活动信息impl
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public class ActivityServiceImpl extends BaseServiceImpl<Activity, String> implements IActivityService {
	private IActivityDao activityDao;

	public IActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	public List<Activity> getActicity(int num) {
		return activityDao.getActicity(num);
		
	}
	/**
	 * 
	 * @param proId 活动栏目的id号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result getActivitys(String proId,String resKey,Page page) {
		
		if(proId!=null&&!proId.trim().equals("")){
			Calendar cal=Calendar.getInstance();//创建一个当前的日期类
			StringBuffer hql=new StringBuffer();
			hql.append("from Activity a where 1=1");
			if(!proId.trim().equals("1")){
				hql.append(" and a.programa.proID='").append(proId).append("'");
			}
			if(resKey!=null&&!resKey.equals("")){
				hql.append(" and a.activitytitle like '%").append(resKey).append("%'");
				
			}
			hql.append(" order by a.createdate desc");
			Result result=activityDao.getActivitys(hql.toString(), page);
			List<Activity> actis=result.getContent();
			for(Iterator<Activity> iterator=actis.iterator();iterator.hasNext();){
				Activity acti=iterator.next();
				Calendar beginCal=Calendar.getInstance();
				beginCal.setTime(acti.getBegindate());//活动开始时间
				Calendar endCal=Calendar.getInstance();
				endCal.setTime(acti.getEnddate());//活动的结束时间
				if(cal.before(beginCal)){//当前时间在begin时间之后返回true
					acti.setIsState(0);//没有开始
				}else if(cal.after(endCal)){//cal是否在endCal之后
					acti.setIsState(1);//活动结束
				}else{
					acti.setIsState(2);//活动进行中
				}
			}
			return result;
		}
		return null;
	}

	public ActivityPrograma getActivityProGramaName(String proId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityPrograma a where a.proID='").append(proId).append("'");
		return activityDao.getByIdActivityPrograma(hql.toString());
	}
	/**
	 * 按栏目id得到最新的活动信息
	 * @param proId
	 * @return
	 */
	public Activity getByProIdAndCreateTime(String proId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Activity a where a.programa.proID='").append(proId)
		.append("' order by a.createdate desc");
		List<Activity> acts=activityDao.getByProIdAndCreateTime(hql.toString());
		if(acts.size()!=0){
			return acts.get(0);
		}
		return null;
	}
	/**
	 * 按栏目id得到已关闭的活动
	 * @param proId
	 * @return
	 */
	public List<Activity> getnewsActivity(int num){
		String hql="from Activity a order by a.begindate desc";
		return activityDao.getActivity(hql.toString(), num);
	}
	/**
	 * 按栏目id得到已关闭的活动
	 * @param proId
	 * @return
	 */
	public List<Activity> getCloseActivity(String proId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Activity a where a.programa.proID='").append(proId).append("' and a.enddate<sysdate");
		return activityDao.getCloseActivity(hql.toString());
	}
	/**
	 * 得到两位推荐的老师
	 */
	public List<ActivityTeacher> getTwoTeacher() {
		StringBuffer hql=new StringBuffer();
		hql.append("from ActivityTeacher t where t.isrecomment='1' order by t.createdate desc");
		return activityDao.getTwoTeacher(hql.toString(),2);
	}

	/**
	 * 显示前三个月和后一个月的活动的类别
	 * @return
	 */
	public List<Activity> getActicityType() {
		StringBuffer hql=new StringBuffer();
		String date;
		String date2;
		try {
			date = DateUtil.DateAdd(new Date(), "yyyy-MM-dd HH:mm:ss", -3, Calendar.MONTH);//前三个月
			date2=DateUtil.DateAdd(new Date(), "yyyy-MM-dd HH:mm:ss", 1, Calendar.MONTH);//后一个月
		
			hql.append("from Activity a where a.programa.proID='8a8081b121bd7ec20131bd7f78e50001'")
			.append(" and to_char(a.begindate,'yyyy-MM-dd HH:mm:ss')>='").append(date)
			.append("' and to_char(a.begindate,'yyyy-MM-dd HH:mm:ss')<='").append(date2).append("'");
			return activityDao.getActivityType(hql.toString());
			}catch (ParseException e) {
				e.printStackTrace();
			}
		return null;
	}

	public Result getcAllCloseAct(Page pager) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Activity a where a.enddate<sysdate");
		return activityDao.getAllCloseAct(hql.toString(),pager);
	}

	public List<Activity> getActivity(int i){
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from Activity a where a.programa.proIsenable='1'").append("and a.begindate<sysdate").append(" order by a.begindate desc");
		return activityDao.getActivity(hql.toString(), i);
	}
	public List<Activity> getActivity(int i ,String programa ){
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from Activity a where a.programa.proIsenable='1'").append(" and a.programa.proID='").append(programa).append("'").append("and a.begindate<sysdate").append(" order by a.begindate desc");
		String ss=hql.toString();
		return activityDao.getActivity(ss, i);
	}

	public List<Activity> ShowindexActivity(int num) {
		// TODO Auto-generated method stub
		return activityDao.ShowindexActivity(6);
	}
}
