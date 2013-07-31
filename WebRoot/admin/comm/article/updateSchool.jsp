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

		<title>修改名校风采</title>

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
			
				//添加自定义方法，封面格式验证
				$.validator.methods.check_cover = function(value, element, param){   
				    var expanded = value.substring(value.indexOf(".") + 1, value.length);
					if(expanded.toUpperCase()=="JPG"){
						return true;
					}else{
						return false;
					}  
				}  
			
				$("#formArticleUpdate").validate({
					//验证规则
					rules:{
						articletitle:"required",
						schoolname:"required",
						'gradecode.gradecode':"required",
						'subjectcode.subjectcode':"required",
						metakeywords:"required",
						cover:"check_cover",
						articleintro:{
							required:true,
							maxlength:256
						},
						articlesrccontent:"required"
					},
					messages:{
						articletitle:"标题不能为空!",
						schoolname:"学校名称不能为空!",
						'gradecode.gradecode':"请选择年级!",
						'subjectcode.subjectcode':"请选择科目!",
						metakeywords:"资源关键字不能为空!",
						cover:"只能上传JPG格式的封面!",
						articleintro:{
							required:"内容简介不能为空!",
							maxlength:$.validator.format("内容简介最大输入{0}字符!")
						},
						articlesrccontent:"内容详情不能为空!"
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
				学习频道管理——修改名校风采
			</h1>
		</div>
		<form method="post" action="admin/updateArticleSchool.action"
			name="formArticleUpdate" id="formArticleUpdate"
			enctype="multipart/form-data">
			<s:token></s:token>
			<input type="hidden" name="articlesrcid" id="articlesrcid"
				value="${articleSrc.articlesrcid }">
			<input type="hidden" name="type" id="type" value="school" />	
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr id="addarea">
								<td align="left" colspan="2">
									<img src="${articleSrc.albumspath }cover.jpg" width="149" height="189">
								</td>
							</tr>
							<tr id="addarea">
								<td align="left" width="150">
									标题：
								</td>
								<td>
									<input type="text" name="articletitle" id="articletitle"
										size="50" value="${articleSrc.articletitle }">
								</td>
							</tr>
							<tr id="addarea">

								<td align="left" width="150">
									学校名称：
								</td>
								<td>
									<input type="text" name="schoolname" id="schoolname" size="50"
										value="${articleSrc.schoolname }">
								</td>
							</tr>
							<tr>
								<td>
									年级：
								</td>
								<td style="word-break: break-all">
									<select name="gradecode.gradecode" id="gradecode.subjectcode">
										<s:iterator value="gradeCodeAll" id="g">
											<option value="${g.gradecode }"
												<s:if test="#request.articleSrc.gradecode==#g">selected</s:if>>
												${g.gradename }
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									科目：
								</td>
								<td style="word-break: break-all">
									<select name="subjectcode.subjectcode"
										id="subjectcode.subjectcode">
										<s:iterator value="subjectCodeAll" id="s">
											<option value="${s.subjectcode }"
												<s:if test="#request.articleSrc.subjectcode==#s">selected</s:if>>
												${s.subjectname }
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									资源关键字：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="metakeywords" id="metakeywords"
										size="30" value="${articleSrc.metakeywords }">
								</td>
							</tr>
							<tr>
								<td>
									是否推荐书籍：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="isrecommend" id="isrecommend"
										value="1"
										<s:if test="#request.articleSrc.isrecommend==1">checked</s:if>>
									是
									<input type="radio" name="isrecommend" id="isrecommend"
										value="0"
										<s:if test="#request.articleSrc.isrecommend==0">checked</s:if>>
									否
								</td>
							</tr>
							<tr>
								<td>
									是启置顶：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="istop" id="istop" value="1"
										<s:if test="#request.articleSrc.istop==1">checked</s:if>>
									是
									<input type="radio" name="istop" id="istop" value="0"
										<s:if test="#request.articleSrc.istop==0">checked</s:if>>
									否
								</td>
							</tr>
							<tr>
								<td>
									是启发布：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="ispublication" id="ispublication"
										value="1"
										<s:if test="#request.articleSrc.ispublication==1">checked</s:if>>
									是
									<input type="radio" name="ispublication" id="ispublication"
										value="0"
										<s:if test="#request.articleSrc.ispublication==0">checked</s:if>>
									否
								</td>
							</tr>
							<tr>
								<td>
									上传封面：
								</td>
								<td style="word-break: break-all">
									<input type="file" name="cover" id="cover" size="30">
								</td>
							</tr>
							<tr>
								<td>
									内容简介：
								</td>
								<td style="word-break: break-all">
									<textarea rows="5" cols="70" id="articleintro"
										name="articleintro">${articleSrc.articleintro }</textarea>
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
										name="articlesrccontent" rows="10">${articleSrc.articlesrccontent }</textarea>
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
