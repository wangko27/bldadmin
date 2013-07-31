package com.cnarj.ttxs.dao.imp.member;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IQuestionDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.info.Question;

public class QuestionDaoImpl extends BaseDaoImpl<Question,String> implements IQuestionDao {

	
	public Result getQuestionList(Page page, List values) {
		String hql = "from Question q where 1=1 and q.member.memberid=? order by createdate desc";
		return super.findByPager(page, hql, values);
	}

}
