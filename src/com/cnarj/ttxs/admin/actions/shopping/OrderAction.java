package com.cnarj.ttxs.admin.actions.shopping;

import com.cnarj.ttxs.admin.service.shopping.IOrderService;
import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.shop.Orders;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;

/**
 * 商城频道后台Action类 - 订单管理
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年9月14日
 */
public class OrderAction extends PageAction implements ModelDriven<Orders> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IOrderService orderService;

	private Orders orders = new Orders();
    private String id ;

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public Orders getModel() {
		return orders;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
	 * 管理
	 * 
	 * @return
	 */
	public String manage() {

		try {// 设置page参数
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MANAGER);

			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}

			page.setCurrentPage(Integer.parseInt(gotoPage));

			String ordersn = "";
			if (null != getParameter("ordersn")) {
				ordersn = getParameter("ordersn");
			}
			String begindate = "";
			if (null != getParameter("begindate")) {
				begindate = getParameter("begindate");
			}
			String enddate = "";
			if (null != getParameter("enddate")) {
				enddate = getParameter("enddate");
			}
			Long status = null;
			if (null != getParameter("status")
					&& !"".equals(getParameter("status"))) {
				status = new Long(getParameter("status"));
			}

			result = orderService.findOrderByPager(page, ordersn, begindate,
					enddate, status);
			setAttribute("list_order", result.getContent());
			return "manage";
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 发货
	 * 
	 * @return
	 */
	public String shipments() {
		try {
			orderService.updateOrderByShipments(orders);
			this.addActionMessage("发货成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 退款
	 * 
	 * @return
	 */
	public String refund() {
		try {
			orderService.updateOrderByRefund(orders);
			this.addActionMessage("退款成功!");
			return manage();
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

    public String findOrderById(){
        orders =  orderService.findById(id);
        return SUCCESS;
    }

    public String  updateOrder(){
        Orders oldOrder = orderService.findById(orders.getOrderid());
        oldOrder.setModifydate(new Date());
        oldOrder.setShipname(orders.getShipname());
        oldOrder.setShipaddress(orders.getShipaddress());
        oldOrder.setShipzipcode(orders.getShipzipcode());
        oldOrder.setShipphone(orders.getShipphone());
        oldOrder.setShipmobile(orders.getShipmobile());
        oldOrder.setOrdermemo(orders.getOrdermemo());
        orderService.update(oldOrder);
        return SUCCESS;
    }
}
