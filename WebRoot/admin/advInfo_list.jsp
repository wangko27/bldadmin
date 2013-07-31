<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="admin/skin/css/base.css" type="text/css" />
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	

  </head>
  
    
  <body>
     <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">

	    <tr bgcolor="#E7E7E7">
			<td height="24" colspan="5" background="skin/images/tbg.gif">&nbsp;管理员信息列表&nbsp;</td>
		</tr>
		<tr align="left" bgcolor="#FAFAF1" height="22">
		    <td>序号</td>
		    <td>管理员姓名</td>
		    <td>管理员Email</td>
		    <td>添加日期</td>
		    <td>操作</td>
		</tr>
 		<s:iterator value="adminList" status="st" id = "ad">
	 		<tr align="left" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		        <td align="left">&nbsp;&nbsp;<u><s:property value="#st.index+1" /></u></td>
		        <td align="left">&nbsp;&nbsp;<u><s:property value="adminname" /></u> </td>
		        <td align="left">&nbsp;&nbsp;<U>${fn:substring(email, 0, 15)}<s:if test="%{email.length()>15}">...</s:if></U></td>
		        <td align="left">&nbsp;&nbsp;<u><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></u> </td>
		        <td align="left">&nbsp;&nbsp;<a href="admin/adminDel.action?id=${adminid}" onclick="return(confirm('确定删除?'))">删除</a> &nbsp;</td>
		    </tr>
 		</s:iterator>
	     
	  <tr>
	      <td class="nv" colspan="5" align="right">
	  		
	   
          </td>
      </tr>
     <tr bgcolor="#FAFAF1">
       <td class="nv" colspan="5">
		<form id="form1" action="admin/adminList.action" method="post">
		<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
        </form>

		</td>
      </tr>
	</table>
   
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
    
  </body>
</html>
