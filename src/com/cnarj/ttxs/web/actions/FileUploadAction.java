package com.cnarj.ttxs.web.actions;


import java.io.File;

import com.cnarj.ttxs.util.FileOperate;
import com.cnarj.ttxs.web.actions.base.BaseAction;

/**
 * 编辑器上传图片Action类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年11月3日14:26:25
 */
public class FileUploadAction extends BaseAction {

	private File imgfile;
	private String imgfileContentType;
	private String imgfileFileName;
	private String imgPath;
	
	public String getImgPath() {		return imgPath;	}
	public void setImgPath(String imgPath) {		this.imgPath = imgPath;	}
	public File getImgfile() {		return imgfile;	}
	public void setImgfile(File imgfile) {		this.imgfile = imgfile;	}
	public String getImgfileContentType() {		return imgfileContentType;	}
	public void setImgfileContentType(String imgfileContentType) {		this.imgfileContentType = imgfileContentType;}
	public String getImgfileFileName() {		return imgfileFileName;	}
	public void setImgfileFileName(String imgfileFileName) {		this.imgfileFileName = imgfileFileName;	}

	/**
	 * 上传图片到服务器
	 * @return
	 */
	public String uploadImgAdmin(){
		

//		//图片地址
//		StringBuffer realpath = new StringBuffer();
//		String filerealpath = readsrcpath.append("userspacefile/")
//			.append(memberid)//用户
//			.append("/readbook/cover/")//博览群书资源封面
//			.toString();
//		//资源地址
//		readsrcpath = new StringBuffer();
//		String srcpath = readsrcpath.append("userspacefile/")
//			.append(memberid)//用户
//			.append("/readbook/souce/")//博览群书资源
//			.toString();
//		//保存封面名称
//		String covername = FileOperate.generateFileName(filename);
//		//保存资源名称
//		String srcname = FileOperate.generateFileName(soucename);
		
		
		String filepath = "img_news/";
		String filename = FileOperate.generateFileName(imgfileFileName);

		//上传资源封面图片,返回封面名称
		try {
			this.imgPath = FileOperate.fileUpload(imgfile,null, null, filepath, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(imgPath);
		return SUCCESS;
	}
}
