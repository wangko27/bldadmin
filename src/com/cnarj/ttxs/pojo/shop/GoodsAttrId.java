package com.cnarj.ttxs.pojo.shop;



/**
 * GoodsAttrId entity. @author MyEclipse Persistence Tools
 */

public class GoodsAttrId  implements java.io.Serializable {


    // Fields    

     private Goods goods;
     private Attribute attribute;


    // Constructors

    /** default constructor */
    public GoodsAttrId() {
    }

    
    /** full constructor */
    public GoodsAttrId(Goods goods, Attribute attribute) {
        this.goods = goods;
        this.attribute = attribute;
    }

   
    // Property accessors

    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }
    
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GoodsAttrId) ) return false;
		 GoodsAttrId castOther = ( GoodsAttrId ) other; 
         
		 return ( (this.getGoods()==castOther.getGoods()) || ( this.getGoods()!=null && castOther.getGoods()!=null && this.getGoods().equals(castOther.getGoods()) ) )
 && ( (this.getAttribute()==castOther.getAttribute()) || ( this.getAttribute()!=null && castOther.getAttribute()!=null && this.getAttribute().equals(castOther.getAttribute()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGoods() == null ? 0 : this.getGoods().hashCode() );
         result = 37 * result + ( getAttribute() == null ? 0 : this.getAttribute().hashCode() );
         return result;
   }   





}