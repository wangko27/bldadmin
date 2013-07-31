package com.cnarj.ttxs.pojo.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private String goodsid;
	private GoodesCategory goodesCategory;  //商品类别
	private GoodesType goodesType;
	private Brand brand;    //品牌
	private Date createdate;
	private Date modifydate;
	private String productsn;
	private String goodsname;
	private Double productprice; //产品价格
	private Double marketprice;//市场价格
	private Double productweight;//产品重量
	private String weightunit;
	private Long stocknum;  //库存数量
	private Long occupiedstock;
	private Long productpoint;
	private String isadded; //1表示为已上架   0 表示未上架
	private String isboutique; //1表示为精品，0表示不是精品(默认)
	private String isnew;
    private String ishot;
	private String productdescription;
	private String pagekeywords;
	private String pagedescript;
	private String htmlfilepath;
	private String photospath;      //商品图片
	private Long commentsnum;
	private Long sharenum;
	private Long collectionnum;
	private String condition;
	private Long productsales;
	private Long generalscore;
	private Set deliveryItems = new HashSet(0);
	private Set goodsAttrs = new HashSet(0);
	private Set carItems = new HashSet(0);
	private Set orderItems = new HashSet(0);
	private Long attention;// 关注度
    private String goodsArea;//商品产地
    private String barCode;//商品条形码
	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */

    public Goods(String goodsid, GoodesCategory goodesCategory, GoodesType goodesType, Brand brand, Date createdate,
                 Date modifydate, String productsn, String goodsname, Double productprice, Double marketprice, Double productweight,
                 String weightunit, Long stocknum, Long occupiedstock, Long productpoint, String isadded, String isboutique,
                 String isnew, String ishot, String productdescription, String pagekeywords, String pagedescript,
                 String htmlfilepath, String photospath, Long commentsnum, Long sharenum, Long collectionnum,
                 String condition, Long productsales, Long generalscore, Set deliveryItems, Set goodsAttrs, Set carItems,
                 Set orderItems, Long attention, String goodsArea, String barCode) {
        this.goodsid = goodsid;
        this.goodesCategory = goodesCategory;
        this.goodesType = goodesType;
        this.brand = brand;
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.productsn = productsn;
        this.goodsname = goodsname;
        this.productprice = productprice;
        this.marketprice = marketprice;
        this.productweight = productweight;
        this.weightunit = weightunit;
        this.stocknum = stocknum;
        this.occupiedstock = occupiedstock;
        this.productpoint = productpoint;
        this.isadded = isadded;
        this.isboutique = isboutique;
        this.isnew = isnew;
        this.ishot = ishot;
        this.productdescription = productdescription;
        this.pagekeywords = pagekeywords;
        this.pagedescript = pagedescript;
        this.htmlfilepath = htmlfilepath;
        this.photospath = photospath;
        this.commentsnum = commentsnum;
        this.sharenum = sharenum;
        this.collectionnum = collectionnum;
        this.condition = condition;
        this.productsales = productsales;
        this.generalscore = generalscore;
        this.deliveryItems = deliveryItems;
        this.goodsAttrs = goodsAttrs;
        this.carItems = carItems;
        this.orderItems = orderItems;
        this.attention = attention;
        this.goodsArea = goodsArea;
        this.barCode = barCode;
    }
    // Property accessors

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public GoodesCategory getGoodesCategory() {
		return this.goodesCategory;
	}

	public void setGoodesCategory(GoodesCategory goodesCategory) {
		this.goodesCategory = goodesCategory;
	}

	public GoodesType getGoodesType() {
		return this.goodesType;
	}

	public void setGoodesType(GoodesType goodesType) {
		this.goodesType = goodesType;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getProductweight() {
        return productweight;
    }

    public void setProductweight(Double productweight) {
        this.productweight = productweight;
    }

    public String getWeightunit() {
        return weightunit;
    }

    public void setWeightunit(String weightunit) {
        this.weightunit = weightunit;
    }

    public Long getStocknum() {
		return this.stocknum;
	}

	public void setStocknum(Long stocknum) {
		this.stocknum = stocknum;
	}

	public Long getOccupiedstock() {
		return this.occupiedstock;
	}

	public void setOccupiedstock(Long occupiedstock) {
		this.occupiedstock = occupiedstock;
	}

	public Long getProductpoint() {
		return this.productpoint;
	}

	public void setProductpoint(Long productpoint) {
		this.productpoint = productpoint;
	}

	public String getIsadded() {
		return this.isadded;
	}

	public void setIsadded(String isadded) {
		this.isadded = isadded;
	}

	public String getIsboutique() {
		return this.isboutique;
	}

	public void setIsboutique(String isboutique) {
		this.isboutique = isboutique;
	}

	public String getIsnew() {
		return this.isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	public String getIshot() {
		return this.ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getProductdescription() {
		return this.productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getPagekeywords() {
		return this.pagekeywords;
	}

	public void setPagekeywords(String pagekeywords) {
		this.pagekeywords = pagekeywords;
	}

	public String getPagedescript() {
		return this.pagedescript;
	}

	public void setPagedescript(String pagedescript) {
		this.pagedescript = pagedescript;
	}

	public String getHtmlfilepath() {
		return this.htmlfilepath;
	}

	public void setHtmlfilepath(String htmlfilepath) {
		this.htmlfilepath = htmlfilepath;
	}

	public String getPhotospath() {
		return this.photospath;
	}

	public void setPhotospath(String photospath) {
		this.photospath = photospath;
	}

	public Long getCommentsnum() {
		return this.commentsnum;
	}

	public void setCommentsnum(Long commentsnum) {
		this.commentsnum = commentsnum;
	}

	public Long getSharenum() {
		return this.sharenum;
	}

	public void setSharenum(Long sharenum) {
		this.sharenum = sharenum;
	}

	public Long getCollectionnum() {
		return this.collectionnum;
	}

	public void setCollectionnum(Long collectionnum) {
		this.collectionnum = collectionnum;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Long getProductsales() {
		return this.productsales;
	}

	public void setProductsales(Long productsales) {
		this.productsales = productsales;
	}

	public Long getGeneralscore() {
		return this.generalscore;
	}

	public void setGeneralscore(Long generalscore) {
		this.generalscore = generalscore;
	}

	public Set getDeliveryItems() {
		return this.deliveryItems;
	}

	public void setDeliveryItems(Set deliveryItems) {
		this.deliveryItems = deliveryItems;
	}

	public Set getGoodsAttrs() {
		return this.goodsAttrs;
	}

	public void setGoodsAttrs(Set goodsAttrs) {
		this.goodsAttrs = goodsAttrs;
	}

	public Set getCarItems() {
		return this.carItems;
	}

	public void setCarItems(Set carItems) {
		this.carItems = carItems;
	}

	public Set getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}

	public Long getAttention() {
		return attention;
	}

	public void setAttention(Long attention) {
		this.attention = attention;
	}

    public String getGoodsArea() {
        return goodsArea;
    }

    public void setGoodsArea(String goodsArea) {
        this.goodsArea = goodsArea;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}