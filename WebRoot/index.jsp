<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/comm/common_tag.jsp"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

			String shownum = request.getParameter("shownum");
			if (null == shownum) {
				shownum = "";
			}
			String subject = request.getParameter("subject");
			if (null == subject) {
				subject = "";
			}
			String gradeCode = request.getParameter("gradeCode");
			if (null == gradeCode) {
				gradeCode = "";
			}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    <base target="_blank"/>
    <title>您好，欢迎来到952116综合信息门户网！</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="comm/include.jsp"></jsp:include>
	<link href="<%=basePath%>comm/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/index.css" rel="stylesheet" type="text/css" />
	 <link href="css/index/bb.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/memberLogin.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/indexjs/index.js"></script>	
	<script type="text/javascript" src="<%=basePath%>js/indexjs/google.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>	
  </head>
  <body>
  <jsp:include page="/base/top.jsp"></jsp:include>
<div class="mainbody" >
  <div class="logo">
  	<a href="#"><img src="<%=basePath%>img/home_img/logo.gif" /></a>
  </div>
  <div class="seach">
  
 <p>热门搜索：<a href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a> <a href="learn/readbook!list.action?liindex=5">书籍资源</a>  <a href="learn/schools_showSchools.action?liindex=4">名校风采</a> <a href="activity_showActions.action?proID=8a8081b121bd7ec20131bd7f78e50001">拍拍乐</a></p>
   <p class="ss">
	   <input name="q" type="hidden" /> 
	　　<input name="qfront" type="text" class="shu" /> 
		<input type="submit" class="an" value="" />
    </p>
    <!-- 
    <form action="http://www.Google.com/search" method="get" onSubmit="Gsitesearch(this)">
    <p class="ss">
	   <input name="q" type="hidden" /> 
	　　<input name="qfront" type="text" class="shu" /> 
		<input type="submit" class="an" value=""/>
    </p>
     </form> -->
  </div>
