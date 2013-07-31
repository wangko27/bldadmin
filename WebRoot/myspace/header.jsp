<%@ page language="java" contentType="text/html; charset=utf-8"  isELIgnored="false" %>
<%@ include file="../comm/common_tag.jsp" %>
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" src="http://v2.jiathis.com/code_mini/jiathis_r.js?btn=r5.gif" charset="utf-8"></script>
<!-- JiaThis Button END -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<script type="text/javascript">
	<!--
	function AddFavorite(sURL, sTitle)
	{
	   try
	   {
	       window.external.addFavorite(sURL, sTitle);
	   }
	   catch (e)
	   {
	       try
	       {
	           window.sidebar.addPanel(sTitle, sURL, "");
	       }
	       catch (e)
	       {
	           alert("加入收藏失败，请使用Ctrl+D进行添加");
	       }
	   }
	}
	//-->
	</script>

	<div class="ding">
	  <div>
	    <ul>
	      <li class="dd">
	        <p>${loginMemberNikename} 同学 ，欢迎您登录952116综合信息门户网。<a href="loginout.action"><span>退出</span></a></p>
	      </li>
	      <li><a target="_self" href="javascript:AddFavorite('http://www.952116.com','《952116综合信息门户网站》')">收藏我们</a> </li>
	      <li><a target="_self" href="index/index.action"><span class="home">返回首页</span></a></li>
	      <li><a target="_blank" href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a></li>
	      <li><a target="_blank" href="login/navigation.jsp">网站导航</a></li>
	    </ul>
	  </div>
	</div>
	<div class="mainbody">
	  <div class="to_menu">
	    <ul>
	      <li><b><a target="_blank" href="learn/xx_index.action?liindex=0">[学习]</a></b></li>
	      <li><a target="_blank" href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a></li>
	      <li><a target="_blank" href="learn/readbook!list.action?liindex=5">博览群书</a></li>
	    </ul>
	    <ul>
	      <li><b><a target="_blank" href="index_interest.jsp">[兴趣]</a></b></li>
	      <li><a target="_blank" href="index_interest.jsp">拍拍乐</a></li>
	      <li><a target="_blank" href="index_interest.jsp">航模组</a></li>
	      <li><a target="_blank" href="index_interest.jsp">英语角</a></li>
	    </ul>
	    <!-- 
	    <ul>
	      <li><b><a target="_blank" href="interest/XQ_index.action">[兴趣]</a></b></li>
	      <li><a target="_blank" href="interest/activity_showActions.action?proID=8a8081b121bd7ec20131bd7f78e50001">拍拍乐</a></li>
	      <li><a target="_blank" href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5f7f6000a">航模组</a></li>
	      <li><a target="_blank" href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5b9760008">英语角</a></li>
	    </ul>
	     -->
	    <ul>
	      <li><b><a target="_blank" href="Article/Show_News_Index.action">[资讯]</a></b></li>
	      <li><a target="_blank" href="Article/getArticleByEducationType.action?id=8a80818c31bb7cc50131bb805c4a0007">教育看点</a></li>
	      <li><a target="_blank" href="Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002">生活百科</a></li>
	      <li><a target="_blank" href="Article/listQuestion.action?id=">答疑小博士</a></li>
	    </ul>
	    <ul>
	      <li><b><a target="_blank" href="shopping/shoppingIndex_showIndex.action?t=">[商城]</a></b></li>
	      <li><a target="_blank" href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d2c4e440002&t=1&byTopicId=">工具书</a></li>
	      <li><a target="_blank" href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d2d68010003&t=1&byTopicId=">学习用品</a></li>
	      <li><a target="_blank" href="shopping/shpping_showShopList.action?byMainTopicId=8a8080bf324d1c4601324d24b5030001&t=1&byTopicId=">资源库题</a></li>
	    </ul>
	    <ul class="wu">
	      <li><b><a href="openzone/zoneIndexAction!userCenterIndex.action">[空间]</a></b></li>
	    </ul>
	  </div>
	</div>
	<div class="mainbody gaodu">
	  <div class="logo_ll">
	    <ul>
	      <li class="img"><a href="#"><img src="img/user_img/logo.gif" /></a></li>
	      
	      <li>
	      <!-- 
	        <input type="text" value="请输入关键词，如：汽车、飞机" />
	        <a href="#"><img src="img/learning_img/go.gif" /></a>
	         -->
	        </li>
	    </ul>
	  </div>
	</div>
	
	<div class="usermenu">
	  <s:if test="#session.loginMemberType == 1">
		  <div class="menu1">
		    <ul class="iopyy">
		      <li> <a href="openzone/zoneIndexAction!userCenterIndex.action">我的空间</a></li>
		      <li> <a href="myspace/comm/friendList.action">好友</a></li>
		      <li> <a href="member/examQueryAction!stuExamList.action">查询</a></li>
		      <li> <a href="myspace/comm/downManaList.action">百宝箱</a></li>
		      <li> <a href="member/secretZoneAction!list.action">私密空间</a></li>
		    </ul>
		    <ul  class="ttiop">
		      <li><a href="member/myinformation!myInfo.action">我的资料</a> | </li>
		      <li><a href="myspace/updatepwd.jsp">设置</a> | </li>
		      <li><a href="<%=basePath%>loginout.action">退出</a> </li>
		    </ul>
		  </div>
	  </s:if>
	  <s:elseif test="#session.loginMemberType == 2">
	  	<div class="menu1">
		    <ul class="iopyy">
		      <li> <a href="openzone/zoneIndexAction!userCenterIndex.action">我的空间</a></li>
		      <li> <a href="myspace/comm/friendList.action">好友</a></li>
		      <li> <a href="member/examQueryAction!parExamList.action">查询<img src="img/user_img/jj.gif" /></a></li>
		      <li> <a href="myspace/comm/downManaList.action">百宝箱<img src="img/user_img/jj.gif" /></a></li>
		    </ul>
		    <ul  class="ttiop">
		      <li><a href="member/myinformation!myInfo.action">我的资料</a> | </li>
		      <li><a href="myspace/updatepwd.jsp">设置</a> | </li>
		      <li><a href="<%=basePath%>loginout.action">退出</a> </li>
		    </ul>
		  </div>
	  </s:elseif>
	  <s:elseif test="#session.loginMemberType == 3">
	  	<div class="menu1">
		    <ul class="iopyy">
		      <li> <a href="openzone/zoneIndexAction!userCenterIndex.action">我的空间</a></li>
		      <li> <a href="myspace/comm/friendList.action">好友</a></li>
		      <li> <a href="member/examQueryAction!teaExamList.action">查询<img src="img/user_img/jj.gif" /></a></li>
		      <li> <a href="myspace/comm/downManaList.action">百宝箱<img src="img/user_img/jj.gif" /></a></li>
		    </ul>
		    <ul  class="ttiop">
		      <li><a href="member/myinformation!myInfo.action">我的资料</a> | </li>
		      <li><a href="myspace/updatepwd.jsp">设置</a> | </li>
		      <li><a href="<%=basePath%>loginout.action">退出</a> </li>
		    </ul>
		  </div>
	  </s:elseif>
	  <s:else>
	  	<div class="menu1">
		    <ul class="iopyy">
		      <li> <a href="openzone/zoneIndexAction!userCenterIndex.action">我的空间</a></li>
		      <li> <a href="myspace/comm/friendList.action">好友</a></li>
		      <li> <a href="myspace/comm/downManaList.action">百宝箱<img src="img/user_img/jj.gif" /></a></li>
		    </ul>
		    <ul  class="ttiop">
		      <li><a href="member/myinformation!myInfo.action">我的资料</a> | </li>
		      <li><a href="myspace/updatepwd.jsp">设置</a> | </li>
		      <li><a href="<%=basePath%>loginout.action">退出</a> </li>
		    </ul>
		  </div>
	  </s:else>
	</div>

