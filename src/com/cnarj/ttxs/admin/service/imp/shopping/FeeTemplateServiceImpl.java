package com.cnarj.ttxs.admin.service.imp.shopping;

import com.cnarj.ttxs.admin.service.shopping.IFeeTemplateService;
import com.cnarj.ttxs.dao.shopping.IFeeTemplateDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.FeeTemplate;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-23
 * Time: A.M 9:12
 * 运费模板services实现类
 */
public class FeeTemplateServiceImpl extends BaseServiceImpl<FeeTemplate, String> implements IFeeTemplateService {
    private IFeeTemplateDao feeTemplateDao;

    @Override
    public Result showAll(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from FeeTemplate where 1=1 order by createTime desc");
        return feeTemplateDao.findByPager(page);


    }

    public IFeeTemplateDao getFeeTemplateDao() {
        return feeTemplateDao;
    }

    public void setFeeTemplateDao(IFeeTemplateDao feeTemplateDao) {
        this.feeTemplateDao = feeTemplateDao;
    }
}
