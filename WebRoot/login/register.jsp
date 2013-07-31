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
    
    <title>您好，欢迎来到952116综合信息门户网！ --  用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/log.css" rel="stylesheet" type="text/css" />
	<jsp:include page="../comm/include.jsp"></jsp:include>	
	<script type="text/javascript">
		$().ready(function(){
			$("#registerEamilForm").validate({meta:"validate"});
			
			$("#registerEamilSubmit").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				$("#registerEamilForm").submit();
				$("body").mask('正在为您发送邮件，请稍后。。。');
			});
			
		});
		
	
	</script>
  </head>
  <body>
   <jsp:include page="header.jsp"></jsp:include>
   <div class="mainbody">
  <div class="logo_1">家校快捷方便沟通的平台</div>
</div>
<div class="mainbody">
  <div class="zhuce">
    <div class="tit"><span>欢迎注册952116综合信息门户网！952116综合信息门户网是爱瑞杰公司旗下网站，绝不会向任何第三方透露您的手机号！</span> <a href="<%=basePath%>login/login.jsp">如果您已有账号！请登录</a></div>
    <form action="<%=basePath%>regSendEmail.action" method="post" id="registerEamilForm">
    <div class="juzh_1">
      <div class="rest_1">
        <ul>
          <li>请输入您的常用邮箱：</li>
          <li class="inppbj">
            <input name="registerEmail" id="registerEmail" type="text" class="email required" style="width: 278px" />
          </li>
          <li class="qur"><img src="<%=basePath%>img/login/qq1.gif" id="registerEamilSubmit"/></li>
        </ul>
      </div>
      
    </div>
    </form>
    <div>
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red" size="2px">说明：系统发送的验证码将发送至此邮箱，请注意查收。</font>
  </div>
  </div>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
