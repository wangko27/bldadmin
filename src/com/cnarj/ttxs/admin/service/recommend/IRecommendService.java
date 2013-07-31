package com.cnarj.ttxs.admin.service.recommend;

import com.cnarj.ttxs.pojo.recommend.GoodsRecommend;
import com.cnarj.ttxs.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-25
 * Time: P.M.4:07
 * 推荐类接口
 */
public interface IRecommendService extends IBaseService<GoodsRecommend, String> {

    public GoodsRecommend findById(String recommendId);
}
