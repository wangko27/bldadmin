package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.stuz.Albumcomment;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 空间service接口 - 相册评论
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public interface IAlbumCommentService extends IBaseService<Albumcomment,String> {

	/**
	 * 查询相册留言 有序的
	 * @param albumid
	 * @return
	 */
	public List<Albumcomment> getListByAlbum(String albumid);
	
	/**
	 * 保存留言,返回相应的HTML
	 * @param albumid 相册ID
	 * @param member 留言用户信息 用户姓名+用户Id 
	 * @return
	 */
	public String saveCommentHtml(String albumid,Member member,String userIp,String comcontent,String fcommentedid);

	
}
