<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			String questionTypeid=request.getParameter("questionTypeid");
			if(questionTypeid==null){
				questionTypeid="0";
			}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>商品频道管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
		
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
			$().ready(function() {
			
				$("#search").validate({
					//验证规则
					rules:{
						questiontitle:"required"
					},
					messages:{
						questiontitle:"检索条件不能为空!"
					},
					/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
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
			function heartAnswer(questionTypeid){
				$("#questionTypeid").val(questionTypeid);
				$("#form1").submit();				
				return false;
			}			
		</script>
	<script type="text/javascript" src="<%=basePath %>admin/shopping/js/showall.js"></script>
	
	</head>

	<body>
		<div class="maindiv">
			<h1>
				商品频道管理&mdash;&mdash;热心解答管理
			</h1>
		</div>
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr>
				<td colspan="8" bgcolor="#e8f0f3">
					搜索
				</td>
			</tr>
			<tr>
				<td colspan="8" bgcolor="#FFFFFF" align="center">
					<form action="admin/shop/heartAnswer!search.action" method="post" name="search" id="search">
						<table border="0">
							<tr>
								<td>
									<font color=red>问题标题</font>或<font color=red>标题中的关键字</font>：
								</td>
								<td>
									<input type="text" name="questiontitle" id="questiontitle" />
								</td>
								<td>
									<input type="submit" value="搜索" class="sst" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="8" background="skin/images/tbg.gif">
					&nbsp;类别列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="heartAnswer(1)">已回答问题</a>--<a onclick="heartAnswer(0)">未回答问题</a>
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td>编号</td>
				<td>问题简介</td>
				<td>提问时间</td>
				<td>提问者类别</td>
				<td>问题状态</td>
				<td>回答时间</td>
				<td>操作</td>
			</tr>
			<c:choose>
			<c:when test="${empty result.content}">
			<tr>
				<td colspan="8" style="text-align: center; font-size: 24px;">没有要搜索的结果!</td>
			</tr>
			</c:when>
			<c:otherwise>
			<c:forEach  items="${result.content}" var="srot" varStatus="index">
				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#e8f6ff';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						<u>${index.index+1}</u>
					</td>
					<td>
						<u onmouseout="hideMp(this)" onmousemove="showMp(event,this,value)" value="${srot.questiontitle}">${fn:substring(srot.questiontitle, 0, 15) }</u>
					</td>
					<td><u><fmt:formatDate value="${srot.questiondate}" pattern="yyyy-MM-dd kk:ss"/></u></td>
					<td>
						<u>
						<c:if test="${srot.member.memberType=='1'}"> 学生</c:if>
						<c:if test="${srot.member.memberType=='2'}">家长</c:if>
						<c:if test="${srot.member.memberType=='3'}">教师</c:if>	
						<c:if test="${srot.member.memberType=='4'}">其他注册用户</c:if>		
						</u>
					</td>
					<td>
						<u> ${empty srot.answer ?'未回答':'已回答' }</u>
					</td>
					<td>
						<U> <fmt:formatDate value="${srot.modifydate}" pattern="yyyy-MM-dd"/>
						</U>
					</td>
					<td>
						<a href="admin/shop/heartAnswer!answerpage.action?id=${srot.zealanswerid }">修改</a>&nbsp;
						|&nbsp;
						<a href="admin/shop/heartAnswer!delete.action?id=${srot.zealanswerid }&type=${empty srot.answer ?'0':'1' }" onClick="return(confirm('確定刪除?'))">删除</a>&nbsp;
						<c:if test="${empty srot.answer}">
						|&nbsp;
						<a href="admin/shop/heartAnswer!answerpage.action?id=${srot.zealanswerid }">回答</a>&nbsp;
						</c:if>
					</td>
				</tr>
			</c:forEach>
				<tr bgcolor="#e8f6ff">
					<td class="nv" colspan="8">
						<form id="form1" action="admin/shop/heartAnswer!list.action"
							method="post">
								<input name="questionTypeid" id="questionTypeid" type="hidden" value="<%=questionTypeid%>"/>
						<t:tpage formId="form1" pageDiv="page" page="${result.page}"
							goImg="img/learning_img/gog.gif"></t:tpage>
						</form>
					<br></td>
				</tr>
			</c:otherwise>
			</c:choose>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
