<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！ --  用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/log.css" rel="stylesheet" type="text/css" />
	
	<jsp:include page="../comm/include.jsp"></jsp:include>
	
  	<script type="text/javascript" src="<%=basePath%>login/js/login.js"></script>
  </head>
  
  <body>
  <script type="text/javascript">
  	var msg = '${msg}';
  	if(msg != ""){
  		alert(msg);
  	}
  </script>
    
  <jsp:include page="header.jsp"></jsp:include>
  <div class="mainbody">
      <div class="logo_1">家校快捷方便沟通的平台</div>
  </div>
<div class="mainbody">
  <div class="zhuce">
    <div class="tit"><span>用户登录</span> <a href="<%=basePath%>login/register.jsp">还没账号，请立即注册!</a></div>
    <form action="" method="post" id="loginForm" name="loginForm">
    <input type="hidden" value="<%=basePath%>" id="basePath"/>
    <div class="juzh">
      <div class="login">登录 LOGIN</div>
      <div class="xxx">
        <ul>
          <li><b>请选择：</b></li>
          <li>
            <input name="memberType"  type="radio" value="1"/>
            学生</li>
          <li>
            <input name="memberType"  type="radio" value="2" />
            家长</li>
          <li>
            <input name="memberType"  type="radio" value="3" />
            老师</li>
          <li>
            <input name="memberType"  type="radio" value="4" />
            普通用户</li>
        </ul>
      </div>
     <div id="loginDiv">
      <div id="studentDiv">
	      <div class="hh">
	        <ul>
	          <li>校徽卡号：</li>
	          <li class="inppbj">
	            <input name="" id="stuUsername" name="stuUsername" type="text" type="text" />
	          </li>
	        </ul>
	      </div>
	      <div class="hh">
	        <ul>
	          <li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	          <li class="inppbj">
	            <input name="stuPassword" id="stuPassword" type="password"   />
	          </li>
	        </ul>
	      </div>
	       <div class="shurr">
	        <ul>
	          <li>
	            <input name="stuValidate" id="stuValidate" type="text" value="输入验证码" onfocus="javascript:this.value=''"  />
	          </li>
	          <li> <img src="validatecode" id="stuLoginValidateImage" alt="点击图片更换验证码" onmouseover="javascript:this.style.cursor='hand'" onclick="javascript:this.src = 'validatecode?now='+new Date()" /></li>
	        </ul>
	       </div>
	       <div class="shurr">
		      <ul>
		        <li><img src="<%=basePath%>img/login/dd.gif" id="imgStuLoginSubmit" /></li>
		        <li><a href="login/retrieve_password.jsp">忘记密码？</a></li>
		      </ul>
	       </div>
       </div>
      <div id="parentDiv" style="display:none">
    	<div class="hh">
	        <ul>
	          <li>手机号码：</li>
	          <li class="inppbj">
	            <input id="parentUsername" name="parentUsername" type="text"  />
	          </li>
	        </ul>
	      </div>
	      <div class="hh">
	        <ul>
	          <li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	          <li class="inppbj">
	            <input name="parentPassword" id="parentPassword" type="password" />
	          </li>
	        </ul>
	      </div>
	       <div class="shurr">
	        <ul>
	          <li>
	            <input  name="parentValidate" id="parentValidate" value="输入验证码" type="text" onfocus="javascript:this.value=''" />
	          </li>
	          <li>  <img src="validatecode" id="parLoginValidateImage" alt="点击图片更换验证码" onmouseover="javascript:this.style.cursor='hand'" onclick="javascript:this.src = 'validatecode?now='+new Date()" /></li>
	        </ul>
	       </div>
	       <div class="shurr">
		      <ul>
		        <li><img src="<%=basePath%>img/login/dd.gif" id="imgParLoginSubmit"  /></li>
		        <li><a href="retrieve_password.jsp">忘记密码？</a></li>
		      </ul>
	       </div>
       </div>
      <div id="teacherDiv" style="display:none">
	      <div class="hh">
	        <ul>
	          <li>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</li>
	          <li class="inppbj">
	            <input type="text" id="teacherUsername" name="teacherUsername" />
	          </li>
	        </ul>
	      </div>
	      <div class="hh">
	        <ul>
	          <li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	          <li class="inppbj">
	            <input name="teacherPassword" id="teacherPassword" type="password"  />
	          </li>
	        </ul>
	      </div>
	       <div class="shurr">
	        <ul>
	          <li>
	            <input name="teacherValidate" id="teacherValidate"  type="text" value="输入验证码" onfocus="javascript:this.value=''"/>
	          </li>
	          <li> <img src="validatecode" id="teaLoginValidateImage" alt="点击图片更换验证码" onmouseover="javascript:this.style.cursor='hand'" onclick="javascript:this.src = 'validatecode?now='+new Date()" /></li>
	        </ul>
	       </div>
	       <div class="shurr">
		      <ul>
		        <li><img src="<%=basePath%>img/login/dd.gif" id="imgTeaLoginSubmit"/></li>
		        <li><a href="login/retrieve_password.jsp">忘记密码？</a></li>
		      </ul>
	       </div>
       </div>
    <div id="touristDiv" style="display:none">
    	<div class="hh">
	        <ul>
	          <li>注册账号：</li>
	          <li class="inppbj">
	            <input name="touristUsername" id="touristUsername" type="text" />
	          </li>
	        </ul>
	      </div>
	      <div class="hh">
	        <ul>
	          <li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
	          <li class="inppbj">
	            <input name="touristPassword" id="touristPassword" type="password" />
	          </li>
	        </ul>
	      </div>
	       <div class="shurr">
	        <ul>
	          <li>
	            <input  name="touristValidate" id="touristValidate" type="text" value="输入验证码" onfocus="javascript:this.value=''" />
	          </li>
	          <li> <img src="validatecode" id="touLoginValidateImage" alt="点击图片更换验证码" onmouseover="javascript:this.style.cursor='hand'" onclick="javascript:this.src = 'validatecode?now='+new Date()" /></li>
	        </ul>
	       </div>
	       <div class="shurr">
		      <ul>
		        <li><img src="<%=basePath%>img/login/dd.gif" id="imgTouLoginSubmit"/></li>
		        <li><a href="login/retrieve_password.jsp">忘记密码？</a></li>
		      </ul>
	       </div>
    </div>
  	</div>
  </div>
  </form>
 </div>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
