<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！ --  用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/login/log.css" rel="stylesheet" type="text/css" />
	<jsp:include page="../comm/include.jsp"></jsp:include>	
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#regFirstSubmit").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				var validatecode = $("#validatecode").val();
				var telephone = $("#telephone").val();
				var loginPassword = $("#loginPassword").val();
				var loginPasswordTwo = $("#loginPasswordTwo").val();
				var nikename = $("#nikename").val();
				var provisionLen = $("input[name='provision']:checked").length;
				if(validatecode == ""){ alert("请填写验证码"); $("#validatecode").focus(); return false;}
				if(validatecode.length != 6){ alert("请填写6位数的验证码"); $("#validatecode").focus(); return false;}
				if(telephone == ""){ alert("请填写手机号码！"); $("#telephone").focus(); return false; }
				var moblieRegex = /^[1][0-9]{10}$/;
				if(!moblieRegex.test(telephone)){alert("手机号码格式错误，请重新输入！"); $("#telephone").focus(); return false;}
				if(nikename == ""){alert("请输入昵称！");$("#nikename").focus();return false;}
				var nikenaemReg = /^[\u0391-\uFFE5\w]+$/;
				if(!nikenaemReg.test(nikename)){alert("昵称只允许包含中文、英文、数字和下划线!");$("#nikename").focus();return false;}
				if(fucCheckLength(nikename)>10){alert("昵称只能在10个字符以内，中文为2个字符");$("#nikename").focus();return false;}
				if(loginPassword == ""){alert("请填写登录密码！"); $("#loginPassword").focus(); return false; }
				if(loginPassword.length < 6){alert("登录密码至少为6位");$("#loginPassword").focus(); return false;};
				if(loginPasswordTwo == ""){ alert("请再次输入登录密码！");$("#loginPasswordTwo").focus(); return false;}
				if(loginPassword != loginPasswordTwo){alert("两次输入密码不一致！");$("#loginPasswordTwo").focus(); return false;}
				if(provisionLen == 0){alert("请选择服务条款！");return false}
				$("#regFirstForm").submit();
				$("body").mask('正在为您注册，请稍后。。。');
			});
		});
		
		function fucCheckLength(strTemp)   
		{   
			var i,sum;   
			sum=0;   
            for(i=0;i<strTemp.length;i++)   
            {   
              if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))   
              sum=sum+1;   
              else  
              sum=sum+2;   
            }   
              return sum;   
        }   
	</script>
  </head>
  
  <body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="mainbody">
  <div class="logo_1">家校快捷方便沟通的平台</div>
</div>
<div class="mainbody">
  <div class="zhuce">
    <div class="tit"><span>欢迎注册952116综合信息门户网！952116综合信息门户网是爱瑞杰公司旗下网站，绝不会向任何第三方透露您的手机号！</span> <a href="<%=basePath%>login/login.jsp">如果您已有账号！请登录</a></div>
   <form action="<%=basePath%>regSave.action" method="post" id="regFirstForm">
   <input  type="hidden" name="registerEmail" value="${registerEmail}"/>
   <s:token></s:token>
    <div class="juzh_1">
      <div class="rest_2">
        <ul>
          <li class="gh">电子邮件：</li>
          <li><b>${registerEmail}</b></li>
          <li class="gh_1"><a href="<%=basePath%>login/register.jsp">更换邮箱</a></li>
        </ul>
      </div>
      <div class="rest_3">
      	<ul>
        	<li><span>*</span> 验证码：</li>
            <li class="inppbj"><input name="validatecode" id="validatecode" type="text" value="${validatecode}" onblur="objTrim(this)"/></li>
            <li class="tu"><img src="<%=basePath%>img/login/dui.gif" width="32" height="27" /></li>
            <li class="ppzi">如果超过5分钟没有收到，或者验证码已过期，请点这里<a href="<%=basePath%>regSendEmail.action">重发验证码</a></li>
        </ul>
      </div>
      <div class="rest_3">
      	<ul>
        	<li><span>*</span> 输入您的手机号码：</li>
            <li class="inppbj"><input name="telephone" id="telephone" type="text" value="${telephone}" onblur="objTrim(this)" /></li>
            <li class="tishi"><img src="<%=basePath%>img/login/tut.gif"/></li>
        </ul>
      </div>
      <div class="rest_3">
      	<ul>
        	<li><span>*</span> 昵        称：</li>
            <li class="inppbj"><input name="nikename" id="nikename" type="text" value="${nikename}" onblur="objTrim(this)"/></li>
        </ul>
      </div>
      <div class="rest_3">
      	<ul>
        	<li><span>*</span> 设置登录密码：</li>
            <li class="inppbj"><input name="loginPassword" id="loginPassword" type="password" value="${loginPassword}" /></li>
        </ul>
      </div>
      <div class="rest_3">
      	<ul>
        	<li><span>*</span> 再次输入密码：</li>
            <li class="inppbj"><input name="loginPasswordTwo" id="loginPasswordTwo" type="password" value="${loginPassword}"  /></li>
        </ul>
      </div>
      <div class="rest_4">
      	<ul>
        	<li><input name="provision" id="provision" type="checkbox" value="1"  /><a href="service.htm">《952116综合信息门户网》服务条款</a></li>
            <li><img src="<%=basePath%>img/login/qq2.gif" width="96" height="39" id="regFirstSubmit" /></li>
        </ul>
      </div>
    </div>
    </form>
  </div>
</div>  
     <jsp:include page="footer.jsp"></jsp:include>
     <!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include>
  </body>
</html>
