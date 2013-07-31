//package com.cnarj.ttxs.admin.actions.comm;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//import com.cnarj.ttxs.comm.CommStaticNum;
//import com.cnarj.ttxs.pojo.sys.Article;
//import com.cnarj.ttxs.pojo.sys.SysArticleHandleRec;
//import com.cnarj.ttxs.pojo.sys.SysArticleType;
//import com.cnarj.ttxs.service.Article.ISysArticleHandleService;
//import com.cnarj.ttxs.service.Article.ISysArticleService;
//import com.cnarj.ttxs.service.Article.ISysArticleTypeService;
//import com.cnarj.ttxs.util.HttpUtil;
//import com.cnarj.ttxs.util.Pubfun;
//import com.cnarj.ttxs.web.actions.base.PageAction;
//import com.opensymphony.xwork2.ModelDriven;
///*
// * 系统文章管理
// *
// * @copyright 湖南爱瑞杰科技发展股份有限公司
// * @author 刘其
// * @version 1.0
// * @since 2011年8月17日
// */
//public class SysArticleAction extends PageAction implements
//	ModelDriven<Article> {
//	Article article=new Article();
//	private ISysArticleService  sysarticleService;
//	private ISysArticleHandleService sysarticleHandleService;
//
//	private ISysArticleTypeService sysArticleTypeService;
//	SysArticleType sysArticleType = new SysArticleType();
//	File cover;// 封面
//	String coverFileName;
//	String coverContentType;
//	public Article getArticle() {
//		return article;
//	}
//	public void setArticle(Article article) {
//		this.article = article;
//	}
//	public ISysArticleService getSysarticleService() {
//		return sysarticleService;
//	}
//	public void setSysarticleService(ISysArticleService sysarticleService) {
//		this.sysarticleService = sysarticleService;
//	}
//	public ISysArticleHandleService getSysarticleHandleService() {
//		return sysarticleHandleService;
//	}
//	public void setSysarticleHandleService(
//			ISysArticleHandleService sysarticleHandleService) {
//		this.sysarticleHandleService = sysarticleHandleService;
//	}
//	public ISysArticleTypeService getSysArticleTypeService() {
//		return sysArticleTypeService;
//	}
//	public void setSysArticleTypeService(
//			ISysArticleTypeService sysArticleTypeService) {
//		this.sysArticleTypeService = sysArticleTypeService;
//	}
//	public SysArticleType getSysArticleType() {
//		return sysArticleType;
//	}
//	public void setSysArticleType(SysArticleType sysArticleType) {
//		this.sysArticleType = sysArticleType;
//	}
//	public File getCover() {
//		return cover;
//	}
//	public void setCover(File cover) {
//		this.cover = cover;
//	}
//	public String getCoverFileName() {
//		return coverFileName;
//	}
//	public void setCoverFileName(String coverFileName) {
//		this.coverFileName = coverFileName;
//	}
//	public String getCoverContentType() {
//		return coverContentType;
//	}
//	public void setCoverContentType(String coverContentType) {
//		this.coverContentType = coverContentType;
//	}
//	public Article getModel() {
//		return article;
//	}
//
//	/**
//	 * 添加页面
//	 *
//	 * @return
//	 * @throws Exception
//	 */
//	public String addPage() {
//		//根据上级类别获得系统文章下级类别
//		List<SysArticleType> ParentTypes=sysArticleTypeService.listBychildtype();
//		this.setAttribute("ParentTypes", ParentTypes);
//		return "addPage";
//	}
//	/**
//	 * 添加系統文章
//	 *
//	 * @return
//	 */
//	public String addSysArticle() {
//		try {
//			article.setCreatedate(new Date());// 创建日期
//			article.setModifydate(new Date());// 修改日期
//			article.setCollectionnum(new Long(0));// 收藏次数
//			article.setSharenum(new Long(0));// 分享次数
//			String newContent = Pubfun.contentHandle(article.getArticlecontent());
//			String level = HttpUtil.getParameter("level");
//			//获得修改后的上级ID
//			String articletypeidChild = HttpUtil.getParameter("articletypeid" + level);
//			SysArticleType sysArticleType = sysArticleTypeService.get(articletypeidChild);
//			article.setArticleType(sysArticleType);
//			article.setArticlecontent(newContent);
//			int pageCount = newContent.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
//			System.out.println(pageCount);
//			article.setPagecount(new Long(pageCount));// 文章页数
//			sysarticleService.save(article);
//			this.addActionMessage("添加成功！");
//			return addPage();
//		} catch (Exception e) {
//			getRequest().setAttribute("exception", e.toString());
//			e.printStackTrace();
//			return ERROR;
//		}
//	}
//		/**
//		 * 系統文章修改页面
//		 *
//		 * @return
//		 */
//		public String updatePage(){
//			Article articleNew=sysarticleService.get(article.getArticleid());
//			articleNew.setArticlecontent(Pubfun.contentHandleUpdate(articleNew.getArticlecontent()));
//			setAttribute("article", articleNew);
//			return "updatePage";
//		}
//		/**
//		 * 修改
//		 *
//		 * @return
//		 * @throws Exception
//		 */
//		public String update() {
//			try {
//				//获得原数据
//				Article articleNew = sysarticleService.get(article.getArticleid());
//				String level = HttpUtil.getParameter("level");
//				//获得修改后的上级ID
//				String articletypeidChild = HttpUtil.getParameter("articletypeid" + level);
//				SysArticleType sysArticleType = sysArticleTypeService.get(articletypeidChild);
//				articleNew.setArticleType(sysArticleType);
//				// 重新设置内容
//				String newContent =Pubfun.contentHandle(article.getArticlecontent());
//				articleNew.setArticlecontent(newContent);
//				//计算新内蓉页数
//				int pageCount = newContent.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>").length;// 页数
//				articleNew.setArticletitle(article.getArticletitle());
//				articleNew.setPagecount(new Long(pageCount));// 文章页数
//				articleNew.setPagekeywords(article.getPagekeywords());// 修改关键字
//				articleNew.setIsrecommend(article.getIsrecommend());// 修改是否推荐书籍
//				articleNew.setIspublication(article.getIspublication());// 修改是否发布
//				articleNew.setIstop(article.getIstop());// 修改是否置顶
//				articleNew.setPagedescript(article.getPagedescript());// 修改内容简介
//				articleNew.setModifydate(new Date());//修改时间
//				article.setCollectionnum(article.getCollectionnum());// 收藏次数
//				article.setSharenum(article.getSharenum());// 分享次数
//				sysarticleService.update(articleNew);
//				this.addActionMessage("修改成功！");
//				return updatePage();
//			} catch (Exception e) {
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//		/**
//		 * 删除
//		 *
//		 * @return
//		 */
//		public String delete() {
//			try {
//				String id=article.getArticleid();
//				List<SysArticleHandleRec> list= sysarticleHandleService.getList("article.articleid", id);
//				String ids[]=new String[list.size()];
//				for (int i = 0; i <list.size(); i++) {
//					ids[i]=list.get(i).getRecordid();
//				}
//				if(ids.length>0){
//					sysarticleHandleService.delete(ids);
//				}
//				sysarticleService.delete(id);
//				this.addActionMessage("删除成功！");
//				return list();
//			} catch (Exception e) {
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//		@SuppressWarnings("unchecked")
//		List list_type = new ArrayList();
//		/**
//		 * 获取该类别所有父级(父级递归，一直到没有父级为止)
//		 *
//		 * @param articletypeid
//		 * @return
//		 */
//		@SuppressWarnings("unchecked")
//		public List articleTypeRecursion(String articletypeid) {
//			if (null == articletypeid) {
//				articletypeid = "";
//			}
//			SysArticleType sysArticleType = sysArticleTypeService.get("articletypeid",
//					articletypeid);
//			if (null != sysArticleType) {
//				String parentid = null;
//				if (null != sysArticleType.getArticleType()) {// 有父级
//					parentid = sysArticleType.getArticleType().getArticletypeid();
//				}
//				list_type.add(parentid);
//				articleTypeRecursion(parentid);
//			}
//
//			return list_type;
//		}
//		/*
//		 *添加修改页面时类别联机
//		 *
//		 * @return
//		 */
//		@SuppressWarnings("unchecked")
//		public String loadArticleTypeOption() {
//			try {
//				String articletypeid=getParameter("articletypeid");
//				// 当前类别
//				SysArticleType articleTypeCurr = sysArticleTypeService.get(articletypeid);
//
//				List articletypeidParent = articleTypeRecursion(articletypeid);
//				StringBuffer sbOption = new StringBuffer();
//				int j = 0;// 第几级菜单
//				for (int i = articletypeidParent.size() - 1; i >= 0; i--) {
//					String id=(String) articletypeidParent.get(i);
//					System.out.println(id);
//					List<SysArticleType> list_articleType = sysArticleTypeService
//							.getList("articleType.articletypeid",
//									articletypeidParent.get(i));
//						sbOption.append("<span id=\"spantype" + (j - 1) + "\">");
//						sbOption.append("<select name=\"articletypeid" + j
//								+ "\" id=\"articletypeid" + j + "\" ");
//						sbOption.append(" onclick=\"typeChange(this.value," + j
//								+ ")\"");
//						sbOption.append(" >");
//
//						for (SysArticleType at : list_articleType) {
//							sbOption.append("<option value=\""
//									+ at.getArticletypeid() + "\" ");
//							// 当前子类选中，当前父类选中
//							if (at.getArticletypeid().equals(articletypeid)
//									|| at.getArticletypeid().equals(
//											articleTypeCurr.getArticleType()
//													.getArticletypeid())) {
//								sbOption.append("selected");
//							}
//							sbOption.append(" >");
//							sbOption.append(at.getArticletypename());
//							sbOption.append("</option>");
//						}
//						sbOption.append("</select>");
//						sbOption.append("</span>");
//						if (i == 0) {
//							sbOption.append("<span id=\"spantype" + (j) + "\">");
//							sbOption.append("</span>");
//						}
//						sbOption.append(" <script>$(\"#level\").val(\"" + j
//								+ "\")</script>");
//
//					j++;
//				}
//				getResponse().getWriter().print(sbOption.toString());
//				getResponse().getWriter().close();
//				return null;
//			} catch (Exception e) {
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//		/*
//		 * 类别变动时修改类别
//		 *
//		 * @return
//		 */
//		public String getArticleTypeOption() {
//			try {
//				String articletypeid=getParameter("articletypeid");
//				List<SysArticleType> list_articleType = sysArticleTypeService
//						.getList("articleType.articletypeid", articletypeid);
//				StringBuffer sbOption = new StringBuffer();
//				for (SysArticleType at : list_articleType) {
//						sbOption.append("<option value=\"" + at.getArticletypeid()+ "\">");
//						sbOption.append(at.getArticletypename());
//						sbOption.append("</option>");
//				}
//				getResponse().getWriter().print(sbOption.toString());
//				getResponse().getWriter().close();
//				return null;
//			} catch (Exception e) {
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//		/**
//		 * 系統文章列表
//		 *
//		 * @return
//		 */
//		public String list() {
//			try {
//				//查询所有上级类别
//				List<SysArticleType> ParentTypes=sysArticleTypeService.getList("from SysArticleType  a where a.articleType is null");
//				setAttribute("ParentTypes", ParentTypes);
//				String articletypeid=getParameter("articletypeid");
//
//				// 设置page参数
//				// 设置每页显示的条数
//				page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);
//
//				// 根据statePage进行Page对象设置，并查询
//				if (gotoPage == null || gotoPage.length() == 0) {
//					gotoPage = "1";
//				}
//
//				page.setCurrentPage(Integer.parseInt(gotoPage));
//				result = sysarticleService.listArticleByInformationPage(page,
//						articletypeid, article.getArticletitle());
//
//				setAttribute("list_article", result.getContent());
//				return "list";
//			} catch (Exception e) {
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//		@SuppressWarnings("unchecked")
//		public String listDate(){
//			try {
//				StringBuffer sbOption = new StringBuffer();
//				String articletypeid = getParameter("articletypeid");
//				String level=getParameter("level");
//				int j=0;
//				if(articletypeid==null||"".equals(articletypeid.trim())){
//					List<SysArticleType> ParentTypes=sysArticleTypeService.getList("from SysArticleType  a where a.articleType is null");
//					sbOption.append("<select name=\"articletypeid0\" id=\"articletypeid0\"");
//					sbOption.append(" onclick=\"typeChange(this.value,1)\">");
//					sbOption.append("<option value=\"\">全部</option>");
//					for(int i=0;i<ParentTypes.size();i++){
//						sbOption.append("<option value=\""+ ParentTypes.get(i).getArticletypeid() + "\">");
//						sbOption.append(ParentTypes.get(i).getArticletypename());
//						sbOption.append("</option>");
//					}
//					sbOption.append("</select>");
//					sbOption.append(" <script>$(\"#level\").val(1)</script>");
//					sbOption.append("<span id=\"spantype0\"></span>");
//				}else{
//					//获得所有上级类别（从最后以及到最上一级）
//					List articletypeidParent = articleTypeRecursion(articletypeid);
//					if(articletypeidParent!=null){
//						for (int i = articletypeidParent.size()-1; i >=0; i--) {
//							List<SysArticleType> list_articleType = sysArticleTypeService.getList("articleType.articletypeid",articletypeidParent.get(i));
//							if(articletypeidParent.get(i)==null){
//								sbOption.append("<select name=\"articletypeid0\" id=\"articletypeid0\"");
//								sbOption.append(" onclick=\"typeChange(this.value" +
//										",1)\">");
//								sbOption.append("<option value=\"\">全部</option>");
//							}else{
//								sbOption.append("<span id=\"spantype" + j + "\">");
//								sbOption.append("<select name=\"articletypeid" + (j)+ "\" id=\"articletypeid" + (j) + "\" ");
//								sbOption.append(" onclick=\"typeChange(this.value," + (j+1)+ ")\" >");
//							}
//							//输出兴趣屏道下级类别
//							for (SysArticleType at : list_articleType) {
//								sbOption.append("<option value=\""+ at.getArticletypeid() + "\" ");
//								if(i>=1){
//									if (at.getArticletypeid().equals(articletypeidParent.get(i-1))){
//										sbOption.append("selected");
//									}
//								}
//								else{
//									if (at.getArticletypeid().equals(articletypeid)){
//										sbOption.append("selected");
//									}
//								}
//								sbOption.append(" >");
//								sbOption.append(at.getArticletypename());
//								sbOption.append("</option>");
//							}
//							sbOption.append("</select>");
//							if(articletypeidParent.get(i)!=null){
//								sbOption.append("</span>");
//							}
//							sbOption.append(" <script>$(\"#level\").val(\"" + (j+1)+ "\")</script>");
//							j++;
//						}
//					}
//				}
//				sbOption.append("<span id=\"spantype"+j+"\"></span>");
//				getResponse().getWriter().print(sbOption.toString());
//				getResponse().getWriter().close();
//				return null;
//			} catch (Exception e) {
//				// TODO: handle exception
//				getRequest().setAttribute("exception", e.toString());
//				e.printStackTrace();
//				return ERROR;
//			}
//		}
//
//		public List getList_type() {
//			return list_type;
//		}
//		public void setList_type(List list_type) {
//			this.list_type = list_type;
//		}
//}
