<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="left">
<s:if test="#session.loginMemberType == 1">
      <div class="ru1"> <img  <c:if test="${empty loginMemberHeadpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> <c:if test="${not empty loginMemberHeadpath}">src="<%=basePath%>${loginMemberHeadpath}"</c:if> />
        <p><b>${loginMemberNikename}</b><br />
          积分：<span>${loginMemberPoint}</span><br />
          <a href="myspace/headChange.jsp">更换头像&gt;&gt;</a> </p>
      </div>
      <div class="ru2">
        <ul>
          <li><a href="myspace/comm/blogList.action?blogtype=1" class="bj1">博文</a> <a href="myspace/comm/editblog.jsp" class="brr">发表</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/albumList.action" class="bj2">相册</a> <a href="myspace/comm/photoAddGo.action" class="brr">上传</a></li>
        </ul>
        <!-- <ul>
          <li><a href="#" class="bj3">学校</a></li>
        </ul> -->
        <ul>
          <li><a href="myspace/comm/msgList.action" class="bj4">留言板</a></li>
        </ul>
      </div>
      <div class="ru2">
        <p>班级</p>
        <ul>
          <li><a href="member/classmateAction!list.action" class="bj5">同学录</a></li>
        </ul>
        <ul>
           <li><a href="member/secretZoneAction!list.action" class="bj6">秘密空间</a></li>
        </ul>
        <ul>
          <!--<li><a  class="bj7">班级动态</a></li>-->
        </ul>
      </div>
     
	      	<div class="ru2">
	        <p>查询</p>
	        <ul>
	          <li><a href="member/examQueryAction!stuExamList.action" class="bj8">成绩查询</a></li>
	        </ul>
	        <ul>
	          <li><a href="member/attenQueryAction!stuAttendancePager.action" class="bj9">考勤查询</a></li>
	        </ul>
	        <ul>
	          <li ><a href="member/smsMsgAction!stuQuery.action" class="bj10" >短信查询</a></li>
	        </ul>
	        <ul>
	          <li><a  class="bj11"><font color="gray">消费记录查询</font></a></li>
	        </ul>
	        <ul>
	          <li><a href="member/courseAction!getCoursesByStu.action" class="bj12">课程表查询</a></li>
	        </ul>
	      </div>
      
       <div class="ru2">
        <p>百宝箱</p>
        <ul>
          <li><a href="myspace/comm/downManaList.action" class="bj13">下载管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/uploadSrcList.action" class="bj18">资源管理</a> <a href="myspace/comm/uploadSrcGo.action" class="brr">上传</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mquestionList.action" class="bj14">问题管理</a> <a href="Article/Show_QuestionAdd.action" class="brr">提问</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/worksList.action" class="bj15">作品管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/carItemList.action" class="bj16">购物车</a> <a href="myspace/comm/carItemList.action" class="brr">付款</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/orderList.action" class="bj19">我的订单</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/receiverList.action" class="bj20">地址管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/listfavca.action" class="bj17">收藏夹</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mStudyList.action" class="bj21">品学论道</a></li>
        </ul>
      </div>
       <div class="ru2">
          <p>设置</p>
          <ul>
            <li><a href="myspace/updateinfo.jsp" class="bj13">个人资料修改</a></li>
          </ul>
          <ul>
            <li><a href="myspace/updatepwd.jsp" class="bj14">密码修改</a></li>
          </ul>
        </div>
