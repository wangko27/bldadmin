package com.cnarj.ttxs.admin.actions.recommend;


import com.cnarj.ttxs.admin.service.recommend.IArticleService;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.ArticleType;
import com.cnarj.ttxs.web.actions.base.PageAction;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-6
 * Time: p.m.3:46
 * 后台推荐文章
 */
public class ArticleAction extends PageAction{
    private Article article;
    private String articleId;
    private IArticleService articleService;
    private ArticleType articleType;
    private Integer orderList;
    private Integer type;



    //添加文章
    public String addArticle(){
        article.setCreateTime(new Date());
        articleService.save(article);
        return SUCCESS;
    }

    //显示文章列表
    public String showArticleList(){
        page.setEveryPage(12);
        if (gotoPage == null || gotoPage.trim().equals("")
                || gotoPage.length() == 0) {
            gotoPage = "1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result = articleService.findAll(page);
        return "success";
    }


    //删除文章
    public String deleteArticle(){
        article = articleService.findById(articleId);
        if(article != null){
            articleService.delete(article);
        }
        return "success";

    }

    public String findArticleById(){
        article = articleService.findById(articleId);
        return SUCCESS;
    }

    public String updateArticle(){
        article.setLastModifyTime(new Date());

        articleService.update(article);
        return SUCCESS;
    }

    public String checkArticleOrder(){
        article = articleService.findOrderByType(orderList,type);
        Integer flag =0;
        if(article!=null ){
            flag=1;
        }
        StringBuffer json=new StringBuffer();
        json.append("{\"flag\":\"")
                .append(flag)
                .append("\"")
                .append("}");
        this.ajaxJson(json.toString());

        return null;
    }





    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public IArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Integer getOrderList() {
        return orderList;
    }

    public void setOrderList(Integer orderList) {
        this.orderList = orderList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
