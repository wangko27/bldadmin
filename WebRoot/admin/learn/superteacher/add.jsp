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

		<title>学习频道管理——名师讲坛——名师信息添加</title>

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
				    var oEditor = CKEDITOR.instances.teacherIntroduction;
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
			
				$("#formSuperTeacherAdd").validate({
					//验证规则
					rules:{
						username:"required",
						teacherPost:"required",
						inSchool:"required",
						workyears:{
							number:true
						},
						cover:{
							check_cover:true
						},
						teaching_linian:{
							required:true,
							maxlength:512
						},
						teacherIntroduction:{
							check_content:true
						}
					},
					messages:{
						username:"姓名不能为空!",
						teacherPost:"职位不能为空!",
						inSchool:"所属学校不能为空!",
						workyears:{
							number:"教龄只能为数字!"
						},
						cover:{
							check_cover:"封面只能上传JPG,PNG,GIF格式的文件!"
						},
						teaching_linian:{
							required:"教学理念不能为空!",
							maxlength:$.validator.format("教学理念最大输入{0}字符!")
						},						
						teacherIntroduction:{
							check_content:"名师简介不能为空!"
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
				学习频道管理——名师讲坛——名师信息添加
			</h1>
		</div>
		<form method="post" action="admin/learn/addSuperTeacher.action"
			name="formSuperTeacherAdd" id="formSuperTeacherAdd"
			enctype="multipart/form-data">
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td align="left" width="100">
									姓名：
								</td>
								<td>
									<input type="text" name="username" id="username" size="50"
										maxlength="10">
									最多10个字
								</td>
							</tr>
							<tr id="addarea">
								<td align="left" width="100">
									职位：
								</td>
								<td>
									<input type="text" name="teacherPost" id="teacherPost"
										size="50" maxlength="30">
									最多30个字
								</td>
							</tr>
							<tr>
								<td>
									所在学校：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="inSchool" id="inSchool" size="50"
										maxlength="40">
									最多40个字
								</td>
							</tr>
							<tr>
								<td>
									教龄：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="workyears" id="workyears" size="50"> 年
								</td>
							</tr>
							<tr>
								<td>
									状态：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="flag" id="flag" value="1"
										checked="checked">
									在职
									<input type="radio" name="flag" id="flag" value="0">
									不在职
								</td>
							</tr>
							<tr>
								<td>
									头像：
								</td>
								<td style="word-break: break-all">
									<input type="file" name="cover" id="cover" size="50">
									<br />
									封面只能上传JPG、PNG、GIF格式的，最大50KB
								</td>
							</tr>
							<tr>
								<td>
									教学理念：
								</td>
								<td style="word-break: break-all">
									<textarea rows="3" cols="50" name="teaching_linian"
										id="teaching_linian"></textarea>
									最多512个字符
								</td>
							</tr>
							<tr>
								<td>
									名师简介：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="teacherIntroduction"
										name="teacherIntroduction" rows="10"></textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('teacherIntroduction');
									//]]></script>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="Submit" value="保存" class="sst">
									<input type="reset" name="Submit" value="重置" class="sst_1">
									<a href="admin/learn/superTeacher!openSuperTeacher.action" target="main">返回名师列表</a>
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
