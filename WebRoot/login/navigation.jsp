<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！ --  网站导航</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/common.css" rel="stylesheet" type="text/css" />

  </head>
  
 <body>
<jsp:include page="/login/header.jsp"></jsp:include>
<div class="mainbody">
  <div class="logo_1">家校快捷方便沟通的平台</div>
</div>
<div class="mainbody">
  <div class="zhuce_1">
    <div class="tit_1">
      <ul>
        <li><a target="_blank" href="http://dsis.952116.com/DSIS_system/">数字化校园系统</a></li>
        <li>|</li>
        <li><a target="_blank" href="http://www.cnarj.com/business.asp?smallname=%B0%AE%C8%F0%BD%DC%BC%BC%CA%F5">技术服务</a></li>
        <li>|</li>
        <li><a href="javascript:;">网站导航</a></li>
        <li>|</li>
        <li><a href="javascript:;">广告服务</a></li>
        <li>|</li>
        <li><a href="javascript:;">合作伙伴</a></li>
        <li>|</li>
        <li><a href="javascript:;">帮助中心</a></li>
        <li>| </li>
        <li><a target="_blank" href="http://www.cnarj.com/about.asp?smallname=%C1%AA%CF%B5%CE%D2%C3%C7">联系我们</a></li>
        <li class="zhao"><a target="_blank" href="http://www.cnarj.com/zs/index.html">招商加盟</a></li>
      </ul>
    </div>
    <div class="youlink">
      <div class="ddaop">网站导航</div>
      <div class="fuq">
        <div class="fu_1">
          <ul>
            <li class="xue">学习：</li>
            <li>
            <a target="_blank" href="learn/oneday_showOneDayOneText.action?liindex=1">一天一课</a> 
            <a target="_blank" href="learn/pinxue_showPinXue.action?liindex=2">品学论道</a> 
            <a target="_blank" href="learn/teacherbema_showTeachers.action?liindex=3">名师讲坛</a> 
            <a target="_blank" href="learn/schools_showSchools.action?liindex=4">名校风采</a> 
            <a target="_blank" href="learn/readbook!list.action?liindex=5">博览群书</a>
            </li>
          </ul>
        </div>
        <div class="fu_1">
          <ul>
            <li class="xing">兴趣：</li>
            <li>
            <a  target="_blank" href="index_interest.jsp">拍拍乐</a> 
            <a target="_blank" href="index_interest.jsp">航模组</a> 
            <a target="_blank" href="index_interest.jsp">英语角</a> 
            <a target="_blank" href="index_interest.jsp">计算机</a> 
            <a target="_blank" href="index_interest.jsp">绘画班</a> 
            <a target="_blank" href="index_interest.jsp">爱探索</a>
            </li>
          </ul>
        </div>
        <div class="fu_1">
          <ul>
            <li class="zix">资讯：</li>
            <li>
            <a target="_blank" href="Article/getArticleByEducationType.action?id=8a80818c31bb7cc50131bb805c4a0007">教育看点</a> 
            <a target="_blank" href="Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002">生活百科</a> 
            <a target="_blank" href="Article/listNews.action">新闻动态</a> 
            <a target="_blank" href="Article/listQuestion.action?id=">答疑小博士</a> 
            </li>
          </ul>
        </div>
      </div>
      <div class="fuq">
        <div class="fu_1">
          <ul>
            <li class="shang">商城：</li>
            <li>
            <a target="_blank" href="shopping/shoppingIndex_showIndex.action?t=">商城首页</a> 
            <a target="_blank" href="shopping/shoppingArticle!list.action?t=2">购物资讯</a> 
            <a target="_blank" href="shopping/shoppingQuestion!list.action?t=3">热心解答</a>
            </li>
          </ul>
        </div>
        <div class="fu_1">
          <ul>
            <li class="kong">空间：</li>
            <li>
            <a target="_blank" href="login/register.jsp">注册</a> 
            <a target="_blank" href="login/login.jsp">登录</a>
            </li>
          </ul>
        </div>
        <div class="fu_1">
          <ul>
            <li class="zong">综合业务：</li>
            <li>
            <a href="javascript:;">汽车违章</a> 
            <a target="_blank" href="http://flight.952116.com/flight/FlightSearch.asp">机票订购</a> 
            <a href="javascript:;">职介通</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="fuq">
        <div class="fu_2">
          <ul>
            <li class="qi">其他：</li>
            <li>
            <a href="http://10.0.5.2/DSIS_system/">数字化校园系统</a>
            <a href="http://www.cnarj.com/business.asp?smallname=%B0%AE%C8%F0%BD%DC%BC%BC%CA%F5">技术服务</a>
            <a href="javascript:;">广告服务</a>
			<a href="javascript:;">合作伙伴</a>
			<a href="javascript:;">帮助中心</a> 
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/login/footer.jsp"></jsp:include>
</body>
</html>

