<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!他人空间-首页</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/zuo.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script src="<%=basePath%>learn/teacherbema/js/xing.js"></script>
	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
	
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
	
	</script>

  </head>
  
  <body>
  	<!-- 头 -->
    <jsp:include page="/Zone/header.jsp"></jsp:include> 
    
    <div class="mainbody_1">
	  	<div class="dde">
	    <div class="uuop">
		    <!-- 他人空间中部左边菜单栏 -->
		    <jsp:include page="/Zone/content_leftmenu.jsp"></jsp:include>
		    <!-- 他人空间中部右边内容详细页 -->
	      <div class="right">
	        
	        <!-- 中间 -->
        	<div class="rzhong">
          		<div class="xxqing">
            		<ul>
		              <li class="xq"><b>他的心情：</b></li>
		              <li class="xqc">${mood.moodtext }</li>
		            </ul>
          		</div>
		          <div class="xcc">
		          	<p class="pcu">他的相册：</p>
		            <ul>
		            
 			  		<s:iterator value="photoList" status="st" id = "photo">
 			  			<li>
	 			  			<a href="Zone/photoDetail.action?TTid=${TTid }&albumid_p=${albums.albumid }">
	 			  				<img src="${photopath }" width="100" height="68" />
	 			  			</a>
 			  			</li>
 			  		</s:iterator>
		            
		            </ul>
		            <p class="mmg"><a href="Zone/albumList.action?TTid=${TTid }">查看更多</a></p>
		          </div>
		          <div class="llyan"><span>给他留言：</span> <a href="Zone/msgList.action?TTid=${TTid }">更多留言</a></div>
		          
		        	<form action="Zone/msgAdd.action?TTid=${TTid }" id="formmsg" method="post">
			        <s:token></s:token>
			        <div class="shukk">
		            <ul>
		              <li>
		                <textarea id="pcomment" name="msg.msgcontent" cols="" rows="">可输入200个字</textarea>
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
		              <li class="yutt"></li>
		              <li class="yutt1"><img id="addmsg"  src="img/user_img/fb.gif" /></li>
		            </ul>
		          </div>
	        	</form>
	        
		          <div class="dtai">
		            <ul>
		              <li class="bai">他的动态</li>
		            </ul>
		          </div>
		          <div class="dongtai">
		          
 			  		<s:iterator value="actionRecList" status="st" id = "actionrec">
 			  		 <ul>
		              <li class="tuuser"><img src="${member.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'" /></li>
		              <li class="tuuser1">
		                <p class="tuzi1">${username}${actiontitle }
		               
		                <s:if test="actiontype == 1">
			                <a href="Zone/photoOfAlbum.action?albumid=${album.albumid }&TTid=${TTid }">${album.albumname}</a></p>
			                
	                		<p class="tuzi2"><a href="Zone/photoDetail.action?TTid=${TTid }&albumid_p=${album.albumid }"><img src="${photo.photopath }" /></a></p>
		                </s:if>
		                
		                <s:elseif test="actiontype == 2">
		                
			                <a href="${otheractionpath1 }">${blog.blogtitle}</a></p>
	                		<p class="tuzi2">${blog.blogcontent }</p>
		                </s:elseif>
		                
		                <s:elseif test="actiontype == 3">
		                	<span>${mood.moodtext}</span></p>
		                </s:elseif>
		                
		                </p>
		                <p class="time">${actiondate }</p>
		              </li>
		            </ul>
 			  		</s:iterator>
 			  		
		          </div>
        	</div>
        	
        	<!-- 右边 -->
        	<div class="ryou">
          		<div class="huid"><span>最近来访</span></div>
		          <div class="pople">
		            <ul>
		            
 			  		<s:iterator value="visitList" status="st" id = "vis">
 			  		  <li>
		                <p class="img50"> <a target="_blank" href="Zone/index.action?TTid=${memberByVisitorsuserid.memberid}"><img src="${visitorspicture }"  onerror="this.src='userspacefile/default/imgmo.gif'"  /></a></p>
		                <p> <a target="_blank" href="Zone/index.action?TTid=${memberByVisitorsuserid.memberid}">${visitorsusername }</a></p>
		                <p><fmt:formatDate value="${visitdate}" pattern="yy-MM"/></p>
		              </li>
		              <s:if test="st.index == 2">
			            </ul>
			            <ul>
		              </s:if>
 			  		</s:iterator>
		            </ul>
		          </div>
		          <div class="huid"><span>今日课题</span> <a href="learn/oneday_showOneDayOneText.action?liindex=1" target="_blank">更多</a></div>
		          <div class="lli">
		            <ul>
		            
 			  		<s:iterator value="onetextList" status="st" id = "onetext">
		              <li>[<a target="_blank" href="learn/readbook!list.action?subjectcode=${onetext.subjectCode.subjectcode }&subjectname=${onetext.subjectCode.subjectname }&liindex=5" class="lan">${onetext.subjectCode.subjectname }</a>]&nbsp;
		              <a target="_blank" href="learn/oneday_showOneDayInfo.action?liindex=1&readId=${onetext.readsrcid }">
		              <c:choose>
	           		  <c:when test="${fn:length(readsrctile)<12}">${readsrctile }</c:when>
	           		  <c:otherwise>${fn:substring(readsrctile,0,11)}...</c:otherwise> 
	           		  </c:choose>
		              </a></li>
 			  		</s:iterator>
		            </ul>
		          </div>
		          <div class="kumu">
		          <s:action name="learnpublic!getSubjectCodeAll" executeResult="false"></s:action>
				  <s:iterator value="#request.list_subjictCode" id="sub" status="s">
				  <s:if test="#s.index != 0"> | </s:if>
					<a target="_blank" href="learn/readbook!list.action?subjectcode=${sub.subjectcode }&subjectname=${sub.subjectname }&liindex=5">${sub.subjectname}</a>
				  </s:iterator>
		          
		          </div>
		          
		          
		          <div class="banner1"><img name="advertisement" title="other-index-a"  src="" width="272" height="124" /></div>
		          
		          <div class="huid"><span>博览群书</span> <a href="learn/readbook!list.action?liindex=5" target="_blank">更多</a></div>
		          <div class="tu_zi">
		          
	 			  	<s:iterator value="readBookList" status="st" id = "book" begin="0" end="1">
	 			  	 <ul>
		              <li class="img_1"><a target="_blank" href="learn/readbook!view.action?readsrcid=${readsrcid }"><img src="${photopath }" /></a></li>
		              <li class="yu"><span><a target="_blank" href="learn/readbook!list.action?subjectcode=${subjectCode.subjectcode }&subjectname=${subjectCode.subjectname }&liindex=5">[${subjectCode.subjectname }]</a></span> <a href="learn/readbook!view.action?readsrcid=${readsrcid }">${readsrctile }</a></li>
		              <s:if test="#st.index == 0">
						<li id="li1">
						<script>
	          				showXin('li1',${(readBookList[0].generalscore==null ? 0:readBookList[0].generalscore)/readBookList[0].ratingnum },'<%=basePath%>');
	          			</script>
	          			<c:choose>
	          				<c:when test="${readBookList[0].ratingnum==0}">
	          					<span>0分</span>
	          				</c:when>
	          				<c:otherwise>
	          					<span><fmt:formatNumber type="number" value="${readBookList[0].generalscore/readBookList[0].ratingnum }" maxFractionDigits="0"/>分</span>
	          				</c:otherwise>
	          			</c:choose>
						</li>
		              </s:if>
		              <s:elseif test="#st.index == 1">
						<li id="li2">
							<script>
					          	showXin('li2',${(readBookList[1].generalscore==null ? 0:readBookList[1].generalscore)/readBookList[1].ratingnum },'<%=basePath%>');
					          </script>
							<c:choose>
	          				<c:when test="${readBookList[1].ratingnum==0}">
	          					<span>0分</span>
	          				</c:when>
	          				<c:otherwise> 
	          					<span><fmt:formatNumber type="number" value="${readBookList[1].generalscore/readBookList[1].ratingnum }" maxFractionDigits="0"/>分</span>
	          				</c:otherwise>
	          			</c:choose>
						</li>
		              </s:elseif>
		              <li class="xia"><a target="_blank" href="learn/readbook!view.action?readsrcid=${readsrcid }"><img src="img/common_img/xiazai.gif" /></a></li>
		            
		            </ul>
		          	</s:iterator>
		          	
		          	
		            <ul class="zi">
		            
	 			  	<s:iterator value="readBookList" status="st" id = "book2" begin="2" end="4">
		              <li> <a href="learn/readbook!view.action?readsrcid=${readsrcid }">
		              
		               <c:choose>
	           		  <c:when test="${fn:length(readsrctile)<13}">${readsrctile }</c:when>
	           		  <c:otherwise>${fn:substring(readsrctile,0,12)}...</c:otherwise> 
	           		  </c:choose>
		              </a></li>
		            </s:iterator>
		            </ul>
		            
		          </div>
		          
		          <div class="huid"><span>生活百科</span> <a href="Article/list.action?id=8a80818c31bb7cc50131bb7fbde70002" target="_blank">更多</a></div>
		          <div class="lli">
		            <ul>
		            	<c:choose>
						<c:when test="${empty liveList}">暂无生活百科</c:when>
						<c:otherwise>
						<s:iterator value="liveList" status="st" id = "artic">
	 			  		
	 			  		<li>
	 			  		<a href="<%=basePath %>Article/getArticleById.action?id=${artic.articlesrcid }" title="${artic.articletitle }"><span>[${artic.articleType.articletypename
										}]</span> ${fn:substring(artic.articletitle,0,11) }
	 			  		</a>
	 			  		</li>
	 			  		</s:iterator>
						</c:otherwise>
						</c:choose>
	 			  		
		            </ul>
		          </div>
		          
          		<div class="banner1"><img name="advertisement" title="other-index-b"  src="" width="272" height="124" /></div>
       	 	</div>
	        
	      </div>
	    </div>
	  	</div>
    </div>
	<!-- 底 -->
    <jsp:include page="/Zone/footer.jsp"></jsp:include> 
	
  	
	<!-- 信息显示 -->
  	<jsp:include page="/comm/message.jsp"></jsp:include> 
  </body>
</html>
