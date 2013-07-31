package com.cnarj.ttxs.dao.imp.recemmend;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.recemmend.IMiaoShaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;

import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: A.M.10:47
 * 后台秒杀管理dao实现类
 */
public class MiaoShaDaoImpl extends BaseDaoImpl<MiaoSha,String> implements IMiaoShaDao {

    @Override
    public Result findAll(String hql,Page page) {
        return this.findByPager(page,hql);
    }

    @Override
    public Object find(String hql) {
       return this.getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public List findAll(String hql) {
        return this.getSession().createQuery(hql).list();
    }

    @Override
    public Object findById(String hql) {
        return this.getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public void deleteById(String hql) {
        this.getSession().saveOrUpdate(hql);
    }
}
