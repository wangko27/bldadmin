<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<%
			String questiontypeid = request.getParameter("questiontypeid");
			if (null == questiontypeid) {
				questiontypeid = "";
			}
			String questionstatus = request.getParameter("questionstatus");
			if (null == questionstatus) {
				questionstatus = "";
			}
			String showtypenum = request.getParameter("showtypenum");
			if (null == showtypenum) {
				showtypenum = "";
			}
			String showstatnum = request.getParameter("showstatnum");
			if (null == showstatnum) {
				showstatnum = "";
			}
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/dayilist.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			//设置查询类别
			function questionType(questiontypeid,showtypenum){
				$("#questiontypeid").val(questiontypeid);
				$("#showtypenum").val(showtypenum);	
				$("#questionlist").submit();				
				return false;
			}			
			//设置当前选中的选项
			function show(index){
				$(".flei_1 ul li").each(function(i){
					if(index==i){
						$(this).addClass("did");
					}else{
						$(this).removeClass("did");
					}
				});
			}
			$().ready(function(){
				show(<%=showtypenum%>);
			});
		</script>	
		<script type="text/javascript">
		//设置查询类别
			function questionstatus(questionstatus,showstatnum){	
				if(questionstatus==null){
					$("#questionstatus").val('');	
				}
				$("#questionstatus").val(questionstatus);
				$("#showstatnum").val(showstatnum);				
				$("#questionlist").submit();
			
				return false;
			}
			
			//设置当前选中的选项
			function showorder(index){
				if(index==null){
				index=0;
				}				
				$(".dda ul li").each(function(i){
					if(index==i){
						$(this).addClass("dibai");
					}else{
						$(this).removeClass("dibai");
					}
				});
			}		
			$().ready(function(){			
				showorder(<%=showstatnum %>);
			});
		
		</script>	
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="<%=basePath%>Article/Show_News_Index.action">资讯</a> > <span>博士小答疑</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
      <div class="titi"><img src="img/news_img/tit_1.gif" /></div>
      <div class="flei_1">
        <ul>
        <s:iterator value="questionTypeList" id="QTrow" status="st" >
          <li class=""><a href="#" onclick="return questionType('${QTrow.questiontypeid}','${st.index }')">${QTrow.questiontypename }</a>(${QTrow.datanum })</li>
		</s:iterator>
        </ul>
      </div>
      <div class="dda">
        <ul><s:iterator>
          <li class="dibai"><a href="#" onclick="return questionstatus('','0')">全部</a></li>
          <li class="dibai"><a href="#" onclick="return questionstatus('0','1')">未解答答疑</a></li>
          <li class="dibai"><a href="#" onclick="return questionstatus('1','2')">已解答</a></li>
          </s:iterator>
        </ul>
      </div>
      <div class="list_2"><span class="ro1">标题</span> <span class="ro2">奖励积分</span> <span class="ro3">回答数</span><span class="ro4">提问时间</span></div>
      <div class="tabxun">
        <table  border="0" cellspacing="0" cellpadding="0" class="kww">
           	<s:if test="result.content.size()==0">
        	<tr>
        		<td>
            	   <center>暂时没有该条件的问题!</center>
            	</td>  
            </tr>
            </s:if>	 
           <c:if test="${not empty result}">    	
	  	<c:forEach items="${result.content}" var="q" varStatus="vs">
	  	<c:if test="${not empty q.question}">
          <tr>
            <td class="k1"><a href="<%=basePath %>Article/getQuestionById.action?id=${q.questionid}" title="${q.question }">${fn:substring(q.question , 0,30)}<s:if test="%{question.length()>30}">...</s:if></a></td>
            <td class="k2"><span>${q.questionpoint}</span></td>
            <td class="k2">${q.answernum}次</td>
            <td class="k3"><fmt:formatDate value="${q.createdate}" pattern="yyyy-MM-dd"/></td>
          </tr>
         </c:if>
      </c:forEach>
      </c:if>
        </table>
      </div>
      	<form action="Article/listQuestion.action" method="post" name="questionlist" id="questionlist">
			<input name="questiontypeid" id="questiontypeid" type="hidden" value="<%=questiontypeid%>"/>
			<input name="questionstatus" id="questionstatus" type="hidden" value="<%=questionstatus%>"/>
			<input name="showstatnum" id="showstatnum" type="hidden" value="<%=showstatnum%>"/>
			<input name="showtypenum" id="showtypenum" type="hidden" value="<%=showtypenum%>"/>
			<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="questionlist"></t:tpage>		 
		</form>
    </div>
      <jsp:include page="news_right.jsp"></jsp:include>
  </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
