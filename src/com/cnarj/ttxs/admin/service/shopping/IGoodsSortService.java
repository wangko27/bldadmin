package com.cnarj.ttxs.admin.service.shopping;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 商城频道后台Service接口类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public interface IGoodsSortService extends IBaseService<GoodesCategory, String> {

	/**
	 * 得到主类别
	 * @return
	 */
	public List<GoodesCategory> getAllSort();

	/**
	 * 添加商品类别
	 * @param category 类别对象
	 * @return 是否成功
	 */
	public boolean saveSrot(GoodesCategory category);

	/**
	 * 判断是否有同名的类型
	 * @param categoryName
	 * @return
	 */
	public boolean isOccurSrot(String categoryName);

	/**
	 * 按条件查询  并分页
	 * @param page
	 * @param categoryName 上级类名
	 * @param isSell 是否为  热销
	 * @return 
	 */
	public Result byConditionSort(Page page, String categoryName, String isSell,String cateName);

	/**
	 * 修改类别
	 * @param category
	 * @return
	 */
	public boolean updateSrot(GoodesCategory category);

	/**
	 * 根据类别id  查找类别信息
	 * @param categoryName
	 * @return
	 */
	public GoodesCategory getByIdQuery(String categoryName);

	/**
	 * 按类别id 删除类别的信息
	 * @param categoryName
	 */
	public void deleteBySrotIdDeleteSrot(String categoryName);

}
