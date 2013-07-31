package com.cnarj.ttxs.service.imp.member;


import java.sql.Date;
import java.util.Hashtable;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.learn.IReaddownDao;
import com.cnarj.ttxs.dao.member.ISrcManaDao;
import com.cnarj.ttxs.dao.member.IUpSrcDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.learn.ReadSrcCommented;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.ISrcManaService;


/**
 * 空间service接口实现类 - 下载资源管理  (学习资源评论信息表)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月30日
 */
public class SrcManaServiceImpl extends BaseServiceImpl<ReadSrcCommented,String> implements
		ISrcManaService {
	private IReaddownDao readdownDao;
	private ISrcManaDao srcManaDao;
	private IUpSrcDao upsrcDao;

	public IUpSrcDao getUpsrcDao() {
		return upsrcDao;
	}

	public void setUpsrcDao(IUpSrcDao upsrcDao) {
		this.upsrcDao = upsrcDao;
	}

	public ISrcManaDao getSrcManaDao() {
		return srcManaDao;
	}

	public void setSrcManaDao(ISrcManaDao srcManaDao) {
		this.srcManaDao = srcManaDao;
	}

	public IReaddownDao getReaddownDao() {
		return readdownDao;
	}

	public void setReaddownDao(IReaddownDao readdownDao) {
		this.readdownDao = readdownDao;
	}

	public void setBaseDao(ISrcManaDao srcManaDao) {
		super.setBaseDao(srcManaDao);
	}

	
	public Result getDownList(Page page,String memberid) {
		
		return srcManaDao.getDownList(page,memberid);
	}

	public ReadSrcDownRec getDownRec(Hashtable table) {
		// TODO Auto-generated method stub
		return readdownDao.get(table);
	}
	
	public void saveComment(ReadSrcCommented srcComm,String srcdownid){
		
		//数据判断
		Assert.notNull(srcComm, "srcComm 为空");
		Assert.notNull(srcComm.getMember(),"srcComm 用户信息为空");
		Assert.notNull(srcComm.getReadSrc(),"srcComm 所评资源为空");
		Assert.hasText(srcComm.getIp(),"srcComm 用户IP不能为空");
		
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		//1.插入评论评分数据
		srcComm.setCommenteddate(now);//评论时间
		srcComm.setDelflag("0");//删除标志 0正常 1删除
		srcManaDao.save(srcComm);
		
		//2.修改资源评论情况(资源下载记录表)
		ReadSrcDownRec downrec = readdownDao.get(srcdownid);
		downrec.setIscommented("1");
		downrec.setIsrating("1");
		
		//3.修改评论人数
		ReadSrc rs = upsrcDao.get(srcComm.getReadSrc().getReadsrcid());
		if(rs.getRatingnum() == null){
			rs.setRatingnum(new Long("0"));
		}
		if(rs.getGeneralscore() == null){
			rs.setGeneralscore(new Long("0"));
		}
		//评论人数+1
		rs.setRatingnum(rs.getRatingnum()+1);
		//累积总分
		rs.setGeneralscore(rs.getGeneralscore()+srcComm.getScoring());
		
		upsrcDao.update(rs);
		
		readdownDao.update(downrec);
	}
	
}
