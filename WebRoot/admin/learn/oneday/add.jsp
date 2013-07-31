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

		<title>学习频道管理——一天一课添加</title>

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
			
				//验证资源类型
				$.validator.methods.check_resource = function(value, element, param){
					if(value!=""){   
					    //验证上传文件类型
						var allowFileType = "DOC,TXT,XLS,PDF,PPT,RAR,ZIP,JPG,GIF,PNG,BMP";
						return checkFileType(value, allowFileType);
					}else{
						return true;
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
			
				$("#formOnedayAdd").validate({
					//验证规则
					rules:{
						readsrctile:"required",
						'gradeCode.gradecode':"required",
						'subjectCode.subjectcode':"required",
						srckeywords:"required",
						cover:{
							check_cover:true
						},
						resource:{
							required:true,
							check_resource:true
						},
						downpoint:{
							required:true,
							number:true
						},
						contentintro:{
							check_content:true
						}
					},
					messages:{
						readsrctile:"标题不能为空!",
						'gradeCode.gradecode':"请选择年级!",
						'subjectCode.subjectcode':"请选择科目!",
						srckeywords:"关键字不能为空!",
						cover:{
							check_cover:"封面只能上传JPG,PNG,GIF格式的文件!"
						},
						resource:{
							required:"请上传课件!",
							check_resource:"课件只能上传DOC,TXT,XLS,PDF,PPT,RAR,ZIP,JPG,GIF,PNG,BMP格式的文件!"
						},
						downpoint:{
							required:"下载所需积分不能为空!",
							number:"下载所需积分只能为整数!"
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

	<body>
		<div class="maindiv">
			<h1>
				学习频道管理——一天一课添加
			</h1>
		</div>
		<form method="post" action="admin/learn/addOneday.action"
			name="formOnedayAdd" id="formOnedayAdd" enctype="multipart/form-data">
			<s:token></s:token>
			<input type="hidden" name="username" id="username" value="编辑员">
			<input type="hidden" name="readSrcType.srctypeid"
				id="readSrcType.srctypeid" value="8a8081a131bbd5780131bbd5cdc30001" />
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td align="left" width="150">
									标题：
								</td>
								<td>
									<input type="text" name="readsrctile" id="readsrctile"
										size="50" maxlength="30" value="${param.readsrctile }">
									最大30个字
								</td>
							</tr>
							<tr>
								<td>
									年级：
								</td>
								<td style="word-break: break-all">
									<select name="gradeCode.gradecode" id="gradeCode.subjectcode">
										<option value="">
											请选择年级
										</option>
										<s:iterator value="gradeCodeAll" id="g">
											<option value="${g.gradecode }">
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
										<option value="">
											请选择科目
										</option>
										<s:iterator value="subjectCodeAll" id="s">
											<option value="${s.subjectcode }">
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
										size="50" maxlength="60" value="${param.srckeywords }">
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
									上传课件：
								</td>
								<td style="word-break: break-all">
									<input type="file" name="resource" id="resource" size="50">
									<br />
									课件只能上传DOC、TXT、XLS、PDF(最大1M)，JPG、GIF、PNG、BMP(最大2M)，PPT(最大5M)，RAR、ZIP(最大10M)格式的
									<br />
									下载所需积分：
									<input type="text" name="downpoint" id="downpoint" value="0"
										size="3" maxlength="3">
									分
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
										rows="10">${param.contentintro }</textarea>
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
