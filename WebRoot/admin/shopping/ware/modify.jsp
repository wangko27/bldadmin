<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改商品</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath %>admin/skin/css/main.css" type="text/css" rel="stylesheet" />
        <script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
       	<script type="text/javascript" src="<%=basePath %>admin/interest/js/activitytype.js"></script>
		<script type="text/javascript" src="<%=basePath %>admin/js/checkfile.js"></script>
        <script language="javascript" src="<%=basePath %>admin/shopping/js/ware1.js"></script>
        
	</head>
	<body>
		<div class="maindiv">
			<h1>
				商品频道管理&mdash;&mdash;修改商品
			</h1>
		</div>
		<form action="<%=basePath %>admin/shop/updategoods.action" method="post" enctype="multipart/form-data"
			id="form_gAdd">
			<s:token></s:token>
			<input type="hidden" id="succes" value="${chonggong }">
			<input type="hidden" id="path" value="<%=basePath %>">
			
			<input type="hidden" name="oldSrot" value="${goods.goodesCategory.categoryid }">
			<input type="hidden" name="goods.goodsid" value="${goods.goodsid }">
			<input type="hidden" name="goods.createdate" value="${goods.createdate }">
			<input type="hidden" name="goods.occupiedstock" value="${goods.occupiedstock }">
			<input type="hidden" name="goods.productpoint" value="${goods.productpoint}">
			<input type="hidden" name="goods.commentsnum" value="${goods.commentsnum}">
			<input type="hidden" name="goods.sharenum" value="${goods.sharenum}">
			<input type="hidden" name="goods.collectionnum" value="${goods.collectionnum}">
			<input type="hidden" name="goods.productsales" value="${goods.productsales}">
			<input type="hidden" name="goods.generalscore" value="${goods.generalscore}">
			<input type="hidden" name="goods.attention" value="${goods.attention}">
			
			<table width="98%" border="0" cellpadding="0" cellspacing="1"
				align="center">
				<tr>
					<td height="26" background="skin/images/newlinebg3.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="left" style="text-align: right">商品类型:
								</td>
								<td>
										<select name="gSrot" id="gSrot">
												<option value="${goods.goodesCategory.goodesCategory.categoryid }">${goods.goodesCategory.goodesCategory.categoryname }</option>
										</select>
										<select name="goods.goodesCategory.categoryid" id="gcsrot">
												<option value="${goods.goodesCategory.categoryid }">${goods.goodesCategory.categoryname }</option>
										</select>
                                </td>
								<td colspan="2" style="text-align: left">&nbsp;</td>
								</tr>
							<tr>
								<td width="150" align="left" style="text-align: right">货　　号:
								</td>
								<td>
									<input type="text" name="goods.productsn" value="${goods.productsn }" id="gSn" size="30">
									
								</td>
								<td style="text-align: right">商品名称:</td>
								<td>
										<input name="goods.goodsname" type="text" id="goodsName" value="${goods.goodsname }" size="30">
								</td>
							</tr>
                            <tr>
                                <td width="150" align="left" style="text-align: right">品牌:
                                </td>
                                <td>
                                    <input type="hidden" name="brand.brandid" value="${goods.brand.brandid}"/>
                                    <input type="text" name="brand.brandname" id="goodsBrand" size="30" value="${goods.brand.brandname}">
                                </td>
                                <td style="text-align: right">产地:</td>
                                <td>
                                    <input name="goods.goodsArea" type="text" id="goodsPlace" size="30" value="${goods.goodsArea}">
                                </td>
                            </tr>
                            <tr>
                                <td width="150" align="left" style="text-align: right">条形码:
                                </td>
                                <td>
                                    <input type="text" name="goods.barCode" id="goodsBarCode" size="30" value="${goods.barCode}">
                                </td>

                            </tr>
							<tr>
                                <td align="left" style="text-align: right">商品价格:</td>
                                <td>
                                		<input name="goods.productprice" type="text" value="${goods.productprice}" id="gMp" size="30">
                                </td>
                                <td style="text-align: right">市场价格:</td>
                                <td>
                                		<input name="goods.marketprice" type="text" value="${goods.marketprice }" id="gPd" size="30">
                                </td>
                            </tr>
                            <tr>
                            		<td align="left" style="text-align: right">是否添加重量:</td>
                            		<td>
                            				<input name="isW" type="radio" id="" value="1" ${goods.productweight!=0 ? 'checked':'' }>
                            				是 
                            				<input type="radio" name="isW" id="" value="0" ${goods.productweight==0 ? 'checked':'' }>不是
									</td>
                            		<td style="text-align: right">&nbsp;</td>
                            		<td>&nbsp;</td>
                            </tr>
                            <tr  id="zl" style="display: ${goods.productweight==0 ? 'none':'' }">
                                <td width="150" align="left" style="text-align: right">商品重量:</td>
                                <td><input name="goods.productweight" type="text" value="${goods.productweight }" id="gPw" size="30">
								
								</td>
                                <td style="text-align: right">重量单位:</td>
                                <td>
                                		<select name="goods.weightunit" id="gWu">
                                				<option value="1" ${goods.weightunit eq "1" ? 'selected':''} > 克</option>
                                				<option value="2" ${goods.weightunit eq "2" ? 'selected':''}>千克</option>
                                		</select>
                                </td>
                            </tr>
							<tr>
								<td width="150" align="left" style="text-align: right">商品库存数量:
								</td>
								<td>
									<input type="text" name="goods.stocknum" id="gSk"
										size="30" value="${goods.stocknum }">
								</td>
								<td style="text-align: right">新旧程度:</td>
								<td>
									<select name="goods.condition" id="gOs">
												<option value="全新" ${goods.condition eq "全新" ? 'selected':''}>全新</option>
												<option value="九成新" ${goods.condition eq "九成新" ? 'selected':''}>九成新</option>
												<option value="八成新" ${goods.condition eq "八成新" ? 'selected':''}>八成新</option>
												<option value="修理过" ${goods.condition eq "修理过" ? 'selected':''}>修理过</option>
									</select>
								</td>
							</tr>
                            <tr>
                                <td align="left" valign="top" style="text-align: right">是否为上架:</td>
                                <td>
										<input name="goods.isadded" type="radio" id="gId" value="1" ${goods.isadded eq '1' ? 'checked':'' } >
										是 
										 <input type="radio" name="goods.isadded" id="gId" value="0" ${goods.isadded eq '0' ? 'checked':'' }>否
                                </td>
                                <td style="text-align: right">是否为新品:</td>
                                <td>
                                		<input name="goods.isnew" type="radio" id="gIs" value="1" ${goods.isnew eq '1' ? 'checked':'' }>
										是
										<input name="goods.isnew" type="radio" id="gIs" value="0" ${goods.isnew eq '0' ? 'checked':'' }>
										否 </td>
				                </tr>
	                            <tr>
                            		<td align="left" valign="top" style="text-align: right">是否为精品:</td>
                            		<td>
                            				<input name="goods.isboutique" type="radio" id="gIb" value="1" ${goods.isboutique eq '1' ? 'checked':'' }>
											是
											<input name="goods.isboutique" type="radio" id="gIb" value="0" ${goods.isboutique eq '0' ? 'checked':'' }>
											否 
									</td>
                            		<td style="text-align: right">是否热销:</td>
                            		<td>
                            				<input name="goods.ishot" type="radio" id="radio7" value="1" ${goods.ishot eq '1' ? 'checked':'' }>
											是
											<input name="goods.ishot" type="radio" id="radio8" value="0" ${goods.ishot eq '0' ? 'checked':'' }>
											否 
									</td>
                            		</tr>
                            		<tr>
                            		<td align="left" valign="top" style="text-align: right">页面关键字:</td>
                            		<td>
                            				<label>
                            						<input name="goods.pagekeywords" type="text" id="gPw" size="30" value="${goods.pagekeywords }">
                            				</label>
                            		</td>
                            		</tr>
                                    <tr>
                                        <script type="text/javascript">
                                            function deletePotots(element){
                                                var key = element.parentElement;
                                                key.parentNode.removeChild(key);
                                            }
                                            function addDiv(element){
                                                var div = "<div>" +
                                                        "<input name='pic' type='file' id='gpH1' size='30' >" +
                                                        "<input type='button'  onclick='deletePotots(this)' value='删除'>" +
                                                        "</div>";
                                                $("#addDIV").before(div);
                                            }
                                        </script>
                                        <td style="text-align: right">商品图片路径:</td>
                                        <td>
                                                <c:forEach var="images" items="${list}">
                                                    <div>
                                                        <input name="pic" type="file" id="gpH1" size="30" value="${images}">
                                                        <input type="hidden" name="oldpic" value="${images}">
                                                        <input type="button"  onclick="deletePotots(this)" value="删除">
                                                    </div>
                                                </c:forEach>
                                            <input type="button" value="增加" onclick="addDiv(this)" id="addDIV">
                                        </td>
                                    </tr>
                            		<tr>
                            		<td align="left" valign="top" style="text-align: right">页面描述:</td>
                            		<td colspan="3">
                            				<textarea name="goods.pagedescript" id="gPds" cols="80" rows="5">${goods.pagedescript }</textarea>
                            		</td>
                            		</tr>
                            		<tr>
                            		<td align="left" valign="top" style="text-align: right">商品描述:</td>
                            		<td style="word-break: break-all" colspan="3">
										<textarea cols="80" id="gPdp" name="goods.productdescription"
											rows="10">${goods.productdescription }</textarea>
										<script type="text/javascript">//<![CDATA[
										window.CKEDITOR_BASEPATH='<%=basePath%>/ckeditor/';
										//]]></script>
										<script type="text/javascript"
											src="<%=basePath%>/ckeditor/ckeditor.js?t=B37D54V"></script>
										<script type="text/javascript">//<![CDATA[
										CKEDITOR.replace('goods.productdescription');
										//]]></script>
									</td>
                            		</tr>
                           		 <tr>
                                <td colspan="4" align="center">
                                    <input type="button" id="tjBut" value="保存" class="sst">
                                    <input type="reset" name="czBut" value="重置" class="sst_1">
                                </td>
                            </tr>
						</table>
					</td>
				</tr>
			</table>
	</form>
		</body>
</html>
