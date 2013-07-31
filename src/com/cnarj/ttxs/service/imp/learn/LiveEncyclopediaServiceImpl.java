package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.ILiveEncyclopediaDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.ILiveEncyclopediaService;
/**
 * 学习频道Service实现类 - 生活百科
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public class LiveEncyclopediaServiceImpl extends BaseServiceImpl<ArticleSrc, String> implements
		ILiveEncyclopediaService {

	private ILiveEncyclopediaDao encyclopediaDao;
	public ILiveEncyclopediaDao getEncyclopediaDao() {
		return encyclopediaDao;
	}
	public void setEncyclopediaDao(ILiveEncyclopediaDao encyclopediaDao) {
		this.encyclopediaDao = encyclopediaDao;
	}
	public List<ArticleSrc> getLiveEncyclopedia(int num) {
		return encyclopediaDao.getLEmcyclopedia(num);
	}
}
