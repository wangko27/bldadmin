package com.cnarj.ttxs.admin.service.imp.learn;

import java.io.File;
import java.util.Date;

import com.cnarj.ttxs.admin.service.learn.IReadbookService;
import com.cnarj.ttxs.dao.learn.IReadbookDao;
import com.cnarj.ttxs.dao.learn.IReadbookTypeDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.util.HttpUtil;
import com.cnarj.ttxs.util.Pubfun;

/**
 * 学习频道后台Service实现类 - 博览群书
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月10日
 */
public class ReadbookServiceImpl extends BaseServiceImpl<ReadSrc, String>
		implements IReadbookService {

	IReadbookDao readbookDao;

	IReadbookTypeDao readbookTypeDao;

	public IReadbookDao getReadbookDao() {
		return readbookDao;
	}

	public void setReadbookDao(IReadbookDao readbookDao) {
		this.readbookDao = readbookDao;
	}

	public IReadbookTypeDao getReadbookTypeDao() {
		return readbookTypeDao;
	}

	public void setReadbookTypeDao(IReadbookTypeDao readbookTypeDao) {
		this.readbookTypeDao = readbookTypeDao;
	}

	public void setBaseDao(IReadbookDao readbookDao) {
		super.setBaseDao(readbookDao);
	}

	public void saveReadSrcByReadbook(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType, File resource,
			String resourceFileName, String resourceContentType)
			throws Exception {
		readSrc.setCreatedate(new Date());// 创建日期
		readSrc.setModifydate(new Date());// 修改日期
		readSrc.setCollectionnum(new Long(0));// 收藏次数
		readSrc.setDownloadnum(new Long(0));// 下载次数
		readSrc.setSharenum(new Long(0));// 分享次数
		readSrc.setRatingnum(new Long(0));// 评分人数
		readSrc.setGeneralscore(new Long(0));// 综合分
		readSrc.setReadsrcsales(new Long(0));// 销量
		readSrc.setReadnum(new Long(0));// 阅读次数
		readSrc.setIsenable("1");// 默认启用

		String newContent = Pubfun.contentHandle(readSrc.getContentintro());
		// 重新设置内容
		readSrc.setContentintro(newContent);

		// 保存并返回ID
		String readsrcid = readbookDao.save(readSrc);

		String coverPath = "uploadfiles/none.gif";// 封面路径

		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("readbook", new Date(),
				readsrcid);

		if (null != cover) {
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("readbook",
					new Date(), readsrcid, cover, coverFileName,
					coverContentType);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
		}

		if (null != resource) {
			// 资源保存文件名
			String resourceUploadFilename = DateUtil.setDateFormat(new Date(),
					"HHmmss")
					+ "_" + resourceFileName;
			// 获得文件后缀名
			String resourceExtension = resourceFileName
					.substring(resourceFileName.lastIndexOf("."));
			// 上传资源
			String resourceUploadPath = FileOperate.fileUpload(resource,
					resourceFileName, resourceContentType, uploadFilepath,
					resourceUploadFilename);
			readSrc.setSrcpath(resourceUploadPath.toString());// 资源路径
			readSrc.setReadsrcformat(resourceExtension.substring(1,
					resourceExtension.length()));// 资源格式
			// resource.length()为字节，保存大小单位为KB
			readSrc.setReadsrcsize(resource.length() / 1024); // 资源大小
		} else {
			readSrc.setReadsrcsize(new Long(0));
			readSrc.setDownpoint(new Long(0));
		}

		readSrc.setPhotopath(coverPath);// 封面路径

		// 保存并返回博览群书ID
		readbookDao.update(readSrc);
	}

	public void updateReadSrcByReadbook(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		ReadSrc readSrcNew = readbookDao.get(readSrc.getReadsrcid());
		readSrcNew.setModifydate(new Date());// 修改日期
		readSrcNew.setReadsrctile(readSrc.getReadsrctile());// 修改标题

		readSrcNew.setGradeCode(readSrc.getGradeCode());// 修改年级
		readSrcNew.setSubjectCode(readSrc.getSubjectCode());// 修改科目
		readSrcNew.setSrckeywords(readSrc.getSrckeywords());// 修改关键字
		readSrcNew.setIsrecommend(readSrc.getIsrecommend());// 修改是否推荐
		readSrcNew.setIshot(readSrc.getIshot());// 修改是启热销
		readSrcNew.setUsername(readSrc.getUsername());// 修改来源

		String newContent = Pubfun.contentHandle(readSrc.getContentintro());
		// 重新设置内容
		readSrcNew.setContentintro(newContent);

		if (null != cover) {
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("readbook",
					readSrcNew.getCreatedate(), readSrcNew.getReadsrcid(),
					cover, coverFileName, coverContentType);
			if (coverUploadPath.length() > 0) {
				readSrcNew.setPhotopath(coverUploadPath);// 封面路径
			}
		}

		// 修改
		readbookDao.update(readSrcNew);
	}

	public Result listReadsrcByOnedayPage(Page page, String subjectcode,
			String gradecode, String readsrctile, String isenable)
			throws Exception {
		return readbookDao.listReadbookByOnedayPage(page, subjectcode,
				gradecode, readsrctile, isenable);
	}

	public Result listReadsrcByReadbookPage(Page page, String subjectcode,
			String gradecode, String srctypeid, String readsrctile,
			String isenable) throws Exception {
		return readbookDao.listReadbookByReadbookPage(page, subjectcode,
				gradecode, srctypeid, readsrctile, isenable);
	}

	@SuppressWarnings("unchecked")
	public void deleteReadsrc(String readsrcid) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);

		// 删除相关文件
		if (null != readSrc.getCreatedate()) {
			// 文件保存路径
			StringBuffer sbUploadFilePath = new StringBuffer("uploadfiles");// 上传文件目录
			sbUploadFilePath.append(File.separator);

			if (readSrc.getReadSrcType().getSrctypeid().equals(
					"8a8081a131bbd5780131bbd5cdc30001")) {// 一天一课
				sbUploadFilePath.append("oneday");
				sbUploadFilePath.append(File.separator);
			} else if (readSrc.getReadSrcType().getReadSrcType().getSrctypeid()
					.equals("8a8081a131bbac4d0131bbac8f5a0001")) {// 博览群书
				sbUploadFilePath.append("readbook");
				sbUploadFilePath.append(File.separator);
			}

			sbUploadFilePath.append("admin");// 用户（这里是后台）
			sbUploadFilePath.append(File.separator);
			sbUploadFilePath.append(DateUtil.setDateFormat(readSrc
					.getCreatedate(), "yyyy-MM-dd"));// 日期（年月日）
			sbUploadFilePath.append(File.separator);
			sbUploadFilePath.append(readsrcid);// ID
			sbUploadFilePath.append(File.separator);
			File fileDirectory = new File(HttpUtil.getRealPath()
					+ sbUploadFilePath.toString());
			FileOperate.deleteDirectoryAndFile(fileDirectory);
		}

		// 删除下载记录

		// 删除评论

		// 删除学习资源处理记录

		// 删除内容
		readbookDao.delete(readSrc);

	}

	public void updateReadsrcByEnable(String readsrcid) throws Exception {
		ReadSrc readSrc = readbookDao.get(readsrcid);
		readSrc.setIsenable("0");// 不可用
		readbookDao.update(readSrc);
	}

	public void saveReadSrcByOneday(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType, File resource,
			String resourceFileName, String resourceContentType)
			throws Exception {
		readSrc.setCreatedate(new Date());// 创建日期
		readSrc.setModifydate(new Date());// 修改日期
		readSrc.setCollectionnum(new Long(0));// 收藏次数
		readSrc.setDownloadnum(new Long(0));// 下载次数
		readSrc.setSharenum(new Long(0));// 分享次数
		readSrc.setRatingnum(new Long(0));// 评分人数
		readSrc.setGeneralscore(new Long(0));// 综合分
		readSrc.setReadsrcsales(new Long(0));// 销量
		readSrc.setReadnum(new Long(0));// 阅读次数
		readSrc.setIshot("0");
		readSrc.setIsrecommend("0");
		readSrc.setIsenable("1");// 默认启用

		String newContent = Pubfun.contentHandle(readSrc.getContentintro());
		// 重新设置内容
		readSrc.setContentintro(newContent);

		// 保存并返回ID
		String readsrcid = readbookDao.save(readSrc);

		// 文件保存路径
		String uploadFilepath = Pubfun.structurePath("oneday", new Date(),
				readsrcid);

		String coverPath = "uploadfiles/none.gif";// 封面路径

		if (null != cover) {
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("readbook",
					new Date(), readsrcid, cover, coverFileName,
					coverContentType);
			if (coverUploadPath.length() > 0) {
				coverPath = coverUploadPath;
			}
		}

		// 资源保存文件名
		String resourceUploadFilename = DateUtil.setDateFormat(new Date(),
				"HHmmss")
				+ "_" + resourceFileName;
		// 获得文件后缀名
		String resourceExtension = resourceFileName.substring(resourceFileName
				.lastIndexOf("."));
		// 上传资源
		String resourceUploadPath = FileOperate.fileUpload(resource,
				resourceFileName, resourceContentType, uploadFilepath,
				resourceUploadFilename);

		readSrc.setSrcpath(resourceUploadPath.toString());// 资源路径
		readSrc.setReadsrcformat(resourceExtension.substring(1,
				resourceExtension.length()));// 资源格式
		// resource.length()为字节，保存大小单位为KB
		readSrc.setReadsrcsize(resource.length() / 1024); // 资源大小
		readSrc.setPhotopath(coverPath);// 封面

		// 修改
		readbookDao.update(readSrc);

	}

	public void updateReadSrcByOneday(ReadSrc readSrc, File cover,
			String coverFileName, String coverContentType) throws Exception {
		ReadSrc readSrcNew = readbookDao.get(readSrc.getReadsrcid());
		readSrcNew.setModifydate(new Date());// 修改日期
		readSrcNew.setReadsrctile(readSrc.getReadsrctile());// 修改标题

		readSrcNew.setGradeCode(readSrc.getGradeCode());// 修改年级
		readSrcNew.setSubjectCode(readSrc.getSubjectCode());// 修改科目
		readSrcNew.setSrckeywords(readSrc.getSrckeywords());// 修改关键字

		String newContent = Pubfun.contentHandle(readSrc.getContentintro());
		// 重新设置内容
		readSrcNew.setContentintro(newContent);

		if (null != cover) {
			// 上传封面
			String coverUploadPath = FileOperate.uploadCover("oneday",
					readSrcNew.getCreatedate(), readSrcNew.getReadsrcid(),
					cover, coverFileName, coverContentType);
			if (coverUploadPath.length() > 0) {
				readSrcNew.setPhotopath(coverUploadPath);// 封面路径
			}
		}

		// 修改
		readbookDao.update(readSrcNew);
	}
}
