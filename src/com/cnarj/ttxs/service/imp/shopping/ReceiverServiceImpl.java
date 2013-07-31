package com.cnarj.ttxs.service.imp.shopping;

import java.util.Date;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.shopping.IReceiverDao;
import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.shopping.IReceiverService;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 商城频道后台Service实现类 - 收货地址
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月7日
 */
public class ReceiverServiceImpl extends BaseServiceImpl<Receiver, String>
		implements IReceiverService {

	IReceiverDao receiverDao;

	MemberDao memberDao;

	public IReceiverDao getReceiverDao() {
		return receiverDao;
	}

	public void setReceiverDao(IReceiverDao receiverDao) {
		this.receiverDao = receiverDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void saveReceiver(Receiver receiver) throws Exception {

		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);

		receiver.setMember(member);
		receiver.setCreatedate(new Date());
		receiver.setModifydate(new Date());

		String receiverid = receiverDao.save(receiver);

		receiverDao.updateReceiverByNotDefault(receiverid);
	}

	public void updateReceiverByDefault(String receiverid) throws Exception {
		Receiver receiver = receiverDao.get(receiverid);
		receiver.setIsdefault("1");
		receiver.setModifydate(new Date());
		receiverDao.update(receiver);

		receiverDao.updateReceiverByNotDefault(receiverid);
	}

}
