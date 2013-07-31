package com.cnarj.ttxs.service.member;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

public interface IFriendsInfoService extends IBaseService<FriendsInfo,String> {
	
	/**
	 * 添加好友
	 * @param member 用户对象
	 * @param friend 好友对象 用户Id+用户姓名
	 * @param type 好友要添加到的分组
	 * @return
	 */
	public int addFriend(Member member,Member friend,FriendType type);
	
	/**
	 * 修改好友所在分类
	 * @param friendinfoid 
	 * @param toType
	 * @return
	 */
	public void updFriendInType(String friendinfoid,FriendType toType);
	
	/**
	 * 解除好友关系
	 * @param friendinfoid
	 * @param memberid
	 * @return
	 */
	public int delFriend(String friendinfoid,String memberid);
	
	/**
	 * 查询我的好友
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getFriendList(Page page,String memberid,String typeid);
}