</div>
<div class="mainbody" >
  <div class="menu" >
    <div class="ul1" >
     <div class="zl"><a href="learn/xx_index.action?liindex=0"><img src="img/home_img/index_6_03.gif" width="25" height="45" /></a></div>
      <ul class="h1" >
      <li><a href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a></li>
      <li><a href="learn/pinxue_showPinXue.action?liindex=2">品学论道</a></li>
      <li><a href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a></li>
      <li><a href="learn/readbook!list.action?liindex=5">博览群书</a> </li>
      </ul>
    </div>
    <div class="ul2">
     <div class="zl2"><a href="index_interest.jsp"><img src="img/home_img/index_6_04.gif" width="25" height="45" /></a></div>
      <ul class="h2">
      <li><a href="index_interest.jsp">拍拍乐</a></li>
      <li><a href="index_interest.jsp">航模组</a></li>
      <li><a href="index_interest.jsp">英语角</a></li>
      <li><a href="index_interest.jsp">计算机</a></li>
      <li><a href="index_interest.jsp">绘画班</a></li>
      <li><a href="index_interest.jsp">爱探索</a> </li>
      </ul>
    </div>
    <!-- 
    
    <div class="ul2">
     <div class="zl2"><a href="interest/XQ_index.action"><img src="img/home_img/index_6_04.gif" width="25" height="45" /></a></div>
      <ul class="h2">
      <li><a href="interest/activity_showActions.action?proID=8a8081b121bd7ec20131bd7f78e50001">拍拍乐</a></li>
      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5f7f6000a">航模组</a></li>
      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5b9760008">英语角</a></li>
      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf564220006">计算机</a></li>
      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf50ad70004">绘画班</a></li>
      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf1ce780002">爱探索</a> </li>
      </ul>
    </div>
     -->
     <div class="ul1">
     <div class="zl3"><a href="Article/Show_News_Index.action"><img src="img/home_img/index_6_05.gif" width="25" height="45" /></a></div>
      <ul class="h1">
      <li><a href="Article/getArticleByEducationType.action?id=8a80818c31bb7cc50131bb805c4a0007">教育看点</a></li>
      <li><a href="Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002">生活百科</a></li>
      <li><a href="Article/listNews.action">今日新闻</a> </li>
      <li><a href="Article/listQuestion.action?id=">答疑小博士 </a></li>
      </ul>
    </div>
    <div class="ul2">
     <div class="zl4"><a href="shopping/shoppingIndex_showIndex.action?t="><img src="img/home_img/index_6_06.gif" width="25" height="45" /></a></div>
      <ul class="h2">
    <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324cdbcc01324ce76e100001&t=1&byTopicId=">航模配件</a></li>
      <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d2c4e440002&t=1&byTopicId=">工具书</a></li>
      <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324cdbcc01324ce84b700004&t=1&byTopicId=">科普读物</a></li>
      <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324c3b0e01324c3d9a2c0001&t=1&byTopicId=">教育电子 </a></li>
      <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d2d68010003&t=1&byTopicId=">学习用品</a></li>
      <li><a href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d24b5030001&t=1&byTopicId=">资源库题 </a></li>
      </ul>
    </div>
    <div class="ul3">
     <div class="zl5"><a href="openzone/zoneIndexAction!userCenterIndex.action"><img src="img/home_img/index_6_07.gif" width="25" height="45" /></a></div>
      <ul class="h3">
      <li><a href="openzone/zoneIndexAction!userCenterIndex.action">我的空间</a></li>
      <li><a href="member/examQueryAction!stuExamList.action">我的查询</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="mainbody" >
  <div class="left">
    <div class="slide">
        <div id="player">
		<ul class="Limg">
			<li><img name="advertisement" title="index-a1" src="" width="300" height="290"/><p>宣传新专辑与徐静蕾合 </p></li>
			<li><img name="advertisement" title="index-a2" src="" width="300" height="290"/><p>尚雯婕为演唱会携天价古</p></li>
			<li><img name="advertisement" title="index-a3" src="" width="300" height="290"/><p>爸妈齐助阵周杰伦2010年</p></li>
			<li><img name="advertisement" title="index-a4" src="" width="300" height="290"/><p>阿朵唱功遭质疑撩裙露臀</p></li>
		</ul>
		<cite class="Nubbt"><span class="on">1</span><span >2</span><span >3</span><span >4</span></cite>
		<script language="javascript" src="<%=basePath%>js/bb.js"></script> 
	</div>
	</div>
    <div class="aday">
     <dl class="tit">
        <dt>一天一课</dt>
        <dd><a href="<%=basePath%>learn/oneday_showOneDayOneText.action?liindex=1" >
      <fmt:formatDate value="${nowdate}" pattern="MM月dd日"/></a></dd>
      </dl> 
      <div  class="qie_1">
        <ul class="nji">
          <li id="">
          	<c:choose>
				<c:when test="${empty list_gradeCode}">
					暂无类别
				</c:when>
				<c:otherwise>
					<c:forEach items="${list_gradeCode}" var="g" varStatus="vs" >
						<a name="gradeCode" id="g${vs.index+1 }" onclick="return changedailyReads('${g.gradecode}','')" class="din">${g.gradename}</a>
					</c:forEach>
				</c:otherwise>
			</c:choose>	
			</li>
        </ul>
        <ul class="qiean">
          <li><a onClick="showgalast()" ><img src="<%=basePath%>img/home_img/an_1.gif" /></a><a onClick="showganext()"><img src="<%=basePath%>img/home_img/an_2.gif" /></a></li>
        </ul>
      </div>
     <div id="changedailyReads">
      <div  class="qie_2">
 		 <ul class="kemu">
          <c:choose>
          	<c:when test="${empty list_subject}">
          		暂无数据
          	</c:when>
          	<c:otherwise>
          		<c:forEach items="${list_subject}" var="sub" varStatus="vs">
          		<li id="li${vs.index+1 }" name="subject">
          		<a onclick="return changedailyReads('','${sub.subjectcode }')" class="din_1" id="a${vs.index+1 }">${ sub.subjectname}</a></li>
          		<li id="lis${vs.index+1 }">|</li>
          		</c:forEach>
          	</c:otherwise>
          </c:choose>
        </ul>
        <ul class="qiean_1">
          <li><a onClick="showsblast()"><img src="img/home_img/an_3.gif" /></a><a onClick="showsbnext()"><img src="img/home_img/an_4.gif" /></a></li>
        </ul>
      </div>
      
      	<div  class="nwen">
        <h1><a href="<%=basePath%>learn/oneday_showOneDayInfo.action?liindex=1&readId=${list_oneday_new[0].readsrcid }" title="${list_oneday_new[0].readsrctile }">${fn:substring(list_oneday_new[0].readsrctile , 0,15)}</a></h1>
        <c:if test="${not empty list_oneday_new[0].contentintro}"><p>${fn:substring(list_oneday_new[0].contentintro , 0,60)}</p></c:if>
      	</div>
      	
      	
      	<div class="nlie">
       	 <ul>
       	 <c:forEach items="${list_oneday_new}" var="oneday" varStatus="vs">
        		<c:if test="${vs.index!=0}">
      	 	 	<li><a href="<%=basePath%>learn/oneday_showOneDayInfo.action?liindex=1&readId=${oneday.readsrcid }">${fn:substring(oneday.readsrctile , 0,15)}</a><span><fmt:formatDate value="${oneday.modifydate}" pattern="MM-dd"/></span></li>
      	  		</c:if>
      		</c:forEach>
       	 </ul>
       </div>
      </div>
    </div>
  </div>
  <div class="middle">
    <div class="tout">
      <h1><a href="<%=basePath %>Article/getArticleById.action?id=${articleListTN[0].articlesrcid }" title="${articleListTN[0].articletitle }">${fn:substring(articleListTN[0].articletitle,0,20) }</a></h1>
      <p><span><fmt:formatDate value="${articleListTN[0].createdate}" pattern="MM-dd"/>| </span> ${articleListTN[0].articlesrccontent }<a href="<%=basePath %>Article/getArticleById.action?id=${articleListTN[0].articlesrcid }">[详细]</a></p>
    </div>
    <div class="newsl">
      <ul>
        <s:iterator value="#request.articleListTN" id="TNrow" status="st">
        <s:if test="#st.index!=0">
          <li><a href="<%=basePath %>Article/getArticleById.action?id=${TNrow.articlesrcid }" title="${TNrow.articletitle }">${fn:substring(TNrow.articletitle , 0, 20)}<s:if test="%{articletitle.length()>20}">...</s:if></a><span><fmt:formatDate value="${TNrow.createdate}" pattern="MM-dd"/></span></li>
          </s:if>
          </s:iterator>
      </ul>
    </div>
    <div class="tit_1"> 热门精彩活动 </div>
    <div class="imgzi">
      <ul>
        <li class="jich"> <a href="index_interest.jsp"><c:if test="${not empty hotactivity[0].activitysrc}"><img src="<%=basePath%>${hotactivity[0].activitysrc }" /></c:if><c:if test="${empty hotactivity[0].activitysrc}"></c:if></a>
          <p class="hot"><img src="<%=basePath%>img/home_img/hot.gif" /></p>
        </li>
        <li class="bti"><a href="index_interest.jsp"><c:if test="${not empty hotactivity}">${fn:substring(hotactivity[0].activitytitle , 0,15)}</c:if></a></li>
        <li class="zi">${hotactivity[0].activityintro }<a href="index_interest.jsp">[详细]
        </a></li>
      </ul>
    </div>
    <div class="newsl">
      <ul>
      <c:forEach items="${hotactivity}" var="hotactivity" varStatus="vs">
		<c:if test="${vs.index!=0}">
			 <li><a href="index_interest.jsp"><c:if test="${not empty hotactivity.programa.proName}"><span>[${hotactivity.programa.proName}]</span></c:if> &nbsp; ${fn:substring(hotactivity.activitytitle , 0,25)}</a> <span><fmt:formatDate value="${hotactivity.begindate}" pattern="MM-dd"/></span></li>
		</c:if>      
      </c:forEach>
      </ul>
    </div>
  </div>
  <div class="right">
    <div class="wai"><a>汽车违章</a><a href="http://flight.952116.com/flight/FlightSearch.asp">机票订购</a><a>职介通</a></div>
    				<%
					if (request
							.getSession()
							.getAttribute(
									(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_ID_SESSION_NAME)) == null) {
				%>
    <form action="" method="post" id="memberLoginForm" name="memberLoginForm">
    <input type="hidden" id="basePath" value="<%=basePath%>" />
    <div class="logintt">用户登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="login/register.jsp">免费注册</a></div>
    <div class="loginkk">
      <div class="jiaose">
        <ul>
          <li class="din_2">学生</li>
          <li>家长</li>
          <li>老师</li>
          <li>普通</li>
        </ul>
      </div>
      <div class="tab_box">
      <div id="studentDiv" >
	      <div class="shukk">
	        <ul>
	          <li class="tu"><img src="<%=basePath%>img/user_img/user_xs.jpg" />
	            <p>学生</p>
	          </li>
	          <li>
	            <input type="text" id="stuUsername" name="stuUsername" value="校徽卡号" onFocus="javascript:this.value=''" style="height: 24px" class="formText" />
	          </li>
	          <li>
	            <input name="stuPassword" id="stuPassword" type="password" value="密码" onFocus="javascript:this.value=''" style=" height: 24px" class="formText"/>
	          </li>
	          <li >
	            <input name="stuValidate" id="stuValidate" type="text" value="输入验证码"  style="width: 70px;margin-right:10px; height: 24px" onFocus="javascript:this.value=''" class="formTextSShort" />
	            <img src="validatecode" id="stuLoginValidateImage" alt="点击图片更换验证码" onMouseOver="javascript:this.style.cursor='hand'" onClick="javascript:this.src = 'validatecode?now='+new Date()" />
	          </li>
	        </ul>
	      </div>
	      <div class="ddll">
	        <ul>
	          <li class="wj"><a href="#">忘记密码</a> </li>
	          <li>
	            <input type="checkbox"  />
	          </li>
	          <li><a href="#">记住密码</a></li>
	          <li class="dlu"><img src="<%=basePath%>img/home_img/dlu.jpg"  id="imgStuLoginSubmit"  onmouseover="javascript:this.style.cursor='hand'"/> </li>
	        </ul>
	      </div>
      </div>
      <div id="parentDiv" style="display: none">
	      <div class="shukk">
	        <ul>
	          <li class="tu"><img src="<%=basePath%>img/user_img/user_jz.jpg" />
	            <p>家长</p>
	          </li>
	          <li>
	            <input type="text" id="parentUsername" name="parentUsername" value="手机号码" onFocus="javascript:this.value=''" style="height: 24px" class="formText"/>
	          </li>
	          <li>
	            <input name="parentPassword" id="parentPassword" type="password" value="密码" onFocus="javascript:this.value=''" style=" height: 24px" class="formText"/>
	          </li>
	          <li>
	            <input name="parentValidate" id="parentValidate" type="text" value="输入验证码" style="width: 70px;margin-right:10px; height: 24px" onFocus="javascript:this.value=''" class="formTextSShort"/>
	             <img src="validatecode" id="parLoginValidateImage" alt="点击图片更换验证码" onMouseOver="javascript:this.style.cursor='hand'" onClick="javascript:this.src = 'validatecode?now='+new Date()" />
	            </li>
	        </ul>
	      </div>
	      <div class="ddll">
	        <ul>
	          <li class="wj"><a href="#">忘记密码</a> </li>
	          <li>
	            <input type="checkbox"  />
	          </li>
	          <li><a href="#">记住密码</a></li>
	          <li class="dlu"><a href="#"><img src="<%=basePath%>img/home_img/dlu.jpg"  id="imgParLoginSubmit" /></a></li>
	        </ul>
	      </div>
      </div>
      <div id="teacherDiv"  style="display: none">
	      <div class="shukk">
	        <ul>
	          <li class="tu"><img src="<%=basePath%>img/user_img/user_ls.jpg" />
	            <p>老师</p>
	          </li>
	          <li>
	            <input type="text" id="teacherUsername" name="teacherUsername" value="手机号码" onFocus="javascript:this.value=''" style="height: 24px" class="formText" />
	          </li>
	          <li>
	            <input name="teacherPassword" id="teacherPassword" type="password"  value="密码" onFocus="javascript:this.value=''" style=" height: 24px" class="formText"/>
	          </li>
	          <li>
	            <input name="teacherValidate" id="teacherValidate" type="text" value="输入验证码" style="width: 70px;margin-right:10px; height: 24px" onFocus="javascript:this.value=''" class="formTextSShort"/>
	           	<img src="validatecode" id="teaLoginValidateImage" alt="点击图片更换验证码" onMouseOver="javascript:this.style.cursor='hand'" onClick="javascript:this.src = 'validatecode?now='+new Date()" />
	          </li>
	        </ul>
	      </div>
	      <div class="ddll">
	        <ul>
	          <li class="wj"><a href="#">忘记密码</a> </li>
	          <li>
	            <input type="checkbox" />
	          </li>
	          <li><a href="#">记住密码</a></li>
	          <li class="dlu"><a href="#"><img src="<%=basePath%>img/home_img/dlu.jpg" id="imgTeaLoginSubmit" /></a></li>
	        </ul>
	      </div>
      </div>
      <div id="touristDiv" style="display: none">
	      <div class="shukk">
	        <ul>
	          <li class="tu"><img src="<%=basePath%>img/user_img/user_yk.jpg" />
	            <p>普通</p>
	          </li>
	          <li>
	            <input name="touristUsername" id="touristUsername" type="text" value="注册账号" onFocus="javascript:this.value=''" style="height: 24px" class="formText"  />
	          </li>
	          <li>
	            <input name="touristPassword" id="touristPassword" type="password" value="密码" onFocus="javascript:this.value=''" style=" height: 24px" class="formText"/>
	          </li>
	          <li>
	            <input name="touristValidate" id="touristValidate" type="text" value="输入验证码" style="width: 70px;margin-right:10px; height: 24px" onFocus="javascript:this.value=''" class="formTextSShort"/>
	            <img src="validatecode" id="touLoginValidateImage" alt="点击图片更换验证码" onMouseOver="javascript:this.style.cursor='hand'" onClick="javascript:this.src = 'validatecode?now='+new Date()" />
			  </li>
	        </ul>
	      </div>
	      <div class="ddll">
	        <ul>
	          <li class="wj"><a href="#">忘记密码</a> </li>
	          <li>
	            <input type="checkbox" checked="checked" />
	          </li>
	          <li><a href="#">记住密码</a></li>
	          <li class="dlu"><a href="#"><img src="<%=basePath%>img/home_img/dlu.jpg"  id="imgTouLoginSubmit"/></a></li>
	        </ul>
	      </div>
      </div>
 	  </div>
  </div>
    </form>
    			<%
					} else {
				%>
				 <div class="logintt">用户登录</div>
				   <div class="loginkk">
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
									%>，欢迎您登录952116综合门户信息网站。
									<br />
									 您当前积分：
									<span>
									 <%if(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_POINT==null){
									  %>
									  0<%}else{
									   %>
									<%=session
										.getAttribute(com.cnarj.ttxs.pojo.user.Member.LOGIN_MEMBER_POINT)%><%}%></span>
								</p>
							</div>
						</td>
					</tr>
					 <tr>
        				<td height="20"><img src="img/home_img/index_6.gif"/></td>
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
				</table>
				</div>
				<%
					}
				%>
    <div class="banner1"><a href="#" onclick="return false"><img name="advertisement" title="index-b" src="" /></a></div>
    <div class="ggao">
      <p>系统公告</p>
      <div class="newsl2">
        <ul>
        <c:choose>
        	<c:when test="${empty articleListNT}">暂时没有数据</c:when>
        	<c:otherwise>
        	<c:forEach items="${articleListNT}" var="NTrow" varStatus="st">    
            <li><a href="<%=basePath %>Article/viewSysById.action?id=${NTrow.articleid }" title="${NTrow.articletitle }">${fn:substring(NTrow.articletitle , 0, 15)}<s:if test="%{articletitle.length()>15}">...</s:if></a></li>
        	</c:forEach>  
        	</c:otherwise>
        </c:choose>
        </ul>
      </div>
    </div>
    <div class="banner2"><a href="#" onclick="return false"><img name="advertisement" title="index-c" src="" /></a></div>
  </div>
