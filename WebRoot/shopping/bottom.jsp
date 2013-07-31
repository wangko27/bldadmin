<%@ page language="java" pageEncoding="utf-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<base href="<%=basePath%>"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shopping_common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/shopping/shlist_2.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div class="mainbody">
	  <div class="commondi"><a href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a> | <a href="#">技术服务</a> | <a href="#">友情链接</a> | <a href="#">网站导航</a> | <a href="#">广告服务</a> | <a href="#">合作伙伴</a> | <a href="#">帮助中心</a><span><a name="aa" id="aa"></a><a href="#"><img src="<%=basePath%>img/learning_img/fan.gif" /></a></span></div>
	  <div class="tima">@2011 952116.com 版权所有 ICP09002922号备 湖南爱瑞杰科技发展股份有限公司
  <script src="http://s20.cnzz.com/stat.php?id=3555187&web_id=3555187&show=pic1" language="JavaScript"></script></div>
	</div>
  </body>
</html>
