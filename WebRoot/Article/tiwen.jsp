<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri= "/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> 
<%@ taglib prefix="t" uri="/ttxs-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您好，欢迎来到952116综合信息门户网！</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/news/news_common.css" rel="stylesheet" type="text/css" />
<link href="css/news/tiwen.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="template/tiwen.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			//去掉文章的空格 和 换行
			function trim(str){
    			str=str.replace("<br/>","");
               	str=str.replace("<br>","");
 			    str=str.replace("<p>","");
 			    str=str.replace("</p>","");
 			    str= str.replace(/(^\s*)|(\s*$)/g,"");
 			    return str;
 			 }
			//提交之前的判断
			function fromSubmit(){
			    var qu=$("#question").val();
			    var qt=$("#questiontypeid").val();
			    var ex=$("#kd").val();
			   if(ex=="您还可以输入500个字"){
			    	 var ex = CKEDITOR.instances.kd.getData();
			    }
 			    ex=trim(ex);
			    if(qu==""){
			    	if(ex==""||ex=="您还可以输入500个字"){
			    		$("#showquestionmessge").html("<font color=red>标题不能为空</font>");
			    		$("#showexplanationmassage").html("<font color=red>内容不能为空</font>");
			    		return false;
			    	}
			    	else{
			    		$("#showquestionmessge").html("<font color=red>标题不能为空</font>");
			    		$("#showexplanationmassage").html("");
			    		return false;
			    	}
			    }else{
			    	
			    	if(ex==""||ex=="您还可以输入500个字"){
			    		$("#showexplanationmassage").html("<font color=red>内容不能为空</font>");
			    		$("#showquestionmessge").html("");
			    		return false;
			    	}
			    	else{
			    		$("#Questionadd").submit();	
			    		return false;
			    	}
			    }
			    
			}
		</script>
		<script type="text/javascript">
		//失去焦点是的判断
			function checkquetion(){
				var qu=$("#question").val();
				if(qu==""){
					$("#showquestionmessge").html("<font color=red>标题不能为空</font>");
				}
				else{
					$("#showquestionmessge").html("");
				}
			}
			function checkexplanation(){
				var ex=$("#kd").val();
				if(ex==""||ex=="您还可以输入500个字"){
					$("#showexplanationmassage").html("<font color=red>内容不能为空</font>");
				}
				else{
					$("#showexplanationmassage").html("");
				}
			}
			function showxplanationull(){
				var value=$("#kd").val();
				if(value=="您还可以输入500个字"){
					$(".shyy_1").html("<textarea cols=\"\" rows=\"\" class=\"tex1\" name=\"explanation\" id=\"kd\" onblur=\"checkexplanation()\" onfocus=\"showxplanationull()\"></textarea>");
				}
			}
		</script>	
</head>
<body>
	<jsp:include page="news_top.jsp"></jsp:include>
<div class="mainbody">
  <div class="seat"><a href="#">952116综合信息门户网首页</a> > <a href="<%=basePath%>Article/Show_News_Index.action">资讯</a> >博士答疑 <span></span></div>
</div>
<div class="mainbody">
	<div class="tiwen">
    	<div class="titwe"><img src="img/news_img/tiwen.gif" /></div>
    	
        <div class="ggtt">
        <form action="<%=basePath %>Article/QuestionAdd.action" method="get" name="Questionadd" id="Questionadd"  enctype="multipart/form-data"">
       	 <s:token></s:token>
        	<ul>       	
            	<li><span>请选择分类：</span>  
            	<s:iterator value="questionTypeList" id="TProw" status="st">
            	<s:if test="#st.index==0">
            		<input name="qt.questionType.questiontypeid" type="radio" value="${TProw.questiontypeid}" id="questiontypeid" checked />${TProw.questiontypename }
            	</s:if>
            	<s:else>
            		<input name="qt.questionType.questiontypeid" type="radio" value="${TProw.questiontypeid}" id="questiontypeid"/>${TProw.questiontypename }
            	</s:else>
              	</s:iterator></li>
                <li><span>积分奖励&nbsp;&nbsp;&nbsp;：</span>
                <select name="qt.questionpoint" id="questionpoin">      
                <option  value="<%=new Long(2) %>" selected >2分</option>
                <option  value="<%=new Long(3) %>" >3分</option>
                <option  value="<%=new Long(4) %>" >4分</option>
                <option  value="<%=new Long(5) %>" >5分</option>
                <option  value="<%=new Long(6) %>" >6分</option>
                <option  value="<%=new Long(7) %>" >7分</option>
                <option  value="<%=new Long(8) %>" >8分</option>
                <option  value="<%=new Long(9) %>" >9分</option>
                <option  value="<%=new Long(10) %>" >10分</option>
                <option  value="<%=new Long(11) %>" >11分</option>
                <option  value="<%=new Long(12) %>" >12分</option>
                <option  value="<%=new Long(13) %>" >13分</option>
                <option  value="<%=new Long(14) %>" >14分</option>
                <option  value="<%=new Long(15) %>" >15分</option>
                </select>
                </li>
                  <li><span id="showquestionmessge"></span></li>
                <li><span>标题：</span><textarea cols="" rows="" class="tex1" name="qt.question" id="question" onblur="checkquetion()" ></textarea></li>
                    <li><span id="showexplanationmassage"></span></li>
                <li>
                	<span>内容：</span>
                    <p class="uut">
                         <span class="shyy_1">
                         <textarea cols="" rows="" class="tex1" name="qt.explanation" id="kd" onblur="checkexplanation()" onfocus="showxplanationull()">您还可以输入500个字</textarea>
                            <script type="text/javascript">//<![CDATA[
									window.CKEDITOR_BASEPATH='<%=basePath%>ckeditor/';
									//]]></script>
									<script type="text/javascript"
										src="<%=basePath%>ckeditor/ckeditor.js?t=B37D54V"></script>
									<script type="text/javascript">//<![CDATA[
									CKEDITOR.replace('qt.explanation',{
										toolbar :
										[
											['Smiley']
										]
									});
									//]]></script>
                         </span>
                    </p>
                </li>
                <li><span class="kko">您想提交问题，但没登录？请点击<a href="#">登录</a>！没账号？<a href="#">立即注册</a>！</span><a href="#" onclick="return fromSubmit()"><img src="img/news_img/tijiao.gif"/></a></li>
                <li class="yyu">
                	<b>积分奖励：</b><br />
					积分的奖励可激励更多的朋友来为你解答，您可给予问题的最佳答案积分奖励。
				 </li>
            </ul> 
          </form>
          			<jsp:include page="/comm/message.jsp"></jsp:include>
        </div> 
    </div>
</div>
	<jsp:include page="/base/bottom.jsp"></jsp:include>
</body>
</html>