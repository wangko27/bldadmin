package com.cnarj.ttxs.service.imp.member;


import java.util.List;

import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IActionRecService;
import com.cnarj.ttxs.util.BusinessException;

public class ActionRecServiceImpl extends BaseServiceImpl<ActionRec,String> implements
		IActionRecService {

	private IActionRecDao actionRecDao;
	
	public IActionRecDao getActionRecDao() {
		return actionRecDao;
	}

	public void setActionRecDao(IActionRecDao actionRecDao) {
		this.actionRecDao = actionRecDao;
	}

	public void setBaseDao(IActionRecDao actionRecDao) {
		super.setBaseDao(actionRecDao);
	}

	
	public List<ActionRec> openActionList(String memberid){
		return actionRecDao.openActionList(memberid);
	}
	
	public List<ActionRec> getListByFriend(String memberId, int length)
			throws BusinessException,Exception {
		return actionRecDao.getListByFriend(memberId, length);
	}

	
	public List<ActionRec> getListByMyself(String memberId, int length)
			throws BusinessException {
		return actionRecDao.getListByMyself(memberId, length);
	}
	
	
}
