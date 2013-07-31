package com.cnarj.ttxs.dao.imp.dsis;

import java.util.List;

import com.cnarj.ttxs.dao.ExamSubInfoDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;

/**
 * 考试科目信息接口实现类
 * @author hedan
 *
 */
public class ExamSubInfoDaoImpl extends BaseDaoDsisImpl<ExamSubInfo, Long> implements ExamSubInfoDao{

	
	@SuppressWarnings("unchecked")
	public ExamSubInfo get(Long njId, Long examId) {
		String hql = " from ExamSubInfo e where 1=1 and e.njId = ? and e.exam.examId = ? ";
		Object obj = getSession().createQuery(hql).setParameter(0, njId).setParameter(1, examId).uniqueResult();
		return (obj != null) ? (ExamSubInfo)obj : null;
	}

}
