
package com.cnarj.ttxs.service.imp.member;


import java.io.File;
import java.sql.Date;

import com.cnarj.ttxs.dao.member.IUpSrcDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IUpSrcService;
import com.cnarj.ttxs.util.FileOperate;

public class UpSrcServiceImpl extends BaseServiceImpl<ReadSrc ,String> implements IUpSrcService {

	private IUpSrcDao upsrcDao;
	
	public IUpSrcDao getUpsrcDao() {
		return upsrcDao;
	}
	public void setUpsrcDao(IUpSrcDao upsrcDao) {
		this.upsrcDao = upsrcDao;
	}
	public void setBaseDao(IUpSrcDao upsrcDao) {
		super.setBaseDao(upsrcDao);
	}

	public Result getUpList(Page page, String memberid) {
		// TODO Auto-generated method stub
		return upsrcDao.getUpList(page, memberid);
	}
	
	public void updCloseSrc(String readsrcid) {
		// TODO Auto-generated method stub
		ReadSrc rs = upsrcDao.load(readsrcid);
		rs.setIsenable("0");
		upsrcDao.update(rs);
	}
	
	/**
	 * 
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
			String soucename,File souce) throws Exception{

		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		//用户
		Member m = new Member();
		m.setMemberid(memberid);
		//图片地址
		StringBuffer readsrcpath = new StringBuffer();
		String filerealpath = readsrcpath.append("userspacefile/")
			.append(memberid)//用户
			.append("/readbook/cover/")//博览群书资源封面
			.toString();
		//资源地址
		readsrcpath = new StringBuffer();
		String srcpath = readsrcpath.append("userspacefile/")
			.append(memberid)//用户
			.append("/readbook/souce/")//博览群书资源
			.toString();
		//保存封面名称
		String covername = FileOperate.generateFileName(filename);
		//保存资源名称
		String srcname = FileOperate.generateFileName(soucename);

		//上传资源封面图片,返回封面名称
		String coverRealPath = FileOperate.fileUpload(file,
		null, null, filerealpath, covername);

		//上传资源,返回资源名称
		String srcRealPath = FileOperate.fileUpload(souce,
		null, null, srcpath, srcname);
		
		
		//资源格式
		String srcformart  = srcname.substring(srcname.lastIndexOf(".")+1);
		
		readsrc.setMember(m);
		readsrc.setCreatedate(now);// 创建日期
		readsrc.setModifydate(now);// 修改日期
		readsrc.setCollectionnum(new Long(0));// 收藏次数
		readsrc.setDownloadnum(new Long(0));// 下载次数
		readsrc.setSharenum(new Long(0));// 分享次数
		readsrc.setRatingnum(new Long(0));// 评分人数
		readsrc.setGeneralscore(new Long(0));// 综合分
		readsrc.setReadsrcsales(new Long(0));// 销量
		readsrc.setReadnum(new Long(0));// 阅读次数
		readsrc.setPhotopath(coverRealPath);// 图片地址（封面）
		readsrc.setReadsrcformat(srcformart);// 格式
		// resource.length()为字节，保存大小单位为KB
		readsrc.setReadsrcsize(file.length() / 1024); // 资源大小
		readsrc.setIsrecommend("0");// 是否推荐书籍 否
		readsrc.setIshot("0");// 是否热销  0否
		readsrc.setIsenable("1");//是否启用 0不启用
		readsrc.setSrcpath(srcRealPath);// 资源路径
		readsrc.setUsername(username);// 来源人姓名
		
		//保存资源信息
		upsrcDao.save(readsrc);
	}
}