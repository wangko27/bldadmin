package com.cnarj.ttxs.service.member;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MimiInfo;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 密码空间接口
 * @author hedan
 *
 */
public interface MimiInfoService extends IBaseService<MimiInfo, String>{

	
	public Result getPager(Page pager, Long classId);
}
