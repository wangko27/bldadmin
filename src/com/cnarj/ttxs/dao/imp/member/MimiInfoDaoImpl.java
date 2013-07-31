package com.cnarj.ttxs.dao.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.MimiInfoDao;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.msg.MimiInfo;
import com.cnarj.ttxs.pojo.msg.RemimiInfo;

/**
 * 秘密空间接口实现类
 * @author hedan
 *
 */
public class MimiInfoDaoImpl extends BaseDaoImpl<MimiInfo, String> implements MimiInfoDao{

	/**
	 * 根据班级id查询秘密空间留言集合-带分页
	 */
	@SuppressWarnings("unchecked")
	public Result getPager(Page pager, Long classId) {
		String hql = " from MimiInfo m where 1=1 and m.classid = ? order by m.msgdate desc ";
		List values = new ArrayList();
		values.add(classId);
		Result result = findByPager(pager, hql, values);
		if(result != null ){
			List<MimiInfo> lst = result.getContent();
			if(lst != null && lst.size() > 0){
				MimiInfo mimiInfo = null;
				int size = lst.size();
				String sql1 = null;
				List<RemimiInfo> lst_remimiInfo = null;
				for(int i=0; i < size; i++){
					mimiInfo = lst.get(i);
					sql1 = " from RemimiInfo r where 1=1 and r.mimi.msgid = ? order by r.remsgdate asc ";
					lst_remimiInfo = getSession().createQuery(sql1).setParameter(0, mimiInfo.getMsgid()).list();
					mimiInfo.setList(lst_remimiInfo);
				}
			}
		}
		return findByPager(pager, hql, values);
	}

	

}
