<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!他人空间-照片列表</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/pohto.css" rel="stylesheet" type="text/css" />

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
	$(document).ready(function() {
	
		//事件 发表留言
		$("#addcomment").click(function(){
			//取得ckedit中的内容
		    var oEditor = CKEDITOR.instances.pcomment;
		    var comdata = oEditor.getData();
		    
			var $albumid = $("#albumid");
			var $comcontent = comdata;
			var comnum = Number($("#comnum").text())+1;
			
			$.ajax({
				type:"post",
				url:"<%=basePath%>myspace/comm/albumCommAdd.action",
				data:{albumid:$albumid.val(),comcontent:$comcontent},
				dataType : "html",
				success : function(data){
				
					if(data == "exception"){	
						alert("请登录!");
					}else{					    
						//输入框复位
					    oEditor.setData("我也来评论，左边的头像是要发表评论的用户头像");
					    //修改留言条数
					    $("#comnum").html(comnum);
						//更新留言数据
						$("#form1").html(data);
						alert("留言成功!");
					}
				  }
			});
		});
	});
	
	</script>
	<script type="text/javascript">
	//点击回复
	function hffunction(hftable){
		if($("#"+hftable).css("display") == "none"){
			$("#"+hftable).css("display","");
		}
		else{
			$("#"+hftable).css("display","none");
		}
	}
	//回复提交
	//comm:内容ID存放容器ID
	//comid:所回复的留言的Id 
	function hfsubmit(comm,comid){
		//设置提交回复的内容

		var $albumid = $("#albumid");
		var $comcontent = $("#"+comm);
		
		$.ajax({
			type:"post",
			url:"<%=basePath%>myspace/comm/albumCommAdd.action",
			data:{albumid:$albumid.val(),comcontent:$comcontent.val(),comid:comid},
			dataType : "html",
			success : function(data){
			
				if(data == "exception"){	
					alert("留言失败,请稍后!");
				}else{
					$("#form1").html(data);
				}
			  }
		});
	}
	//查看图片详情
	function photodetail(index){
		$('#gotoPagephoto').val(index);
		$('#formphoto').submit();
	}
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
	        <div class="bobti">他的相册</div>
	        <div class="lujin"> <a href="Zone/albumList.action?TTid=${TTid }">他的相册</a> > <b>${album.albumname }</b> </div>
	        <div class="poth_1">
	          <ul>
	            <li class="tm"><b>${album.albumname }</b> (共${album.photonum }张)</li>
	          </ul>
	        </div>
	        <form id="formphoto" action="Zone/photoDetail.action" method="post">
	        <input type="hidden" id="albumid_p" name="albumid_p" value="${album.albumid }"/>
	        <input type="hidden" id="gotoPagephoto" name="gotoPagephoto" value=""/>
			  <input type="hidden" name="TTid" value="${TTid }"/>
	        
	        <div class="poth_3">
	          <ul>
	          	<s:iterator value="result.content" status="st" id = "photo">
	            <li>
	              <p class="pp"><a href="javascript:photodetail(${(result.page.currentPage-1)*20+st.count });" ><img src="${photopath }" width="250" height="230" /></a></p>
	              <p class="zz">${photoname }</p>
	            </li>
	            </s:iterator>
	          </ul>
	        </div>
	        </form>
	        
			<form id="formpage" action="Zone/photoOfAlbum.action"  method="post">
			  <input type="hidden" id="albumid" name="albumid" value="${album.albumid }"/>
			  <input type="hidden" name="TTid" value="${TTid }"/>
			  <t:tpage pageDiv="page" page="${result.page}" goImg="img/learning_img/gog.gif" formId="formpage"></t:tpage>
		    </form>
		      
	        
	        <form id="form1" action="" method="post">
	        
	        <div class="poth_1 mari">
	          <ul>
	            <li class="tm" id="commnum"><b>相册评论(共${fn:length(albumComList)}条)</b><a name="Aname" id="Aid"></a></li>
	          </ul>
	        </div>
	        <div class="poth_4">
	        
	        <!-- 处理留言数据 -->
	        <s:iterator value="albumComList" status="st" id = "comm">
	        
		        <!-- 如果是留言 -->
		        <s:if test="#comm.parent == null">
		        	<!-- 如果不是第一条留言,给上一个留言加上结束的div -->
			        <s:if test="#st.index != 0">
			          </div>
			          </div>
			        </s:if>
			        
			        <!-- 显示留言信息和回复框 -->
		            <div class="plun">
		            <div class="cee"><a href="#"><img src="${comm.member.headpath }" onerror="this.src='img/user_img/imgmo.gif'" /></a></div>
		            <div class="cenn">
		            <table width="384" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td><a href="#">${comm.member.username }</a> <span>${comm.commenteddate }</span></td>
	                  </tr>
	                  <tr>
	                    <td><p>${comm.commentedcontent }</p>
	                      <a href="javascript:;" onclick="hffunction('hftable${st.index }');">回复</a></td>
	                  </tr>
	                </table>
	                <table id="hftable${st.index }" width="384" border="0" cellspacing="0" cellpadding="0" style="display:none">
			            <tr>
			              <td>
			              <textarea id="recomment${st.index}" name="comcontent" cols="" rows="" class="tex"></textarea>
			              </td>
			            </tr>
			            <tr>
			              <td><input name="" type="button" onclick="hfsubmit('recomment${st.index}','${comm.commentedid }');" value="确定" class="quedd"/>
			                <a href="#" class="qqx">取消</a></td>
			            </tr>
		          	</table>
		        </s:if>
		        
		        <!-- 如果是回复 -->
		        <s:else>
		        <!-- 显示回复 -->
		          <ul class="hui">
	                <li class="tou"><a href="#"><img src="${comm.member.headpath }" onerror="this.src='img/user_img/imgmo.gif'" /></a></li>
	                <li>
	                  <dl>
	                    <dt><a href="#">${comm.member.username }</a> <span>${comm.commenteddate }</span></dt>
	                    <dd>${comm.commentedcontent }</dd>
	                  </dl>
	                </li>
	              </ul>
		        </s:else>
		        
	        </s:iterator>
	        
	        
             
             <s:if test="albumComList.size() > 0">
	          </div>
	          </div>
             </s:if>
	          <!-- 被留言的相册 -->
	          <input type="hidden" value="${album.albumid }" name="albumid" id="albumid"/>
	          <!-- 被留言的留言 -->
	          <input type="hidden" value="" name="comid" id="comid"/>
	        </form>
	        
	          <div class="plun">
	            <div class="cee"><a href="#"><img src="${sessionScope.loginMemberHeadpath }" onerror="this.src='img/user_img/imgmo.gif'"/></a></div>
	            <div class="cenn">
	              <table width="384" border="0" cellspacing="0" cellpadding="0">
	                <tr>
	                  <td>
	                  	<textarea id="pcomment" cols="" rows="" class="tex_1">我也来评论，左边的头像是要发表评论的用户头像</textarea>
	                  
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
	                  </td>
	                </tr>
	                <tr>
	                  <td>
	                  <input id="addcomment" type="button"  value="发表评论" class="quedd_1"/></td>
	                </tr>
	              </table>
	            </div>
	          </div>
	          
	        
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
