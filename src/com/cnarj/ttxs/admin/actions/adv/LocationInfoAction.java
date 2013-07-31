package com.cnarj.ttxs.admin.actions.adv;

import com.cnarj.ttxs.admin.service.adv.IAdvInfoService;
import com.cnarj.ttxs.pojo.adv.AdvInfo;
import com.cnarj.ttxs.pojo.sys.Admin;
import com.cnarj.ttxs.pojo.sys.LocationInfo;
import com.cnarj.ttxs.service.sys.ILocContentService;
import com.cnarj.ttxs.service.sys.ILocationInfoService;
import com.cnarj.ttxs.util.ImageSize;
import com.cnarj.ttxs.util.UploadFileUtils;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-20
 * Time: p.m.4:18
 * 广告位置管理
 */
public class LocationInfoAction extends PageAction{
    private LocationInfo locationInfo;
    private ILocationInfoService locationInfoService;
    private String advLocationId;
    private IAdvInfoService advInfoService;
    private ILocContentService locContentService;
    private AdvInfo advInfo;
    private Admin admin;
    private String locationId;
    private File img;
    private String imgFileName;


    //分页查询
    public String listByPage(){
        page.setEveryPage(20);
        if (gotoPage == null || gotoPage.trim().equals("")
                || gotoPage.length() == 0) {
            gotoPage = "1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result = locationInfoService.getAllLocation(page);
        return "success";
    }

    //用于接收用户发送过来的ajax请求，返回所有的广告位置的集合
    public String ajaxFindAll(){
        List<LocationInfo> locationInfoList = locationInfoService.getAllLocation();
        StringBuffer json=new StringBuffer();
        json.append("{locationList:[");
        for(int i=0;i<locationInfoList.size();i++){
            LocationInfo locInfo=locationInfoList.get(i);
            json.append("{\"id\":\"")
                    .append(locInfo.getLocationid())
                    .append("\"")
                    .append(",")
                    .append("\"locIntro\":\"")
                    .append(locInfo.getLocationintro())
                    .append("\"}");
            if(i==(locationInfoList.size()-1)){
                break;
            }
            json.append(",");
        }
        json.append("]}");
        this.ajaxJson(json.toString());
        return null;
    }
    // 根据字符串输出JSON，返回null
    public String ajaxJson(String jsonString) {
        return ajax(jsonString, "text/html");
    }
    // AJAX输出，返回null
    public String ajax(String content, String type) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    //添加广告位置
    public String add(){
        if(locationInfo.getNum()==null){
            locationInfo.setNum(1);
        }
        locationInfo.setCreatedate(new Date());
        locationInfo.setModifydate(new Date());
        locationInfoService.save(locationInfo);
        this.setAttribute("isSucc", "添加成功!");
        return "success";
    }


    //根据id进行修改
    public String update(){
        locationInfo.setModifydate(new Date());
        locationInfoService.update(locationInfo);
        this.setAttribute("isSucc", "更新成功!");
        return "success";
    }


    //根据id进行寻找
    public String find(){
         locationInfo = locationInfoService.get(advLocationId);
         this.setAttribute("locationInfo",locationInfo);
         return "findSuccess";
    }

    /**
     * 根据广告位置id,删除该广告
     * @return
     */
    public String delete(){
        if (advLocationId != null && !advLocationId.trim().equals("")) {
            //删除关联的广告信息表的记录
            List<AdvInfo>  advInfoList = advInfoService.getShowAllAdv(advLocationId);
            for (AdvInfo adv:advInfoList){
                 advInfoService.delete(adv);
            }
//            //删除关联的广告内容表的记录
//            List<LocContent> contentList = locContentService.findByLocationId(advLocationId);
//            for(LocContent content:contentList){
//                locContentService.delete(content);
//            }
            //删除广告位置表的记录
            locationInfo = locationInfoService.getById(advLocationId);
            locationInfoService.delete(locationInfo);
        }
        this.setAttribute("isSucc", "删除成功!");
        return "success";
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
            advInfoService.save(advInfo);
            return "addSucc";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 修改广告
     */
    public String updateAdvInfo() {
        advInfo.setModifydate(new Date());
        Map<String,Object> session = this.getSession();
        admin=(Admin)session.get("admin");
        advInfo.setAdmin(admin);
        locationInfo = locationInfoService.getById(locationId);
        locationInfo.setModifydate(new Date());
        advInfo.setLocationInfo(locationInfo);

        Gson gson = new Gson();
        List<String> imagePaths = new ArrayList<String>();
        if(img != null && imgFileName != null && !imgFileName.trim().equals("")){
            //保存上传的图片在服务器指定目录下
            //获取配置文件里面的服务器图片目录
            String uploadDir = UploadFileUtils.getUploadFilePath();
            // 在指定目录下面 自动生成目标文件路径
            String advPicPathInDB = genericDestFilePath(imgFileName);
            imagePaths.add(advPicPathInDB);
//                advInfo.setPhotoid(advPicPathInDB);
            String destFilePath = uploadDir+"/"+advPicPathInDB;
            // 创建目录
            File dir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
            if (!dir.exists()) {
                if (!dir.mkdirs())
                    throw new UnsupportedOperationException(String.format("create dir %s failed!", dir.getAbsolutePath()));
            }
            //在指定目录下生成图片
            try {
                IOUtils.copy(new FileInputStream(img), new FileOutputStream(new File(destFilePath)));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                return ERROR;
            }

            //压缩图片()
                UploadFileUtils.compressImages(destFilePath, new String[]{ ImageSize.INDEX_PPT_BIGPIC,
                        ImageSize.INDEX_PPT_LITTLEPIC ,ImageSize.INDEX_LEFT_ADV,ImageSize.INDEX_LONG_ADV} );
        }else {
            imagePaths.add(advInfo.getPhotoid());
        }
        advInfo.setPhotoid(gson.toJson(imagePaths));
        img = null;
        advInfoService.update(advInfo);
        // this.setAttribute("isSucc", "修改成功!");
        return "updateSucc";

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


    public String getAdvLocationId() {
        return advLocationId;
    }

    public void setAdvLocationId(String advLocationId) {
        this.advLocationId = advLocationId;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public ILocationInfoService getLocationInfoService() {
        return locationInfoService;
    }

    public void setLocationInfoService(ILocationInfoService locationInfoService) {
        this.locationInfoService = locationInfoService;
    }

    public IAdvInfoService getAdvInfoService() {
        return advInfoService;
    }

    public void setAdvInfoService(IAdvInfoService advInfoService) {
        this.advInfoService = advInfoService;
    }

    public ILocContentService getLocContentService() {
        return locContentService;
    }

    public void setLocContentService(ILocContentService locContentService) {
        this.locContentService = locContentService;
    }

    public AdvInfo getAdvInfo() {
        return advInfo;
    }

    public void setAdvInfo(AdvInfo advInfo) {
        this.advInfo = advInfo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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


}
