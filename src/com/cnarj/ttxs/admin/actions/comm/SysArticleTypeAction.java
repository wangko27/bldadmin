package com.cnarj.ttxs.admin.actions.comm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 学习频道后台Action类 - 文章类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public class SysArticleTypeAction extends PageAction implements
		ModelDriven<SysArticleType> {
	private ISysArticleService  sysarticleService;
	private ISysArticleTypeService sysArticleTypeService;	
	SysArticleType sysArticleType=new SysArticleType();
	
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}

	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
	}

	public ISysArticleTypeService getSysArticleTypeService() {
		return sysArticleTypeService;
	}

	public void setSysArticleTypeService(
			ISysArticleTypeService sysArticleTypeService) {
		this.sysArticleTypeService = sysArticleTypeService;
	}

	public SysArticleType getSysArticleType() {
		return sysArticleType;
	}

	public void setSysArticleType(SysArticleType sysArticleType) {
		this.sysArticleType = sysArticleType;
	}

	public SysArticleType getModel() {
	
		return sysArticleType;
	}
	
	
	/**
	 * 添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String addPage() {
		try {
			// 查询所有类别
			List<SysArticleType> ParentTypes=sysArticleTypeService.listBychildtype();
			this.setAttribute("ParentTypes", ParentTypes);
			return "addPage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() {
		try {
			sysArticleType.setCreatedate(new Date());
			sysArticleType.setModifydate(new Date());
			String level = HttpUtil.getParameter("level");
			//获得修改后的上级ID
			String articletypeidChild = HttpUtil.getParameter("articletypeid" + level);
			SysArticleType ArticleType = sysArticleTypeService.get(articletypeidChild);	
			sysArticleType.setArticleType(ArticleType);
			sysArticleTypeService.save(sysArticleType);
			this.addActionMessage("添加成功！");
			return addPage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 系统类别列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String list() {
		try {
			//查询所有上级类别
			List<SysArticleType> ParentTypes=sysArticleTypeService.getList("from SysArticleType  a where a.articleType is null");
			setAttribute("ParentTypes", ParentTypes);
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			// 总数目
			Long totalRecords = sysArticleTypeService.getTotalCount();

			// 创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());

			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(SysArticleType.class);
			detachedCriteria.addOrder(Order.asc("articlesort"));
			
			result = sysArticleTypeService.findByPager(page, detachedCriteria);
			setAttribute("list_articleType", result.getContent());
			return "list";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	/*
	 * 根据上级类别检索下级类别
	 * 
	 */
	public 	String searchCildrentype(){
		try {
			String articletypeid = getParameter("articletypeid");
			String level =HttpUtil.getParameter("level");
			StringBuffer sbOption = new StringBuffer();
			int level1=Integer.parseInt(level);
			//根据上级类别获得系统文章下级类别
			if(!articletypeid.trim().equals("")){
				List<SysArticleType> childTypes=sysArticleTypeService.getList("articleType.articletypeid", articletypeid);
				if(childTypes.size()>0){
					sbOption.append("<select name=\"articletypeid"+(level1+1)+"\" id=\"articletypeid"+(level1+1)+"\"");
					sbOption.append("onchange=\"typeChange(this.value,"+(level1+1)+")\">");
					sbOption.append("<option value=\"\">全部</option>");
					for (SysArticleType at : childTypes) {
						sbOption.append("<option value=\"" + at.getArticletypeid()+ "\">");
						sbOption.append(at.getArticletypename());
						sbOption.append("</option>");
					}
					sbOption.append("</select>");
					sbOption.append("<span id=\"spantype"+(level1+1)+"\"></span>");
				}
			}
			getResponse().getWriter().print(sbOption.toString());
			getResponse().getWriter().close();	
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return "list";
		}
	}
	/*
	 * 根据上级类别查询下级类别
	 * 
	 */
	public String listCildrentype(){
		try {
			//查询所有上级类别
			List<SysArticleType> ParentTypes=sysArticleTypeService.getList("from SysArticleType  a where a.articleType is null");
			setAttribute("ParentTypes", ParentTypes);
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			SysArticleType	ArticleType=sysArticleTypeService.get(sysArticleType.getArticletypeid());
			page.setCurrentPage(Integer.parseInt(gotoPage));
			// 总数目
			Long totalRecords = sysArticleTypeService.getTotalCount("articleType.articletypeid",ArticleType.getArticletypeid());

			// 创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());
			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(SysArticleType.class);
			detachedCriteria.addOrder(Order.asc("articlesort"));
			detachedCriteria.add(Restrictions.eq("articleType", ArticleType));
			result = sysArticleTypeService.findByPager(page, detachedCriteria);
			setAttribute("list_articleType", result.getContent());
			if(result.getContent().size()==0){
				addActionMessage("该类别下暂无下级类别");
			}
			return "list";
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("list_articleType", null);
			return "list";
		}
	}
	/*
	 * 根据上级类别查询下级类别
	 * 
	 */
	public String listCildrentype2(){
		try {
			//查询所有上级类别
			List<SysArticleType> ParentTypes=sysArticleTypeService.getList("from SysArticleType  a where a.articleType is null");
			setAttribute("ParentTypes", ParentTypes);
			// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			String level = HttpUtil.getParameter("level");
			int level1=Integer.parseInt(level);
			if(level1==0){
				//获得修改后的上级ID
				String articletypeidChild = HttpUtil.getParameter("articletypeid" + level1);
				if(null==articletypeidChild||articletypeidChild.trim().equals("")){
				return	list();
				}
				SysArticleType sysArticleType = sysArticleTypeService.get(articletypeidChild);
				page = PageUtil.createPage(page, 1);
				setAttribute("list_articleType", sysArticleType);	
			}else{
				//获得修改后的上级ID
				String articletypeidChild = HttpUtil.getParameter("articletypeid" + (level1-1));
				SysArticleType sysArticleType = sysArticleTypeService.get(articletypeidChild);
				// 总数目
				Long totalRecords = sysArticleTypeService.getTotalCount("articleType.articletypeid",sysArticleType.getArticletypeid());
				// 创建页面
				page = PageUtil.createPage(page, totalRecords.intValue());
				
				// 根据位置排序
				DetachedCriteria detachedCriteria = DetachedCriteria
						.forClass(SysArticleType.class);
				detachedCriteria.addOrder(Order.asc("articlesort"));
				detachedCriteria.add(Restrictions.eq("articleType", sysArticleType));
				result = sysArticleTypeService.findByPager(page, detachedCriteria);
				setAttribute("list_articleType", result.getContent());
			}
			return "list";
		} catch (Exception e) {
			// TODO: handle exception
			setAttribute("list_articleType", null);
			return "list";
		}
	}
	/**
	 * 修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePage() {
		try {
			SysArticleType articleTypeNew = sysArticleTypeService.get(sysArticleType.getArticletypeid());
			if (null != articleTypeNew) {
				setAttribute("articleType", articleTypeNew);
			}
			return "updatePage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() {
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		try {
			SysArticleType newArticleType= sysArticleTypeService.get(sysArticleType.getArticletypeid());
			newArticleType.setModifydate(now);
			newArticleType.setArticletypename(sysArticleType.getArticletypename());
			newArticleType.setArticlesort(sysArticleType.getArticlesort());
			sysArticleTypeService.update(newArticleType);
			this.clearMessages();
			this.addActionMessage("修改成功！");
			return updatePage();
		} catch (Exception e) {
			this.addActionMessage("修改失败！");
			return updatePage();
		}
	}
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		try {
			// 判断该类型下面是否有文章
			boolean result = sysarticleService.isExist("articleType.articletypeid", sysArticleType.getArticletypeid());
			if (result) {
				this.addActionMessage("该类别下还有文章，请先删除！");
			} else {
				sysArticleTypeService.delete(sysArticleType.getArticletypeid());
				this.addActionMessage("删除成功！");
			}
			return list();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	public String deletefromSystype(){
		return "success";
	}
}