</s:if>
<s:elseif test="#session.loginMemberType == 2">
	 <div class="ru1"> <img  <c:if test="${empty loginMemberHeadpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> <c:if test="${not empty loginMemberHeadpath}"><%=basePath%>${loginMemberHeadpath}</c:if> />
        <p><b>${loginMemberNikename}</b><br />
          积分：<span>${loginMemberPoint}</span><br />
          <a href="myspace/headChange.jsp">更换头像&gt;&gt;</a> </p>
      </div>
      <div class="ru2">
        <ul>
          <li><a href="myspace/comm/blogList.action?blogtype=1" class="bj1">博文</a> <a href="myspace/comm/editblog.jsp" class="brr">发表</a></li>
        </ul>
        <ul>
           <li><a href="myspace/comm/albumList.action" class="bj2">相册</a> <a href="myspace/comm/photoAddGo.action" class="brr">上传</a></li>
        </ul>
        <!--  <ul>
          <li><a href="#" class="bj3">学校</a></li>
        </ul>-->
        <ul>
          <li><a href="myspace/comm/msgList.action" class="bj4">留言板</a></li>
        </ul>
      </div>
         
	      	<div class="ru2">
	        <p>查询</p>
	        <ul>
	          <li><a href="member/examQueryAction!parExamList.action" class="bj8">成绩查询</a></li>
	        </ul>
	        <ul>
	          <li><a href="member/attenQueryAction!parAttendancePager.action" class="bj9">考勤查询</a></li>
	        </ul>
	        <ul>
	          <li><a href="member/smsMsgAction!parQuery.action" class="bj10">短信查询</a></li>
	        </ul>
	        <ul>
	          <li><a  class="bj11"><font color="gray">消费记录查询</font></a></li>
	        </ul>
	        <ul>
	          <li><a href="member/courseAction!getCourseByPar.action" class="bj12">课程表查询</a></li>
	        </ul>
	      </div>
      
      <div class="ru2">
        <p>百宝箱</p>
        <ul>
          <li><a href="myspace/comm/downManaList.action" class="bj13">下载管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/uploadSrcList.action" class="bj18">资源管理</a> <a href="myspace/comm/uploadSrcGo.action" class="brr">上传</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mquestionList.action" class="bj14">问题管理</a> <a href="Article/Show_QuestionAdd.action" class="brr">提问</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/worksList.action" class="bj15">作品管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/carItemList.action" class="bj16">购物车</a> <a href="myspace/comm/carItemList.action" class="brr">付款</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/orderList.action" class="bj19">我的订单</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/receiverList.action" class="bj20">地址管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/listfavca.action" class="bj17">收藏夹</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mStudyList.action" class="bj21">品学论道</a></li>
        </ul>
      </div>
 		<div class="ru2">
          <p>设置</p>
          <ul>
            <li><a href="myspace/updateinfo.jsp" class="bj13">个人资料修改</a></li>
          </ul>
          <ul>
            <li><a href="myspace/updatepwd.jsp" class="bj14">密码修改</a></li>
          </ul>
        </div>
