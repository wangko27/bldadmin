package com.cnarj.ttxs.admin.actions.recommend;

import com.cnarj.ttxs.admin.service.recommend.IMiaoShaService;
import com.cnarj.ttxs.admin.service.shopping.IGoodsService;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;
import com.cnarj.ttxs.web.actions.base.PageAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: A.M.10:29
 * 后台商品秒杀管理
 */
public class MiaoShaAction extends PageAction{

    private IMiaoShaService miaoShaService;
    private IGoodsService goodsService;
    private String beginDate;
    private String endDate;
    private String miaoShaId;
    private MiaoSha miaoSha;

    //获取所有已经被推荐为秒杀的商品
    public String showMiaoShaGoods(){
        page.setEveryPage(20);
        if (gotoPage == null || gotoPage.trim().equals("")
                || gotoPage.length() == 0) {
            gotoPage = "1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result = miaoShaService.findAllMiaoShaGoods(page);
        return SUCCESS;
    }

    //检查该开始日期是否有推荐秒杀商品
    public String ajaxCheckBeginDate() throws ParseException {
        Integer integer = miaoShaService.findByBeginDate(beginDate,endDate);
        StringBuffer json=new StringBuffer();
        Integer num = 0;
        if ( integer != null && integer == 1){
            num = integer;
        }
        json.append("{\"goodsNum\":\"")
                .append(num)
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

    public String find(){
        if(miaoShaId != null &&  !"".equals(miaoShaId)){
            miaoSha = miaoShaService.findById(miaoShaId);
            return "findSuccess";
        }
        return "success";
    }

    public String update(){
        return "success";
    }

    public String delete(){
        if(miaoShaId != null && !"".equals(miaoShaId)){
            miaoSha = miaoShaService.findById(miaoShaId);
            miaoShaService.delete(miaoSha);
        }
        return "success";
    }



    public IMiaoShaService getMiaoShaService() {
        return miaoShaService;
    }

    public void setMiaoShaService(IMiaoShaService miaoShaService) {
        this.miaoShaService = miaoShaService;
    }

    public IGoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getMiaoShaId() {
        return miaoShaId;
    }

    public void setMiaoShaId(String miaoShaId) {
        this.miaoShaId = miaoShaId;
    }

    public MiaoSha getMiaoSha() {
        return miaoSha;
    }

    public void setMiaoSha(MiaoSha miaoSha) {
        this.miaoSha = miaoSha;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
