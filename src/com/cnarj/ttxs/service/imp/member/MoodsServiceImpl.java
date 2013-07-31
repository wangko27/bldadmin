package com.cnarj.ttxs.service.imp.member;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.dao.member.IMoodsDao;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.pojo.stuz.moods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IMoodsService;
import com.cnarj.ttxs.util.BusinessException;

public class MoodsServiceImpl extends BaseServiceImpl<moods,String> implements IMoodsService {

	private IMoodsDao moodsDao;
	private IActionRecDao actionRecDao;
	
	
	public IMoodsDao getMoodsDao() {
		return moodsDao;
	}

	public void setMoodsDao(IMoodsDao moodsDao) {
		this.moodsDao = moodsDao;
		super.setBaseDao(moodsDao);
	}

	public IActionRecDao getActionRecDao() {
		return actionRecDao;
	}

	public void setActionRecDao(IActionRecDao actionRecDao) {
		this.actionRecDao = actionRecDao;
	}

//	public void setBaseDao(IMoodsDao moodsDao) {
//		super.setBaseDao(moodsDao);
//	}

	public Common saveMood(moods mood, Member member) throws BusinessException{
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		//1.保存心情
		String moodId = moodsDao.save(mood);
		
		//2.记录发表心情的动作
		ActionRec actionrec = new ActionRec();
		actionrec.setActiondate(now);
		actionrec.setActionpath1("");
		actionrec.setActiontitle("发表心情：");
		actionrec.setActiontype(new Long(3));
		actionrec.setMood(mood);
		actionrec.setMember(member);
		actionrec.setUsername(member.getNikename());
		String actionRecId = actionRecDao.save(actionrec);
		common.setStr1(moodId);
		common.setStr2(actionRecId);
		return common;
	}
	
	
	/**************************他人空间******************************************/

	public moods getMood(String memberid) {
		
		return moodsDao.getMood(memberid);
	}

	
	public List<moods> getListByMaxResults(String memberid, int length)throws BusinessException{
		if(length <= 0){
			throw new BusinessException("长度必须为大于0的正整数！");
		}
		return moodsDao.getListByMaxResults(memberid, length);
	}
}
