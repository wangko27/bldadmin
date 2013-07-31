package com.cnarj.ttxs.dao.member;

import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.info.Question;

public interface IQuestionDao extends IBaseDao<Question,String> {

	/**
	 * 查询用户的问题
	 * @param page
	 * @param values
	 * @return
	 */
	public Result getQuestionList(Page page,List values);
}
