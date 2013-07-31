package com.cnarj.ttxs.service.imp.member;

import com.cnarj.ttxs.dao.member.IMemberAddInfoDao;
import com.cnarj.ttxs.pojo.user.MemberAddInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IMemberAddInfoService;

/**
 * 会员业务接口实现类
 * @author Administrator
 *
 */
public class MemberAddInfoServiceImpl extends BaseServiceImpl<MemberAddInfo, String> implements IMemberAddInfoService{

	private IMemberAddInfoDao memberAddInfoDao;

	public IMemberAddInfoDao getMemberAddInfoDao() {
		return memberAddInfoDao;
	}

	public void setMemberAddInfoDao(IMemberAddInfoDao memberAddInfoDao) {
		this.memberAddInfoDao = memberAddInfoDao;
		super.setBaseDao(memberAddInfoDao);
	}
	
	
	
}
