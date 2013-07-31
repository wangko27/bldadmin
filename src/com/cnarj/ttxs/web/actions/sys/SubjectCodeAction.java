package com.cnarj.ttxs.web.actions.sys;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.sys.Navigation;
import com.cnarj.ttxs.pojo.sys.SubjectCode;
import com.cnarj.ttxs.service.sys.ISubjectCodeService;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;
import com.cnarj.ttxs.web.actions.base.BaseAction;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * 系统Action类 - 科目
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月23日17:03:31
 */
@Validation
public class SubjectCodeAction extends PageAction{
	
	private ISubjectCodeService subjectCodeService;
	
	private SubjectCode subjectCode;
	private String id;
	
	private List<SubjectCode> subjectCodeList;
	
	
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public ISubjectCodeService getSubjectCodeService() {		return subjectCodeService;	}
	public void setSubjectCodeService(ISubjectCodeService subjectCodeService) {		this.subjectCodeService = subjectCodeService;}
	public SubjectCode getSubjectCode() {		return subjectCode;	}
	public void setSubjectCode(SubjectCode subjectCode) {		this.subjectCode = subjectCode;	}
	public List<SubjectCode> getSubjectCodeList() {		return subjectCodeList;	}
	public void setSubjectCodeList(List<SubjectCode> subjectCodeList) {		this.subjectCodeList = subjectCodeList;}
	
	@Validations( 
		requiredStrings={ 
		@RequiredStringValidator(fieldName="subjectCode.subjectname",
				message="科目名称不能为空!",
				trim = true)
		},
		stringLengthFields = {
				@StringLengthFieldValidator(fieldName="subjectCode.subjectname",
						message = "科目名称长度必须在 ${minLength}-${maxLength}之间",
						shortCircuit = true,
						trim = true, 
						minLength = "1", 
						maxLength = "128") ,
				@StringLengthFieldValidator(fieldName="subjectCode.subjectintro",
						message = "科目说明长度必须在 ${minLength}-${maxLength}之间",
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
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		subjectCode.setCreatedate(now);
		
		String aa = subjectCodeService.save(subjectCode);
		return SUCCESS;
	}

	@Validations( 
		requiredStrings={ 
		@RequiredStringValidator(fieldName="subjectCode.subjectname",
				message="科目名称不能为空!",
				trim = true)
		},
		stringLengthFields = {
				@StringLengthFieldValidator(fieldName="subjectCode.subjectname",
						message = "科目名称长度必须在 ${minLength}-${maxLength}之间",
						shortCircuit = true,
						trim = true, 
						minLength = "1", 
						maxLength = "128") ,
				@StringLengthFieldValidator(fieldName="subjectCode.subjectintro",
						message = "科目说明长度必须在 ${minLength}-${maxLength}之间",
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
		subjectCodeService.update(subjectCode);
		return SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		subjectCodeService.delete(id);
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
		Long totalRecords = subjectCodeService.getTotalCount();  
		
		//创建页面
		page = PageUtil.createPage(page, totalRecords.intValue());  

		
		// 根据位置排序
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubjectCode.class);
		detachedCriteria.addOrder(Order.asc("createdate"));
		result = subjectCodeService.findByPager(page, detachedCriteria);
		
		this.subjectCodeList = result.getContent();
		
		return SUCCESS;
	}
	
	/**
	 * 根据ID查询
	 * @return
	 */
	public String queryById(){
		subjectCode = subjectCodeService.get(this.id);
		
		return SUCCESS;
	}
}
