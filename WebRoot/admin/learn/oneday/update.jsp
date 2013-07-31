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

		<title>学习频道管理——修改一天一课</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript" src="admin/js/checkfile.js"></script>
		<script type="text/javascript">
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/
		
			$().ready(function() {
			
				//添加自定义方法，验证内容详情是否填写
				$.validator.methods.check_content = function(value, element, param){   
				    //取得ckedit中的内容
				    var oEditor = CKEDITOR.instances.contentintro;
				    var condata = oEditor.getData();
					if(condata!=""){
						return true;
					}else{
						return false;
					}  
				} 	
			
				//验证封面类型
				$.validator.methods.check_cover = function(value, element, param){
					if(value!=""){   
					    //验证上传文件类型
						var allowFileType = "JPG,PNG,GIF";
						return checkFileType(value, allowFileType);
					}else{
						return true;
					}
				}
			
				$("#formOnedayUpdate").validate({
					//验证规则
					rules:{
						readsrctile:"required",
						'gradeCode.gradecode':"required",
						'subjectCode.subjectcode':"required",
						srckeywords:"required",
						cover:{
							check_cover:true
						},
						contentintro:{
							check_content:true
						}
					},
					messages:{
						readsrctile:"标题不能为空!",
						'gradeCode.gradecode':"请选择年级!",
						'subjectCode.subjectcode':"请选择科目!",
						srckeywords:"资源关键字不能为空!",
						cover:{
							check_cover:"封面只能上传JPG,PNG,GIF格式的文件!"
						},
						contentintro:{
							check_content:"内容简介不能为空!"
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

	<body onload="loadselecttype('${readSrc.readSrcType.srctypeid }')">
		<div class="maindiv">
			<h1>
				学习频道管理——修改一天一课
			</h1>
		</div>
		<form method="post" action="admin/learn/updateOneday.action"
			name="formOnedayUpdate" id="formOnedayUpdate"
			enctype="multipart/form-data">
			<s:token></s:token>
			<input type="hidden" name="readsrcid" id="readsrcid"
				value="${readSrc.readsrcid }">
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td align="left" colspan="2">
									<img src="${readSrc.photopath }" width="151" height="101">
								</td>
							</tr>
							<tr id="addarea">
								<td align="left" width="150">
									标题：
								</td>
								<td>
									<input type="text" name="readsrctile" id="readsrctile"
										size="50" value="${readSrc.readsrctile }" maxlength="30">
									最大30个字
								</td>
							</tr>
							<tr>
								<td>
									年级：
								</td>
								<td style="word-break: break-all">
									<select name="gradeCode.gradecode" id="gradeCode.subjectcode">
										<s:iterator value="gradeCodeAll" id="g">
											<option value="${g.gradecode }"
												<s:if test="#request.readSrc.gradeCode.gradecode==#g.gradecode">selected</s:if>>
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
									<select name="subjectCode.subjectcode"
										id="subjectCode.subjectcode">
										<s:iterator value="subjectCodeAll" id="s">
											<option value="${s.subjectcode }"
												<s:if test="#request.readSrc.subjectCode.subjectcode==#s.subjectcode">selected</s:if>>
												${s.subjectname }
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									关键字：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="srckeywords" id="srckeywords"
										size="50" value="${readSrc.srckeywords }" maxlength="60">
									最大60个字，多个以空格分隔
								</td>
							</tr>
							<tr>
								<td>
									上传封面：
								</td>
								<td style="word-break: break-all">
									<input type="file" name="cover" id="cover" size="50">
									<br />
									封面只能上传JPG、PNG、GIF格式的，最大50KB
								</td>
							</tr>
							<tr>
								<td>
									内容简介：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="contentintro" name="contentintro"
										rows="10">${readSrc.contentintro }</textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('contentintro');
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