</div>
<div class="mainbody">
  <div class="banner3"><a href="#" onclick="return false"><img name="advertisement" title="index-d" src="" /></a></div>
</div>
<div class="mainbody">
  <div class="learning">
		    <P>
		    <a href="<%=basePath %>learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a> - 
		    <a href="<%=basePath %>learn/pinxue_showPinXue.action?liindex=2">品学论道</a> - 
		    <a href="<%=basePath %>learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a> -
		    <a href="<%=basePath %>learn/readbook!list.action?liindex=5">博览群书</a>  
		    </P>
    <form action="learn/oneday_showOneDayOneText.action" name="form_readbook" id="form_readbook" method="post">
    	<input type="hidden" name="liindex" id="liindex" value="1" />
    	<input type="hidden" name="gradename" id="gradename" value="全部" />
		<input type="hidden" name="subjectname" id="subjectname" value="全部" />
    <ul>
      <li>一天一课查询：</li>
      <li>
       <select name="gradecode" id="gradecode" onChange="javascript:$('#gradename').val($('#gradecode option:selected').text())">
        <option value="">年级</option>
        <s:iterator value="#request.list_gradeCode" var="grade" status="vs">
         <option value="${grade.gradecode }">${grade.gradename }</option>
        </s:iterator>
        </select>
      </li>
      <li>
        <select name="subjectcode" id="subjectcode" onChange="javascript:$('#subjectname').val($('#subjectcode option:selected').text())">
        	<option value="">科目</option>
        <c:forEach items="${suball}" var="subject" varStatus="vs">
         <option value="${subject.subjectcode }">${subject.subjectname }</option>
        </c:forEach>
        </select>
      </li>
      <li><a href="#" onClick="javascript:form_readbook.submit();return false;"><img src="<%=basePath%>img/home_img/zz.gif" /></a></li>
    </ul>
    </form>
  </div>
  <div class="learning_di">
    <div class="left_1">
    <c:choose>
    	<c:when test="${empty listnewread}">暂无数据</c:when>
    	<c:otherwise>
    	 <div class="book">
        <p><a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[0].readsrcid }&liindex=5"><s:if test="#request.listnewread[0].photopath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${listnewread[0].photopath }" /></s:else></a></p>
        <ul>
          <li class="bookt"><a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[0].readsrcid }&liindex=5" title="${listnewread[0].readsrctile }">[最新]${fn:substring(listnewread[0].readsrctile  , 0,13)} </a></li>
          <li class="bookzi">${listnewread[0].contentintro}<a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[0].readsrcid }&liindex=5">[详情]</a></li>
        </ul>
      </div>
      <div class="book">
        <p><a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[1].readsrcid }&liindex=5"><s:if test="#request.listnewread[0].photopath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath %>${listnewread[1].photopath }" /></s:else></a></p>
        <ul>
          <li class="bookt"><a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[1].readsrcid }&liindex=5" title="${listnewread[1].readsrctile }">[最新]${fn:substring(listnewread[1].readsrctile, 0,8)}</a></li>
          <li class="bookzi">${listnewread[1].contentintro}<a href="<%=basePath %>learn/readbook!view.action?readsrcid=${listnewread[1].readsrcid }&liindex=5">[详情]</a></li>
        </ul>
      </div>
      <div class="book_1">
        <ul>
       <s:iterator value="#request.listnewread" var="read" status="st">
        	<s:if test="#st.index>=2">
          	<li title="${read.readsrctile }"><a href="<%=basePath %>learn/readbook!view.action?readsrcid=${read.readsrcid }&liindex=5">《${fn:substring(read.readsrctile  , 0,7)}<s:if test="%{readsrctile.length()>7}">..》</s:if><s:else>》</s:else></a></li>
          	</s:if>
        </s:iterator>
        </ul>
      </div>
     <div class="book_2"> <b>资源分类</b><br />
      <s:iterator value="#request.suball" status="st" var="sub">
       <s:if test="!#st.isLast()">
        <a href="<%=basePath%>learn/readbook!list.action?subjectcode=${ sub.subjectcode}&subjectname=${sub.subjectname }&liindex=5">${ sub.subjectname}</a>|
        </s:if>
        <s:if test="#st.isLast()">
        	 <a href="<%=basePath%>learn/readbook!list.action?subjectcode=${ sub.subjectcode}&subjectname=${sub.subjectname }&liindex=5">${ sub.subjectname}</a>
        </s:if>
       </s:iterator>
       </div>
    	</c:otherwise>
    </c:choose>
       </div>
    <div class="middle_1">
      <div class="teach">
        <p><span>名师讲坛</span> <a href="<%=basePath%>learn/teacherbema_showTeachers.action?liindex=3"><img src="<%=basePath%>img/home_img/more.gif" /></a></p>
        <ul>
        <s:iterator value="#request.listsuperteacher" var="teacher" status="st">
        	  <li><a href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${teacher.superTeacherID }"> <s:if test="#teacher.teacherPath==null"><img src="img/news_img/none.jpg" /></s:if><s:else><img src="<%=basePath%>${teacher.teacherPath }" /></s:else></a>
        	  <a href="<%=basePath%>learn/teacherbema_showTeacherinfo.action?teacherId=${teacher.superTeacherID }" title="${teacher.username }:${teacher.teacherIntroduction }">${teacher.username }：${fn:substring(teacher.teacherIntroduction  , 0,10)}</a></li>
        </s:iterator>
        </ul>
      </div>
      <div class="teach">
        <p class="school"><span>名校风采</span> <a href="<%=basePath%>learn/schools_showSchools.action?liindex=4" target=""><img src="<%=basePath%>img/home_img/more.gif"  /></a></p>
        <ul>
         	<s:if test="#request.listschool.size()<=0">
        			<center>数据不足请稍等</center>
        	</s:if>
        	<s:else>
           <s:iterator value="#request.listschool" var="school" status="st">
        	  <li><a href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${school.articlesrcid }"><s:if test="#school.coverpath==null"><img src="img/news_img/none.jpg" /></s:if><img src="${school.coverpath }" /></a> <a href="<%=basePath%>learn/teacherbema_showSchool.action?articlesrcId=${school.articlesrcid }">${school.schoolname }</a></li>
        </s:iterator>
      	</s:else>
        </ul>
      </div>
    </div>
    <div class="right_1">
      <div class="ppll">
        <p><span>品学论道</span> <a href="<%=basePath%>learn/pinxue_showPinXue.action?liindex=2"><img src="<%=basePath%>img/home_img/more.gif" /></a></p>
        <div class="newsl3">
          <ul>
          <c:choose>
          	<c:when test="${empty PerusalArticle}">
          		暂无数据
          	</c:when>
          	<c:otherwise>
          		<c:forEach items="${PerusalArticle}" var="pa" varStatus="vs">
          			<li><a href="<%=basePath%>learn/PerusalArticle!getArticleById.action?liindex=2&id=${pa.articlesrcid }" title="${pa.articletitle  }">${fn:substring(pa.articletitle  , 0,18)}</a></li>
          		</c:forEach>
          	</c:otherwise>
          </c:choose>
          </ul>
        </div>
        <div class="banner4"><a href="#" onclick="return false"><img name="advertisement" title="index-e" src="" /></a></div>
      </div>
    </div>
  </div>
