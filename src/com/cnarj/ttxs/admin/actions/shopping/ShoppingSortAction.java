package com.cnarj.ttxs.admin.actions.shopping;

import com.cnarj.ttxs.admin.service.shopping.IGoodsSortService;
import com.cnarj.ttxs.pojo.shop.GoodesCategory;
import com.cnarj.ttxs.web.actions.base.PageAction;

import java.io.IOException;
import java.util.List;
/**
 * 商城频道后台类别action - 商品类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年9月2日
 */
@SuppressWarnings("serial")
public class ShoppingSortAction extends PageAction {

	private String pageId;//查询分页的id
	private GoodesCategory category;//商品类别
	private String categoryName;//类别名称 或者 id
	private String isSell;//是否热销 sell销
	private IGoodsSortService sortService;
	private String catName;//是否名称查询
	public GoodesCategory getCategory() {
		return category;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getIsSell() {
		return isSell;
	}

	public void setIsSell(String isSell) {
		this.isSell = isSell;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategory(GoodesCategory category) {
		this.category = category;
	}

	public IGoodsSortService getSortService() {
		return sortService;
	}

	public void setSortService(IGoodsSortService sortService) {
		this.sortService = sortService;
	}
	/**
	 * 得到所有的主类别
	 * @return
	 */
	public String showAddPage(){//跳转到添加页面
		List<GoodesCategory> goodsList= sortService.getAllSort();//得到主类别
        this.setAttribute("goodsList", goodsList);
        return "showAddPage";
	}
	/**
	 * 添加方法
	 * @return
	 */
	public String addSrot(){
		String result="";
		boolean isSuccess=sortService.saveSrot(category);
		if(isSuccess){
			result="添加成功!";
		}else{
			result="添加失败!";
		}
		showAddPage();
		this.setAttribute("sucResult", result);
		return 
		"add";
	}
	/**
	 * 判断是否有同名
	 * @return
	 */
	public String isOccurSrot(){
		String result=null;
		boolean isOccurSrot=sortService.isOccurSrot(categoryName);
		if(isOccurSrot){
			result="1";
		}else{
			result="0";
		}
		try {
			getResponse().getWriter().print(result);
			getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 按条件得到所有的类别(查询所有,查询主类别下,是否热销)
	 */
	@SuppressWarnings("unchecked")
	public String byTermAllSrot(){
		//得到所有的主类别
        List<GoodesCategory> goodsList= sortService.getAllSort();
        this.setAttribute("goodsList", goodsList);

		page.setEveryPage(15);
		if(pageId!=null&&!pageId.trim().equals("")){
			gotoPage=pageId;
			pageId=null;
		}
		if(gotoPage==null||gotoPage.trim().equals("")||gotoPage.length()==0){
			gotoPage="1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
        categoryName = null;
		result=sortService.byConditionSort(page,categoryName,isSell,catName);//根据条件查找
		return "all";
	}
	/**
	 * 修改类别(根据类别id)
	 */
	public String updateSrot(){
		sortService.updateSrot(category);
		this.setAttribute("sucResult", "修改成功!");
		return "update";
	}
	/**
	 * 按id查询方法
	 */
	public String byIdQuery(){
		showAddPage();//得到所有的主类别
		category= sortService.getByIdQuery(categoryName);
		categoryName=null;
		return "find";
	}
	/**
	 * 删除类别的方法
	 * @return
	 */
	public String deleteSrot(){
		try {
			GoodesCategory goodesCategory=sortService.getByIdQuery(categoryName);
			//System.out.println(categoryName);
			if(goodesCategory.getGoodesCategories().size()==0&&goodesCategory.getGoodses().size()==0){
				sortService.deleteBySrotIdDeleteSrot(categoryName);
			}
			categoryName=null;
			byTermAllSrot();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "del";
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
}
