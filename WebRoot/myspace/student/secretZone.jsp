<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored = "false"%>
<%@ include file="../../comm/common_tag.jsp"%>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 秘密空间</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/mimi.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>comm/js/jquery-1.4.2.js"></script>
	 <script type="text/javascript">
		$().ready(function(){
			$("#msgcontent").click(function(){
				 var value = $(this).val();
				 if(value == "可输入200个字"){
				 	$(this).val("");
				 }
			
			});
			
			$("#btnmsg").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				var msgcontent = $("#msgcontent").val();
				if(msgcontent == "" || msgcontent == "可输入200个字"){
					alert("请输入留言内容！");
					$("#msgcontent").focus();
					return false;
				}
				$.ajax({
					url:"<%=basePath%>member/leavemessage.action",
					type:"post",
					dataType:"json",
					data:{msgcontent : msgcontent},
					success:function(msg){
						if(msg.status == "success"){
							window.location.href = "<%=basePath%>member/secretZoneAction!list.action";
						}else{
							alert(msg.message);
						}
					}
				});
			});
			
			$("p.p2").hover(function(){
				$(this).css("cursor","hand");
			}).click(function(){
				var index = $("p.p2").index(this); 
				$(".tan1").eq(index)
				.show().siblings("div").hide();
			});
		});
		
		/**回复留言*/
		function reback(formid,areaid){
			var areaValue = document.getElementById(areaid).value;
			if(areaValue == "" || areaValue == "我也说一句"){
				alert("请输入留言内容！");
				document.getElementById(areaid).focus();
				return false;
			}
			document.getElementById(formid).submit();
			return false;
		}
		
		function cleanValue(obj){
			if(obj.value == "我也说一句"){
				obj.innerHTML = "";
			}
		}
		
		function displayDiv(id){
			var $div_table = $("div.tan1")
			alert($div_table.length);
			$("#"+id).show().siblings().hide(); 
		}
	  </script>
  </head>
  <body>
<jsp:include page="../header.jsp"></jsp:include>
   <div class="mainbody_1">
  <div class="dde">
    <div class="right_1">
      <div class="bobti">秘密空间</div>
      <div class="shukk">
        <ul>
          <li>
            <textarea name="textarea" name="msgcontent" id="msgcontent" cols="" rows="" class="ssk">可输入200个字</textarea>
          </li>
          <li class="yutt"><img  src="<%=basePath%>img/user_img/fb.gif" id="btnmsg" style="float:right" /></li>
        </ul>
      </div>
     
      <div class="mes_1">
      </div>
      <c:forEach items="${result.content}" var="mimiInfo">
      <form  action="<%=basePath%>member/revert.action" method="post" id="form_${mimiInfo.msgid}">
      <s:token></s:token>
      <input type="hidden" name="msgid" id="msgid" value="${mimiInfo.msgid}"/>
      <div class="mes_2">
        <div class="mestou"> <a href="Zone/index.action?TTid=${mimiInfo.sendmember.memberid}"><img  <c:if test="${empty mimiInfo.sendmember.headpath}">src="<%=basePath%>img/user_img/usbj.gif"</c:if> <c:if test="${not empty mimiInfo.sendmember.headpath}">src="<%=basePath%>${mimiInfo.sendmember.headpath}"</c:if> width="51" height="51" /></a></div>
        <div class="messl">
          <table width="840" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><p class="p1"><a href="Zone/index.action?TTid=${mimiInfo.sendmember.memberid}">${mimiInfo.sendmember.nikename}</a> <span> <c:if test="${not empty mimiInfo.msgdate}"><fmt:formatDate value="${mimiInfo.msgdate}" pattern="yyyy-MM-dd HH:mm:ss"/>  </c:if> </span></p>
                <p class="p2"><font color="#0b5ea4">回复</font></p>
              </td>
            </tr>
            <tr>
              <td >${mimiInfo.msgcontent}</td>
            </tr>
          </table>
          <div class="tan">
           <c:forEach items="${mimiInfo.list}" var="remimi" >
            <ul>
              <li class="tou"><a href="Zone/index.action?TTid=${remimi.sendmember.memberid}"><img <c:if test="${empty remimi.sendmember.headpath}">src="<%=basePath%>img/user_img/usbj.gif"</c:if> <c:if test="${not empty remimi.sendmember.headpath}">src="<%=basePath%>${remimi.sendmember.headpath}"</c:if> width="40" height="40"/></a></li>
              <li>
                <dl>
                  <dt><a href="Zone/index.action?TTid=${remimi.sendmember.memberid}">${remimi.sendmember.nikename}</a> <span><c:if test="${not empty remimi.remsgdate}"><fmt:formatDate value="${remimi.remsgdate}" pattern="yyyy-MM-dd HH:mm:ss"/>  </c:if></span></dt>
                  <dd>${remimi.remsgcontent}</dd>
                </dl>
              </li>
            </ul>
           </c:forEach>
           <!-- <div class="tan" style="display:lock" id="divtxt_${mimiInfo.msgid}">
	           <table width="840" border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td><p class="p1"> <span> <input type="text" name="txt_${mimiInfo.msgid}"  onfocus="leavemessagefocus('divtxt_${mimiInfo.msgid}','divtbl_${mimiInfo.msgid}')"  id="txt_${remimi.remsgid}" style="font-family: 宋体; color: gray;height: 20px; width: 395px;" value="我也说一句"/></span></p>
	                </td>
	            </tr>
	          </table>
           </div> -->
           <div class="tan1" style="display:none" id="replay_${mimiInfo.msgid}">
            <table width="384" class="se" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="10"></td>
              </tr>
              <tr>
                <td><textarea name="leavemsg_${mimiInfo.msgid}" style="color:gray" cols="" rows="" id="leavemsg_${mimiInfo.msgid}" onfocus="cleanValue(this)"  class="tex">我也说一句</textarea></td>
              </tr>
              <tr>
                <td><input name="submit_${mimiInfo.msgid}" type="button" id="submit_${mimiInfo.msgid}" onclick="reback('form_${mimiInfo.msgid}','leavemsg_${mimiInfo.msgid}')"  value="发表" onmouseover="javascript:this.style.cursor='hand'" class="quedd"/>
                 </td>
              </tr>
            </table>
            </div>
          </div>
        </div>
      </div>
      </form>
      </c:forEach>
      <div class="mes_1">
        <div class="titt">(共<c:if test="${empty totalcount}">0</c:if><c:if test="${not empty totalcount}">${totalcount}</c:if>条留言)</div>
         <div class="page" style="float:right">
          <form action="member/secretZoneAction!list.action" method="post" id="mimiForm2">
            <t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="mimiForm2"></t:tpage>
          </form>      
         </div>
      </div>
      
     </div>
   </div>
  </div>
   <jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>
