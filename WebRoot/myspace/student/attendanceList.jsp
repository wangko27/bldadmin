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
    
    <title>您好，欢迎来到952116综合信息门户网！-- 学生考勤查询</title>
    
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
				$("#attenQueryForm").attr("action","<%=basePath%>member/attenQueryAction!stuAttendancePager.action");
				$("#attenQueryForm").submit();
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
            <li><a href="member/examQueryAction!stuExamList.action">成绩查询</a></li>
            <li class="bai"><a href="member/attenQueryAction!stuAttendancePager.action">考勤查询</a></li>
            <li><a href="member/smsMsgAction!stuQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCoursesByStu.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="<%=basePath%>member/attenQueryAction!stuAttendancePager.action" method="post" id="attenQueryForm">
        <div class="xunc_1">
          <table width="700" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3" class="chx">查询条件：</td>
            </tr>
            <tr>
              <td colspan="2">
              日期：<input name="startDate" type="text" id="startDate" class="Wdate" style="float: none" onclick="WdatePicker()"  value="${requestScope.startDate}" />
                到 &nbsp;&nbsp;&nbsp;<input name="endDate" type="text" id="endDate" style="float: none" class="Wdate" onclick="WdatePicker()" value="${requestScope.endDate}"/>
             </td>
              <td><input name="attenQueryBtn" id="attenQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
      
        <div class="xunc_2">
          <h1><span>查询结果：</span>（${requestScope.startDate} --- ${requestScope.endDate}）您的考勤记录如下</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0" >
          	<tr>
              <td class="t1">日期</td>
              <td class="t1">刷卡时间</td>
              <td class="t1">出入校情况</td>
            </tr>
            <tbody id="tblAttendance">
          	<c:choose>
          		<c:when test="${not empty studentAttenRecordPager.content}">
          			<c:forEach items="${studentAttenRecordPager.content}" var="studentAttenRecord">
          				<tr>
			                  <td><fmt:formatDate value="${studentAttenRecord.readcardTime}" pattern="yyyy.MM.dd"/>  </td>
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
	              <td align="center" colspan="3">没有记录！</td>
	             </tr>
          		</c:otherwise>
          	</c:choose>
          	</tbody>
          </table>
	       <t:tpage pageDiv="page" page="${studentAttenRecordPager.page}" goImg="img/learning_img/gog.gif" formId="attenQueryForm"></t:tpage>
        </div>
          </form>
     </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>
