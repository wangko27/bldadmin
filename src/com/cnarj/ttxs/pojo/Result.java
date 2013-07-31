package com.cnarj.ttxs.pojo;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;

/**
 * 实体类 - 返回分页信息和List数据的Pojo
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public class Result {
	private Page page; // 分页信息
	private List content; // 每页显示的集合��ʾ�ļ���

	/**
	 * The default constructor
	 */
	public Result() {
		super();
	}

	/**
	 * The constructor using fields
	 * 
	 * @param page
	 * @param content
	 */
	public Result(Page page, List content) {
		this.page = page;
		this.content = content;
	}

	/**
	 * @return Returns the content.
	 */
	public List getContent() {
		return content;
	}

	/**
	 * @return Returns the page.
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param content
	 *            The content to set.
	 */
	public void setContent(List content) {
		this.content = content;
	}

	/**
	 * @param page
	 *            The page to set.
	 */
	public void setPage(Page page) {
		this.page = page;
	}
}
