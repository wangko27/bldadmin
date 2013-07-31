package com.cnarj.ttxs.admin.actions.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

import com.cnarj.ttxs.util.DateUtil;
import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 后台公用的Action类 - 文件操作
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月26日
 */
public class FileOperateAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String filedata;// 文件
	private String filename;// 文件名
	private String savePath;// 保存路径
	private int isFilenameNew;// 是否用新文件名
	private String[] deleteFilepath;// 要删除的文件
	private String forwardPage;// 要跳转的页面

	public String getFiledata() {
		return filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getIsFilenameNew() {
		return isFilenameNew;
	}

	public void setIsFilenameNew(int isFilenameNew) {
		this.isFilenameNew = isFilenameNew;
	}

	public String[] getDeleteFilepath() {
		return deleteFilepath;
	}

	public void setDeleteFilepath(String[] deleteFilepath) {
		this.deleteFilepath = deleteFilepath;
	}

	public String getForwardPage() {
		return forwardPage;
	}

	public void setForwardPage(String forwardPage) {
		this.forwardPage = forwardPage;
	}

	/**
	 * 文件上传
	 * 
	 * @return
	 */
	public String toFileUpload() {
		try {
			FileInputStream fis = new FileInputStream(getFiledata());
			File directory = new File(getRealPath() + savePath);
			if (!directory.exists()) {// 如果目录不存在，则创建
				directory.mkdirs();
			}

			if (isFilenameNew == 1) {
				Random rand = new Random();
				String filenameNew = DateUtil.setDateFormat(new Date(),
						"HHmmss")
						+ rand.nextInt(100000) + "_" + filename;
				filename = filenameNew;
			}

			FileOutputStream fos = new FileOutputStream(directory
					+ File.separator + filename);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fis.close();
			fos.close();
			return null;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @return
	 */
	public String toDeleteFile() {
		try {
			if (null != deleteFilepath && deleteFilepath.length > 0) {
				for (int i = 0; i < deleteFilepath.length; i++) {
					FileOperate.deleteFile(deleteFilepath[i]);
				}
			}
			this.addActionMessage("删除成功！");
			return forwardPage;
		} catch (Exception e) {
			getRequest().setAttribute("exception", e.toString());
			e.printStackTrace();
			return ERROR;
		}
	}
}
