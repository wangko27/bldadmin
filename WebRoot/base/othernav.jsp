<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>
   
<div class="mainbody">
  <div class="learning_menu">
    <ul>
 	  <s:iterator value="navigationList" status="st" id = "nav">
      <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li> 	  	
 	  </s:iterator>
    </ul>
  </div>
  <div class="commongao"></div>
</div>
