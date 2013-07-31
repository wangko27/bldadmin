package com.cnarj.ttxs.dao.Article;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
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
public interface IQuestionDao extends IBaseDao<Question,String>{
	/**
	 * 根据HQL获取实体对象总数
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Result searchQuestion(Object value,Page page);
	/**
	 * 根据HQL获取实体对象总数
	 * @param propertyName
	 * 			属性名称
	 * @param value
	 * 			属性值
	 * @return 是实体对象总数
	 */
	public Long searchQuestion(Object value);
	/**
	 * 根据问题状态分页查找和类别
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Result getQuestionBystaues(Page page,String questionstatus,String questiontypeid) ;
	/**
	 * 根据问题状态查找和类别查找问题总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Long getTotalCount(String questionstatus,String questiontypeid) ;
	/**
	 * 根据属性名和属性值获取相关实体对象集合.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public List<Question> getQuestionRI(String questionType,Object value) ;
	/**
	 * 查找根据属性排序的前几条数据.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
		public List<Question> getFrushQuestion(String propertyName, String orderBy,
			
			int number,String questionid);	
	/**
	 * 查找根据属性排序的前几条数据.
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */ 
	public List<Question> getHOTQuestion(String visittime,String answernum ,String begindate, int number);
}
