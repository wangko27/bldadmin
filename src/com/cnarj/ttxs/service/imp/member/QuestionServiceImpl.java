package com.cnarj.ttxs.service.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.Article.IAnswerDao;
import com.cnarj.ttxs.dao.member.IQuestionDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.info.Answer;
import com.cnarj.ttxs.pojo.info.Question;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IQuestionService;

public class QuestionServiceImpl extends BaseServiceImpl<Question,String> implements
		IQuestionService {

	private IQuestionDao questionDao;
	private IAnswerDao answerDao;
	private MemberDao memberDao;
	
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public IAnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	public IQuestionDao getQuestionDao() {
		return questionDao;
	}
	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	public void setBaseDao(IQuestionDao questionDao) {
		super.setBaseDao(questionDao);
	}
	
	
	public Result getQuestionList(Page page, String memberid) {
		List list = new ArrayList();
		list.add(memberid);
		return questionDao.getQuestionList(page, list);
	}

	public int saveBeseAnswer(String memberid, String answerid, String questionid) {
		//查询回答信息
		Answer answer = answerDao.get(answerid);
		
		String mm = answer.getQuestion().getMember().getMemberid();
		
		//判断用户是否是该回答对应问题的提问者
		if(!mm.equals(memberid)){
			return 0;
		}
		
		answer.setIsbest("1");
		answerDao.update(answer);
		
		//修改问题状态
		Question q = new Question();
		q = questionDao.get(questionid);
		q.setQuestionstatus("1");
		questionDao.update(q);
		
		//修改积分
		Member mTW = q.getMember();//提问者
		Member mHD = answer.getMember();//回答者Id
		Long p1 = (mTW.getMemberpoint()==null?0:mTW.getMemberpoint())-q.getQuestionpoint();
		Long p2 = (mHD.getMemberpoint()==null?0:mHD.getMemberpoint())+q.getQuestionpoint()+10;
		mTW.setMemberpoint(p1);
		mHD.setMemberpoint(p2);
		
		memberDao.update(mTW);
		memberDao.update(mHD);
		
		return 1;
	}

}
