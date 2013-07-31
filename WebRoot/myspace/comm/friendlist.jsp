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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-我的好友</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/myfriend.css" rel="stylesheet" type="text/css" />
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
			$("#divcloseupd").click(function(){
				$("#divupdtype").css("display","none");
			});
			//关闭弹出层
			$("#divcloseadd").click(function(){
				$("#divaddtype").css("display","none");
			});
			
			//提交修改好友所在组的表单
			$("#subupd").click(function(){
				$("#divupdtype").css("display","none");
				$("#formuptype").submit();
			});
			
			//提交增加好友分组的表单
			$("#subadd").click(function(){
				$("#divaddtype").css("display","none");
				$("#formaddtype").submit();
			});
		});
		
		function showUpdTypeDiv(id,name){
			$("#divupdtype").css("display","block");
			$("#divupdname").html(name);
			
			$("#infoid").val(id);
		}
		
		function showAddTypeDiv(){
			$("#divaddtype").css("display","block");
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
	        <div class="bobti">好友</div>
	        <div class="dtai">
	          <ul>
	            <li class="bai">我的好友</li>
	            <li><a href="member/classmateAction!list.action">同学录</a></li>
	            <li><a href="myspace/comm/visitMeList.action">访问脚步</a></li>
	            <li><a href="myspace/comm/friendfind.jsp">查找朋友</a></li>
	          </ul>
	        </div>
	        <div class="fire">
	          <div class="fireleft">
	            <div class="anbootm">
				<s:if test="result != null && result.page != null && result.page.totalPage>0">
		            <!-- 有上一页 -->
		            <s:if test="result.page.hasPrePage">
		            	<a href="myspace/comm/friendList.action?typeidpage=${typeidpage }&gotoPage=${result.page.currentPage-1 }">
			            	<img src="img/user_img/re1.gif" width="18" height="18" />
			            </a>
		            </s:if>
		            <s:else>
		            	<img src="img/user_img/re1_1.gif" width="18" height="18" />
		            </s:else>
		            
		            <!-- 有下一页 -->
		            <s:if test="result.page.hasNextPage">
		            	<a href="myspace/comm/friendList.action?typeidpage=${typeidpage }&gotoPage=${result.page.currentPage+1 }">
			            	<img src="img/user_img/re2.gif" width="18" height="18" />
			            </a>
		            </s:if>
		            <s:else>
		            	<img src="img/user_img/re2_1.gif" width="18" height="18" />
		            </s:else>
	            </s:if>
	            <s:else>
		            <img src="img/user_img/re1_1.gif" width="18" height="18" />
		            <img src="img/user_img/re2_1.gif" width="18" height="18" />
	            </s:else>
	            </div>
	            <div class="myfriend">
	        		<s:iterator value="friendList" status="st" id = "friend">
		              <ul>
		                <li class="imgus"><a href="Zone/index.action?TTid=${memberByFrienduserid.memberid }"><img src="${memberByFrienduserid.headpath }" onerror="this.src='userspacefile/default/imgmo.gif'"  width="51" height="51" /></a></li>
		                <li class="xiao">
		                  <p><a href="Zone/index.action?TTid=${memberByFrienduserid.memberid }">${memberByFrienduserid.nikename }</a></p>
		                  <p>分组：${friendtype.friendtypename } <a href="javascript:showUpdTypeDiv('${friendsinfoid }','${memberByFrienduserid.nikename }');" style="font-size:12px; text-decoration:underline">修改分组</a></p>
		                </li>
		                <li class="chu"><a href="myspace/comm/friendDel.action?friendinfoid=${friendsinfoid }">解除关系</a></li>
		              </ul>
	        		</s:iterator>
	            </div>
	          </div>
	          <div class="fireright">
	            <h1><span style=" float:left">好友分组</span> <a href='javascript:showAddTypeDiv();' style="font-size:12px; font-weight:normal; float:right; color:red; text-decoration:underline; padding:0px 5px 0px 0px;">新增分组</a></h1>
	            <ul>
	        		<s:iterator value="typeList" status="st" id = "type">
	        		<li>
	        		<a href="myspace/comm/friendList.action?typeidpage=${friendtypeid }" <s:if test="typeidpage == friendtypeid"> class="dizhu" </s:if> >${friendtypename }(${friendnum })</a>
	        		<s:if test='friendnum == 0 && isdefault == "0"'>
	        		<a href="myspace/comm/friendTypeDel.action?typeid=${friendtypeid }" class="aat"><img src="img/user_img/xx.gif" width="8" height="7" /></a>
	        		</s:if>
	        		</li>
	        		</s:iterator>
	            </ul>
	          </div>
	        </div>
	        <!-- 修改用户所在组的层 -->
	         <div class="tance" id="divupdtype" style="display:none">
	         	<form action="myspace/comm/friendUpdType.action" id="formuptype" method="post">
	         	<input type="hidden" id="infoid" name="friendinfoid" />
	         	
                <ul>
                  <li>
                    <input name="" type="button" class="chaa" id="divcloseupd"/>
                  </li>
                  <li>您把“<span id="divupdname"></span>”修改到：</li>
                  <li>
                    <select name="friendtype.friendtypeid">
		        		<s:iterator value="typeList" status="st" id = "type">
	                      <option value="${friendtypeid }">${friendtypename }</option>
		        		</s:iterator>
                    </select>
                  </li>
                  <li>
                    <input name="subupd" type="button" id="subupd" value="确&nbsp;&nbsp;&nbsp;&nbsp;定" />
                  </li>
                </ul>
                </form>
              </div>
			
	        <!-- 添加用户组的层 -->
	         <div class="tance" id="divaddtype" style="display:none">
	         	<form action="myspace/comm/friendTypeAdd.action" id="formaddtype" method="post">
	         	
                <ul>
                  <li>
                    <input name="" type="button" class="chaa" id="divcloseadd"/>
                  </li>
                  <li>新添加的分组名称：</li>
                  <li>
                    <input name="friendtype.friendtypename" id="typename"  />
                  </li>
                  <li>
                    <input name="subadd" type="button" id="subadd" value="确&nbsp;&nbsp;&nbsp;&nbsp;定" />
                  </li>
                </ul>
                </form>
              </div>
			
			<s:if test="result != null">
	        <form action="myspace/comm/friendList.action" id="formpage" method="post">
	        	<input type="hidden" name="typeidpage" value="${typeidpage }" />
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
	        </form>
	        </s:if>
	        
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
