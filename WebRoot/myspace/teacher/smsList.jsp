<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>您好，欢迎来到952116综合信息门户网！-- 家校互动短信查询</title>
    
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
			$("#tblSms tr:odd").addClass("t2");
			$("#smsQueryBtn").mouseover(function(){
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
				$("#smsQueryForm").attr("action","<%=basePath%>member/smsMsgAction!teaQuery.action");
				$("#smsQueryForm").submit();
			});
			
			
			$("#gradeId").change(function(){
				var gradeId = $(this).val();
				if(gradeId == '-1'){
					$("#classId option").remove();
					$("#classId").append("<option value='-1'>--必选--</option>");
					$("#stuId option").remove();
					$("#stuId").append("<option value='0'>--可选--</option>");
				}else{
				    $.ajax({
				      url:"<%=basePath%>member/smsMsgAction!ajaxClassByGrade.action",
				      type:"post",
				      data:{gradeId:gradeId},
				      success:function(msg){
				          if(msg != 'error'){
				          	$("#classId option").remove();
	 						$("#classId").append(msg);
	 						$("#stuId option").remove();
	 						$("#stuId").append("<option value='0'>--可选--</option>");
				          }else{
				          	alert("查询班级出错！请与管理员联系！");
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
					$("#stuId").append("<option value='0'>--可选--</option>");
				}else{
					$.ajax({
				      url:"<%=basePath%>member/smsMsgAction!ajaxStudentByClass.action",
				      type:"post",
				      data:{classId:classId},
				      success:function(msg){
				          if(msg != 'error'){
				          	$("#stuId option").remove();
	 						$("#stuId").append(msg);
				          }else{
				          	alert("查询学生出错！请与管理员联系！");
				          	return false;
				          }
				      }
				    });
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
            <li><a href="member/attenQueryAction!teaAttendancePager.action">考勤查询</a></li>
            <li class="bai"><a href="member/smsMsgAction!teaQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCourseByTea.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="<%=basePath%>member/smsMsgAction!teaQuery.action" method="post" id="smsQueryForm">
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td>
              日期：<input name="startDate" type="text" id="startDate" class="Wdate" style="float: none;width: 100px;" onclick="WdatePicker()"  value="${requestScope.startDate}" />
              &nbsp;&nbsp;到 &nbsp;&nbsp;&nbsp;<input name="endDate" type="text" id="endDate" style="float: none;width: 100px;" class="Wdate" onclick="WdatePicker()" value="${requestScope.endDate}"/>
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
              <td><input name="smsQueryBtn" id="smsQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
      
        <div class="xunc_2">
          <h1><span>查询结果：</span>（${requestScope.startDate} -- ${requestScope.endDate} + ${gradeName} + ${className} + ${stuName}）您的学生短信如下  (含作业、个性、成绩等短信)</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0" >
          	<tr>
              <td class="t1" width="12%">短信类别</td>
              <td class="t1" width="12%">学生姓名</td>
              <td class="t1" width="61%">信息内容</td>
              <td class="t1" width="15%">发送时间</td>
            </tr>
            <tbody id="tblSms">
          	<c:choose>
          		<c:when test="${not empty result.content}">
          			<c:forEach items="${result.content}" var="smsinfo">
          				<tr>
			                  <td align="center">${smsinfo.category_name}</td>
				              <td align="center">${smsinfo.xs_xming}</td>
				              <td align="center">${smsinfo.msm_content}</td>
				              <td align="center">${smsinfo.display_date}</td>
			            </tr>
          			</c:forEach>
          		</c:when>
          		<c:otherwise>
          		 <tr>
	              <td align="center" colspan="4">没有记录！</td>
	             </tr>
          		</c:otherwise>
          	</c:choose>
          	</tbody>
          </table>
	       <t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="smsQueryForm"></t:tpage>
        </div>
          </form>
     </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>
