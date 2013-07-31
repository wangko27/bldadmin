package com.cnarj.ttxs.dao;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.ExamSubInfo;

/**
 * 考试科目信息接口
 * @author hedan
 *
 */
public interface ExamSubInfoDao extends BaseDsisDao<ExamSubInfo, Long>{

	/**
	 * 根据年级id和考次id获得考试科目
	 * @param njId
	 * @param examId
	 * @return
	 */
	public ExamSubInfo get(Long njId, Long examId);
}
