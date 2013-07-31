<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<title>添加文章类别</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="admin/skin/css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
		<script type="text/javascript">
			/*$.validator.setDefaults({
				submitHandler: function() { alert("submitted!"); }
			});*/			
				//类别改变，如果有子类，显示子类
			function typeChange(typeid,level){
				$.ajax({
					type:"post",
					url:"admin/SysArticle!getArticleTypeOption.action",
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
				系统文章管理&mdash;&mdash;添加文章类别
			</h1>
		</div>
		<form method="post" action="admin/SysArticletype!add.action"
			name="form_articleTypeAdd" id="form_articleTypeAdd">
			<s:token></s:token>
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr id="addarea">
								<td>
									上级类别：
								</td>
								<td>
									<select name="articletypeid0" id="articletypeid0" onchange="typeChange(this.value,0)">
										<option value="">
											请选择类别：
										</option>
										<c:forEach items="${ParentTypes}" var="st" varStatus="vs">
										<option value="${st.articletypeid }">
												${st.articletypename }
											</option>
										</c:forEach>		
									</select>
									<span id="spantype0"></span>
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									类别名称：
								</td>
								<td>
									<input type="text" name="articletypename" id="articletypename"
										size="30">
								</td>
							</tr>
							<tr>
								<td align="left" width="150">
									排序：
								</td>
								<td>
									<input type="text" name="articlesort" id="articlesort"
										size="30">
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
