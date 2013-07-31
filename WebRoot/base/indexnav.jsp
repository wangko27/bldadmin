<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri= "/struts-tags" %>

<!-- admin -->
<div class="mainbody">
  <div class="menu">
    <ul class="ul1">
 	  <s:iterator value="navigationList" status="st" id = "nav">
 	  	<s:if test="#nav.navigation.navigationname == '学习'">
     	  <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li>
 	  	</s:if>
      </s:iterator>
    </ul>
    <ul class="ul2">
      <s:iterator value="navigationList" status="st" id = "nav">
 	  	<s:if test="#nav.navigation.navigationname == '兴趣'">
     	  <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li>
 	  	</s:if>
      </s:iterator>
    </ul>
    <ul class="ul5">
      <s:iterator value="navigationList" status="st" id = "nav">
 	  	<s:if test="#nav.navigation.navigationname == '资讯'">
     	  <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li>
 	  	</s:if>
      </s:iterator>
    </ul>
    <ul class="ul3">
      <s:iterator value="navigationList" status="st" id = "nav">
 	  	<s:if test="#nav.navigation.navigationname == '商城'">
     	  <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li>
 	  	</s:if>
      </s:iterator>
    </ul>
    <ul class="ul4">
      <s:iterator value="navigationList" status="st" id = "nav">
 	  	<s:if test="#nav.navigation.navigationname == '空间'">
     	  <li><a href="${ nav.navigation.navigationurl}">${navigationname }</a></li>
 	  	</s:if>
      </s:iterator>
    </ul>
  </div>
</div>
