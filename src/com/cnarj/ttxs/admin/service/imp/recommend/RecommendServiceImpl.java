package com.cnarj.ttxs.admin.service.imp.recommend;

import com.cnarj.ttxs.admin.service.recommend.IRecommendService;
import com.cnarj.ttxs.dao.recemmend.IRecommendDao;
import com.cnarj.ttxs.pojo.recommend.GoodsRecommend;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-25
 * Time: P.M.4:10
 * 推荐接口实现类
 */
public class RecommendServiceImpl extends BaseServiceImpl<GoodsRecommend, String> implements IRecommendService {
    private IRecommendDao recommendDao;

    @Override
    public GoodsRecommend findById(String recommendId) {
        StringBuffer hql = new StringBuffer();
        hql.append("from GoodsRecommend where 1=1");
        if(recommendId != null && !"".equals(recommendId.trim())){
            hql.append("and recommendId ='").append(recommendId).append("'");
        }
        return (GoodsRecommend)recommendDao.findById(hql.toString());
    }



    public IRecommendDao getRecommendDao() {
        return recommendDao;
    }

    public void setRecommendDao(IRecommendDao recommendDao) {
        this.recommendDao = recommendDao;
    }
}
