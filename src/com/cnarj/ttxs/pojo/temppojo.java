package com.cnarj.ttxs.pojo;

/**
 * 相册javaBean
 * @author Administrator
 *private String albumPath;//图片的路径
	private List<String> pictures;//路径下的所有图片名称
 */
public class temppojo {

	
	private String albumPath;//图片的路径
	private String[] pictures;//路径下的所有图片名称
	private String str_picture;//所有图片路径
	public String getStr_picture() {
		return str_picture;
	}
	public void setStr_picture(String str_picture) {
		this.str_picture = str_picture;
	}
	public String getAlbumPath() {
		return albumPath;
	}
	public void setAlbumPath(String albumPath) {
		this.albumPath = albumPath;
	}
	public String[] getPictures() {
		return pictures;
	}
	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}
	
}
