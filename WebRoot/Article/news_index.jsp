<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/news/news.css" rel="stylesheet" type="text/css" />
	 <link href="css/news/bb.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="newsbig">
    <div class="leftzuo">
      <div class="huandd">
	        <div id="player">
		<ul class="Limg">
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="news-index-a1" src="" width="300" height="260"/><p>宣传新专辑与徐静蕾合 </p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="news-index-a2" src="" width="300" height="260"/><p>尚雯婕为演唱会携天价古</p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="news-index-a3" src="" width="300" height="260"/><p>爸妈齐助阵周杰伦2010年</p></a></li>
			<li><a href="#" onclick="return false" target="_blank"><img name="advertisement" title="news-index-a4" src="" width="300" height="260"/><p>阿朵唱功遭质疑撩裙露臀</p></a></li>
		</ul>
		<cite class="Nubbt"><span class="on">1</span><span >2</span><span >3</span><span >4</span></cite>
		<script language="javascript" src="<%=basePath%>js/bb.js"></script> 
	</div>
	</div>
      <div class="jiaoyu">
       <!--无值 -->
        <h1><span>教育看点</span><a href="<%=basePath %>Article/getArticleByEducationType.action?id=8a80818c31bb7cc50131bb805c4a0007"><img src="img/home_img/more.gif" /></a></h1>
        <ul>
        <s:iterator value="articleListTypeE" id="Erow">
          <li><a href="<%=basePath %>Article/getArticleById.action?id=${Erow.articlesrcid }" title="${Erow.articletitle }">${fn:substring(Erow.articletitle , 0, 15)}<s:if test="%{articletitle.length()>15}">...</s:if></a></li>
         </s:iterator>
        </ul>
      </div>
    </div>
    <div class="mendzh">
      <div class="tout">
        <h1><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTN[0].articlesrcid }" title="articleListTN[0].articletitle">${articleListTN[0].articletitle }</a></h1>
        <p><span><fmt:formatDate value="${articleListTN[0].createdate}" pattern="MM-dd"/> | </span> ${articleListTN[0].articlesrccontent}<a href="<%=basePath %>Article/getArticleById.action?id=${articleListTN[0].articlesrcid }">[详细]</a></p>
      </div>
      <div class="newsl">
        <ul>
        <s:iterator value="articleListTN" id="TNrow" status="st">
        <s:if test="#st.index!=0">
          <li><a href="<%=basePath %>Article/getArticleById.action?id=${TNrow.articlesrcid }" title="${TNrow.articletitle }">${fn:substring(TNrow.articletitle , 0, 20)}<s:if test="%{articletitle.length()>20}">...</s:if></a><span><fmt:formatDate value="${TNrow.createdate}" pattern="MM-dd"/></span></li>
          </s:if>
          </s:iterator>
        </ul>
      </div>     
      <div class="tit_1">图片新闻</div>
      <div class="tuwen">
        <ul>
	 <s:iterator value="articleListTP" id="TProw" status="st">
         <s:if test="#st.index<3">
         	<s:if test="#st.index==1">
         	 <li class="kuan"><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }"><s:if test="#TProw.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${TProw.coverpath }" /></s:else></a><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }">${fn:substring(TProw.articletitle , 0, 9)}<s:if test="%{articletitle.length()>20}">...</s:if></a></li>
         	</s:if>
         	<s:else>
      	 	 <li><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }"><s:if test="#TProw.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${TProw.coverpath }" /></s:else></a><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }">${fn:substring(TProw.articletitle , 0, 9)}<s:if test="%{articletitle.length()>20}">...</s:if></a></li>
         	</s:else>
      	</s:if>
     </s:iterator>
        </ul>
        <ul>
         <s:iterator value="articleListTP" id="TProw" status="st">
         <s:if test="#st.index>=3">
            <s:if test="#st.index==4">
         	 	<li class="kuan"><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }"><s:if test="#TProw.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${TProw.coverpath }" /></s:else></a><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }">${fn:substring(TProw.articletitle , 0, 9)}<s:if test="%{articletitle.length()>20}">...</s:if></a></li>
         	</s:if>
      	 	<s:else>
      	 	 <li><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }"><s:if test="#TProw.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${TProw.coverpath }" /></s:else></a><a href="<%=basePath %>Article/getArticleById.action?id=${TProw.articlesrcid }" title="${TProw.articletitle }">${fn:substring(TProw.articletitle , 0, 9)}<s:if test="%{articletitle.length()>20}">...</s:if></a></li>
         	</s:else>
         </s:if>
        </s:iterator>
        </ul>
      </div>
    </div>
    <div class="rightyou">
   			<div class="login_1">
				<%
					if (request
							.getSession()
							.getAttribute(
									(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_ID_SESSION_NAME)) == null) {
				%>
       		 <p><a href="#"> <img src="img/news_img/bulee_an.gif" /></a></p>
        <ul>
          <li>登陆后，您可以：</li>
          <li>·&nbsp;与您的朋友进行交流</li>
          <li>·&nbsp;下载资源、博览群书</li>
          <li> ·&nbsp;查看您的积分记录、查询成绩</li>
          <li>&nbsp;</li>
          <li>·&nbsp;解答孩子问题</li>
          <li>·&nbsp;上传您的资源、分享快乐</li>
          <li> ·&nbsp;与您的朋友进行交流</li>
        </ul>
				<%
					} else {
				%>
				<table width="80%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<div class="ru1">
								<%
									if(session.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_HEADPATH)==null){
									
								 %>
								 <img src="img/user_img/imgmo.gif" />
								 <%
								 }else{
								  %>
								<img
									src="<%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_HEADPATH)%>" />
								<%} %>	
								<p>
									<b><%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_NIKENAME)%></b>
									<%
										Object type = session
													.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_TYPE);
											if ("1".equals(type.toString())) {
									%>同学
									<%
										} else if ("2".equals(type.toString())) {
									%>家长
									<%
										} else if ("3".equals(type.toString())) {
									%>教师
									<%
										}
									%>，欢迎您登录952116综合信息门户网综合门户网站。
									<br />
									当前积分：
									<span><%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_POINT)%></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="green">
										&nbsp;&nbsp;
										<img src="img/learning_img/d_03.gif" width="3" height="3" />
										&nbsp;&nbsp;
										<a href="member/myinformation!myInfo.action">我的资料</a>
									</td>
									<td class="green">
										&nbsp;&nbsp;
										<img src="img/learning_img/d_03.gif" width="3" height="3" />
										&nbsp;&nbsp;
										<a href="myspace/updatepwd.jsp">修改密码</a>
									</td>
								</tr>
								<tr>
									<td class="green">
										&nbsp;&nbsp;
										<img src="img/learning_img/d_03.gif" width="3" height="3" />
										&nbsp;&nbsp;
										<a href="myspace/comm/uploadSrcGo.action">上传资源</a>
									</td>
									<td class="green">
										&nbsp;&nbsp;
										<img src="img/learning_img/d_03.gif" width="3" height="3" />
										&nbsp;&nbsp;
										<a href="loginout.action">用户退出</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>
					<tr>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="45">
										<img src="img/learning_img/bz.gif" width="34" height="17" />
									</td>
									<td align="left" class="hui">
										<a href="#">什么是数字化校园？</a>
									</td>
								</tr>
								<tr>
									<td>
										<img src="img/learning_img/cx.gif" alt="" width="34"
											height="16" />
									</td>
									<td align="left" class="hui">
										<a href="#">如何查询成绩？</a>
									</td>
								</tr>
								<tr>
									<td>
										<img src="img/learning_img/jl.gif" alt="" width="34"
											height="17" />
									</td>
									<td align="left" class="hui">
										<a href="#">与您的朋友进行交流</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<%
					}
				%>
			</div>
      <div class="ggao">
        <p><span>系统公告</span></p>
        <div class="newsl2">
          <ul>
          <s:iterator value="articleListNT" id="NTrow">        
            <li><a href="<%=basePath %>Article/viewSysById.action?id=${NTrow.articleid }" title="${NTrow.articletitle }">${fn:substring(NTrow.articletitle , 0, 13)}<s:if test="%{articletitle.length()>13}">...</s:if></a></li>
          </s:iterator>
          </ul>
        </div>
      </div>
      <div class="banner1"><a href="#" onclick="return false"><img name="advertisement" title="information-b" src="" /></a></div>
    </div>
  </div>
