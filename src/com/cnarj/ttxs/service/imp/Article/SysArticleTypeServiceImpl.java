package com.cnarj.ttxs.service.imp.Article;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.servlet.ServletContext;
import java.io.BufferedWriter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.freemarker.FreemarkerManager;
import freemarker.template.Configuration;
import freemarker.template.Template;

import com.cnarj.ttxs.dao.Article.IArticleDao;
import com.cnarj.ttxs.dao.Article.IQuestionTypeDao;
import com.cnarj.ttxs.dao.Article.ISysArticleDao;
import com.cnarj.ttxs.dao.Article.ISysArticleTypeDao;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleTypeService;



/**
 * Service实现类 - Service实现类测试类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日14:39:38
 */
public class SysArticleTypeServiceImpl extends BaseServiceImpl<SysArticleType,String> implements ISysArticleTypeService {
	public void setBaseDao(ISysArticleTypeDao sysArticleTypeDao) {
		super.setBaseDao(sysArticleTypeDao);
	}
	private ISysArticleTypeDao sysArticleTypeDao;
	public ISysArticleTypeDao getSysArticleTypeDao() {
		return sysArticleTypeDao;
	}
	public void setSysArticleTypeDao(ISysArticleTypeDao sysArticleTypeDao) {
		this.sysArticleTypeDao = sysArticleTypeDao;
	}
	
	public List<SysArticleType> listBychildtype(){
		return sysArticleTypeDao.listBychildtype();
	}
}