<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-留言</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/message.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
	//<![CDATA[
	window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
	//]]>
	</script>
	<script type="text/javascript"
		src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V">
	</script>
	<script type="text/javascript">
	$().ready(function() {
	
		//事件 发表留言
		$("#addmsg").click(function(){
			$("#formmsg").submit();
		});
		
		
	});
	
	function subRemsg(formid){
		$(formid).submit();
	}
	
	function showretable(tableid){
		$(tableid).css("display","block");
	}
	
	function closeretable(tableid){
		$(tableid).css("display","none");
	}
	</script>
  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/myspace/header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		  <!-- 用户中心中部左边菜单栏 -->
		  <jsp:include page="/myspace/content_leftmenu.jsp"></jsp:include>
		  <!-- 用户中心中部右边内容详细页 -->
	      <div class="right">
	      	
        	<div class="bobti">留言板</div>
        	<form action="myspace/comm/msgAdd.action?recmid=${sessionScope.loginMemberId }&recmnikename=${sessionScope.loginMemberNikename }" id="formmsg" method="post">
	        <s:token></s:token>
	        <div class="shukk">
	          <ul>
	            <li>
	              <textarea id="pcomment" name="msg.msgcontent" cols="" rows="" class="ssk">可输入200个字</textarea>
					<script type="text/javascript">
					//<![CDATA[
					CKEDITOR.replace('pcomment',{
						toolbar :
						[
							['Smiley']
						]
					});
					//]]>
					</script>
	            </li>
	            
            	<li><img id="addmsg"  style="float:right" src="img/user_img/fb.gif" /></li>
	          </ul>
	        </div>
	        </form>
	        <div class="mes_1">
	          <div class="titt">(共${result.page.totalCount}条留言)</div>
	        </div>
	        
	        <!-- 处理留言数据 -->
	        <s:iterator value="msgList" status="st" id = "msg">
	        <div class="mes_2">
	          <div class="mestou"> <a href="Zone/index.action?TTid=${memberBySenduserid.memberid}"><img src="${memberBySenduserid.headpath }" onerror="this.src='userspacefile/default/imgmo.gif'" width="51" height="51" /></a></div>
	          <div class="messl">
	            <table width="640" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td><p class="p1"><a href="Zone/index.action?TTid=${memberBySenduserid.memberid}">${sendusername }</a> <span><fmt:formatDate value="${msgdate}" pattern="yyyy-MM-dd HH:mm:ss"/></span></p>
	                  <p class="p2"><a href="javascript:showretable('#retable${st.count}');">回复</a></p></td>
	              </tr>
	              <tr>
	                <td >${msgcontent }</td>
	              </tr>
	            </table>
	            <div class="tan">
	            <!-- 回复 -->
				<s:iterator value="remsgs" status="rest" id = "remsg">
	              <ul>
	                <li class="tou"><a href="Zone/index.action?TTid=${remsg.memberBySenduserid.memberid}"><img src="${remsg.memberBySenduserid.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'" /></a></li>
	                <li>
	                  <dl>
	                    <dt><a href="Zone/index.action?TTid=${remsg.memberBySenduserid.memberid}">${sendusername }</a> <span><fmt:formatDate value="${remsg.remsgdate}" pattern="yyyy-MM-dd HH:mm:ss"/></span></dt>
	                    <dd>${remsg.remsgcontent }</dd>
	                  </dl>
	                </li>
	              </ul>
				</s:iterator>
	              
	            <form action="myspace/comm/remsgAdd.action?msg.msgid=${msgid }" id="form${st.count }" method="post">
	               <s:token></s:token>
	               <table width="384" class="se" border="0" cellspacing="0" cellpadding="0" id="retable${st.count}" style="display:none;">
	                
	                <tr>
	                  <td><textarea name="remsg.remsgcontent" cols="" rows="" class="tex"></textarea></td>
	                </tr>
	                <tr>
	                  <td><input name="" type="button" onclick="subRemsg('#form${st.count }');" value="确定" class="quedd"/> <a href="javascript:closeretable('#retable${st.count}');" class="qqx">取消</a></td>
	                </tr>
	              </table>
	            </form>
	            </div>
	          </div>
	        </div>
	        </s:iterator>
	        
	        <div class="mes_1">
	          <div class="titt">(共${result.page.totalCount}条留言)</div>
	          
				<s:if test="result != null">
		        <form action="myspace/comm/msgList.action" id="formpage" method="post">
		        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
		        </form>
		        </s:if>
	        </div>
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
  	
	<!-- 消息提示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
