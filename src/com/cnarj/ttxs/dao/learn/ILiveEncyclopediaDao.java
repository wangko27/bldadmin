package com.cnarj.ttxs.dao.learn;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;


/**
 * 学习频道Dao接口类 - 生活百科(文章资源表)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface ILiveEncyclopediaDao extends IBaseDao<ArticleSrc, String>{
	/**
	 * 得到5条生活百科
	 * @return
	 */
	public List<ArticleSrc> getLEmcyclopedia(int num);
}
