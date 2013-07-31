package com.cnarj.ttxs.admin.actions.shopping;

import com.cnarj.ttxs.admin.service.shopping.IFeeTemplateService;
import com.cnarj.ttxs.pojo.shop.FeeTemplate;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.web.actions.base.PageAction;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-22
 * Time: P.M.4:57
 * 购物车运费模板管理
 */
public class FeeTemplateAction extends PageAction {
    private IFeeTemplateService feeTemplateService;
    private FeeTemplate fee;
    private String id;
    private Admin admin;

    public String showAll(){
        page.setEveryPage(10);
        if(gotoPage==null||gotoPage.trim().equals("")||gotoPage.length()==0){
            gotoPage="1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result=feeTemplateService.showAll(page);
        return SUCCESS;
    }

    public String addFeeTemplate(){
        Map<String,Object> session = this.getSession();
        admin= (Admin)session.get("admin");
        fee.setAdmin(admin);
        fee.setCreateTime(new Date());
        feeTemplateService.save(fee);
        return SUCCESS;
    }

    public String deleteById(){
        fee = feeTemplateService.get(id);
        feeTemplateService.delete(fee);
        return SUCCESS;
    }

    public String findById(){
        fee = feeTemplateService.get(id);
        return SUCCESS;
    }
    public String update(){
        Map<String,Object> session = this.getSession();
        admin= (Admin)session.get("admin");
        fee.setLastModifyAdmin(admin);
        feeTemplateService.update(fee);
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IFeeTemplateService getFeeTemplateService() {
        return feeTemplateService;
    }

    public void setFeeTemplateService(IFeeTemplateService feeTemplateService) {
        this.feeTemplateService = feeTemplateService;
    }

    public FeeTemplate getFee() {
        return fee;
    }

    public void setFee(FeeTemplate fee) {
        this.fee = fee;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
