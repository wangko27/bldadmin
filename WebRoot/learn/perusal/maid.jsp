<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/learning_common.css" rel="stylesheet" type="text/css" />
<link href="../css/mshimain.css" rel="stylesheet" type="text/css" />  
<script type="text/javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" >
			var ind=0;
			function showcontent(index){
				$("div[id^='content']").each(function(i){
					if(index==i){
						$(this).show();
					}else{
						$(this).hide();
					}
				});
				return false;
			}
			function toUp(){
						ind--;
						if(ind<0){
							ind=0;
						}
						showcontent(ind);
						return false;
					}
			function toDown(len){
				 ind++;
				 if(ind>len-1){
					 	ind=len-1;
					}
				showcontent(ind);
				return false;
				}

				
			$().ready(function(){
				
				//推荐
				$("#a_share").bind("click",function(){
					//文章ID
					var articlesrcid='${articleSrc.articlesrcid}';
					$.ajax({
						type:"post",
						url:"learn/PerusalArticle!Share.action",
						data:{articlesrcid:articlesrcid},
						dataType:"text",
						success:function(msg){
							if(msg==1){
								alert("推荐成功!"); 	
							}else if(msg==-1){
								alert("请先登录!");
							}else{
								alert("程序内部异常!");
							}
						},
						error:function(xhr,msg,e){
							alert("error");
						}
					});
					return false;
				});
			});
		</script>	
</head>
<body>
		<jsp:include page="/learn/top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="learn/xx_index.action">学习频道</a> > <span><a href="learn/pinxue_showPinXue.action?liindex=2">品学论道</a></span>> <span>${ articleSrc.articletitle}</span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
    	<c:if test="${empty articleSrc}">
    		暂无数据
    	</c:if>
    	<c:if test="${not empty articleSrc}">
      <div class="maind_1">${ articleSrc.articletitle}</div>
      <div class="maind_2"><span class="s1"><fmt:formatDate value="${articleSrc.createdate}" pattern="yyyy-MM-dd"/></span> <span class="s2">
      	<a href="#" id="a_share"><img src="img/learning_img/fen_3.gif" /></a>${articleSrc.userpushnum}</span>
      </div>
      <div class="maind_3">
      
      	<div class="ppmm">  	
        	  <p>
      		<c:forEach items="${content}" var="con" varStatus="index">
									<c:choose>
										<c:when test="${index.index==0}">
											<div id="content${index.index }">
												${con }
											</div>
										</c:when>
										<c:otherwise>
											<div id="content${index.index }" style="display: none">
												${con }
											</div>
										</c:otherwise>
									</c:choose>
								</c:forEach>
      	</p>
        </div>
        <div class="page">
		<ul>
				<li>
					<a href="#" onclick="return showcontent(0)">首页</a>
				</li>
				<li>
					<a href="#" onclick="return toUp()">上一页</a>
				</li>
				<c:forEach begin="1" end="${srclength}" var="showindex" varStatus="ind">
				<li>
					<a href="#" onclick="return showcontent(${ind.index-1 })">${showindex }</a>
				</li>
				</c:forEach>
				<li>
					<a href="#" onclick="return toDown(${srclength})">下一页</a>
				</li>
				<li>
					<a href="#" onclick="return showcontent(${srclength-1 })">尾页</a>
				</li>
		</ul>
        </div>
      </div>
      </c:if>
      <div class="maind_4">
      <c:if test="${empty articleList}">
      	暂无数据
      </c:if>
      <c:if test="${ not empty articleList}">
        <ul>
          <li class="bbt">相关阅读：</li>
         <c:forEach items="${articleList}" var="row" varStatus="vs">
          <li><a href="<%=basePath%>learn/PerusalArticle!getArticleById.action?id=${row.articlesrcid}&liindex=2">${row.articletitle}</a> <span><fmt:formatDate value="${row.createdate}" pattern="yyyy-MM-dd"/></span></li>
          </c:forEach>     
        </ul>
        </c:if>
      </div>
    </div>
				<jsp:include page="/learn/right.jsp"></jsp:include>
    </div>
  </div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>
