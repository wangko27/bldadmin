<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网!用户中心-资源评分</title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="css/user/download.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
	//<![CDATA[
	window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
	//]]>
	</script>
	<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-plugin/validate/jquery.validate.js"></script>
	<script type="text/javascript">
    
	$().ready(function() {
		
		//验证
		$("#form1").validate({
			//验证规则
			rules:{
				'readSrcComm.scoring':"required"
			},
			messages:{
				'readSrcComm.scoring':"请为资源评分!"
			},
			/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
	        showErrors: function(errorMap, errorList) {   
	            var msg = "";   
	            $.each( errorList, function(i,v){   
	              msg += (v.message+"\r\n");   
	            });   
	            if(msg!="") alert(msg);   
	        },   
	        /* 失去焦点时不验证 */    
	        onfocusout: false  
		});
		
	});
	
	function subform(){
		//取得ckedit中的内容
	    var oEditor = CKEDITOR.instances.pcomment;
	    var comdata = oEditor.getData();
	    
		if(comdata == ''){
			alert("请输入评论内容!");
			return ;
		}
		else{
			$("#form1").submit();
		}
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
	        
	        <form action="myspace/comm/ratingAdd.action" id="form1" method="post">
	        <input type="hidden" value="${readSrcDownRec.readSrc.readsrcid }" name = "readSrc.readsrcid" />
		    <input type="hidden" value="${readSrcDownRec.downrecid }" name = "readSrcDownRec.downrecid" />
		      
		        
		        
		        <div class="bobti">百宝箱</div>
		        <div class="dtai">
		          <ul>
		            <li class="bai">下载管理</li>
		            <li><a href="myspace/comm/uploadSrcList.action">资源管理</a></li>
		            <li><a href="myspace/comm/mquestionList.action">问题管理</a></li>
		            <li><a href="myspace/comm/worksList.action">作品管理</a></li>
            		<li><a href="myspace/comm/carItemList.action">购物车</a></li>
            	<!-- 
             	<li><a href="myspace/comm/orderList.action">我的订单</a></li>
             	 -->
	            	<li><a href="myspace/comm/receiverList.action">地址管理</a></li>
		            <li><a href="myspace/comm/listfavca.action">收藏夹</a></li>
		          </ul>
		        </div>
			        
		        <div class="yutr">
		          <ul class="nmmid_1">
		            <li class="rar">
		              <p> <a href="learn/readbook!view.action?readsrcid=${readSrcDownRec.readSrc.readsrcid }&liindex=5" target="_blank">${readSrcDownRec.readSrc.readsrctile }</a> <span>需${readSrcDownRec.readSrc.downpoint }积分</span></p>
		              <p><span>${readSrcDownRec.readSrc.readsrcsize }KB</span></p>
		            </li>
		            <li class="an">
		              <p><span>${readSrcDownRec.downloaddate }</span></p>
		            </li>
		          </ul>
		        </div>
		        <div class="yutr_1">我来打分：</div>
		        <div class="yutr_2">
		          <ul>
		            <li>
		              <input name="readSrcComm.scoring" type="radio" value="2" />
		            </li>
		            <li class="fen">2分</li>
		            <li class="xing"><img src="img/common_img/xing.gif" width="12" height="12" />
		            <li class="se">太差了，根本没用处</li>
		          </ul>
		          <ul>
		            <li>
		              <input name="readSrcComm.scoring" type="radio" value="4" />
		            </li>
		            <li class="fen">4分</li>
		            <li class="xing"><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" />
		            <li class="se">一般般，还可以！</li>
		          </ul>
		           <ul>
		            <li>
		              <input name="readSrcComm.scoring" type="radio" value="6" />
		            </li>
		            <li class="fen">6分</li>
		            <li class="xing"><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" />
		            <li class="se">还不错哦，有些帮助！</li>
		          </ul>
		           <ul>
		            <li>
		              <input name="readSrcComm.scoring" type="radio" value="8" />
		            </li>
		            <li class="fen">8分</li>
		            <li class="xing"><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" />
		            <li class="se">值得下载，帮助很大！</li>
		          </ul>
		           <ul>
		            <li>
		              <input name="readSrcComm.scoring" type="radio" value="10" />
		            </li>
		            <li class="fen">10分</li>
		            <li class="xing"><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" /><img src="img/common_img/xing.gif" width="12" height="12" />
		            <li class="se">哇，资源太棒了，一定要去下载！</li>
		          </ul>
		        </div>
		        <div class="yutr_1">我来评论：<span>请对此资源进行评论，打分才能成功哦！</span></div>
		        <div class="shukk">
		            <ul>
		              <li>
		                <textarea id="pcomment" name="readSrcComm.commentedcontent" cols="" rows=""></textarea>
						<script type="text/javascript">
						//<![CDATA[
						CKEDITOR.replace('pcomment',{
							width:520,
							toolbar :
							[
								['Smiley']
							]
						});
						//]]>
						</script>
		              </li>
		              <li class="yutt1"><a href="javascript:subform();"><img src="img/user_img/fb.gif" /></a></li>
		            </ul>
		        </div>
            </form>
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
