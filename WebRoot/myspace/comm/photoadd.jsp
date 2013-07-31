<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP page</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/pohto.css" rel="stylesheet" type="text/css" />
	<link href="js/ext/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type='text/javascript' src="js/ext/ext-base.js"></script>
	<script type='text/javascript' src="js/ext/ext-all.js"></script>
	<script type="text/javascript" src="js/swfupload.js"></script>
	<script type="text/javascript" src="js/uploaderPanel.js"></script>

	<script type="text/javascript">
	$().ready(function() {
		$("#upbtn").click(function(){
			var $album = $('#albums');
			Ext.onReady(function(){ 
				Ext.QuickTips.init();
				new Ext.Window({
					width : 650,
					title : '照片上传',
					height : 300,
					layout : 'fit',
					modal:true,
					listeners:{ 
						"close":function(){ 
							//如果上传照片成功,跳转到相册内容展示列表页
							$('#albumid').val($album.val());
							$('#form1').submit();
						} 
					}, 
					items : [
						{
							xtype:'uploadPanel',
							border : false,
							fileSize : 1024*550,//限制文件大小
							uploadUrl : 'myspace/comm/photoAdd.action',
							flashUrl : 'js/swfupload.swf',//相对于jsp文件的目录
							filePostName : 'filedata', //后台接收参数
							fileTypes : '*.jpg;*.gif;*.png;*.JPEG;',//可上传文件类型
							postParams : {albumid:$album.val()} //上传文件存放目录
						}
					]
				}).show();
				
			}); 
		});
	});
	</script>
  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="../header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	      
	      <form id="form1" method="post" action="myspace/comm/photoOfAlbum.action">
	        <div class="bobti">我的相册</div>
	        <div class="lujin"> <a href="myspace/comm/albumList.action">我的相册</a> > <b>上传照片</b> </div>
	        <div class="poth_1">
	          <ul>
	            <li>选择相册：
	              <select name="" style="width:150px;" id="albums">
	              	<s:iterator value="albumList" status="st" id = "album">
	                  <option value="${album.albumid }">${album.albumname }</option>
	                </s:iterator>
	              </select>
	            </li>
	            <li><a href="myspace/comm/albumadd.jsp">创建新相册</a></li>
	          </ul>
	        </div>
	        <div class="poth_7">
	          <input id="upbtn" type="button" />
	        </div>
	        
	        <input type="hidden" id="albumid" name="albumid" />
          </form>
        
        
        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="../footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
