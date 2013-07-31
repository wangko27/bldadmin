package com.cnarj.ttxs.admin.service.shopping;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.shop.FeeTemplate;
import com.cnarj.ttxs.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-23
 * Time: A.M.9:11
 * 运费模板service接口
 */
public interface IFeeTemplateService  extends IBaseService<FeeTemplate, String> {

    public Result showAll(Page page);
}
