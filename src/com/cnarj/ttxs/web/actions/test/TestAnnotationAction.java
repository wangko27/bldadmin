package com.cnarj.ttxs.web.actions.test;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.web.actions.base.BaseAction;

@Validation
/**
 * 示例Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月23日17:03:31
 */
public class TestAnnotationAction extends BaseAction {


	private String userName;
	private String password;
	private Integer age;
	private Date birthday;
	
//	@RequiredStringValidator(message="Supply name") 
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	
//	@RequiredStringValidator(message="Supply password") 
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	
	public Integer getAge() {		return age;	}
	public void setAge(Integer age) {		this.age = age;	}
	
	public Date getBirthday() {		return birthday;	}
	public void setBirthday(Date birthday) {		this.birthday = birthday;	}
	
	/**
	 * 示例
	 * 1. 验证 基于注解的验证示例
	 * @return
	 */
	@Validations( 
			requiredStrings={ 
			@RequiredStringValidator(fieldName="userName",message="用户名不能为空!"), 
			@RequiredStringValidator(fieldName="password",message="密码不能为空!") 
			},
			intRangeFields={
					@IntRangeFieldValidator(fieldName="age",min="1",max="150",message="年龄的范围在1-150岁之内")
			}
			) 
	public String testAnnotationMethod(){
		if(!getUserName().equals("Admin") || !getPassword().equals("Admin")){  
	       addActionError("Invalid user name or password! Please try again!");  
	             
	       return ERROR;  
		      
		}  
		else{  
		       
		 return SUCCESS; 
		}
	}
	
	public String testAA(){
		LogUtil.logger.info("进入的是testAA方法!");
		return SUCCESS;
	}
	
	
}
