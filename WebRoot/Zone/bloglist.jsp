<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!他人空间-博文</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/usermaid.css" rel="stylesheet" type="text/css" />

	<style type="text/css" media="screen">
	.tance {
		width:300px;
		background:#fff;
		height:200px;
		border:3px solid #a2d0ff;
		position:absolute;
		top:50%;
		left:50%;
		margin:-100px 0px 0px -150px;
	}
	.tance ul {
		padding:10px 0px 10px 50px;
		width:250px;
		border:none;
	}
	.tance ul li {
		float:left;
		width:240px;
		padding:5px 0px;
	}
	input.chaa {
		background:url(img/user_img/uy1.gif);
		border:none;
		width:18px;
		height:18px;
		float:right
	}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
	<script type="text/javascript">
		$().ready(function() {	
			//关闭弹出层
			$("#divcloseupd").click(function(){
				$("#pwd").val("");
				$("#blogpwd").css("display","none");
			});
		});
		//点击查看博文详情
		function adetail(power,id,iscom){
			$("#blogid").val(id);
			$("#iscom").val(iscom);
			
			if(power == '4'){//需输入密码
				$("#blogpwd").css("display","block");
			}
			else if(iscom == 0){//非评论
				subdetail();
			}
			else if(iscom == 1){
				subdetailco();
			}
		}
		function subpwd(){
			var iscom = $("#iscom").val();
			if(iscom == 0){//非评论
				subdetail();
			}
			else if(iscom == 1){
				subdetailco();
			}
		}
		//提交查询博文详情的表单
		function subdetail(){
			$("#blogpwd").css("display","none");
			$("#detailform").submit();
		}
		
		//评论
		function subdetailco(){
			$("#detailform").attr("action","Zone/blogDetail.action?a=a&Aname#Aid");
			$("#blogpwd").css("display","none");
			$("#detailform").submit();
		}
	</script>
	
  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/Zone/header.jsp"></jsp:include> 
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		    <!-- 他人空间中部左边菜单栏 -->
		    <jsp:include page="/Zone/content_leftmenu.jsp"></jsp:include>
		    <!-- 他人空间中部右边内容详细页 -->
		 	<div class="right">
		        <div class="bobti"> 博文 </div>
		        <div class="bbowen">
		          <div class="opous">
		          
		          <form action="Zone/blogDetail.action" method="post" id="detailform">
				  <input id="d1" name="TTid" value="${TTid }" type="hidden" />
				  <input id="blogid" name="blogid" type="hidden" />
 				  <s:iterator value="bloglist" status="st" id = "blog">
		            <div class="zhz">
		             <ul class="wenzi_1">
		                <li class="bh"><a href="javascript:adetail('${blog.viewperm }','${blog.blogid }','0');">${blog.blogtitle }</a></li>
		                <li class="time">${blog.createdate }</li>
		                <li>
		                 <p> ${blog.blogcontent } </p>
		                </li>
		                <li><a href="javascript:adetail('${blog.viewperm }','${blog.blogid }','0');">阅读</a>(${blog.readnum }) | <a href="javascript:adetail('${blog.viewperm }','${blog.blogid }','1');">评论</a>(${blog.commentnum })</li>
		              </ul>
		            </div>
		          </s:iterator>
		          
			        <!-- 弹出密码输入框 -->
		      		<div class="tance" id="blogpwd" style="display:none"  media="screen">
		      			
		      			<input name="iscom" id="iscom" type="hidden"/>
		                <ul>
		                  <li>
		                    <input name="" type="button" class="chaa"  id="divcloseupd"/>
		                  </li>
		                  <li>请输入博文密码：</li>
		                  <li>
		                  <input name="pwd" value="" id="pwd" type="text" />
		                  </li>
		                  <li>
		                    <input name="确定" type="button" id="确定" value="确定" onclick="subpwd();" />
		                  </li>
		                </ul>
		            </div>
		          </form>
		          
				  <form id="form1" action="Zone/blogList.action" method="post">
				  	<input name="TTid" value="${TTid }" type="hidden" />
					<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="form1"></t:tpage>
			      </form>
		        </div>
		          
		        <div class="banner">
		          <img name="advertisement" title="other-bloglist-a1"  src="" width="272" height="124" />
		          <img name="advertisement" title="other-bloglist-a2"  src="" width="272" height="124" />
		        </div>
		        
	        </div>
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/Zone/footer.jsp"></jsp:include> 
	
  	
	<!-- 信息显示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