</div>
<div class="mainbody">
<div class="interesting">
  <P>
   	<s:iterator value="#request.programa" var="pro" status="st">
   		<s:if test="!#st.isLast()">
   			<a href="<%=basePath %>interest/activity_showActions.action?proID=${pro.proID }">${pro.proName}</a> - 
   		</s:if>
   		 <s:if test="#st.isLast()">
        	 <a href="<%=basePath %>interest/activity_showActions.action?proID=${pro.proID }">${pro.proName}</a>
        </s:if>
   	</s:iterator>
   </P>
</div>
<div class="learning_di">
  <div class="left_1">

    <div class="book">
      <!--  
       <c:choose>
      	<c:when test="${empty newworks}">
      		暂无数据
      	</c:when>
      	<c:otherwise>
      <p><img src="<%=basePath%>${newworks[0].facepath }" /></p>
      <ul>
      	 <li class="bookt"><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${newworks[0].worksid }">[最新]${fn:substring(newworks[0].workstitle,0,15)}</a></li>
       	 <li class="bookzi">${newworks[0].worksintro}<a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${newworks[0].worksid }">[详情]</a></li>
      </ul>
          </c:otherwise>
      	</c:choose>
    </div>
    
    <div class="book_3">
      <ul>
        <c:choose>
      	<c:when test="${empty newworks}">
      		暂无数据
      	</c:when>
      	<c:otherwise>				
      	<s:if test="#request.newworks.size()<=1">
					数据不足
      	</s:if>	
      	<s:else>
      	   	<c:forEach items="${newworks}" var="newworks" varStatus="vs">
      	   		<c:if test="${vs.index!=0}">
      	   		<li><a href="<%=basePath %>interest/activity_showActions.action?proID=${newworks.activity.programa.proID }"><span style="color:#626262;">[${newworks.activity.programa.proName }]</span></a><a href="<%=basePath %>interest/Comm_showActivityWorkComm.action?workId=${newworks.worksid }">${fn:substring(newworks.workstitle,0,15)}</a></li>
      	   		</c:if>
      	   	</c:forEach>
      	</s:else>	
      	</c:otherwise>
      	</c:choose>
      </ul>
    </div>
    
     -->
       <c:choose>
      	<c:when test="${fn:length(activity)<3}">
      		暂无数据
      	</c:when>
      	<c:otherwise>
     	<p><img src="<%=basePath%>${activity[0].activitysrc }" /></p>
	      <ul>
	      	 <li class="bookt"><a href="index_interest.jsp">[最新]${fn:substring(activity[3].activitytitle ,0,15)}</a></li>
	       	 <li class="bookzi">${fn:substring(activity[3].activityintro,0,30) }<a href="index_interest.jsp">[详情]</a></li>
	      </ul>
      	</c:otherwise>
      	</c:choose>
      	</div>
    	<div class="book_3">
      	<c:choose>
	      	<c:when test="${fn:length(activity)<4}">
	      		暂无数据
	      	</c:when>
	      	<c:otherwise>
	      	 <ul>
	      	<c:forEach items="${activity}" var="newworks" varStatus="vs">
	      	<c:if test="${vs.index>=4}">
	      	<li><a href="index_interest.jsp">${fn:substring(newworks.activitytitle , 0,10)}</a></li>
	      	</c:if>
	      	</c:forEach>
	      	</ul>
	      	</c:otherwise>	
      	</c:choose>
      	</div>			
  </div>
  <div class="middle_1">
    <div class="paile">
      <p><span>最新活动</span> <a href="index_interest.jsp"><img src="<%=basePath%>img/home_img/canyu.gif" /></a></p>
     <c:choose>
      	<c:when test="${empty activity}">
      		暂无数据
      	</c:when>
      	<c:otherwise>
      		<c:forEach items="${activity}" var="activity" varStatus="vs">
      		<c:if test="${vs.index<3}">
     		<ul>
        <li><a href="index_interest.jsp"><c:if test="${empty activity.activitysrc}"><img src="img/news_img/none.jpg" /></c:if><c:if test="${not empty activity.activitysrc}"><img src="<%=basePath%>${activity.activitysrc}" /></c:if></a> </li>
        <li>
          <p><img src="<%=basePath%>img/home_img/${vs.index+1 }.gif" /></p>
        </li>
        <li><a href="index_interest.jsp">${fn:substring(activity.activitytitle  , 0,20)}</a></li>
      	</ul>
      	</c:if>
      		</c:forEach>
      	</c:otherwise>
      </c:choose>
    </div>
  </div>
  <div class="right_1">
    <div class="ppll">
      <p><span>新知识点</span> </p>
      <div class="newsl3">
        <ul>
        <c:choose>
        <c:when test="${empty newknows}">
        	暂无数据
        </c:when>
        <c:otherwise>
        	<c:forEach items="${newknows}" var="new" varStatus="vs">
        	 <li><a href="<%=basePath%>interest/viewById.action?id=${new.articleid }"><span>[${new.articleType.articletypename }]</span></a> <a href="<%=basePath%>interest/viewById.action?id=${new.articleid }" title="${new.articletitle }">${fn:substring(new.articletitle  , 0,15)}</a></li>
        	</c:forEach>
        </c:otherwise>
        </c:choose>
        </ul>
        <div class="banner5"><a href="#" onclick="return false"><img name="advertisement" title="index-f" src="" /></a></div>
      </div>
    </div>
  </div>
