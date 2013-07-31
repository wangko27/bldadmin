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
    
    <title>您好，欢迎来到952116综合信息门户网！-- 成绩查询</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/chaxun.css" rel="stylesheet" type="text/css" />
 	<link href="<%=basePath%>css/user/zuo.css" rel="stylesheet" type="text/css" />
 	<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
 	<script type="text/javascript">
 		$().ready(function(){
 		    //学期下拉列表
 			$("#termId").change(function(){
 					var termId = $(this).val();
 					if(termId == '0'){
 					   $("#examId option").remove();
 					   $("#examId").append("<option value='0'>--请选择--</option>");
 					}else{
	 					var classId = $("#classId").val();
			 		    $.ajax({
		 					url:"<%=basePath%>member/examQueryAction!ajaxExamByTerm.action",
		 					type:"post",
		 					data:{termId : $(this).val(),classId : classId},
		 					success:function(msg){
		 						if(msg != 'exception'){
		 						    $("#examId option").remove();
		 						    $("#examId").append(msg);
		 						    $("#subjectId option").remove();
		 		    				$("#subjectId").append("<option value='-1'>全部科目</option>");
		 						}else{
		 							alert("出错了，请与管理员联系！");
		 							return false;
		 						}
		 					}
		 				});
 					}
 			});
 			
 			$("#gradeId").change(function(){
 				if($(this).val() != '0'){
	 				$.ajax({
	 					url:"<%=basePath%>member/examQueryAction!ajaxClassByGrade.action",
	 					type:"post",
	 					data:{gradeId : $(this).val()},
	 					success:function(msg){
	 						if(msg != 'exception'){
	 						    $("#classId option").remove();
	 						    $("#classId").append(msg);
	 						    $("#stuId option").remove();
	 						    $("#stuId").append("<option value='-1'>--全部--</option>");
	 						}else{
	 							alert("出错了，请与管理员联系！");
	 							return false;
	 						}
	 					}
	 				});
 				}
 			});
 			
 			$("#classId").change(function(){
 				var classId = $(this).val();
 				if(classId == '-1'){
 					$("#stuId option").remove();
	 			    $("#stuId").append("<option value='-1'>--全部--</option>");
 				}else{
 					var termId = $("termId").val();
	 				$.ajax({
	 					type:"post",
	 					url:"<%=basePath%>member/examQueryAction!ajaxStuAndExamByClass.action",
	 					data:{classId : $(this).val() , termId : termId},
	 					dataType: "json",
	 					success:function(data){
	 						if(data != 'exception'){
	 						    $("#stuId option").remove();
	 						    $("#stuId").append(data.stuList);
	 						    $("#examId option").remove();
	 						    $("#examId").append(data.examList)
	 						}else{
	 							alert("出错了，请与管理员联系！");
	 							return false;
	 						}
	 					}
		 			});
 				}
 			});
 		
 		    $("#examId").change(function(){
 		    	var examId = $(this).val();
	 		    if(examId == '0'){
	 		    	$("#subjectId option").remove();
	 		    	$("#subjectId").append("<option value='-1'>全部科目</option>");
	 		    }else{
	 		    var gradeId = $("#gradeId").val();
		 		   $.ajax({
	 					url:"<%=basePath%>member/examQueryAction!ajaxSubjectByExam.action",
	 					type:"post",
	 					data:{examId:examId, gradeId:gradeId},
	 					success:function(data){
	 						if(data != 'exception'){
	 						    $("#subjectId option").remove();
	 		    				$("#subjectId").append(data);
	 						}else{
	 							alert("出错了，请与管理员联系！");
	 							return false;
	 						}
	 					}
		 			});
	 		    }
 		    });
 		    
 			$("#examQueryBtn").mouseover(function(){
 				$(this).css("cursor","hand");
 			}).click(function(){
 				if($("#classId").val() == '0'){
 					alert("请选择班级！");
 					return false;
 				}
 				if($("#examId").val() == '0'){
 					alert("请选择考试名称！");
 					return false;
 				}
 				$("#teaExamForm").attr("action","<%=basePath%>member/examQueryAction!teaExamList.action");
 				$("#teaExamForm").submit();
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
            <li class="bai"><a href="member/examQueryAction!teaExamList.action">成绩查询</a></li>
            <li><a href="member/attenQueryAction!teaAttendancePager.action">考勤查询</a></li>
            <li><a href="member/smsMsgAction!teaQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCourseByTea.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="<%=basePath%>member/examQueryAction!teaExamList.action" method="post" id="teaExamForm">
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="4" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td>年级：
                <select name="gradeId" id="gradeId">
                	<c:choose>
                		<c:when test="${not empty listGrades}">
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
				 <td>班级：
                <select name="classId" id="classId">
                	<c:choose>
                		<c:when test="${not empty listClasses}">
                			<c:forEach items="${listClasses}" var="classes">
                				<option value="${classes.bjId}" <c:if test="${classes.bjId eq classId}">selected="selected"</c:if> >${classes.bjMcheng}</option>
                			</c:forEach>
                		</c:when>
                		<c:otherwise>
                			<option value="0">没有班级</option>
                		</c:otherwise>
                	</c:choose>
                </select>
                </td>
                <td>学生：
                <select name="stuId" id="stuId">
                	<option value="-1">--全部--</option>
                	<c:forEach items="${listStudents}" var="student">
                		<option value="${student.xsId}" <c:if test="${student.xsId eq stuId}">selected="selected"</c:if>>${student.xsXming}</option>
                	</c:forEach>
                </select>
               </td>
               <td></td>
            </tr>
             <tr>
              <td>
              学期:
              <select name="termId" id="termId">
                	<c:if test="${not empty requestScope.listTermsets}">
                		<c:forEach items="${requestScope.listTermsets}" var="term">
                			<option value="${term.termId}" <c:if test="${term.termId eq termId}">selected="selected"</c:if>>${term.termName}</option>
                		</c:forEach>
                	</c:if>
                	<c:if test="${empty requestScope.listTermsets}">
                		<option value="0">没有学期</option>
                	</c:if>
                </select>
            </td>
            <td>
              考试名称：
                <select name="examId" id="examId">
                	<option value="0">--请选择--</option>
                	<c:forEach items="${listExaminations}" var="examination">
                		<option value="${examination.examId}" <c:if test="${examination.examId eq examId}">selected="selected"</c:if> >${examination.examName}</option>
                	</c:forEach>
                </select>
               </td>
              <td>科目：
                <select name="subjectId" id="subjectId">
                <option value="-1" <c:if test="${subjectId eq -1 }">selected="selected"</c:if>>全部科目</option>
                <c:forEach items="${listSubjects}" var="subject">
                	<option value="${subject.subjectId}"<c:if test="${subject.subjectId eq subjectId}">selected="selected"</c:if> >${subject.subjectName}</option>
                </c:forEach>
                </select>
                </td>
              <td><input name="examQueryBtn" id="examQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
        <div class="xunc_2">
          <h1><span>查询结果：</span>(${termName} + ${examName}) + ${gradeName} + ${className} + 全部科目)</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="t1">班级</td>
              <td class="t1">学生姓名</td>
              <td class="t1">科目</td>
              <td class="t1">总分</td>
              <td class="t1">班级排名</td>
              <td class="t1">年级排名</td>
              <td class="t1">操作</td>
            </tr>
           <c:choose>
           	<c:when test="${not empty result.content}">
           			<c:forEach items="${result.content}" var="stuExamresult">
           				 <tr>
			              <td><c:out value="${stuExamresult.TClasses.bjMcheng}" default="&nbsp;" escapeXml="false"></c:out>  </td>
			              <td><c:out value="${stuExamresult.TStudent.xsXming}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td>全部科目</td>
			              <td><c:out value="${stuExamresult.alltotalScore}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${stuExamresult.classRank}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><c:out value="${stuExamresult.njRank}" default="&nbsp;" escapeXml="false"></c:out></td>
			              <td><a href="<%=basePath%>member/examQueryAction!getExaminationDetail.action?exam_id=${stuExamresult.cjId}">查看分数</a></td>
			            </tr>
           			</c:forEach>
           	</c:when>
           	<c:otherwise>
           		<tr><td align="center" colspan="7">没有记录！</td></tr>
           	</c:otherwise>
           </c:choose>
          </table>
        </div>
        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="teaExamForm"></t:tpage>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
 </body>
</html>
