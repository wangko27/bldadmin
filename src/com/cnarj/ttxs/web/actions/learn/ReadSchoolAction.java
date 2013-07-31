package com.cnarj.ttxs.web.actions.learn;

import java.util.List;


import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.learn.IReadShoolService;

@SuppressWarnings("serial")
public class ReadSchoolAction extends TogetherAction {

	private IReadShoolService readShoolService;
	private String nowpage;
	private String pagesize;
	private String liindex;
	private String subjectcode;
	private String selectInfo;
	public String getNowpage() {
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public IReadShoolService getReadShoolService() {
		return readShoolService;
	}

	public void setReadShoolService(IReadShoolService readShoolService) {
		this.readShoolService = readShoolService;
	}

	public String getLiindex() {
		return liindex;
	}

	public void setLiindex(String liindex) {
		this.liindex = liindex;
	}

	

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public String getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}
	@SuppressWarnings("unchecked")
	public String showSchools(){
		connMethod();
		getComTeachers();
		//设置page参数
		// 设置每页显示的条数
		page.setEveryPage(28);
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		
		result=readShoolService.getSchools(page);
		List<ArticleSrc> lists=result.getContent();
		this.setAttribute("schools", lists);
		return "showSchs";
	}

	/**
	 * 
	 */
	public String toPage(){
		String resultString="";//返回值
		String name="";//页面显示的变量名
		System.out.println(liindex+subjectcode+selectInfo);
		result =readShoolService.getAllResult(liindex, subjectcode, selectInfo);
		if(liindex.trim().equals("0")){//为首页面
			//resultString="index";
		}else if(liindex.trim().equals("1")){//一天一课
			name="onedays";
			resultString="oneDay";
			
		}else if(liindex.trim().equals("2")){//评学论道
			name="";
			resultString="pingdao";
		}else if(liindex.trim().equals("3")){//名师讲堂
			name="aticless";
			resultString="mingshi";
		}else if(liindex.trim().equals("4")){//名校风采
			name="schools";
			resultString="showSchs";
		}else if(liindex.trim().equals("5")){//群拦帛书
			name="list_readSrc";
			resultString="qunshu";
		}
		this.setAttribute(name, result.getContent());
		return resultString;
	}
}
