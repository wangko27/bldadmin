package com.cnarj.ttxs.admin.service.imp.shopping;
import com.cnarj.ttxs.admin.service.shopping.IGoodsService;
import com.cnarj.ttxs.dao.shopping.IGoodsDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 商城频道后台Service实现类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
public class GoodsServiceImpl extends BaseServiceImpl<Goods, String> implements IGoodsService {

	private IGoodsDao goodsDao;


	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	/**
	 * 分页
	 * @param page
	 * @param goodsKey  条件搜索
	 * @return
	 */
	public Result getByTrimGoods(Page page, String goodsKey) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Goods g where 1=1");
		if(goodsKey!=null&&!goodsKey.trim().equals("")){
			hql.append(" and g.goodsname like '%").append(goodsKey).append("%'");
		}
        hql.append("order by createdate desc ");
		return goodsDao.getByTrimGoods(hql.toString(),page);
	}

    /**
     * 商品搜索，按照类别名称搜索
     * @param page
     * @param categoryName
     * @return
     */
    @Override
    public Result findByCategoryName(Page page, String categoryName) {
        categoryName = categoryName.trim();
        StringBuffer hql=new StringBuffer();
        hql.append("from Goods g where 1=1");
        Result result = null;
        //在二级分类里面搜索
        if( categoryName != null &&  !"".equals(categoryName.trim()) ){
            hql.append(" and g.goodesCategory.categoryname like '%").append(categoryName).append("%'");
            hql.append(" order by createdate desc ");
            result =  goodsDao.getByTrimGoods(hql.toString(),page);
        }
        //在一级级分类里面搜索
        if (result == null || result.getContent() == null || result.getContent().size() <= 0){
            hql=new StringBuffer();
            hql.append("from Goods g where 1=1");
            hql.append(" and g.goodesCategory.goodesCategory.categoryname like '%").append(categoryName).append("%'");
            hql.append(" order by createdate desc ");
            result =  goodsDao.getByTrimGoods(hql.toString(),page);
        }
        if (result == null || result.getContent() == null || result.getContent().size() <= 0){
            result =  goodsDao.getByTrimGoods(hql.toString(),page);
        }
        return result;
    }

    public Result findAllGoods(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from Goods g where 1=1 order by g.createdate");
        return goodsDao.getAllGoods(hql.toString(), page);
    }

    @Override
    public Goods findById(String goodsId) {
        StringBuffer hql = new StringBuffer();
        if(goodsId != null && !"".equals(goodsId.trim())){
            hql.append("from Goods g where g.goodsid='").append(goodsId).append("'");
            return (Goods)goodsDao.findById(hql.toString());
        }
        return null;
    }

    //分页获取所有已被推荐的商品(不包括秒杀的)
    @Override
    public Result findAllRecommendGoods(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from GoodsRecommend g where g.recommendType = '1' and g.recommendState = '1'" +
                "and g.miaoSha = '0' order by g.createDate");
        return goodsDao.getAllGoods(hql.toString(), page);
    }

    //分页获取所有已被推荐为热销的商品
    @Override
    public Result findAllHotGoods(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from Goods g where g.isadded = '1' and g.stocknum > 0 and g.ishot = '1'" +
                "order by g.createdate");
        return goodsDao.getAllGoods(hql.toString(), page);
    }


}