</div>
<div class="mainbody">
  <div class="banner2"><a href="#" onclick="return false"><img name="advertisement" title="information-c" src="" /></a></div>
</div>
	<div class="mainbody">
  
<div class="mainbody">
  <div class="newsbig_1">
    <div class="bla_1">
      <p><a href="<%=basePath %>Article/listQuestion.action?id=8a80818c31b21f9c0131b2206ced0001&&showtypenum=0">升学入学</a> - <a href="<%=basePath %>Article/listQuestion.action?id=8a80818c31b21f9c0131b2206ced0002&&showtypenum=1">院校信息</a> - <a href="<%=basePath %>Article/listQuestion.action?id=8a80818c31b21f9c0131b2206ced0003&&showtypenum=2">学习教育</a> - <a href="<%=basePath %>Article/listQuestion.action?id=8a80818c31b21f9c0131b2206ced0004&&showtypenum=3">成长问题</a> - <a href="<%=basePath %>Article/listQuestion.action?questiontypeid=8a80818c31b21f9c0131b2206ced0005&&showtypenum=4">理工学科</a> - <a href="<%=basePath %>Article/listQuestion.action?questiontypeid=8a80818c31b21f9c0131b2206ced0006&&showtypenum=5">其他问题</a></p>
      <p class="more"><a href="<%=basePath %>Article/listQuestion.action"><img src="img/home_img/more.gif" /></a></p>
    </div>
    <div class="answow">
      <div class="answ1">
        <div class="wen1">
          <ul>
            <li class="diwen"><span>最新问答：</span>${ answerlist[0].question.question}</li>
            <li class="xiaozi">悬赏积分：<span>${ answerlist[0].question.questionpoint}</span>分 | 提问者：${ answerlist[0].question.asker}| 提问时间：<fmt:formatDate value="${ answerlist[0].question.begindate}" pattern="yyyy-MM-dd kk:mm"/> </li>
            <li class="hui"> <b>最新回答：</b>
              <p>${fn:substring(answerlist[0].answer , 0, 40)}<s:if test="%{articletitle.length()>40}">...</s:if><a href="<%=basePath %>Article/getQuestionById.action?id=${ answerlist[0].question.questionid}">[查看详情]</a></p>
              <p><a href="<%=basePath %>Article/getQuestionById.action?id=${ answerlist[0].question.questionid}"><img src="img/news_img/hui.gif" /></a></p>
            </li>
          </ul>
        </div>
        <div class="wen2">
          <ul>
          <c:forEach items="${ListtopQuestion}" var="rowtop" varStatus="st">
          	<c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0001'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=0">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
          	<c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0002'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=1">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
          	 <c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0003'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=2">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
          	 <c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0004'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=3">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
          	 <c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0005'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=4">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
          	 <c:if test="${rowtop.questionType.questiontypeid=='8a80818c31b21f9c0131b2206ced0006'}">
          		 <li>          
               		<p class="p1"><a href="<%=basePath %>Article/listQuestion.action?questiontypeid=${rowtop.questionType.questiontypeid}&&showtypenum=5">[${rowtop.questionType.questiontypename}]</a></p>
                	<p class="p2"><a href="<%=basePath %>Article/getQuestionById.action?id=${questionid}">${rowtop.question }</a> <span>${rowtop.questionpoint }分</span></p>
          		</li>
          	</c:if>
            </c:forEach> 
          </ul>
        </div>
      </div>
      <div class="answ2">
        <p>热门答疑&nbsp;&nbsp;<span>HOT</span> </p>
        <div class="liebb">
          <ul>   
			<s:iterator id="Hotrow" value="ListHotQuestion">				
			<li>
            <p> <a href="<%=basePath %>Article/getQuestionById.action?id=${questionid }" title="${Hotrow.question }">${fn:substring(Hotrow.question , 0, 15)}<s:if test="%{question.length()>15}">...</s:if></a></p>
              <span>${Hotrow.answernum }回答</span></li>
			 </s:iterator>
          </ul>
        </div>
        <div class="banner3"><a href="#" onclick="return false"><img name="advertisement" title="information-d" src="" /></a></div>
      </div>
    </div>
  </div>
