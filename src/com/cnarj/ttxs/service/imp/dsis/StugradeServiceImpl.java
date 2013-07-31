package com.cnarj.ttxs.service.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.StugradeDao;
import com.cnarj.ttxs.pojo.dsis.TStugrade;
import com.cnarj.ttxs.service.StugradeService;
import com.cnarj.ttxs.service.imp.BaseDsisServiceImpl;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 年级业务实现类
 * @author hedan
 *
 */
public class StugradeServiceImpl extends BaseDsisServiceImpl<TStugrade, Long> implements StugradeService{

	private StugradeDao stugradeDao;
	
	
	
	public StugradeDao getStugradeDao() {
		return stugradeDao;
	}

	public void setStugradeDao(StugradeDao stugradeDao) {
		this.stugradeDao = stugradeDao;
		super.setBaseDao(stugradeDao);
	}



	public Long getStugrade(Long xs_id) throws BusinessException{
		return stugradeDao.getStugrade(xs_id);
	}

	
	public List<TStugrade> getList(Long xs_id) throws BusinessException {
		return stugradeDao.getList(xs_id);
	}

	
	public List<TStugrade> getGradeListByBind(Long teacherId)
			throws BusinessException {
		return stugradeDao.getGradeListByBind(teacherId);
	}

}
