package com.cnarj.ttxs.admin.actions.adv;

import com.cnarj.ttxs.admin.service.adv.IAdvInfoService;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.util.ImageSize;
import com.cnarj.ttxs.util.UploadFileUtils;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 广告action类 - 广告
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月13日22:24:18
 */
@SuppressWarnings("serial")
public class AdvInfoAction extends PageAction {

	private AdvInfo advInfo;
	private String advId;
	private IAdvInfoService infoService;
    private ILocationInfoService locationInfoService;
    private LocationInfo locationInfo;

	private String locationId;
	private File img;
	private String imgFileName;
	private String loctId;
    private Admin admin;

	private String lj;//

	public String getLoctId() {
		return loctId;
	}

	public String getLj() {
		return lj;
	}

	public void setLj(String lj) {
		this.lj = lj;
	}

	public void setLoctId(String loctId) {
		this.loctId = loctId;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getAdvId() {
		return advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public AdvInfo getAdvInfo() {
		return advInfo;
	}

	public void setAdvInfo(AdvInfo advInfo) {
		this.advInfo = advInfo;
	}

	public IAdvInfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(IAdvInfoService infoService) {
		this.infoService = infoService;
	}

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ILocationInfoService getLocationInfoService() {
        return locationInfoService;
    }

    public void setLocationInfoService(ILocationInfoService locationInfoService) {
        this.locationInfoService = locationInfoService;
    }

    /**
	 * 得到广告的位置id
	 * 
	 * @return
	 */
	public String getAdvAddress() {
		StringBuffer jsonString = new StringBuffer();
		List<LocationInfo> locats = infoService.getAllLocationInfo(lj);
		jsonString.append("{gcs:[");
		for (int i = 0; i < locats.size(); i++) {
			LocationInfo li = locats.get(i);
			jsonString.append("{\"id\":\"").append(li.getLocationid()).append(
					"\"").append(",").append("\"name\":\"").append(li.getLocationintro()).append(
                    "\"").append(",").append("\"size\":\"").append(li.getLocationSize()).append("\"}");
			if (i == (locats.size() - 1)) {
				break;
			}
			jsonString.append(",");
		}
		jsonString.append("]}");
		lj = null;
		return ajaxJson(jsonString.toString());
	}

	/**
	 * 添加广告
	 */
	public String addAdvInfo() {
		try {
			advInfo.setCreatedate(new Date());
			advInfo.setModifydate(new Date());
            Map<String,Object> session = this.getSession();
            admin=(Admin)session.get("admin");
			advInfo.setAdmin(admin);
			advInfo.setAdvtype(new Long(1));// 1代表图片
			advInfo.setShowtype(new Long(1));// 1代表图片
			advInfo.setUpusername(admin.getUsername());// 用户名称
            locationInfo = locationInfoService.getById(locationId);
            advInfo.setLocationInfo(locationInfo);

            //上传广告图片
            List<String> imagePaths = new ArrayList<String>();
			if(img != null){
                //保存上传的图片在服务器指定目录下
                //获取配置文件里面的服务器图片目录
                String uploadDir = UploadFileUtils.getUploadFilePath();
                // 在指定目录下面 自动生成目标文件路径
                String advPicPathInDB = genericDestFilePath(imgFileName);
                imagePaths.add(advPicPathInDB);
                String destFilePath = uploadDir+"/"+advPicPathInDB;
                // 创建目录
                File dir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
                if (!dir.exists()) {
                    if (!dir.mkdirs())
                        throw new UnsupportedOperationException(String.format("create dir %s failed!", dir.getAbsolutePath()));
                }
                //在指定目录下生成图片
                IOUtils.copy(new FileInputStream(img), new FileOutputStream(new File(destFilePath)));
                //压缩图片()
                UploadFileUtils.compressImages(destFilePath, new String[]{ ImageSize.INDEX_PPT_BIGPIC,
                        ImageSize.INDEX_PPT_LITTLEPIC,ImageSize.INDEX_LEFT_ADV,ImageSize.INDEX_LONG_ADV} );
            }
            Gson gson = new Gson();
            advInfo.setPhotoid(gson.toJson(imagePaths));
			String isSucc = "添加成功!";
			this.setAttribute("isSucc", isSucc);
			infoService.save(advInfo);
			return "addSucc";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

    /**
     * 在指定目录下面 自动生成目标文件路径
     * @param fileName  文件名
     * @return
     */
    private  String genericDestFilePath(String fileName) {
        Calendar cal = Calendar.getInstance();
        String month;
        int monthNumber = cal.get(Calendar.MONTH) + 1;
        if (monthNumber < 10) {
            month = "0" + monthNumber;
        } else {
            month = String.valueOf(monthNumber);
        }
        String calDate;
        if (cal.get(Calendar.DATE) < 10) {
            calDate = "0" + cal.get(Calendar.DATE);
        } else {
            calDate = String.valueOf(cal.get(Calendar.DATE));
        }
        return String.format("%s/%s/%s/%s",
                cal.get(Calendar.YEAR), month, calDate,System.currentTimeMillis() + getExtention(fileName).toLowerCase());
    }

	/**
	 * 图片的重命名
	 * 
	 * @param fileName
	 * @return
	 */
	private String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	/**
	 * 查找广告
	 */
	public String findByid() {
		AdvInfo info = infoService.get(advId);
        List<String> stringList = getImagePaths(info.getPhotoid());
        if(stringList != null && stringList.size() > 0){
            info.setPhotoid(stringList.get(0));
        }
		this.setAttribute("info", info);
		return "findSucc";
	}


	/**
	 * 删除
	 */
	public String delAdvInfo() {
		if (advId != null && !advId.trim().equals("")) {
			infoService.delete(advId);
		}
		this.setAttribute("isSucc", "删除成功!");
		showAdv();
		return "delSucc";
	}

	/**
	 * 查找所有的广告信息
	 */
	public String showAdv() {
		page.setEveryPage(5);
		if (gotoPage == null || gotoPage.trim().equals("")
				|| gotoPage.length() == 0) {
			gotoPage = "1";
		}
		if (locationId != null && !locationId.trim().equals("")) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result = infoService.getShowAllAdv(locationId, page);
        //图片格式处理
        if(result != null&& result.getContent()!= null  && result.getContent().size() > 0){
            List<AdvInfo>  list = (List<AdvInfo>)result.getContent();
            for(AdvInfo adv:list){
                List<String> stringList = getImagePaths(adv.getPhotoid());
                if(stringList != null && stringList.size() > 0 ){
                    adv.setPhotoid(stringList.get(0));
                }
            }
        }
		this.setAttribute("advs", result.getContent());
		locationId = null;
		return "selectSucc";
	}

    public   List<String> getImagePaths(String images){
        try{
            return new Gson().fromJson(images,new TypeToken<List<String>>(){}.getType());
        }catch (Exception e){
            return null;
        }
    }

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	/**
	 * 根据广告位置的id 得到广告信息
	 */
	public String queryByLocactionId() {
		AdvInfo byInfo = infoService.get("locationInfo.locationname", loctId);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{");
		if (byInfo != null && byInfo.getAdvstat().equals("1")) {
			jsonString.append("path:'").append(byInfo.getPhotoid()).append(
					"',href:'").append(byInfo.getHyperlink()).append(
					"',title:'").append(byInfo.getAdvtitle()).append("'");
		}
		jsonString.append("}");
		return ajaxJson(jsonString.toString());
	}


    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }
}
