<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="admin/skin/css/base.css" rel="stylesheet" type="text/css"/>
	<script language='javascript'>
	var preFrameW = '206,*';
	var FrameHide = 0;
	var curStyle = 1;
	var totalItem = 9;
	function ChangeMenu(way){
		var addwidth = 10;
		var fcol = top.document.all.btFrame.cols;
		if(way==1) addwidth = 10;
		else if(way==-1) addwidth = -10;
		else if(way==0){
			if(FrameHide == 0){
				preFrameW = top.document.all.btFrame.cols;
				top.document.all.btFrame.cols = '0,*';
				FrameHide = 1;
				return;
			}else{
				top.document.all.btFrame.cols = preFrameW;
				FrameHide = 0;
				return;
			}
		}
		fcols = fcol.split(',');
		fcols[0] = parseInt(fcols[0]) + addwidth;
		top.document.all.btFrame.cols = fcols[0]+',*';
	}
	
	
	function mv(selobj,moveout,itemnum)
	{
	   if(itemnum==curStyle) return false;
	   if(moveout=='m') selobj.className = 'itemsel';
	   if(moveout=='o') selobj.className = 'item';
	   return true;
	}
	
	function changeSel(itemnum)
	{
	  curStyle = itemnum;
	  for(i=1;i<=totalItem;i++)
	  {
	     if(document.getElementById('item'+i)) document.getElementById('item'+i).className='item';
	  }
	  document.getElementById('item'+itemnum).className='itemsel';
	}
	function exit(){
	if(confirm('您确定退出吗！')){
	return true;
	}else{
	return false;
	}
	}
	</script>
	<style>
	body { padding:0px; margin:0px; }
	#tpa {
		color: #009933;
		margin:0px;
		padding:0px;
		float:right;
		padding-right:10px;
	}
	
	#tpa dd {
		margin:0px;
		padding:0px;
		float:left;
		margin-right:2px;
	}
	
	#tpa dd.ditem {
		margin-right:8px;
	}
	
	#tpa dd.img {
	  padding-top:6px;
	}
	
	div.item
	{
	  text-align:center;
		background:url(admin/skin/images/frame/topitembg.gif) 0px 3px no-repeat;
		width:82px;
		height:26px;
		line-height:28px;
	}
	
	.itemsel {
	  width:80px;
	  text-align:center;
	  background:#226411;
		border-left:1px solid #c5f097;
		border-right:1px solid #c5f097;
		border-top:1px solid #c5f097;
		height:26px;
		line-height:28px;
	}
	
	*html .itemsel {
		height:26px;
		line-height:26px;
	}
	
	a:link,a:visited {
	 text-decoration: underline;
	}
	
	.item a:link, .item a:visited {
		font-size: 12px;
		color: #ffffff;
		text-decoration: none;
		font-weight: bold;
	}
	
	.itemsel a:hover {
		color: #ffffff;
		font-weight: bold;
		border-bottom:2px solid #E9FC65;
	}
	
	.itemsel a:link, .itemsel a:visited {
		font-size: 12px;
		color: #ffffff;
		text-decoration: none;
		font-weight: bold;
	}
	
	.itemsel a:hover {
		color: #ffffff;
		border-bottom:2px solid #E9FC65;
	}
	
	.rmain {
	  padding-left:10px;
	  /* background:url(skin/images/frame/toprightbg.gif) no-repeat; */
	}
	</style>
  </head>
  
  
	<body bgColor='#ffffff'>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" background="admin/skin/images/frame/top.jpg">
	  <tr>
	    <td width='38%' height="60"><img src="admin/skin/images/frame/top_logo.jpg" width="382" height="99" /></td>
	    <td width='62%' height="99" align="right" valign="bottom">
	    	<table width="600" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	      <td height="65" align="right" valign="top" style="padding-right:10px;line-height:26px;">
	        	您好：<span class="username">${admin.adminname }</span>，欢迎使用舒天便民后台管理系统！
	        	[<a href="#" target="_blank">网站主页</a>]
	        	&nbsp; &nbsp;
	        	[<a href="adminlogin/login!logout.action" target="_top">注销退出</a>]&nbsp;
	      </td>
	      </tr>
	      
	    </table></td>
	  </tr>
	</table>
	</body>
	
</html>
