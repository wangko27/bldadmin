<%@ page language="java"   import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<script language="javascript" src="<%=basePath%>js/ad.js"></script>
<script type="text/javascript">

		function onblurMood(obj){
			var objValue = obj.value;
			if(objValue == "可输入200个字"){
				obj.innerHTML  = "";
			}
		}

		$().ready(function(){
			$("#moodSubmitBtn").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				var moodContentValue = $("#moodContent").val();
				if(moodContentValue == ""){
					alert("请填写心情！");
					$("#moodContent").focus();
					return false;
				}
				if(moodContentValue.length > 200){
					alert("心情必须少于200字！");
					$("#moodContent").focus();
					return false;
				}
				$.ajax({
					url:"<%=basePath%>openzone/zoneIndexAction!ajaxAddMoods.action",
					type:"post",
					data:{moodtext:moodContentValue},
					success:function(msg){
						if(msg == 'exception'){
							alert("发表心情失败！请与管理员联系！");
							return ;
						}else{
							$(".xinqing").html(msg);
						}
					}
				});
			});
			
			
		  $("#emailSubmitBtn").hover(function(){
		  	$(this).css("cursor","hand");
		  }).click(function(){
		  	 var email = $("#email").val();
		  	 if(email == ""){
		  	 	alert("请填写您的邮箱地址！");
		  	 	$("#email").focus();
		  	 	return false;
		  	 }
		  	 var regEmail =/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i;
		     if(!regEmail.test(email)){
		     	alert("邮件格式不正确！");
		     	$("#email").focus();
		  	 	return false;
		     }
		     $.ajax({
					url:"<%=basePath%>member/memberLogin!addEmail.action",
					type:"post",
					dataType:"json",
					data:{email:email},
					success:function(msg){
						if(msg.status == 'success'){
							$("#addemaildiv").css("display","none");
						    alert(msg.message);
						}else{
							alert(msg.message);
							return;
						}
					}
				});
		  });
		  
		  $("#divcloseupd").hover(function(){
		  	$(this).css("cursor","hand");
		  }).click(function(){
		  	$("#addemaildiv").css("display","none");
		  });
		});
