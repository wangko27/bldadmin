package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.stuz.moods;

public interface IMoodsDao extends IBaseDao<moods,String> {


	
	/**
	 * 查用户最新的心情
	 * @param memberid
	 * @return
	 */
	public moods getMood(String memberid);


	/**
	 * 根据会员id去前最新几条心情对象集合--根据创建时间排序
	 * @param memberid
	 * @param length
	 * @return
	 */
	public List<moods> getListByMaxResults(String memberid, int length);
}
