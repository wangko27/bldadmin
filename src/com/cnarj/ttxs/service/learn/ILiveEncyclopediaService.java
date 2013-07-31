package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 生活百科
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface ILiveEncyclopediaService extends IBaseService<ArticleSrc, String> {

	/**
	 * num 为显示多少条
	 * 得到3条生活百科
	 * @return
	 */
	public List<ArticleSrc> getLiveEncyclopedia(int num);
}
