package com.cnarj.ttxs.service.learn;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 品学论道的service类
 * 李万余
 * @author Administrator
 *
 */
public interface IPingXueService extends IBaseService<ArticleSrc, String> {

	/**
	 * 
	 * @param type 是否为全部
	 * @param sId 学生id
	 * @param Tid 老师id
	 * @param Jid 家长id
	 * @return 结果
	 */
	public Result getAllPinXue(String type,String id,Page page );
}
