package com.cnarj.ttxs.service.interest;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityWorksShow;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 兴趣频道Service类 - 活动栏目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月22日
 */
public interface IActivityProgramaService extends IBaseService<ActivityPrograma, String> {
	
	/**
	 * 得到导航栏目的
	 * @param isNumber 是否启用限行
	 * @param isSelect  是否启用条件查询
	 * @param number  限行条数
	 * @return 得到结果
	 */
	public List<ActivityPrograma> getTopPrograma(boolean isNumber,int number,boolean isSelect);

	/**
	 * 得到展示图片
	 * @return
	 */
	public List<ActivityWorksShow> getShowPics();

	/**
	 * 得到所有的排行榜信息
	 * @return
	 */
	public Result getShowAllFera(String actiId,Page page);
}
