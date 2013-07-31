package com.cnarj.ttxs.dao.imp.shopping;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IGoodsDao;
import com.cnarj.ttxs.dao.shopping.ISalesDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.Sales;
import com.cnarj.ttxs.util.DateUtil;

/**
 * 商品模块Dao实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class SalesDaoImpl extends BaseDaoImpl<Sales, String> implements ISalesDao{
	@SuppressWarnings("unchecked")
	public List getweekssales(int num) {
		// TODO Auto-generated method stub
		Date date=DateUtil.getCurrentDate().getTime();
		//取得当天是一年中的多少周
		int weekYear=DateUtil.getWeekOfYear(date)+1;
		//计算某年某周的开始日期
		String yearWeekFirst=null;
		String yearWeekEnd=null;
		try {
			yearWeekFirst=DateUtil.getYearWeekFirstDay(DateUtil.getYear(date), weekYear, "yyyy-MM-dd HH:mm:ss");
			//计算某年某周的结束日期
			yearWeekEnd=DateUtil.getYearWeekEndDay(DateUtil.getYear(date), weekYear, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		/**
		 * 得到一周的销售排行信息
		 */
		StringBuffer sHql=new StringBuffer();
		sHql.append("select s.goods.goodsid from Sales s where s.buydate between to_date('").append(yearWeekFirst)
		.append("','YYYY-MM-DD HH24:MI:SS') and to_date('").append(yearWeekEnd)
		.append("','YYYY-MM-DD HH24:MI:SS') group by s.goods.goodsid  order by sum(s.buynum) desc ");
		String hql=sHql.toString();
		List list= this.getSession().
		createQuery(hql).
		setMaxResults(num).list();
		return list;
	}

	public List<Goods> getbestssales(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}