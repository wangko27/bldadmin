package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DeliveryType entity. @author MyEclipse Persistence Tools
 */

public class DeliveryType  implements java.io.Serializable {


    // Fields    

     private String deliverytypeid;
     private DeliveryCorp deliveryCorp;
     private Date createdate;
     private Date modifydate;
     private String deliverytypename;
     private Long deliverymethod;
     private Long firstweight;
     private Long continueweight;
     private Long firstweightunit;
     private Long continueweightunit;
     private Long firstweightprice;
     private Long continueweightprice;
     private String typedescription;
     private Long orderlist;
     private Set reships = new HashSet(0);
     private Set orderses = new HashSet(0);
     private Set shippings = new HashSet(0);


    // Constructors

    /** default constructor */
    public DeliveryType() {
    }

    
    /** full constructor */
    public DeliveryType(DeliveryCorp deliveryCorp, Date createdate, Date modifydate, String deliverytypename, Long deliverymethod, Long firstweight, Long continueweight, Long firstweightunit, Long continueweightunit, Long firstweightprice, Long continueweightprice, String typedescription, Long orderlist, Set reships, Set orderses, Set shippings) {
        this.deliveryCorp = deliveryCorp;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.deliverytypename = deliverytypename;
        this.deliverymethod = deliverymethod;
        this.firstweight = firstweight;
        this.continueweight = continueweight;
        this.firstweightunit = firstweightunit;
        this.continueweightunit = continueweightunit;
        this.firstweightprice = firstweightprice;
        this.continueweightprice = continueweightprice;
        this.typedescription = typedescription;
        this.orderlist = orderlist;
        this.reships = reships;
        this.orderses = orderses;
        this.shippings = shippings;
    }

   
    // Property accessors

    public String getDeliverytypeid() {
        return this.deliverytypeid;
    }
    
    public void setDeliverytypeid(String deliverytypeid) {
        this.deliverytypeid = deliverytypeid;
    }

    public DeliveryCorp getDeliveryCorp() {
        return this.deliveryCorp;
    }
    
    public void setDeliveryCorp(DeliveryCorp deliveryCorp) {
        this.deliveryCorp = deliveryCorp;
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

    public String getDeliverytypename() {
        return this.deliverytypename;
    }
    
    public void setDeliverytypename(String deliverytypename) {
        this.deliverytypename = deliverytypename;
    }

    public Long getDeliverymethod() {
        return this.deliverymethod;
    }
    
    public void setDeliverymethod(Long deliverymethod) {
        this.deliverymethod = deliverymethod;
    }

    public Long getFirstweight() {
        return this.firstweight;
    }
    
    public void setFirstweight(Long firstweight) {
        this.firstweight = firstweight;
    }

    public Long getContinueweight() {
        return this.continueweight;
    }
    
    public void setContinueweight(Long continueweight) {
        this.continueweight = continueweight;
    }

    public Long getFirstweightunit() {
        return this.firstweightunit;
    }
    
    public void setFirstweightunit(Long firstweightunit) {
        this.firstweightunit = firstweightunit;
    }

    public Long getContinueweightunit() {
        return this.continueweightunit;
    }
    
    public void setContinueweightunit(Long continueweightunit) {
        this.continueweightunit = continueweightunit;
    }

    public Long getFirstweightprice() {
        return this.firstweightprice;
    }
    
    public void setFirstweightprice(Long firstweightprice) {
        this.firstweightprice = firstweightprice;
    }

    public Long getContinueweightprice() {
        return this.continueweightprice;
    }
    
    public void setContinueweightprice(Long continueweightprice) {
        this.continueweightprice = continueweightprice;
    }

    public String getTypedescription() {
        return this.typedescription;
    }
    
    public void setTypedescription(String typedescription) {
        this.typedescription = typedescription;
    }

    public Long getOrderlist() {
        return this.orderlist;
    }
    
    public void setOrderlist(Long orderlist) {
        this.orderlist = orderlist;
    }

    public Set getReships() {
        return this.reships;
    }
    
    public void setReships(Set reships) {
        this.reships = reships;
    }

    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }

    public Set getShippings() {
        return this.shippings;
    }
    
    public void setShippings(Set shippings) {
        this.shippings = shippings;
    }
   








}