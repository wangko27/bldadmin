<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-修改论文</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/usermaid.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
	$().ready(function() {
	
		
		$("#subbtn").click(function(){
			
			$("#form1").attr("action","<%=basePath%>myspace/comm/mStudyUpd.action");
			$("#form1").submit();
		
		});
		
		$("#reset").click(function(){
			
			$("#form1").attr("action","<%=basePath%>myspace/comm/mStudyList.action");
			$("#form1").submit();
		});
		
	});
	</script>

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    
    <form action="myspace/comm/mStudyUpd.action" id="form1" method="post">
    <s:token></s:token>
    <input type="hidden" name="studysrc.articlesrcid" value="${studysrc.articlesrcid }" />
    <div class="mainbody_1">
	  <div class="dde">
	    <div class="uuop">
	      <div class="right_1">
	        <div class="bobti"> 品学论道 </div>
	        <div class="dtai_1">
	          <ul>
	          </ul>
	        </div>
	        <div class="bbti">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input id="title" name="studysrc.articletitle" value="${ studysrc.articletitle }" type="text" /></div>
	        <div class="bbti">内容摘要：<textarea name="studysrc.articleintro" cols="44" rows="5">${studysrc.articleintro }</textarea></div>
	        <div class="bbti">关&nbsp;&nbsp;键&nbsp;&nbsp;字：<input name="studysrc.metakeywords" type="text" value="${studysrc.metakeywords }"></input></div>
	        <div class="eidm">
	        	<textarea id="art" name="studysrc.articlesrccontent" cols="" rows="">${studysrc.articlesrccontent }</textarea>
                <script type="text/javascript">
				//<![CDATA[
				window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
				//]]>
				</script>
				<script type="text/javascript"
					src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V">
				</script>
				<script type="text/javascript">
				//<![CDATA[
				CKEDITOR.replace('art');
				//]]>
				</script>
	        </div>
	        
	        <div class="botton"><img id="subbtn" src="img/user_img/qued.gif"  /><img  id="reset" src="img/user_img/qux.gif" /></div>
	      </div>
	    </div>
	  </div>
	</div>
	</form>
	
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
	
  </body>
</html>
