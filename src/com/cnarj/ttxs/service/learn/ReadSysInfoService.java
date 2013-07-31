package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 名师讲堂
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */

public interface ReadSysInfoService extends IBaseService<Article, Long> {

	/**
	 * 得到系统的最新3条数据
	 * @return
	 */
	public List<Article> get3Article();
}
