<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="css/mshimain.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
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
				
				//分享
				$("#a_share").bind("click",function(){
					//文章ID
					var articleid='${article.articleid}';
					$.ajax({
						type:"post",
						url:"Article/SysShare.action",
						data:{articleid:articleid},
						dataType:"text",
						success:function(msg){
							if(msg==1){
								alert("分享成功!");
                                var clipBoardContent=document.location; 
								clipBoardContent+='\r\n'; 
								window.clipboardData.setData("Text",clipBoardContent); 
								alert("耶！复制成功喽！按 ctrl+V 把地址发给 MSN,QQ上的好朋友呀！再次感谢你对952116综合信息门户网的支持哦！"); 	
								
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
				
				//收藏
				$("#a_collect").bind("click",function(){
					//博览群书ID
					var articleid='${article.articleid}';
					$.ajax({
						type:"post",
						url:"Article/SysCollect.action",
						data:{articleid:articleid},
						dataType:"text",
						success:function(msg){
							if(msg==1){
								alert("收藏成功!");
							}else if(msg==-1){
								alert("请先登录!");
							}else if(msg==-2){
								alert("你已经收藏过了!");
							}else{
								alert("程序内部异常!");
							}
						},
						error:function(xhr,msg,e){
							alert(articleid);
						}
					});
					return false;
				});
			});
		</script>	
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="<%=basePath%>Article/Show_News_Index.action">资讯</a> >系统公告 <span></span></div>
</div>
<div class="mainbody">
  <div class="listbig">
    <div class="listleft">
    
      <div class="maind_1">${fn:substring(article.articletitle , 0,30)}<s:if test="%{articletitle.length()>30}">...</s:if></div>
      <div class="maind_2">
      	<span class="s1"><fmt:formatDate value="${article.createdate}" pattern="yyyy-MM-dd"/></span>     
		<span class="s2"><a id="a_share"><img src="img/learning_img/fen_1.gif" /></a>${ article.sharenum}</span>
       	<span class="s3"><a id="a_collect"><img src="img/learning_img/fen_2.gif" /></a>${article.collectionnum }</span>
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
      <div class="maind_4">
        <ul>
        <c:if test="${not empty articleList}">
          <c:forEach items="${articleList}" var="row">
          	<li><a href="<%=basePath %>Article/viewSysById.action?id=${row.articleid}">${row.articletitle}</a> <span><fmt:formatDate value="${row.createdate}" pattern="yyyy-MM-dd"/></span></li>
          </c:forEach>
       </c:if>
        </ul>
      </div>
    </div>
    	<jsp:include page="news_right.jsp"></jsp:include>
  </div>
</div>
<div class="mainbody">
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</div>
</body>
</html>
