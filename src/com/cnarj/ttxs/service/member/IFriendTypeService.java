package com.cnarj.ttxs.service.member;


import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.service.IBaseService;

public interface IFriendTypeService extends IBaseService<FriendType,String> {
	
	/**
	 * 修改好友类别
	 * @param type
	 * @param membetid
	 * @return
	 */
	public int updFriendType(FriendType type,String memberid);

	/**
	 * 查找用户 根据用户姓名
	 * @param page
	 * @param xm
	 * @return
	 */
	public Result getMemberList(Page page,String xm);

	/**
	 * 添加默认分类
	 * @param memberid
	 * @return
	 */
	public int addDefualtType(String memberid);
}
