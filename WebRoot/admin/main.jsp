<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<base target="_self">
    
    <title>main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="admin/skin/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/skin/css/main.css" />

  </head>
 
	<body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>
            <div style='float:left'> <img height="14" src="admin/skin/images/frame/book1.gif" width="20" />&nbsp;
                <h3 style="color: blue;">欢迎您登陆后台管理中心！</h3>
            </div>
	      <div style='float:right;padding-right:8px;'>
	        
	      </div></td>
	  </tr>
	  <tr>
	    <td height="1" background="admin/skin/images/frame/sp_bg.gif" style='padding:0px'></td>
	  </tr>
	</table>
	<!--  
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
	  <tr>
	    <td colspan="2" background="admin/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
	    	<div style='float:left'><span>快捷操作�</span></div>
	    	<div style='float:right;padding-right:10px;'></div>
	   </td>
	  </tr>
	  <tr bgcolor="#FFFFFF">
	    <td height="30" colspan="2" align="center" valign="bottom"><table width="100%" border="0" cellspacing="1" cellpadding="1">
	        <tr>
	          <td width="15%" height="31" align="center"><img src="admin/skin/images/frame/qc.gif" width="90" height="30" /></td>
	          <td width="85%" valign="bottom"><div class='icoitem'>
	              <div class='ico'><img src='admin/skin/images/frame/addnews.gif' width='16' height='16' /></div>
	              <div class='txt'><a href='../mgr/news.do?method=listNewsByCondition&kind=zxdt&pageNum=1'><u>�����板�ㄦ��<br></u></a></div>
	            </div>
	            <div class='icoitem'>
	              <div class='ico'><img src='admin/skin/images/frame/menuarrow.gif' width='16' height='16' /></div>
	              <div class='txt'><a href='../mgr/news.do?method=listNewsByCondition&kind=fwzn&pageNum=1'><u>�����℃�����<br></u></a></div>
	            </div>
	            <div class='icoitem'>
	              <div class='ico'><img src='admin/skin/images/frame/manage1.gif' width='16' height='16' /></div>
	              <div class='txt'><a href='../mgr/news.do?method=listNewsByCondition&kind=jkcs&pageNum=1'><u>��ュ悍甯歌��</u></a></div>
	            </div>
	            </td>
	        </tr>
	      </table></td>
	  </tr>
	</table>
	
	-->
	
	</body>
</html>
