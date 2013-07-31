package com.cnarj.ttxs.dao.imp.recemmend;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.recemmend.IRecommendDao;
import com.cnarj.ttxs.pojo.recommend.GoodsRecommend;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-26
 * Time: P.M.11:30
 *  商品推荐dao 实现类
 */
public class RecommendDaoImpl extends BaseDaoImpl<GoodsRecommend,String> implements IRecommendDao {
    @Override
    public Object findById(String hql) {
        return this.getSession().createQuery(hql).uniqueResult();
    }
}
