package com.cnarj.ttxs.service.imp.shopping;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.dao.shopping.IGoodsDao;
import com.cnarj.ttxs.dao.shopping.ISalesDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.util.DateUtil;
/**
 * 商城模块实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsServiceImpl extends BaseServiceImpl<Goods, String> implements IGoodsService {
	
	public void setBaseDao(IGoodsDao goodsDao) {
		super.setBaseDao(goodsDao);
	}
	private IGoodsDao goodsDao;
	private ISalesDao salesDao;
	
	public ISalesDao getSalesDao() {
		return salesDao;
	}
	public void setSalesDao(ISalesDao salesDao) {
		this.salesDao = salesDao;
	}
	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	/**
	 * 
	 * @param byTopicId 按主题id来查看商品列表(比如 全部商品 资源库题 卡通人偶)
	 * @param byTermId 1为按销量  2为价格
	 * @param page 分页
	 * @return
	 */
	public Result getAllGoods(String byTopicId, String byTermId,String byMainTopicId, Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where 1=1");
		if(byTopicId!=null&&!byTopicId.trim().equals("")){//按类别查询
			hql.append(" and g.goodesCategory.categoryid='").append(byTopicId).append("'");
		}
		if(byMainTopicId!=null&&!byMainTopicId.trim().equals("")){//按主类别查找
			hql.append(" and g.goodesCategory.goodesCategory.categoryid='").append(byMainTopicId).append("'");
		}
		if(byTermId.trim().equals("1")){//按销量排
			hql.append(" order by g.productsales desc");
		}else if(byTermId.trim().equals("2")){//按价格排
			hql.append(" order by g.productprice");
		}
		return goodsDao.getAllGoods(hql.toString(),page);
	}
	/**
	 * 得到商品的总数量
	 */
	public int getAllGoodsNumber() {
		Long goods_Long=goodsDao.getTotalCount();
		return goods_Long.intValue();
	}
	/**
	 * 查询本周的热销排行榜
	 */
	public List<Goods> getWeekHotGoods(int num) {
		StringBuffer hql=new StringBuffer();
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
		sHql.append("select s.goods.goodsid from OrderItem s where s.createdate between to_date('").append(yearWeekFirst)
		.append("','YYYY-MM-DD HH24:MI:SS') and to_date('").append(yearWeekEnd)
		.append("','YYYY-MM-DD HH24:MI:SS') group by s.goods.goodsid  order by sum(s.goodsnum) desc ");
		List<Object[]> goodsId=goodsDao.getWeekHotSales(sHql.toString(),num);
		Object[] gObjects=new Object[goodsId.size()];
		for(int i=0;i<goodsId.size();i++){
			gObjects[i]=goodsId.get(i);
		}
		if(gObjects.length!=0){
			hql.append("from Goods g where g.goodsid in (:goodsId)");
			return goodsDao.getWeekHotGoods(hql.toString(),gObjects);
		}
		return null;
	}
	/**
	 * 查询购物咨询
	 * @param i 条数
	 * @return
	 */
	public List<Article> getShoppingSys(int i) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Article a where a.articleType.articleType.articletypeid='8a8081a131hjrldd3211faf5f7f60009' order by a.createdate desc");
		return goodsDao.getShoppingSys(hql.toString(),i);
	}
	public List<Goods> gethotGoods(int num) {
		
		return goodsDao.gethotGoods(num);
	}
	public List<Goods> getbestsales(int num) {
		List list=salesDao.getweekssales(num);
		String[] gObjects=new String[list.size()];
		if(list.size()<=0){
			return null;
		}
		for(int i=0;i<list.size();i++){
			gObjects[i]=(String) list.get(i);
		}
		return goodsDao.get(gObjects);
	}
	/**
	 * 得到3个月的销量
	 * @param goodsid
	 * @return
	 */
	public Long getByGoodsIdBuy(String goodsid) {
		StringBuffer hql=new StringBuffer();
		Date date=DateUtil.getCurrentDate().getTime();
		try {
			String str_date=DateUtil.DateAdd(date, "yyyy-MM", -3, Calendar.MONTH);
			hql.append("select sum(s.buynum) from Sales s where s.buydate>= to_date('" )
			.append(str_date).append("','YYYY-MM') and s.goods.goodsid='")
			.append(goodsid).append("' group by s.goods.goodsid");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return goodsDao.getByGoodsIdBuy(hql.toString());
	}
	/**
	 * 根据关键字查找页面
	 * @param searchKey
	 * @param page
	 * @return
	 */
	public Result getBySearchGoods(String searchKey, Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where g.goodsname like '%").append(searchKey).append("%'");
		return goodsDao.getAllGoods(hql.toString(),page);
	}
	/**
	 * 根据主类别得到该类的热销商品10
	 * @param sortId
	 * @param i
	 * @return
	 */
	public List<Goods> getByMainSortGoods(String sortId, int i) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where g.goodesCategory.goodesCategory.categoryid='")
		.append(sortId).append("' and g.ishot=1 order by g.productsales desc");
		return goodsDao.getByMainSortGoods(hql.toString(),i);
	}
	/**
	 * 根据主类别的id得到最新的商品
	 * @param sortId
	 * @param i
	 * @return
	 */
	public List<Goods> getByMainSortNewGoods(String sortId, int i) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where g.goodesCategory.goodesCategory.categoryid='")
		.append(sortId).append("' order by g.createdate desc");
		return goodsDao.getByMainSortGoods(hql.toString(),i);
	}
	public Result getTypeGoods(Page page, String typeId) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where 1=1");
		if(typeId.trim().equals("1")){
			hql.append(" order by g.createdate desc");
		}else if(typeId.trim().equals("2")){
			hql.append(" and g.goodesCategory.categoryid in ('8a8080bf324c3b0e01324c3e2fe40002',")
		.append("'8a8080bf324c3b0e01324c3d9a2c0001')").append(" order by g.createdate desc ");
		}
		return goodsDao.getAllGoods(hql.toString(), page);
	}
	/**
	 * 根据主类别的id或下级类别id得到最新的商品
	 * @param sortId
	 * @param i
	 * @return
	 */
	public Result getTypeGoods(Page page, String goodsMianSrot,String goodsSrot){
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where 1=1"); 
		if(null!=goodsMianSrot.trim()&&!"".equals(goodsMianSrot.trim())){
			if(null!=goodsSrot && !"".equals(goodsSrot.trim())){
				hql.append(" and g.goodesCategory.categoryid='").append(goodsSrot).append("'").append(" order by g.createdate desc "); 
			}else{
				hql.append(" and g.goodesCategory.goodesCategory.categoryid='").append(goodsMianSrot).append("'").append(" order by g.createdate desc ");
			}
		}
		
		return goodsDao.getAllGoods(hql.toString(), page);
	}
	/**
	 * 得到商品的评论
	 * @param goodsId 商品的id
	 * @param page 商品分页
	 * @return
	 */
	public Result getGoodsRats(String goodsId, Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from GoodsRat g where g.good.goodsid='").append(goodsId)
		.append("' order by g.createdate desc");
		return goodsDao.getAllGoods(hql.toString(), page);
	}
	
}
