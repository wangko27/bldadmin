package com.cnarj.ttxs.admin.service.recommend;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-6
 * Time: p.m.3:51
 * 后台推荐文章service接口
 */
public interface IArticleService extends IBaseService<Article, String> {
    public Article findById(String articleId);

    public Result findAll(Page page);

    public Article findOrderByType(Integer orderList, Integer type);
}
