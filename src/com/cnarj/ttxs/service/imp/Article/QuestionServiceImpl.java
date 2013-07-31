package com.cnarj.ttxs.service.imp.Article;

import java.util.List;

import com.cnarj.ttxs.dao.Article.IQuestionDao;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import com.cnarj.ttxs.service.Article.IQuestionService;



/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class QuestionServiceImpl extends BaseServiceImpl<Question,String> implements IQuestionService {
	public void setBaseDao(IQuestionDao QuestionDao) {
		super.setBaseDao(QuestionDao);
	}
	private	IQuestionDao QuestionDao;

	public IQuestionDao getQuestionDao() {
		return QuestionDao;
	}
	public void setQuestionDao(IQuestionDao questionDao) {
		QuestionDao = questionDao;
	}

	public List<Question> getQuestionRI(String questionType,Object value) {
		// TODO Auto-generated method stub
		
		return QuestionDao.getQuestionRI(questionType, value);
	}
		public List<Question> getFrushQuestion(String propertyName, String orderBy,
			
			int number,String questionid) {
		// TODO Auto-generated method stub
		return QuestionDao.getFrushQuestion(propertyName, orderBy, number, questionid);
	}
	 
	public List<Question> getHOTQuestion(String visittime,String answernum ,String begindate, int number){
		// TODO Auto-generated method stub
		return QuestionDao.getHOTQuestion(visittime, answernum, begindate, number);
	}
	public Result getQuestionBystaues(Page page,String questionstatus,String questiontypeid){
		return QuestionDao.getQuestionBystaues(page, questionstatus, questiontypeid);
	}
	public Long getTotalCount(String questionstatus,String questiontypeid){
		return QuestionDao.getTotalCount(questionstatus, questiontypeid);
	}
	public Result searchQuestion(Object value, Page page) {
		// TODO Auto-generated method stub
		return QuestionDao.searchQuestion(value, page);
	}
	public Long searchQuestion(Object value) {
		// TODO Auto-generated method stub
		return QuestionDao.searchQuestion(value);
	}
	/*
	 * 限制用户一天回答三个问题 
	 * 
	 */
	
}