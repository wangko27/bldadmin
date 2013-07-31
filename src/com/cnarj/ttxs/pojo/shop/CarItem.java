package com.cnarj.ttxs.pojo.shop;

import com.cnarj.ttxs.pojo.user.Member;
import java.util.Date;


/**
 * CarItem entity. @author MyEclipse Persistence Tools
 */

public class CarItem  implements java.io.Serializable {


    // Fields    

     private String cartitemid;
     private Goods goods;
     private Member member;
     private Long quantity;
     private Date createdate;
     private Date modifydate;


    // Constructors

    /** default constructor */
    public CarItem() {
    }

    
    /** full constructor */
    public CarItem(Goods goods, Member member, Long quantity, Date createdate, Date modifydate) {
        this.goods = goods;
        this.member = member;
        this.quantity = quantity;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

   
    // Property accessors

    public String getCartitemid() {
        return this.cartitemid;
    }
    
    public void setCartitemid(String cartitemid) {
        this.cartitemid = cartitemid;
    }

    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

    public Long getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
   








}