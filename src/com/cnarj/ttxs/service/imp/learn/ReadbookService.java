package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IReadbookService;

/**
 * 学习频道Service实现类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadbookService extends BaseServiceImpl<ReadSrc, String> implements
		IReadbookService {

	public List<ReadSrc> get5ReadSrc(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isExistByReaddown(String readsrcid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExistByReadhandle(String readsrcid, Long actiontype)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isHaveByDownPoint(String readsrcid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List listCorrelateRead(String readsrcid, String srckeywords,
			int shownum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result listReadCommentedByPager(Page page, String readsrcid)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List listReadbookByGrade(String[] gradecode, int shownum)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result listReadbookByPager(Page page, String srctypeid,
			String subjectcode, String gradeCode, String order)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List listReadbookByRecommend(int shownum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String readdown(String readsrcid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveReaddown(String readsrcid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void saveReadhandle(String readsrcid, Long actiontype)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void saveReadhandle(String readsrcid, Long actiontype,
			String actionpath) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
