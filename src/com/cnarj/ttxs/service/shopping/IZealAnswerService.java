package com.cnarj.ttxs.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 商城模块service类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IZealAnswerService extends IBaseService<ZealAnswer, String> {
	/**
	 * 根据问题状态查找和类别查找问题总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Long getTotalCountBysartch(String questiontitle);
	/**
	 * 根据问题状态查找和类别查找问题总数
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Long getTotalCount(String isnull);
	/**
	 * 根据问题状态分页查找
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Result getQuestionBystaues(Page page,String isnull) ;
	/**
	 * 根据标题检索问题相关问题
	 * 
	 * @param propertyName
	 *            属性名称
	 * @param value
	 *            属性值
	 * @return 实体对象集合
	 */
	public Result getQuestionRI(Page page, String questiontitle);
}
