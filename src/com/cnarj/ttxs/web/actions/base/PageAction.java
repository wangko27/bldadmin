package com.cnarj.ttxs.web.actions.base;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 分页Action
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public class PageAction extends BaseAction {

	/**
	 * 实例化一个page对象
	 */
	protected Page page = new Page();
	/**
	 * 返回结果的Result对象
	 */
	protected Result result;
	/**
	 * 跳往第几页
	 */
	protected String gotoPage; 
	
	
	
	public PageAction() {

	}
	
	public Result getResult() {		return result;	}
	public void setResult(Result result) {		this.result = result;	}
	public Page getPage() {		return page;	}
	public void setPage(Page page) {		this.page = page;	}
	public String getGotoPage() {		return gotoPage;	}
	public void setGotoPage(String gotoPage) {		this.gotoPage = gotoPage;	}
	
}
