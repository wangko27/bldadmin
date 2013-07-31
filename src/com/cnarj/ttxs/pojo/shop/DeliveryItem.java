package com.cnarj.ttxs.pojo.shop;

import java.util.Date;


/**
 * DeliveryItem entity. @author MyEclipse Persistence Tools
 */

public class DeliveryItem  implements java.io.Serializable {


    // Fields    

     private String deliveryitemid;
     private Shipping shipping;
     private Reship reship;
     private Goods goods;
     private Date createdate;
     private Date modifydate;
     private String productsn;
     private String productname;
     private String producthtmlfilepath;
     private Long deliveryquantity;


    // Constructors

    /** default constructor */
    public DeliveryItem() {
    }

    
    /** full constructor */
    public DeliveryItem(Shipping shipping, Reship reship, Goods goods, Date createdate, Date modifydate, String productsn, String productname, String producthtmlfilepath, Long deliveryquantity) {
        this.shipping = shipping;
        this.reship = reship;
        this.goods = goods;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.productsn = productsn;
        this.productname = productname;
        this.producthtmlfilepath = producthtmlfilepath;
        this.deliveryquantity = deliveryquantity;
    }

   
    // Property accessors

    public String getDeliveryitemid() {
        return this.deliveryitemid;
    }
    
    public void setDeliveryitemid(String deliveryitemid) {
        this.deliveryitemid = deliveryitemid;
    }

    public Shipping getShipping() {
        return this.shipping;
    }
    
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Reship getReship() {
        return this.reship;
    }
    
    public void setReship(Reship reship) {
        this.reship = reship;
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

    public String getProductname() {
        return this.productname;
    }
    
    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducthtmlfilepath() {
        return this.producthtmlfilepath;
    }
    
    public void setProducthtmlfilepath(String producthtmlfilepath) {
        this.producthtmlfilepath = producthtmlfilepath;
    }

    public Long getDeliveryquantity() {
        return this.deliveryquantity;
    }
    
    public void setDeliveryquantity(Long deliveryquantity) {
        this.deliveryquantity = deliveryquantity;
    }
   








}