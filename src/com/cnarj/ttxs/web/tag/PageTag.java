package com.cnarj.ttxs.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.cnarj.ttxs.pojo.Page;

/**
 * 公用分页标签
 * @author sly
 * 
 */
public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = -3455857999077797745L;
	
	/**
	 * 应用于分页标签的样式
	 */
	private String pageDiv;
	//分页信息
	private Page page;
//	跳转的action URL
//	private String url;
	//当前页码前和后
	private final int show=5;
	//分页go图片的路径
	private String goImg;
	
	private String formId;

	public PageTag() {

	}

	public PageTag(String pageDiv, Page page, String formId) {
		super();
		this.pageDiv = pageDiv;
		this.page = page;
//		this.url = url;
		this.formId = formId;
	}

//    此标签结构
//    <div class="page">
//      <ul>
//        <li><a href="#">首页</a></li>
//        <li><a href="#">上一页</a></li>
//        <li><a href="#">1</a></li>
//        <li><a href="#">2</a></li>
//        <li><a href="#">3</a></li>
//        <li><a href="#">4</a></li>
//        <li><a href="#">下一页</a></li>
//        <li><a href="#">尾页</a></li>
//      </ul>
//      <p><a href="#"><img src="../img/learning_img/gog.gif" /></a> <span>跳转到
//        <input name="" type="text" />
//        页</span></p>
//    </div>
	public int doStartTag() throws JspException {

		
		JspWriter out = pageContext.getOut();
		try {
			//"首页" "上一页"
			StringBuilder sb = new StringBuilder();
			sb.append("<div class=\""+pageDiv+"\">");
			sb.append("<ul>");
			if(page != null){
				if(page.getHasPrePage()){
					sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value=1;"+formId+".submit();\" >首页</a></li>");
					sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value="+String.valueOf(page.getCurrentPage()-1)+";"+formId+".submit();\">上一页</a></li>");
				}
				else{
					sb.append("<li><a href=\"javascript:;\">首页</a></li>");
					sb.append("<li><a href=\"javascript:;\">上一页</a></li>");
				}
				
				//中间数字
				
				//总页数小于等于总共要显示的页数
				if (page.getTotalPage() <= show * 2 + 1) {
					for (int i=1; i<=page.getTotalPage(); i++) {
						if (page.getCurrentPage() == i) {
							sb.append("<li><a href=\"javascript:;\" style=\" border:1px solid #851815; background:#c41c1b; color:#fff;\">"+i+"</a></li>");
						} else {
							sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value="+i+";"+formId+".submit();\">"+i+"</a></li>");
						}
					}	
				}
				//否则
				else {
					int startIndex = page.getCurrentPage() - show;
					if (startIndex <=1 ) {startIndex = 1;}
					
					int endIndex = page.getCurrentPage() + show;
					if (endIndex >= page.getTotalPage()) {endIndex = page.getTotalPage();}
					
					if (page.getCurrentPage()<=show) {endIndex = show * 2 + 1;}
					if(page.getCurrentPage()>=page.getTotalPage()-show){startIndex = page.getTotalPage()-(show*2);}
					
					for (int i=startIndex; i<=endIndex; i++) {
						if (page.getCurrentPage() == i) {
							sb.append("<li><a href=\"javascript:;\" style=\" border:1px solid #851815; background:#c41c1b; color:#fff;\">"+i+"</a></li>");
						} else {
							sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value="+i+";"+formId+".submit();\">"+i+"</a></li>");
						}
					}
				}
				
				//"下一页" "尾页"
				if(page.getHasNextPage()){
					sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value="+String.valueOf(page.getCurrentPage()+1)+";"+formId+".submit();\">下一页</a></li>");
					sb.append("<li><a href=\"javascript:document.getElementById('gotoPage').value="+String.valueOf(page.getTotalPage())+";"+formId+".submit();\">尾页</a></li>");
				}
				else{
					sb.append("<li><a href=\"javascript:;\">下一页</a></li>");
					sb.append("<li><a href=\"javascript:;\">尾页</a></li>");
				}
				sb.append("</ul>");
				sb.append("<p><a href=\"javascript:");
				sb.append("if(document.getElementById('gotoPage').value < 1)");
				sb.append("{document.getElementById('gotoPage').value = 1;}");
				sb.append("else if(document.getElementById('gotoPage').value > "+page.getTotalPage()+")");
				sb.append("{document.getElementById('gotoPage').value = "+page.getTotalPage()+";}");
				sb.append(formId+".submit();\"><img src=\""+goImg+"\"/></a> <span>跳转到");
				sb.append("<input id=\"gotoPage\"  name=\"gotoPage\" type=\"text\"  onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\"/>");
				sb.append("页</span></p>");
			}else{
				sb.append("<li><a href=\"javascript:;\">首页</a></li>");
				sb.append("<li><a href=\"javascript:;\">上一页</a></li>");
				sb.append("<li><a href=\"javascript:;\">下一页</a></li>");
				sb.append("<li><a href=\"javascript:;\">尾页</a></li>");
				sb.append("</ul>");
				sb.append("<p><a href=\"javascript:");
				sb.append("if(document.getElementById('gotoPage').value < 1)");
				sb.append("{document.getElementById('gotoPage').value = 1;}");
				sb.append("else if(document.getElementById('gotoPage').value > "+1+")");
				sb.append("{document.getElementById('gotoPage').value = "+1+";}");
				sb.append(formId+".submit();\"><img src=\""+goImg+"\"/></a> <span>跳转到");
				sb.append("<input id=\"gotoPage\"  name=\"gotoPage\" type=\"text\"  onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\"/>");
				sb.append("页</span></p>");
			}
			
			sb.append("</div>");
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
//	public int doStartTag() throws JspException {
//
//		
//		JspWriter out = pageContext.getOut();
//		try {
//			//"首页" "上一页"
//			StringBuilder sb = new StringBuilder();
//			sb.append("<div class=\""+pageDiv+"\">");
//			sb.append("<ul>");
//
//			if(page.getHasPrePage()){
//				sb.append("<li><a href=\""+url+"?gotoPage=1\">首页</a></li>");
//				sb.append("<li><a href=\""+url+"?gotoPage="+String.valueOf(page.getCurrentPage()-1)+"\">上一页</a></li>");
//			}
//			else{
//				sb.append("<li><a href=\"javascript:;\">首页</a></li>");
//				sb.append("<li><a href=\"javascript:;\">上一页</a></li>");
//			}
//			
//			//中间数字
//			
//			//总页数小于等于总共要显示的页数
//			if (page.getTotalPage() <= show * 2 + 1) {
//				for (int i=1; i<=page.getTotalPage(); i++) {
//					if (page.getCurrentPage() == i) {
//						sb.append("<li><a href=\""+url+"?gotoPage="+i+"\">"+i+"</a></li>");
//					} else {
//						sb.append("<li><a href=\""+url+"?gotoPage="+i+"\">"+i+"</a></li>");
//					}
//				}	
//			}
//			//否则
//			else {
//				int startIndex = page.getCurrentPage() - show;
//				if (startIndex <=1 ) {startIndex = 1;}
//				
//				int endIndex = page.getCurrentPage() + show;
//				if (endIndex >= page.getTotalPage()) {endIndex = page.getTotalPage();}
//				
//				if (page.getCurrentPage()<=show) {endIndex = show * 2 + 1;}
//				if(page.getCurrentPage()>=page.getTotalPage()-show){startIndex = page.getTotalPage()-(show*2);}
//				
//				for (int i=startIndex; i<=endIndex; i++) {
//					if (page.getCurrentPage() == i) {
//						sb.append("<li><a href=\"javascript:;\">"+i+"</a></li>");
//					} else {
//						sb.append("<li><a href=\""+url+"?gotoPage="+i+"\">"+i+"</a></li>");
//					}
//				}
//			}
//			
//			//"下一页" "尾页"
//			if(page.getHasNextPage()){
//				sb.append("<li><a href=\""+url+"?gotoPage="+String.valueOf(page.getCurrentPage()+1)+"\">下一页</a></li>");
//				sb.append("<li><a href=\""+url+"?gotoPage="+String.valueOf(page.getTotalPage())+"\">尾页</a></li>");
//			}
//			else{
//				sb.append("<li><a href=\"javascript:;\">下一页</a></li>");
//				sb.append("<li><a href=\"javascript:;\">尾页</a></li>");
//			}
//			sb.append("</ul>");
//			sb.append("<p><a href=\""+url+"\"><img src=\""+goImg+"\"/></a> <span>跳转到");
//			sb.append("<input name=\"gotoPage\" type=\"text\"  onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\"/>");
//			sb.append("页</span></p>");
//			sb.append("</div>");
//
//			out.print(sb.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return SKIP_BODY;
//	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public String getPageDiv() {
		return pageDiv;
	}

	public void setPageDiv(String pageDiv) {
		this.pageDiv = pageDiv;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getShow() {
		return show;
	}

	public String getGoImg() {
		return goImg;
	}

	public void setGoImg(String goImg) {
		this.goImg = goImg;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
