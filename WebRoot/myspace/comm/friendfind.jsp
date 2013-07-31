<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-查找好友</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/classmate.css" rel="stylesheet" type="text/css" />
	<style type="text/css" media="screen">
	.tance {
		width:300px;
		background:#fff;
		height:150px;
		border:3px solid #a2d0ff;
		position:absolute;
		top:50%;
		left:50%;
		margin:-75px 0px 0px -150px;
	}
	.tance ul {
		padding:10px 0px 10px 50px;
		width:230px;
		border:none;
	}
	.tance ul li {
		float:left;
		width:230px;
		padding:5px 0px;
	}
	.tance ul li select {
		width:150px;
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
	<script type="text/javascript">
		$(document).ready(function() {
		
			//关闭弹出层
			$("#divclose").click(function(){
				$("#divindex").css("display","none");
			});
			//提交添加好友的表单
			$("#sub2").click(function(){
				$("#divindex").css("display","none");
				$("#form2").submit();
			});
		});
		
		
		function search(){
			if($("#xm").val() == ""){
				alert("请输入搜索的姓名！");
			}
			else{
				$("#form1").submit();
			}
			
		}
		function showdiv(id,name){
			$("#divindex").css("display","block");
			$("#divname").html(name);
			
			$("#friid").val(id);
			$("#frinikename").val(name);
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
	        <div class="bobti">查找朋友</div>
	        <div class="dtai">
	          <ul>
	            <li><a href="myspace/comm/friendList.action">我的好友</a></li>
	            <li><a href="member/classmateAction!list.action">同学录</a></li>
	            <li><a href="myspace/comm/visitMeList.action">访问脚步</a></li>
	            <li class="bai">查找朋友</li>
	          </ul>
	        </div>
	        <div class="jique">
	        	<p><span>精确查找</span></p>
	        </div> 
	        <div class="jjcha">
	        	<form action="myspace/comm/friendFind.action" method="post" id="form1">
	        	<ul>
	        	<li>姓名： <input name="xm" type="text" value="${xm }" /></li> 
	        	<li><a href="javascript:search();"><img src="img/user_img/ss.gif" width="49" height="27" /></a></li>
	        	</ul>
	        	</form>
	        </div>
	         <div class="jique">
	        	<p><span>查找结果：</span></p>
	        </div> 
	        <div class="jieg">
	        	<s:iterator value="mList" status="st" id = "mem">
		             <c:choose>
         				<c:when test="${mem.memberid == sessionScope.loginMemberId}">
	                	<ul>
			            	<li class="imgtu"><img src="${mem.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'" width="73" height="73" /></li>
			                <li class="ziz"><p>${mem.nikename }</p>
			                </li>
		            	</ul>
         				</c:when>
         				<c:otherwise>
         				<ul>
			            	<li class="imgtu"><a target="_blank" href="Zone/index.action?TTid=${mem.memberid}"><img src="${mem.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'" width="73" height="73" /></a></li>
			                <li class="ziz"><p><a target="_blank" href="Zone/index.action?TTid=${mem.memberid}">${mem.nikename }</a></p>
			                <p class="ppo">
			                	<a href="javascript:showdiv('${mem.memberid }','${mem.nikename }');">加为好友</a>
			                </p>
			                </li>
		            	</ul>
         				</c:otherwise>
         			</c:choose>
	        	</s:iterator>
	        </div>
	        
	        
	         <div class="tance" id="divindex" style="display:none">
	         	<form action="myspace/comm/friendAdd.action" id="form2" method="post">
	         	<s:token></s:token>
	         	
	         	<input type="hidden" id="friid" name="mfriend.memberid" />
	         	<input type="hidden" id="frinikename" name="mfriend.nikename" />
                <ul>
                  <li>
                    <input name="" type="button" class="chaa" id="divclose"/>
                  </li>
                  <li>您把“<span id="divname"></span>”添加到：</li>
                  <li>
                    <select name="typeid">
		        		<s:iterator value="typeList" status="st" id = "type">
	                      <option value="${friendtypeid }">${friendtypename }</option>
		        		</s:iterator>
                    </select>
                  </li>
                  <li>
                    <input name="sub2" type="button" id="sub2" value="确&nbsp;&nbsp;&nbsp;&nbsp;定" />
                  </li>
                </ul>
                </form>
              </div>
	        
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
