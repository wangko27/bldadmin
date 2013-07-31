package com.cnarj.ttxs.service.member;


import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.service.IBaseService;

public interface IQuestionService extends IBaseService<Question,String> {

	/**
	 * 查询用户的问题
	 * @param page
	 * @param values
	 * @return
	 */
	public Result getQuestionList(Page page, String memberid);
	
	/**
	 * 选定最佳答案
	 * @param memberid
	 * @param answerid
	 * @param questionid
	 * @return
	 */
	public int saveBeseAnswer(String memberid,String answerid,String questionid);
}
