package com.cnarj.ttxs.web.actions.sys;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.pojo.sys.WebContent;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.service.sys.IWebContentService;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;


/**
 * 系统Action类 - 内容
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月6日11:26:36
 */
@Validation
public class WebContentAction extends PageAction {

	private IWebContentService webContentService;
	
	private WebContent webContent;
	private List<WebContent> webContentList;
	private String id;
	
	
	public IWebContentService getWebContentService() {		return webContentService;	}
	public void setWebContentService(IWebContentService webContentService) {		this.webContentService = webContentService;}
	public WebContent getWebContent() {		return webContent;	}
	public void setWebContent(WebContent webContent) {		this.webContent = webContent;	}
	public List<WebContent> getWebContentList() {		return webContentList;	}
	public void setWebContentList(List<WebContent> webContentList) {		this.webContentList = webContentList;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="webContent.contentname",
					message="内容名称不能为空!",
					trim = true),
			@RequiredStringValidator(fieldName="webContent.contenturl",
					message="内容展示的URL不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="webContent.contentname",
							message = "内容名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="webContent.contenturl",
							message = "内容展示的URL长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="webContent.contentintro",
							message = "内容说明长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "512") 
			}
		) 
		/**
		 * 增加
		 */
		public String add(){
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			
			webContent.setCreatedate(now);
			
			String aa = webContentService.save(webContent);
			
			return SUCCESS;
		}

	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="webContent.contentname",
					message="内容名称不能为空!",
					trim = true),
			@RequiredStringValidator(fieldName="webContent.contenturl",
					message="内容展示的URL不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="webContent.contentname",
							message = "内容名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="webContent.contenturl",
							message = "内容展示的URL长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="webContent.contentintro",
							message = "内容说明长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "512") 
			}
		) 
		/**
		 * 修改
		 */
		public String edit(){
		webContentService.update(webContent);
			return SUCCESS;
		}
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			webContentService.delete(id);
			return SUCCESS;
		}
		
		/**
		 * 查询所有
		 * @return
		 */
		public String list(){

			//设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			//总数目
			Long totalRecords = webContentService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(WebContent.class);
			detachedCriteria.addOrder(Order.asc("createdate"));
			result = webContentService.findByPager(page, detachedCriteria);
			
			this.webContentList = result.getContent();
			
			webContentList = webContentService.getAll();
			return SUCCESS;
		}
		
		/**
		 * 根据ID查询
		 * @return
		 */
		public String queryById(){
			webContent = webContentService.get(this.id);
			
			return SUCCESS;
		}
	
}
