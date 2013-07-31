package com.cnarj.ttxs.dao.imp.shopping;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IOrderDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Orders;

/**
 * 商城频道Dao接口实现类 - 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月6日
 */
public class OrderDaoImpl extends BaseDaoImpl<Orders, String> implements
		IOrderDao {

	/**
	 * 查找订单（带分页）
	 * 
	 * @param pager
	 * 
	 * @param ordersn
	 *            订单号
	 * @param begindate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 * @param status
	 *            状态
	 * @return
	 * @throws Exception
	 */
	public Result findOrderByPager(Page pager, String ordersn,
			String begindate, String enddate, Long status) throws Exception {
		StringBuffer sbHql = new StringBuffer("from Orders o where 1=1");
		if (null != ordersn && !"".equals(ordersn)) {
			sbHql.append(" and o.ordersn like '%" + ordersn + "%'");
		}

		if (null != begindate && !"".equals(begindate)) {
			sbHql.append(" and to_date(o.createdate,'yyyy-MM-dd')>='"
					+ begindate + "'");
		}
		if (null != enddate && !"".equals(enddate)) {
			sbHql.append(" and to_date(o.createdate,'yyyy-MM-dd')<='" + enddate
					+ "'");
		}
		if (null != status) {
			sbHql.append(" and o.orderstatus=" + status);
		}
		sbHql.append(" order by createdate desc");
		return this.findByPager(pager, sbHql.toString());
	}

    @Override
    public Orders findById(String id) {
        StringBuffer hql = new StringBuffer();
        hql.append("from Orders where orderid ='").append(id).append("'");
        return (Orders)this.getSession().createQuery(hql.toString()).uniqueResult();
    }
}
