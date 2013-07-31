package com.cnarj.ttxs.service.member;


import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.service.IBaseService;
/**
 * 空间博文管理业务接口类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月16日20:40:20
 * 
 */
public interface IBlogService extends IBaseService<Blog,String> {

	/**
	 * 修改博文
	 * @param blog
	 */
	public void updateBlog(Blog blog);
	
	/**
	 * 查询上一页
	 * @param blog 需要
	 * @return
	 */
	public Blog getPre(Blog blog,int type, String memberid) ;
	

	/**
	 * 检查是否有上一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public boolean isHasPre(Date date,String memberid,int type);
	
	/**
	 * 查询用户博文信息,根据时间,取下一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public Blog getNext(Blog blog,int type, String memberid) ;
	
	/**
	 * 检查是否有下一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public boolean isHasNext(Date date, String memberid,int type);
	
	/**
	 * 查询用户的博文列表
	 * @param memberid
	 * @return
	 */
	public Result getmyblog(Page pager,String memberid);

	/**
	 * 查询用户好友的博文列表
	 * @param memberid
	 * @return
	 */
	public Result getfriendblog(Page pager,String memberid);

	/**
	 * 查询所有用户的博文列表
	 * @param pager
	 * @return
	 */
	public Result getallblog(Page pager);
	/**
	 * 增加一个阅读数
	 * @param blog
	 */
	public void updateReadNum(Blog blog);
	
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String blogid);
	
	/**
	 * 删除博文 指定用户和博文Id 
	 * @param blogid
	 * @return 0 删除失败 1 删除成功
	 */
	public int delBlog(String blogid ,String memberid);
	
	
	/**************************他人空间******************************************/

	/**
	 * 查询博文列表
	 * @param pager 分页
	 * @param memberid 自己ID
	 * @param TTid 要查看的ID
	 */
	public Result openGetBlogList(Page pager,String memberid,String TTid);

	/**
	 * 获取博文详情
	 * @param blogid
	 * @param TTid
	 * @param memberid
	 * @param pwd
	 * @return
	 */
	public Blog opengetBlog(String blogid,String TTid,String memberid,String pwd);
	
	/**
	 * 查询上一页
	 * @param blog
	 * @param TTid
	 * @param pwd
	 * @param memberid
	 * @return
	 */
	public Blog opengetPre(Blog blog,String TTid,String pwd,String memberid);
	
	/**
	 * 查询下一页
	 * @param blog
	 * @param TTid
	 * @param pwd
	 * @param memberid
	 * @return
	 */
	public Blog opengerNext(Blog blog,String TTid,String pwd,String memberid);
}
