<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 资料修改</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/zzll.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#updateBtn").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				$("#updForm").submit();
			});
		});
	</script>
  </head>
  
  <body>
     <jsp:include page="header.jsp"></jsp:include>
  <div class="mainbody_1">
  <div class="dde">
     <div class="uuop">
	 <jsp:include page="content_leftmenu.jsp"></jsp:include>
	 <div class="right">
        <div class="bobti">个人资料修改</div>
        <form action="<%=basePath%>member/memberLogin!updateInfo.action" method="post" id="updForm">
        <div class="zzll">
          <ul>
          	<li class="ww">（温馨提示：您的基本资料，除了昵称可以修改，其他资料设定以后就无法修改）</li>
          </ul>
          <ul> 
          	<li><b>修改昵称：</b>  <span>（您可以设置昵称，方便保密您的信息。昵称的字数在10个字符以内(中文为两个字符)。）</span></li>
          <li>昵称：
              <input name="nikename" id="nikename" type="text" />
            </li>
            <li class="aal"><input name="updateBtn" type="button" id="updateBtn" class="qqd" />&nbsp;&nbsp;&nbsp;</li>
            </ul>
        </div>
        </form>
      </div>
  </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<!-- 信息显示 -->
 <jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
