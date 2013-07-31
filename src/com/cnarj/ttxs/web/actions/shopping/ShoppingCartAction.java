package com.cnarj.ttxs.web.actions.shopping;

import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.shopping.ICartService;
import com.cnarj.ttxs.service.shopping.IGoodsService;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ShoppingCartAction extends PageAction {

	private String goodsId;//商品的id
	private int goodsNum;//商品数量
	private ICartService cartService;
	private IGoodsService goodsService;//商品的信息
	
	private String [] goodsids;
	
	
	public String[] getGoodsids() {
		return goodsids;
	}

	public void setGoodsids(String[] goodsids) {
		this.goodsids = goodsids;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	/**
	 * 添加购物车
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String setCartInfo(){
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){//用户没登录
			
			//update by sly

			return ajaxHtml("请登录!");
			
			/*
			if(null==getSession("carts")){
				List<CarItem> list=new ArrayList<CarItem>();//没有就创建
				CarItem carItem=new CarItem();
				carItem.setCreatedate(new Date());
				carItem.setModifydate(new Date());
				Goods goods=goodsService.get(goodsId);
				carItem.setGoods(goods);//商品
				carItem.setQuantity(new Long(goodsNum));//设置数量
				list.add(carItem);
				setSession("carts",list );
			}else{
				List<CarItem> cartss=(List<CarItem>) getSession("carts");
				boolean isEx=true;
				for(CarItem carts:cartss){
					if(carts.getGoods().getGoodsid().equals(goodsId)){
						//如果已经存在该产品 就数量相加
						int goodsN=carts.getQuantity().intValue();
						goodsN=goodsN+goodsNum;
						carts.setQuantity(new Long(goodsN));
						isEx=false;
						break;
					}
				}
				if(isEx){
					CarItem carItem=new CarItem();
					Goods goods=goodsService.get(goodsId);
					carItem.setGoods(goods);//商品
					carItem.setCreatedate(new Date());//添加时间
					carItem.setQuantity(new Long(goodsNum));//设置数量
					cartss.add(carItem);
				}
				setSession("carts", cartss);//跟新购物车
				
			}
			*/
		}else{//用户登录了
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			List<CarItem> list=null;//得到该用户的所有的商品
			list=cartService.getList("member.memberid", memberid);//得到跟新后的数据
			if(list.size()==0){
				addCart(memberid);
			}else{
				boolean isEx=true;
				for(CarItem item:list){
					if(item.getGoods().getGoodsid().equals(goodsId)){//已经存在该商品了
						updateCart(item);
						isEx=false;
						break;
					}
				}
				if(isEx){
					addCart(memberid);
				}
			}
		}
		return ajaxHtml("添加成功!");
	}
	/**
	 * 添加
	 * @param memberid
	 */
	private void addCart(String memberid){
		CarItem carItem=new CarItem();
		Goods goods=goodsService.get(goodsId);
		Member member=new Member();
		member.setMemberid(memberid);
		carItem.setCreatedate(new Date());
		carItem.setGoods(goods);
		carItem.setMember(member);
		carItem.setModifydate(new Date());
		carItem.setQuantity(new Long(goodsNum));
		cartService.save(carItem);
	}
	/**
	 * 修改
	 * @param item
	 */
	private void updateCart(CarItem item){
		int goodN=item.getQuantity().intValue();
		goodN=goodN+goodsNum;
		item.setQuantity(new Long(goodN));
		item.setModifydate(new Date());
		cartService.update(item);
	}

	/**
	 * 得到购物车的信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getCartInfo(){
		List<CarItem> carlist=null;
		long i=0;
		//如果用户没有登录
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
			carlist=(List<CarItem>) getSession("carts");
			if(carlist==null){
				carlist=new ArrayList<CarItem>();
				setSession("carts", carlist);
			}
		}else{
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			carlist=cartService.getList("member.memberid", memberid);
		}
		//商品总价格
//		for(CarItem carItem:carlist){
//			i=i+carItem.getGoods().getProductprice()*carItem.getQuantity();
//		}
		setAttribute("priceTotal", i);
		setAttribute("cartsInfo", carlist);
		setAttribute("conut", carlist.size());
		return "getSucc";
	}
	@SuppressWarnings("unchecked")
	public String getTotalNum() {
		List<CarItem> carlist=null;
		//如果用户没有登录
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
			carlist=(List<CarItem>) getSession("carts");
		}else{
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			carlist=cartService.getList("member.memberid", memberid);
		}
		
		return ajaxHtml(String.valueOf(carlist.size()));
	}

	/**
	 * 删除
	 */
	@SuppressWarnings("unchecked")
	public String deleteCart(){
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
			List<CarItem> carlist=(List<CarItem>) getSession("carts");
			for(CarItem item:carlist){
				if(item.getGoods().getGoodsid().equals(goodsId)){
					carlist.remove(item);
					break;
				}
			}
			setSession("carts", carlist);
		}else{
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			CarItem carItem=cartService.getMemberGoodsId(goodsId, memberid);
			cartService.delete(carItem);//根据用户名  和 商品id
		}
		getCartInfo();
		return "delSucc";
	}
	/**
	 * 修改购物数量
	 */
	@SuppressWarnings("unchecked")
	public String updateCart(){
		List<CarItem> carlist=null;
		long k=0;//修改单个商品的总价
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){
			carlist=(List<CarItem>) getSession("carts");
			for(CarItem item:carlist){
				if(item.getGoods().getGoodsid().equals(goodsId)){
//					k=goodsNum*item.getGoods().getProductprice();
					item.setQuantity(new Long(goodsNum));
					item.setModifydate(new Date());
					break;
				}
			}
			setSession("carts", carlist);
		}else{
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			CarItem item=cartService.getMemberGoodsId(goodsId,memberid);//用户和商品id
			item.setQuantity(new Long(goodsNum));
			item.setModifydate(new Date());
//			k=goodsNum*item.getGoods().getProductprice();
			cartService.update(item);
			carlist=cartService.getList("member.memberid", memberid);
		}
		//商品总价格
		long i=0;
//		for(CarItem carItem:carlist){
////			i=i+carItem.getGoods().getProductprice()*carItem.getQuantity();
//		}
		return ajaxJson("{i:'"+i+"',k:'"+k+"'}");
	}
	/**
	 * 批量取消购物车
	 */
	@SuppressWarnings("unchecked")
	public String remvoeAllCart(){
		//判断是否登录
		if(null == getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME)){//用户没登录
			if(null!=getSession("carts")){
				//移除购物车
				List<CarItem> cartss=(List<CarItem>) getSession("carts");
				if(cartss.size()>0){
					for(int j=0;j<cartss.size();j++){
						for(int i=0;i<goodsids.length;i++){
							if(cartss.get(j).getGoods().getGoodsid().equals(goodsids[i])){
								cartss.remove(cartss.get(j));
								continue;
							}
						}
					}
				}
				setSession("carts", cartss);//跟新购物车
			}
		}else{//用户登录了
			cartService.delete(goodsids);//移出所选的购物车
			String memberid = HttpUtil.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
			for(String id:goodsids){
				CarItem carItem=cartService.getMemberGoodsId(id, memberid);
				cartService.delete(carItem);//根据用户名  和 商品id
			}
		}
		getCartInfo();
		goodsids=null;
		return "delSucc";
	}
}

