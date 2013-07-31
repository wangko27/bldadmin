<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>您好，欢迎来到952116综合信息门户网！</title>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/interesting/moban.css" rel="stylesheet"
			type="text/css" />
		<link href="css/interesting/motyss.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			var ind=0;
			function showcontent(index){
				$("[id^='content']").each(function(i){
					if(index==i){
						$(this).show();
					}else{
						$(this).hide();
					}
				});
				return false;
			}
			function toUp(){
						ind--;
						if(ind<0){
							ind=0;
						}
						showcontent(ind);
						return false;
					}
			function toDown(len){
				 ind++;
				 if(ind>len-1){
					 	ind=len-1;
					}
				showcontent(ind);
				return false;
				}
				</script>
	</head>
	<body>
		<jsp:include page="top2.jsp"></jsp:include>
		<div class="bbj">
			<div class="mmaind">
				<jsp:include page="left.jsp"></jsp:include>
				<div class="mmleft">
				</div>
				<div class="mmright">
					<div class="ritu_1">
						<h1>
							<span>活动规则</span>
						</h1>
						<div class="neirr">
							<h2>
								<s:property value="activity.activitytitle" />
								主题活动规则
							</h2>
							${activity.activityrule }
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="mainbody">
			<jsp:include page="/base/bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
