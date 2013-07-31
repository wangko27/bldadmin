<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/zzll.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>myspace/js/updatepwd.js"></script>
  </head>
  <body>
     <jsp:include page="header.jsp"></jsp:include>
  <div class="mainbody_1">
  <div class="dde">
     <div class="uuop">
	 <jsp:include page="content_leftmenu.jsp"></jsp:include>
	 <div class="right">
        <div class="bobti">密码修改</div>
        <input type="hidden" value="<%=basePath%>" id="basePath"/>
        <div class="zzll">         
          <ul> 
          	<li><b>登录密码修改：</b>  <span>（您可以重新设置您的登录密码，方便保密您的信息。限制6位数以上）</span></li>
          <li>当前登录密码：
              <input name="loginpassword" id="loginpassword" type="password" />
            </li>
             <li>新登录密码：&nbsp;&nbsp;&nbsp;
               <input name="newpassword" id="newpassword" type="password" />
            </li>
            <li>重复新密码：&nbsp;&nbsp;&nbsp;
              <input name="renewpassword" id="renewpassword" type="password" />
            </li>
            <li class="aal"><input name="updpwdSubmot" type="button" id="updpwdSubmot" class="qqd" />&nbsp;&nbsp;&nbsp;</li>
          </ul>
        </div>
      </div>
  </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
