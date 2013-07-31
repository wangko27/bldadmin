package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;
import com.cnarj.ttxs.util.BusinessException;

public interface IMoodsService extends IBaseService<moods,String> {

	public Common saveMood(moods mood ,Member member)throws BusinessException;
	
	/**
	 * 查用户最新的心情
	 * @param memberid
	 * @return
	 */
	public moods getMood(String memberid);
	
	/**
	 * 根据会员id取前几条数据
	 * @param memberid
	 * @param length
	 * @return
	 */
	public List<moods> getListByMaxResults(String memberid, int length)throws BusinessException;
}
