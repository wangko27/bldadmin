package com.cnarj.ttxs.admin.service.imp.recommend;

import com.cnarj.ttxs.admin.service.recommend.IArticleService;
import com.cnarj.ttxs.dao.recemmend.IArticleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-6
 * Time: P.M.3:54
 * 后台推荐文章service实现类
 */
public class ArticleServiceImpl  extends BaseServiceImpl<Article, String> implements IArticleService {
     private IArticleDao articleDao;

    @Override
    public Article findById(String articleId) {
        StringBuffer hql =new StringBuffer();
        if(articleId != null && !"".equals(articleId)){
            hql.append("from Article where id = '").append(articleId).append("'");
            return articleDao.findById(hql.toString());
        }
        return null;
    }

    @Override
    public Result findAll(Page page) {
        StringBuffer hql =new StringBuffer();
        hql.append("from Article where 1=1 order by orderList desc");
        return articleDao.findAll(hql.toString(),page);
    }

    @Override
    public Article findOrderByType(Integer orderList, Integer type) {
        StringBuffer hql =new StringBuffer();
        hql.append("from Article where type='").append(type).append("'");
        hql.append(" and orderList =").append(orderList);
        return articleDao.findByTypeAndOrder(hql.toString());
    }

    public IArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
