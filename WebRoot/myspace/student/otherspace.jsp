<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../comm/common_tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>您好，欢迎来到952116综合信息门户网！-- 个人空间</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link href="<%=basePath%>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/user/zuo.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <jsp:include page="../header.jsp"></jsp:include>
    <div class="mainbody_1">
  <div class="dde">
    <div class="uuop">
      <div class="left">
        <div class="ru1"> <img src="../img/user_img/imgmo.gif" />
          <p><b>欧阳燕个人空间</b><br /><a href="#"><img src="../img/user_img/kkk.gif" width="80" height="24" /></a></p>
        </div>
        <div class="ru2">
          <ul>
            <li><a href="#" class="bj1">博文</a> </li>
          </ul>
          <ul>
            <li><a href="#" class="bj2">相册</a> </li>
          </ul>
          <ul>
            <li><a href="#" class="bj4">留言板</a></li>
          </ul>
          <ul>
            <li><a href="#" class="bj4_1">他的资料</a></li>
          </ul>
        </div>
      </div>
      <div class="right">
        <div class="rzhong">
          <div class="xxqing">
            <ul>
              <li class="xq"><b>他的心情：</b></li>
              <li class="xqc">呵呵，今天天气真好<img src="../img/user_img/bq1.gif" width="15" height="15" /></li>
            </ul>
          </div>
          <div class="xcc">
          	<p class="pcu">他的相册：</p>
            <ul><li><a href="#"><img src="../img/user_img/tu2.gif" width="100" height="68" /></a></li>
            <li><a href="#"><img src="../img/user_img/tu2.gif" width="100" height="68" /></a></li>
            <li><a href="#"><img src="../img/user_img/tu2.gif" width="100" height="68" /></a></li>
            <li><a href="#"><img src="../img/user_img/tu2.gif" width="100" height="68" /></a></li>
            <li><a href="#"><img src="../img/user_img/tu2.gif" width="100" height="68" /></a></li>
            </ul>
            <p class="mmg"><a href="#">查看更多</a></p>
          </div>
          <div class="llyan"><span>给他留言：</span> <a href="#">更多留言</a></div>
          <div class="shukk">
            <ul>
              <li>
                <textarea name="" cols="" rows="">可输入200个字</textarea>
              </li>
              <li class="yutt"><a href="#" class="ty">表情</a> <a href="#" class="ty1">图片</a></li>
              <li class="yutt1"><a href="#"><img src="../img/user_img/fb.gif" /></a></li>
            </ul>
          </div>
          <div class="dtai">
            <ul>
              <li class="bai">他的动态</li>
            </ul>
          </div>
          <div class="dongtai">
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>上传照片到相册：<a href="#">相册名称</a></p>
                <p class="tuzi2"><a href="#"><img src="../img/learning_img/12.jpg" /></a></p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>发表博文：<a href="#">英国癌症少女博客上列遗愿 明星草根均伸出援手</a></p>
                <p class="tuzi2">网友“凯思·埃利奥特”在英国《卫报》网站留言说，她的博客曾经遭到不明真相网友攻击，差点不得不关闭，而派恩的故事告诉大家，“网络世界有时是一个污水坑</p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">欧阳燕</a>发表心情：<span>呵呵天气很热哦</span></p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>上传照片到相册：<a href="#">相册名称</a></p>
                <p class="tuzi3"> <a href="#"><img src="../img/learning_img/tu2.gif" /></a> <span> 打分：<img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing_1.gif" /><img src="../img/common_img/xing_1.gif" /> <b>8分</b> <br />
                  致力于为广大用户提供安全快速的电子支付/网上支付/安全支付/手机支付体验，及转账收款/水电煤缴费/信用卡还款/AA收款等生活 </span> </p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>上传照片到相册：<a href="#">相册名称</a></p>
                <p class="tuzi2"><a href="#"><img src="../img/learning_img/12.jpg" /></a></p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>发表博文：<a href="#">英国癌症少女博客上列遗愿 明星草根均伸出援手</a></p>
                <p class="tuzi2">网友“凯思·埃利奥特”在英国《卫报》网站留言说，她的博客曾经遭到不明真相网友攻击，差点不得不关闭，而派恩的故事告诉大家，“网络世界有时是一个污水坑</p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">欧阳燕</a>发表心情：<span>呵呵天气很热哦</span></p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
            <ul>
              <li class="tuuser"><a href="#"><img src="../img/user_img/imgmo.gif" /></a></li>
              <li class="tuuser1">
                <p class="tuzi1"><a href="#">李震</a>上传照片到相册：<a href="#">相册名称</a></p>
                <p class="tuzi3"> <a href="#"><img src="../img/learning_img/tu2.gif" /></a> <span> 打分：<img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing_1.gif" /><img src="../img/common_img/xing_1.gif" /> <b>8分</b> <br />
                  致力于为广大用户提供安全快速的电子支付/网上支付/安全支付/手机支付体验，及转账收款/水电煤缴费/信用卡还款/AA收款等生活 </span> </p>
                <p class="time">2011-05-18 15:32</p>
              </li>
            </ul>
          </div>
        </div>
        <div class="ryou">
          <div class="huid"><span>最近来访（89）</span></div>
          <div class="pople">
            <ul>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
            </ul>
            <ul>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
              <li>
                <p class="img50"> <a href="#"><img src="../img/user_img/imgmo.gif" /></a></p>
                <p> <a href="#">王海波家长</a></p>
                <p><a href="#"><img src="../img/user_img/shi.gif" /></a>04-27</p>
              </li>
            </ul>
          </div>
          <div class="huid"><span>今日课题</span> <a href="#">更多</a></div>
          <div class="lli">
            <ul>
              <li>[<a href="#" class="lan">语文</a>]&nbsp;<a href="#">云南省玉溪市小学数学毕业考</a></li>
              <li>[<a href="#" class="lan">数学</a>]&nbsp;<a href="#">重庆市万州区小学数学毕业</a></li>
              <li>[<a href="#" class="lan">英语</a>]&nbsp;<a href="#">2007年小学毕业考试数学试</a></li>
            </ul>
          </div>
          <div class="kumu"> <a href="#">语文</a> | <a href="#">数学</a> | <a href="#">物理</a> | <a href="#">化学</a> | <a href="#">生物</a> | <a href="#">历史</a> | <a href="#">地理</a> | <a href="#">政治</a> </div>
          <div class="banner1"><a href="#"><img src="../img/user_img/banner.gif" /></a></div>
          <div class="huid"><span>博览群书</span> <a href="#">更多</a></div>
          <div class="tu_zi">
            <ul>
              <li class="img_1"><a href="#"><img src="../img/home_img/tu4.jpg" /></a></li>
              <li class="yu"><span><a href="#">[语文]</a></span> <a href="#">小学四年级语文经典课外阅练习试</a></li>
              <li><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing_1.gif" /><img src="../img/common_img/xing_1.gif" /> <span>8.5分</span></li>
              <li class="xia"><a href="#"><img src="../img/common_img/xiazai.gif" /></a></li>
            </ul>
            <ul>
              <li class="img_1"><a href="#"><img src="../img/home_img/tu4.jpg" /></a></li>
              <li class="yu"><span><a href="#">[语文]</a></span> <a href="#">小学四年级语文经典课外阅读练</a></li>
              <li><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing.gif" /><img src="../img/common_img/xing_1.gif" /><img src="../img/common_img/xing_1.gif" /> <span>8.5分</span></li>
              <li class="xia"><a href="#"><img src="../img/common_img/xiazai.gif" /></a></li>
            </ul>
            <ul class="zi">
              <li> <a href="#">中国打破了世界软件巨头规则</a></li>
              <li><a href="#">口语：会说中文就能说英语！</a></li>
              <li><a href="#">农场摘菜不如在线学外语好玩</a></li>
            </ul>
          </div>
          <div class="huid"><span>生活百科</span> <a href="#">更多</a></div>
          <div class="lli">
            <ul>
              <li>[<a href="#" class="lan">成长教育</a>]&nbsp;<a href="#">逮捕高干震动中南海 </a></li>
              <li>[<a href="#" class="lan">好好生活</a>]&nbsp;<a href="#">重庆市万州区小学数毕业</a></li>
              <li>[<a href="#" class="lan">心理健康</a>]&nbsp;<a href="#">2007年小学毕业考数学试</a></li>
              <li>[<a href="#" class="lan">营养保健</a>]&nbsp;<a href="#">2007年小学毕业试数学试</a></li>
              <li>[<a href="#" class="lan">心理健康</a>]&nbsp;<a href="#">2007年小学毕业考数学试</a></li>
            </ul>
          </div>
          <div class="banner1"><a href="#"><img src="../img/user_img/banner.gif" /></a></div>
        </div>
      </div>
    </div>
  </div>
</div>
    <jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>
