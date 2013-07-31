package com.cnarj.ttxs.admin.actions.recommend;

import com.cnarj.ttxs.admin.service.recommend.IMiaoShaService;
import com.cnarj.ttxs.admin.service.recommend.IRecommendService;
import com.cnarj.ttxs.admin.service.shopping.IGoodsService;
import com.cnarj.ttxs.pojo.recommend.GoodsRecommend;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.IBaseService;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.web.actions.base.PageAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-24
 * Time: p.m.4:59
 * 后台商品推荐 控制器
 */
public class GoodsRecommendAction extends PageAction{
    private IGoodsService goodsService;
    private IBaseService baseService;
    private Admin admin;
    private String goodsId;
    private Goods goods;
    private GoodsRecommend goodsRecommend;
    private LocationInfo locationInfo;
    private ILocationInfoService locationInfoService;
    private IRecommendService recommendService;
    private String recommendId;
    private String locationId;
    private String ms;   //是否为秒杀，1代表推荐到秒杀区，0代表不推荐到秒杀区
    private MiaoSha miaoSha;
    private IMiaoShaService miaoShaService;
    private String isHot;

    /**
     * 分页获取所有已经被推荐的商品
     * @return
     */
    public String showRecommendGoods(){
        page.setEveryPage(10);
        if (gotoPage == null || gotoPage.trim().equals("")
                || gotoPage.length() == 0) {
            gotoPage = "1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result = goodsService.findAllRecommendGoods(page);
        return "success";
    }

    /**
     * 分页获取所有已经被推荐热销的商品
     * @return
     */
    public String showHotGoods(){
        page.setEveryPage(10);
        if (gotoPage == null || gotoPage.trim().equals("")
                || gotoPage.length() == 0) {
            gotoPage = "1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result = goodsService.findAllHotGoods(page);
        return SUCCESS;
    }

    //商品推荐
    public String recommend(){
        goods.setIshot(isHot);
        goods  = goodsService.findById(goodsId);
        goodsRecommend.setGoods(goods);
        goodsRecommend.setAdmin(admin);
        goodsRecommend.setLastModifyUser(admin);
        goodsRecommend.setCreateDate(new Date());
        goodsRecommend.setLastModifyDate(new Date());
        goodsRecommend.setRecommendState("1");
        goodsRecommend.setRecommendType("1");
        if(locationId == null || locationId.equals("0")   ){
            goodsRecommend.setLocationInfo(null);
        }else {
            locationInfo = locationInfoService.getById(locationId);
            goodsRecommend.setLocationInfo(locationInfo);
        }
        //是否推荐为秒杀商品
        if(ms.equals("1")){
            miaoSha.setGoods(goods);
            miaoSha.setState("3"); // state==3 代表即将开始秒杀
            Map<String,Object> session = this.getSession();
            admin=(Admin)session.get("admin");
            miaoSha.setAdmin(admin);
            miaoSha.setCreateDate(new Date());
            String beginWeekday = getWeekStr(miaoSha.getBeginDate());
            miaoSha.setBeginWeekday(beginWeekday);
            String endWeekday = getWeekStr(miaoSha.getEndDate());
            miaoSha.setEndWeekday(endWeekday);
            Long time = miaoSha.getEndDate().getTime() - miaoSha.getBeginDate().getTime();
            miaoSha.setTime(time);
            String price = new DecimalFormat("0.00").format(Double.valueOf(miaoSha.getMiaoPrice().toString()) * miaoSha.getGoods().getProductprice() );
            miaoSha.setMiaoPrice(new Double(price));
            miaoShaService.save(miaoSha);
            goodsRecommend.setMiaoSha("1");
            goodsRecommend.setMiao(miaoSha);
        }
        goodsRecommend.setMiaoSha("0");
        goodsRecommend.setMiao(null);
        recommendService.save(goodsRecommend);
        return "success";
    }
   //根据日期获取是星期几
    private String getWeekStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null ){
            return "";
        }
        calendar.setTime(date);
        int hour = calendar.get(Calendar.DAY_OF_WEEK);
        String str = "";
        if(hour == 1){
            str = "星期日";
        }else if(hour == 2){
            str = "星期一";
        }else if(hour == 3){
            str = "星期二";
        }else if(hour == 4){
            str = "星期三";
        }else if(hour == 5){
            str = "星期四";
        }else if(hour == 6){
            str = "星期五";
        }else if(hour == 7){
            str = "星期六";
        }
        return str;
    }

    //根据推荐id找到该推荐商品
    public String find(){
        goodsRecommend = recommendService.findById(recommendId);
        return SUCCESS;
    }


    //根据商品id找到该商品
    public String findById(){
        goods = goodsService.findById(goodsId);
        Map<String,Object> session =  getSession();
        admin= (Admin)session.get("admin");
        return "success";
    }

    //更新商品的推荐信息
    public String update (){
        goodsRecommend.setLastModifyDate(new Date());
        Map<String,Object> session = getSession();
        admin = (Admin)session.get("admin");
        goodsRecommend.setLastModifyUser(admin);
        locationInfo = locationInfoService.getById(locationId);
        goodsRecommend.setLocationInfo(locationInfo);
        recommendService.update(goodsRecommend);
        return "success";
    }


    //ajax检查商品库存数量
    public String ajaxCheckNum(){
//        List<LocationInfo> locationInfoList = locationInfoService.getAllLocation();
        goods = goodsService.findById(goodsId);
        StringBuffer json=new StringBuffer();
            json.append("{\"goodsNum\":\"")
                    .append(goods.getStocknum())
                    .append("\"")
                    .append("}");
        this.ajaxJson(json.toString());
        return null;
    }
    // 根据字符串输出JSON，返回null
    public String ajaxJson(String jsonString) {
        return ajax(jsonString, "text/html");
    }
    // AJAX输出，返回null
    public String ajax(String content, String type) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public IGoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public IBaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(IBaseService baseService) {
        this.baseService = baseService;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsRecommend getGoodsRecommend() {
        return goodsRecommend;
    }

    public void setGoodsRecommend(GoodsRecommend goodsRecommend) {
        this.goodsRecommend = goodsRecommend;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public ILocationInfoService getLocationInfoService() {
        return locationInfoService;
    }

    public void setLocationInfoService(ILocationInfoService locationInfoService) {
        this.locationInfoService = locationInfoService;
    }

    public IRecommendService getRecommendService() {
        return recommendService;
    }

    public void setRecommendService(IRecommendService recommendService) {
        this.recommendService = recommendService;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public MiaoSha getMiaoSha() {
        return miaoSha;
    }

    public void setMiaoSha(MiaoSha miaoSha) {
        this.miaoSha = miaoSha;
    }

    public IMiaoShaService getMiaoShaService() {
        return miaoShaService;
    }

    public void setMiaoShaService(IMiaoShaService miaoShaService) {
        this.miaoShaService = miaoShaService;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getHot() {
        return isHot;
    }

    public void setHot(String hot) {
        isHot = hot;
    }
}