</div>

<div class="mainbody">
  <div class="newsbig_2">
    <div class="bla_1">
 <p><a href="<%=basePath %>Article/list.action?id=8a80818c31b6a6270131b6a808e90001&shownum=1">成长教育</a> - <a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb8029c00005&shownum=3">好好生活</a> - <a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb8014a20004&shownum=2">心理健康</a> - <a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb80468f0006&shownum=4">营养保健</a> </p>
      <p class="more"><a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002"><img src="img/home_img/more.gif" /></a></p>
    </div>
    
    
    <div class="baike">
      <div class="baike1">
        <div class="bkleft">
          <h1><span>营养保健</span><a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb80468f0006&shownum=4">更多</a></h1>
          <ul class="tuzi">
            <li class="tut"><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeN[0].articlesrcid }" title="${articleListTypeN[0].articletitle }"><s:if test="#articleListTypeN[0].coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="${articleListTypeN[0].coverpath }" /></s:else></a></li>
            <li class="ziz"> <b><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeN[0].articlesrcid }" title="${articleListTypeN[0].articletitle }">${fn:substring(articleListTypeN[0].articletitle , 0, 15)}<s:if test="%{articletitle.length()>15}">...</s:if></a></b>
              <p>${fn:substring(articleListTypeN[0].articlesrccontent , 0, 15)}<s:if test="%{articlesrccontent.length()>15}">...</s:if><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeN[0].articlesrcid }" title="${articleListTypeN[0].articletitle }">[详情]</a></p>
            </li>
          </ul>
          <ul class="wenzi">
          	<s:iterator value="articleListTypeN" id="Nrow" status="st">
          	 <s:if test="#st.index!=0">
            <li><a href="<%=basePath %>Article/getArticleById.action?id=${Nrow.articlesrcid }" title="${Nrow.articletitle }">${fn:substring(Nrow.articletitle , 0, 20)}<s:if test="%{articletitle.length()>20}">...</s:if></a> </li>
            </s:if>
            </s:iterator>
          </ul>
        </div>
        
        
        <div class="bkleft">
          <h1><span>好好生活</span> <a href="<%=basePath %>Article/list.action?id=8a80818c31bb7cc50131bb8029c00005&shownum=3">更多</a></h1>
          <ul class="tuzi">
                       <li class="tut"><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeL[0].articlesrcid }" title="${articleListTypeL[0].articletitle }"><s:if test="#articleListTypeL[0].coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="${articleListTypeL[0].coverpath }" /></s:else></a></li>
                        <li class="ziz"> <b><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeL[0].articlesrcid }" title="${articleListTypeL[0].articletitle }">${fn:substring(articleListTypeL[0].articletitle , 0, 15)}<s:if test="%{articletitle.length()>15}">...</s:if></a></b>
              <p>${fn:substring(articleListTypeL[0].articlesrccontent , 0, 15)}<s:if test="%{articlesrccontent.length()>15}">...</s:if><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTypeL[0].articlesrcid }" title="${articleListTypeL[0].articletitle }">[详情]</a></p>
            </li>
          </ul>
          <ul class="wenzi">
            <s:iterator value="articleListTypeL" id="Lrow" status="st">
             <s:if test="#st.index!=0">
            <li><a href="<%=basePath %>Article/getArticleById.action?id=${Lrow.articlesrcid }" title="${Lrow.articletitle }">${fn:substring(Lrow.articletitle , 0, 17)}<s:if test="%{articletitle.length()>20}">...</s:if></a></li>
            </s:if>
            </s:iterator>
          </ul>
        </div>
      </div>
      <div class="baike2">
        <div class="tout2">
          <h1><a href="<%=basePath %>Article/getArticleById.action?id=${articleListNN[0].articlesrcid }">${articleListNN[0].articletitle }</a></h1>
          <p><span><fmt:formatDate value="${articleListNN[0].createdate}" pattern="MM-dd"/>| </span> ${articleListNN[0].articlesrccontent}<a href="<%=basePath %>Article/getArticleById.action?id=${articleListNN[0].articlesrcid }">[详细]</a></p>
        </div>
        <div class="news2">
          <ul>
          <s:iterator value="articleListNN" id="NNrow" status="st">
          	 <s:if test="#st.index!=0">
            <li>
              <p class="p1"><a href="#">[${NNrow.articleType.articletypename }]</a></p>
              <p class="p2"><a href="<%=basePath %>Article/getArticleById.action?id=${articlesrcid }" title="${NNrow.articletitle }">${fn:substring(NNrow.articletitle , 0,15)}</a> <span><fmt:formatDate value="${NNrow.createdate}" pattern="MM-dd"/></span></p>
            </li>
            </s:if>
           </s:iterator>
          </ul>
        </div>
      </div>
      
      <div class="baike3">
      	<div class="baiansw">
          <p>成长教育</p>
          <div class="baitu">
          <s:iterator value="articleListTypeG" id="Grow" status="st">
          	<s:if test="#st.index<3">
          	<a href="<%=basePath %>Article/getArticleById.action?id=${Grow.articlesrcid }" title="${Grow.articletitle }">
            	<s:if test="#Grow.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="${Grow.coverpath }" /></s:else>
            	<br />
				${fn:substring(Grow.articletitle , 0, 10)}
			</a>
			</s:if>
            </s:iterator>
          </div>
          <div class="bailiebb">
            <ul>
             <s:iterator value="articleListTypeG" id="Grow"  status="st">
             	<s:if test="#st.index>=3">
              	<li><a href="<%=basePath %>Article/getArticleById.action?id=${Grow.articlesrcid }" title="${Grow.articletitle }">${fn:substring(Grow.articletitle , 0, 25)}</a> </li>
              	</s:if>
              </s:iterator>
            </ul>
          </div>
        </div>
        <div class="baiansw">
          <p>心理健康</p>
          <div class="bailiebb">
            <ul>
            	<s:iterator value="articleListTypeP" id="Prow" status="st">
           		 <li><a href="<%=basePath %>Article/getArticleById.action?id=${Prow.articlesrcid }" title="${Prow.articletitle }">${fn:substring(Prow.articletitle , 0, 25)}</a></li>
            </s:iterator>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div> 
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
