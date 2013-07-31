package com.cnarj.ttxs.dao.Article;

import java.util.List;

import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.dao.IBaseDao;

/**
 * 测试Dao接口 - 用于测试的Dao接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface IAnswerDao extends IBaseDao<Answer,String>{
	/**
	 * 查找根据属性排序的前几条数据.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Answer> getAnswerList(String propertyName, Object Value);
	/**
	 * 首页最新问题.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value    回答时间
	 *            属性值
	 * @return 实体对象集合
	 */
	public  List<Answer> getTopanswer(String answerdate, int number);
	/**
	 * 首页最新问题.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value    回答时间
	 *            属性值
	 * @return 实体对象集合
	 */
	public  List<Answer> getbestanswer(String Isbest, Object question);
	
	public boolean isExist(String propertyName, Object value,String questionid);
}
