<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-我的作品管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/zp.css" rel="stylesheet" type="text/css" />
	<link href="css/user/tcc.css" rel="stylesheet" type="text/css" />
	<link href="js/ext/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type='text/javascript' src="js/ext/ext-base.js"></script>
	<script type='text/javascript' src="js/ext/ext-all.js"></script>
	<script type="text/javascript" src="js/swfupload.js"></script>
	<script type="text/javascript" src="js/uploaderPanel.js"></script>

	<script type="text/javascript">
		
		$().ready(function() {
			//提交作品
			$("#divsub").click(function(){
				$("#formsub").attr("action","myspace/comm/worksAdd.action");
				$("#formsub").submit();
			});
			
			//取消提交作品
			$("#divcancel").click(function(){
				$("#formsub").attr("action","myspace/comm/worksAddCancel.action");
				$("#formsub").submit();
			});
			
			/*
			$("#form1").validate({
				//验证规则
				rules:{
					'work.activity.activityid':"required",
					'work.workstitle':{
						required:true,
						maxlength:256
					},
					snfile:"required",
					workfile:"required",
					'work.worksintro':{
						required:true,
						maxlength:256
					},
					'work.workscontent':"required"
				},
				messages:{
					'work.activity.activityid':"请选择活动!",
					'work.workstitle':{
						required:"填写作品标题!",
						maxlength:$.validator.format("作品标题最大输入{0}字符!")
					},
					snfile:"请选择作品缩略图!",
					workfile:"请选择作品!",
					'work.worksintro':{
						required:"请填写作品简介!",
						maxlength:$.validator.format("作品简介最大输入{0}字符!")
					},
					'work.workscontent':"请填写作品介绍!"
				},
				/* 重写错误显示消息方法,以alert方式弹出错误消息 
		        showErrors: function(errorMap, errorList) {   
		            var msg = "";   
		            $.each( errorList, function(i,v){   
		              msg += (v.message+"\r\n");   
		            });   
		            if(msg!="") alert(msg);   
		        },   
		        /* 失去焦点时不验证    
		        onfocusout: false  
			});
			*/  
		});

		function upwork(){
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
							//如果上传照片成功,刷新已上传照片信息
							document.getElementById("form1").action = "myspace/comm/worksUploadClose.action";
							$("#form1").submit();
						} 
					}, 
					items : [
						{
							xtype:'uploadPanel',
							border : false,
							fileSize : 1024*10,//限制文件大小 10M
							uploadUrl : 'myspace/comm/worksUpload.action',
							flashUrl : 'js/swfupload.swf',//相对于jsp文件的目录
							filePostName : 'filedata', //后台接收参数
							fileTypes : '*.jpg;*.gif;*.png;*.JPEG;',//可上传文件类型
							postParams : {}, //上传文件存放目录
							filenum:10 //上传上限
						}
					]
				}).show();
				
			}); 
		}
		
		function delupwork(path){
			
			if(confirm('确定删除?')){
				$("#delworkup").val(path);
				$("#form1").attr("action","myspace/comm/worksUploadDel.action");
				$("#form1").submit();
			}
		}
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
	            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
	            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
	            <li class="bai">作品管理</li>
            	<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
	            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
	          </ul>
	        </div>
	        
	        <form action="myspace/comm/worksAddAdvance.action" id="form1" method="post" encType="multipart/form-data">
	        <s:token></s:token>
	        <div class="ziy_1"> <a href="myspace/comm/friendList.action">作品管理</a> > <b>上传作品</b> </div>
	        <div class="ziy_1">
	          <ul>
	            <li>&nbsp;请选择活动主题：
	              <select name="work.activity.activityid">
	              	<option value="">请选择</option>
 			  		<s:iterator value="activityList" status="st" id = "act">
	                	<option value="${activityid }"  <s:if test="work.activity.activityid == activityid">selected="selected"</s:if>>${activitytitle }</option>
 			  		</s:iterator>
	              </select>
	              <span>(请详细查看活动规格。如果您不符合我们的规则，作品则不能通过审核!)</span> </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作品标题：
	              <input name="work.workstitle" value="${ work.workstitle}" type="text" />
	            </li>
	            
	          </ul>
	        </div>
	        <div class="ziy_2"><a href="javascript:upwork();">点击上传作品 </a><span> (您的作品最大上传数是10张，总共大小是在10MB)</span></div>
	        <div class="ziy_3">
	          <table width="390" border="0" cellspacing="0" cellpadding="0">
	          
 			  	<s:iterator value="photoList" status="st" id = "photo">
 			  	<tr>
	              <td width="270">${photoname }</td>
	              <td width="60">上传成功</td>
	              <td width="60" style=" text-align:right"><a href="javascript:delupwork('${photopath }');" >删除</a></td>
	            </tr>
 			  	</s:iterator>
 			  	
	          </table>
	        </div>
	        <div class="ziy_1">
	        <ul>
	            <li>&nbsp;上传作品缩略图：
	              <input type="file" id="snfile" name="snfile" />
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作品简介：
	              <textarea name="work.worksintro" value="${work.worksintro }" cols="" rows="">作品简介</textarea>
	            </li>
	            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作品介绍：
	              <textarea name="work.workscontent" value="${work.workscontent}" cols="" rows="">作品介绍</textarea>
	            </li>
	        </ul>
	        </div>
	        <div class="ziy_2">
	        <input id="subbtn" name="" type="submit" value="" class="ann"/> <span>(点确定后，预览您的作品页面，作品发布后，将无法修改内容，请仔细填写。)</span>
	        </div>
	        
	        <input type="hidden" id="delworkup" name="delworkup" value="" />
	        <input type="hidden" name="work.facepath" value="${work.facepath }" />
	        <input type="hidden" name="work.showsrc" value="${work.showsrc }" />
	        <input type="hidden" name="activityid" value="${work.activity.activityid }" />
	        </form>
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
        
		<div id="Preview" class="tcc" <s:if test='divshow == "0"'>style="display:none"</s:if>>
		<div class="mmright" style="">
		  <div class="ritu_1">
		  	<form id="formsub" method="post" action=""> 
		  	
		  	<s:token></s:token>
		  		<input type="hidden" name="work.workscontent" value="${work.workscontent}" />
		        <input type="hidden" name="work.facepath" value="${work.facepath }" />
		        <input type="hidden" name="work.showsrc" value="${work.showsrc }" />
		        <input type="hidden" name="activityid" value="${work.activity.activityid }" />
		  		<input type="hidden"  name="work.worksintro" value="${work.worksintro }"  />
		  		<input type="hidden"  name="work.workstitle" value="${ work.workstitle}" />
		    
		    	<h1><span>参赛作品</span> </h1>
			    <div class="zzpp">
			      <p><img id="showsnfile" src="${work.facepath }" width="203" height="248" /></p>
			      <ul>
			        <li class="hti"><b>${work.workstitle }</b><span>票数：0</span></li>
			        <li>编号：001</li>
			        <li>作者：${work.member.username }</li>
			        <li>时间：<fmt:formatDate value="${work.createdate}" pattern="yyyy-MM-dd"/></li>
			        <li class="jianjie">作品简介：<br />
			          <span>${work.worksintro}</span></li>
			        <li class="ann"><span><img src="img/interesting_img/tp.gif" width="110" height="40" /></span><span>0票</span></li>
			      </ul>
			    </div>
			    <div class="zuop">作品介绍</div>
			    <div class="neirr">
			    
 			  	<s:iterator value="photoList" status="st" id = "photo">
			      <p><img id="showworkfile" src="${photopath }" width="600" /> </p> 
			    </s:iterator>
			      <p>${work.workscontent }</p>
			    </div>
			    <div class="qyf">您确定要发布您的作品吗？作品上传以后将无法进行修改！</div>
			    <div class="qyf">
				      <p>
				      <input id="divsub" name=""  type="button"  class="ann"/>  
				      <input id="divcancel" name="" type="button"  class="ann_1"/>
				      </p>
			    </div>
			    
			</form>
		  </div>
		</div>
		</div>
	
	<!-- 消息 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
