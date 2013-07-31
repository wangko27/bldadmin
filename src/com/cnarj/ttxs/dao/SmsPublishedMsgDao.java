package com.cnarj.ttxs.dao;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.dsis.SmsPublishedMsg;


/**
 * 短信发送记录接口
 * @author hedan
 *
 */
public interface SmsPublishedMsgDao extends BaseDsisDao<SmsPublishedMsg, Long>{

	/**
	 * 根据手机号码查询发送的信息--带分页
	 * @param mobile
	 * @param startDate
	 * @param endDate
	 * @param pageSize
	 * @param nowpage
	 * @return
	 */
	public Result getSmsMsgPage(String mobile, String startDate,
			String endDate, Page page);
	
	/**
	 * 根据学生id查询发送的信息--带分页
	 * @param xsId
	 * @param startDate
	 * @param endDate
	 * @param page
	 * @return
	 */
	public Result getSmsMsgPage(Long xsId, String startDate, String endDate, Page page);
	
	/**
	 * 根据班级查询信息--带分页
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param classId
	 * @return
	 */
	public Result getSmsMsgPage(Page page,String startDate, String endDate, Long classId);
}
