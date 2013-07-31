package com.cnarj.ttxs.service.imp.member;


import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.dao.member.IBlogCommentDao;
import com.cnarj.ttxs.dao.member.IBlogDao;
import com.cnarj.ttxs.dao.member.IFriendsInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IBlogService;

/**
 * 空间博文管理业务实现类
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月16日20:40:20
 * 
 */
public class BlogServiceImpl extends BaseServiceImpl<Blog,String> implements IBlogService {

	private IBlogDao blogDao;
	private IFriendsInfoDao friendDao;
	private IActionRecDao actionRecDao;
	private IBlogCommentDao blogCommentDao;
	
	
	public IBlogCommentDao getBlogCommentDao() {
		return blogCommentDao;
	}

	public void setBlogCommentDao(IBlogCommentDao blogCommentDao) {
		this.blogCommentDao = blogCommentDao;
	}

	public IActionRecDao getActionRecDao() {
		return actionRecDao;
	}

	public void setActionRecDao(IActionRecDao actionRecDao) {
		this.actionRecDao = actionRecDao;
	}

	public IFriendsInfoDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(IFriendsInfoDao friendDao) {
		this.friendDao = friendDao;
	}

	public IBlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(IBlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public void setBaseDao(IBlogDao blogDao) {
		super.setBaseDao(blogDao);
	}

	public void updateBlog(Blog blog) {
		//获取原始博文信息
		Blog tempblog = blogDao.get(blog.getBlogid());

		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		tempblog.setModifydate(now);
		tempblog.setBlogtitle(blog.getBlogtitle());
		tempblog.setBlogcontent(blog.getBlogcontent());
		tempblog.setViewperm(blog.getViewperm());
		tempblog.setViewpwd(blog.getViewpwd());
		
		blogDao.update(tempblog);
	}

	public Blog getPre(Blog blog,int type, String memberid) {
		// TODO Auto-generated method stub
		List<String> idlist  = null;
		if(type == 2){
		//1.查询好友列表		
			List<FriendsInfo> friendsList = friendDao.getList("memberByUserid.memberid",memberid);
			
			idlist  = new ArrayList<String>();
			for(FriendsInfo info : friendsList){
				idlist.add(info.getMemberByFrienduserid().getMemberid());
			}
		}
		
		return blogDao.getPre(blog.getCreatedate(), blog.getMember().getMemberid(),type,idlist);
	}

	public boolean isHasPre(Date date, String memberid,int type) {

		List<String> idlist  = null;
		if(type == 2){
		//1.查询好友列表		
			List<FriendsInfo> friendsList = friendDao.getList("memberByUserid.memberid",memberid);
			
			idlist  = new ArrayList<String>();
			for(FriendsInfo info : friendsList){
				idlist.add(info.getMemberByFrienduserid().getMemberid());
			}
		}
		
		return blogDao.isHasPre(date, memberid,type,idlist);
	}

	public Blog getNext(Blog blog,int type, String memberid) {
		// TODO Auto-generated method stub
		List<String> idlist  = null;
		if(type == 2){
		//1.查询好友列表		
			List<FriendsInfo> friendsList = friendDao.getList("memberByUserid.memberid",memberid);
			
			idlist  = new ArrayList<String>();
			for(FriendsInfo info : friendsList){
				idlist.add(info.getMemberByFrienduserid().getMemberid());
			}
		}
		return blogDao.getNext(blog.getCreatedate(),blog.getMember().getMemberid(),type,idlist);
	}

	public boolean isHasNext(Date date, String memberid,int type) {
		// TODO Auto-generated method stub
		List<String> idlist  = null;
		if(type == 2){
		//1.查询好友列表		
			List<FriendsInfo> friendsList = friendDao.getList("memberByUserid.memberid",memberid);
			
			idlist  = new ArrayList<String>();
			for(FriendsInfo info : friendsList){
				idlist.add(info.getMemberByFrienduserid().getMemberid());
			}
		}
		return blogDao.isHasNext(date, memberid,type,idlist);
	}

	public Result getmyblog(Page pager,String memberid){
		// TODO Auto-generated method stub
		return blogDao.getmyblog(pager,memberid);
	}

	public Result getfriendblog(Page pager, String memberid) {
		//1.查询好友列表		
		List<FriendsInfo> friendsList = friendDao.getList("memberByUserid.memberid",memberid);
		if(null == friendsList || friendsList.size() == 0){
			return null;
		}
		List<String> idlist  = new ArrayList<String>();
		for(FriendsInfo info : friendsList){
			idlist.add(info.getMemberByFrienduserid().getMemberid());
		}
		if(null == idlist || idlist.size() == 0){
			return null;
		}
		return blogDao.getMListblog(pager, idlist);
	}

	public Result getallblog(Page pager) {
		
		return blogDao.getAllBelog(pager);
	}

	public void updateReadNum(Blog blog) {
		blogDao.updateReadNum(blog.getBlogid());
	}

	public void updateCommentNum(String blogid) {
		blogDao.updateCommentNum(blogid);
	}


	/**************************他人空间******************************************/
	
	public Result openGetBlogList(Page pager, String memberid, String TTid) {

		//浏览权限List
		List<Long> powerList = new ArrayList<Long>();
		powerList.add(new Long("1"));//所有人可看权限
		powerList.add(new Long("4"));//加密权限 可查看列表
		
		//判断是否是他人好友 他人ID+自己ID
		if(memberid != null && memberid.length() > 0){
			Hashtable table = new Hashtable();
			table.put("memberByUserid.memberid", TTid);
			table.put("memberByFrienduserid.memberid", memberid);
			
			boolean isfri = friendDao.isExist(table);
			if(isfri){
				powerList.add(new Long("2"));//仅好友
			}
		}
		
		
		//查询数据,返回
		return blogDao.openGetBlogList(pager, TTid, powerList);
	}
	
	public Blog opengetBlog(String blogid,String TTid,String memberid,String pwd){
		
		//查询博文信息
		Blog blo = blogDao.get(blogid);
		//浏览权限List
		List<Long> powerList = new ArrayList<Long>();
		powerList.add(new Long("1"));//所有人可看权限
		powerList.add(new Long("4"));//加密权限 可查看列表
		boolean isfri = false;//默认非好友
		

		//判断是否是他人好友 他人ID+自己ID
		if(memberid != null && memberid.length() > 0){
			Hashtable table = new Hashtable();
			table.put("memberByUserid.memberid", TTid);
			table.put("memberByFrienduserid.memberid", memberid);
			
			isfri = friendDao.isExist(table);
			if(isfri){
				powerList.add(new Long("2"));//仅好友
			}
		}
		
		//判断有没有权限
		if(blo.getViewperm() == 2){//仅好友
			
			if(!isfri){//如果非好友
				return null;
			}
		}
		else if(blo.getViewperm() == 3){//仅自己
			return null;
		}
		else if(blo.getViewperm() == 4){//加密
			if(!blo.getViewpwd().equals(pwd)){
				return null;
			}
		}
		
		//判断是否有上一页下一页
		blo.setBlogpre(blogDao.openisHasPre(blo.getCreatedate(), TTid, powerList));
		blo.setBlognext(blogDao.openisHasNext(blo.getCreatedate(), TTid, powerList));
		
		return blo;
	}

	public Blog opengetPre(Blog blog,String TTid,String pwd,String memberid) {
		
		//浏览权限List
		List<Long> powerList = new ArrayList<Long>();
		powerList.add(new Long("1"));//所有人可看权限
		powerList.add(new Long("4"));//加密权限 可查看列表
		
		//判断是否是他人好友 他人ID+自己ID
		if(memberid != null && memberid.length() > 0){
			Hashtable table = new Hashtable();
			table.put("memberByUserid.memberid", TTid);
			table.put("memberByFrienduserid.memberid", memberid);
			
			boolean isfri = friendDao.isExist(table);
			if(isfri){
				powerList.add(new Long("2"));//仅好友
			}
		}
		
		Blog blo = blogDao.opengetPre(blog.getCreatedate(), memberid, powerList);
		
		if(blo.getViewperm() == 4){
			if(!blo.getViewpwd().equals(pwd)){
				return null;
			}
		}
		
		return blo;
	}
	
	public Blog opengerNext(Blog blog,String TTid,String pwd,String memberid){

		//浏览权限List
		List<Long> powerList = new ArrayList<Long>();
		powerList.add(new Long("1"));//所有人可看权限
		powerList.add(new Long("4"));//加密权限 可查看列表
		
		//判断是否是他人好友 他人ID+自己ID
		if(memberid != null && memberid.length() > 0){
			Hashtable table = new Hashtable();
			table.put("memberByUserid.memberid", TTid);
			table.put("memberByFrienduserid.memberid", memberid);
			
			boolean isfri = friendDao.isExist(table);
			if(isfri){
				powerList.add(new Long("2"));//仅好友
			}
		}
		
		Blog blo = blogDao.opengetNext(blog.getCreatedate(), memberid, powerList);

		if(blo.getViewperm() == 4){
			if(!blo.getViewpwd().equals(pwd)){
				return null;
			}
		}
		
		return blo;
	}

	public int delBlog(String blogid,String memberid) {
		//删除博文动作记录
		Hashtable table2 = new Hashtable();
		table2.put("blog.blogid", blogid);
		table2.put("member.memberid", memberid);
		actionRecDao.delete(table2);
		
		//删除博文评论记录
		Hashtable table1 = new Hashtable();
		table1.put("blog.blogid", blogid);
		table1.put("member.memberid", memberid);
		blogCommentDao.delete(table1);
		
		//删除博文
		Hashtable table3 = new Hashtable();
		table3.put("blogid", blogid);
		table3.put("member.memberid", memberid);
		blogDao.delete(table3);
		
		return 0;
	}
}
