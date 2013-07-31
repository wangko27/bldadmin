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

		<title>资讯频道管理——添加文章</title>

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
						articletypeid0:"required",
						metakeywords:"required",
						cover:"check_cover",
						articlesrccontent:{
							check_content:true
						}
					},
					messages:{
						articletitle:"标题不能为空!",
						articletypeid0:"请选择类别!",
						metakeywords:"资源关键字不能为空!",
						cover:"封面只能上传JPG,PNG,GIF格式的文件!",
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
			
			
			//类别改变，如果有子类，显示子类
			function typeChange(typeid,level){
				$.ajax({
					type:"post",
					url:"admin/articleType!getArticleTypeOption.action",
					data:{
						articletypeid:typeid
					},
					dataType:"text",
					success:function(msg){
						if(msg!=""){
							$("#spantype"+level).html("<select name=\"articletypeid"+(level+1)+"\" id=\"articletypeid"+(level+1)+"\" onchange=\"typeChange(this.value,"+(level+1)+")\">"+msg+"</select> <span id=\"spantype"+(level+1)+"\"></span>");
							$("#level").val((level+1));
						}else{
							$("#spantype"+level).html("");
							$("#level").val(level);
						}
					},
					error:function(xhr,msg,e){
						alert("error");
					}
				});
			}
		</script>
	</head>

	<body>
		<div class="maindiv">
			<h1>
				资讯频道管理——添加文章
			</h1>
		</div>
		<form method="post" action="admin/addArticle.action"
			name="formArticleAdd" id="formArticleAdd"
			enctype="multipart/form-data">
			<s:token></s:token>
			<input type="hidden" name="level" id="level" value="0">
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
									<input type="text" name="articletitle" id="articletitle"
										size="50" maxlength="30">
									最大30个字
								</td>
							</tr>
							<tr>
								<td>
									类别：
								</td>
								<td>
									<select name="articletypeid0" id="articletypeid0"
										onchange="typeChange(this.value,0)">
										<option value="">
											请选择类别
										</option>
										<s:iterator value="articleTypeAll" id="at">
											<option value="${at.articletypeid }">
												${at.articletypename }
											</option>
										</s:iterator>
									</select>
									<span id="spantype0"></span>
								</td>
							</tr>
							<tr>
								<td>
									关键字：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="metakeywords" id="metakeywords"
										size="30" maxlength="60">
									最大60个字，多个以空格分隔
								</td>
							</tr>
							<tr>
								<td>
									文章来源：
								</td>
								<td style="word-break: break-all">
									<input type="text" name="artfrom" id="artfrom" size="30"
										maxlength="30">
									最大30个字
								</td>
							</tr>
							<tr>
								<td>
									是否推荐：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="isrecommend" id="isrecommend"
										value="1" checked="checked">
									是
									<input type="radio" name="isrecommend" id="isrecommend"
										value="0">
									否
								</td>
							</tr>
							<tr>
								<td>
									是启置顶：
								</td>
								<td style="word-break: break-all">
									<input type="radio" name="istop" id="istop" value="1" checked="checked">
									是
									<input type="radio" name="istop" id="istop" value="0">
									否
								</td>
							</tr>
							<tr>
								<td>
									上传封面：
								</td>
								<td style="word-break: break-all">
									<input type="file" name="cover" id="cover" size="30">
									<br />
									封面只能上传JPG、PNG、GIF格式的，最大50KB
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
									CKEDITOR.replace('articlesrccontent',addUploadButton(this));
									 function addUploadButton(editor){
							           CKEDITOR.on('dialogDefinition', function( ev ){
							               var dialogName = ev.data.name;
							               var dialogDefinition = ev.data.definition;
							               if ( dialogName == 'image' ){
							                   var infoTab = dialogDefinition.getContents( 'info' );
							                   infoTab.add({
							                       type : 'button',
							                       id : 'upload_image',
							                       align : 'center',
							                       label : '上传',
							                       onClick : function( evt ){
							                           var thisDialog = this.getDialog();
							                           var txtUrlObj = thisDialog.getContentElement('info', 'txtUrl');
							                           var txtUrlId = txtUrlObj.getInputElement().$.id;
							                           addUploadImage(txtUrlId);
							                       }
							                   }, 'browse'); //place front of the browser button
							               }
							           });
							       }
									 function addUploadImage(theURLElementId){
						           		var uploadUrl = "<%=basePath%>uploadsFiles.jsp"; //这是我自己的处理文件/图片上传的页面URL
										 var obj = new Object();
								    	obj.name="admin/imgUpload.action";
							           var imgUrl = window.showModalDialog(uploadUrl,obj);
							       //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
							       //更多window.showModalDialog的使用方法参考
							           var urlObj = document.getElementById(theURLElementId);
							           urlObj.value = "<%=basePath%>"+imgUrl;
							           urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
							       }
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
