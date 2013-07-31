package com.cnarj.ttxs.web.actions.adv;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.service.adv.IAdvInfoService;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * 广告Action类 - 广告
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月6日11:26:36
 */
public class AdvInfoAction extends PageAction {

	private IAdvInfoService advInfoService;
	private ILocationInfoService locationInfoService;
	
	private List<AdvInfo> advInfoList;
	private List<LocationInfo> locationInfoList;	
	
	private AdvInfo advInfo;
	private String id;
	
	
	
	public ILocationInfoService getLocationInfoService() {		return locationInfoService;	}
	public void setLocationInfoService(ILocationInfoService locationInfoService) {		this.locationInfoService = locationInfoService;	}
	public IAdvInfoService getAdvInfoService() {		return advInfoService;	}
	public void setAdvInfoService(IAdvInfoService advInfoService) {		this.advInfoService = advInfoService;	}
	
	public List<AdvInfo> getAdvInfoList() {		return advInfoList;	}
	public void setAdvInfoList(List<AdvInfo> advInfoList) {		this.advInfoList = advInfoList;	}
	public List<LocationInfo> getLocationInfoList() {		return locationInfoList;	}
	public void setLocationInfoList(List<LocationInfo> locationInfoList) {		this.locationInfoList = locationInfoList;	}
	
	public AdvInfo getAdvInfo() {		return advInfo;	}
	public void setAdvInfo(AdvInfo advInfo) {		this.advInfo = advInfo;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	

//	@Validations( 
//			requiredStrings={ 
//			@RequiredStringValidator(fieldName="navigation.navigationname",
//					message="导航名称不能为空!",
//					trim = true)
//			},
//			stringLengthFields = {
//					@StringLengthFieldValidator(fieldName="navigation.navigationname",
//							message = "导航名称长度必须在 ${minLength}-${maxLength}之间",
//							shortCircuit = true,
//							trim = true, 
//							minLength = "1", 
//							maxLength = "256") 
//			}
//		)
		/**
		 * 增加
		 */
		public String add(){
//			//判断该导航是否已经存在
//			boolean isexist = navigationService.isExist("navigationname", navigation.getNavigationname());
//			if(isexist){
//				this.addActionError("该导航已经存在!");
//				return ERROR;
//			}
		
			//1.准备数据,添加管理员
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			advInfo.setCreatedate(now);
			
			String aa = advInfoService.save(advInfo);
			
			this.addActionMessage("导航信息添加成功!");
			
			return SUCCESS;
		}

//	@Validations( 
//			requiredStrings={ 
//			@RequiredStringValidator(fieldName="navigation.navigationname",
//					message="导航名称不能为空!",
//					trim = true)
//			},
//			stringLengthFields = {
//					@StringLengthFieldValidator(fieldName="navigation.navigationname",
//							message = "导航名称长度必须在 ${minLength}-${maxLength}之间",
//							shortCircuit = true,
//							trim = true, 
//							minLength = "1", 
//							maxLength = "256") 
//			}
//		)
		/**
		 * 修改
		 */
		public String edit(){
			
			//判断该导航是否已经存在
//			boolean isunique = advInfoService.isUnique("navigationname",oldvalue, navigation.getNavigationname());
//			if(!isunique){
//				this.addActionError("该导航已经存在,请勿重复添加!");
//				return ERROR;
//			}
			
			advInfoService.update(advInfo);
			
			this.addActionMessage("修改成功");
			
			advInfoList = advInfoService.getAll();
			
			return SUCCESS;
		}
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			//判断是否有子记录
			List list = advInfoService.getList("navigation.navigationid", this.id);
			if(null != list && list.size() > 0){
				this.addActionMessage("该导航下面还有子导航,不能删除!");
//				struts.xwork.chaining.copyMessages();
				return ERROR;
			}
			
			advInfoService.delete(id);
			this.addActionMessage("删除成功!");
			return SUCCESS;
		}
		
		/**
		 * 分页查询
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
			Long totalRecords = advInfoService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Navigation.class);
			detachedCriteria.addOrder(Order.asc("navigation.navigationid"));
			detachedCriteria.addOrder(Order.asc("orderlist"));
			result = advInfoService.findByPager(page, detachedCriteria);
			
			this.advInfoList = result.getContent();
			
			return SUCCESS;
		}
		
		/**
		 * 查询所有用于页面展示的
		 * @return
		 */
		public String listShow(){
//			this.advInfoList = advInfoService.getTopNavigationList();
			
			return SUCCESS;
		}

		/**
		 * 根据ID查询
		 * @return
		 */
		public String queryById(){
			advInfo = advInfoService.get(this.id);
			
			advInfoList = advInfoService.getAll();
			
			return SUCCESS;
		}
	/**
	 * 添加前查询位置信息
	 * @return
	 */
	public String addBef(){

		locationInfoList = locationInfoService.getAll();
		
		return SUCCESS;
	}
	
//	/**
//	 * 根据上级导航的名称查询
//	 * @return
//	 */
//	public String listByPevId(){
////		this.advInfoList = advInfoService.getList("navigation.navigationname", this.preName);
//		return SUCCESS;
//	}
	
}
