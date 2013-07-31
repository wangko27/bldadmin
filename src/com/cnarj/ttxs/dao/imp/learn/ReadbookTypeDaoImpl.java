package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IReadbookTypeDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;

/**
 * 学习频道Dao接口实现类 - 博览群书类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public class ReadbookTypeDaoImpl extends BaseDaoImpl<ReadSrcType, String>
		implements IReadbookTypeDao {

	@SuppressWarnings("unchecked")
	public List<ReadSrcType> listReadSrcTypeByChild(String srctypeid)
			throws Exception {
		String hql = "from ReadSrcType r where r.readSrcType.srctypeid='"+srctypeid+"' order by r.modifydate";
		return this.getSession().createQuery(hql).list();
	}

}
