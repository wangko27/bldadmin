package com.cnarj.ttxs.web.actions.index;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.interest.Activity;
import com.cnarj.ttxs.pojo.interest.ActivityPrograma;
import com.cnarj.ttxs.pojo.interest.ActivityWorks;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Article;
import com.cnarj.ttxs.pojo.sys.GradeCode;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.Article.IArticleService;
import com.cnarj.ttxs.service.Article.IArticleTypeService;
import com.cnarj.ttxs.service.Article.ISysArticleService;
import com.cnarj.ttxs.service.interest.IActivityProgramaService;
import com.cnarj.ttxs.service.interest.IActivityService;
import com.cnarj.ttxs.service.interest.IActivityWorksService;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.service.learn.IReadShoolService;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.service.learn.ISuperTeacherService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.service.sys.IGradeCodeService;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */

public class IndexAction extends PageAction{
	private ISubjectCodeService subjectCodeService;
	private IGradeCodeService gradeCodeService;
	private IArticleService articleService;
	private IArticleTypeService articleTypeService;
	private IActivityService activityService;
	private IOneDayOneTextService oneTextService;
	private ISysArticleService sysarticleService;
	private IReadbookService readbookService;
	private ISuperTeacherService superTeacherService;
	private IGoodsService goodsService;
	private IGoodsSortService sortService;
	private IActivityProgramaService activityProgramaService;
	private IActivityWorksService activityWorksService;
	private String subject;
	private String gradeCode;
	private IReadShoolService readShoolService;
	private String t;
	
