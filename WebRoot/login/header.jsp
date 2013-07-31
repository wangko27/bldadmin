<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
	      <c:choose>
      		<c:when test="${fn:length(loginMemberNikename)>0}">
      		<p>${loginMemberNikename} 同学 ，欢迎您登录952116综合信息门户网。<a href="loginout.action"><span>退出</span></a></p>
      		</c:when>
      		<c:otherwise>
      		<p>您好，欢迎来到952116综合信息门户网！请<a href="login/login.jsp"><span>登录</span></a>。新用户，请<a href="login/register.jsp">免费注册</a>！</p>
      		</c:otherwise> 
      		</c:choose>
	      </li>
	      <li><a target="_self" href="javascript:AddFavorite('http://www.952116.com','《952116综合信息门户网》')">收藏我们</a> </li>
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
	    <!--
	    <ul>
	      <li><b><a href="interest/XQ_index.action" target="_blank">[兴趣]</a></b></li>
	      <li><a href="interest/activity_showActions.action?proID=8a8081b121bd7ec20131bd7f78e50001" target="_blank">拍拍乐</a></li>
	      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5f7f6000a" target="_blank">航模组</a></li>
	      <li><a href="interest/activity_showActions.action?proID=8a8081a131faef070131faf5b9760008" target="_blank">英语角</a></li>
	    </ul>
	     -->
	    <ul>
	      <li><b><a target="_blank" href="index_interest.jsp" target="_blank">[兴趣]</a></b></li>
	      <li><a target="_blank" href="index_interest.jsp" target="_blank">拍拍乐</a></li>
	      <li><a target="_blank" href="index_interest.jsp" target="_blank">航模组</a></li>
	      <li><a target="_blank" href="index_interest.jsp" target="_blank">英语角</a></li>
	    </ul>
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
	      <li><b><a target="_blank" href="openzone/zoneIndexAction!userCenterIndex.action">[空间]</a></b></li>
	    </ul>
	  </div>
</div>