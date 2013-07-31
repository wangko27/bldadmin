package com.cnarj.ttxs.admin.actions.shopping;


import com.cnarj.ttxs.admin.service.shopping.IBrandService;
import com.cnarj.ttxs.admin.service.shopping.IGoodsService;
import com.cnarj.ttxs.admin.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.pojo.shop.Brand;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.pojo.shop.Goods;
import com.cnarj.ttxs.util.ImageSize;
import com.cnarj.ttxs.util.UploadFileUtils;
import com.cnarj.ttxs.web.actions.base.PageAction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 商城频道后台action类 - 商品
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
@SuppressWarnings("serial")
public class ShoppingGoodsAction extends PageAction {

	private Goods goods;//商品
	private String goodsKey;//商品的id  或者名称,或者关键字
	private IGoodsSortService sortService;//商品类别
	private IGoodsService goodsService;//商品
	private String gSortId;//类型id
	private File [] pic;//上传的图片
	private String [] picFileName;//图片路径
    private File upload;//商品描述中的图片
    private String uploadFileName;   //商品描述中的图片的文件名
    private String categoryId;//类别id
    private String [] oldpic;//商品修改页面，商品以前的图片
    private String categoryName;//商品管理页面，按照商品的类别来搜索商品
    private Brand brand ;
    private IBrandService brandService;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getOldpic() {
        return oldpic;
    }

    public void setOldpic(String[] oldpic) {
        this.oldpic = oldpic;
    }




    private static final int BUFFER_SIZE = 16 * 1024 ;//缓存

	private String oldSrot;//以前的类型
	
	public String getOldSrot() {
		return oldSrot;
	}

	public void setOldSrot(String oldSrot) {
		this.oldSrot = oldSrot;
	}

	/*public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}*/
    public File[] getPic() {
        return pic;
    }

    public String[] getPicFileName() {
        return picFileName;
    }


    public String getGSortId() {
		return gSortId;
	}

	public void setGSortId(String sortId) {
		gSortId = sortId;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public IGoodsSortService getSortService() {
		return sortService;
	}

	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}

	public String getGoodsKey() {
		return goodsKey;
	}

