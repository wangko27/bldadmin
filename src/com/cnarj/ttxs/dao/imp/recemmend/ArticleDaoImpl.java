package com.cnarj.ttxs.dao.imp.recemmend;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.recemmend.IArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-6
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class ArticleDaoImpl extends BaseDaoImpl<Article,String> implements IArticleDao {
    @Override
    public Article findById(String s) {
        return (Article)this.getSession().createQuery(s).uniqueResult();
    }

    @Override
    public Result findAll(String s, Page page) {
        return this.findByPager(page,s);
    }

    @Override
    public Article findByTypeAndOrder(String s) {
        return (Article)this.getSession().createQuery(s).uniqueResult();
    }
}
