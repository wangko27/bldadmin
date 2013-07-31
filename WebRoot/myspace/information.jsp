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
    
    <title>您好，欢迎来到952116综合信息门户网！-- 我的资料</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/zzll.css" rel="stylesheet" type="text/css" />
  </head>
  
   <body>
  <jsp:include page="header.jsp"></jsp:include>
  <div class="mainbody_1">
  <div class="dde">
     <div class="uuop">
	 <jsp:include page="content_leftmenu.jsp"></jsp:include>
	 <div class="right">
        <div class="bobti">我的资料</div>
        <s:if test="#session.loginMemberType == 1">
        	 <div class="zzll">
	          <ul>
	          	<li class="ww">（温馨提示：您的基本资料，除了昵称可以修改，其他资料设定以后就无法修改，请再注册的时候认真填写。）</li>
	            <li>我的身份：学生</li>
	            <li>姓名：${student.xsXming}</li>
	            <li>性别：${student.sex}</li>
	            <li>生日：<c:if test="${not empty student.birthday}"><fmt:formatDate value="${student.birthday}" pattern="MM月dd日"/></c:if></li>
	            <li>学校：${schoolinfo.schName}</li>
	            <li>班级：${student.TClasses.bjMcheng}</li>
	            <li>年级：${student.TClasses.TStugrade.njMcheng}</li>
	            <li>昵称：${sessionScope.loginMemberNikename}</li>
	          </ul>
	        </div>
        </s:if>
        <s:elseif test="#session.loginMemberType == 2">
        	  <div class="zzll">
		          <ul>
		          	<li class="ww">（温馨提示：您的基本资料，除了昵称可以修改，其他资料设定以后就无法修改，请再注册的时候认真填写。）</li>
		            <li>我的身份：家长</li>
		            <li>手机号码：${parentAccount.accountName}</li>
		            <li>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${parentAccount.parentinfo.parentsName}</li>
		            <li>所&nbsp;&nbsp;在&nbsp;&nbsp;地：${parentAccount.parentinfo.workaddress }</li>
		            <li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：${sessionScope.loginMemberNikename}</li>
		          </ul>
		            <ul>
		            <li>孩子姓名：${student.xsXming}</li>
		            <li>孩子学校：${schoolinfo.schName}</li>
		            <li>所在年级：${student.TClasses.TStugrade.njMcheng}</li>
		            <li>所在班级：${student.TClasses.bjMcheng}</li>
		          </ul>
		        </div>
        </s:elseif>
        <s:elseif test="#session.loginMemberType == 3">
        	<div class="zzll">
	          <ul>
	          	<li class="ww">（温馨提示：您的基本资料，除了昵称可以修改，其他资料设定以后就无法修改，请再注册的时候认真填写。）</li>
	            <li>我的身份：老师</li>
	            <li>手机号码：${teacherinfo.moblie}</li>
	            <li>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${teacherinfo.name}</li>
	            <li>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<c:if test="${teacherinfo.sex eq 1}">男</c:if> <c:if test="${teacherinfo.sex eq 2}">女</c:if></li>
	            <li>所&nbsp;&nbsp;在&nbsp;&nbsp;地：${teacherinfo.address}</li>
	            <li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：${sessionScope.loginMemberNikename}</li>
	          </ul>
	            <ul>
	            <li>执教学校：${schoolinfo.schName}</li>
	            <li>任职职位：</li>
	            <li>所在年级：</li>
	            <li>所在班级：</li>
	          </ul>
	        </div>
        </s:elseif>
        <s:else>
        	 <div class="zzll">
		          <ul>
		          	<li class="ww">（温馨提示：您的基本资料，除了昵称可以修改，其他资料设定以后就无法修改，请再注册的时候认真填写。）</li>
		            <li>我的身份：普通用户</li>
		            <li>手机号码：${member.mobilephone}</li>
		            <li>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${member.memberAddInfo.realname}</li>
		            <li>所&nbsp;&nbsp;在&nbsp;&nbsp;地：${member.memberAddInfo.inaddr}</li>
		            <li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：${member.nikename}</li>
		          </ul>
		        </div>
         </s:else>
      </div>
  </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>