</s:elseif>
<s:elseif test="#session.loginMemberType == 3">
	 <div class="ru1"> <img  <c:if test="${empty loginMemberHeadpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> <c:if test="${not empty loginMemberHeadpath}"><%=basePath%>${loginMemberHeadpath}</c:if> />
        <p><b>${loginMemberNikename}</b><br />
          积分：<span>${loginMemberPoint}</span><br />
          <a href="myspace/headChange.jsp">更换头像&gt;&gt;</a> </p>
      </div>
      <div class="ru2">
        <ul>
          <li><a href="myspace/comm/blogList.action?blogtype=1" class="bj1">博文</a> <a href="myspace/comm/editblog.jsp" class="brr">发表</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/albumList.action" class="bj2">相册</a> <a href="myspace/comm/photoAddGo.action" class="brr">上传</a></li>
        </ul>
       <!--  <ul>
          <li><a href="#" class="bj3">学校</a></li>
        </ul> -->
        <ul>
          <li><a href="myspace/comm/msgList.action" class="bj4">留言板</a></li>
        </ul>
      </div>
     
	      	<div class="ru2">
	        <p>查询</p>
	        <ul>
	          <li><a href="member/examQueryAction!teaExamList.action" class="bj8">成绩查询</a></li>
	        </ul>
	        <ul>
	          <li><a href="member/attenQueryAction!teaAttendancePager.action" class="bj9">考勤查询</a></li>
	        </ul>
	        <ul>
	          <li><a href="member/smsMsgAction!teaQuery.action" class="bj10">短信查询</a></li>
	        </ul>
	        <ul>
	          <li><a  class="bj11"><font color="gray">消费记录查询</font></a></li>
	        </ul>
	        <ul>
	          <li><a href="member/courseAction!getCourseByTea.action" class="bj12">课程表查询</a></li>
	        </ul>
	      </div>
      
      <div class="ru2">
        <p>百宝箱</p>
        <ul>
          <li><a href="myspace/comm/downManaList.action" class="bj13">下载管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/uploadSrcList.action" class="bj18">资源管理</a> <a href="myspace/comm/uploadSrcGo.action" class="brr">上传</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mquestionList.action" class="bj14">问题管理</a> <a href="Article/Show_QuestionAdd.action" class="brr">提问</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/worksList.action" class="bj15">作品管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/carItemList.action" class="bj16">购物车</a> <a href="myspace/comm/carItemList.action" class="brr">付款</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/orderList.action" class="bj19">我的订单</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/receiverList.action" class="bj20">地址管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/listfavca.action" class="bj17">收藏夹</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mStudyList.action" class="bj21">品学论道</a></li>
        </ul>
      </div>
		 <div class="ru2">
          <p>设置</p>
          <ul>
            <li><a href="myspace/updateinfo.jsp" class="bj13">个人资料修改</a></li>
          </ul>
          <ul>
            <li><a href="myspace/updatepwd.jsp" class="bj14">密码修改</a></li>
          </ul>
        </div>
</s:elseif>
<s:else>
<div class="ru1"> <img  <c:if test="${empty loginMemberHeadpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> <c:if test="${not empty loginMemberHeadpath}"><%=basePath%>${loginMemberHeadpath}</c:if> />
        <p><b>${loginMemberNikename}</b><br />
          积分：<span>${loginMemberPoint}</span><br />
          <a href="myspace/headChange.jsp">更换头像&gt;&gt;</a> </p>
      </div>
      <div class="ru2">
        <ul>
          <li><a href="myspace/comm/blogList.action?blogtype=1" class="bj1">博文</a> <a href="myspace/comm/editblog.jsp" class="brr">发表</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/albumList.action" class="bj2">相册</a> <a href="myspace/comm/photoAddGo.action" class="brr">上传</a></li>
        </ul>
        <!--  <ul>
          <li><a href="#" class="bj3">学校</a></li>
        </ul> -->
        <ul>
          <li><a href="myspace/comm/msgList.action" class="bj4">留言板</a></li>
        </ul>
      </div>
      <div class="ru2">
        <p>百宝箱</p>
        <ul>
          <li><a href="myspace/comm/downManaList.action" class="bj13">下载管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/uploadSrcList.action" class="bj18">资源管理</a> <a href="myspace/comm/uploadSrcGo.action" class="brr">上传</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/mquestionList.action" class="bj14">问题管理</a> <a href="Article/Show_QuestionAdd.action" class="brr">提问</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/worksList.action" class="bj15">作品管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/carItemList.action" class="bj16">购物车</a> <a href="myspace/comm/carItemList.action" class="brr">付款</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/orderList.action" class="bj19">我的订单</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/receiverList.action" class="bj20">地址管理</a></li>
        </ul>
        <ul>
          <li><a href="myspace/comm/listfavca.action" class="bj17">收藏夹</a></li>
        </ul>
      </div>
       <div class="ru2">
          <p>设置</p>
          <ul>
            <li><a href="member/memberLogin!detail.action" class="bj13">个人资料修改</a></li>
          </ul>
          <ul>
            <li><a href="myspace/updatepwd.jsp" class="bj14">密码修改</a></li>
          </ul>
        </div>
</s:else>
</div>
