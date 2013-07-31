<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 成绩查询</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/chaxun.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#tblExamDetail tr:odd").addClass("t2");
		});
	
	</script>
  </head>
  
  <body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="mainbody_1">
  <div class="dde">
    <div class="uuop">
	<jsp:include page="../content_leftmenu.jsp"></jsp:include>
	<div class="right">
        <div class="bobti">查询</div>
        <div class="dtai">
          <ul>
            <li class="bai"><a href="member/examQueryAction!teaExamList.action">成绩查询</a></li>
            <li><a href="member/attenQueryAction!teaAttendancePager.action">考勤查询</a></li>
            <li><a href="member/smsMsgAction!teaQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCourseByTea.action">课程表查询</a></li>
          </ul>
        </div>
        <div class="xunc_3"><a href="#">成绩查询</a> &gt; <b>${studentExamresult.TStudent.xsXming}的成绩表</b></div>
        <div class="xunc_2">
          <table width="720" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="t1">科目</td>
              <td class="t1">分数</td>
            </tr>
            <tbody id="tblExamDetail">
            <c:choose>
            	<c:when test="${not empty studentExamresult.listExamSubject}">
		            <c:forEach items="${studentExamresult.listExamSubject}" var="examrSubject">
			            <tr>
			              <td>${examrSubject.subject.subjectName}</td>
			              <td>${examrSubject.score}分</td>
			            </tr>
		            </c:forEach>
		             <tr>
		              <td colspan="2" class="t1">总分：${studentExamresult.alltotalScore}分</td>
		            </tr>
            	</c:when>
            	<c:otherwise>
            		<tr>
		              <td colspan="2" align="center">没有记录！</td>
		            </tr>
            	</c:otherwise>
            </c:choose>
            </tbody>
          </table>
        </div>
    </div>
  </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
 </body>
</html>