package com.cnarj.ttxs.dao.recemmend;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.recommend.GoodsRecommend;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-26
 * Time: P.M.11:28
 *
 */
public interface IRecommendDao extends IBaseDao<GoodsRecommend,String> {

    public Object findById(String hql);
}
