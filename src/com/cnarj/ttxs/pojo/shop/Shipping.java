package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Shipping entity. @author MyEclipse Persistence Tools
 */

public class Shipping  implements java.io.Serializable {


    // Fields    

     private String shippingid;
     private DeliveryType deliveryType;
     private Orders orders;
     private Date createdate;
     private Date modifydate;
     private String shippingsn;
     private String deliverytypename;
     private String deliverycorpname;
     private String deliverysn;
     private Long deliveryfee;
     private String shipname;
     private String shiparea;
     private String shipareapath;
     private String shipaddress;
     private String shipzipcode;
     private String shipphone;
     private String shipmobile;
     private String shippingmemo;
     private Set deliveryItems = new HashSet(0);


    // Constructors

    /** default constructor */
    public Shipping() {
    }

    
    /** full constructor */
    public Shipping(DeliveryType deliveryType, Orders orders, Date createdate, Date modifydate, String shippingsn, String deliverytypename, String deliverycorpname, String deliverysn, Long deliveryfee, String shipname, String shiparea, String shipareapath, String shipaddress, String shipzipcode, String shipphone, String shipmobile, String shippingmemo, Set deliveryItems) {
        this.deliveryType = deliveryType;
        this.orders = orders;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.shippingsn = shippingsn;
        this.deliverytypename = deliverytypename;
        this.deliverycorpname = deliverycorpname;
        this.deliverysn = deliverysn;
        this.deliveryfee = deliveryfee;
        this.shipname = shipname;
        this.shiparea = shiparea;
        this.shipareapath = shipareapath;
        this.shipaddress = shipaddress;
        this.shipzipcode = shipzipcode;
        this.shipphone = shipphone;
        this.shipmobile = shipmobile;
        this.shippingmemo = shippingmemo;
        this.deliveryItems = deliveryItems;
    }

   
    // Property accessors

    public String getShippingid() {
        return this.shippingid;
    }
    
    public void setShippingid(String shippingid) {
        this.shippingid = shippingid;
    }

    public DeliveryType getDeliveryType() {
        return this.deliveryType;
    }
    
    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Orders getOrders() {
        return this.orders;
    }
    
    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public String getShippingsn() {
        return this.shippingsn;
    }
    
    public void setShippingsn(String shippingsn) {
        this.shippingsn = shippingsn;
    }

    public String getDeliverytypename() {
        return this.deliverytypename;
    }
    
    public void setDeliverytypename(String deliverytypename) {
        this.deliverytypename = deliverytypename;
    }

    public String getDeliverycorpname() {
        return this.deliverycorpname;
    }
    
    public void setDeliverycorpname(String deliverycorpname) {
        this.deliverycorpname = deliverycorpname;
    }

    public String getDeliverysn() {
        return this.deliverysn;
    }
    
    public void setDeliverysn(String deliverysn) {
        this.deliverysn = deliverysn;
    }

    public Long getDeliveryfee() {
        return this.deliveryfee;
    }
    
    public void setDeliveryfee(Long deliveryfee) {
        this.deliveryfee = deliveryfee;
    }

    public String getShipname() {
        return this.shipname;
    }
    
    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShiparea() {
        return this.shiparea;
    }
    
    public void setShiparea(String shiparea) {
        this.shiparea = shiparea;
    }

    public String getShipareapath() {
        return this.shipareapath;
    }
    
    public void setShipareapath(String shipareapath) {
        this.shipareapath = shipareapath;
    }

    public String getShipaddress() {
        return this.shipaddress;
    }
    
    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    public String getShipzipcode() {
        return this.shipzipcode;
    }
    
    public void setShipzipcode(String shipzipcode) {
        this.shipzipcode = shipzipcode;
    }

    public String getShipphone() {
        return this.shipphone;
    }
    
    public void setShipphone(String shipphone) {
        this.shipphone = shipphone;
    }

    public String getShipmobile() {
        return this.shipmobile;
    }
    
    public void setShipmobile(String shipmobile) {
        this.shipmobile = shipmobile;
    }

    public String getShippingmemo() {
        return this.shippingmemo;
    }
    
    public void setShippingmemo(String shippingmemo) {
        this.shippingmemo = shippingmemo;
    }

    public Set getDeliveryItems() {
        return this.deliveryItems;
    }
    
    public void setDeliveryItems(Set deliveryItems) {
        this.deliveryItems = deliveryItems;
    }
   








}