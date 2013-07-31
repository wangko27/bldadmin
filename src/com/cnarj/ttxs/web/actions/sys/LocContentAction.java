package com.cnarj.ttxs.web.actions.sys;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.components.ActionMessage;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.LocContent;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.pojo.sys.WebContent;
import com.cnarj.ttxs.service.sys.ILocContentService;
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
public class LocContentAction extends PageAction {

	private ILocContentService locContentService;
	private ILocationInfoService locationInfoService;
	private IWebContentService webContentService;
	
	private List<LocContent> locContentList;
	private List<WebContent> webContentList;
	private List<LocationInfo> locationInfoList;
	
	private LocContent locContent;
//	private WebContent webContent;
//	private LocationInfo locationInfo;
	
	private String id;
	
	
	public ILocContentService getLocContentService() {		return locContentService;	}
	public void setLocContentService(ILocContentService locContentService) {		this.locContentService = locContentService;	}
	public ILocationInfoService getLocationInfoService() {		return locationInfoService;	}
	public void setLocationInfoService(ILocationInfoService locationInfoService) {		this.locationInfoService = locationInfoService;	}
	public IWebContentService getWebContentService() {		return webContentService;	}
	public void setWebContentService(IWebContentService webContentService) {		this.webContentService = webContentService;	}
	
	public LocContent getLocContent() {		return locContent;	}
	public void setLocContent(LocContent locContent) {		this.locContent = locContent;	}
	
	public List<LocContent> getLocContentList() {		return locContentList;	}
	public void setLocContentList(List<LocContent> locContentList) {		this.locContentList = locContentList;	}
	
//	public WebContent getWebContent() {		return webContent;	}
//	public void setWebContent(WebContent webContent) {		this.webContent = webContent;	}
//	public LocationInfo getLocationInfo() {		return locationInfo;	}
//	public void setLocationInfo(LocationInfo locationInfo) {		this.locationInfo = locationInfo;	}
	
	public List<WebContent> getWebContentList() {		return webContentList;	}
	public void setWebContentList(List<WebContent> webContentList) {		this.webContentList = webContentList;	}
	public List<LocationInfo> getLocationInfoList() {		return locationInfoList;	}
	public void setLocationInfoList(List<LocationInfo> locationInfoList) {		this.locationInfoList = locationInfoList;	}
	
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="locContent.locationInfo.locationid",
					message="必须选择位置!",
					trim = true),
			@RequiredStringValidator(fieldName="locContent.webContent.contentid",
					message="必须选择内容!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="locContent.locationInfo.locationid",
							message = "位置长度必须为 ${minLength}位",
							shortCircuit = true,
							trim = true, 
							minLength = "32", 
							maxLength = "32") ,
					@StringLengthFieldValidator(fieldName="locContent.webContent.contentid",
							message = "内容长度必须为 ${minLength}位",
							shortCircuit = true,
							trim = true, 
							minLength = "32", 
							maxLength = "32") 
			}
		) 
		/**
		 * 增加
		 */
		public String add(){
			//取当前时间
			Date now = new Date(System.currentTimeMillis());

			boolean bool = locContentService.isExist("locationInfo", locContent.getLocationInfo());
			if(!bool){
				locContent.setCreatedate(now);
				
				String aa = locContentService.save(locContent);
				
				this.addActionMessage("添加成功!");
			}
			else{
				this.addActionMessage("该位置已经对应的内容!请勿重复添加!");
			}
			
			return SUCCESS;
		}

	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="locContent.locationInfo.locationid",
					message="必须选择位置!",
					trim = true),
			@RequiredStringValidator(fieldName="locContent.webContent.contentid",
					message="必须选择内容!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="locContent.locationInfo.locationid",
							message = "位置长度必须为 ${minLength}位",
							shortCircuit = true,
							trim = true, 
							minLength = "32", 
							maxLength = "32") ,
					@StringLengthFieldValidator(fieldName="locContent.webContent.contentid",
							message = "内容长度必须为 ${minLength}位",
							shortCircuit = true,
							trim = true, 
							minLength = "32", 
							maxLength = "32") 
			}
		)  
		/**
		 * 修改
		 */
		public String edit(){
		locContentService.update(locContent);
			return SUCCESS;
		}
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			locContentService.delete(id);
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
			Long totalRecords = locContentService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LocContent.class);
			detachedCriteria.addOrder(Order.asc("createdate"));
			result = locContentService.findByPager(page, detachedCriteria);
			
			this.locContentList = result.getContent();
			
			return SUCCESS;
		}
		
		/**
		 * 根据ID查询
		 * @return
		 */
		public String querySouce(){

			locationInfoList = locationInfoService.getAll();
			webContentList = webContentService.getAll();
			
			return SUCCESS;
		}
	
}
