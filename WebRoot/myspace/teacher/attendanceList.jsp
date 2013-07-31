<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../../comm/common_tag.jsp" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>学生考勤查询</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/chaxun.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"  defer="defer"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#tblAttendance tr:odd").addClass("t2");
			
			$("#attenQueryBtn").mouseover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				if(compareDate($("#startDate").val(),$("#endDate").val())){
					return false;
				}
				var gradeId = $("#gradeId").val();
				if(gradeId == 0 || gradeId == -1){
					alert("请选择年级！");
					return false;
				}
				var classId = $("#classId").val();
				if(classId == -1){
					alert("请选择班级！");
					return false;
				}
				var startDate = $("#startDate").val();
				if(startDate == ''){
					alert("请选择开始日期！");
					return false;
				}
				var endDate = $("#endDate").val();
				if(endDate == ""){
					alert("请选择结束日期！");
					return false;
				}
				$("#teaAttenForm").attr("action","<%=basePath%>member/attenQueryAction!teaAttendancePager.action");
				$("#teaAttenForm").submit();
			});
			
			
			$("#gradeId").change(function(){
				var gradeId = $(this).val();
				if(gradeId == '-1'){
					$("#classId option").remove();
					$("#classId").append("<option value='-1'>--必选--</option>");
					$("#stuId option").remove();
					$("#stuId").append("<option value='0'>--可选--</option>");
				}else{
					$("#teaAttenForm").attr("action","<%=basePath%>member/attenQueryAction!onchangeGradeByTea.action");
					$("#teaAttenForm").submit();
				}
			});
			
			$("#classId").change(function(){
				var classId = $(this).val();
				if(classId == '-1'){
					$("#stuId option").remove();
					$("#stuId").append("<option value='0'>--可选--</option>");
				}else{
					$("#teaAttenForm").attr("action","<%=basePath%>member/attenQueryAction!teaAttendancePager.action");
					$("#teaAttenForm").submit();
				}
				
			});
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
            <li><a href="member/examQueryAction!teaExamList.action">成绩查询</a></li>
            <li class="bai"><a href="member/attenQueryAction!teaAttendancePager.action">考勤查询</a></li>
            <li><a href="member/smsMsgAction!teaQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCourseByTea.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="<%=basePath%>member/attenQueryAction!teaAttendancePager.action" method="post" id="teaAttenForm">
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td>
              日期：<input name="startDate" type="text" id="startDate" class="Wdate" style="float: none" onclick="WdatePicker()"  value="${requestScope.startDate}" />
                到&nbsp;&nbsp;&nbsp;<input name="endDate" type="text" id="endDate" style="float: none" class="Wdate" onclick="WdatePicker()" value="${requestScope.endDate}"/>
                </td>
              <td>年级：
                <select name="gradeId" id="gradeId">
                	<c:choose>
                		<c:when test="${not empty listGrades}">
                			<option value="-1" <c:if test="${gradeId eq -1 }">selected="selected"</c:if> >--必选--</option>
                			<c:forEach items="${listGrades}" var="grade">
                				<option value="${grade.njId}" <c:if test="${grade.njId eq  gradeId}">selected="selected"</c:if>>${grade.njMcheng}</option>
                			</c:forEach>
                		</c:when>
                		<c:otherwise>
                			<option value="0">没有年级</option>
                		</c:otherwise>
                	</c:choose>
                </select>
              </td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>班级：
                 <select name="classId" id="classId">
           			<option value="-1" <c:if test="${classId eq -1 }">selected="selected"</c:if>>--必选--</option>
           			<c:forEach items="${listClasses}" var="classes">
           				<option value="${classes.bjId}" <c:if test="${classes.bjId eq classId}">selected="selected"</c:if> >${classes.bjMcheng}</option>
           			</c:forEach>
                </select>
              </td>
              <td>学生：
                <select name="stuId" id="stuId">
                	<option value="0">--可选--</option>
                	<c:forEach items="${listStudents}" var="student">
                		<option value="${student.xsId}" <c:if test="${student.xsId eq stuId}">selected="selected"</c:if>>${student.xsXming}</option>
                	</c:forEach>
                	<option value="-1" <c:if test="${stuId eq -1 }">selected="selected"</c:if>>--全部--</option>
                </select>
                
                </td>
              <td><input name="attenQueryBtn" id="attenQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
       
        <div class="xunc_2">
          <h1><span>查询结果：</span>（${requestScope.startDate} -- ${requestScope.endDate} + ${gradeName} + ${className} + ${stuName}）</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="t1">日期</td>
              <td class="t1">班级</td>
              <td class="t1">姓名</td>
              <td class="t1">刷卡时间</td>
              <td class="t1">状态</td>
            </tr>
            <tbody id="tblAttendance">
            <c:choose>
            	<c:when test="${not empty studentAttenRecordPager.content}">
            		<c:forEach items="${studentAttenRecordPager.content}" var="studentAttenRecord">
            			 <tr>
			              <td><fmt:formatDate value="${studentAttenRecord.readcardTime}" pattern="yyyy.MM.dd"/></td>
			              <td><c:out value="${studentAttenRecord.TStudent.TClasses.bjMcheng}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${studentAttenRecord.TStudent.xsXming}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><fmt:formatDate value="${studentAttenRecord.readcardTime}" pattern="HH:mm:ss"/></td>
			               <c:if test="${studentAttenRecord.inOutState eq '1'}">
			              	 <td><font color="green"> 进校 </font></td>
			              </c:if>
			             <c:if test="${studentAttenRecord.inOutState eq '0'}">
			              	 <td><font color="red">  出校 </font></td>
			              </c:if>
			            </tr>
            		</c:forEach>
            	</c:when>
            	<c:otherwise>
            		 <tr>
		              <td colspan="5" align="center">没有记录！</td>
		            </tr>
            	</c:otherwise>
            </c:choose>
            </tbody>
          </table>
	       <t:tpage pageDiv="page" page="${studentAttenRecordPager.page}" goImg="img/learning_img/gog.gif" formId="teaAttenForm"></t:tpage>
        </div>
         </form>
     </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>
