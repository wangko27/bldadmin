package com.cnarj.ttxs.service.imp.member;

import java.sql.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.member.IGoodsRatDao;
import com.cnarj.ttxs.dao.member.IOrderDao;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.shop.GoodsRat;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IGoodsRatService;

public class GoodsRatServiceImpl extends BaseServiceImpl<GoodsRat,String> implements
		IGoodsRatService {

	private IGoodsRatDao goodsratDao;
	private IOrderDao morderDao;
	
	public IOrderDao getMorderDao() {
		return morderDao;
	}

	public void setMorderDao(IOrderDao morderDao) {
		this.morderDao = morderDao;
	}

	public IGoodsRatDao getGoodsratDao() {
		return goodsratDao;
	}

	public void setGoodsratDao(IGoodsRatDao goodsratDao) {
		this.goodsratDao = goodsratDao;
	}

	public void setBaseDao(IGoodsRatDao goodsratDao) {
		super.setBaseDao(goodsratDao);
	}
	
	/**
	 * 保存用户订单对商品的评论
	 * @param goodids 商品id列表
	 * @param contents 评论内容列表
	 * @param isAnonys 是否匿名发表
	 * @param mem
	 */
	public int saveRat(String orderid,List<String> goodids,List<String> contents,String isAnonys,Member mem,String mip){

		Assert.notNull(goodids, "goodids is required");
		Assert.notNull(contents, "contents is required");
		Assert.notNull(mem, "mem is required");
		
		if(goodids.size() != contents.size()){
			return 0;//错误
		}
		
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//处理评论
		GoodsRat rat;
		Goods goo;
		String msg;
		for(int i = 0;i < goodids.size();i++){
			goo = new Goods();
			goo.setGoodsid(goodids.get(i));
			msg = contents.get(i);
			if(null == msg || msg.length() == 0){
				msg = "好评！";
			}
			
			rat = new GoodsRat();
			rat.setCreatedate(now);
			rat.setFlag("1");
			rat.setGood(goo);
			if(null == isAnonys){
				rat.setMember(mem);
				rat.setNikename(mem.getNikename());
			}
			rat.setMemberip(mip);
			rat.setRatmsg(msg);
			
			goodsratDao.save(rat);
			
		}
		
		//处理订单
		Hashtable table = new Hashtable();
		table.put("member.memberid", mem.getMemberid());
		table.put("orderid", orderid);
		
		Orders ord = morderDao.get(table);
		if(null == ord){
			return 0;//错误
		}
		ord.setIsrat("1");
		
		morderDao.update(ord);
		
		return 1;
	}

}
