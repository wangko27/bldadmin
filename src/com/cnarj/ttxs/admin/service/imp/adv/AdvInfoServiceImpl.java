package com.cnarj.ttxs.admin.service.imp.adv;


import com.cnarj.ttxs.admin.service.adv.IAdvInfoService;
import com.cnarj.ttxs.dao.adv.IAdvInfoDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

import java.util.List;
/**
 * 广告Service实现类 - 广告
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年7月24日22:24:18
 */
public class AdvInfoServiceImpl extends BaseServiceImpl<AdvInfo, String> implements IAdvInfoService {

	private IAdvInfoDao advInfoDao;

	public IAdvInfoDao getAdvInfoDao() {
		return advInfoDao;
	}

	public void setAdvInfoDao(IAdvInfoDao advInfoDao) {
		this.advInfoDao = advInfoDao;
	}

	/**
	 *得到广告位
    */
	public List<LocationInfo> getAllLocationInfo(String sel) {
		StringBuffer hql=new StringBuffer();
		hql.append("from LocationInfo l where 1=1");
//		if(sel!=null&&sel.trim().equals("add")){
//            //获取没有广告的广告位
//			hql.append(" and l.locationid not in (select a.locationInfo.locationid from AdvInfo a)");
//		}else {
//            //获取有广告的广告位
//			hql.append(" and l.locationid in (select a.locationInfo.locationid from AdvInfo a)");
//		}
		return advInfoDao.getAllLocationInfo(hql.toString());
	}

	/**
	 * 根据广告位置获取广告并分页
	 */
	public Result getShowAllAdv(String locationId, Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from AdvInfo a where 1=1");
		if(locationId!=null&&!locationId.trim().equals("")){
			hql.append(" and a.locationInfo.locationid='").append(locationId).append("'");
		}
		return advInfoDao.getShowAllAdv(hql.toString(),page);
	}


    /**
     * 根据广告位置获取所有的广告
     */
    public List<AdvInfo> getShowAllAdv(String locationId) {
        StringBuffer hql=new StringBuffer();
        hql.append("from AdvInfo a where 1=1");
        if(locationId!=null&&!locationId.trim().equals("")){
            hql.append(" and a.locationInfo.locationid='").append(locationId).append("'");
        }
        return advInfoDao.getShowAllAdv(hql.toString());
    }
}
