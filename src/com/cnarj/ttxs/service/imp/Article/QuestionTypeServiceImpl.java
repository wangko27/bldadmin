package com.cnarj.ttxs.service.imp.Article;

import java.util.List;

import com.cnarj.ttxs.dao.Article.IQuestionDao;
import com.cnarj.ttxs.dao.Article.IQuestionTypeDao;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.info.QuestionType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.IQuestionTypeService;



/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class QuestionTypeServiceImpl extends BaseServiceImpl<QuestionType,String> implements IQuestionTypeService{
	public void setBaseDao(IQuestionTypeDao questionTypeDao) {
		super.setBaseDao(questionTypeDao);
	}
	private	IQuestionTypeDao QuestionTypeDao;
	public IQuestionTypeDao getQuestionTypeDao() {
		return QuestionTypeDao;
	}
	public void setQuestionTypeDao(IQuestionTypeDao questionTypeDao) {
		QuestionTypeDao = questionTypeDao;
	}
}