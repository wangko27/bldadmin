package com.cnarj.ttxs.pojo.shop;



/**
 * GoodsAttr entity. @author MyEclipse Persistence Tools
 */

public class GoodsAttr  implements java.io.Serializable {


    // Fields    

     private GoodsAttrId id;
     private String explanation;


    // Constructors

    /** default constructor */
    public GoodsAttr() {
    }

	/** minimal constructor */
    public GoodsAttr(GoodsAttrId id) {
        this.id = id;
    }
    
    /** full constructor */
    public GoodsAttr(GoodsAttrId id, String explanation) {
        this.id = id;
        this.explanation = explanation;
    }

   
    // Property accessors

    public GoodsAttrId getId() {
        return this.id;
    }
    
    public void setId(GoodsAttrId id) {
        this.id = id;
    }

    public String getExplanation() {
        return this.explanation;
    }
    
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
   








}