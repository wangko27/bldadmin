<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@page import="com.cnarj.ttxs.pojo.info.Question"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
Question question=(Question)request.getAttribute("qt");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="css/news/newsmaid.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			//去掉文章的空格 和 换行
			function trim(str){
    			str=str.replace("<br/>","");
               	str=str.replace("<br>","");
 			    str=str.replace("<p>","");
 			    str=str.replace("</p>","");
 			    str= str.replace(/(^\s*)|(\s*$)/g,"");
 			    return str;
 			 }
			//提交之前的判断
			function fromSubmit(){
				//alert(1);
				var answer=$("textarea:first").val();
				//alert(answer);
			    if(answer=="给出您的答案，如果被提问者选中为最佳答案，可获得他赠与的奖励积分！"){
			    	 var answer = CKEDITOR.instances.answer.getData();
			    }
			   // alert(answer);
			    answer=trim(answer);
			   // alert(answer);
			   if(answer==""||answer=="给出您的答案，如果被提问者选中为最佳答案，可获得他赠与的奖励积分！"){
			   		alert("内容不能为空");
			   }
			   else{
			   	$("#answerform").submit();	
			   } 
			   return false;
			}
			//编辑框无效时
			function showanswernull(){
				var value=$("textarea:first").val();
				if(value=="给出您的答案，如果被提问者选中为最佳答案，可获得他赠与的奖励积分！"){
					$("#remove").html("<textarea cols=\"\" rows=\"\" name=\"as.answer\" id=\"answer\" onfocus=\"showanswernull()\"></textarea>");
				}
			}
			
		</script>
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="<%=basePath%>Article/Show_News_Index.action">资讯</a> > <span>博士答疑</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    	<div class="news_leftmd">
    	
    	 <div class="weirr">
         <ul>
          <li class="yidahh">${qt.question }</li>
          <li class="xiaozi">
            <p class="jj1">奖励积分：<b>${qt.questionpoint }分</b> | </p>
              <p><c:if test="${qt.questionstatus=='0'}">问题将于<fmt:formatDate value="${qt.enddate}" pattern="yyyy-MM-dd kk:mm"/>结束</c:if><c:if test="${qt.questionstatus=='1'}">问题已结束</c:if></p>
            <p class="jj2"> | 提问者：${qt.asker}</p>
          </li>
          <li class="tish"><span class="s1">提问时间：<fmt:formatDate value="${qt.begindate}" pattern="yyyy-MM-dd kk:mm"/></span> <span class="s2">浏览次数：${qt.visittime}次</span></li>
        </ul>
        <p class="buch">${qt.explanation}</p> 
        </div>
    	
    <c:if test="${qt.questionstatus=='1'}">
      <s:if test="bestanswer.size()==0"></s:if>
      	<s:else>
      <div class="jiada">
        <p class="jiap1"><b>最佳答案：</b><br />
         <p><pre style="word-wrap:break-word; ">${bestanswer[0].answer}</pre></p></p>
        <p class="dipu"><span class="jii">奖励积分：${bestanswer[0].question.questionpoint}分</span> <span class="jjrrr">回答者：${bestanswer[0].answerusername}| <fmt:formatDate value="${bestanswer[0].answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></span></p>
      </div>
      </s:else>
	</c:if>
    	
    <c:if test="${qt.questionstatus=='0'}">
      <div class="hui">
        <h1>我来回答：</h1>
	<form action="<%=basePath %>Article/AnswerQuestion.action?id=${qt.questionid}" method="post" id="answerform" name="answerform">
			 <s:token></s:token>
        <ul>
          <li id="remove">
            <textarea cols="" rows="" name="as.answer" id="answer" onfocus="showanswernull()">给出您的答案，如果被提问者选中为最佳答案，可获得他赠与的奖励积分！</textarea>
                                     <script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('as.answer',{
										toolbar :
										[
											['Smiley']
										]
									});
									//]]></script>
          </li>
          <li></li>
        </ul>
      	 <p><a href="#"><img src="img/news_img/tijiao.gif" onclick="return fromSubmit()"/></a></p>
      	 	<jsp:include page="../comm/message.jsp"></jsp:include>  
         </form> 
      </div>
	</c:if>
    	
      <div class="dada">
      <c:if test="${qt.answernum=='0' }">
      	<center><font color="red">该问题暂时没人回答</font></center>
      </c:if>
      	<c:if test="${qt.answernum!='0' }">
         	<c:if test="${qt.questionstatus=='0'}">
         	<h1>回答：<span>(共${qt.answernum }条)</span></h1>
       		 <%
        		if(session.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_NIKENAME)!=null){
        			if(session.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_NIKENAME).equals(question.getAsker())){
        			//问题提交者登陆%>
        			<s:iterator value="answerlist" id="awrow" status="st">
        				<c:if test="${awrow.answerusername=='助教信息员'}">
        				  <div class="ggff">
        				   <a href="<%=basePath %>myspace/comm/mquestionBAnswer.action?answerid=${awrow.answerid}&questionid=${qt.questionid}"><img src="<%=basePath %>img/news_img/da.gif" id="setbestanswer"/></a>
          					<p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre></p>
          					<p class="wewzi"><a><img src="img/news_img/da.gif" /></a>回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
       					 </div>
       					</c:if>
        				  <div class="ggff_1">
        				  <a href="<%=basePath %>myspace/comm/mquestionBAnswer.action?answerid=${awrow.answerid}&questionid=${qt.questionid}"><img src="<%=basePath %>img/news_img/da.gif" id="setbestanswer"/></a>
        				  	 <p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre><br />
        				  	  <p class="wewzi">
           					 回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
        				  </div>
        			</s:iterator>
        			<%
        			 }else{//其他用户
        			 %>
        			 <s:iterator value="answerlist" id="awrow" status="st">
        				<c:if test="${awrow.answerusername=='助教信息员'}">
        				  <div class="ggff">
          					<p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre></p>
          					<p class="wewzi"><a><img src="img/news_img/da.gif" /></a>回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
       					 </div>
       					</c:if>
        				  <div class="ggff_1">
        				  	 <p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre><br />
        				  	 <script type="text/javascript">
						</script>
        				  	  <p class="wewzi">
           					 回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
        				  </div>
        				</s:iterator>
        			 <%
        			 }
        		}
        		else{//无用户登录
			%>
        			<s:iterator value="answerlist" id="awrow" status="st">
        				<c:if test="${awrow.answerusername=='助教信息员'}">
        				  <div class="ggff">
          					<p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre></p>
          					<p class="wewzi"><a><img src="img/news_img/da.gif" /></a>回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
       					 </div>
       					</c:if>
        				  <div class="ggff_1">
        				  	 <p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre><br />
        				  	  <p class="wewzi">
           					 回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
        				  </div>
        			</s:iterator>
        			<%} %>
			</c:if>
			<c:if test="${qt.questionstatus=='1'}">
			  <h1>回答：<span>(共<%=(question.getAnswernum()-1) %>条)</span></h1>
        			<s:iterator value="answerlist" id="awrow" status="st">
        				<c:if test="${awrow.answerusername=='助教信息员'}">
        				  <div class="ggff">
          					<p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre></p>
          					<p class="wewzi"><a><img src="img/news_img/da.gif" /></a>回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
       					 </div>
       					</c:if>
        				  <div class="ggff_1">
        				  	 <p class="wew"><pre style="word-wrap:break-word; ">${awrow.answer} </pre><br />
        				  	  <p class="wewzi">
           					 回答者：${awrow.answerusername} | <fmt:formatDate value="${awrow.answerdate}" pattern="yyyy-MM-dd kk:mm:ss"/></p>
        				  </div>
        			</s:iterator>				
			</c:if>
		</c:if>
     </div>
      <!-- 其他关联信息 -->
	     <div class="qita">
     		<h1>其他疑问：</h1><br />
          <ul>
          <s:iterator  value="questionList" id="row">
            <li><a href="<%=basePath %>Article/getQuestionById.action?id=${row.questionid }">${fn:substring(row.question,0,30) }</a><span class="fen">${row.questionpoint }分</span> <span>${row.begindate}</span></li>
          </s:iterator>
          </ul>
        </div>
      </div>
    </div>
         <jsp:include page="news_right.jsp"></jsp:include>
  </div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
