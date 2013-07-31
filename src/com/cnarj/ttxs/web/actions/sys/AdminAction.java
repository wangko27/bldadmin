package com.cnarj.ttxs.web.actions.sys;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.service.sys.IAdminService;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import java.sql.Date;
import java.util.List;

@Validation
public class AdminAction extends PageAction {

	private IAdminService adminService;
	private Admin admin;
	private List<Admin> adminList;
	private String id;
	private String repwd;

	public IAdminService getAdminService() {		return adminService;	}
	public void setAdminService(IAdminService adminService) {		this.adminService = adminService;	}
	public Admin getAdmin() {		return admin;	}
	public void setAdmin(Admin admin) {		this.admin = admin;	}
	public List<Admin> getAdminList() {		return adminList;	}
	public void setAdminList(List<Admin> adminList) {		this.adminList = adminList;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public String getRepwd() {		return repwd;	}
	public void setRepwd(String repwd) {		this.repwd = repwd;	}
	
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="admin.username",
					message="用户名不能为空!",
					trim = true),
			@RequiredStringValidator(fieldName="admin.adminpassword",
					message="密码不能为空!",
					trim = true)
			},
			stringLengthFields = {
					@StringLengthFieldValidator(fieldName="admin.username",
							message = "用户名长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "1", 
							maxLength = "128") ,
					@StringLengthFieldValidator(fieldName="admin.adminpassword",
							message = "密码长度必须在 ${minLength}-${maxLength}之间",
							shortCircuit = true,
							trim = true, 
							minLength = "6",
							maxLength = "128") 
			}
		)
		/**
		 * 增加
		 */
		public String add(){
//		//1.验证输入的数据
//			String vali = (String)super.getSession("authcode");;
//			String vali_user = (String)super.getParameter("vali_user");
//			if(!vali.equals(vali_user)){
//				this.addActionError("验证码输入错误!");
//				return ERROR;
//			}
			
			if(!admin.getAdminpassword().equals(this.repwd)){
				this.addActionError("两次输入的密码不一致!");
				return ERROR;
			}			
			//2.判断是否已经存在该管理员的信息
			boolean isexist = adminService.isExist("username", admin.getUsername());
			if(isexist){
				this.addActionError("该用户名已经存在!");
				return ERROR;
			}
			
			//3.准备数据,添加管理员
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
			admin.setCreatedate(now);
			
//			MD5 m = new MD5();
//			String str2 = MD5.getMD5ofStr(admin.getAdminpassword());
//			admin.setAdminpassword(str2);
				
			String aa = adminService.save(admin);
			
			this.addActionMessage("管理员添加成功!");
			
			return SUCCESS;
		}

		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			adminService.delete(id);
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
			Long totalRecords = adminService.getTotalCount();  
			
			//创建页面
			page = PageUtil.createPage(page, totalRecords.intValue());  

			
			// 根据位置排序
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Admin.class);
			detachedCriteria.addOrder(Order.asc("createdate"));
			result = adminService.findByPager(page, detachedCriteria);
			
			this.adminList = result.getContent();
			
			return SUCCESS;
		}
		
		/**
		 * 登录
		 * @return
		 */
		public String login(){
			
			return SUCCESS;
		}
	
}
