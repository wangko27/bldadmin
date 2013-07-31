<%@ page language="java"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="<%=basePath%>comm/css/base.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>comm/css/jquery.datepicker.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>comm/css/jquery.zoomimage.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>comm/css/jquery.loadmask.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.validate.methods.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.validate.cn.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.zoomimage.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/js/jquery.loadmask.js"></script>
<!--<script type="text/javascript" src="<%=basePath%>comm/tiny_mce/jquery.tinymce.js"></script>-->
<!--[if lte IE 6]>
<script type="text/javascript" src="<%=basePath%>comm/js/belatedPNG.js"></script>
<![endif]-->
<!--<script type="text/javascript" src="<%=basePath%>comm/js/base.js"></script>-->