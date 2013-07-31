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
<link href="css/interesting/moban.css" rel="stylesheet" type="text/css" />
<link href="css/interesting/motyss.css" rel="stylesheet" type="text/css" />
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
        <h1><span>活动介绍及图片</span></h1>
         <div class="neirr">
         	<h2><s:property value="activity.activitytitle" />主题活动介绍</h2>
         		<c:forEach items="${content}" var="con" varStatus="index">
									<c:choose>
										<c:when test="${index.index==0}">
											<div id="content${index.index }">
												${con }
											</div>
										</c:when>
										<c:otherwise>
											<div id="content${index.index }" style="display: none">
												${con }
											</div>
										</c:otherwise>
									</c:choose>
								</c:forEach>
		 </div>
		 <div class="page">
		<ul>
				<li>
					<a href="#" onclick="return showcontent(0)">首页</a>
				</li>
				<li>
					<a href="#" onclick="return toUp()">上一页</a>
				</li>
				<c:forEach begin="1" end="${srclength}" var="showindex" varStatus="ind">
				<li>
					<a href="#" onclick="return showcontent(${ind.index-1 })">${showindex }</a>
				</li>
				</c:forEach>
				<li>
					<a href="#" onclick="return toDown(${srclength})">下一页</a>
				</li>
				<li>
					<a href="#" onclick="return showcontent(${srclength-1 })">尾页</a>
				</li>
		</ul>
        </div>
         <div class="zuop">活动图片</div>
         <div class="neirr_1" id="imgs" >
         <c:choose>
         	<c:when test="${empty album.str_picture}">
				<a href="#"><img src="<%=basePath%>img/learning_img/tu6.gif" /> </a>
        	 </c:when>
         <c:otherwise>
         	<script>
         		var arr=new Array(${album.str_picture});
         		var imgs=document.getElementById("imgs");
         		//alert(arr.length);
         		var lisHtml='';
         			if(arr.length>0){        		
         				for(var i=0;i<arr.length;i++){
							lisHtml=lisHtml+'<a href="#"><img src="'+'<%=basePath%>${album.albumPath}/'+arr[i]+'"/></a>';
						}
					}
					imgs.innerHTML=lisHtml;
         	</script>
         </c:otherwise>
         </c:choose>
         </div>
	</div>
    </div>
  </div>
</div>

<div class="mainbody">
	<jsp:include page="bottom.jsp"></jsp:include>
</div>
</body>
</html>
