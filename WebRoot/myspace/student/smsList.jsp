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
				$("#smsQueryForm").attr("action","<%=basePath%>member/smsMsgAction!stuQuery.action");
				$("#smsQueryForm").submit();
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
            <li><a href="member/attenQueryAction!stuAttendancePager.action">考勤查询</a></li>
            <li class="bai"><a href="member/smsMsgAction!stuQuery.action">短信查询</a></li>
            <li><a href="member/courseAction!getCoursesByStu.action">课程表查询</a></li>
          </ul>
        </div>
        <form action="<%=basePath%>member/smsMsgAction!stuQuery.action" method="post" id="smsQueryForm">
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
              <td><input name="smsQueryBtn" id="smsQueryBtn" type="button"  class="cx"/></td>
            </tr>
          </table>
        </div>
      
        <div class="xunc_2">
          <h1><span>查询结果：</span>（${requestScope.startDate} --- ${requestScope.endDate}）您的短信如下  (含作业、个性、成绩等短信)</h1>
          <table width="720" border="0" cellspacing="0" cellpadding="0" >
          	<tr>
              <td class="t1" width="12%">短信类别</td>
              <td class="t1" width="12%">姓    名</td>
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
