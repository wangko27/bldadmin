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
 	<link href="<%=basePath%>css/user/zuo.css" rel="stylesheet" type="text/css" />
 	<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
 	<script type="text/javascript">
 		$().ready(function(){
 		    //学期下拉列表
 			$("#termId").change(function(){
 				var termId = $(this).val();
 				$.ajax({
 					type:"post",
 					url:"<%=basePath%>member/examQueryAction!ajaxExaminationByTerm.action",
 					data:{termId:termId, examDate:'-1'},
 					success:function(data){
 						if(data == 'exception'){
 							alert("查询出错！");
 							return ;
 						}else{
 							$("#examDate").val("-1");
 							$("#examId option").remove();
 							$("#examId").append(data);
 						}
 					}
 				});
 			});
 			//月份下拉
 			$("#examDate").change(function(){
 				var termId = $("#termId").val();
 				$.ajax({
 					type:"post",
 					url:"<%=basePath%>member/examQueryAction!ajaxExaminationByTerm.action",
 					data:{termId:termId, examDate:$(this).val()},
 					success:function(data){
 						if(data == 'exception'){
 							alert("查询出错！");
 							return ;
 						}else{
 							$("#examId option").remove();
 							$("#examId").append(data);
 						}
 					}
 				});
 			});
 		
 			$("#stuQueryBtn").mouseover(function(){
 				$(this).css("cursor","hand");
 			}).click(function(){
 				var examId = $("#examId").val();//考试id
 				var termId = $("#termId").val();
 				if(examId == "0"){
 					alert("请选择考次！");
 					return false;
 				}
 				if(termId == "0"){
 					alert("请选择学期!");
 					return false;
 				}
 				var termName = $("#termId").find("option:selected").text();
 				var examDateId = $("#examDate").val();
 				var examDate = $("#examDate").find("option:selected").text();
 				var examName = $("#examId").find("option:selected").text();
 				$.ajax({
 					type:"post",
 					url:"<%=basePath%>member/examQueryAction!getStuExamination.action",
 					data:{examId:examId, examName:examName, termName:termName, examDateId:examDateId, examDate:examDate },
 					success:function(data){
 						if(data == 'exception'){
 							alert("查询出错！");
 							return ;
 						}else{
 							$("#examinationDiv").html(data);
 						}
 					}
 				});
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
            <li class="bai"><a href="member/examQueryAction!stuExamList.action">成绩查询</a></li>
            <li><a href="member/attenQueryAction!stuAttendancePager.action">考勤查询</a></li>
            <li><a href="member/smsMsgAction!stuQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCoursesByStu.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="" method="post" id="stuQueryForm">
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td>学期：
                <select name="termId" id="termId">
                	<c:if test="${not empty requestScope.listTermsets}">
                		<c:forEach items="${requestScope.listTermsets}" var="term">
                			<option value="${term.termId}" <c:if test="${term.termId eq terId}"></c:if>>${term.termName}</option>
                		</c:forEach>
                	</c:if>
                	<c:if test="${empty requestScope.listTermsets}">
                		<option value="0">没有学期</option>
                	</c:if>
                </select>
                <select name="examDate" id="examDate">
                	<option value="-1">--不限--</option>
                	<option value="1月">1月</option>
                	<option value="2月">2月</option>
                	<option value="3月">3月</option>
                	<option value="4月">4月</option>
                	<option value="5月">5月</option>
                	<option value="6月">6月</option>
                	<option value="7月">7月</option>
                	<option value="8月">8月</option>
                	<option value="9月">9月</option>
                	<option value="10月">10月</option>
                	<option value="11月">11月</option>
                	<option value="12月">12月</option>
                	
                </select>
                </td>
              <td>考试名称：
                <select name="examId" id="examId">
                	<option value="0">--请选择--</option>
                	<c:forEach items="${requestScope.listExaminations}" var="examination">
                		<option value="${examination.examId}" <c:if test="${examination.examId eq examId}"></c:if>>${examination.examName}</option>
                	</c:forEach>
                </select>
              </td>
              <td><input name="stuQueryBtn"  id="stuQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
        </form>
        <div class="xunc_2" id="examinationDiv">
          <h1><span>查询结果：</span></h1>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
 </body>
</html>
