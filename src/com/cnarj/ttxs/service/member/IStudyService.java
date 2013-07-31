package com.cnarj.ttxs.service.member;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.IBaseService;

public interface IStudyService extends IBaseService<ArticleSrc,String> {

	/**
	 * 查询品学论道 
	 * 根据用户ID
	 * @param page
	 * @param values
	 * @return
	 */
	public Result getStudyListByM(Page page, String memberid);
	
	/**
	 * 添加品学论道文章 用户上传
	 * @param title 标题
	 * @param content 内容
	 * @param memberid 用户ID
	 * @return 保存后的主键
	 */
	public String saveStudy(String title,String content,String memberid,Long membertype,ArticleSrc article);
	
	/**
	 * 修改品学论道文章
	 * @param article
	 */
	public void updateStudy(ArticleSrc article);
	
}
