package com.cnarj.ttxs.dao;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MimiInfo;

/**
 * 密码空间接口类
 * @author hedan
 *
 */
public interface MimiInfoDao extends IBaseDao< MimiInfo, String>{

	public Result getPager(Page page, Long classId);
	
}
