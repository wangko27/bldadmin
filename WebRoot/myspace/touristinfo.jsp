<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../comm/common_tag.jsp" %>
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
    		$("#updSubmitBtn").hover(function(){
    			$(this).css("cursor","hand");
    		}).click(function(){
    			$("#infoForm").submit();
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
        <form action="<%=basePath%>member/memberLogin!updateInfo.action" method="post" id="infoForm">
        <div class="zzll">
          <ul>
            <li>我的身份：普通用户</li>
            <li>手机号码：${member.mobilephone}</li>
            <li>常用邮箱：<input name="email" id="email" type="text" value="${member.email}"/></li> 
            <li>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input name="realname" id="realname" type="text" value="${member.memberAddInfo.realname}" /></li>
            <li>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" value="男" <c:if test="${member.memberAddInfo.sex eq '男'}">checked="checked"</c:if>/>&nbsp;男 &nbsp;<input type="radio" name="sex" value="女" <c:if test="${member.memberAddInfo.sex eq '女'}">checked="checked"</c:if> />&nbsp;女
            </li>
            <li>所&nbsp;&nbsp;在&nbsp;&nbsp;地：<input name="inaddr" id="inaddr" type="text" value="${member.memberAddInfo.inaddr}" /></li>
            <li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input name="nikename" id="nikename" type="text" value="${member.nikename}"/></li>
          </ul>
          <ul> 
            <li class="aal"><input name="updSubmitBtn" id="updSubmitBtn" type="button" class="qqd" />&nbsp;&nbsp;&nbsp;</li>
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
