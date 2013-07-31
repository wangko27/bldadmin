<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
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

		<title>活动线下图片管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/js/ext/resources/css/ext-all.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>

		<script type='text/javascript' src="js/ext/ext-base.js"></script>
		<script type='text/javascript' src="js/ext/ext-all.js"></script>
		<script type="text/javascript" src="js/swfupload.js"></script>
		<script type="text/javascript" src="js/uploaderPanel.js"></script>

		<script type="text/javascript">
			
			$().ready(function(){
				
				//添加图片
				$("#btnAddPic").bind("click",function(){
					Ext.onReady(function(){
						Ext.QuickTips.init();
						new Ext.Window({
							width : 650,
							title : '上传活动线下图片 批量上传图片（支持的图片类型：*.jpg;*.png;*.gif，单个图片最大不能超过300K）',
							height : 300,
							layout : 'fit',
							items : [
								{
									xtype:'uploadPanel',
									border : false,
									fileSize : 300,//限制文件大小
									uploadUrl : '<%=basePath%>admin/common/fileOperate!toFileUpload.action',
									flashUrl : 'js/swfupload.swf',//相对于jsp文件的目录
									filePostName : 'filedata', //后台接收参数
									fileTypes : '*.jpg;*.gif;*.png',//可上传文件类型
									postParams : {savePath:'${activity.unlinepath}',isFilenameNew:1} //上传文件存放目录
								}
							],listeners:{ 
								"close":function(){ 
									$("#form_picManage").submit(); 
								} 
							} 
						}).show();
					});
				});
				
				//删除图片
				$("#btnDeletePic").bind("click",function(){
					
					var deleteFileLength=$("input[name='deleteFilepath']:checked").length;
					if(deleteFileLength<1){
						alert("请至少选择一个图片!");
						return false;
					}
					
					if(confirm("您确定删除吗？")){
						$("#formDeleteFile").submit();
					}
				});
				
				//全选
				$("#btnSelectAll").bind("click",function(){
					$("input[name='deleteFilepath']").each(function(){
						if($("#chkAll").attr("checked")){
							$(this).attr("checked",true);
						}else{
							$(this).attr("checked",false);
						}
					});
				});
			});
			
		</script>
	</head>

	<body>
		<form action="admin/activity!picManage.action" method="post" name="form_picManage" id="form_picManage">
			<input type="hidden" name="activityid" id="activityid" value="${activity.activityid }"/>
		</form>
		<div class="maindiv">
			<h1>
				兴趣频道管理&mdash;&mdash; ${activity.activitytitle } &mdash;&mdash;
				活动线下图片管理
			</h1>
		</div>

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#afd3e9" align="center" style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="70%" height="24" background="skin/images/tbg.gif">
					&nbsp;图片管理&nbsp;
				</td>
				<td><input type="checkbox" name="chkAll" id="chkAll"/></td>
				<td width="80" align="right">
					<input type="button" value="全选" id="btnSelectAll" class="sst" />
				</td>
				<td width="80" align="right">
					<input type="button" value="删除图片" id="btnDeletePic" class="sst" />
				</td>
				<td width="80" align="right">
					<input type="button" value="添加图片" id="btnAddPic" class="sst" />
				</td>
			</tr>
			<tr align="center" bgcolor="#e8f0f3" height="22">
				<td colspan="5">
					<form action="admin/common/fileOperate!toDeleteFile.action" method="post" name="formDeleteFile" id="formDeleteFile">
						<input type="hidden" name="forwardPage" id="forwardPage" value="picManage"/>
						<input type="hidden" name="activityid" id="activityid" value="${activity.activityid }"/>
						<table>
							<s:iterator value="#request.list_unlinepath" id="unlinepath"
								status="s">
								<s:if test="#s.index%4==0">
									<tr>
								</s:if>
								<td width="120">
									<img src="${unlinepath }" width="120" height="150" />
								</td>
								<td valign="bottom" width="50">
									<input type="checkbox" name="deleteFilepath"
										id="deleteFilepath" value="${unlinepath }" />
								</td>
								<s:if
									test="(((#s.index+1)%4==0) && #s.index!=0) || ((#request.list_unlinepath.size-1)==#s.index)">
									</tr>
								</s:if>
							</s:iterator>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<jsp:include page="/comm/message.jsp"></jsp:include>
	</body>
</html>