</script>
<div class="right">
   <div class="rzhong">
     <div class="xinqing">
     	<p>${mood.moodtext}</p><span><fmt:formatDate value="${mood.createdate}" pattern="yyyy-MM-dd HH:mm"/></span>
     </div>
     <div class="shukk">
       <ul>
         <li>
           <textarea name="mood.moodtext" id="moodContent" cols="" rows="" onfocus="onblurMood(this)">可输入200个字</textarea>
         </li>
         <!-- <li class="yutt"><a  class="ty">表情</a> <a  class="ty1">图片</a></li> -->
         <li class="yutt1"><img src="<%=basePath%>img/user_img/fb.gif" id="moodSubmitBtn" /></li>
       </ul>
     </div>
     <div class="dtai">
       <ul>
         <li class="bai"><a href ="<%=basePath%>openzone/zoneIndexAction!userCenterIndex.action">好友动态</a></li>
         <li><a href="<%=basePath%>openzone/zoneIndexAction!myself.action"> 我的动态</a></li>
         <c:if test="${sessionScope.loginMemberType eq 1}">
         	<li><a href="<%=basePath%>member/classDynamicAction!dynamic.action">班级动态 </a></li>
         </c:if>
       </ul>
     </div>
     <s:if test="#session.loginMemberEmail == null">
     <div class="tance" id="addemaildiv" >
            <ul>
            	<li><font color="red">温馨提示：请填写您的常用邮箱，方便您找回密码。</font></li>
              <li>
                <input name="" type="button" class="chaa"  id="divcloseupd"/>
              </li>
                <li>
               请输入您的常用邮箱：
               <input id="email" name="email" type="text"  style="float:none; width:200px;"/>
              </li>
              <li>
              <p align="center">
                <input name="emailSubmitBtn" type="button" id="emailSubmitBtn"  class="qqd" />
             </p>
              </li>
            </ul>
     </div>
    </s:if>
     <div class="dongtai">
     	
            
            <c:forEach items="${requestScope.listActionRecords}" var="record">
          	<c:choose>
          		<c:when test="${record.actiontype eq 1}">
          			<ul>
		            	<li class="tuuser">
		            	<c:choose>
          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
		            		<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
          				</c:when>
          				<c:otherwise>
			            	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
			            	<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
			            	</a>
          				</c:otherwise>
          				</c:choose>
		            	</li>
		                <li class="tuuser1">
		                	<p class="tuzi1">
		                	
		                	<c:choose>
	          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
			            		${record.username}
	          				</c:when>
	          				<c:otherwise>
			                	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
				            	${record.username}
			                	</a>
	          				</c:otherwise>
	          				</c:choose>
		                	
		                	${record.actiontitle}<a target="_blank" href="<%=basePath%>${record.otheractionpath1}">${record.album.albumname}</a></p>
		                    <p class="tuzi2"><a target="_blank" href="<%=basePath%>${record.otheractionpath2}"><img <c:if test="${not empty record.photo.photopath}">src="<%=basePath%>${record.photo.photopath}"</c:if> <c:if test="${empty record.photo.photopath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> /></a></p>
		                    <p class="time"><fmt:formatDate value="${record.actiondate}" pattern="yyyy-MM-dd HH:mm"/> </p>
		                </li>
           			</ul>
          		</c:when>
          		<c:when test="${record.actiontype eq 2}">
          			 <ul>
		            	<li class="tuuser">
		            	
		            	<c:choose>
          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
		            		<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
          				</c:when>
          				<c:otherwise>
			            	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
			            	<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
			            	</a>
          				</c:otherwise>
          				</c:choose>
		            	
		            	</li>
		                <li class="tuuser1">
		                	<p class="tuzi1">
		                	
		                	<c:choose>
	          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
			            		${record.username}
	          				</c:when>
	          				<c:otherwise>
			                	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
				            	${record.username}
			                	</a>
	          				</c:otherwise>
	          				</c:choose>
		                	
		                	${record.actiontitle}<a target="_blank" href="<%=basePath%>${record.otheractionpath1}"><c:if test="${fn:length(record.blog.blogtitle) > 20}">${record.blog.blogtitle}...</c:if><c:if test="${fn:length(record.blog.blogtitle) <= 20}">${record.blog.blogtitle}</c:if></a></p>
		                    <p class="tuzi2">${record.blog.blogcontent}</p>
		                    <p class="time"><fmt:formatDate value="${record.actiondate}" pattern="yyyy-MM-dd HH:mm"/></p>
		                </li>
		             </ul>
          		</c:when>
          		<c:when test="${record.actiontype eq 3}">
          			<ul>
		            	<li class="tuuser">
		            	
		            	
		            	<c:choose>
          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
		            		<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
          				</c:when>
          				<c:otherwise>
			            	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
			            	<img  <c:if test="${not empty record.member.headpath}">src="<%=basePath%>${record.member.headpath }"</c:if> <c:if test="${empty record.member.headpath}">src="<%=basePath%>img/user_img/imgmo.gif"</c:if> />
			            	</a>
          				</c:otherwise>
          				</c:choose>
		            	
		            	</li>
		                <li class="tuuser1">
		                	<p class="tuzi1">
		                	
		                	<c:choose>
	          				<c:when test="${record.member.memberid eq sessionScope.loginMemberId}">
			            		${record.username}
	          				</c:when>
	          				<c:otherwise>
			                	<a target="_blank" href="Zone/index.action?TTid=${record.member.memberid }">
				            	${record.username}
			                	</a>
	          				</c:otherwise>
	          				</c:choose>
		                	
		                	${record.actiontitle}<span>${record.mood.moodtext}</span></p>
		                    <p class="time"><fmt:formatDate value="${record.actiondate}" pattern="yyyy-MM-dd HH:mm"/></p>
		                </li>
		            </ul>
          		</c:when>
          	</c:choose>
            </c:forEach>
     </div>
   </div>
   
  	<!-- 右边 -->
        	<div class="ryou">
          		<div class="huid"><span>最近来访</span></div>
		          <div class="pople">
		            <ul>
		            <c:if test="${not empty visitList}">
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
 			  		</c:if>
		            </ul>
		          </div>
		          <div class="huid"><span>今日课题</span> <a href="learn/oneday_showOneDayOneText.action?liindex=1" target="_blank">更多</a></div>
		          <div class="lli">
		            <ul>
		            <c:if test="${not empty onetextList}">
 			  		<s:iterator value="onetextList" status="st" id = "onetext">
		              <li>[<a target="_blank" href="learn/readbook!list.action?subjectcode=${onetext.subjectCode.subjectcode }&subjectname=${onetext.subjectCode.subjectname }&liindex=5" class="lan">${onetext.subjectCode.subjectname }</a>]&nbsp;
		              <a target="_blank" href="learn/oneday_showOneDayInfo.action?liindex=1&readId=${onetext.readsrcid }">
		              <c:choose>
	           		  <c:when test="${fn:length(readsrctile)<12}">${readsrctile }</c:when>
	           		  <c:otherwise>${fn:substring(readsrctile,0,11)}...</c:otherwise> 
	           		  </c:choose>
		              </a></li>
 			  		</s:iterator>
 			  		</c:if>
		            </ul>
		          </div>
		          <div class="kumu">
		          
		          <s:action name="learnpublic!getSubjectCodeAll" executeResult="false"></s:action>
				  <s:iterator value="#request.list_subjictCode" id="sub" status="s">
				  <s:if test="#s.index != 0"> | </s:if>
					<a target="_blank" href="learn/readbook!list.action?subjectcode=${sub.subjectcode }&subjectname=${sub.subjectname }&liindex=5">${sub.subjectname}</a>
				  </s:iterator>
				  
		          </div>
		          
		          <div class="banner1"><img name="advertisement" title="user-index-a"  src="" width="272" height="124" /></div>
		          
		          <div class="huid"><span>博览群书</span> <a href="learn/readbook!list.action?liindex=5" target="_blank">更多</a></div>
		          <div class="tu_zi">
		            <c:if test="${not empty readBookList}">
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
	          					<span><fmt:formatNumber type="number" value="${readBookList[0].generalscore/readBookList[0].ratingnum }" maxFractionDigits="0"/> 分</span>
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
		          	</c:if>
		            <ul class="zi">
		            <c:if test="${not empty readBookList}">
	 			  	<s:iterator value="readBookList" status="st" id = "book2" begin="2" end="4">
		              <li> <a target="_blank" href="learn/readbook!view.action?readsrcid=${readsrcid }">
		              
		               <c:choose>
	           		  <c:when test="${fn:length(readsrctile)<13}">${readsrctile }</c:when>
	           		  <c:otherwise>${fn:substring(readsrctile,0,12)}...</c:otherwise> 
	           		  </c:choose>
		              </a></li>
		            </s:iterator>
		            </c:if>
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
	 			  		<a target="_blank" href="<%=basePath %>Article/getArticleById.action?id=${artic.articlesrcid }" title="${artic.articletitle }"><span>[${artic.articleType.articletypename
										}]</span> ${fn:substring(artic.articletitle,0,11) }
	 			  		</a>
	 			  		</li>
	 			  		</s:iterator>
						</c:otherwise>
						</c:choose>
	 			  		
		            </ul>
		          </div>
          		<div class="banner1"><img name="advertisement" title="user-index-b"  src="" width="272" height="124" /></div>
  </div>
