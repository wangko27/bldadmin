<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>404错误</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/common.css" rel="stylesheet" type="text/css" />
      <link href="css/adminlogin.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	setTimeout( "history.back() ",5000);
	</script>

  </head>
  
  <body>
  
  

	<div class="mainbody">
	  <div class="baoc">
	  	<p><span><b>对不起！</b></span></p>
		<p>您访问的页面不存在！</p> 
		<p><b>5秒以后返回上一页</b></p>
	  </div>

	</div>

    <div class="bottom">
        <div class="bot1">
            湖南舒天网络科技发展有限公司 Copyright(C)2004-2013 湘ICP备11007592号
            <br />

        </div>
    </div>
  
  </body>
</html>
