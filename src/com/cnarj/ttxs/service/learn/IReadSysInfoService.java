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

public interface IReadSysInfoService extends IBaseService<Article, String> {

	/**
	 * 栏目的条数 num
	 * 得到系统的最新3条数据
	 * @return
	 */
	public List<Article> getArticle(int num);
	/**
	 * 按系统公告Id得到系统信息
	 */
	public Article getArticle(String articleId);
	/**
	 * 根据关键字得到相关的阅读
	 */
	public List<Article> getXingGuanArticle(int num ,String keyString,String articleId);
}
