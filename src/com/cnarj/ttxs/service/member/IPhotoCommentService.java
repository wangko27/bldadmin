package com.cnarj.ttxs.service.member;

import java.util.List;

import com.cnarj.ttxs.pojo.stuz.Photocomment;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 空间service接口类 - 照片留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月29日19:25:37
 */
public interface IPhotoCommentService extends IBaseService<Photocomment,String> {

	/**
	 * 查询照片留言 有序的
	 * @param albumid
	 * @return
	 */
	public List<Photocomment> getListByPhoto(String photoid);
	
	/**
	 * 保存留言,返回相应的HTML
	 * @param albumid 相册ID
	 * @param member 留言用户信息 用户姓名+用户Id 
	 * @return
	 */
	public String saveCommentHtml(String photoid,Member member,String userIp,String comcontent,String fcommentedid);

}
