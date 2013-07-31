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
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-我的作品管理</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/ziyuan.css" rel="stylesheet" type="text/css" />


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
	        
	        <div class="bobti">品学论道</div>
	        <div class="dtai">
	          <ul>
	          </ul>
	        </div>
	        <div class="ziyuan">
	        	<h1>温馨提示：请勿在未经授权的情况下，上传任何可能涉及侵权的信息资料（包括文本、图形、链接，查询数据等），上传的所有文档内容符合中国法律法规和规范性文件的相关规定。转载的信息资料，请注明来源，并确保不侵犯任何第三方的合法权益。<br />
	        	</h1>
	        	<h1>
	        	<a href="myspace/comm/treasure/studyadd.jsp"><img src="img/user_img/zz.gif" width="80" height="24" /></a>
	        	</h1>
	          <table width="200" border="0" cellspacing="0" cellpadding="0">
	            <tr class="lase">
	              <td class="k1">标题</td>
	              <td class="k2">用户推荐数</td>
	              <td class="k2">状态</td>
	              <td class="k3">上传时间</td>
	              <td class="k3">操作</td>
	            </tr>
	            
 			  	<s:iterator value="studyList" status="st" id = "study">
	             <tr>
	              <td class="k1">${articletitle }</td>
	              <td class="k2">${userpushnum }</td>
	              <td 
		              <s:if test='isrecommend == "0"'> class="sz"</s:if>
		              <s:elseif test='isrecommend == "1"'> class="kt"</s:elseif>
		              <s:else> class="k2"</s:else>
	              >
		              <s:if test='isrecommend == "0"'>编辑未推荐</s:if>
		              <s:elseif test='isrecommend == "1"'>编辑已推荐</s:elseif>
	              </td>
	              <td class="k3"><fmt:formatDate value="${createdate}" pattern="yyyy-MM-dd"/></td>
		          <td class="k3">
		              <a href="myspace/comm/mStudyUpdGo.action?studyid=${articlesrcid }" >修改</a> | 
		              <a href="myspace/comm/mStudyDel.action?studyid=${articlesrcid }"  onClick="return(confirm('確定刪除?'))">删除</a>
		              </td>
		          </tr>
	            </s:iterator>
	          </table>
	        </div>
	        
	        
			<s:if test="result != null">
	        <form action="myspace/comm/mStudyList.action" id="formpage" method="post">
	        	<t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
	        </form>
	        </s:if>
	        
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/myspace/footer.jsp"></jsp:include> 
	<!-- 消息 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 

  </body>
</html>
