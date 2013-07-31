package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.IPxldDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IPxldService;

/**
 * 学习频道Service实现类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月20日
 */
public class PxldServiceImpl extends BaseServiceImpl<ArticleSrc, String>
		implements IPxldService {
	IPxldDao pxldDao;

	public IPxldDao getPxldDao() {
		return pxldDao;
	}

	public void setPxldDao(IPxldDao pxldDao) {
		this.pxldDao = pxldDao;
	}

	public void setBaseDao(IPxldDao pxldDao) {
		super.setBaseDao(pxldDao);
	}

	@SuppressWarnings("unchecked")
	public List listArticleByRecommend(int shownum) throws Exception {
		return pxldDao.listArticleByRecommend(shownum);
	}

}
