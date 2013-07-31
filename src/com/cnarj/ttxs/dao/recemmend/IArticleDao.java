package com.cnarj.ttxs.dao.recemmend;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-6
 * Time: p.m.3:56
 *
 */
public interface IArticleDao extends IBaseDao<Article,String> {
    public Article findById(String s);

    public Result findAll(String s, Page page);

    public Article findByTypeAndOrder(String s);
}
