package com.cnarj.ttxs.dao.interest;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;

/**
 * 兴趣频道Dao接口类 - 活动栏目Dao
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityProgramaDao extends
		IBaseDao<ActivityPrograma, String> {

	/**
	 * 
	 * 得到活动栏目信息 isNumber 是否启用限行
	 * 
	 * @param hql
	 *            要执行的sql语句
	 * @param number
	 *            显示行数
	 * @return 返回结果
	 */
	public List<ActivityPrograma> getActivityProgramas(boolean isNumber,
			String hql, int number);

	/**
	 * 查找活动栏目（带分页）
	 * 
	 * @param pager
	 * 
	 * @param proName
	 *            栏目名称
	 * @param proIsenable
	 *            状态
	 * @return
	 * @throws Exception
	 */
	public Result findProgramaByPager(Page pager, String proName,
			Long proIsenable) throws Exception;
/**
 * 得到展示图片
 * @param hql
 * @return
 */
	public List<ActivityWorksShow> getShowPics(String hql);

	/**
	 * 得到所有的排行榜   (分页)
	 * @param hql
	 * @param page
	 * @return
	 */
public Result getAllFera(String hql, Page page);
}
