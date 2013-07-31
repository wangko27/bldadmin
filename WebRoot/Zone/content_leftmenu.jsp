<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"  isELIgnored="false"%>
<%@ include file="../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css" media="screen">
	.tance {
		width:300px;
		background:#fff;
		height:150px;
		border:3px solid #a2d0ff;
		position:absolute;
		top:50%;
		left:50%;
		margin:-75px 0px 0px -150px;
	}
	.tance ul {
		padding:10px 0px 10px 50px;
		width:230px;
		border:none;
	}
	.tance ul li {
		float:left;
		width:230px;
		padding:5px 0px;
	}
	.tance ul li select {
		width:150px;
	}
	input.chaa {
		background:url(img/user_img/uy1.gif);
		border:none;
		width:18px;
		height:18px;
		float:right
	}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
		
			//关闭弹出层
			$("#divclose").click(function(){
				$("#divindex").css("display","none");
			});
			//提交添加好友的表单
			$("#sub2").click(function(){
				$("#divindex").css("display","none");
				$("#form2").submit();
			});
		});
		function showdiv(id,name){
			$("#divindex").css("display","block");
			$("#divname").html(name);
			
			$("#friid").val(id);
			$("#frinikename").val(name);
			
			//获得好友分类
			if($("#fritype option").length == 0){
				$.ajax({
					type:"post",
					url:"myspace/comm/ajaxFriendTypeList.action",
					dataType:"text",
					success:function(msg){
						$("#fritype option").remove();
						$(msg).appendTo("#fritype");
						
						if(msg == 'exception'){
							alert("error");
						}
					},
					error:function(xhr,msg,e){
						alert("error");
					}
				});
			}
		}
	</script>
<div class="left">
  <div class="ru1"> <img src="${TTUser.headpath }"  onerror="this.src='userspacefile/default/imgmo.gif'" />
    <p><b>${TTUser.nikename }个人空间</b><br />
    <s:if test="!friendsign">
    <a href="javascript:showdiv('${TTUser.memberid }','${TTUser.nikename }');"><img src="img/user_img/kkk.gif" width="80" height="24" /></a>
    </s:if>
    </p>
  </div>
  <div class="ru2">
    <ul>
      <li><a href="Zone/blogList.action?TTid=${TTid }" class="bj1">博文</a> </li>
    </ul>
    <ul>
      <li><a href="Zone/albumList.action?TTid=${TTid }" class="bj2">相册</a> </li>
    </ul>
    <ul>
      <li><a href="Zone/msgList.action?TTid=${TTid }" class="bj4">留言板</a></li>
    </ul>
    <ul>
      <li><a href="Zone/userinfo.action?TTid=${TTid }" class="bj4_1">他的资料</a></li>
    </ul>
  </div>
  
  
	         <div class="tance" id="divindex" style="display:none">
	         	<form action="myspace/comm/friendAdd.action" id="form2" method="post">
	         	<s:token></s:token>
	         	
	         	<input type="hidden" id="friid" name="mfriend.memberid" />
	         	<input type="hidden" id="frinikename" name="mfriend.nikename" />
                <ul>
                  <li>
                    <input name="" type="button" class="chaa" id="divclose"/>
                  </li>
                  <li>您把“<span id="divname"></span>”添加到：</li>
                  <li>
                    <select name="typeid" id="fritype">
		        		<s:iterator value="typeList" status="st" id = "type">
	                      <option value="${friendtypeid }">${friendtypename }</option>
		        		</s:iterator>
                    </select>
                  </li>
                  <li>
                    <input name="sub2" type="button" id="sub2" value="确&nbsp;&nbsp;&nbsp;&nbsp;定" />
                  </li>
                </ul>
                </form>
              </div>
              
</div>