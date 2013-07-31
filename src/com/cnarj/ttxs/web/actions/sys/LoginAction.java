package com.cnarj.ttxs.web.actions.sys;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.comm.ExceptionBasicSet;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.pojo.user.MemberAddInfo;
import com.cnarj.ttxs.service.MemberService;
import com.cnarj.ttxs.service.member.IAlbumsService;
import com.cnarj.ttxs.service.member.IFriendTypeService;
import com.cnarj.ttxs.service.member.IMemberAddInfoService;
import com.cnarj.ttxs.service.shopping.ICartService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.MD5;
import com.cnarj.ttxs.util.MailUtil;
import com.cnarj.ttxs.util.Pubfun;
import com.cnarj.ttxs.util.ValidateCode;
import com.cnarj.ttxs.util.ValidateUtil;
import com.cnarj.ttxs.web.actions.base.BaseAction;

import org.apache.commons.lang.StringUtils;
/**
 * 登录action
 * @author hedan
 *
 */
public class LoginAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3591234249591432083L;

	private MemberService memberService;
	
	private ICartService cartService;
	
	private IGoodsService goodsService;//商品的信息
	
	private IAlbumsService albumsService;
	
	private IFriendTypeService friendTypeService;
	
	private IMemberAddInfoService memberAddInfoService;
	
	private String telephone;//电话号码
	
	private String memberType;//会员类型
	
	private Member member = new Member();
	
	private String registerEmail;//注册邮箱
	
	private String loginPassword;//登录密码
	
	private String nikename;//昵称
	
	private String validatecode;//六位数字的验证码
	
	private String identity;//游客身份
	

	/**
	 * Ajax会员登录验证
	 */ 
	
	@SuppressWarnings("unchecked")
	public String ajaxLogin()throws Exception{
		try {
			
			if(memberType != null && !"".equals(memberType)){
				
				//学生登录
				if(memberType.equals("1")){
					member.setUsername(StringUtils.trimToNull(getParameter("stuUsername")));
					member.setMemberpassword(StringUtils.trimToNull(getParameter("stuPassword")));
					member.setMemberType(new Long(1));
					
					String validateId = (String)getSession(ValidateCode.IMAGE_VALIDATE_KEY);//保存在session中的验证码
					String validateRequestId = getParameter("stuValidate");//从表单中提交过来的验证码
					if(StringUtils.isEmpty(validateRequestId )|| !validateRequestId.equals(validateId)){
						return ajaxJsonErrorMessage("验证码输入错误！");
					}
				}
				//家长登录
				if(memberType.equals("2")){
					member.setUsername(StringUtils.trimToNull(getParameter("parentUsername")));
					member.setMemberpassword(StringUtils.trimToNull(getParameter("parentPassword")));
					member.setMemberType(new Long(2));
					
					String validateId = (String)getSession(ValidateCode.IMAGE_VALIDATE_KEY);//保存在session中的验证码
					String validateRequestId = getParameter("parentValidate");//从表单中提交过来的验证码
					if(StringUtils.isEmpty(validateRequestId )|| !validateRequestId.equals(validateId)){
						return ajaxJsonErrorMessage("验证码输入错误！");
					}
				}
				//老师登录
				if(memberType.equals("3")){
					member.setUsername(StringUtils.trimToNull(getParameter("teacherUsername")));
					member.setMemberpassword(StringUtils.trimToNull(getParameter("teacherPassword")));
					member.setMemberType(new Long(3));
					
					String validateId = (String)getSession(ValidateCode.IMAGE_VALIDATE_KEY);//保存在session中的验证码
					String validateRequestId = getParameter("teacherValidate");//从表单中提交过来的验证码
					if(StringUtils.isEmpty(validateRequestId )|| !validateRequestId.equals(validateId)){
						return ajaxJsonErrorMessage("验证码输入错误！");
					}
				}
				//本站注册会员登录
				if(memberType.equals("4")){
					member.setUsername(StringUtils.trimToNull(getParameter("touristUsername")));
					member.setMemberpassword(StringUtils.trimToNull(getParameter("touristPassword")));
					member.setMemberType(new Long(4));
					
					String validateId = (String)getSession(ValidateCode.IMAGE_VALIDATE_KEY);//保存在session中的验证码
					String validateRequestId = getParameter("touristValidate");//从表单中提交过来的验证码
					if(StringUtils.isEmpty(validateRequestId )|| !validateRequestId.equals(validateId)){
						return ajaxJsonErrorMessage("验证码输入错误！");
					}
				}
			}
			
			member.setLoginip(getRequest().getRemoteAddr());//设置登录id
			member.setLogindate(new Date());
			Common common  = memberService.loginMember(member);
			Member l_member = (Member)common.getObj();
			if(common.isStatus()){
				setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME, l_member.getMemberid());//写入session
				setSession(Member.LOGIN_MEMBER_USERNAME_COOKIE_NAME, l_member.getUsername());//写入session
				setSession(Member.LOGIN_MEMBER_TYPE, l_member.getMemberType());
				setSession(Member.LOGIN_MEMBER_SESSION_XXID, l_member.getXxid());//将会员所属学校id写入session
				setSession(Member.LOGIN_MEMBER_SESSION_DSISUSERID, l_member.getDsisuserid());
				setSession(Member.LOGIN_MEMBER_HEADPATH, l_member.getHeadpath());
				setSession(Member.LOGIN_MEMBER_NIKENAME, l_member.getNikename());
				setSession(Member.LOGIN_MEMBER_POINT, l_member.getMemberpoint());
				setSession(Member.LOGIN_MEMBER_EMAIL, l_member.getEmail());
				///加入购物车
				if(null!=getSession("carts")){//是否存在该购物车
					List<CarItem> catList=(List<CarItem>) getSession("carts");
						List<CarItem> list=cartService.getList("member.memberid", HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString());//得到该用户的所有的商品
						for(CarItem car:catList){
							for(CarItem carItem:list){
								if(car.getGoods().getGoodsid().equals(carItem.getGoods().getGoodsid())){//已经存在该商品了
									int goodN=carItem.getQuantity().intValue();
									goodN=goodN+car.getQuantity().intValue();
									carItem.setQuantity(new Long(goodN));
									carItem.setModifydate(new Date());
									cartService.update(carItem);
									continue;
								}else{//不存在商品
									CarItem carIt=new CarItem();
									Goods goods=goodsService.get(car.getGoods().getGoodsid());
									Member member=new Member();
									member.setMemberid(HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString());
									carIt.setCreatedate(new Date());
									carIt.setGoods(goods);
									carIt.setMember(member);
									carIt.setModifydate(new Date());
									carIt.setQuantity(new Long(car.getQuantity()));
									cartService.save(carIt);
									continue;
								}
							}
						}
					getRequest().getSession().removeAttribute("carts");//移除购物车
				}
				return ajaxJsonSuccessMessage("会员登录成功！");
				
			}else{
				return ajaxJsonErrorMessage(common.getMessage());
			}
		} catch (Exception e) {
			return ajaxJsonErrorMessage("登录失败！请与管理员联系！");
		}
	}
	
	
	
	/**
	 * 退出
	 * @return
	 * @throws Exception
	 */
	public String loginout()throws Exception{
		try {
			getSession().remove(Member.LOGIN_MEMBER_ID_SESSION_NAME);//写入session
			getSession().remove(Member.LOGIN_MEMBER_USERNAME_COOKIE_NAME);//写入session
			getSession().remove(Member.LOGIN_MEMBER_TYPE);
			getSession().remove(Member.LOGIN_MEMBER_SESSION_XXID);//将会员所属学校id写入session
			getSession().remove(Member.LOGIN_MEMBER_SESSION_DSISUSERID);
			getSession().remove(Member.LOGIN_MEMBER_HEADPATH);
			getSession().remove(Member.LOGIN_MEMBER_NIKENAME);
			getSession().remove(Member.LOGIN_MEMBER_POINT);
			getSession().clear();
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 找回密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toRetrievepassword() throws Exception {
		try {
			String username = getParameter("username");
			String email = getParameter("email");
			// 判断用户名是否存在
			Member memberNew = memberService.get("username", username);
			if (null == memberNew) {
				this.addActionError("该用户不存在!");
				return "retrievePassword";
			} else if (!email.equals(memberNew.getEmail())) {
				this.addActionError("用户名与邮箱不匹配!");
				return "retrievePassword";
			} else {
				// 判断用户名和邮箱是否匹配
				// 生成新密码
				String newpassword = Pubfun.getRandomNumber(8);
				// 更改数据库密码
				memberService.updatePwd(memberNew.getMemberid(), MD5
						.getMD5ofStr(newpassword));
				// 发送新密码
				StringBuffer content = new StringBuffer("");
				content.append("亲爱的" + username + ":<br/>").append(
						"您好！您在爱瑞杰旗下天天向上网站的密码已变更。<br/>").append(
						"您的新密码是：" + newpassword + " 请返回登录页面登录网站。<br/>").append(
						"感谢您的使用<br/>").append(" 如有疑问，请致电 952116 全国统一客服电话.谢谢！");
				MailUtil.sendMail("您在天天向上通过找回密码生成的新密码(系统邮件，请勿回复)", content
						.toString(), "text/html;charset=gbk;", email);// 发送验证码到指定邮件
				return "retrieveSuccess";
			}
		} catch (Exception e) {
			setAttribute(
					ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e
							.toString());
			return ERROR;
		}
	}
	

	/**
	 * 会员注册 第一步--发送验证码到电子邮件
	 * @return
	 * @throws Exception
	 */
	public String registerStepOne()throws Exception{
		try {
			if(registerEmail == null || "".equals(registerEmail)){
				addActionError("邮箱不能为空！");
				return "actionError";
			}
			String autoKey = ValidateUtil.getRandSixKey();
			StringBuffer content = new StringBuffer("");
			content.append("亲爱的"+registerEmail.substring(0, registerEmail.indexOf("@"))+":<br/>")
			.append("您好！欢迎您注册爱瑞杰旗下天天向上网站。<br/>")
			.append("您的注册码是："+autoKey+" 请返回注册页面继续注册。<br/>")
			.append("感谢您的使用<br/>")
			.append(" 如有疑问，请致电 952116 全国统一客服电话.谢谢！");
			MailUtil.sendMail("天天向上邮箱验证(系统邮件，请勿回复)", content.toString(), "text/html;charset=gbk;",registerEmail);//发送验证码到指定邮件
			setSession(ValidateUtil.VALIDATE_SESSION_KEY, autoKey);
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 注册 第二步---填写用户名和密码
	 * @return
	 * @throws Exception
	 */
	public String registerStepTwo()throws Exception{
		try {
			String autoKey = getSession(ValidateUtil.VALIDATE_SESSION_KEY) == null ? "" : getSession(ValidateUtil.VALIDATE_SESSION_KEY).toString();
			String l_password = loginPassword;
			if(!"".equals(autoKey) && !"".equals(validatecode) && autoKey.equals(validatecode.trim())){
				//验证账户名是否已经存在
				boolean flag = memberService.isExist("username", registerEmail);
				if(flag){
					addActionError("对不起，账户名已存在！请重新输入邮件！");
					return "regError";
				}else{
					member.setUsername(registerEmail);
					member.setEmail(registerEmail);
					loginPassword = MD5.getMD5ofStr(loginPassword);
					member.setMemberpassword(loginPassword);
					member.setMemberType(Long.valueOf(4));
					member.setCreatedate(new Date());
					member.setNikename(nikename);
					member.setRegistip(getRequest().getRemoteAddr());
					member.setIsaccountenabled("1");
					member.setIsaccountlocked("1");
					member.setMobilephone(telephone);
					member.setMemberpoint(Long.valueOf(20));
					String l_memberId = memberService.save(member);
					if(l_memberId != null){
						albumsService.saveAlbumDefault(l_memberId);
						friendTypeService.addDefualtType(l_memberId);
						setAttribute("memberId", l_memberId);
						setAttribute("username", member.getUsername());
						setAttribute("password", l_password);
					}
				}
			}else{
				addActionError("对不起，验证码错误！");
				return "regError";
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 会员注册 第三步 -- 补充会员资料
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		MemberAddInfo memberAddInfo = null;
		try {
			//学生更新资料
			if(identity.equals("1")){
				memberAddInfo = new MemberAddInfo();
				memberAddInfo.setMember(member);
				member.setMemberAddInfo(memberAddInfo);
				memberAddInfo.setRealname(getParameter("realname"));
				memberAddInfo.setSex(getParameter("sex"));
				memberAddInfo.setInaddr(getParameter("inaddr"));
				memberAddInfo.setSchool(getParameter("stuschool"));
				memberAddInfo.setGrade(getParameter("stugrade"));
				memberAddInfo.setClasses(getParameter("stuclasses"));
				memberAddInfo.setIdentity("学生");
				memberAddInfoService.save(memberAddInfo);
			}
			if(identity.equals("2")){
				memberAddInfo = new MemberAddInfo();
				memberAddInfo.setMember(member);
				member.setMemberAddInfo(memberAddInfo);
				memberAddInfo.setRealname(getParameter("realname"));
				memberAddInfo.setSex(getParameter("sex"));
				memberAddInfo.setInaddr(getParameter("inaddr"));
				memberAddInfo.setChildname(getParameter("childname"));
				memberAddInfo.setSchool(getParameter("parentshool"));
				memberAddInfo.setGrade(getParameter("parentgrade"));
				memberAddInfo.setClasses(getParameter("parentclasses"));
				memberAddInfo.setIdentity("家长");
				memberAddInfoService.save(memberAddInfo);
			}
			if(identity.equals("3")){
				memberAddInfo = new MemberAddInfo();
				memberAddInfo.setMember(member);
				member.setMemberAddInfo(memberAddInfo);
				memberAddInfo.setRealname(getParameter("realname"));
				memberAddInfo.setSex(getParameter("sex"));
				memberAddInfo.setInaddr(getParameter("inaddr"));
				memberAddInfo.setSchool(getParameter("teacherschool"));
				memberAddInfo.setGrade(getParameter("teachergrade"));
				memberAddInfo.setClasses(getParameter("teacherclasses"));
				memberAddInfo.setIdentity("老师");
				memberAddInfoService.save(memberAddInfo);
			}
			if(identity.equals("4")){
				memberAddInfo = new MemberAddInfo();
				memberAddInfo.setMember(member);
				member.setMemberAddInfo(memberAddInfo);
				memberAddInfo.setRealname(getParameter("realname"));
				memberAddInfo.setSex(getParameter("sex"));
				memberAddInfo.setInaddr(getParameter("inaddr"));
				memberAddInfo.setIdentity("其他");
				memberAddInfoService.save(memberAddInfo);
			}
			
			//注册成功后进行登录
			member.setMemberType(Long.valueOf(4));
			member.setLoginip(getRequest().getRemoteAddr());//设置登录id
			member.setLogindate(new Date());
			Common common  = memberService.loginMember(member);
			Member l_member = (Member)common.getObj();
			if(common.isStatus()){
				setSession(Member.LOGIN_MEMBER_ID_SESSION_NAME, l_member.getMemberid());//写入session
				setSession(Member.LOGIN_MEMBER_USERNAME_COOKIE_NAME, l_member.getUsername());//写入session
				setSession(Member.LOGIN_MEMBER_TYPE, l_member.getMemberType());
				setSession(Member.LOGIN_MEMBER_SESSION_XXID, l_member.getXxid());//将会员所属学校id写入session
				setSession(Member.LOGIN_MEMBER_SESSION_DSISUSERID, l_member.getDsisuserid());
				setSession(Member.LOGIN_MEMBER_HEADPATH, l_member.getHeadpath());
				setSession(Member.LOGIN_MEMBER_NIKENAME, l_member.getNikename());
				setSession(Member.LOGIN_MEMBER_POINT, l_member.getMemberpoint());
				setAttribute("memberid", l_member.getMemberid());
				return SUCCESS;
				
			}else{
				setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME,common.getMessage());
				return ERROR;
			}
		} catch (Exception e) {
			setAttribute(ExceptionBasicSet.REQUEST_SET_ATTRIBUTE_EXCEPTION_NAME, e.toString());
			return ERROR;
		}
	}
	
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public IAlbumsService getAlbumsService() {
		return albumsService;
	}

	public void setAlbumsService(IAlbumsService albumsService) {
		this.albumsService = albumsService;
	}

	public IFriendTypeService getFriendTypeService() {
		return friendTypeService;
	}

	public void setFriendTypeService(IFriendTypeService friendTypeService) {
		this.friendTypeService = friendTypeService;
	}

	public IMemberAddInfoService getMemberAddInfoService() {
		return memberAddInfoService;
	}

	public void setMemberAddInfoService(IMemberAddInfoService memberAddInfoService) {
		this.memberAddInfoService = memberAddInfoService;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getValidatecode() {
		return validatecode;
	}

	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
	
}
