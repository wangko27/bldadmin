<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script language="javascript" src="<%=basePath%>js/ad.js"></script>
<script type="text/javascript">
	function isSubmit(){
				var name=$("#topName").val();
				if(name==''){
					alert("请输入关键字!");
					return false;
				}else{
					topForm.submit();;
				}
				return false;
			}

</script>
</head>
<body>
	<jsp:include page="/base/top.jsp"></jsp:include>
	<jsp:include page="/base/toplink.jsp"></jsp:include>
		<input type="hidden" id="path" value="<%=basePath%>" />
<div class="mainbody">
  <div class="logo_ll">
   <form name="topForm" method="post" action="<%=basePath %>/Article/News_Index!search.action">
    <ul>
      <li class="img"><a href="#"><img src="img/news_img/logo.gif" /></a></li>
  
      <li>
        <select name="Type">
					<option value="8a80818c31bb7cc50131bb805c4a0007">教育看点</option>
					<option value="8a8081a131cd5fcd0131cd6a83e40005">新闻动态</option>
					<option value="8a80818c31bb7cc50131bb7fbde70002">生活百科</option>
					<option value="dayi">答疑小博士</option>
        </select>
      </li>
      <li>
      	 <input type="text" value="" id="topName" name="topName"/>
        <a href="#" onclick="return isSubmit();"><img src="img/learning_img/go.gif" /></a>
      </li>
    </ul>
    </form>
  </div>
</div>
<div class="mainbody">
  <div class="learning_menu">
    <ul>
      <li><b><a href="<%=basePath %>Article/Show_News_Index.action">资讯主页</a></b></li>
      <li><a href="<%=basePath %>Article/getArticleByEducationType.action?id=8a80818c31bb7cc50131bb805c4a0007">教育看点</a></li>
      <li><a href="<%=basePath %>Article/listNews.action">新闻动态</a></li>
      <li><a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002">生活百科</a></li>
    <li><a href="<%=basePath %>Article/listQuestion.action?id=">答疑小博士</a></li>
    </ul>
  </div>
    <div class="commongao">
    <div class="didan"><a href="<%=basePath %>Article/Show_QuestionAdd.action"><img src="img/news_img/yidaan.gif" /></a> <span>请将您的疑问告诉我们，让网友一起来帮你解决！</span></div>
  </div>
</div>
</body>
</html>