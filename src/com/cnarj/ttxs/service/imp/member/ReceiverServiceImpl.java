package com.cnarj.ttxs.service.imp.member;

import java.util.Hashtable;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.member.IReceiverDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Receiver;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IReceiverService;

public class ReceiverServiceImpl extends BaseServiceImpl<Receiver,String> implements
		IReceiverService {

	private IReceiverDao receiverDao;
	
	
	public IReceiverDao getReceiverDao() {
		return receiverDao;
	}
	public void setReceiverDao(IReceiverDao receiverDao) {
		this.receiverDao = receiverDao;
	}
	public void setBaseDao(IReceiverDao receiverDao) {
		super.setBaseDao(receiverDao);
	}
	
	/**
	 * 删除收货地址
	 * @param receiverid 收货地址ID
	 * @param memberid 用户ID
	 */
	public void delReceiver(String receiverid,String memberid){
		Assert.hasText(receiverid,"收货地址ID不能为空");
		Assert.hasText(memberid,"用户ID不能为空");
		
		Hashtable table = new Hashtable();
		table.put("receiverid", receiverid);
		table.put("member.memberid", memberid);
		
		receiverDao.delete(table);
	}

	/**
	 * 修改收货地址
	 * @param rec
	 * @param memberid
	 * @throws Exception
	 */
	public int updReceiver(Receiver rec, String memberid) throws Exception {
		//查询数据
		Receiver old = new Receiver();
		Hashtable table = new Hashtable();
		table.put("receiverid", rec.getReceiverid());
		table.put("member.memberid", memberid);
		
		old = receiverDao.get(table);
		
		
		//判断是否已存在
		Hashtable oldtable = new Hashtable();
		Hashtable newtable = new Hashtable();
		oldtable.put("member.memberid", memberid);
		oldtable.put("areapath", old.getAreapath());
		oldtable.put("receiveraddress", old.getReceiveraddress());

		newtable.put("member.memberid", memberid);
		newtable.put("areapath", rec.getAreapath());
		newtable.put("receiveraddress", rec.getReceiveraddress());
		
		boolean isu = receiverDao.isUnique(oldtable, newtable);
		if(isu == false){
			return 0;//不唯一
		}
		
		//修改
		old.setAreapath(rec.getAreapath());
		old.setReceiveraddress(rec.getReceiveraddress());
		receiverDao.update(old);
		
		return 1;
	}
}
