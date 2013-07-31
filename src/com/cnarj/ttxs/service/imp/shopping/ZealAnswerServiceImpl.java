package com.cnarj.ttxs.service.imp.shopping;


import java.util.List;

import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.dao.shopping.IZealAnswerDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IZealAnswerService;
/**
 * 商城模块实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class ZealAnswerServiceImpl extends BaseServiceImpl<ZealAnswer, String> implements IZealAnswerService{
	public void setBaseDao(IZealAnswerDao zealAnswerDao) {
		super.setBaseDao(zealAnswerDao);
	}
	private IZealAnswerDao zealAnswerDao;
	public IZealAnswerDao getZealAnswerDao() {
		return zealAnswerDao;
	}
	public void setZealAnswerDao(IZealAnswerDao zealAnswerDao) {
		this.zealAnswerDao = zealAnswerDao;
	}
	public Long getTotalCount(String isnull) {
		// TODO Auto-generated method stub
		return zealAnswerDao.getTotalCount(isnull);
	}
	public Result getQuestionBystaues(Page page, String isnull) {
		// TODO Auto-generated method stub
		return zealAnswerDao.getQuestionBystaues(page, isnull);
	}
	public Result getQuestionRI(Page page, String questiontitle){
		return zealAnswerDao.getQuestionRI(page, questiontitle);
	}
	public Long getTotalCountBysartch(String questiontitle){
		return zealAnswerDao.getTotalCountBysartch(questiontitle);
	}
}
