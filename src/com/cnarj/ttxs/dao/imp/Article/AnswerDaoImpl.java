package com.cnarj.ttxs.dao.imp.Article;

import java.util.List;

import org.hibernate.Query;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;

/**
 * 测试实现类 - 用于测试的Dao实现类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */


public class AnswerDaoImpl extends BaseDaoImpl<Answer, String> implements IAnswerDao {
	@SuppressWarnings("unchecked")
	public List<Answer> getAnswerList(String propertyName, Object Value) {
		// TODO Auto-generated method stub
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(Value, "value is required");
		String hql="select * from Answer where "+propertyName+"="+Value+"";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Answer> getTopanswer(String answerdate, int number) {
		// TODO Auto-generated method stub
		String hql="from Answer  order by "+answerdate+" desc";
		List list = getSession().
		createQuery(hql).setMaxResults(number).
		list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Answer> getbestanswer(String Isbest, Object question) {
		// TODO Auto-generated method stub
		String hql="from Answer where isbest='"+Isbest+"' and  question.questionid='"+question+"'";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	/*
	 * 判断用户是否重复回答问题判断用户回答问题的次数
	 * 
	 */
	public boolean isExist(String propertyName, Object value,String questionid){
		String hql="select count (*) from Answer a where a."+propertyName+"='"+value+"' and  a.question.questionid='"+questionid+"'";
		Query query = getSession()
		.createQuery(hql);
		if (((Long) query.uniqueResult()) > new Long(0)) {
			return true;
		} else {
			return false;
		}
	}
}
	
