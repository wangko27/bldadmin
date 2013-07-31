package com.cnarj.ttxs.admin.service.interest;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道后台Service接口类 - 活动栏目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月23日
 */
public interface IActivityProgramaService extends
		IBaseService<ActivityPrograma, String> {
	/**
	 * 添加活动栏目
	 * 
	 * @param programa
	 * @throws Exception
	 */
	public void savePrograma(ActivityPrograma programa) throws Exception;

	/**
	 * 修改活动栏目
	 * 
	 * @param programa
	 * @throws Exception
	 */
	public void updatePrograma(ActivityPrograma programa) throws Exception;

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
	 * 删除栏目
	 * 
	 * @param proID
	 * @throws Exception
	 */
	public void deletePrograma(String proID) throws Exception;
}
