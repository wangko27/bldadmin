package com.cnarj.ttxs.web.actions.learn;

import java.util.Iterator;
import java.util.List;

import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;
import com.cnarj.ttxs.util.HtmlUtil;
import com.cnarj.ttxs.web.actions.base.PageAction;

@SuppressWarnings("serial")
public class OneDayOneTextAction extends PageAction {
	private IOneDayOneTextService oneTextService;
	private String subjectcode;//科目Id
	private String gradecode;//年级Id
	private int order;//类型
	private String readId;//一天一课的id号
	
	private String oneTime;//当前时间
	
	public String getOneTime() {
		return oneTime;
	}

	public void setOneTime(String oneTime) {
		this.oneTime = oneTime;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getSubjectcode() {
		return subjectcode;
	}

	public String getReadId() {
		return readId;
	}

	public void setReadId(String readId) {
		this.readId = readId;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public String getGradecode() {
		return gradecode;
	}

	public void setGradecode(String gradecode) {
		this.gradecode = gradecode;
	}


	public IOneDayOneTextService getOneTextService() {
		return oneTextService;
	}

	public void setOneTextService(IOneDayOneTextService oneTextService) {
		this.oneTextService = oneTextService;
	}
	/**
	 * 一天一课列表
	 * @return
	 */
	public String showOneDayOneText(){
		//设置page参数
		// 设置每页显示的条数
		// 根据statePage进行Page对象设置，并查询
		if (gotoPage == null || gotoPage.length() == 0) {
			gotoPage = "1";
		}
		page.setCurrentPage(Integer.parseInt(gotoPage));
		page.setEveryPage(10);
		result=oneTextService.getToDayReadSrc(subjectcode, gradecode,oneTime, order, page);
		if(result.getContent()!=null&&result.getContent().size()>0){
			List list=result.getContent();
			for(Iterator iter=list.iterator();iter.hasNext();){
				ReadSrc src=(ReadSrc) iter.next();
				if(src.getContentintro()!=null&&!src.getContentintro().trim().equals("")){
					src.setContentintro(HtmlUtil.splitAndFilterString(src.getContentintro(), 200));
				}
				
			}
		}
		oneTime=null;
		this.setAttribute("onedays", result.getContent());
		return "bytime";
	}
	/**
	 * 一天一课的对象
	 * @return
	 */
	public String showOneDayInfo(){
		//System.out.println(readId);
		ReadSrc readSrc=oneTextService.getByIdOneDayOneText(readId);//根据id得到的对象
		if(readSrc==null){
			System.out.println("没有该对象!");
		}
		/**
		 * 查询昨日课堂5条信息(按科目,一天一课,行数)
		 */
		List<ReadSrc> reads=oneTextService.getXiangGuangOneDayOneText(readSrc.getSubjectCode().getSubjectcode(), 5,readSrc.getReadsrcid());
		oneTextService.updateOneDayOneText(readSrc);//添加阅读次数
		String [] content=null;
		int contLength=0;
		if(readSrc.getContentintro()!=null&&!readSrc.getContentintro().trim().equals("")){
			content=readSrc.getContentintro()
			.split("<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>");//该处为内容分页
			contLength=content.length;
		}
		this.setAttribute("content", content);
		this.setAttribute("read", readSrc);
		this.setAttribute("reads", reads);
		this.setAttribute("srclength", contLength);
		return "oneDayInfo";
	}

}
