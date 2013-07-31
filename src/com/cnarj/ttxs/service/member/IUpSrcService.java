
package com.cnarj.ttxs.service.member;

import java.io.File;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.IBaseService;

public interface IUpSrcService extends IBaseService<ReadSrc ,String> {

	/**
	 * 获取用户上传的资源列表
	 * @param page
	 * @param memberid
	 * @return
	 */
	public Result getUpList(Page page,String memberid);
	
	/**
	 * 关闭已上传资源
	 * @return
	 */
	public void updCloseSrc(String readsrcid) ;
	
	/**
	 * 保存用户上传的资源信息
	 * 
	 * @param memberid 用户ID
	 * 
	 * @param username 用户姓名
	 * 
	 * @param readsrc 用户输入的资源信息
	 * 
	 * @param filename 资源图片名称
	 * 
	 * @param file 资源图片
	 * 
	 * @param soucename 资源名称
	 * 
	 * @param souce 资源
	 * 
	 * @throws Exception
	 */
	public void addSrc(String memberid,String username,ReadSrc readsrc,String filename,File file,
			String soucename,File souce) throws Exception;
	
}