</div>
<div class="mainbody">
  <div class="shopping">
    <p></p>
     <form action="<%=basePath%>shopping/shpping_showShopList.action" name="seaFor" id="seaFor" method="post">
    <ul>
      <li>商品查询：</li>
      <li>
      <input type="hidden" name="t" value="1"/>
      <!-- 输出所有上级类别 -->
        <select name="byMainTopicId" id="goodsMianSrot"  onchange="typeChange(this.value)">
          	<option value="">全部</option>
        	<c:forEach items="${goodsMianSrot}" varStatus="vs" var="goodsMianSrot">
        		<option value="${goodsMianSrot.categoryid }">${goodsMianSrot.categoryname }</option>
        	</c:forEach>
        </select>
      </li>
      <li>
      <!-- 根据上级类别获得子类别 -->
        <select name="byTopicId" id="goodsSrot" onChange="javascript:$('#categoryname').val($('#goodsSrot option:selected').text())">
			<option value="">全部</option>
        </select>
      </li>
      <li><a href="#" onClick="javascript:seaFor.submit();return false;"><img src="<%=basePath%>img/home_img/zz.gif" /></a></li>
    </ul>
    </form>
    
  </div>
  <div class="learning_di">
    <div class="left_2">
      <div class="scmenu">
        <ul>
        <c:choose>
        	<c:when test="${empty hotMainsrot}">
        		暂无类别
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${hotMainsrot}" var="Hm" varStatus="vs">
        			<li class="mmbj"><a href="#" onClick="return showhotgoods(this.value,'${vs.index}')" value="${Hm.categoryid }">${Hm.categoryname }</a></li>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </ul>
        <p><a href="shopping/shoppingIndex_showIndex.action"><img src="<%=basePath%>img/home_img/jinr.gif" /></a></p>
      </div>
      <div class="bookji">
        <ul id="goodstype">
        <c:choose>
	        <c:when test="${empty hotGoodses}">没有最新产品</c:when>
	      	<c:otherwise>
	      	 <c:forEach items="${hotGoodses}" var="hg" varStatus="vs">
	      	 	<li>
	          	<a href="shopping/shpping_showGoods.action?goodsId=${hg.goodsid }&t=1" title="${hg.goodsname }"">
	          		<c:if test="${empty hg.photospath}"><img src="img/news_img/none.jpg" /></c:if>
	          		<c:if test="${not empty hg.photospath}"><img src="<%=basePath%>${hg.photospath }"/></c:if>
	          		${fn:substring(hg.goodsname,0,9 )}
	          		<span> ￥${hg.productprice }.00</span>
	          	</a>
	          </li>
	          </c:forEach>
	      	</c:otherwise> 
	     </c:choose>
        </ul>
        
      </div>
    </div>
    <div class="right_2">
      <div class="pl">
        <p><span>商品热卖</span> </p>
      </div>
      <div class="remai">
      <c:choose>
      	<c:when test="${empty bestsalegoods}">
      		暂无数据
      	</c:when>
      	<c:otherwise>
      		<c:forEach items="${bestsalegoods}" var="good" varStatus="vs">
      		     <ul>	
        			<li class="imgtu"><img src="<%=basePath%>${good.photospath }" /></li> <li><a href="<%=basePath%>shopping/shpping_showGoods.action?goodsId=${good.goodsid}">${fn:substring(good.goodsname,0,10) }</a></li><li><span>${fn:substring(good.productdescription  , 0,30)}<s:if test="%{productdescription.length()>30}">...</s:if></span></li>
        		</ul>
      		</c:forEach>
      	</c:otherwise>
      </c:choose>
      </div>
      <div class="guanci">
      <c:choose>
      	<c:when test="${empty hotchildsrot}">
      		暂无数据
      	</c:when>
      	<c:otherwise>
      		<c:forEach items="${hotchildsrot}" var="hs" varStatus="vs">
      				<a href="<%=basePath%>shopping/shpping_showShopList.action?byTopicId==${hs.categoryid }&t=1&byMainTopicId=${hs.goodesCategory.categoryid}">${hs.categoryname }</a> |
      		</c:forEach>
      	</c:otherwise>
      </c:choose>
         </div>
    </div>
  </div>