	private String sortId;//类别的Id(畅销)
	
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public IGoodsSortService getSortService() {
		return sortService;
	}
	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}
	public IGoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public ISuperTeacherService getSuperTeacherService() {
		return superTeacherService;
	}
	public void setSuperTeacherService(ISuperTeacherService superTeacherService) {
		this.superTeacherService = superTeacherService;
	}
	public IReadbookService getReadbookService() {
		return readbookService;
	}
	public void setReadbookService(IReadbookService readbookService) {
		this.readbookService = readbookService;
	}
	public ISysArticleService getSysarticleService() {
		return sysarticleService;
	}
	public void setSysarticleService(ISysArticleService sysarticleService) {
		this.sysarticleService = sysarticleService;
	}
	public IOneDayOneTextService getOneTextService() {
		return oneTextService;
	}
	public void setOneTextService(IOneDayOneTextService oneTextService) {
		this.oneTextService = oneTextService;
	}
	public IActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}
	public ISubjectCodeService getSubjectCodeService() {
		return subjectCodeService;
	}
	public void setSubjectCodeService(ISubjectCodeService subjectCodeService) {
		this.subjectCodeService = subjectCodeService;
	}
	public IArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	public IGradeCodeService getGradeCodeService() {
		return gradeCodeService;
	}
	public void setGradeCodeService(IGradeCodeService gradeCodeService) {
		this.gradeCodeService = gradeCodeService;
	}
	public IArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}
	public void setArticleTypeService(IArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}
	public IActivityProgramaService getActivityProgramaService() {
		return activityProgramaService;
	}
	public void setActivityProgramaService(
			IActivityProgramaService activityProgramaService) {
		this.activityProgramaService = activityProgramaService;
	}
	public IActivityWorksService getActivityWorksService() {
		return activityWorksService;
	}
	public void setActivityWorksService(IActivityWorksService activityWorksService) {
		this.activityWorksService = activityWorksService;
	}
	@SuppressWarnings("unchecked")
	public String index(){
		try {
			//--------------头部----------------------------//
			
			//--------------上面的部分----------------------------//
		//获得最新新闻6条
		List<ArticleSrc> articleListTN=articleService.getShareArticleSrc("最新新闻", "1", 6);
		for(int i=0;i<articleListTN.size();i++){
			articleListTN.get(i).setArticlesrccontent(HtmlUtil.splitAndFilterString(articleListTN.get(i).getArticlesrccontent(), 85));
		}
		this.setAttribute("articleListTN", articleListTN);
		//精彩活动6条
		List<Activity> hotactivity=activityService.ShowindexActivity(6);
		for(int i=0;i<hotactivity.size();i++){
			hotactivity.get(i).setActivityintro(HtmlUtil.splitAndFilterString(hotactivity.get(i).getActivityintro(), 90));
		}
		this.setAttribute("hotactivity", hotactivity);
		//系统公告 4条 
		List<Article> articleListNT=sysarticleService.getNewsNotice(4);
		this.setAttribute("articleListNT", articleListNT);
		// 存储当前日期
		setAttribute("nowdate", new Date());
		// 查询一天一课内容(显示最新四条)
		// 默认查一年级的语文
		String gradecode = "8a8081a131bd7ec20131bd1234560001";//一年级
		String subject = "8a8080ad31bbc084013321c4f1a90003";//语文
		//获得所有年级
		List<GradeCode> list_gradeCode = gradeCodeService.getAll();
		//获得关联科目
		List<SubjectCode> list_subject=subject(gradecode);
		this.setAttribute("list_subject", list_subject);
		this.setAttribute("list_gradeCode", list_gradeCode);
		List<ReadSrc> list_oneday_new=oneTextService.getToDayReadSrc(subject, gradecode, 4);
		for(int i=0;i<list_oneday_new.size();i++){
			list_oneday_new.get(i).setContentintro(HtmlUtil.splitAndFilterString(list_oneday_new.get(i).getContentintro(), 60));
		}
		this.setAttribute("list_oneday_new", list_oneday_new);
		//--------------学习部分----------------------------//
		//获得文章资源 学习栏目下的文章类别
		List<ArticleType> listarticletype=articleTypeService.getList("articleType.articletypeid","8a8081a131cd5fcd0131cd68a7250001");
		this.setAttribute("articletype",listarticletype );
		//8本最新读物
		List<ReadSrc> listnewread=readbookService.get5ReadSrc(8);
		//去掉内容中的 样式
		for(int i=0;i<listnewread.size();i++){
			listnewread.get(i).setContentintro(HtmlUtil.splitAndFilterString(listnewread.get(i).getContentintro(),55));
		}
		this.setAttribute("listnewread", listnewread);
		//获得所有科目
		List<SubjectCode> suball=subjectCodeService.getAll();
		this.setAttribute("suball", suball);
		//查询3 条名师 根据创建时间排序
		List<SuperTeacher> listsuperteacher=superTeacherService.getnewteacher(3);
		for(int i=0;i<listsuperteacher.size();i++){
			listsuperteacher.get(i).setTeacherIntroduction(HtmlUtil.splitAndFilterString(listsuperteacher.get(i).getTeacherIntroduction(), 30));
		}
		this.setAttribute("listsuperteacher", listsuperteacher);
		//获得3条名校风采
		List<ArticleSrc> listschool=readShoolService.listSchoolsByTop(3);
		//去掉内容中的 样式
		for(int i=0;i<listschool.size();i++){
			listschool.get(i).setArticleintro(HtmlUtil.splitAndFilterString(listschool.get(i).getArticleintro(), 30));
		}
		this.setAttribute("listschool", listschool);
		//获得品学论道 8 条
		List<ArticleSrc> PerusalArticle=articleService.getPualArticle(8);
		this.setAttribute("PerusalArticle", PerusalArticle);
		//--------------兴趣部分----------------------------//
		//获得拍拍乐下的活动作品票数最多 3条
		//得到票数最多的3条活动作品
		List<ActivityWorks> fareList=activityWorksService.getByFareActivityWorks(3,false,"8a8081a1320f1b7c01320f300e99000c");
		setAttribute("fareList", fareList);
		//获得最新活动作品 4条
		List<ActivityWorks> newworks=activityWorksService.getnewsWorks(4);
		for(int i=0;i<newworks.size();i++){
			newworks.get(i).setWorksintro(HtmlUtil.splitAndFilterString(newworks.get(i).getWorksintro(), 60));
		}
		this.setAttribute("newworks",newworks );
		//获得启用所有
		List<ActivityPrograma> listallPrograma=activityProgramaService.getAll();
		this.setAttribute("listallPrograma", listallPrograma);
		//获得拍拍乐下精彩活动3条拍拍乐为上级类别
		//获得兴趣频道最新活动
		List<Activity> list=activityService.getnewsActivity(7);
		this.setAttribute("activity", list);
		//5条新知识
		List<Article> newknows=sysarticleService.getactivitynews(5);
		this.setAttribute("newknows", newknows);
		//--------------商城部分----------------------------//
		//查询4条热卖商品本周
		List<Goods> bestsalegoods=goodsService.gethotGoods(4);
		for(int i=0;i<bestsalegoods.size();i++){
			bestsalegoods.get(i).setProductdescription(HtmlUtil.splitAndFilterString(bestsalegoods.get(i).getProductdescription(),30));
		}
		this.setAttribute("bestsalegoods", bestsalegoods);
		//得到主类别的热销类别
		List<GoodesCategory> hotMainsrot=sortService.getHotMainList();
		this.setAttribute("hotMainsrot", hotMainsrot);
		//获得所有热销下级类别
		List<GoodesCategory> hotchildsrot=sortService.getHotSrot();
		this.setAttribute("hotchildsrot", hotchildsrot);
		//根据主类别的id 得到8条热销商
		if(hotMainsrot!=null&&hotMainsrot.size()>0){
			if(sortId==null||sortId.trim().equals("")){
				sortId=hotMainsrot.get(0).getCategoryid();
			}
		List<Goods> hotGoodses=goodsService.getByMainSortGoods(sortId,8);
		this.setAttribute("hotGoodses", hotGoodses);
		} 
		//获得所有上级类别
		List<GoodesCategory> goodsMianSrot=sortService.getMainList();
		this.setAttribute("size", goodsMianSrot.size());
		this.setAttribute("goodsMianSrot", goodsMianSrot);	
		//--------------友情链接----------------------------//
			
		 //--------------底部----------------------------//
		 
		 
			return "showindex";
		} catch (Exception e) {
			e.printStackTrace();
			return "showindex";
		}
	}
	/*
	 * 根据商品的上级类别查询下级类别
	 */
	public String getcildtypeByparent(){
		try {
			String goodsMianSrot = getParameter("goodsMianSrot");
			StringBuffer sbOption = new StringBuffer();
			List<GoodesCategory> goodSrot=sortService.getSrot(goodsMianSrot);
			if(goodSrot.size()<=0){
				sbOption.append("<option value=''");
				sbOption.append(" >");
				sbOption.append("全部");
				sbOption.append("</option>");
			}
			else{
				sbOption.append("<option value=''");
				sbOption.append(" >");
				sbOption.append("全部");
				sbOption.append("</option>");
				for (GoodesCategory gs: goodSrot) {
					sbOption.append("<option value=\""
							+ gs.getCategoryid() + "\" ");
					sbOption.append(" >");
					sbOption.append(gs.getCategoryname());
					sbOption.append("</option>");
				}
			}
			
			getResponse().getWriter().print(sbOption.toString());
			getResponse().getWriter().close();
			
			return null; 
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	/*
	 * 根据商品类别查询 8条最新商品
	 * 
	 */
	public String gethotgoods(){
		try {

			String goodstype = getParameter("goodstype");
			StringBuffer sbOption = new StringBuffer();
			List<Goods> hotGoodses=goodsService.getByMainSortGoods(goodstype,8);
			if(hotGoodses.size()<=0){
				sbOption.append("<center>暂无数据</center>");
			}
			else{
				for (Goods g: hotGoodses) {
					sbOption.append("<li><a href=\"shopping/shpping_showGoods.action?goodsId="+g.getGoodsid()+"");
					sbOption.append("&t=1\"\">");
					if(g.getPhotospath()==null){
						sbOption.append("<img src=\"img/news_img/none.jpg\"/>");
						sbOption.append("</br>");
					}
					else{
						sbOption.append("<img src=\""+g.getPhotospath()+"\"/>");
						sbOption.append("</br>");
					}
					sbOption.append(g.getGoodsname().substring(0,g.getGoodsname().length()>10 ? 10:g.getGoodsname().length()));
					sbOption.append("</br>");
					sbOption.append("<span>￥");
					sbOption.append(g.getProductprice());
					sbOption.append(".00</span></a></li>");
				}	
			}
			getResponse().getWriter().print(sbOption.toString());
			getResponse().getWriter().close();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	/*
	 *根据类别检索 商品
	 * 
	 */
	public String searchBytype(){
		try {
			page.setEveryPage(24);
			//设置page参数
			// 设置每页显示的条数
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			//默认为全部
			String goodsMianSrot = "";//上级类别
			String goodsSrot = "";//下级类别
			if (null != getParameter("goodsMianSrot")
					&& !"".equals(getParameter("goodsMianSrot"))) {
				goodsMianSrot = getParameter("goodsMianSrot");
			}
			if (null != getParameter("goodsSrot")
					&& !"".equals(getParameter("goodsSrot"))) {
				goodsSrot = getParameter("goodsSrot");
			}
			result=goodsService.getTypeGoods(page, goodsMianSrot, goodsSrot);//查询商品列表
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	@SuppressWarnings("unchecked")
	List<SubjectCode> list_subject = new ArrayList();
	/*
	 * 去掉科目中的多余科目
	 * 
	 */
	public List<SubjectCode> subject(String gradecode){
		//一二年级
		if(gradecode.equals("8a8081a131bd7ec20131bd1234560001")||gradecode.equals("8a8081a131bd7ec20131bd7f78e53331")){
			String[] subject=new String[2];
			subject[0]="8a8080ad311234560131bbc4f1a90003";//语文
		    subject[1]="8a8080ad31bbc084013321c4f1a90003";//数学
			return list_subject=subjectCodeService.get(subject);
			//三四五六年级
		}else if(gradecode.equals("8a8081a131bd7ec20131bd7f78e50221")||gradecode.equals("8a8081a131bd7ec20131bd7f78e50001")||gradecode.equals("8a8081a131bd7ec20131bd7f78e50002")||gradecode.equals("8a8081a131bd7ec20131bd7f78e50003")){
			String[] subject=new String[4];
			subject[0]="8a8080ad31bbc084013321c4f1a90003";//语文
			subject[1]="8a8080ad311234560131bbc4f1a90003";//数学
			subject[2]="8a8080ad31bbc0840131bbc4f1a90003";//外语
			subject[3]="8a8081ee32b901f30132b9137cb00002";//奥数
			return list_subject=subjectCodeService.get(subject);
		}
		//七年级/初一
		else if(gradecode.equals("8a8081a131bd7ec20131bd7f78e50004")){
			String[] subject=new String[8];
			subject[0]="8a8080ad31bbc084013321c4f1a90003";//语文
			subject[1]="8a8080ad311234560131bbc4f1a90003";//数学
			subject[2]="8a8080ad31bbc0840131bbc4f1a90003";//外语
			subject[3]="8a8081ee32b901f30132b9137cb00002";//奥数
			subject[4]="8a8080ad31bbd5c10131bbd625a70001";//历史
			subject[5]="8a8080ad31bbd85a0131bbd9704e0001";//地理
			subject[6]="8a8080ad31bbd3470131bbd46b260002";//生物
			subject[7]="8a8080ad31bc6eb20131bc70301a0002";//思想品德
			return list_subject=subjectCodeService.get(subject);
		}
		//初二
		else if(gradecode.equals("8a8081a131bd7ec20131bd7f78e50005")){
			String[] subject=new String[9];
			subject[0]="8a8080ad31bbc084013321c4f1a90003";//语文
			subject[1]="8a8080ad311234560131bbc4f1a90003";//数学
			subject[2]="8a8080ad31bbc0840131bbc4f1a90003";//外语
			subject[3]="8a8081ee32b901f30132b9137cb00002";//奥数
			subject[4]="8a8080ad31bbd5c10131bbd625a70001";//历史
			subject[5]="8a8080ad31bbd85a0131bbd9704e0001";//地理
			subject[6]="8a8080ad31bbd3470131bbd46b260002";//生物
			subject[7]="8a8080ad31bbd3470131bbd4114e0001";//物理
			subject[8]="8a8080ad31bc6eb20131bc70301a0002";//思想品德
			return list_subject=subjectCodeService.get(subject);
		}
		//初三
		else if(gradecode.equals("8a8081a131bd7ec20131bd7f78e50006")){
			String[] subject=new String[8];
			subject[0]="8a8080ad31bbc084013321c4f1a90003";//语文
			subject[1]="8a8080ad311234560131bbc4f1a90003";//数学
			subject[2]="8a8080ad31bbc0840131bbc4f1a90003";//外语
			subject[3]="8a8081ee32b901f30132b9137cb00002";//奥数
			subject[4]="8a8080ad31bbd5c10131bbd625a70001";//历史
			subject[5]="8a8080ad31bbd3470131bbd4114e0001";//物理
			subject[6]="8a8080ad311234840131bbc4f1a90003";//化学
			subject[7]="8a8080ad31bc6eb20131bc70301a0002";//思想品德
			return list_subject=subjectCodeService.get(subject);
		}
		//高一高二高三
		else if(gradecode.equals("8a8081a131bd7ec20131bd7f78e50007")||gradecode.equals("8a8081a131bd7ec20131bd7f78e50008")||gradecode.equals("8a8081a131bd7ec20131bd7f78e50009")){
			String[] subject=new String[10];
			subject[0]="8a8080ad31bbc084013321c4f1a90003";//语文
			subject[1]="8a8080ad311234560131bbc4f1a90003";//数学/文理
			subject[2]="8a8080ad31bbc0840131bbc4f1a90003";//外语
			subject[3]="8a8081ee32b901f30132b9137cb00002";//奥数
			subject[4]="8a8080ad31bbd5c10131bbd625a70001";//历史
			subject[5]="8a8080ad31bbd3470131bbd4114e0001";//物理
			subject[6]="8a8080ad311234840131bbc4f1a90003";//化学
			subject[7]="8a8080ad31bc6eb20131bc70301a0002";//政治
			subject[8]="8a8080ad31bc6eb20131bc70301a0002";//地理
			subject[9]="8a8080ad31bc6eb20131bc70301a0002";//生物
			return list_subject=subjectCodeService.get(subject);
		}
		else{
			return list_subject;
		}
		
	}

	/*
	 * 一天一课查询
	 * 
	 */	
	@SuppressWarnings("deprecation")
	public String changedailyReads(){
		try {
			StringBuffer sbOption = new StringBuffer();
			if(null==gradeCode||"".equals(gradeCode)){
				gradeCode = "8a8081a131bd7ec20131bd1234560001";//一年级
			}
			if(null==subject||"".equals(subject)){
				subject = "8a8080ad31bbc084013321c4f1a90003";//语文
			}

			//获得年级下的类别
			List<SubjectCode> list_subject=subject(gradeCode);
			List<ReadSrc> list_oneday_new=oneTextService.getToDayReadSrc(subject, gradeCode, 4);
			if(list_oneday_new.size()<=0){
				sbOption.append("<div id=\"changedailyReads\"><div  class=\"qie_2\"><ul class=\"kemu\">");
				for(int i=0;i<list_subject.size();i++){
					sbOption.append("<li name=\"subject\" id=\"li");
					sbOption.append(i+1);
					sbOption.append("\"><a onclick=\"return changedailyReads('','");
					System.out.println(list_subject.get(i).getSubjectcode());
					sbOption.append(list_subject.get(i).getSubjectcode());
					sbOption.append("')\"");
					if(list_subject.get(i).getSubjectcode().equals(subject)){
						sbOption.append(" class=\"din_1\" id=\"a");
					}
					else{
						sbOption.append(" id=\"a");
					}
					sbOption.append(i+1);
					sbOption.append("\">");
					sbOption.append(list_subject.get(i).getSubjectname());
					sbOption.append("</a></li>");
					sbOption.append("<li id=\"lis");
					sbOption.append(i+1);
					sbOption.append("\">|</li>");
				}
				sbOption.append(" </ul><ul class=\"qiean_1\"><li><a onClick=\"showsblast()\"><img src=\"img/home_img/an_3.gif\" /></a><a onClick=\"showsbnext()\">");
				sbOption.append("<img src=\"img/home_img/an_4.gif\" /></a></li></ul></div>");
				sbOption.append("<div  class=\"nwen\"><center>暂时没有数据</center></div>");
			}
			if(list_oneday_new.size()==1){
				sbOption.append("<div id=\"changedailyReads\"><div  class=\"qie_2\"><ul class=\"kemu\">");
				for(int i=0;i<list_subject.size();i++){
					sbOption.append("<li name=\"subject\" id=\"li");
					sbOption.append(i+1);
					sbOption.append("\"><a onclick=\"return changedailyReads('','");
					System.out.println(list_subject.get(i).getSubjectcode());
					sbOption.append(list_subject.get(i).getSubjectcode());
					sbOption.append("')\"");
					if(list_subject.get(i).getSubjectcode().equals(subject)){
						sbOption.append(" class=\"din_1\" id=\"a");
					}
					else{
						sbOption.append(" id=\"a");
					}
					sbOption.append(i+1);
					sbOption.append("\">");
					sbOption.append(list_subject.get(i).getSubjectname());
					sbOption.append("</a></li>");
					sbOption.append("<li id=\"lis");
					sbOption.append(i+1);
					sbOption.append("\">|</li>");
				}
				sbOption.append(" </ul><ul class=\"qiean_1\"><li><a onClick=\"showsblast()\"><img src=\"img/home_img/an_3.gif\" /></a><a onClick=\"showsbnext()\">");
				sbOption.append("<img src=\"img/home_img/an_4.gif\" /></a></li></ul></div>");
				sbOption.append("<div  class=\"nwen\"><h1><a href=\"learn/oneday_showOneDayInfo.action?liindex=1&readId=");
				sbOption.append(list_oneday_new.get(0).getReadsrcid());
				sbOption.append("\" title=\"");
				sbOption.append(list_oneday_new.get(0).getReadsrctile());
				sbOption.append("\">");
				if(list_oneday_new.get(0).getReadsrctile()!=null){
					
					sbOption.append(list_oneday_new.get(0).getReadsrctile().substring(0, list_oneday_new.get(0).getReadsrctile().length()>15 ? 15:list_oneday_new.get(0).getReadsrctile().length()));
				}
				sbOption.append("</a></h1><p>");
				if(list_oneday_new.get(0).getContentintro()!=null){
					sbOption.append(HtmlUtil.splitAndFilterString(list_oneday_new.get(0).getContentintro(), 60));
				}
				sbOption.append("</p></div>");
				sbOption.append("<div class=\"nlie\"><center>数据不足</center></div></div>");
			}else if(list_oneday_new.size()>1){
				sbOption.append("<div id=\"changedailyReads\"><div  class=\"qie_2\"><ul class=\"kemu\">");
				for(int i=0;i<list_subject.size();i++){
					sbOption.append("<li name=\"subject\" id=\"li");
					sbOption.append(i+1);
					sbOption.append("\"><a onclick=\"return changedailyReads('','");
					System.out.println(list_subject.get(i).getSubjectcode());
					sbOption.append(list_subject.get(i).getSubjectcode());
					sbOption.append("')\"");
					if(list_subject.get(i).getSubjectcode().equals(subject)){
						sbOption.append(" class=\"din_1\" id=\"a");
					}
					else{
						sbOption.append(" id=\"a");
					}
					sbOption.append(i+1);
					sbOption.append("\">");
					sbOption.append(list_subject.get(i).getSubjectname());
					sbOption.append("</a></li>");
					sbOption.append("<li id=\"lis");
					sbOption.append(i+1);
					sbOption.append("\">|</li>");
				}
				sbOption.append(" </ul><ul class=\"qiean_1\"><li><a onClick=\"showsblast()\"><img src=\"img/home_img/an_3.gif\" /></a><a onClick=\"showsbnext()\">");
				sbOption.append("<img src=\"img/home_img/an_4.gif\" /></a></li></ul></div>");
				for(int i=0; i<list_oneday_new.size();i++){
					if(i==0){
						sbOption.append("<div id=\"changedailyReads\"><div  class=\"nwen\"><h1><a href=\"learn/oneday_showOneDayInfo.action?liindex=1&readId=");
						sbOption.append(list_oneday_new.get(0).getReadsrcid());
						sbOption.append("\" title=\"");
						sbOption.append(list_oneday_new.get(0).getReadsrctile());
						sbOption.append("\">");
						if(list_oneday_new.get(0).getReadsrctile()!=null){
							sbOption.append(list_oneday_new.get(0).getReadsrctile().substring(0, list_oneday_new.get(0).getReadsrctile().length()>15 ? 15:list_oneday_new.get(0).getReadsrctile().length()));
						}
						sbOption.append("</a></h1><p>");
						if(list_oneday_new.get(0).getContentintro()!=null){
							sbOption.append(HtmlUtil.splitAndFilterString(list_oneday_new.get(0).getContentintro(), 60));
						}
						sbOption.append("</p></div>");	
					}else{
						sbOption.append("<div class=\"nlie\"><ul><li><a href=\"learn/oneday_showOneDayInfo.action?liindex=1&readId=");
						sbOption.append(list_oneday_new.get(i).getReadsrcid());
						sbOption.append("\">");
						if(list_oneday_new.get(i).getReadsrctile()!=null){
							sbOption.append(list_oneday_new.get(i).getReadsrctile().substring(0, list_oneday_new.get(i).getReadsrctile().length()>15 ? 15:list_oneday_new.get(i).getReadsrctile().length()));
						}
						sbOption.append("</a><span>");
						Date di=list_oneday_new.get(i).getModifydate();
						if(di!=null){
							System.out.println(di);
							SimpleDateFormat format=new SimpleDateFormat("MM-dd");
							String strdi=format.format(di);
							sbOption.append(strdi);
						}
						sbOption.append("</span></li></ul></div></div>");
						
					}
				}
			}
			String just=sbOption.toString();
			getResponse().getWriter().print(just);
			getResponse().getWriter().close();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public IReadShoolService getReadShoolService() {
		return readShoolService;
	}
	public void setReadShoolService(IReadShoolService readShoolService) {
		this.readShoolService = readShoolService;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
}
