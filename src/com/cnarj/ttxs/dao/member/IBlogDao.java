package com.cnarj.ttxs.dao.member;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;
/**
 * 空间Dao接口 - 博文
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月28日15:25:24
 */
public interface IBlogDao extends IBaseDao<Blog,String> {

	/**
	 * 查询用户博文信息,根据时间,取上一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public Blog getPre(Date date, String memberid,int type, List<String> memberidList);
	
	/**
	 * 检查是否有上一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public boolean isHasPre(Date date,String memberid,int type, List<String> memberidList);

	/**
	 * 查询用户博文信息,根据时间,取下一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public Blog getNext(Date date, String memberid,int type, List<String> memberidList);
	
	/**
	 * 检查是否有下一篇
	 * @param date
	 * @param memberid
	 * @return
	 */
	public boolean isHasNext(Date date, String memberid,int type, List<String> memberidList);

	/**
	 * 查询用户的博文列表
	 * @param page 分页信息
	 * @param memberid 用户名
	 * @return
	 */
	public Result getmyblog(Page pager,String memberid);

	/**
	 * 查询一组用户博文列表
	 * @param page 分页信息
	 * @param memberidList 用户名列表
	 * @return
	 */
	public Result getMListblog(Page pager, List<String> memberidList);

	/**
	 * 查询所有用户的博文列表 按时间倒序
	 * @param pager
	 * @return
	 */
	public Result getAllBelog(Page pager);
	
	/**
	 * 更新阅读数 +1
	 * @param blogid
	 */
	public void updateReadNum(String blogid);
	
	/**
	 * 增加一个评论数
	 * @param blog
	 */
	public void updateCommentNum(String blogid);
	

	/**************************他人空间******************************************/

	/**
	 * 查询博文列表 他人空间
	 * @param pager 分页
	 * @param memberid 自己ID
	 * @param powerList 查看的权限列表
	 */
	public Result openGetBlogList(Page pager, String memberid, List<Long> powerList);

	/**
	 * 检查是否有上一篇 他人空间
	 * @param date
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public boolean openisHasPre(Date date, String memberid, List<Long> powerList);
	
	/**
	 * 检查是否有下一篇 他人空间
	 * @param date
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public boolean openisHasNext(Date date, String memberid, List<Long> powerList);
	
	/**
	 * 获取上一页 他人空间
	 * @param date
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public Blog opengetPre(Date date, String memberid, List<Long> powerList);
	
	/**
	 * 获取下一页  他人空间
	 * @param date
	 * @param memberid
	 * @param powerList
	 * @return
	 */
	public Blog opengetNext(Date date, String memberid, List<Long> powerList);
}
