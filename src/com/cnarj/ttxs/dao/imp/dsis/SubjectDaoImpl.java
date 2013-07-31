package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.SubjectDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;
import com.cnarj.ttxs.pojo.dsis.TSubject;

/**
 * 科目接口实现类
 * @author hedan
 *
 */
public class SubjectDaoImpl extends BaseDaoDsisImpl<TSubject, Long> implements SubjectDao{


	@SuppressWarnings("unchecked")
	public List<TSubject> getListByExamId(Long njId, Long examId) {
		Assert.notNull(njId,"njId is required");
		Assert.notNull(examId,"examId is required");
		String hql = " from ExamSubInfo  e where 1=1 and e.exam.examId = ? and e.njId = ? ";
		ExamSubInfo examSubinfo = (ExamSubInfo)getSession().createQuery(hql).setParameter(0, examId).setParameter(1, njId).uniqueResult();
		List<TSubject> list = null;
		if(examSubinfo != null ){
			String l_str = examSubinfo.getSubstr();
			String[] l_strArr = null;
			
			if(l_str != null && !"".equals(l_str)){
				list = new ArrayList();
				l_strArr = l_str.split(",");
				int size = l_strArr.length;
				Long l_subId = null;
				for(int i = 0; i < size ;i++ ){
					l_subId = Long.parseLong(l_strArr[i]);
					list.add(super.get(l_subId));
				}
			}
		}
		return list;
	}

}
