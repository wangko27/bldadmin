package com.cnarj.ttxs.service.imp.Article;

import java.util.List;

import com.cnarj.ttxs.dao.Article.IAnswerDao;

import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.IAnswerService;




/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class AnswerServiceImpl extends BaseServiceImpl<Answer,String> implements IAnswerService {
	
	public void setBaseDao(IAnswerDao AnswerDao) {
		super.setBaseDao(AnswerDao);
	}
	private IAnswerDao AnswerDao;
	public IAnswerDao getAnswerDao() {
		return AnswerDao;
	}



	public void setAnswerDao(IAnswerDao answerDao) {
		AnswerDao = answerDao;
	}



	public List<Answer> getAnswerList(String propertyName, Object Value) {
		// TODO Auto-generated method stub
		return AnswerDao.getAnswerList(propertyName, Value);
	}
	public List<Answer> getTopanswer(String answerdate, int number){
		return AnswerDao.getTopanswer(answerdate, number);
	}



	public List<Answer> getbestanswer(String Isbest, Object question) {
		// TODO Auto-generated method stub
		return AnswerDao.getbestanswer(Isbest, question);
	}
	
	/*
	 * 判断用户是否重复回答问题判断用户回答问题的次数
	 * 
	 */
	public boolean isExist(String propertyName, Object value,String questionid){
		
		return AnswerDao.isExist(propertyName, value, questionid);
	}
}