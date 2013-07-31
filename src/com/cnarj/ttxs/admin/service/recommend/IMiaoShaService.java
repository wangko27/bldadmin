package com.cnarj.ttxs.admin.service.recommend;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;
import com.cnarj.ttxs.service.IBaseService;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: a.m.10:38
 * 后台秒杀管理service类
 */
public interface IMiaoShaService extends IBaseService<MiaoSha, String> {

    public Result findAll(Page page);
    public Result findAllMiaoShaGoods(Page page) ;

    public Integer findByBeginDate(String beginDate,String endDate) throws ParseException;

    public MiaoSha findById(String miaoShaId);

    public void deleteById(String miaoShaId);
}
