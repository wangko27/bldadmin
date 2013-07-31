package com.cnarj.ttxs.web.actions.member;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.shop.CarItem;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.ICarItemService;
import com.cnarj.ttxs.service.member.IGoodsRatService;
import com.cnarj.ttxs.service.member.IOrderService;
import com.cnarj.ttxs.web.actions.base.PageAction;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 用户Action类 - 购物管理 购物车 订单
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class ShopAction extends PageAction {

	private ICarItemService carItemService;
	private IOrderService morderService;
	private IGoodsRatService goodsratService;
	
	private String memberid;
	private List<CarItem> carItemList;
	private Long totalPrice;
	
	private List<Orders> orderList;
	private Long totalOrderPrice;
	private String orderstatuStr;
	private String orderid;
	private Orders myorder;
	
	private List<String> goodids;//订单评价时商品id，可能多个
	private String isAnonys;//是否匿名提交评论
	private List<String> ratcotents;//评论内容 可能多个
	private String cartitemid;//购物车项ID，删除时用
	
	
	
	public String getCartitemid() {		return cartitemid;	}
	public void setCartitemid(String cartitemid) {		this.cartitemid = cartitemid;	}
	public List<String> getGoodids() {		return goodids;	}
	public void setGoodids(List<String> goodids) {		this.goodids = goodids;	}
	public String getIsAnonys() {		return isAnonys;	}
	public void setIsAnonys(String isAnonys) {		this.isAnonys = isAnonys;	}
	public List<String> getRatcotents() {		return ratcotents;	}
	public void setRatcotents(List<String> ratcotents) {		this.ratcotents = ratcotents;	}
	public IGoodsRatService getGoodsratService() {		return goodsratService;	}
	public void setGoodsratService(IGoodsRatService goodsratService) {		this.goodsratService = goodsratService;	}
	public Orders getMyorder() {		return myorder;	}
	public void setMyorder(Orders myorder) {		this.myorder = myorder;	}
	public String getOrderid() {		return orderid;	}
	public void setOrderid(String orderid) {		this.orderid = orderid;	}
	public String getOrderstatuStr() {		return orderstatuStr;	}
	public void setOrderstatuStr(String orderstatuStr) {		this.orderstatuStr = orderstatuStr;	}
	public Long getTotalOrderPrice() {		return totalOrderPrice;	}
	public void setTotalOrderPrice(Long totalOrderPrice) {		this.totalOrderPrice = totalOrderPrice;	}
	public List<Orders> getOrderList() {		return orderList;	}
	public void setOrderList(List<Orders> orderList) {		this.orderList = orderList;	}
	public IOrderService getMorderService() {		return morderService;	}
	public void setMorderService(IOrderService morderService) {		this.morderService = morderService;	}
	public Long getTotalPrice() {		return totalPrice;	}
	public void setTotalPrice(Long totalPrice) {		this.totalPrice = totalPrice;	}
	public ICarItemService getCarItemService() {		return carItemService;	}
	public void setCarItemService(ICarItemService carItemService) {		this.carItemService = carItemService;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public List<CarItem> getCarItemList() {		return carItemList;	}
	public void setCarItemList(List<CarItem> carItemList) {		this.carItemList = carItemList;	}

	/**
	 * 查询购物车数据
	 * @return
	 */
	public String listCarItem(){
		try{
			
			carItemList = carItemService.getList("member.memberid",memberid);
		
			//计算总价
			totalPrice = new Long("0");
//			for(CarItem c : carItemList){
//				totalPrice += c.getGoods().getProductprice()*c.getQuantity();
//			}
			//批量时的商品ID字符串
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除购物车中的物品
	 * @return
	 */
	public String delCarItem(){
		try{
			Hashtable table = new Hashtable();
			table.put("member.memberid",memberid);
			table.put("cartitemid", cartitemid);
			carItemService.delete(table);
			this.addActionMessage("删除成功！");
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败！");
			return ERROR;
		}
	}
	
	
	/**
	 * 查询会员的订单(所有，或指定状态) 分页 倒序（按时间）
	 * @return
	 */
	public String listOrder(){
		try{

			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_ORDER);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			List<Long> list = new ArrayList<Long>();
			if(orderstatuStr != null && orderstatuStr.length() > 0){
				String[] strList = this.orderstatuStr.split(",");
				
				for(String s : strList){
					list.add(new Long(s));
				}
			}
			
			result = morderService.getOrderList(page, memberid, list);
			orderList = result.getContent();

			//计算订单总价
			this.totalOrderPrice = new Long("0");
			for(Orders o : orderList){
				totalOrderPrice = totalOrderPrice + o.getTotalamount();
			}
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 取消订单
	 * @return
	 */
	public String cancelOrder(){
		try{
			int re = morderService.updateOrder(memberid, orderid, new Long("5"));
			if(re == 0){
				this.addActionMessage("订单不存在！");
				return ERROR;
			}
			else{
				this.addActionMessage("订单已取消！");
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	public void validateCancelOrder() {
		if(null == orderid || orderid.length() == 0){
			this.addActionError("错误!!");
		}
	}
	
	/**
	 * 确认收货
	 * @return
	 */
	public String getGoodsOk(){
		try{
			//交易成功
			int re = morderService.updateOrder(memberid, orderid, new Long("1"));
			if(re == 0){
				this.addActionMessage("订单不存在！");
				return ERROR;
			}
			else{
				this.addActionMessage("订单交易成功！");
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	public void validateGetGoodsOk() {
		if(null == orderid || orderid.length() == 0){
			this.addActionError("错误!!");
		}
	}

	/**
	 * 查看订单详情 (或跳转到评论处、或订单详情处)
	 * @return
	 */
	public String getOrder(){
		try{
			Hashtable table = new Hashtable();
			table.put("member.memberid", this.memberid);
			table.put("orderid", this.orderid);
			
			this.myorder = morderService.get(table);

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	public void validateGetOrder() {
		if(null == orderid || orderid.length() == 0){
			this.addActionError("错误!!");
		}
	}
	
	/**
	 * 评论商品
	 * @return
	 */
	public String ratGoods(){
		try{
			Member m = new Member();
			m.setMemberid(this.memberid);
			m.setNikename((String)super.getSession(Member.LOGIN_MEMBER_NIKENAME));
			
			String mip = super.getRequest().getRemoteAddr();
			
			int res = goodsratService.saveRat(orderid, goodids, this.ratcotents, isAnonys, m, mip);
			
			if(res == 0){
				this.addActionMessage("错误，评论失败！");
				return ERROR;
			}
			this.addActionMessage("成功评论！");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
}
