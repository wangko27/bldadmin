package com.cnarj.ttxs.web.actions.sys;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;


/**
 * 系统Action类 - 网站位置
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月6日9:49:37
 */
@Validation
public class LocationInfoAction extends PageAction {

	private ILocationInfoService locationInfoService;
	
	private LocationInfo locationInfo;
	private List<LocationInfo> locationInfoList;
	private String id;
	
	public ILocationInfoService getLocationInfoService() {		return locationInfoService;	}
	public void setLocationInfoService(ILocationInfoService locationInfoService) {		this.locationInfoService = locationInfoService;}
	public LocationInfo getLocationInfo() {		return locationInfo;	}
	public void setLocationInfo(LocationInfo locationInfo) {		this.locationInfo = locationInfo;	}
	public List<LocationInfo> getLocationInfoList() {		return locationInfoList;	}
	public void setLocationInfoList(List<LocationInfo> locationInfoList) {		this.locationInfoList = locationInfoList;}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="locationInfo.locationname",
					message="网站位置名称不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="locationInfo.locationname",
							message = "网站位置名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="locationInfo.locationintro",
							message = "科目说明长度必须在 ${minLength}-${maxLength}之间",
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
			
			locationInfo.setCreatedate(now);
			
			String aa = locationInfoService.save(locationInfo);
			
			this.addActionMessage("添加成功！");
			
			return SUCCESS;
		}

	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="locationInfo.locationname",
					message="网站位置名称不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="locationInfo.locationname",
							message = "网站位置名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") ,
					@StringLengthFieldValidator(fieldName="locationInfo.locationintro",
							message = "科目说明长度必须在 ${minLength}-${maxLength}之间",
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
			locationInfoList = locationInfoService.getAll();
			return SUCCESS;
		}
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			locationInfoService.delete(id);
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
			Long totalRecords = locationInfoService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LocationInfo.class);
			detachedCriteria.addOrder(Order.asc("createdate"));
			result = locationInfoService.findByPager(page, detachedCriteria);
			
			this.locationInfoList = result.getContent();
			
			return SUCCESS;
		}
		
		/**
		 * 根据ID查询
		 * @return
		 */
		public String queryById(){
			locationInfo = locationInfoService.get(this.id);
			
			locationInfoList = locationInfoService.getAll();
			
			return SUCCESS;
		}
	
}
