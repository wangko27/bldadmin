package com.cnarj.ttxs.service.member;

import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrcCommented;
import com.cnarj.ttxs.pojo.learn.ReadSrcDownRec;
import com.cnarj.ttxs.service.IBaseService;


/**
 * 空间service接口 - 下载资源管理  (学习资源评论信息表)
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月30日
 */
public interface ISrcManaService extends IBaseService<ReadSrcCommented,String> {

	/**
	 * 查询用户的资源下载情况
	 * @param memberid
	 * @return
	 */
	public Result getDownList(Page page,String memberid);
	
	/**
	 * 根据传入的参数获取ReadSrcDownRec对象
	 * @param table
	 * @return
	 */
	public ReadSrcDownRec getDownRec(Hashtable table);
	
	/**
	 * 对已经下载的资源进行评论和评分
	 * @param srcComm 评分信息
	 */
	public void saveComment(ReadSrcCommented srcComm,String srcdownid);
}
