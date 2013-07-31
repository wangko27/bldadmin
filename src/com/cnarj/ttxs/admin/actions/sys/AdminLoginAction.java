package com.cnarj.ttxs.admin.actions.sys;

import com.cnarj.ttxs.admin.service.sys.IAdminService;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.util.MD5;
import com.cnarj.ttxs.util.ValidateCode;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 管理员后台Action类 - 管理员登录
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月14日
 */
public class AdminLoginAction extends PageAction implements ModelDriven<Admin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Admin admin = new Admin();

	IAdminService adminService;

	public Admin getModel() {
		return admin;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

    public static void main(String [] args){
        MD5 m = new MD5();
        String str1 = MD5.getMD5ofStr("lizhou");
        String str2 = MD5.getMD5ofStr("1");
        System.out.println(str1+","+str2);
    }

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		try {
			String sessionValidateCode = (String) getRequest().getSession()
					.getAttribute(ValidateCode.IMAGE_VALIDATE_KEY);// 验证码
			String adminvalidate = getParameter("adminvalidate");// 验证码
//			if ((sessionValidateCode != null && adminvalidate != null)
//					&& sessionValidateCode.equals(adminvalidate)) {
//                MD5 m = new MD5();
//                String str2 = MD5.getMD5ofStr(admin.getAdminpassword());
//                admin.setAdminpassword(str2);
				Admin adminNew = adminService.login(admin.getUsername(), admin
						.getAdminpassword());
				if (null == adminNew) {
					this.addActionMessage("用户名或密码错误!");
					return "adminLogin";
				} else {
					if (adminNew.getIsaccountenabled().equals("0")) {// 是否启用
						this.addActionMessage("该账号未启用!");
						return "adminLogin";
					} else if (adminNew.getIsaccountexpired().equals("0")) {// 账号是否过期
						this.addActionMessage("该账号已过期!");
						return "adminLogin";
					} else if (adminNew.getIsaccountlocked().equals("0")) {// 账号是否锁定
						this.addActionMessage("该账号已锁定!");
						return "adminLogin";
					} else if (adminNew.getIscredentialsexpired().equals("0")) {// 凭证是否过期
						this.addActionMessage("该账号凭证已过期!");
						return "adminLogin";
					} else {
						setSession("admin", adminNew);
						return "index";
					}

				}
//			} else {
//				this.addActionMessage("验证码输入错误!");
//				return "adminLogin";
//			}
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public String logout() {
		try {
			getRequest().getSession().removeAttribute("admin");
			getResponse().getWriter().print(
					"<script>window.parent.parent.location.href='"
							+ getRequest().getContextPath()
							+ "/adminLogin.jsp'</script>");
			getResponse().getWriter().close();
			return "adminLogin";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

}
