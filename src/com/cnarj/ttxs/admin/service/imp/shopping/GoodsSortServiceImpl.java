package com.cnarj.ttxs.admin.service.imp.shopping;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.dao.shopping.IGoodsSrotDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
/**
 * 商城频道后台Service实现类 - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsSortServiceImpl extends BaseServiceImpl<GoodesCategory, String> implements com.cnarj.ttxs.admin.service.shopping.IGoodsSortService {

	private IGoodsSrotDao srotDao;
	public IGoodsSrotDao getSrotDao() {
		return srotDao;
	}
	public void setSrotDao(IGoodsSrotDao srotDao) {
		this.srotDao = srotDao;
	}
	/**
	 * 得到主类别
	 */
	public List<GoodesCategory> getAllSort() {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory c where c.goodesCategory.categoryid is null order by c.orderlist");
		return srotDao.getMainList(hql.toString());
	}
	/**
	 * 添加类别
	 */
	public boolean saveSrot(GoodesCategory category) {
		category.setCreatedate(new Date());
		category.setModifydate(new Date());
		category.setGoodsnum(new Long(0));
		return srotDao.save(category)==null?false:true;
	}
	/**
	 * 判断是否有同名类型
	 */
	public boolean isOccurSrot(String categoryName) {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory c where c.categoryname='").append(categoryName.trim()).append("'");
		return srotDao.isOccurSrot(hql.toString());
	}
	/**
	 * 按条件查询  并分页
	 * @param page
	 * @param categoryName 上级类名
	 * @param isSell 是否为  热销
	 * @return 
	 */
	public Result byConditionSort(Page page, String categoryName, String isSell,String cateName) {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodesCategory c where 1=1");
		if(categoryName!=null&&!categoryName.trim().equals("")){
			hql.append(" and c.goodesCategory.categoryid='").append(categoryName).append("'");
		}
		if(isSell!=null&&!isSell.trim().equals("")){
			hql.append(" and c.ishot='").append(isSell).append("'");
		}
		if(cateName!=null&&!cateName.trim().equals("")){
			hql.append(" and c.categoryname like '%").append(cateName).append("%'");
		}
		return srotDao.byConditionSort(hql.toString(),page);
	}
	/**
	 * 修改类别
	 */
	public boolean updateSrot(GoodesCategory category) {
		category.setModifydate(new Date());
		srotDao.update(category);
		return true;
	}
	/**
	 * 查询方法
	 */
	public GoodesCategory getByIdQuery(String categoryName) {
		return srotDao.get(categoryName);
	}
	/**
	 * 按类别得id 删除类别信息
	 */
	public void deleteBySrotIdDeleteSrot(String categoryName) {
		srotDao.delete(categoryName);
	}
	
}
