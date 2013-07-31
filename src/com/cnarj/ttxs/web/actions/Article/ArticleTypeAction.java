package com.cnarj.ttxs.web.actions.Article;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.cnarj.ttxs.service.Article.IAnswerService;
import com.cnarj.ttxs.service.Article.IArticleHandleRecService;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.service.Article.IQuestionService;

import com.cnarj.ttxs.comm.ArticleHandleStaticNum;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.comm.ssStaticNum;

import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.comm.*;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.pojo.user.Member;
/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class ArticleTypeAction extends PageAction{
	
	public IArticleTypeService articleTypeService;
	
	public IArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(IArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	/**
	 * 获得所以资讯频道下级栏目
	 * 
	 * @copyright 湖南爱瑞杰科技发展股份有限公司
	 * @author sly
	 * @version 1.0
	 * @since 2011年7月6日11:26:36
	 */	
	public String listparentType(){
		try {
			List<ArticleType>	listparenttype=articleTypeService.getList("articleType.articletypeid", "8a80818c31bb7cc50131bb7fbde70001");
			setAttribute("articletypelist", listparenttype);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}
}
	