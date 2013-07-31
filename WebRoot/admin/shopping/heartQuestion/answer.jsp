<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改文章</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
			$().ready(function() {
			
				$("#formArticleUpdate").validate({
					//验证规则
					rules:{
						'zealAnswer.questiontitle':"required",
						'zealAnswer.questiondetails':"required",
						'zealAnswer.answer':{
							required:true,
							maxlength:256
						}
					},
					messages:{
						'zealAnswer.questiontitle':"标题不能为空!",
						'zealAnswer.questiondetails':"问题详情不能为空!",
						'zealAnswer.answer':{
							required:"回答内容不能为空!",
							maxlength:$.validator.format("内容简介最大输入{0}字符!")
						}
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
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				商城管理——热心答疑回答
			</h1>
		</div>
		<form method="post" action="admin/shop/heartAnswer!answer.action" enctype="multipart/form-data" name="#formArticleUpdate"" id="#formArticleUpdate"">
		<input type="hidden" name="zealAnswer.zealanswerid" value="${zealAnswer.zealanswerid }">
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
					<c:choose>
						 <c:when test="${empty zealAnswer}">
						 	<font color='red' size='3'>没有该问题的详情</font>
						 </c:when>
						 <c:otherwise>
						 <tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">

							<tr>
								<td>
									问题：
								</td>

								<td style="word-break: break-all">
									<textarea rows="2" cols="50" id="zealAnswer.questiontitle"
										name="zealAnswer.questiontitle">${zealAnswer.questiontitle }</textarea>
								</td>
							</tr>
							<tr>
								<td>
									问题详情：
								</td>
								<td style="word-break: break-all">
									<textarea rows="5" cols="70" id="zealAnswer.questiondetails"
										name="zealAnswer.questiondetails">${zealAnswer.questiondetails }</textarea>
								</td>
							</tr>
							<tr>
								<td>我来回答：</td>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="zealAnswer.answer"
										name="zealAnswer.answer" rows="10">${zealAnswer.answer }</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="Submit" value="保存" class="sst">
									<input type="reset" name="reset" value="重置" class="sst_1">
								</td>
							</tr>
						</table>
					</td>
				</tr>
						 </c:otherwise>						
					</c:choose>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
