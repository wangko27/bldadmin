package com.cnarj.ttxs.dao.recemmend;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: A.M.10:46
 * 后台秒杀管理dao接口
 */
public interface IMiaoShaDao extends IBaseDao<MiaoSha,String> {

    public Result findAll(String hql,Page page);
    public List findAll(String hql);

    public Object findById(String s);

    public void deleteById(String hql);

    public Object find(String hql);
}
