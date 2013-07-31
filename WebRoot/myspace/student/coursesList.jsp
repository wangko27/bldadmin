<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  isELIgnored = "false"%>
<%@ include file="../../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>课程表查询</title>
    
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
			$("#stuCourseTbl tr:odd").addClass("t2");
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
            <li><a href="member/examQueryAction!stuExamList.action">成绩查询</a></li>
            <li><a href="member/attenQueryAction!stuAttendancePager.action">考勤查询</a></li>
             <li><a href="member/smsMsgAction!stuQuery.action">短信查询</a></li>
            <li class="bai"><a href="member/courseAction!getCoursesByStu.action">课程表查询</a></li>
          </ul>
        </div>
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td>年级：
                <select name="gradeId" disabled="disabled">
                	<c:choose>
                		<c:when test="${not empty listGrades}">
                			<c:forEach items="${requestScope.listGrades}" var="grade">
                				<option value="${grade.njId}" <c:if test="${gradeId eq grade.njId}">selected="selected" </c:if> >${grade.njMcheng}</option>
                			</c:forEach>
                		</c:when>
                		<c:otherwise>
                			<option value="0">没有年级</option>
                		</c:otherwise>
                	</c:choose>
                </select>
              </td>
              <td>班级：
                <select name="classId" disabled="disabled">
                	<c:choose>
                		<c:when test="${not empty listClasses}">
                			<c:forEach items="${requestScope.listClasses}" var="classes">
                				<option value="${classes.bjId}" <c:if test="${classes.bjId eq classId}">selected="selected" </c:if> >${classes.bjMcheng}</option>
                			</c:forEach>
                		</c:when>
                		<c:otherwise>
                			<option value="0">没有年级</option>
                		</c:otherwise>
                	</c:choose>
                </select>
              </td>
              <td><input name="" type="button"  class="cx" disabled="disabled"/></td>
            </tr>
          </table>
        </div>
        <div class="xunc_2">
          <h1><span>查询结果：</span>（${requestScope.gradeName}年级 + ${requestScope.className}）</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="t1">课序</td>
              <td class="t1">星期一</td>
              <td class="t1">星期二</td>
              <td class="t1">星期三</td>
              <td class="t1">星期四</td>
              <td class="t1">星期五</td>
              <td class="t1">星期六</td>
              <td class="t1">星期日</td>
            </tr>
            <tbody id="stuCourseTbl">
            <c:choose>
            	<c:when test="${not empty listCourses}">
	            	<c:forEach items="${listCourses}" var="course">
			            <tr>
			              <td><c:out value="${course.courseSequence}" default="&nbsp;" escapeXml="false"></c:out> </td>
			               <td><c:out value="${course.monday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.tuesday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.wednesday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.thursday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.friday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.saturday}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${course.sunday}" default="&nbsp;" escapeXml="false"></c:out></td>
			            </tr>
		             </c:forEach>
            	</c:when>
            	<c:otherwise>
            		<tr>
            			<td colspan="8" bgcolor="#ffffff" align="center">没有记录！</td>
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