</div>
<div class="mainbody">
	<div class="goodll">
    	<p><span>友情链接</span></p>
        <ul>
        <li><a href="http://www.ncet.edu.cn/"><img src="<%=basePath%>img/home_img/中央电化教育馆.jpg" /></a></li>
         <li><a href="http://www.hunanedu.net/"><img src="<%=basePath%>img/home_img/湖南省电化教育馆.jpg" /></a></li>
         <li><a href="http://www.csedu.gov.cn/"><img src="<%=basePath%>img/home_img/长沙教育信息网.jpg" /></a></li>
         <li><a href="http://www.beiro.com.cn/"><img src="<%=basePath%>img/home_img/长沙贝诺医院.jpg" /></a></li>
         <li><a href="#"><img src="<%=basePath%>img/home_img/IPTV教育.jpg" /></a></li>
         <li><a href="http://www.xwtd.cn"><img src="<%=basePath%>img/home_img/新闻天地.jpg" /></a></li>
         <li><a href="http://www.rednet.cn"><img src="<%=basePath%>img/home_img/红网.jpg" /></a></li>
         <li><a href="http://www.yyyb.gov.cn"><img src="<%=basePath%>img/home_img/岳阳医保网.jpg" /></a></li>
         <li><a href="http://www.hndpf.org/"><img src="<%=basePath%>img/home_img/湖南省残疾人联合会.jpg" /></a></li>
         <li><a href="http://edu.sina.com.cn/"><img src="<%=basePath%>img/home_img/新浪教育.jpg" /></a></li>
         <li><a href="http://edu.qq.com/"><img src="<%=basePath%>img/home_img/腾讯教育.jpg" /></a></li>
         <li><a href="http://learning.sohu.com/"><img src="<%=basePath%>img/home_img/搜狐教育.jpg" /></a></li>
         <li><a href="http://edu.163.com/"><img src="<%=basePath%>img/home_img/网易教育.jpg" /></a></li>
         <li><a href="http://edu.china.com/"><img src="<%=basePath%>img/home_img/中华网教育.jpg" /></a></li>
         <li><a href="http://www.yilu365.com/"><img src="<%=basePath%>img/home_img/艺路网.jpg" /></a></li>
         <li><a href="http://gaokao.eol.cn/"><img src="<%=basePath%>img/home_img/tu6.jpg" /></a></li>
        </ul>
    </div>
