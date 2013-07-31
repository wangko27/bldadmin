<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
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

		<title>学习频道管理——名师讲坛——文章添加</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
		
			$().ready(function() {
			
				//添加自定义方法，验证内容详情是否填写
				$.validator.methods.check_content = function(value, element, param){   
				    //取得ckedit中的内容
				    var oEditor = CKEDITOR.instances.articlesrccontent;
				    var condata = oEditor.getData();
					if(condata!=""){
						return true;
					}else{
						return false;
					}  
				}  
			
				$("#formArticleAdd").validate({
					//验证规则
					rules:{
						articletitle:"required",
						metakeywords:"required",
						articlesrccontent:{
							check_content:true
						}
					},
					messages:{
						articletitle:"标题不能为空!",
						metakeywords:"资源关键字不能为空!",						
						articlesrccontent:{
							check_content:"内容详情不能为空!"
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
				学习频道管理——名师讲坛——文章添加
			</h1>
		</div>
		<form method="post" action="admin/addMastersArticle.action"
			name="formArticleAdd" id="formArticleAdd"
			enctype="multipart/form-data">
			<s:token></s:token>
			<input type="hidden" name="member.memberid" id="member.memberid"
				value="${memberid }">
			<input type="hidden" name="articleType.articletypeid"
				id="articleType.articletypeid"
				value="8a8081a131cd5fcd0131cd6a4b400003">
			<input type="hidden" name="nikename" id="nikename"
				value="${nikename }">			
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td align="left" width="100">
									名师：
								</td>
								<td>
									${nikename }
								</td>
							</tr>
							<tr id="addarea">
								<td align="left" width="100">
									标题：
								</td>
								<td>
									<input type="text" name="articletitle" id="articletitle"
										size="50" maxlength="256">
									最多256个字符
								</td>
							</tr>
							<tr>
								<td>
									资源关键字：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="metakeywords" id="metakeywords"
										size="50" maxlength="128">
									多个以空格分隔，最多128个字符
								</td>
							</tr>
							<tr>
								<td>
									是否推荐：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="isrecommend" id="isrecommend"
										value="1">
									是
									<input type="radio" name="isrecommend" id="isrecommend"
										value="0" checked="checked">
									否
								</td>
							</tr>
							<tr>
								<td>
									是启置顶：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="istop" id="istop" value="1">
									是
									<input type="radio" name="istop" id="istop" value="0"
										checked="checked">
									否
								</td>
							</tr>
							<tr>
								<td>
									是启发布：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="ispublication" id="ispublication"
										value="1" checked="checked">
									是
									<input type="radio" name="ispublication" id="ispublication"
										value="0">
									否
								</td>
							</tr>
							<tr>
								<td>
									内容详情：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="articlesrccontent"
										name="articlesrccontent" rows="10"></textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('articlesrccontent');
									//]]></script>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="Submit" value="保存" class="sst">
									<input type="reset" name="Submit" value="重置" class="sst_1">
									<a href="admin/article!openMasters.action" target="main">返回名师列表</a>
									<a href="admin/article!openMastersArticle.action?memberid=${memberid }&nikename=${nikename }" target="main">返回文章管理</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
