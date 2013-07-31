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

		<title>添加首页活动作品展示</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript" src="admin/js/trendsFile.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>

		<script type="text/javascript" src="admin/interest/js/activitytype.js"></script>
		<script type="text/javascript" src="admin/js/checkfile.js"></script>
		
		<script type="text/javascript">
			$().ready(function(){
			
				//添加自定义方法
				
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
			
				//表单验证
				$("#form_worksShowAdd").validate({
					//验证规则
					rules:{
						showTitle:"required",
						showUrl:"required",
						showSort:"number",
						cover:{
							required:true,
							check_cover:true
						}
					},
					messages:{
						showTitle:"显示标题不能为空!",
						showUrl:"链接地址不能为空!",
						showSort:"排序序号只能为数字!",
						cover:{
							required:"显示图片必须上传",
							check_cover:"显示图片只能上传JPG,PNG,GIF格式的文件!"
						}
					},
					/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
			        showErrors: function(errorMap, errorList) {   
			            var msg = "";   
			            $.each( errorList, function(i,v){   
			              msg += (v.message+"\r\n");   
			            });   
			            if(msg!=""){ 
			            	alert(msg);
			            }   
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
				兴趣频道管理&mdash;&mdash;添加首页活动作品展示
			</h1>
		</div>
		<form method="post" action="admin/AddWorksShow.action"
			name="form_worksShowAdd" id="form_worksShowAdd"
			enctype="multipart/form-data">
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="150">
									显示标题：
								</td>
								<td>
									<input type="text" name="showTitle" id="showTitle" size="50" />
								</td>
							</tr>

							<tr>
								<td align="left" width="150">
									链接地址：
								</td>
								<td>
									<input type="text" name="showUrl" id="showUrl" size="50" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									排序：
								</td>
								<td>
									<input type="text" name="showSort" id="showSort" value="0" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									上传显示图片：
								</td>
								<td>
									<input type="file" name="cover" id="cover" size="50" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									是否可用：
								</td>
								<td>
									<input type="radio" name="showEnabled" id="showEnabled" value="1"
										checked="checked" />
									有效
									<input type="radio" name="showEnabled" id="showEnabled" value="0" />
									无效
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