	public void setGoodsKey(String goodsKey) {
		this.goodsKey = goodsKey;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * 添加商品的方法
	 * @return
	 */
	public String addGoods() throws IOException {
        GoodesCategory category = sortService.get(categoryId);
        if(category == null){
            this.setAttribute("chonggong", "添加失败!");
            return "add";
        }
        goods.setGoodesCategory(category);
		goods.setCreatedate(new Date());
		goods.setModifydate(new Date());
		//Goods goods1=goods;
		goods.setOccupiedstock(new Long(0));
		goods.setProductpoint(new Long(0));
		goods.setCommentsnum(new Long(0));
		goods.setSharenum(new Long(0));
		goods.setCollectionnum(new Long(0));
		goods.setProductsales(new Long(0));
		goods.setGeneralscore(new Long(0));
		goods.setAttention(new Long(0));
        brandService.save(brand);
        goods.setBrand(brand);

       //保存上传的图片在WebRoot根目录下
//		System.out.println("addGoods  is running...,picFileName="+picFileName);
//		String imageFileName = new Date().getTime() + getExtention(picFileName);
//        System.out.println("addGoods  is running...,imageFileName="+imageFileName);
//		try {
//			File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "uploadfiles/shopping/UploadImages") , imageFileName);
//			if(!imageFile.getParentFile().exists()) imageFile.getParentFile().mkdirs();
//			FileUtils.copyFile(pic, imageFile);
//		} catch (RuntimeException e) {
//			this.setAttribute("chonggong", "添加失败!");
//			e.printStackTrace();
//			return "add";
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		goods.setPhotospath("uploadfiles/shopping/UploadImages/"+imageFileName);

        //保存上传的图片在服务器指定目录下
        //获取配置文件里面的服务器图片目录
        List<String> imagePaths = new ArrayList<String>();

        if( picFileName != null && picFileName.length > 0 ){
            for(int x = 0 ; x<picFileName.length; x++){
                if(picFileName[x] != null && !"".equals(picFileName[x].trim())){
                    String uploadDir = UploadFileUtils.getUploadFilePath();
                    // 在指定目录下面 自动生成目标文件路径
                    String picFilePathInDB = genericDestFilePath(picFileName[x]);
                    imagePaths.add(picFilePathInDB);

                    String destFilePath = uploadDir+"/"+picFilePathInDB;
//        创建目录
                    File dir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
                    if (!dir.exists()) {
                        if (!dir.mkdirs()) {
                            throw new UnsupportedOperationException(String.format("create dir %s failed!", dir.getAbsolutePath()));
                        }
                    }
//        System.out.println("dir.getAbsolutePath()="+dir.getAbsolutePath());
                    //在指定目录下生成图片
                    IOUtils.copy(new FileInputStream(pic[x]), new FileOutputStream(new File(destFilePath)));
                    //压缩图片()
                    UploadFileUtils.compressImages(destFilePath, new String[]{ ImageSize.INDEX_MIAOSHA,ImageSize.INDEX_FENLEI,
                            ImageSize.XIANGXI_DATU,ImageSize.XIANGXI_SUOLUETU,ImageSize.LIST_SUOLUETU,ImageSize.LIST_XIANGGUAN,
                            ImageSize.XIANGXI_HOTS,ImageSize.ORDER_SUOLUETU} );

                }
            }

        }

        Gson gson = new Gson();
        goods.setPhotospath(gson.toJson(imagePaths));

//        System.out.println("addGoods  is running...,goods.getPhotospath()="+goods.getPhotospath());
        goodsService.save(goods);

		//修改子类的数量
		GoodesCategory clicder=sortService.get(goods.getGoodesCategory().getCategoryid());
		long goNun=clicder.getGoodsnum();
		goNun=goNun+1;
		clicder.setGoodsnum(goNun);
		sortService.update(clicder);
		//修改父类的数量
		GoodesCategory paten=sortService.get(clicder.getGoodesCategory().getCategoryid());
		long patenNun=clicder.getGoodsnum();
		patenNun=patenNun+1;
		clicder.setGoodsnum(patenNun);
		sortService.update(paten);
		
	    this.setAttribute("chonggong", "添加成功!");
	    goods=null;
		return SUCCESS;
	}

    /**
     *  自动生成目标文件路径
     * @param fileName  文件名
     * @param
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
	 * 图片的扩展名
	 * @param fileName
	 * @return
	 */
	private  String getExtention(String fileName)  {
        int pos = fileName.lastIndexOf(".");
      //String ex=fileName.substring(pos);
        return fileName.substring(pos);
   } 
	/**
	 * 删除商品的方法
	 * @return
	 */
	public String deleteGoods(){
		Goods goods=goodsService.get(goodsKey);
		if(goods.getCarItems().size()==0&&goods.getOrderItems().size()==0){
			goodsService.delete(goodsKey);
			//修改子类的数量
			GoodesCategory clicder=sortService.get(goods.getGoodesCategory().getCategoryid());
			long goNun=clicder.getGoodsnum();
			goNun=goNun-1;
			if(goNun<0){
				goNun=0;
			}
			clicder.setGoodsnum(goNun);
			sortService.update(clicder);
			//修改父类的数量
			GoodesCategory paten=sortService.get(clicder.getGoodesCategory().getCategoryid());
			long patenNun=clicder.getGoodsnum();
			patenNun=patenNun-1;
			if(patenNun<0){
				patenNun=0;
			}
			clicder.setGoodsnum(patenNun);
			sortService.update(paten);
			this.setAttribute("chonggong", "删除成功!");
		}else{
			this.setAttribute("chonggong", "删除失败!该商品正在使用..");
		}
		goodsKey=null;
		
		return tyTrimGoods();
	}
	/**
	 * 修改商品的方法
	 * @return
	 */
	public String updateGoods() throws IOException {
		goods.setModifydate(new Date());
        brandService.save(brand);
        goods.setBrand(brand);
        Gson gson = new Gson();
        List<String> imagePaths = new ArrayList<String>(Arrays.asList(oldpic));
        if( picFileName != null && picFileName.length > 0 ){
            for(int x = 0 ; x<picFileName.length; x++){
                if(picFileName[x] != null && !"".equals(picFileName[x].trim())){
                    String uploadDir = UploadFileUtils.getUploadFilePath();
                    // 在指定目录下面 自动生成目标文件路径
                    String picFilePathInDB = genericDestFilePath(picFileName[x]);
                    imagePaths.add(picFilePathInDB);

                    String destFilePath = uploadDir+"/"+picFilePathInDB;
//        创建目录
                    File dir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
                    if (!dir.exists()) {
                        if (!dir.mkdirs()) {
                            throw new UnsupportedOperationException(String.format("create dir %s failed!", dir.getAbsolutePath()));
                        }
                    }
//        System.out.println("dir.getAbsolutePath()="+dir.getAbsolutePath());
                    //在指定目录下生成图片
                    IOUtils.copy(new FileInputStream(pic[x]), new FileOutputStream(new File(destFilePath)));
                    //压缩图片()
                    /*UploadFileUtils.compressImages(destFilePath, new String[]{ ImageSize.INDEX_MIAOSHA,ImageSize.INDEX_FENLEI,
                            ImageSize.XIANGXI_DATU,ImageSize.XIANGXI_SUOLUETU,ImageSize.LIST_SUOLUETU,ImageSize.LIST_XIANGGUAN,
                            ImageSize.XIANGXI_HOTS,ImageSize.ORDER_SUOLUETU} );*/

                }
            }

        }
        goods.setPhotospath(gson.toJson(imagePaths));

		//////////////////////////////////////////////////////////////////////////////////修改子类的数量
		GoodesCategory newclicder=sortService.get(goods.getGoodesCategory().getCategoryid());
		//修改父类的数量
		GoodesCategory newpaten=sortService.get(newclicder.getGoodesCategory().getCategoryid());
		
		//旧父类的数量
		GoodesCategory oldclicder=sortService.get(oldSrot);
		GoodesCategory oldpaten=sortService.get(oldclicder.getGoodesCategory().getCategoryid());
		if(!goods.getGoodesCategory().getCategoryid().equals(oldSrot)){//子类型数量变
			long goNun=oldclicder.getGoodsnum();//旧的
			goNun=goNun-1;
			if(goNun<0){
				goNun=0;
			}
			oldclicder.setGoodsnum(goNun);
			sortService.update(oldclicder);
			long goNun1=newclicder.getGoodsnum();//新的
			goNun1=goNun1+1;
			newclicder.setGoodsnum(goNun1);
			sortService.update(newclicder);
			if(!newclicder.getGoodesCategory().getCategoryid().equals(oldclicder.getGoodesCategory().getCategoryid())){
				long goNun2=oldpaten.getGoodsnum();//旧的
				goNun2=goNun2-1;
				if(goNun2<0){
					goNun2=0;
				}
				oldpaten.setGoodsnum(goNun2);
				sortService.update(oldpaten);
				long goNun3=newpaten.getGoodsnum();//新的
				goNun3=goNun3+1;
				newpaten.setGoodsnum(goNun3);
				sortService.update(newpaten);
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////
		goodsService.update(goods);
		
		setAttribute("chonggong", "修改成功!");
		goods=null;
		goodsKey=null;
		return tyTrimGoods();
	}
	/**
	 * 显示所有的方法(分页,按条件)
	 * @return
	 */
	public String tyTrimGoods(){
		
		page.setEveryPage(12);
		if(gotoPage==null||gotoPage.trim().equals("")||gotoPage.length()==0){
			gotoPage="1";
		}
//		System.out.println(gotoPage);
		page.setCurrentPage(Integer.parseInt(gotoPage));
		result=goodsService.getByTrimGoods(page,goodsKey);
		//Result result2=result;
		goodsKey=null;
		return "sel";
	}

    /**
     * 商品管理页面
     * 按照商品的类别，分页获取商品
     * @return result
     */
    public String findByCategoryName(){
        page.setEveryPage(12);
        if(gotoPage==null||gotoPage.trim().equals("")||gotoPage.length()==0){
            gotoPage="1";
        }
        page.setCurrentPage(Integer.parseInt(gotoPage));
        result=goodsService.findByCategoryName(page, categoryName);
        categoryName=null;
        return SUCCESS;
    }


	/**
	 * 显示主类别
	 */
	public String showMainGoodsSort(){
		List<GoodesCategory> gCategory=sortService.getAllSort();//得到所有的类别
		StringBuffer json=new StringBuffer();
		json.append("{gcs:[");
		for(int i=0;i<gCategory.size();i++){
			GoodesCategory gc=gCategory.get(i);
			json.append("{\"id\":\"")
			.append(gc.getCategoryid())
			.append("\"")
			.append(",")
			.append("\"name\":\"")
			.append(gc.getCategoryname())
			.append("\"}");
			if(i==(gCategory.size()-1)){
				break;
			}
			json.append(",");
		}
		json.append("]}");
		this.ajaxJson(json.toString());
		return null;
	}
	/**
	 * 显示子类别
	 */
	public String showSubtype(){
		GoodesCategory cat=sortService.get(gSortId);
		int i=0;
		StringBuffer json=new StringBuffer();
		json.append("{gcs:[");
		List<GoodesCategory> catChild=cat.getGoodesCategories();
		for(Iterator iter=catChild.iterator();iter.hasNext();){
			GoodesCategory gc=(GoodesCategory) iter.next();
			json.append("{\"id\":\"")
			.append(gc.getCategoryid())
			.append("\"")
			.append(",")
			.append("\"name\":\"")
			.append(gc.getCategoryname())
			.append("\"}");
			if(i==(catChild.size()-1)){
				break;
			}
			json.append(",");
			i++;
		}
		json.append("]}");
		this.ajaxJson(json.toString());
		return null;
	}
	/**
	 * 显示当个商品
	 */
	public String showGoods(){
		goods=goodsService.get(goodsKey);
        Gson gson = new Gson();
        List<String> imagePath = gson.fromJson(goods.getPhotospath(),new TypeToken<List<String>>(){}.getType());
        ActionContext.getContext().getValueStack().set("list",imagePath);
		return "oneGoods";
	}



    public String saveGoodsDescriptPic () throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();

        // CKEditor提交的很重要的一个参数
        String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum");
        if(upload.length() > 1024*1024){
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于1MB');");
            out.println("</script>");
            return null;
        }

        StringBuffer json=new StringBuffer();
        if(upload != null ){
            String uploadDir = UploadFileUtils.getUploadFilePath();
            // 在指定目录下面 自动生成目标文件路径
            String picFilePath =genericDestFilePath(uploadFileName);
            String destFilePath = uploadDir+"/"+picFilePath;
//        创建目录
            File dir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    throw new UnsupportedOperationException(String.format("create dir %s failed!", dir.getAbsolutePath()));
                }
            }
//        System.out.println("dir.getAbsolutePath()="+dir.getAbsolutePath());
            //在指定目录下生成图片
            IOUtils.copy(new FileInputStream(upload), new FileOutputStream(new File(destFilePath)));
            json.append(destFilePath);

            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction("+ callback + ",'" +"/upload/"+ picFilePath + "','')");
            out.println("</script>");
        }
        this.ajaxJson(json.toString());
        return null;
    }



    public void setPic(File[] pic) {
        this.pic = pic;
    }

    public void setPicFileName(String[] picFileName) {
        this.picFileName = picFileName;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getgSortId() {
        return gSortId;
    }

    public void setgSortId(String gSortId) {
        this.gSortId = gSortId;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public IBrandService getBrandService() {
        return brandService;
    }

    public void setBrandService(IBrandService brandService) {
        this.brandService = brandService;
    }
}
