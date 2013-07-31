package com.cnarj.ttxs.service.imp.member;


import java.sql.Date;
import java.util.Hashtable;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.member.IFriendTypeDao;
import com.cnarj.ttxs.dao.member.IFriendsInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IFriendsInfoService;

public class FriendsInfoServiceImpl extends BaseServiceImpl<FriendsInfo,String> implements
		IFriendsInfoService {
	private IFriendsInfoDao friendDao;
	private IFriendTypeDao friendTypeDao;
	
	
	public IFriendTypeDao getFriendTypeDao() {
		return friendTypeDao;
	}

	public void setFriendTypeDao(IFriendTypeDao friendTypeDao) {
		this.friendTypeDao = friendTypeDao;
	}

	public IFriendsInfoDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(IFriendsInfoDao friendDao) {
		this.friendDao = friendDao;
	}


	public void setBaseDao(IFriendsInfoDao friendDao) {
		super.setBaseDao(friendDao);
	}


	public int addFriend(Member member,Member friend,FriendType type){
		Assert.notNull(member, "用户对象不能为空");
		Assert.notNull(friend,"好友对象不能为空");
		Assert.notNull(type,"好友所在分类对象不能为空");
		Assert.hasText(type.getFriendtypeid(),"分类对象主键不能为空");
		
		//1 判断该用户是否已经有该好友
		Hashtable table = new Hashtable();
		table.put("memberByUserid.memberid", member.getMemberid());
		table.put("memberByFrienduserid.memberid", friend.getMemberid());
		
		boolean has = friendDao.isExist(table);
		if(has == true){
			return 0;//已经存在该好友
		}
		
		//2 取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//3 添加好友
		FriendsInfo fri = new FriendsInfo();
		fri.setCreatedate(now);
		fri.setFriendtype(type);
		fri.setFriendusername(friend.getUsername());
		fri.setMemberByFrienduserid(friend);
		fri.setMemberByUserid(member);
		
		friendDao.save(fri);
		
		//4 修改分类下好友数量
		//  查询好友分类
		type = friendTypeDao.get(type.getFriendtypeid());
		//  修改好友分类
		type.setFriendnum(type.getFriendnum()+1);
		friendTypeDao.save(type);
		
		return 1;
	}
	
	public void updFriendInType(String friendinfoid,FriendType toType){
		Assert.hasText(friendinfoid,"好友关联Id不能为空");
		Assert.notNull(toType,"好友要修改为分类不能为空");
		
		//1 取当前时间
		Date now = new Date(System.currentTimeMillis());
		//2 取对象
		FriendsInfo info = friendDao.get(friendinfoid);
		
		//修改前后是否未同一个
		if(info.getFriendtype().getFriendtypeid().equals(toType.getFriendtypeid())){
			return;//修改前后是同一个
		}
		
		//3 修改原来分类的好友个数
		FriendType oldtype = info.getFriendtype();
		oldtype.setFriendnum(oldtype.getFriendnum()-1);
		friendTypeDao.update(oldtype);
		
		//4 修改修改后的分类的好友个数
		toType = friendTypeDao.get(toType.getFriendtypeid());
		toType.setFriendnum(toType.getFriendnum()+1);
		friendTypeDao.update(toType);
		
		//5 修改保存
		info.setFriendtype(toType);
		friendDao.update(info);
		
	}
	
	public int delFriend(String friendinfoid,String memberid){
		
		//1. 获取对象
		Hashtable table = new Hashtable();
		table.put("memberByUserid.memberid", memberid);
		table.put("friendsinfoid", friendinfoid);
		
		FriendsInfo info = friendDao.get(table);
		if(null == info){
			return 0;//该用户没有该好友未删除
		}
		
		//2. 修改所在分类的好友数量
		FriendType oldtype = info.getFriendtype();
		oldtype.setFriendnum(oldtype.getFriendnum()-1);
		friendTypeDao.update(oldtype);
		
		//3. 删除好友关系
		friendDao.delete(info);
		return 1;
	}

	public Result getFriendList(Page page,String memberid,String typeid) {

		return friendDao.getFriendList( page, memberid, typeid);
	}
}
