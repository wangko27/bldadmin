package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.service.IBaseService;
import com.cnarj.ttxs.util.BusinessException;

public interface IActionRecService extends IBaseService<ActionRec,String> {

	/**
	 * 查询最新动态50条
	 * @param memberid 
	 * @return
	 */
	public List<ActionRec> openActionList(String memberid);
	
	/**
	 * 获得当前用户好友的动态集合
	 * @param memberId
	 * @return
	 */
	public List<ActionRec> getListByFriend(String memberId, int length)throws BusinessException,Exception;
	
	
	/**
	 * 获得当前用户的动态集合
	 * @param memberId  当前用户id
	 * @param length    条数  为0则查询全部
	 * @return
	 */
	public List<ActionRec> getListByMyself(String memberId, int length)throws BusinessException;
}
