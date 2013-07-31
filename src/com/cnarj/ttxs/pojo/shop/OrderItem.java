package com.cnarj.ttxs.pojo.shop;

import java.util.Date;


/**
 * OrderItem entity. @author MyEclipse Persistence Tools
 */

public class OrderItem  implements java.io.Serializable {


    // Fields    

     private String orderitemid;
     private Goods goods;
     private Date createdate;
     private Date modifydate;
     private String productsn;
     private String goodsname;
     private Long orderitemprice;
     private String htmlfilepath;
     private Long goodsnum;
     private Long shipnum;
     private Long totalshipnum;

     private Orders order;

    // Constructors

    /** default constructor */
    public OrderItem() {
    }

    
    /** full constructor */
    public OrderItem(Goods goods, Date createdate, Date modifydate, String productsn, 
    		String goodsname, Long orderitemprice, String htmlfilepath, Long goodsnum, 
    		Long shipnum, Long totalshipnum,Orders order) {
        this.goods = goods;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.productsn = productsn;
        this.goodsname = goodsname;
        this.orderitemprice = orderitemprice;
        this.htmlfilepath = htmlfilepath;
        this.goodsnum = goodsnum;
        this.shipnum = shipnum;
        this.totalshipnum = totalshipnum;
        this.order = order;
    }

   
    // Property accessors

    public String getOrderitemid() {
        return this.orderitemid;
    }
    
    public void setOrderitemid(String orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return this.modifydate;
    }
    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getProductsn() {
        return this.productsn;
    }
    
    public void setProductsn(String productsn) {
        this.productsn = productsn;
    }

    public String getGoodsname() {
        return this.goodsname;
    }
    
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Long getOrderitemprice() {
        return this.orderitemprice;
    }
    
    public void setOrderitemprice(Long orderitemprice) {
        this.orderitemprice = orderitemprice;
    }

    public String getHtmlfilepath() {
        return this.htmlfilepath;
    }
    
    public void setHtmlfilepath(String htmlfilepath) {
        this.htmlfilepath = htmlfilepath;
    }

    public Long getGoodsnum() {
        return this.goodsnum;
    }
    
    public void setGoodsnum(Long goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Long getShipnum() {
        return this.shipnum;
    }
    
    public void setShipnum(Long shipnum) {
        this.shipnum = shipnum;
    }

    public Long getTotalshipnum() {
        return this.totalshipnum;
    }
    
    public void setTotalshipnum(Long totalshipnum) {
        this.totalshipnum = totalshipnum;
    }


	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}
   








}