package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.shop.GoodsRat;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

public interface IGoodsRatService extends IBaseService<GoodsRat,String> {

	/**
	 * 保存用户订单对商品的评论
	 * @param goodids 商品id列表
	 * @param contents 评论内容列表
	 * @param isAnonys 是否匿名发表
	 * @param mem
	 */
	public int saveRat(String orderid,List<String> goodids,List<String> contents,String isAnonys,Member mem,String mip);
	
}
