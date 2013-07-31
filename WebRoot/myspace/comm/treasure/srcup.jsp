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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-上传资源</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/ziyuan.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
	
	$().ready(function() {
	
		//验证
		$("#form1").validate({
			//验证规则
			rules:{
				'readsrc.readsrctile':{
					required:true,
					maxlength:128
				},
				'readsrc.gradeCode.gradecode':{
					required:true
				},
				'readsrc.subjectCode.subjectcode':{
					required:true
				},
				'readsrc.readSrcType.srctypeid':{
					required:true
				},
				'readsrc.srckeywords':{
					maxlength:128
				},
				'readsrc.contentintro':{
					required:true
				},
				photofile:{
					required:true
				},
				souce:{
					required:true
				},
				'readsrc.contentintro':{
					required:true
				}
			},
			messages:{
				'readsrc.readsrctile':{
					required:"请填写资源标题!",
					maxlength:$.validator.format("标题过大,请输入30个汉字以内的标题!")
				},
				'readsrc.gradeCode.gradecode':{
					required:"请选择年级!"
				},
				'readsrc.subjectCode.subjectcode':{
					required:"请选择科目!"
				},
				'readsrc.readSrcType.srctypeid':{
					required:"请选择类型!"
				},
				'readsrc.srckeywords':{
					maxlength:$.validator.format("关键字过大,请控制在64个汉字以内!")
				},
				'readsrc.contentintro':{
					required:"请填写简介!"
				},
				photofile:{
					required:"请选择要上传的资源封面!"
				},
				souce:{
					required:"请选择要上传的资源!"
				}
			},
			/* 重写错误显示消息方法,以alert方式弹出错误消息  */ 
	        showErrors: function(errorMap, errorList) {   
	            var msg = "";   
	            $.each( errorList, function(i,v){   
	              msg += (v.message+"\r\n");   
	            });   
	            if(msg!="") alert(msg);   
	        },    
	        /* 失去焦点时不验证 */     
	        onfocusout: false  
		});
	});
	
	</script>
  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	        
        	<div class="bobti">百宝箱</div>
	        <div class="dtai">
	          <ul>
	            <li><a href="myspace/comm/downManaList.action">下载管理</a></li>
	            <li class="bai">资源管理</li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li><a href="myspace/comm/worksList.action">作品管理</a></li>
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        <form id="form1" method="post" action="myspace/comm/uploadSrcAdd.action" enctype="multipart/form-data">
			<s:token></s:token>
	        <div class="ziy_1"> <a href="myspace/comm/uploadSrcList.action">资源管理</a> > <b>上传资源</b> </div>
	        <div class="ziy_1">
	        
	          <ul>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题：
	              <input name="readsrc.readsrctile" type="text" />
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年级：
	              <select name="readsrc.gradeCode.gradecode">
	                <option value="">请选择</option>
	              <s:iterator value="gradeList" status="st" id = "grade">
	                <option value="${gradecode }">${gradename }</option>
	              </s:iterator>
	              </select>
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;科目：
	              <select name="readsrc.subjectCode.subjectcode">
	                <option value="">请选择</option>
	              <s:iterator value="subjectList" status="st" id = "subject">
	                <option value="${subjectcode }">${subjectname }</option>
	              </s:iterator>
	              </select>
	            </li>
	            <li>资源类别：
	              <select name="readsrc.readSrcType.srctypeid">
	                <option value="">请选择</option>
	              <s:iterator value="srctypeList" status="st" id = "srct">
	                <option value="${srctypeid }">${srctype }</option>
	              </s:iterator>
	              </select>
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;关键字：
	               <input name="readsrc.srckeywords" type="text" style="width:100px"/>&nbsp;&nbsp;&nbsp;&nbsp;多个关键字之间请以空格分开
	            </li>
	            <li>所需积分：
	               <input name="readsrc.downpoint" type="text" value="0" style="width:100px"/>
	            </li>
	            <li>资源图片：
	               <input name="photofile" type="file" />
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资源：
	               <input name="souce" type="file" />
	            </li>
	            <li>内容简介：
	              <textarea name="readsrc.contentintro" cols="" rows="">内容介绍</textarea>
	            </li>
	            <li class="qq"><input name="" type="submit" value="" class="ann"/>  <input name="" type="reset" value="" class="ann_1"/></li>
	          </ul>
	        </div>
        	</form>
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
	<!-- 消息 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
