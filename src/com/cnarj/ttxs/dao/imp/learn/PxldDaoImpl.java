package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IPxldDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 学习频道Dao接口实现类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class PxldDaoImpl extends BaseDaoImpl<ArticleSrc, String> implements
		IPxldDao {

	@SuppressWarnings("unchecked")
	public List listArticleByRecommend(int shownum) throws Exception {
		StringBuffer sbHql = new StringBuffer(
				"from ArticleSrc a where a.articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40004' and a.isrecommend=1 order by createdate desc");
		return this.getSession().createQuery(sbHql.toString()).setMaxResults(
				shownum).list();
	}

}
