package com.cnarj.ttxs.admin.service.imp.recommend;

import com.cnarj.ttxs.admin.service.recommend.IMiaoShaService;
import com.cnarj.ttxs.dao.recemmend.IMiaoShaDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.recommend.MiaoSha;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-27
 * Time: A.M.10:40
 * 后台秒杀管理service实现类
 */
public class MiaoShaServiceImpl extends BaseServiceImpl<MiaoSha, String> implements IMiaoShaService {
    private IMiaoShaDao miaoShaDao;

    //分页查询所有秒杀商品
    @Override
    public Result findAll(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from MiaoSha where 1=1");
        return miaoShaDao.findAll(hql.toString(),page);
    }

    public IMiaoShaDao getMiaoShaDao() {
        return miaoShaDao;
    }

    public void setMiaoShaDao(IMiaoShaDao miaoShaDao) {
        this.miaoShaDao = miaoShaDao;
    }

    //分页获取所有已被推荐的商品(不包括秒杀的)
    @Override
    public Result findAllMiaoShaGoods(Page page) {
        StringBuffer hql = new StringBuffer();
        hql.append("from MiaoSha m where 1=1  order by m.createDate desc");
        return miaoShaDao.findAll(hql.toString(), page);
    }


    /**
     * 根据开始日期、结束时间查询是否有秒杀商品
     *以当前时间为基准，不能超过当前时间 应该以传过来的开始时间和结束时间段为判断依据
     *两种情况：
     * 1、传过来的开始时间大于当前时间(页面已判断)，并且开始时间大于数据库里面当天结束时间的最大值
     * 2、传过来的开始时间大于当前时间(页面已判断)，并且结束时间小于数据库里面当天开始时间的最小值
     * @param beginDate
     * @return 若返回1 则表示可以推荐该商品为秒杀商品
     * @throws ParseException
     */
    @Override
    public Integer findByBeginDate(String beginDate,String endDate) throws ParseException {
        StringBuffer hql = null;
        Integer i = 0;
        Date maxEndDate = null;
        Date minBeginDate = null;
        Date bDate = null;
        Date eDate = null;
        if(beginDate != null && !"".equals(beginDate)  && endDate != null && !"".equals(endDate) ){
            bDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beginDate);
            eDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);
        }
        if(bDate != null && eDate != null){
            hql =  new StringBuffer();
            hql .append("select max(m.endDate) from MiaoSha m  where to_char(m.beginDate,'yyyy-MM-dd') ='");
            hql.append(new SimpleDateFormat("yyyy-MM-dd").format(bDate));
            hql.append("' and m.state = '1' order by m.createDate desc");
            maxEndDate = (Date)miaoShaDao.find(hql.toString());
//            if(maxDate == null){
//                return 1;
//            }else {
//                //i == -1 maxDate > date    i==0 maxDate == date   i ==1   date> maxDate
//                i = bDate.compareTo(maxDate);
//            }
            hql =  new StringBuffer();
            //开始日期必须大于数据库的当前日期，选取开始日期当天的最小开始日期
            hql.append("select min(m.beginDate) from MiaoSha m where " +
                    " to_date('"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bDate)+"','yyyy-mm-dd hh24:mi:ss') > sysdate" +
                    " and to_char(m.beginDate,'yyyy-MM-dd') = '");
            hql.append(new SimpleDateFormat("yyyy-MM-dd").format(bDate));
            hql.append("' and m.state = '1' order by m.createDate desc");
            minBeginDate = (Date)miaoShaDao.find(hql.toString());
//            if(minBeginDate == null){
//                return 1;
//            }else {
//                //i == -1 date > minDate    i==0 maxDate == date   i ==1   minDate> date
//                //传过来的期必须大于最小日期
//                i = minBeginDate.compareTo(eDate);
//            }
        }
        if(maxEndDate == null || minBeginDate == null){
            i = 1;
        }
        if( i == 0 && maxEndDate != null && bDate.compareTo(maxEndDate) == 1){
            i = 1;
        }
        if(i == 0  && maxEndDate != null && minBeginDate.compareTo(eDate) == 1){
            i = 1;
        }
        return i;
    }

    @Override
    public MiaoSha findById(String miaoShaId) {
        StringBuffer hql = new StringBuffer();
        hql.append("from MiaoSha where miaoShaId = '");
        hql.append(miaoShaId);
        hql.append("'");
        return (MiaoSha)miaoShaDao.findById(hql.toString());
    }

    @Override
    public void deleteById(String miaoShaId) {
        StringBuffer hql = new StringBuffer();
        hql.append("delete from MiaoSha where miaoShaId = '");
        hql.append(miaoShaId);
        hql.append("'");
        miaoShaDao.deleteById(hql.toString());
    }
}
