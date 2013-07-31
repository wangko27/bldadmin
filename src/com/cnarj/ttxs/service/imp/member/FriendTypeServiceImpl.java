package com.cnarj.ttxs.service.imp.member;


import java.sql.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.member.IFriendTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IFriendTypeService;

public class FriendTypeServiceImpl extends BaseServiceImpl<FriendType,String> implements
		IFriendTypeService {

	private IFriendTypeDao friendTypeDao;
	
	public IFriendTypeDao getFriendTypeDao() {
		return friendTypeDao;
	}

	public void setFriendTypeDao(IFriendTypeDao friendTypeDao) {
		this.friendTypeDao = friendTypeDao;
	}

	public void setBaseDao(IFriendTypeDao friendTypeDao) {
		super.setBaseDao(friendTypeDao);
	}

	public int updFriendType(FriendType type,String memberid){
		Assert.notNull(type, "类型对象不能为空");
		Assert.hasText(type.getFriendtypeid(),"类型ID不能为空!");
		Assert.hasText(type.getFriendtypename(),"类型名称不能修改为空!");

		//1 查询分类数据
		Hashtable table = new Hashtable();
		table.put("member.memberid", memberid);
		table.put("friendtypeid", type.getFriendtypeid());
		
		FriendType newtype = friendTypeDao.get(table);
		
		//2 判断是否唯一
		boolean b = friendTypeDao.isUnique("friendtypename", newtype.getFriendtypename(), type.getFriendtypename());
		if(!b){
			return 0;//不唯一
		}
		//3 修改
		newtype.setFriendtypename(type.getFriendtypename());
		friendTypeDao.update(newtype);
		
		
		return 0;
	}

	public Result getMemberList(Page page,String xm){
		// TODO Auto-generated method stub
		return friendTypeDao.getMemberList(page,xm);
	}
	

	/**
	 * 生成默认分类
	 * @param memberid
	 * @return
	 */
	public int addDefualtType(String memberid){
		//1 取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		Member m = new Member();
		m.setMemberid(memberid);
		
		FriendType type = new FriendType();
		type.setCreatedate(now);
		type.setFriendnum(new Long("0"));
		type.setFriendtypename("我的好友");
		type.setIsdefault("1");
		type.setMember(m);
		
		friendTypeDao.save(type);
		
		return 1;
	}
}
