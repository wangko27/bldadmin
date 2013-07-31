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
	<script type="text/javascript">
		$().ready(function(){
			
			$("input[name='identity']").get(0).checked = true;//默认选择第一个单选框按钮
			$("input[name='identity']").click(function(){
				var checkValue = $("input[name='identity']:checked").val();
				var index = parseInt(checkValue) -1 ;
				$("#regDiv > div")    //选取子节点
					.eq(index).show()
					.siblings().hide();
			});
			
			$("#regSubmitBtn").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				var chk_length = $("input[name='identity']:checked").length;
				if(chk_length == 0){
					alert("请选择您的身份");
					return false;
				}
				var realname = $("#realname").val();
				if(realname == ""){
					alert("请填写真实姓名！");
					$("#realname").focus();
					return false;
				}
				var chk_sex = $("input[name='sex']:checked").length;
				if(chk_sex == 0){
					alert("请选择性别！");
					return false;
				}
				$("#updateInfoForm").attr("action","<%=basePath%>regUpdate.action");
				$("#updateInfoForm").submit();
				$("body").mask('正在为您更新资料，请稍后。。。');
			});
		
		});
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
    <form action="" method="post" id="updateInfoForm">
    <s:token></s:token>
    <div class="juzh_3">
      <div class="wans"><b>恭喜您，注册成功! 您的账户名为：${member.username}</b>
      <input  type="hidden" name="member.memberid" id="memberid" value="${memberId}"/>
      <input type="hidden" name="member.username" id="username" value="${username}"/>
      <input type="hidden" name="member.memberpassword" id="memberpassword" value="${password}"/>
        <p>为了您能在952116综合信息门户网上获得更好的使用体验，请首先完善下列资料。</p>
      </div>
      <div class="clia">
        <div class="ww">完善个人基本资料</div>
        <div class="dzi1">
          <ul>
            <li><span>*</span> 您的身份：</li>
            <li>
              <input name="identity" type="radio" value="1" />&nbsp;学生
            </li>
            <li>
              <input name="identity" type="radio" value="2" />&nbsp;家长
            </li>
            <li>
              <input name="identity" type="radio" value="3" />&nbsp;老师
            </li>
            <li>
              <input name="identity" type="radio" value="4" />&nbsp;其他
            </li>
          </ul>
        </div>
        <div class="rest_3">
          <ul>
            <li><span>*</span> 您的真实姓名：</li>
            <li class="inppbj">
              <input name="realname" id="realname" type="text" />
            </li>
          </ul>
        </div>
         <div class="dzi1">
          <ul>
            <li><span>*</span> 您的性别：</li>
           <li>
              <input name="sex" id="sex" type="radio" value="男" />&nbsp;&nbsp;男
            </li>
            <li>
              <input name="sex" id="sex" type="radio" value="女" />&nbsp;&nbsp;女
            </li>
          </ul>
        </div>
        <div class="rest_3">
          <ul>
            <li>您的所在地：</li>
          	<li class="inppbj"><input type="text" name="inaddr" id="inaddr" /> </li>
          </ul>
        </div>
      </div>
      <div id="regDiv">
      <div id="stuDiv" style="display:block">
      <div class="clia_1">
      	<div class="ww">完善班级资料1 <span><input name="" type="checkbox" value="" /> <b>暂不填写</b>（完善班级资料后，为我们提供信息，我们将为您提供更为优质的服务。）</span></div>
        <div class="zz">
            <div class="rest_6">
              <ul>
                <li> 所在学校：</li>
                <li class="inppbj">
                  <input name="stuschool" id="stuschool" type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_6">
              <ul>
                <li> 所在年级：</li>
                <li class="inppbj">
                  <input name="stugrade" id="stugrade"  type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_6">
              <ul>
                <li> 所在班级：</li>
                <li class="inppbj">
                  <input name="stuclasses" id="stuclasses" type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_5">非常感谢您完善了资料！</div>
        </div>
        <div class="ddz"><a href="#">查看已开通</a>数字校园业务的学校<p>如果您属于开通了的学校，可直接人工拨打<b>952116</b>定制我们的业务!</p></div>
      </div>
      </div>
      <div id="parentDiv" style="display:none">
	      <div class="clia_1">
	      	<div class="ww">完善班级资料2 <span><input name="" type="checkbox" value="" /> <b>暂不填写</b>（完善班级资料后，为我们提供信息，我们将为您提供更为优质的服务。）</span></div>
	        <div class="zz">
	            <div class="rest_6">
	              <ul>
	                <li> 孩子姓名：</li>
	                <li class="inppbj">
	                  <input name="childname" id="childname" type="text" />
	                </li>
	              </ul>
	            </div>
	            <div class="rest_6">
	              <ul>
	                <li> 孩子学校：</li>
	                <li class="inppbj">
	                  <input name="parentshool" id="parentshool" type="text" />
	                </li>
	              </ul>
	            </div>
	            <div class="rest_6">
	              <ul>
	                <li> 所在年级：</li>
	                <li class="inppbj">
	                  <input name="parentgrade" id="parentgrade" type="text" />
	                </li>
	              </ul>
	            </div>
	             <div class="rest_6">
	              <ul>
	                <li> 所在班级：</li>
	                <li class="inppbj">
	                  <input name="parentclasses" id="parentclasses" type="text" />
	                </li>
	              </ul>
	            </div>
	        </div>
	        <div class="ddz"><a href="#">查看已开通</a>数字校园业务的学校<p>如果您属于开通了的学校，可直接人工拨打<b>952116</b>定制我们的业务!</p></div>
	         <div class="rest_5">非常感谢您完善了资料！</div>
	      </div>
      </div>
       <div id="teacherDiv" style="display:none">
      <div class="clia_1">
      	<div class="ww">完善班级资料3 <span><input name="" type="checkbox" value="" /> <b>暂不填写</b>（完善班级资料后，为我们提供信息，我们将为您提供更为优质的服务。）</span></div>
        <div class="zz">
            <div class="rest_6">
              <ul>
                <li> 执教学校：</li>
                <li class="inppbj">
                  <input name="teacherschool" id="teacherschool" type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_6">
              <ul>
                <li> 所在年级：</li>
                <li class="inppbj">
                  <input name="teachergrade" id="teachergrade"  type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_6">
              <ul>
                <li> 班级名称：</li>
                <li class="inppbj">
                  <input name="teacherclasses" id="teacherclasses" type="text" />
                </li>
              </ul>
            </div>
            <div class="rest_5">非常感谢您完善了资料！</div>
        </div>
        <div class="ddz"><a href="#">查看已开通</a>数字校园业务的学校<p>如果您属于开通了的学校，可直接人工拨打<b>952116</b>定制我们的业务!</p></div>
      </div>
      </div>
      <div id="otherDiv" style="display:none"> </div>
      </div>
      <div class="dzi2"><img src="<%=basePath%>img/login/qq3.gif" width="168" height="38" id="regSubmitBtn" /></div>
    </div>
  </form>
  </div>
</div>
   <jsp:include page="footer.jsp"></jsp:include>
   <jsp:include page="/comm/message.jsp"></jsp:include>
  </body>
</html>
