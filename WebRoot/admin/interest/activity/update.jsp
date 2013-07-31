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

		<title>修改活动</title>

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
				$("#form_activityUpdate").validate({
					//验证规则
					rules:{
						'programa.proID':"required",
						'activityType.typeId':"required",
						begindate:"required",
						enddate:"required",
						cover:{
							check_cover:true
						},
						featured:{
							check_cover:true
						},
						activitytitle:"required",
						activityintro:"required"
					},
					messages:{
						'programa.proID':"请选择所属栏目!",
						'activityType.typeId':"请选择所属类别!",
						begindate:"开始时间不能为空!",
						enddate:"结束时间不能为空!",
						cover:{
							check_cover:"封面只能上传JPG,PNG,GIF格式的文件!"
						},
						featured:{
							check_cover:"活动专题图片只能上传JPG,PNG,GIF格式的文件!"
						},
						activitytitle:"活动标题不能为空!",
						activityintro:"活动简介不能为空!"
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

	<body
		onload="selectType('${activity.programa.proID }',null,'${activity.activityType.typeId }')">
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash;修改活动
			</h1>
		</div>
		<form method="post" action="admin/UpdateActivity.action"
			name="form_activityUpdate" id="form_activityUpdate"
			enctype="multipart/form-data">
			<input type="hidden" name="activityid" id="activityid"
				value="${activity.activityid }" />
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" colspan="2">
									<img src="${activity.activitysrc }" width="186" height="220" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									所属栏目：
								</td>
								<td>
									<select name="programa.proID" id="programa.proID"
										onchange="selectType(this.value)">
										<s:iterator value="programaAll" id="p">
											
											<option value="${p.proID }"
												<s:if test="#p.proID==#request.activity.programa.proID">selected</s:if>>
												${p.proName } 
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									所属类别：
								</td>
								<td>
									<select name="activityType.typeId" id="typeId">
									</select>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									开始时间：
								</td>
								<td>
									<input type="text" name="begindate" id="begindate"
										value="<s:date name="#request.activity.begindate" format="yyyy-MM-dd" />"
										onclick="WdatePicker()" class="Wdate" readonly="readonly" />
								</td>
							</tr>

							<tr>
								<td align="left" width="150">
									结束时间：
								</td>
								<td>
									<input type="text" name="enddate" id="enddate"
										value="<s:date name="#request.activity.enddate" format="yyyy-MM-dd" />"
										onclick="WdatePicker()" class="Wdate" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									是否显示线下图片：
								</td>
								<td>
									<s:radio list="#{1:'显示',0:'不显示'}"
										value="%{#request.activity.isshowpic}" name="isshowpic"></s:radio>
								</td>
							</tr>
							<!-- 
							<tr>
								<td align="left" width="150">
									上传线下活动图片：
								</td>
								<td>
									<input type="button" value="添加图片" class="button" name="btn_add"
										onclick="createInput('span_upload','unline')" />
									<div id="span_upload"></div>
								</td>
							</tr> -->
							<tr>
								<td align="left" width="150">
									上传封面：
								</td>
								<td>
									<input type="file" name="cover" id="cover" size="50" />
									<br />
									封面只能上传JPG、PNG、GIF格式的，最大50KB
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									上传活动专题图片：
								</td>
								<td>
									<input type="file" name="featured" id="featured" size="50" />
									<br />
									活动专题图片只能上传JPG、PNG、GIF格式的，最大200KB
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									活动标题：
								</td>
								<td>
									<input type="text" name="activitytitle" id="activitytitle"
										maxlength="50" size="50" value="${activity.activitytitle }" />
									最大50个字
								</td>
							</tr>
							<tr>
								<td align="left" width="150" colspan="2">
									活动规则：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="activityrule" name="activityrule"
										rows="10">${activity.activityrule }</textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('activityrule');
									//]]></script>
								</td>
							</tr>
							<tr>
								<td align="left" width="150" colspan="2">
									活动简介：
								</td>
							</tr>
							<tr>
								<td style="word-break: break-all" colspan="2">
									<textarea cols="80" id="activityintro" name="activityintro"
										rows="10">${activity.activityintro }</textarea>
									<script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('activityintro');
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
