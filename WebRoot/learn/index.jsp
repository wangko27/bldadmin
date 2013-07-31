<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>学习频道首页</title>

		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/learning.css" rel="stylesheet" type="text/css" />
		<link href="css/learning_common.css" rel="stylesheet" type="text/css" />
		<link href="css/bb.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script language="javascript" src="<%=basePath%>js/ad.js"></script>
		<script type="text/javascript" src="learn/js/scroll.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js" defer="defer"></script>
		<script type="text/javascript">
			//设置学校风采选项
			function showschooltab(index){
				$(".xuedao li").each(function(i){
					if(index==i){
						$(this).find("a").addClass("daia");
						$("#li_school"+i).show();
						$("#div_school"+i).show();
					}else{
						$(this).find("a").removeClass("daia");
						$("#li_school"+i).hide();
						$("#div_school"+i).hide();
					}
				});
				return false;
			}
			
			$(document).ready(function(){
				$("#prev_p").click(function(){
					myscroll('left');
				});
				$("#next_p").click(function(){
					myscroll('right');
				});
			})
			
		</script>
	</head>

	<body>

		<jsp:include page="/learn/top.jsp"></jsp:include>

		<div class="mainbody">
			<div class="slide_1">
				<div id="player">
					<ul class="Limg">
						<li>
							<a href="#" onclick="return false" target="_blank"><img
									name="advertisement" title="learning-index-a1" src=""
									width="693" height="160" />
								<p>
									宣传新专辑与徐静蕾合作很紧张
								</p> </a>
						</li>
						<li>
							<a href="#" onclick="return false" target="_blank"><img
									name="advertisement" title="learning-index-a2" src=""
									width="693" height="160" />
								<p>
									尚雯婕为演唱会携天价古董拍海报
								</p> </a>
						</li>
						<li>
							<a href="#" onclick="return false" target="_blank"><img
									name="advertisement" title="learning-index-a3" src=""
									width="693" height="160" />
								<p>
									爸妈齐助阵周杰伦2010年新专辑MV
								</p> </a>
						</li>
						<li>
							<a href="#" onclick="return false" target="_blank"><img
									name="advertisement" title="learning-index-a4" src=""
									width="693" height="160" />
								<p>
									阿朵唱功遭质疑撩裙露臀卖肉博眼球
								</p> </a>
						</li>
					</ul>
					<cite class="Nubbt"><span class="on">1</span><span>2</span><span>3</span><span>4</span>
					</cite>
				</div>
				<script language="javascript" src="<%=basePath%>js/bb.js"></script>
			</div>
			<div class="login_1">
				<jsp:include page="/base/logging_status.jsp?pathitem=learning_img"></jsp:include>
			</div>
			<input type="hidden" id="path" value="<%=basePath%>" />
			
			<div class="mainbody">
				<div class="adayke">
					<div class="toulan">
						<input name="oneTime" id="oneTime" type="hidden"/>
						<span onClick="WdatePicker({el:'oneTime',onpicked:function(dp){window.open('learn/oneday_showOneDayOneText.action?liindex=1&oneTime='+dp.cal.getDateStr())}})" > <s:date name="#request.nowdate" format="MM月dd日" />
						</span>
					</div>
					<div class="adaynei">
						<div class="qieh">
							<ul>
								<s:action name="public!getGradeCodeAll" executeResult="false"></s:action>
								<s:iterator value="#request.list_gradeCode" id="g" status="s">

									<c:choose>
										<c:when
											test="${param.gradecode==g.gradecode || gradecode==g.gradecode}">
											<li>
												<a
													href="learn/xx_index.action?liindex=0&gradecode=${g.gradecode}"
													class="ggg">${g.gradename }</a>
											</li>
										</c:when>
										<c:otherwise>
											<li>
												<a
													href="learn/xx_index.action?liindex=0&gradecode=${g.gradecode}">${g.gradename
													}</a>
											</li>
										</c:otherwise>
									</c:choose>

								</s:iterator>
							</ul>
						</div>
						<div class="mainnei" style="height: 260px">
							<s:iterator value="#request.list_oneday_new" id="oneday_new"
								status="s">
								<ul>
									<li class="img1">
										<a
											href="learn/oneday_showOneDayInfo.action?readId=${oneday_new.readsrcid }&liindex=1"
											target="_blank"><img src="${oneday_new.photopath }"
												width="151" height="101" /> </a>
									</li>
									<li>
										<s:if test="#s.first">
											<h1>
												<span>${oneday_new.subjectCode.subjectname }课</span>
												<a
													href="learn/oneday_showOneDayInfo.action?readId=${oneday_new.readsrcid }&liindex=1"
													target="_blank">${oneday_new.readsrctile }</a>
											</h1>
										</s:if>
										<s:else>
											<h2>
												<span>${oneday_new.subjectCode.subjectname }课</span>
												<a
													href="learn/oneday_showOneDayInfo.action?readId=${oneday_new.readsrcid }&liindex=1"
													target="_blank">${oneday_new.readsrctile }</a>
											</h2>
										</s:else>

										<p>
											${oneday_new.contentintro }...
										</p>
									</li>
									<li class="xuean">
										<a
											href="learn/oneday_showOneDayInfo.action?readId=${oneday_new.readsrcid }&liindex=1"
											target="_blank"><img src="img/learning_img/xuebj.gif" />
										</a>
									</li>
								</ul>
							</s:iterator>
							<s:if test="#request.list_oneday_new.size==0">
							暂无课程
						</s:if>
						</div>
					</div>
				</div>
				<div class="pin">
					<div class="toulan_1"></div>
					<div class="bainei">
						<ul>
							<s:iterator value="#request.list_pxld_recommend"
								id="pxld_recommend">
								<li>
									<a
										href="learn/PerusalArticle!getArticleById.action?liindex=2&id=${pxld_recommend.articlesrcid }"
										target="_blank" title="${pxld_recommend.articletitle }">·${fn:substring(pxld_recommend.articletitle,0,15)
										}...</a>
								</li>
							</s:iterator>
						</ul>
					</div>
				</div>
				<div class="banner_1">
					<a href="#" onclick="return false"><img name="advertisement"
							title="learning-index-b" src="" /> </a>
				</div>
			</div>
			<div class="mainbody">
				<div class="bolan">
					<div class="bla_1">
						<p>
							<s:action name="public!getSubjectCodeAll" executeResult="false"></s:action>
							<s:iterator value="#request.list_subjictCode" id="sub" status="s">
								<a
									href="learn/readbook!list.action?subjectcode=${sub.subjectcode }&subjectname=${sub.subjectname }&liindex=5">${sub.subjectname
									}</a>
							</s:iterator>
						</p>
						<p class="more">
							<a href="learn/readbook!list.action?liindex=5"><img
									src="img/home_img/more.gif" /> </a>
						</p>
					</div>
					<div class="bla_2">
						<ul class="anniu">
							<li id="prev_p" title="上一张">
								<a href="#" onclick="javascript:return false;"><img
										src="img/learning_img/san.gif" /> </a>
							</li>
						</ul>
						<div id="pictures">
							<ul class="tunei" id="list"
								style="height: 165px; overflow: hidden; text-overflow: ellipsis;">
								<s:iterator value="#request.list_book_recommend" id="recommend">
									<li>
										<p>
											<a
												href="learn/readbook!view.action?readsrcid=${recommend.readsrcid }&liindex=5"><img
													src="${recommend.photopath }" width="93" height="115"
													alt="${recommend.readsrctile }" /> </a>
										</p>
										<p>
											<a
												href="learn/readbook!view.action?readsrcid=${recommend.readsrcid }&liindex=5"
												target="_blank" title="${recommend.readsrctile }">${fn:substring(recommend.readsrctile,0,10)
												}</a>
										</p>
										<p>
											<span><a
												href="learn/readbook!list.action?liindex=5&gradecode=${recommend.gradeCode.gradecode }&gradename=${recommend.gradeCode.gradename }">[${recommend.gradeCode.gradename
													}]</a> </span>
										</p>
									</li>
								</s:iterator>
							</ul>
						</div>
						<ul class="anniu">
							<li id="next_p" title="下一张">
								<a href="#" onclick="javascript:return false;"><img
										src="img/learning_img/san_1.gif" /> </a>
							</li>
						</ul>
					</div>
					<div class="bla_3">
						<form action="learn/readbook!list.action" name="form_readbook"
							id="form_readbook" method="post">
							<input type="hidden" name="liindex" id="liindex" value="5" />
							<input type="hidden" name="gradename" id="gradename" value="全部" />
							<input type="hidden" name="subjectname" id="subjectname"
								value="全部" />
							<input type="hidden" name="srctypename" id="srctypename"
								value="全部" />
							<span>资源搜索： <select name="gradecode" id="gradecode"
									onchange="javascript:$('#gradename').val($('#gradecode option:selected').text())">
									<option value="">
										年级
									</option>
									<s:iterator value="#request.list_gradeCode" id="g" status="s">
										<option value="${g.gradecode }">
											${g.gradename }
										</option>
									</s:iterator>
								</select> &nbsp; <select name="subjectcode" id="subjectcode"
									onchange="javascript:$('#subjectname').val($('#subjectcode option:selected').text())">
									<option value="">
										科目
									</option>
									<s:iterator value="#request.list_subjictCode" id="sub"
										status="s">
										<option value="${sub.subjectcode}">
											${sub.subjectname }
										</option>
									</s:iterator>
								</select> &nbsp; <select name="srctypeid" id="srctypeid"
									onchange="javascript:$('#srctypename').val($('#srctypeid option:selected').text())">
									<option value="">
										类别
									</option>

									<s:action name="public!getReadsrctypeAllByBook"
										executeResult="false"></s:action>
									<s:iterator value="#request.list_readType" id="r">
										<option value="${r.srctypeid}">
											${r.srctype }
										</option>
									</s:iterator>
								</select> </span>
							<a href="#"
								onclick="javascript:form_readbook.submit();return false;"><img
									src="img/learning_img/seach_bj.gif" /> </a>
						</form>
					</div>
					<div class="bla_4">
						<div class="xxue">
							<div class="sma">
								小学
							</div>
							<div class="lbi">
								<ul>
									<s:iterator value="#request.list_readbook_xx" id="xx">
										<li>
											<span>[<a
												href="learn/readbook!list.action?liindex=5&gradecode=${xx.gradeCode.gradecode }&gradename=${xx.gradeCode.gradename }">${xx.gradeCode.gradename
													}</a>]</span>
											<a
												href="learn/readbook!view.action?readsrcid=${xx.readsrcid }&liindex=5"
												target="_blank" title="${xx.readsrctile }">${fn:substring(xx.readsrctile,0,20)
												}</a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
						<div class="xxue">
							<div class="sma">
								初中
							</div>
							<div class="lbi">
								<ul>
									<s:iterator value="#request.list_readbook_zx" id="zx">
										<li>
											<span>[<a
												href="learn/readbook!list.action?liindex=5&gradecode=${zx.gradeCode.gradecode }&gradename=${zx.gradeCode.gradename }">${zx.gradeCode.gradename
													}</a>]</span>
											<a
												href="learn/readbook!view.action?readsrcid=${zx.readsrcid }&liindex=5"
												target="_blank" title="${zx.readsrctile }">${fn:substring(zx.readsrctile,0,20)
												}</a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
						<div class="xxue_1">
							<div class="sma">
								高中
							</div>
							<div class="lbi_1">
								<ul>
									<s:iterator value="#request.list_readbook_gz" id="gz">
										<li>
											<span>[<a
												href="learn/readbook!list.action?liindex=5&gradecode=${gz.gradeCode.gradecode }&gradename=${gz.gradeCode.gradename }">${gz.gradeCode.gradename
													}</a>]</span>
											<a
												href="learn/readbook!view.action?readsrcid=${gz.readsrcid }&liindex=5"
												target="_blank" title="${gz.readsrctile }">${fn:substring(gz.readsrctile,0,20)
												}</a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="mainbody">
				<div class="mischool">
					<div class="bla_1">
						<p>
							&nbsp;
						</p>
						<p class="more">
							<a href="learn/schools_showSchools.action?liindex=4"
								target="_blank"><img src="img/home_img/more.gif" /> </a>
						</p>
					</div>
					<div class="schbig">
						<div class="mmsch">
							<div class="tuqie">
								<ul class="xuedao">
									<s:iterator value="#request.list_school_new"
										id="school_new" status="s">
										<li>
											<s:if test="#s.first">
												<a href="#" onclick="return showschooltab(${s.index })"
													class="daia" title="${school_new.schoolname }">${fn:substring(school_new.schoolname,0,5)
													}</a>
											</s:if>
											<s:else>
												<a href="#" onclick="return showschooltab(${s.index })"
													title="${school_new.schoolname }">${fn:substring(school_new.schoolname,0,5)
													}</a>
											</s:else>
										</li>
									</s:iterator>
								</ul>
								<ul class="tu">
									<s:iterator value="#request.list_school_new"
										id="school_new" status="s">
										<li id="li_school${s.index }"
											<s:if test="#s.first==false">style="display:none"</s:if>>
											<a
												href="learn/teacherbema_showSchool.action?liindex=4&articlesrcId=${school_new.articlesrcid }">
												<img
													src="${school_new.coverpath }" width="104"
													height="124" /> </a>
											<p>
												${school_new.schoolname }
											</p>
										</li>
									</s:iterator>
								</ul>
							</div>
							<div class="ziw">
								<s:iterator value="#request.list_school_new"
									id="school_new" status="s">
									<div id="div_school${s.index }"
										<s:if test="#s.first==false">style="display:none"</s:if>>
										<p>
											<b>${school_new.schoolname }</b>
										</p>
										<p>
											${school_new.articlesrccontent }...
											<a
												href="learn/teacherbema_showSchool.action?liindex=4&articlesrcId=${school_new.articlesrcid }"
												target="_blank">[详情]</a>
										</p>
									</div>
								</s:iterator>
							</div>
						</div>
						<div class="xuezi">
							<div class="tuwen">
								<ul>
									<s:iterator value="#request.list_school_recommend" id="school_recommend">
										<li>
											<a
												href="learn/teacherbema_showSchool.action?liindex=4&articlesrcId=${school_recommend.articlesrcid }"
												target="_blank"><img src="${school_recommend.coverpath }"
													width="104" height="124" /> </a>
											<a
												href="learn/teacherbema_showSchool.action?liindex=4&articlesrcId=${school_recommend.articlesrcid }"
												target="_blank">${school_recommend.schoolname }</a>
										</li>
									</s:iterator>
								</ul>
							</div>
							<div class="mingzi">
								<ul>
									<s:iterator value="#request.list_school_recommend1" id="school_recommend1">
										<li>
											<a
												href="learn/teacherbema_showSchool.action?liindex=4&articlesrcId=${school_recommend1.articlesrcid }"
												target="_blank">·${school_recommend1.schoolname }</a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
					</div>
					<div class="teach">
						<p>
							名师讲坛
						</p>
						<p class="more">
							<a href="learn/teacherbema_showTeachers.action?liindex=3"
								target="_blank"><img src="img/home_img/more.gif" /> </a>
						</p>
					</div>
					<div class="teach_1">
						<div class="teachtu">
							<ul>
								<s:iterator value="#request.list_teacher" id="teacher">
									<li>
										<a
											href="learn/teacherbema_showTeacherinfo.action?liindex=3&teacherId=${teacher.superTeacher.superTeacherID }"
											target="_blank"><img
												src="${teacher.superTeacher.teacherPath}" width="104"
												height="124" /> </a><a
											href="learn/teacherbema_showTeacherinfo.action?liindex=3&teacherId=${teacher.superTeacher.superTeacherID }"
											target="_blank" title="${teacher.articletitle}">${teacher.superTeacher.username}：${fn:substring(teacher.articletitle,0,12)
											}</a>
										<p>
											<img src="img/learning_img/shitu.gif" />
										</p>
									</li>
								</s:iterator>
							</ul>
						</div>
						<div class="teachzi">
							<span>热点人物</span>
							<p>
								<s:iterator value="#request.list_teacher_hot" id="teacher_hot"
									status="s">
									<s:if test="#teacher_hot.peopleNum>=500">
										<b><a
											href="learn/teacherbema_showTeacherinfo.action?liindex=3&teacherId=${teacher_hot.superTeacherID }"
											target="_blank">${teacher_hot.username}</a> </b>
									</s:if>
									<s:else>
										<a
											href="learn/teacherbema_showTeacherinfo.action?liindex=3&teacherId=${teacher_hot.superTeacherID }"
											target="_blank">${teacher_hot.username}</a>
									</s:else>
									<s:if test="#s.last==false">
								 	|&nbsp;
								 </s:if>
								</s:iterator>
							</p>
						</div>
					</div>
				</div>
			</div>



			<jsp:include page="/base/bottom.jsp"></jsp:include>
	</body>
</html>
