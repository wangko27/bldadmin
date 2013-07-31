package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.stuz.blogcomment;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

public interface IBlogCommentService extends IBaseService<blogcomment,String> {
	
	/**
	 * 查询文章的留言,有序的
	 * @param blogid
	 * @return
	 */
	public List<blogcomment> getListByDate(String blogid) ;
	
	/**
	 * 保存留言,返回相应的HTML
	 * @param blogid 博文ID
	 * @param member 留言用户信息 用户姓名+用户Id 
	 * @return
	 */
	public String saveCommentHtml(String blogid,Member member,String userIp,String comcontent,String fcommentedid);
}
