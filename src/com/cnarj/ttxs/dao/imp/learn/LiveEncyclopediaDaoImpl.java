package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.ILiveEncyclopediaDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
/**
 * 学习频道Dao接口实现类 - 生活百科
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class LiveEncyclopediaDaoImpl extends BaseDaoImpl<ArticleSrc, String> implements
		ILiveEncyclopediaDao {
/*
 * (non-Javadoc)得到3条最新百科
 * @see com.cnarj.ttxs.dao.learn.LiveEncyclopediaDao#get3LEmcyclopedia()
 */
	@SuppressWarnings("unchecked")
	public List<ArticleSrc> getLEmcyclopedia(int num) {
		return this.getSession()
		.createQuery("from ArticleSrc a where a.ispublication=1	and a.articleType.articletypeid='8a80818c31bb7cc50131bb7fbde70002'  order by createdate desc")
		.setMaxResults(num).list();
	}

}
