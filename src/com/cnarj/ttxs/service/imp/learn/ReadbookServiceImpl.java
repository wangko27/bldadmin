package com.cnarj.ttxs.service.imp.learn;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.learn.IReadbookDao;
import com.cnarj.ttxs.dao.learn.IReaddownDao;
import com.cnarj.ttxs.dao.learn.IReadhandleDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;
import com.cnarj.ttxs.pojo.learn.ReadSrcHandleRec;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IReadbookService;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;

/**
 * 学习频道Service实现类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadbookServiceImpl extends BaseServiceImpl<ReadSrc, String>
		implements IReadbookService {

	IReadbookDao readbookDao;

	IReadhandleDao readhandleDao;

	MemberDao memberDao;

	IReaddownDao readdownDao;

	public IReadbookDao getReadbookDao() {
		return readbookDao;
	}

	public void setReadbookDao(IReadbookDao readbookDao) {
		this.readbookDao = readbookDao;
	}

	public void setBaseDao(IReadbookDao readbookDao) {
		super.setBaseDao(readbookDao);
	}

	public IReadhandleDao getReadhandleDao() {
		return readhandleDao;
	}

	public void setReadhandleDao(IReadhandleDao readhandleDao) {
		this.readhandleDao = readhandleDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public IReaddownDao getReaddownDao() {
		return readdownDao;
	}

	public void setReaddownDao(IReaddownDao readdownDao) {
		this.readdownDao = readdownDao;
	}

	/**
	 * 如果有num条以上的推荐书 就显示推荐书 负责: 就用,最早发布的书来接到不足num条的书籍上
	 */
	public List<ReadSrc> get5ReadSrc(int num) {

		if (num < 0) {
			num = 5;
		}
		List<ReadSrc> rList = readbookDao.getRReadsrc(num);// 0.1..2
		if (rList.size() >= num) {
			return rList;
		} else {
			int j = rList.size();
			List<ReadSrc> list = readbookDao.getReadsrc(num - rList.size());// num-rList.size
			// 为还差多少条信息2
			for (int i = 0; i < list.size(); i++) {
				rList.add(j + i, list.get(i));// 用没有推荐的书籍加入rlist集合中
			}
		}
		return rList;
	}

	public Result listReadbookByPager(Page page, String srctypeid,
			String subjectcode, String gradeCode, String order)
			throws Exception {
		return readbookDao.listReadbook(page, srctypeid, subjectcode,
				gradeCode, order);
	}

	public void saveReadhandle(String readsrcid, Long actiontype,
			String actionpath) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);
		if (actiontype == 1) {// 修改分享次数（加1）
			readSrc.setSharenum(readSrc.getSharenum() + 1);
		} else if (actiontype == 2) {// 修改收藏次数（加1）
			readSrc.setCollectionnum(readSrc.getCollectionnum() + 1);
		}
		readbookDao.update(readSrc);

		// 添加分享/收藏记录
		ReadSrcHandleRec readSrcHandleRec = new ReadSrcHandleRec();
		readSrcHandleRec.setReadSrc(readSrc);
		readSrcHandleRec.setActiontype(actiontype);
		readSrcHandleRec.setActiondate(new Date());
		readSrcHandleRec.setActionpath(actionpath);
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);
		readSrcHandleRec.setMember(member);
		readhandleDao.save(readSrcHandleRec);
	}

	public boolean isExistByReadhandle(String readsrcid, Long actiontype)
			throws Exception {
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		return readhandleDao.isExistByReadhandle(readsrcid, actiontype,
				memberid);
	}

	public boolean isExistByReaddown(String readsrcid) throws Exception {
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		return readdownDao.isExistByReaddown(readsrcid, memberid);
	}

	public void saveReaddown(String readsrcid) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);
		// 修改下载次数（加1）
		readSrc.setDownloadnum(readSrc.getDownloadnum() + 1);
		readbookDao.update(readSrc);

		// 添加下载记录
		ReadSrcDownRec readSrcDownRec = new ReadSrcDownRec();
		readSrcDownRec.setReadSrc(readSrc);
		readSrcDownRec.setDownloaddate(new Date());
		readSrcDownRec.setDownrecpoint(readSrc.getDownpoint());
		readSrcDownRec.setIscommented("0");
		readSrcDownRec.setIsrating("0");
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);
		// 修改用户积分（减去下载所需积分）
		member.setMemberpoint(member.getMemberpoint() - readSrc.getDownpoint());
		memberDao.update(member);

		readSrcDownRec.setMember(member);
		readdownDao.save(readSrcDownRec);

		// 修改资源发布人积分（添加下载所需积分）
		if (null != readSrc.getMember()) {
			Member member_pub = readSrc.getMember();
			member_pub.setMemberpoint(member_pub.getMemberpoint()
					+ readSrc.getDownpoint());
			memberDao.update(member_pub);
		}

	}

	public String readdown(String readsrcid) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);
		if (null == readSrc.getSrcpath()) {
			FileOperate.downFile("none/", "none.file");
		} else {
			int mark = readSrc.getSrcpath().lastIndexOf(File.separator) + 1;
			String filepath = readSrc.getSrcpath().substring(0, mark);
			String filename = readSrc.getSrcpath().substring(mark,
					readSrc.getSrcpath().length());
			FileOperate.downFile(filepath, filename);
		}

		return null;
	}

	public boolean isHaveByDownPoint(String readsrcid) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);
		// 用户ID
		String memberid = HttpUtil.getSession(
				Member.LOGIN_MEMBER_ID_SESSION_NAME).toString();
		Member member = memberDao.get(memberid);
		if (null == member.getMemberpoint()
				|| member.getMemberpoint() < readSrc.getDownpoint()) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List listCorrelateRead(String readsrcid, String srckeywords,
			int shownum) throws Exception {
		return readbookDao.listCorrelateRead(readsrcid, srckeywords, shownum);
	}

	public Result listReadCommentedByPager(Page page, String readsrcid)
			throws Exception {
		return readbookDao.listReadCommentedByPager(page, readsrcid);
	}

	@SuppressWarnings("unchecked")
	public List listReadbookByGrade(String[] gradecode, int shownum)
			throws Exception {
		return readbookDao.listReadbookByGrade(gradecode, shownum);
	}

	@SuppressWarnings("unchecked")
	public List listReadbookByRecommend(int shownum) throws Exception {
		return readbookDao.listReadbookByRecommend(shownum);
	}
}
