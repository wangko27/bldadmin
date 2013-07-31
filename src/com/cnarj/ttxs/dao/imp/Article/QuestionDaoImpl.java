package com.cnarj.ttxs.dao.imp.Article;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.IQuestionDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
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


public class QuestionDaoImpl extends BaseDaoImpl<Question, String> implements IQuestionDao {
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionRI(String questionType,Object value) {
		Assert.notNull(questionType, "value is required");
		Assert.hasText(questionType,"value is not null");
		String hql ="from Question where "+questionType+"='"+value+"' and rownum<6 order by begindate desc";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	@SuppressWarnings("unchecked")
		public List<Question> getFrushQuestion(String propertyName, String orderBy,
			
			int number,String questionid){
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(orderBy, "value is required");
		Assert.notNull(number, "number is required");
		String hql ="from Question where rownum <="+number+" and questionid!='"+questionid+"' order by "+propertyName+" "+orderBy+"";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Question> getHOTQuestion(String visittime,String answernum ,String begindate, int number){
		String hql ="from Question where rownum <="+number+"  order by "+visittime+" ,"+answernum+","+begindate+" desc";
		List list = getSession().
		createQuery(hql).
		list();
		return list;
	}
	public Result getQuestionBystaues(Page page,String questionstatus,String questiontypeid) {
		StringBuffer sbHql = new StringBuffer();		
		if(null==questiontypeid||"".equals(questiontypeid.trim())){
			if(null==questionstatus||"".equals(questionstatus.trim())){
				sbHql.append("from Question order by begindate desc");
			}
			else{
				sbHql.append("from Question where questionstatus='").append(questionstatus).append("' order by begindate desc");
			}
		}
		else{
			if(null==questionstatus||"".equals(questionstatus.trim())){
				sbHql.append("from Question where questionType.questiontypeid='").append(questiontypeid).append("'").append(" order by begindate desc");
			}
			else{
				sbHql.append("from Question where questionType.questiontypeid='").append(questiontypeid).append("' and questionstatus='").append(questionstatus).append("' order by begindate desc");
			}
		}
		return this.findByPager(page, sbHql.toString());
	}
	public Long getTotalCount(String questionstatus,String questiontypeid) {
		StringBuffer sbHql = new StringBuffer();
		if(null==questiontypeid||"".equals(questiontypeid.trim())){
			if(null==questiontypeid||"".equals(questiontypeid.trim())){
				sbHql.append("select count(*) from Question");
			}
			else{
				sbHql.append("select count(*) from Question where questionstatus='").append(questionstatus).append("'");
			}
		}
		else{
			if(null==questionstatus||"".equals(questionstatus.trim())){
				sbHql.append("select count(*) from Question where questionType.questiontypeid='").append(questiontypeid).append("'");
			}else{
				sbHql.append("select count(*) from Question where questionType.questiontypeid='").append(questiontypeid).append("' and questionstatus='").append(questionstatus).append("'");
			}
		}
		return (Long) getSession().createQuery(sbHql.toString()).uniqueResult();
	}
	public Long searchQuestion( Object value) {
		String hql = "select count(*) from Question where question like '%"+value+"%'";
		return  (Long) getSession().createQuery(hql).uniqueResult();
	}
	public Result searchQuestion(Object value, Page page) {
		String hql ="from Question  where question like '%"+value+"%'";
		return this.findByPager(page, hql);
	}
} 
