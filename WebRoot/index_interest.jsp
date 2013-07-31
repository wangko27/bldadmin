<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>您好，欢迎来到952116综合信息门户网!--兴趣首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/interesting/interesting.css" rel="stylesheet" type="text/css" />
	<link href="css/interesting/interesting_common.css" rel="stylesheet" type="text/css" />
	<!-- JiaThis Button BEGIN -->
	<script type="text/javascript" src="http://v2.jiathis.com/code_mini/jiathis_r.js?btn=r5.gif" charset="utf-8"></script>
	<!-- JiaThis Button END -->
  </head>
  
  <body>
  
	<jsp:include page="/base/top.jsp"></jsp:include>
	<jsp:include page="/base/toplink.jsp"></jsp:include>
	<div class="mainbody">
	  <div class="logo_ll">
	    <ul>
	      <li class="img"><a href="#"><img src="img/interesting_img/l2.gif" /></a></li>
	      
	      <!-- 
	      <li>
	        <select name="">
	          <option>科目</option>
	          <option>语文</option>
	        </select>
	      </li>
	      <li>
	        <input type="text" value="请输入关键词，如：试卷、教案" />
	        <a href="#"><img src="../img/learning_img/go.gif" /></a></li>
	         -->
	    </ul>
	  </div>
	</div>
<div class="mainbody">
  <div class="learning_menu">
    <ul>
      <li><a href="#" class="dizhu">兴趣首页</a></li>
      <li>为了更好的提高学生们的活动积极性，给大家提供施展个性与才华的平台。</li>
    </ul>
  </div>
  <div class="commongao"></div>
</div>
<div class="mainbody">
  <div class="slide_1">
    <div class="sde"><img src="img/interesting_img/sep.jpg" /></div>
  </div>
  <div class="login_1">
    <p><a href="#"> <img src="img/interesting_img/zi.gif" /></a></p>
    <ul>
      <li>&nbsp;&nbsp;&nbsp;&nbsp;在充满活力的校园里，随时都会发生各种有趣的情景故事。快用几张照片，留下精彩瞬间。让我们拾起属于我们的美丽青春画卷...</li>
      <li>&nbsp;</li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306bf89260015">闪光灯使用技巧7必杀</a></li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c16fa90016">数码相机使用小技巧</a></li>
      <li> ·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c27d020017">闪光灯使用技巧</a></li>

    </ul>
  </div>
</div>
<div class="mainbody">
  <div class="slide_1">
    <div class="sde"><img src="img/interesting_img/bs.jpg" /></div>
  </div>
  <div class="login_1">
    <p><a href="#"> <img src="img/interesting_img/zi.gif" /></a></p>
    <ul>
      <li>&nbsp;&nbsp;&nbsp;&nbsp;为了促进广大中小学生口才与应变能力，特针对所有中小学用户开展演讲活动，采用网络视频的方式上次到网上，进行投票...</li>
      <li>&nbsp;</li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd01330664f8650005">演讲的含义</a></li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd0133066b404e0006">演讲技巧</a></li>
      <li> ·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd0133069aff44000c">只有动真情，才能动人心</a></li>
      
    </ul>
  </div>
</div>
<div class="mainbody">
  <div class="slide_1">
    <div class="sde"><img src="img/interesting_img/xkj.jpg" /></div>
  </div>
  <div class="login_1">
    <p><a href="#"> <img src="img/interesting_img/zi.gif" /></a></p>
    <ul>
      <li>&nbsp;&nbsp;&nbsp;&nbsp;在全新的数字化时代的课堂教学，已经离不开优质的电子课件——趣味教学，使用创新技术；轻松课堂，引领思维火花的碰撞...</li>
     
      <li>&nbsp;</li>

      
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306e06ef60020">制作flash课件要点</a></li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306e1a2f20021">制作PPT课件规范</a></li>
      <li> ·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306dfa83b001f">什么是网络课件</a></li>
    </ul>
  </div>
</div>
<div class="mainbody">
  <div class="slide_1">
    <div class="sde"><img src="img/interesting_img/js.jpg" /></div>
  </div>
  <div class="login_1">
    <p><a href="#"> <img src="img/interesting_img/zi.gif" /></a></p>
    <ul>
      <li>&nbsp;&nbsp;&nbsp;&nbsp;给老师提供一个抒发自我，互相交流学习教学的平台，特举办以老师为核心的作文比赛，命题围绕老师多年经验来述说...</li>
      <li>&nbsp;</li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306960bdf000a">为什么当教师？</a></li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd01330696e7f7000b">一名合格的人民教师心得...</a></li>
      <li> ·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c55cc90018">中学教师解放思想心得体会</a></li>
    </ul>
  </div>
</div>
<div class="mainbody">
  <div class="slide_1">
    <div class="sde"><img src="img/interesting_img/xzj.jpg" /></div>
  </div>
  <div class="login_1">
    <p><a href="#"> <img src="img/interesting_img/zi.gif" /></a></p>
    <ul>
      <li>&nbsp;&nbsp;&nbsp;&nbsp;大家可以利用平时课余时间的一天一练的随笔进行投稿，此次活动主要以培养孩子平时写作能力，互相学习的同时快乐的成长...</li>
      <li>&nbsp;</li>

      
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c71268001a">初中作文写作技巧</a></li>
      <li>·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c7c5ea001b">如何写好作文标题开头？</a></li>
      <li> ·&nbsp;<a href="interest/viewById.action?id=8a80801133065abd013306c655a00019">写好作文口诀法宝</a></li>
    </ul>
  </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
  
  </body>
</html>
