package com.cnarj.ttxs.admin.service.imp.user;

import java.util.List;

import com.cnarj.ttxs.admin.service.user.IMemberService;
import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 用户频道后台Service实现类 - 会员
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月29日
 */
public class MemberServiceImpl extends BaseServiceImpl<Member, String>
		implements IMemberService {

	MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setBaseDao(MemberDao memberDao) {
		super.setBaseDao(memberDao);
	}

	public List<Member> listMemberByUsername(String username, Long memberType)
			throws Exception {
		return memberDao.listMemberByUsername(username, memberType);
	}

	public List<Member> getList(String propertyName, Object value) {
		return memberDao.getList(propertyName, value);
	}

	public List<Member> listMemberByNikename(String nikename, Long memberType)
			throws Exception {
		return memberDao.listMemberByNikename(nikename, memberType);
	}


}
