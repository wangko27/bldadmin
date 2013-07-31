package com.cnarj.ttxs.web.actions.Article;
import java.util.Date;
import java.util.Iterator;
import java.util.List;




import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.service.Article.IAnswerService;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.service.Article.IQuestionService;
import com.cnarj.ttxs.service.Article.IQuestionTypeService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
import com.cnarj.ttxs.service.imp.Article.QuestionTypeServiceImpl;
import com.cnarj.ttxs.service.learn.IReadSysInfoService;

import com.cnarj.ttxs.comm.CommStaticNum;

import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.comm.*;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.info.QuestionType;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class IndexAction extends PageAction{
	private IArticleService articleService;
	private IQuestionService questionService;
	private IAnswerService answerServive;
	private IArticleTypeService articleTypeService;
	private ISysArticleService sysarticleService;
	private IQuestionTypeService questionTypeService;
	private ISysArticleTypeService sysArticleTypeService;
	
	private List<ArticleSrc> articleList;
	//最新置顶新闻
	private List<ArticleSrc> articleListTN;
	private ArticleSrc TNarticleSrcTN;
	private List<ArticleSrc> articleListNN;
	//系统公告
	private List<Article> articleListNT;
	//最新发布置顶图片
	private List<ArticleSrc> articleListTP;
	private ArticleSrc articleSrcTP;
	//营养保健
	private List<ArticleSrc> articleListTypeN;
	private ArticleSrc articleSrcN;
	//好好生活
	private List<ArticleSrc> articleListTypeL;
	private ArticleSrc articleSrcL;
	//成长教育
	private List<ArticleSrc> articleListTypeG;
	private List<ArticleSrc> articleListTypeGP;
	
	private ArticleSrc articleSrcG;
	//生理健康
	private List<ArticleSrc> articleListTypeP;
	private ArticleSrc articleSrcP;
	//教育看点
	private List<ArticleSrc> articleListTypeE;
	
	//教育看点的图片
	public  List<ArticleSrc> articleListTypeEP;
	//最新问题
	private List<Question> ListtopQuestion;	
	private List<Question> ListHotQuestion;
	private Question question;
	private ArticleSrc articleSrc;
	private ArticleType articleType;
	private List<ArticleType> articleTypeList;
	private String id;
	private List<Answer> answerlist;
	private List<QuestionType> questionTypeList;
	
	public List<QuestionType> getQuestionTypeList() {
		return questionTypeList;
	}
	public void setQuestionTypeList(List<QuestionType> questionTypeList) {
		this.questionTypeList = questionTypeList;
	}
	public List<Question> getListHotQuestion() {
		return ListHotQuestion;
	}
	public void setListHotQuestion(List<Question> listHotQuestion) {
		ListHotQuestion = listHotQuestion;
	}
	public List<ArticleSrc> getArticleList() {
		return articleList;
	}
	public List<ArticleType> getArticleTypeList() {
		return articleTypeList;
	}
	public List<Answer> getAnswerlist() {
		return answerlist;
	}
	public IArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public IAnswerService getAnswerServive() {
		return answerServive;
	}
	public void setAnswerServive(IAnswerService answerServive) {
		this.answerServive = answerServive;
	}
	public IArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}
	public void setArticleTypeService(IArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public ArticleSrc getArticleSrc() {
		return articleSrc;
	}
	public void setArticleSrc(ArticleSrc articleSrc) {
		this.articleSrc = articleSrc;
	}
	public ArticleType getArticleType() {
		return articleType;
	}
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setArticleList(List<ArticleSrc> articleList) {
		this.articleList = articleList;
	}

	public List<Question> getListtopQuestion() {
		return ListtopQuestion;
	}

	public void setListtopQuestion(List<Question> listtopQuestion) {
		ListtopQuestion = listtopQuestion;
	}
	public void setArticleTypeList(List<ArticleType> articleTypeList) {
		this.articleTypeList = articleTypeList;
	}
	public void setAnswerlist(List<Answer> answerlist) {
		this.answerlist = answerlist;
	}	
	public List<ArticleSrc> getArticleListTypeN() {
		return articleListTypeN;
	}
	public List<ArticleSrc> getArticleListTypeL() {
		return articleListTypeL;
	}
	public List<ArticleSrc> getArticleListTypeG() {
		return articleListTypeG;
	}
	public List<ArticleSrc> getArticleListTypeP() {
		return articleListTypeP;
	}
	public void setArticleListTypeN(List<ArticleSrc> articleListTypeN) {
		this.articleListTypeN = articleListTypeN;
	}
	public void setArticleListTypeL(List<ArticleSrc> articleListTypeL) {
		this.articleListTypeL = articleListTypeL;
	}
	public void setArticleListTypeG(List<ArticleSrc> articleListTypeG) {
		this.articleListTypeG = articleListTypeG;
	}
	public void setArticleListTypeP(List<ArticleSrc> articleListTypeP) {
		this.articleListTypeP = articleListTypeP;
	}	
	
	public List<ArticleSrc> getArticleListTypeE() {
		return articleListTypeE;
	}
	public void setArticleListTypeE(List<ArticleSrc> articleListTypeE) {
		this.articleListTypeE = articleListTypeE;
	}
	public List<ArticleSrc> getArticleListTN() {
		return articleListTN;
	}
	public void setArticleListTN(List<ArticleSrc> articleListTN) {
		this.articleListTN = articleListTN;
	}
	public List<ArticleSrc> getArticleListTP() {
		return articleListTP;
	}
	public void setArticleListTP(List<ArticleSrc> articleListTP) {
		this.articleListTP = articleListTP;
	}
	
	public List<ArticleSrc> getArticleListTypeEP() {
		return articleListTypeEP;
	}
	public void setArticleListTypeEP(List<ArticleSrc> articleListTypeEP) {
		this.articleListTypeEP = articleListTypeEP;
	}
	public ArticleSrc getTNarticleSrcTN() {
		return TNarticleSrcTN;
	}
	public void setTNarticleSrcTN(ArticleSrc narticleSrcTN) {
		TNarticleSrcTN = narticleSrcTN;
	}
	public ArticleSrc getArticleSrcTP() {
		return articleSrcTP;
	}
	public void setArticleSrcTP(ArticleSrc articleSrcTP) {
		this.articleSrcTP = articleSrcTP;
	}
	public ArticleSrc getArticleSrcN() {
		return articleSrcN;
	}
	public void setArticleSrcN(ArticleSrc articleSrcN) {
		this.articleSrcN = articleSrcN;
	}
	public ArticleSrc getArticleSrcL() {
		return articleSrcL;
	}
	public void setArticleSrcL(ArticleSrc articleSrcL) {
		this.articleSrcL = articleSrcL;
	}
	public ArticleSrc getArticleSrcG() {
		return articleSrcG;
	}
	public void setArticleSrcG(ArticleSrc articleSrcG) {
		this.articleSrcG = articleSrcG;
	}
	public ArticleSrc getArticleSrcP() {
		return articleSrcP;
	}
	public void setArticleSrcP(ArticleSrc articleSrcP) {
		this.articleSrcP = articleSrcP;
	}
	public List<ArticleSrc> getArticleListTypeGP() {
		return articleListTypeGP;
	}
	public void setArticleListTypeGP(List<ArticleSrc> articleListTypeGP) {
		this.articleListTypeGP = articleListTypeGP;
	}
	public List<ArticleSrc> getArticleListNN() {
		return articleListNN;
	}
	public void setArticleListNN(List<ArticleSrc> articleListNN) {
		this.articleListNN = articleListNN;
	}
	
	
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}
	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
	}
	public List<Article> getArticleListNT() {
		return articleListNT;
	}
	public void setArticleListNT(List<Article> articleListNT) {
		this.articleListNT = articleListNT;
	}
	public String Show_News_Index(){		
		//获得最新新闻
		articleListTN=articleService.getShareArticleSrc("最新新闻", 6);
		for(int i=0;i<articleListTN.size();i++){
			articleListTN.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListTN.get(i).getArticlesrccontent(), 100));
		}
		//获得新闻图片
		articleListTP=articleService.getShareArticleSrc("图片新闻",6);		
		//获得教育看点新闻
		articleListTypeE=articleService.getEducationByhql("articletypeid", "8a80818c31bb7cc50131bb805c4a0007", 12);
		//获得系统公告
		articleListNT=sysarticleService.getNewsNotice(5);
		//获得百科教育新闻
		articleListNN=articleService.getShareArticleSrc( "成长教育", "1", 12);
		for(int i=0;i<articleListNN.size();i++){
			articleListNN.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListNN.get(i).getArticlesrccontent(), 80));
		}
		//成长教育新闻
		articleListTypeG=articleService.getShareArticleSrc("成长教育","0", 6);
		for(int i=0;i<articleListTypeG.size();i++){
			articleListTypeG.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListTypeG.get(i).getArticlesrccontent(), 60));
		}
		//营养保健新闻
		articleListTypeN=articleService.getShareArticleSrc( "营养保健","1", 5);
		for(int i=0;i<articleListTypeN.size();i++){
			articleListTypeN.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListTypeN.get(i).getArticlesrccontent(), 60));
		}
		//好好生活新闻
		articleListTypeL=articleService.getShareArticleSrc( "好好生活","1",  5);
		for(int i=0;i<articleListTypeL.size();i++){
			articleListTypeL.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListTypeL.get(i).getArticlesrccontent(), 60));
		}
		//生理健康新闻
		articleListTypeP=articleService.getShareArticleSrc("心理健康","1", 6);
		 //热门答疑
		 ListHotQuestion=questionService.getHOTQuestion("visittime", "answernum", "begindate", 10);
		 //第一条最新回答
		 answerlist=answerServive.getTopanswer("answerdate", 1);
		 Iterator<Answer> it=answerlist.iterator();
		 Answer answer = null;
		 String questionid=null;
		 while (it.hasNext()){
			 answer=it.next(); 
			 questionid=answer.getQuestion().getQuestionid();
		 }
		//最新问答
		 ListtopQuestion = questionService.getFrushQuestion("begindate", "desc", 10,questionid);
		return "success";
	}
	/*
	 * 资讯站内搜索
	 */
	@SuppressWarnings("unchecked")
	public String search(){
		try {
			String type=getParameter("Type");
			String topName=getParameter("topName");
			System.out.println(type);
			System.out.println(topName);
			LogUtil.logger.info("记录日志信息!");
			// 设置每页查询的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
			//设置排序的字段
			page.setOrderBy("modifydate");
			//设置排序方法
			page.setOrderType(OrderType.desc);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			//教育看点
			if(type.equals("8a80818c31bb7cc50131bb805c4a0007")&&!topName.trim().equals("")){
				//获得页面总数
				Long totalRecords = articleService.searchArticle("articletypeid", type, topName);
				page= PageUtil.createPage(page, totalRecords.intValue()); 
				result = articleService.searchArticle("articletypeid", type, topName, page);
				if(result.getContent().size()==0){
					this.setAttribute("Isempty", "yes");
				}
				return "education";
			}
			//答疑小博士
			else if(type.equals("dayi")){
				questionTypeList=questionTypeService.getAll();
				//获得页面总数
				Long totalRecords = questionService.searchQuestion(topName);
				page= PageUtil.createPage(page, totalRecords.intValue());
				result = questionService.searchQuestion(topName, page);
				if(result.getContent().size()==0||result==null){
					 this.setAttribute("Isempty", "yes");
				}
				else{
					this.setAttribute("Isempty", "no");
				}						
				return "dayilist";
			}
			//生活百科			
			else if(type.equals("8a80818c31bb7cc50131bb7fbde70002")||type.equals("8a8081a131cd5fcd0131cd6a83e40005")){
				articleTypeList=articleTypeService.getList("articleType.articletypeid", type);
				this.setAttribute("articleType", articleTypeList);
				//获得页面总数
				Long totalRecords = articleService.searchArticle("articleType.articletypeid", type, topName);
				page= PageUtil.createPage(page, totalRecords.intValue()); 
				result = articleService.searchArticle("articleType.articletypeid", type, topName, page);
				if(result.getContent().size()==0){
					this.setAttribute("Isempty", "yes");
				}
				if(type.equals("8a80818c31bb7cc50131bb7fbde70002")){
					return "baikelist";
				}else{
					return "sysarticlelist";
				}
			}else{
				return "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	public IQuestionTypeService getQuestionTypeService() {
		return questionTypeService;
	}
	public void setQuestionTypeService(IQuestionTypeService questionTypeService) {
		this.questionTypeService = questionTypeService;
	}
	public ISysArticleTypeService getSysArticleTypeService() {
		return sysArticleTypeService;
	}
	public void setSysArticleTypeService(
			ISysArticleTypeService sysArticleTypeService) {
		this.sysArticleTypeService = sysArticleTypeService;
	}
}
	