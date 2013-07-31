package com.cnarj.ttxs.web.actions.sys;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.components.ActionMessage;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.sys.LocContent;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.pojo.sys.WebContent;
import com.cnarj.ttxs.pojo.sys.Navigation.Position;
import com.cnarj.ttxs.service.sys.ILocContentService;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.service.sys.INavigationService;
import com.cnarj.ttxs.service.sys.IWebContentService;
import com.cnarj.ttxs.util.MD5;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;


/**
 * 系统Action类 - 导航
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年7月6日11:26:36
 */
@Validation
public class NavigationAction extends PageAction {

	private INavigationService navigationService;
	private List<Navigation> navigationList;
	private Navigation navigation;
	private String id;
	private String preName;
	private String oldvalue;
	
	public INavigationService getNavigationService() {		return navigationService;	}
	public void setNavigationService(INavigationService navigationService) {		this.navigationService = navigationService;}
	public List<Navigation> getNavigationList() {		return navigationList;	}
	public void setNavigationList(List<Navigation> navigationList) {		this.navigationList = navigationList;	}
	public Navigation getNavigation() {		return navigation;	}
	public void setNavigation(Navigation navigation) {		this.navigation = navigation;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public String getPreName() {		return preName;	}
	public void setPreName(String preName) {		this.preName = preName;	}
	public String getOldvalue() {		return oldvalue;	}
	public void setOldvalue(String oldvalue) {		this.oldvalue = oldvalue;	}
	
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="navigation.navigationname",
					message="导航名称不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="navigation.navigationname",
							message = "导航名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") 
			}
		)
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
			navigation.setCreatedate(now);
//			System.out.println(navigation.getNavigationposition());
			
			String aa = navigationService.save(navigation);
			
			this.addActionMessage("导航信息添加成功!");
			
			return SUCCESS;
		}

	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="navigation.navigationname",
					message="导航名称不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="navigation.navigationname",
							message = "导航名称长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "256") 
			}
		)
		/**
		 * 修改
		 */
		public String edit(){
			
			//判断该导航是否已经存在
			boolean isunique = navigationService.isUnique("navigationname",oldvalue, navigation.getNavigationname());
			if(!isunique){
				this.addActionError("该导航已经存在,请勿重复添加!");
				return ERROR;
			}
			Navigation na = new Navigation();
			na = navigationService.get(navigation.getNavigationid());
			na.setNavigationname("11");
			navigationService.update(na);
			
			this.addActionMessage("修改成功");
			
			navigationList = navigationService.getAll();
			
			return SUCCESS;
		}
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			//判断是否有子记录
			List list = navigationService.getList("navigation.navigationid", this.id);
			if(null != list && list.size() > 0){
				this.addActionMessage("该导航下面还有子导航,不能删除!");
//				struts.xwork.chaining.copyMessages();
				return ERROR;
			}
			
			navigationService.delete(id);
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
			Long totalRecords = navigationService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Navigation.class);
			detachedCriteria.addOrder(Order.asc("navigation.navigationid"));
			detachedCriteria.addOrder(Order.asc("orderlist"));
			result = navigationService.findByPager(page, detachedCriteria);
			
			this.navigationList = result.getContent();
			
			return SUCCESS;
			
		}
		
		/**
		 * 查询所有用于页面展示的
		 * @return
		 */
		public String listShow(){
			this.navigationList = navigationService.getTopNavigationList();
			
			return SUCCESS;
		}

		/**
		 * 根据ID查询
		 * @return
		 */
		public String queryById(){
			navigation = navigationService.get(this.id);
			
			navigationList = navigationService.getAll();
			
			return SUCCESS;
		}
	/**
	 * 添加前查询导航信息
	 * @return
	 */
	public String addBef(){
		navigationList = navigationService.getAll();
		
		return SUCCESS;
	}
	
	/**
	 * 根据上级导航的名称查询
	 * @return
	 */
	public String listByPevId(){
		this.navigationList = navigationService.getList("navigation.navigationname", this.preName);
		return SUCCESS;
	}
}
