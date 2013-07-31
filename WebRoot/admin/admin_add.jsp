<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="admin/adminAdd.action" >
  <table>
  	<tr>
  		<td>
    	用户名:
  		</td>
  		<td>
  		<input type="text" name="admin.username">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	密码:
  		</td>
  		<td>
  		<input type="password" name="admin.adminpassword">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	重新输入密码:
  		</td>
  		<td>
  		<input type="password" name="repwd">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	E-mail:
  		</td>
  		<td>
  		<input type="text" name="admin.email">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	姓名:
  		</td>
  		<td>
  		<input type="text" name="admin.adminname">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	部门:
  		</td>
  		<td>
  		<input type="text" name="admin.department">
  		</td>
  	</tr>
  	<tr>
  		<td>
    	账号是否启用:
  		</td>
  		<td>
	  		<select name="admin.isaccountenabled">
		  	<option value="1">是</option>
		 	<option value="0">否</option>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>
    	账号是否锁定:
  		</td>
  		<td>
	  		<select name="admin.isaccountlocked">
		  		<option value="1">否</option>
			 	<option value="0">是</option>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>
    	账号是否过期:
  		</td>
  		<td>
	  		<select name="admin.isaccountexpired">
		  		<option value="1">否</option>
			 	<option value="0">是</option>
			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>
    	凭证是否过期:
  		</td>
  		<td>
	  		<select name="admin.iscredentialsexpired">
		  		<option value="1">否</option>
			 	<option value="0">是</option>
			</select>
  		</td>
  	</tr>
  	<%--<tr>--%>
  		<%--<td>--%>
    	<%--验证码:--%>
  		<%--</td>--%>
  		<%--<td>--%>
	  		<%--<input name="vali_user" type="text" /><img src="validatecode" id="voli"/> <a href="javascript:refresh()">更换验证码</a>--%>
  		<%--</td>--%>
  	<%--</tr>--%>
  	<tr><td colspan="2">
  		<input type="submit" value="提  交">
  	</td>  	</tr>
  </table>
  	<jsp:include page="../comm/message.jsp"></jsp:include>  
    </form>
     <%--<script type="text/javascript">--%>
	<%--function refresh(){--%>
	    <%--document.getElementById("voli").src='validatecode?now=' + new Date();--%>
	<%--}--%>
	<%--</script>--%>
  </body>
</html>