</div>
<div class="mainbody">
	<div class="homebottom">
    	<div class="aboutus"><h1>关于我们</h1><p>湖南爱瑞杰科技发展股份有限公司成立于2006年6月，拥有国家工业与信息化部严格审核与批复的全国全网公众特服电话952116。 以952116为全国统一客服电话，公司投巨资逐步建立...<a href="http://WWW.CNARJ.COM">[去官网]</a></p></div>
        <div class="webgg"><h1>网站公告</h1><p>网站正在建设中，数字化校园智能信息管理系统二期开发进行中，请关注。。</p><p class="dian"><a href="http://www.cnarj.com/zs/index.html"><img src="<%=basePath%>img/home_img/zzss.gif" /></a><a href="http://www.cnarj.com/about.asp?smallname=%C1%AA%CF%B5%CE%D2%C3%C7"><img src="<%=basePath%>img/home_img/ll.gif" /></a></p></div>
        <div class="webgg"><h1>互动交流</h1><p class="gao">家长QQ交流群:<br /><span>77642979</span></p><p>教师QQ交流群:<br /><span>181176363</span></p></div>
        <div class="help"><h1>客服帮助</h1><p>QQ1：1308066280</p><p>QQ2：1006911600</p><p class="tel">全国统一客户电话：<span>952116</span></p></div>
    </div>
</div>
<div class="mainbody">
	<div class="banqq">
    <span>@2011 952116.com 版权所有 ICP09002922号备   湖南爱瑞杰科技发展股份有限公司
  <script src="http://s20.cnzz.com/stat.php?id=3555187&web_id=3555187&show=pic1" language="JavaScript"></script></span> 
    <p>
    <a href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a> 
    | <a href="http://www.cnarj.com/business.asp?smallname=%B0%AE%C8%F0%BD%DC%BC%BC%CA%F5">技术服务</a> 
    | <a href="login/navigation.jsp">网站导航</a> 
    | <a href="javascript:;">广告服务</a> 
    | <a href="javascript:;">合作伙伴</a> 
    | <a href="javascript:;">帮助中心</a> 
    | <a target="_blank"  href="http://v1.952116.com">旧版本</a>
    </p>
    </div>
</div>
</body>
</html>