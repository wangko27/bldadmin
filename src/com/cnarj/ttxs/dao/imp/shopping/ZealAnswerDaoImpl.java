package com.cnarj.ttxs.dao.imp.shopping;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.shopping.IGoodsDao;
import com.cnarj.ttxs.dao.shopping.IZealAnswerDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.ZealAnswer;

/**
 * 商品模块Dao实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class ZealAnswerDaoImpl extends BaseDaoImpl<ZealAnswer, String> implements IZealAnswerDao {
	public Long getTotalCount(String isnull) {
		String hql = "select count(*) from ZealAnswer where  answer "+isnull+"";
		
		return (Long) getSession().createQuery(hql).uniqueResult();
	}

	public Result getQuestionBystaues(Page page, String isnull) {
		// TODO Auto-generated method stub
		StringBuffer sbHql = new StringBuffer("from ZealAnswer  where  answer ").append(isnull).append(" order by modifydate desc");		
		return this.findByPager(page, sbHql.toString());
	}
	@SuppressWarnings("unchecked")
	public Result getQuestionRI(Page page, String questiontitle){
		String hql ="from ZealAnswer  where questiontitle like '%"+questiontitle.trim()+"%' order by modifydate desc";
			return this.findByPager(page, hql);
	}
	public Long getTotalCountBysartch(String questiontitle) {
		String hql = "select count(*) from ZealAnswer where questiontitle like '%"+questiontitle.trim()+"%'";
		return (Long) getSession().createQuery(hql).uniqueResult();
	}
}
