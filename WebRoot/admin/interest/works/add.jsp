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

		<title>添加作品</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript"
			src="js/jquery-plugin/validate/jquery.validate.js"></script>
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
				$("#form_worksAdd").validate({
					//验证规则
					rules:{
						memberid:"required",
						worksnumber:"required",
						workstitle:"required",
						worksintro:"required",
						cover:{
							check_cover:true
						},
						show:{
							check_cover:true
						},
						workscontent:"required"
					},
					messages:{
						memberid:"请选择作者!",
						worksnumber:"作品编号不能为空!",
						workstitle:"作品标题不能为空!",
						worksintro:"作品简介不能为空!",
						cover:{
							check_cover:"封面只能上传JPG,PNG,GIF格式的文件!"
						},
						show:{
							check_cover:"展示图片只能上传JPG,PNG,GIF格式的文件!"
						},
						workscontent:"作品介绍不能为空!"
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
			
			//显示会员
			function showMember(memberType){
				$.ajax({type:"post", url:"admin/works!getMemberOption.action", data:{memberType:memberType}, dataType:"text", success:function (msg) {
					$("#memberid option").each(function () {
						$(this).remove();//移除原有项
					});
					$("#memberid").append("<option value=\"\">请选择作者</option>");
					$(msg).appendTo("#memberid");
				}, error:function (xhr, msg, e) {
					alert("error");
				}});
			}
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash; ${activity.activitytitle } &mdash;&mdash; 添加作品
			</h1>
		</div>
		<form method="post" action="admin/AddWorks.action"
			name="form_worksAdd" id="form_worksAdd" enctype="multipart/form-data">
			<input type="hidden" name="activity.activityid"
				id="activity.activityid" value="${activity.activityid }" />
			<input type="hidden" name="activityid" id="activityid"
				value="${activity.activityid }" />
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="150">
									作者：
								</td>
								<td>
									<select name="memberType" id="memberType"
										onchange="showMember(this.value)">
										<option value="3"
											<s:if test="#attr.memberType==3">selected</s:if>>
											老师
										</option>
										<option value="2"
											<s:if test="#attr.memberType==2">selected</s:if>>
											家长
										</option>
										<option value="1"
											<s:if test="#attr.memberType==1">selected</s:if>>
											学生
										</option>
										<option value="4"
											<s:if test="#attr.memberType==4">selected</s:if>>
											其他注册用户
										</option>
									</select>
									<select name="member.memberid" id="memberid">
										<option value="">
											请选择作者
										</option>
										<s:iterator value="#request.list_member" id="m">
											<option value="${m.memberid }"
												<s:if test="#m.memberid==#attr['member.memberid']">selected</s:if>>
												${m.username }
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									作品编号：
								</td>
								<td>
									<input type="text" name="worksnumber" id="worksnumber"
										value="${param.worksnumber }" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									上传封面：
								</td>
								<td>
									<input type="file" name="cover" id="cover" size="50" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									上传展示图片：
								</td>
								<td>
									<input type="file" name="show" id="show" size="50" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									作品标题：
								</td>
								<td>
									<input type="text" name="workstitle" id="workstitle" size="50"
										value="${param.workstitle }" />
								</td>
							</tr>

							<tr>
								<td align="left" width="150">
									作品简介：
								</td>
								<td>
									<textarea name="worksintro" id="worksintro" rows="5" cols="50"
										>${param.worksintro }</textarea>
								</td>
							</tr>
							<tr>
								<td align="left" width="150" colspan="2">
									作品介绍：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="workscontent" name="workscontent"
										rows="10">${param.workscontent }</textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('workscontent');
									//]]></script>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="save" value="保存" class="sst">
									<input type="reset" name="Submit" value="重置" class="sst_1">
									<input type="button" name="back" onclick="javascript:window.location='admin/works!manage.action?activityid=${activity.activityid }'" value="返回" class="sst">
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
